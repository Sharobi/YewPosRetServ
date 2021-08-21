package com.sharobi.pharmacy.sales.webservice.impl;

import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.hibernate.Session;
import org.hibernate.internal.SessionFactoryImpl;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPageMar;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.sharobi.pharmacy.common.CommonResultSetMapper;
import com.sharobi.pharmacy.common.PersistenceListener;
import com.sharobi.pharmacy.common.ReturnConstant;
import com.sharobi.pharmacy.common.model.EsiCodeMaster;
import com.sharobi.pharmacy.common.model.ResponseObj;
import com.sharobi.pharmacy.common.model.TypeMaster;
import com.sharobi.pharmacy.commonutil.DateUtil;
import com.sharobi.pharmacy.exceptions.DAOException;
import com.sharobi.pharmacy.inventory.model.CustomerMaster;
import com.sharobi.pharmacy.inventory.model.CustomerType;
import com.sharobi.pharmacy.procurement.model.PurchaseOrderDetailsDTO;
import com.sharobi.pharmacy.sales.model.CardPaymentStatus;
import com.sharobi.pharmacy.sales.model.CustPaymentDetailsAllDTO;
import com.sharobi.pharmacy.sales.model.CustPaymentDetailsByIdDTO;
import com.sharobi.pharmacy.sales.model.CustomerInfoDTO;
import com.sharobi.pharmacy.sales.model.CustomerPayment;
import com.sharobi.pharmacy.sales.model.PaymentMode;
import com.sharobi.pharmacy.sales.model.SaleDetailsAllDTO;
import com.sharobi.pharmacy.sales.model.SaleDetailsDTO;
import com.sharobi.pharmacy.sales.model.SaleDetailsForReturnDTO;
import com.sharobi.pharmacy.sales.model.SaleHeaderDTO;
import com.sharobi.pharmacy.sales.model.SaleItemDetailsDTO;
import com.sharobi.pharmacy.sales.model.SaleManTour;
import com.sharobi.pharmacy.sales.model.SaleManTourDetails;
import com.sharobi.pharmacy.sales.model.SaleManTourDetailsDTO;
import com.sharobi.pharmacy.sales.model.SaleOrder;
import com.sharobi.pharmacy.sales.model.SaleOrderDTO;
import com.sharobi.pharmacy.sales.model.SaleOrderDetailsDTO;
import com.sharobi.pharmacy.sales.model.SaleOrderHeaderDTO;
import com.sharobi.pharmacy.sales.model.SaleReturn;
import com.sharobi.pharmacy.sales.model.SaleReturnDTO;
import com.sharobi.pharmacy.sales.model.SaleReturnDetailsDTO;
import com.sharobi.pharmacy.sales.model.SaleReturnDetailsSerialMapper;
import com.sharobi.pharmacy.sales.model.SaleTourPlan;
import com.sharobi.pharmacy.sales.model.SaleTourPlanDTO;
import com.sharobi.pharmacy.sales.model.SaleTourPlanDetailsDTO;
import com.sharobi.pharmacy.sales.model.Sales;
import com.sharobi.pharmacy.sales.model.TaxDetailsSaleBillDTO;
import com.sharobi.pharmacy.sales.service.SalesService;
import com.sharobi.pharmacy.sales.webservice.SalesWS;
import com.sharobi.pharmacy.store.dao.StoreDAO;
import com.sharobi.pharmacy.store.dao.impl.StoreDAOImpl;
import com.sharobi.pharmacy.store.model.StoreMaster;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.export.ooxml.JRDocxExporter;
import net.sf.jasperreports.engine.export.ooxml.JRDocxExporterParameter;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimpleXlsxReportConfiguration;

/**
 * rajarshi
 */
@Path(value = "/sales")
public class SalesWSImpl implements SalesWS {

	private SalesService salesService = new SalesService();

	public SalesWSImpl() {

	}

	@Override
	@Path(value = "/getSalesHeader")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String getSalesHeader(CommonResultSetMapper mapper) {
		SaleHeaderDTO saleHeaderDTO = null;

		try {

			saleHeaderDTO = salesService.getSalesHeader(mapper);

		} catch (Exception x) {
			x.printStackTrace();

		}
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		String json = gson.toJson(saleHeaderDTO, SaleHeaderDTO.class);

		return json;
	}

	@Override
	@Path(value = "/getSalesHeaderForBill")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String getSalesHeaderForBill(CommonResultSetMapper mapper) {
		SaleHeaderDTO saleHeaderDTO = null;

		try {

			saleHeaderDTO = salesService.getSalesHeaderForBill(mapper);

		} catch (Exception x) {
			x.printStackTrace();

		}
		Gson gson = new GsonBuilder().serializeNulls().excludeFieldsWithoutExposeAnnotation().create();
		String json = gson.toJson(saleHeaderDTO, SaleHeaderDTO.class);
		//System.out.println("/getSalesHeaderForBill sale header : " + json);
		return json;
	}

	@Path(value = "/postAllSalesInvoice")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String postALLSalesInvoice(Sales sales) {
		String status = "";
		//System.out.println("postALLSalesInvoice sales = " + sales);
		try {
			status = salesService.postALLSalesInvoice(sales);
		} catch (Exception x) {
			x.printStackTrace();
		}
		//System.out.println("status = " + status);
		return "" + status;
	}

	@Path(value = "/postAllReturnSalesInvoice")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String postALLReturnSalesInvoice(SaleReturn salereturn) {
		String status = "";
		try {
			status = salesService.postALLReturnSalesInvoice(salereturn);
		} catch (Exception x) {
			x.printStackTrace();
		}

		return "" + status;
	}

	@Override
	@Path(value = "/getSalesHeaderByInvNo")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String getSalesHeaderByInvNo(CommonResultSetMapper mapper) {
		SaleHeaderDTO saleHeaderDTO = null;

		try {

			saleHeaderDTO = salesService.getSalesHeader(mapper);

		} catch (Exception x) {
			x.printStackTrace();

		}
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		String json = gson.toJson(saleHeaderDTO, SaleHeaderDTO.class);

		return json;
	}

	@Override
	@Path(value = "/getSalesDetailsById")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String getSalesDetailsById(CommonResultSetMapper mapper) {
		List<SaleDetailsDTO> saleDetailsDTOs = null;

		try {

			saleDetailsDTOs = salesService.getSalesDetailsById(mapper);

		} catch (Exception x) {
			x.printStackTrace();

		}
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		java.lang.reflect.Type type = new TypeToken<List<SaleDetailsDTO>>() {
		}.getType();
		String json = gson.toJson(saleDetailsDTOs, type);

		//System.out.println("getSalesDetailsById saleDetailsDTOs = " + json);
		return json;
	}

	@Path(value = "/getSaleItemDetailsByItemId")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String getSaleItemDetailsByItemId(CommonResultSetMapper mapper) {
		List<SaleItemDetailsDTO> saleItemDetailsDTOs = null;

		try {

			saleItemDetailsDTOs = salesService.getSaleItemDetailsByItemId(mapper);

		} catch (Exception x) {
			x.printStackTrace();

		}
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		java.lang.reflect.Type type = new TypeToken<List<SaleItemDetailsDTO>>() {
		}.getType();
		String json = gson.toJson(saleItemDetailsDTOs, type);
		return json;
	}

	@Path(value = "/getTaxDetailsForSaleBill")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String getTaxDetailsForSaleBill(CommonResultSetMapper mapper) {
		List<TaxDetailsSaleBillDTO> taxes = null;

		try {

			taxes = salesService.getTaxDetailsForSaleBill(mapper);

		} catch (Exception x) {
			x.printStackTrace();

		}
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		java.lang.reflect.Type type = new TypeToken<List<TaxDetailsSaleBillDTO>>() {
		}.getType();
		String json = gson.toJson(taxes, type);
		return json;
	}

	@Override
	@Path(value = "/getSalesDetailsByIdForBill")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String getSalesDetailsByIdForBill(CommonResultSetMapper mapper) {
		List<SaleDetailsDTO> saleDetailsDTOs = null;

		try {

			saleDetailsDTOs = salesService.getSalesDetailsByIdForBill(mapper);

		} catch (Exception x) {
			x.printStackTrace();

		}
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		java.lang.reflect.Type type = new TypeToken<List<SaleDetailsDTO>>() {
		}.getType();
		String json = gson.toJson(saleDetailsDTOs, type);
		return json;
	}

	@Override
	@Path(value = "/getSalesDetailsByInvNo")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String getSalesDetailsByInvNo(CommonResultSetMapper mapper) {
		List<SaleDetailsDTO> saleDetailsDTOs = null;

		try {

			saleDetailsDTOs = salesService.getSalesDetailsByInvNo(mapper);

		} catch (Exception x) {
			x.printStackTrace();

		}
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		java.lang.reflect.Type type = new TypeToken<List<SaleDetailsDTO>>() {
		}.getType();
		String json = gson.toJson(saleDetailsDTOs, type);
		return json;
	}

	@Override
	@Path(value = "/getAllSalesReturnDetails")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String getAllSalesReturnDetails(CommonResultSetMapper mapper) {
		List<SaleReturnDTO> saleDetailsDTOs = null;

		try {

			saleDetailsDTOs = salesService.getAllSalesReturnDetails(mapper);

		} catch (Exception x) {
			x.printStackTrace();

		}
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		java.lang.reflect.Type type = new TypeToken<List<SaleReturnDTO>>() {
		}.getType();
		String json = gson.toJson(saleDetailsDTOs, type);
		return json;
	}

	@Override
	@Path(value = "/getSaleReturnHeader")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String getSaleReturnHeader(CommonResultSetMapper mapper) {
		SaleReturnDTO saleDetailsDTOs = null;

		try {

			saleDetailsDTOs = salesService.getSaleReturnHeader(mapper);

		} catch (Exception x) {
			x.printStackTrace();

		}
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		String json = gson.toJson(saleDetailsDTOs, SaleReturnDTO.class);

		return json;
	}

	@Override
	@Path(value = "/getSaleReturnDetails")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String getSaleReturnDetails(CommonResultSetMapper mapper) {
		List<SaleReturnDetailsDTO> saleDetailsDTOs = null;

		try {

			saleDetailsDTOs = salesService.getSaleReturnDetails(mapper);

		} catch (Exception x) {
			x.printStackTrace();

		}
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		java.lang.reflect.Type type = new TypeToken<List<SaleReturnDetailsDTO>>() {
		}.getType();
		String json = gson.toJson(saleDetailsDTOs, type);
		return json;
	}

	@Override
	@Path(value = "/getSaleDetailsForReturnByItem")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String getSaleDetailsForReturnByItem(CommonResultSetMapper mapper) {
		List<SaleDetailsForReturnDTO> saleDetailsDTOs = null;

		try {

			saleDetailsDTOs = salesService.getSaleDetailsForReturnByItem(mapper);

		} catch (Exception x) {
			x.printStackTrace();

		}
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		java.lang.reflect.Type type = new TypeToken<List<SaleDetailsForReturnDTO>>() {
		}.getType();
		String json = gson.toJson(saleDetailsDTOs, type);
		return json;
	}

	@Path(value = "/getSerialSaleReturnStatus")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String getSerialSaleReturnStatus(CommonResultSetMapper mapper) {
		List<SaleReturnDetailsSerialMapper> saleDetailsDTOs = null;

		try {

			saleDetailsDTOs = salesService.getSerialSaleReturnStatus(mapper);

		} catch (Exception x) {
			x.printStackTrace();

		}
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		java.lang.reflect.Type type = new TypeToken<List<SaleReturnDetailsSerialMapper>>() {
		}.getType();
		String json = gson.toJson(saleDetailsDTOs, type);
		return json;
	}

	@Override
	@Path(value = "/getSaleDetailsForReturn")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String getSaleDetailsForReturn(CommonResultSetMapper mapper) {
		List<SaleDetailsForReturnDTO> saleDetailsDTOs = null;

		try {

			saleDetailsDTOs = salesService.getSaleDetailsForReturn(mapper);

		} catch (Exception x) {
			x.printStackTrace();

		}
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		java.lang.reflect.Type type = new TypeToken<List<SaleDetailsForReturnDTO>>() {
		}.getType();
		String json = gson.toJson(saleDetailsDTOs, type);
		//System.out.println("getSaleDetailsForReturn = " + json);
		return json;
	}

	@Override
	@Path(value = "/getAdjSaleReturn")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String getAdjSaleReturn(CommonResultSetMapper mapper) {
		List<SaleReturnDTO> saleReturnAdjDTOs = null;

		try {

			saleReturnAdjDTOs = salesService.getAdjSaleReturn(mapper);

		} catch (Exception x) {
			x.printStackTrace();

		}
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		java.lang.reflect.Type type = new TypeToken<List<SaleReturnDTO>>() {
		}.getType();
		String json = gson.toJson(saleReturnAdjDTOs, type);
		return json;
	}

	@Override
	@Path(value = "/getAdjSaleReturnBySaleId")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String getAdjSaleReturnBySaleId(CommonResultSetMapper mapper) {
		List<SaleReturnDTO> saleReturnAdjDTOs = null;

		try {

			saleReturnAdjDTOs = salesService.getAdjSaleReturnBySaleId(mapper);

		} catch (Exception x) {
			x.printStackTrace();

		}
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		java.lang.reflect.Type type = new TypeToken<List<SaleReturnDTO>>() {
		}.getType();
		String json = gson.toJson(saleReturnAdjDTOs, type);
		return json;
	}

	@Override
	@Path(value = "/getAllSaleDetails")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String getAllSaleDetails(CommonResultSetMapper mapper) {
		List<SaleDetailsAllDTO> details = null;

		try {

			details = salesService.getAllSaleDetails(mapper);

		} catch (Exception x) {
			x.printStackTrace();

		}
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		java.lang.reflect.Type type = new TypeToken<List<SaleDetailsAllDTO>>() {
		}.getType();
		String json = gson.toJson(details, type);
		return json;
	}

	@Override
	@Path(value = "/getLastSaleByCustomer")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String getLastSaleByCustomer(CommonResultSetMapper mapper) {
		List<SaleHeaderDTO> details = null;

		try {

			details = salesService.getLastSaleByCustomer(mapper);

		} catch (Exception x) {
			x.printStackTrace();

		}
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		java.lang.reflect.Type type = new TypeToken<List<SaleHeaderDTO>>() {
		}.getType();
		String json = gson.toJson(details, type);
		return json;
	}

	@Override
	@Path(value = "/getAllCustomerByNameOrPh")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String getAllCustomerByNameOrPh(CommonResultSetMapper mapper) {
		List<CustomerMaster> customer = null;

		try {

			customer = salesService.getAllCustomerByNameOrPh(mapper);

		} catch (Exception x) {
			x.printStackTrace();

		}
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		java.lang.reflect.Type type = new TypeToken<List<CustomerMaster>>() {
		}.getType();
		String json = gson.toJson(customer, type);
		//System.out.println("fetched all customer:"+json);
		return json;
	}

	@Override
	@Path(value = "/getCustomerType")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String getCustomerType(CommonResultSetMapper mapper) {
		List<CustomerType> customer = null;

		try {

			customer = salesService.getCustomerType(mapper);

		} catch (Exception x) {
			x.printStackTrace();

		}
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		java.lang.reflect.Type type = new TypeToken<List<CustomerType>>() {
		}.getType();
		String json = gson.toJson(customer, type);
		return json;
	}

	@Override
	@Path(value = "/createOrUpdateSalesInvoice")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String createOrUpdateSalesInvoice(Sales sales) {
		String status = "";
		//System.out.println("createOrUpdateSalesInvoice controller = " + sales);
		try {
			status = salesService.createOrUpdateSalesInvoice(sales);
		} catch (Exception x) {
			x.printStackTrace();
		}

		return "" + status;
	}

	@Override
	@Path(value = "/createOrUpdateSalesReturn")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String createOrUpdateSalesReturn(SaleReturn sales) {
		String status = "";
		try {
			status = salesService.createOrUpdateSalesReturn(sales);
		} catch (Exception x) {
			x.printStackTrace();
		}

		return "" + status;
	}

	@Override
	@Path(value = "/postSalesInvoice")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String postSalesInvoice(CommonResultSetMapper mapper) {
		String status = "";
		try {
			status = salesService.postSalesInvoice(mapper);
		} catch (Exception x) {
			x.printStackTrace();
		}

		return "" + status;
	}

	@Override
	@Path(value = "/postSalesReturn")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String postSalesReturn(CommonResultSetMapper mapper) {
		String status = "";
		try {
			status = salesService.postSalesReturn(mapper);
		} catch (Exception x) {
			x.printStackTrace();
		}

		return "" + status;
	}

	@Override
	@Path(value = "/incrementPrintCount")
	@GET
	@Consumes("application/json")
	@Produces("application/json")
	public String incrementPrintCount(@QueryParam(value = "id") String id, @QueryParam(value = "flag") String flag) {
		int count = 0;
		try {
			count = salesService.incrementPrintCount(id);
			if (flag.equalsIgnoreCase("r"))
				count = count - 1;
		} catch (Exception x) {
			count = 0;
			x.printStackTrace();
		}

		return "" + count;
	}

	@Override
	@Path(value = "/getSalesOrderDetailsByIdForBill")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String getSalesOrderDetailsByIdForBill(CommonResultSetMapper mapper) {
		List<SaleOrderDetailsDTO> saleorderDetailsDTOs = null;

		try {

			saleorderDetailsDTOs = salesService.getSalesOrderDetailsByIdForBill(mapper);

		} catch (Exception x) {
			x.printStackTrace();

		}
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		java.lang.reflect.Type type = new TypeToken<List<SaleOrderDetailsDTO>>() {
		}.getType();
		String json = gson.toJson(saleorderDetailsDTOs, type);
		//System.out.println("/getSalesOrderDetailsForBill sale detail : " + json);
		return json;
	}

	@Override
	@Path(value = "/getSalesOrderHeaderForBill")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String getSalesOrderHeaderForBill(CommonResultSetMapper mapper) {
		SaleOrderHeaderDTO saleHeaderDTO = null;

		try {

			saleHeaderDTO = salesService.getSalesOrderHeaderForBill(mapper);

		} catch (Exception x) {
			x.printStackTrace();

		}
		Gson gson = new GsonBuilder().serializeNulls().excludeFieldsWithoutExposeAnnotation().create();
		String json = gson.toJson(saleHeaderDTO, SaleOrderHeaderDTO.class);
		//System.out.println("/getSalesOrderHeaderForBill sale header : " + json);
		return json;
	}

	@Path(value = "/getTaxDetailsForSaleOrderBill")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String getTaxDetailsForSaleOrderBill(CommonResultSetMapper mapper) {
		List<TaxDetailsSaleBillDTO> taxes = null;

		try {

			taxes = salesService.getTaxDetailsForSaleOrderBill(mapper);

		} catch (Exception x) {
			x.printStackTrace();

		}
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		java.lang.reflect.Type type = new TypeToken<List<TaxDetailsSaleBillDTO>>() {
		}.getType();
		String json = gson.toJson(taxes, type);
		return json;
	}

	@Path(value = "/printSaleBill")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String printSaleBill(CommonResultSetMapper mapper, @Context HttpServletRequest request,
			@Context HttpServletResponse response) {

		String jrxmlFile = null;
		String docFile = null;
		String modDocFile = null;
		String status = "";
		Connection connection = null;
		EntityManagerFactory entityManagerFactory;
		EntityManager em = null;
		try {
			String printCount = "";
			int printCnt = 0;
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();

			// get store
			StoreDAO dao = new StoreDAOImpl();
			StoreMaster store = dao.getStoreDetails("" + mapper.getStoreId());
			int isXclusive = store.getIsExclusive();
			int isEsi = store.getIsEsi();

			// get connection object from entity manager
			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses.getSessionFactory();

			connection = sessionFactory.getConnectionProvider().getConnection();
			Map<String, Object> parameters = new HashMap<String, Object>();

			try {
				if (mapper.getIsRePrint() == 1) {
					printCount = incrementPrintCount("" + mapper.getSaleId(), "r");

					if (printCount != null) {
						if (printCount.length() > 0 && !printCount.equalsIgnoreCase("")) {
							printCnt = Integer.parseInt(printCount);
						}
					}
				}
			}

			catch (Exception e) {
				// TODO Auto-generated catch block
				printCnt = 1;
				e.printStackTrace();
			}

			parameters.put("W_CompanyID", mapper.getCompanyId());
			parameters.put("W_StoreID", mapper.getStoreId());
			parameters.put("W_SaleID", mapper.getSaleId());
			parameters.put("W_IsReprint", mapper.getIsRePrint());
			parameters.put("W_ReprintCount", printCnt);
			parameters.put("W_Note1", mapper.getNoteLineOne());
			parameters.put("W_Note2", mapper.getNoteLineTwo());

			if (isXclusive == 0) {

				if (isEsi == 0) {
					jrxmlFile = "SaleBillWithExcludingGSTDotMatrixTVS.jrxml";
				} else if (isEsi == 1) {
					jrxmlFile = "SaleBillWithExcludingGSTDotMatrixTVSESI.jrxml";
				}

			} else if (isXclusive == 1) {
				if (isEsi == 0) {
					jrxmlFile = "SaleBillWithGSTDotMatrixTVS.jrxml";
				} else if (isEsi == 1) {
					jrxmlFile = "SaleBillWithGSTDotMatrixTVSESI.jrxml";
				}
			}

			docFile = "printBill.docx";
			modDocFile = "printBillMod.docx";
			JasperDesign jsd = JRXmlLoader.load(request.getRealPath("/") + "/jasper/sales/" + jrxmlFile);
			JasperReport jr = JasperCompileManager.compileReport(jsd);

			JasperPrint jp = JasperFillManager.fillReport(jr, parameters, connection);

			/****************
			 * export jasper to doc
			 */
			String docPath = request.getRealPath("/") + "/jasper/sales/" + docFile;
			String modDocPath = request.getRealPath("/") + "/jasper/sales/" + modDocFile;
			JRDocxExporter exporterDoc = new JRDocxExporter();
			exporterDoc.setParameter(JRExporterParameter.JASPER_PRINT, jp);
			exporterDoc.setParameter(JRDocxExporterParameter.OFFSET_X, 0);
			exporterDoc.setParameter(JRDocxExporterParameter.OFFSET_Y, 0);
			exporterDoc.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, docPath);
			exporterDoc.exportReport();

			File file = null;
			file = new File(docPath);
			FileInputStream fis = new FileInputStream(file.getAbsolutePath());
			XWPFDocument document = new XWPFDocument(fis);

			CTSectPr sectPr = document.getDocument().getBody().addNewSectPr();
			CTPageMar pageMar = sectPr.addNewPgMar();
			pageMar.setLeft(BigInteger.valueOf(200L));
			pageMar.setTop(BigInteger.valueOf(250L));
			pageMar.setRight(BigInteger.valueOf(300L));
			pageMar.setBottom(BigInteger.valueOf(300L));
			FileOutputStream out = new FileOutputStream(new File(modDocPath));
			document.write(out);
			out.close();

			File file1 = new File(modDocPath);
			Desktop.getDesktop().print(file1);

			status = "success";

		} catch (FileNotFoundException e) {
			status = "failure";
			e.printStackTrace();
		} catch (IOException e) {
			status = "failure";
			e.printStackTrace();
		} catch (SQLException e) {
			status = "failure";
			e.printStackTrace();
		} catch (JRException e) {
			status = "failure";
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DAOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if (em != null)
				em.close();
		}

		return status;
	}

	@Path(value = "/printSaleBillWithGst")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String printSaleBillWithGst(CommonResultSetMapper mapper, @Context HttpServletRequest request,
			@Context HttpServletResponse response) {

		String jrxmlFile = null;
		String docFile = null;
		String modDocFile = null;
		String status = "";
		Connection connection = null;
		EntityManagerFactory entityManagerFactory;
		EntityManager em = null;
		try {

			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();

			// get connection object from entity manager
			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses.getSessionFactory();

			connection = sessionFactory.getConnectionProvider().getConnection();
			Map<String, Object> parameters = new HashMap<String, Object>();

			parameters.put("W_CompanyID", mapper.getCompanyId());
			parameters.put("W_StoreID", mapper.getStoreId());
			parameters.put("W_SaleID", mapper.getSaleId());
			parameters.put("W_IsReprint", mapper.getIsRePrint());
			parameters.put("W_ReprintCount", mapper.getPrintCount());
			parameters.put("W_Note1", mapper.getNoteLineOne());
			parameters.put("W_Note2", mapper.getNoteLineTwo());

			jrxmlFile = "SaleBillWithGSTDotMatrixTVS.jrxml";
			docFile = "printBillWithGst.docx";
			modDocFile = "printBillWithGstMod.docx";
			JasperDesign jsd = JRXmlLoader.load(request.getRealPath("/") + "/jasper/sales/" + jrxmlFile);
			JasperReport jr = JasperCompileManager.compileReport(jsd);

			JasperPrint jp = JasperFillManager.fillReport(jr, parameters, connection);

			/****************
			 * export jasper to doc
			 */
			String docPath = request.getRealPath("/") + "/jasper/sales/" + docFile;
			String modDocPath = request.getRealPath("/") + "/jasper/sales/" + modDocFile;
			JRDocxExporter exporterDoc = new JRDocxExporter();
			exporterDoc.setParameter(JRExporterParameter.JASPER_PRINT, jp);
			exporterDoc.setParameter(JRDocxExporterParameter.OFFSET_X, 0);
			exporterDoc.setParameter(JRDocxExporterParameter.OFFSET_Y, 0);
			exporterDoc.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, docPath);
			exporterDoc.exportReport();

			File file = null;
			file = new File(docPath);
			FileInputStream fis = new FileInputStream(file.getAbsolutePath());
			XWPFDocument document = new XWPFDocument(fis);

			CTSectPr sectPr = document.getDocument().getBody().addNewSectPr();
			CTPageMar pageMar = sectPr.addNewPgMar();
			pageMar.setLeft(BigInteger.valueOf(200L));
			pageMar.setTop(BigInteger.valueOf(250L));
			pageMar.setRight(BigInteger.valueOf(300L));
			pageMar.setBottom(BigInteger.valueOf(300L));
			FileOutputStream out = new FileOutputStream(new File(modDocPath));
			document.write(out);
			out.close();

			File file1 = new File(modDocPath);
			Desktop.getDesktop().print(file1);

			status = "success";

		} catch (FileNotFoundException e) {
			status = "failure";
			e.printStackTrace();
		} catch (IOException e) {
			status = "failure";
			e.printStackTrace();
		} catch (SQLException e) {
			status = "failure";
			e.printStackTrace();
		} catch (JRException e) {
			status = "failure";
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if (em != null)
				em.close();
		}

		return status;
	}

	@Override
	@Path(value = "/deleteSalesInvoice")
	@POST
	@Consumes("application/json")
	@Produces("text/plain")
	public String deleteSalesInvoice(CommonResultSetMapper mapper) {
		String status = "";
		try {
			status = salesService.deleteSalesInvoice(mapper);

		} catch (Exception x) {
			status = "" + 0;
			x.printStackTrace();
		}

		return status;
	}

	@Override
	@Path(value = "/deleteSalesReturn")
	@POST
	@Consumes("application/json")
	@Produces("text/plain")
	public String deleteSalesReturn(CommonResultSetMapper mapper) {
		String status = "";
		try {
			status = salesService.deleteSalesReturn(mapper);

		} catch (Exception x) {
			status = "" + 0;
			x.printStackTrace();
		}

		return status;
	}

	@Override
	@Path(value = "/getPaymentModes")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String getPaymentModes(CommonResultSetMapper mapper) {

		//System.out.println("getPaymentModes mapper = " + mapper);
		List<PaymentMode> paymentTypes = null;
		try {

			paymentTypes = salesService.getPaymentModes(mapper);

		} catch (Exception x) {
			x.printStackTrace();

		}
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		java.lang.reflect.Type type = new TypeToken<List<PaymentMode>>() {
		}.getType();
		String json = gson.toJson(paymentTypes, type);

		return json;
	}

	@Override
	@Path(value = "/getAllCustPaymentDetails")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String getAllCustPaymentDetails(CommonResultSetMapper mapper) {
		List<CustPaymentDetailsAllDTO> details = null;

		try {

			details = salesService.getAllCustPaymentDetails(mapper);

		} catch (Exception x) {
			x.printStackTrace();

		}
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		java.lang.reflect.Type type = new TypeToken<List<CustPaymentDetailsAllDTO>>() {
		}.getType();
		String json = gson.toJson(details, type);
		return json;
	}

	@Override
	@Path(value = "/getCustPaymentHeaderById")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String getCustPaymentHeaderById(CommonResultSetMapper mapper) {
		CustPaymentDetailsAllDTO saleHeaderDTO = null;

		try {

			saleHeaderDTO = salesService.getCustPaymentHeaderById(mapper);

		} catch (Exception x) {
			x.printStackTrace();

		}
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		String json = gson.toJson(saleHeaderDTO, CustPaymentDetailsAllDTO.class);

		return json;
	}

	@Override
	@Path(value = "/getCustPaymentDetailsById")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String getCustPaymentDetailsById(CommonResultSetMapper mapper) {
		List<CustPaymentDetailsByIdDTO> details = null;

		try {

			details = salesService.getCustPaymentDetailsById(mapper);

		} catch (Exception x) {
			x.printStackTrace();

		}
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		java.lang.reflect.Type type = new TypeToken<List<CustPaymentDetailsByIdDTO>>() {
		}.getType();
		String json = gson.toJson(details, type);
		return json;
	}

	@Override
	@Path(value = "/getPendingPaymentByCustomer")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String getPendingPaymentByCustomer(CommonResultSetMapper mapper) {
		//System.out.println("getPendingPaymentByCustomer mapper = " + mapper);

		List<CustPaymentDetailsByIdDTO> details = null;

		try {

			details = salesService.getPendingPaymentByCustomer(mapper);

		} catch (Exception x) {
			x.printStackTrace();

		}
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		java.lang.reflect.Type type = new TypeToken<List<CustPaymentDetailsByIdDTO>>() {
		}.getType();
		String json = gson.toJson(details, type);
		return json;
	}

	@Override
	@Path(value = "/deleteCustPayment")
	@POST
	@Consumes("application/json")
	@Produces("text/plain")
	public String deleteCustPayment(CommonResultSetMapper mapper) {
		String status = "";
		try {
			status = salesService.deleteCustPayment(mapper);

		} catch (Exception x) {
			status = "" + 0;
			x.printStackTrace();
		}

		return status;
	}

	@Override
	@Path(value = "/postCustPayment")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String postCustPayment(CommonResultSetMapper mapper) {
		String status = "";
		try {
			status = salesService.postCustPayment(mapper);
		} catch (Exception x) {
			x.printStackTrace();
		}

		return "" + status;
	}

	@Override
	@Path(value = "/createOrUpdateCustPayment")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String createOrUpdateCustPayment(CustomerPayment customerPayment) {
		String status = "";
		try {
			status = salesService.createOrUpdateCustPayment(customerPayment);
		} catch (Exception x) {
			x.printStackTrace();
		}

		return "" + status;
	}

	@Override
	@Path(value = "/getCustWithCreditLimitByName")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String getCustWithCreditLimitByName(CommonResultSetMapper mapper) {
		List<CustomerInfoDTO> customerInfoDTOList = null;

		try {

			customerInfoDTOList = salesService.getCustWithCreditLimitByName(mapper);

		} catch (Exception x) {
			x.printStackTrace();

		}
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		java.lang.reflect.Type type = new TypeToken<List<CustomerInfoDTO>>() {
		}.getType();
		String json = gson.toJson(customerInfoDTOList, type);
		return json;
	}

	@Path(value = "/getTypes")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String getTypes(CommonResultSetMapper mapper) {
		List<TypeMaster> types = null;

		try {

			types = salesService.getTypes(mapper);

		} catch (Exception x) {
			x.printStackTrace();

		}
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		java.lang.reflect.Type type = new TypeToken<List<TypeMaster>>() {
		}.getType();
		String json = gson.toJson(types, type);
		return json;
	}

	@Path(value = "/getEsiCodes")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String getEsiCodes(CommonResultSetMapper mapper) {
		List<EsiCodeMaster> types = null;

		try {

			types = salesService.getEsiCodes(mapper);

		} catch (Exception x) {
			x.printStackTrace();

		}
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		java.lang.reflect.Type type = new TypeToken<List<EsiCodeMaster>>() {
		}.getType();
		String json = gson.toJson(types, type);
		return json;
	}

	@Override
	@Path(value = "/getAutoRemarks")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String getAutoRemarks(CommonResultSetMapper mapper) {
		List<CommonResultSetMapper> list = null;

		try {

			list = salesService.getAutoRemarks(mapper);

		} catch (Exception x) {
			x.printStackTrace();

		}
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		java.lang.reflect.Type type = new TypeToken<List<CommonResultSetMapper>>() {
		}.getType();
		String json = gson.toJson(list, type);
		return json;
	}

	/* Card Payment through gateway START */

	@Path(value = "/insertCardPayment")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String insertCardPayment(CardPaymentStatus cardPaymentStatus) {
		// String status = "";
		//System.out.println("insertCardPayment csp = " + cardPaymentStatus);
		ResponseObj responseObj = new ResponseObj();
		// String responseObj="";
		// ResponseObj responseObj = new ResponseObj();
		String stat = "";
		try {
			stat = salesService.insertCardPayment(cardPaymentStatus);
			if (!stat.equals("0")) {
				responseObj.setStatus(ReturnConstant.SUCCESS);
				responseObj.setId(Integer.parseInt(stat));
				responseObj.setReason("Payment inserted successfully");
			} else {
				throw new Exception("Payment insert not successful.");
			}

		} catch (Exception x) {
			x.printStackTrace();
			responseObj.setStatus(ReturnConstant.FAILURE);
			responseObj.setId(0);
			responseObj.setReason("Payment insert not successful.");
		}
		//System.out.println("Payment insert status = " + responseObj);

		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		String json = gson.toJson(responseObj, ResponseObj.class);
		return json;

//		return responseObj;
	}

	@Path(value = "/updateCardPayment")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String updateCardPayment(CardPaymentStatus cardPaymentStatus) {
		// String status = "";
		//System.out.println("updateCardPayment csp = " + cardPaymentStatus);
		ResponseObj responseObj = new ResponseObj();
		// String responseObj="";
		// ResponseObj responseObj = new ResponseObj();
		String stat = "";
		try {
			stat = salesService.updateCardPayment(cardPaymentStatus);
			if (!stat.equals("0")) {
				responseObj.setStatus(ReturnConstant.SUCCESS);
				responseObj.setId(Integer.parseInt(stat));
				responseObj.setReason("Payment updated successfully");
			} else {
				throw new Exception("Payment update not successful.");
			}

		} catch (Exception x) {
			x.printStackTrace();
			responseObj.setStatus(ReturnConstant.FAILURE);
			responseObj.setId(0);
			responseObj.setReason("Payment update not successful.");
		}
		//System.out.println("Payment update status = " + responseObj);

		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		String json = gson.toJson(responseObj, ResponseObj.class);
		return json;

//		return responseObj;
	}

	@Override
	@Path(value = "/getAllCardPayments")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String getAllCardPayments(CommonResultSetMapper mapper) {
		List<CardPaymentStatus> list = null;

		try {

			list = salesService.getAllCardPayments(mapper);

		} catch (Exception x) {
			x.printStackTrace();

		}
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		java.lang.reflect.Type type = new TypeToken<List<CardPaymentStatus>>() {
		}.getType();
		String json = gson.toJson(list, type);
		return json;
	}

	@Override
	@Path(value = "/deletecardpaytmentID")
	@POST
	@Consumes("application/json")
	@Produces("text/plain")
	public String deleteCardPaytmentID(CardPaymentStatus cardPStatus) {

		//System.out.println("deletecardpaytmentID::" + cardPStatus.getId());
		String status = "";
		try {
			status = salesService.deleteCardPaytmentID(cardPStatus);

		} catch (Exception x) {
			status = "" + 0;
			x.printStackTrace();
		}
		//System.out.println("deletecardpaytmentID status = " + status);
		return status;
	}

	@Override
	@Path(value = "/getAllSaleTransaction")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String getAllSaleTransaction(CommonResultSetMapper mapper) {
		List<CardPaymentStatus> saleTransaction = null;

		//System.out.println("getAllSaleTransaction::" + mapper.getCompanyId() + ", " + mapper.getStoreId());

		try {

			saleTransaction = salesService.getAllSaleTransaction(mapper);

		} catch (Exception x) {
			x.printStackTrace();

		}
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		java.lang.reflect.Type type = new TypeToken<List<CardPaymentStatus>>() {
		}.getType();
		String json = gson.toJson(saleTransaction, type);

		//System.out.println("getAllSaleTransaction saleTransaction = " + json);
		return json;
	}

	/* Card Payment through gateway END */

	@Override
	@Path(value = "/createOrUpdateSaleOrder")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String createOrUpdateSaleOrder(SaleOrder saleOrder) {
		ResponseObj responseObj = new ResponseObj();
		//System.out.println("createOrUpdateSaleOrder saleOrder = " + saleOrder);
		try {
			responseObj = salesService.createOrUpdateSaleOrder(saleOrder);
		} catch (Exception x) {
			x.printStackTrace();
			responseObj.setStatus(ReturnConstant.FAILURE);
			responseObj.setId(0);
			responseObj.setReason("Record not saved successfully.");
		}

		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		String json = gson.toJson(responseObj, ResponseObj.class);
		return json;
	}

	@Override
	@Path(value = "/getAllSaleOrderDetails")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String getAllSaleOrderDetails(CommonResultSetMapper mapper) {
		//System.out.println("getAllSaleOrderDetails mapper = " + mapper);
		List<SaleOrderDTO> sales = null;

		try {

			sales = salesService.getAllSaleOrderDetails(mapper);

		} catch (Exception x) {
			x.printStackTrace();

		}
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		java.lang.reflect.Type type = new TypeToken<List<SaleOrderDTO>>() {
		}.getType();
		String json = gson.toJson(sales, type);
		//System.out.println("getAllSaleOrderDetails result = " + json);
		return json;
	}

	@Override
	@Path(value = "/getSaleOrderHeaderById")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String getSaleOrderHeaderById(CommonResultSetMapper mapper) {
		SaleOrderDTO sales = null;

		try {

			sales = salesService.getSaleOrderHeaderById(mapper);

		} catch (Exception x) {
			x.printStackTrace();

		}
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		String json = gson.toJson(sales, SaleOrderDTO.class);

		return json;
	}

	@Override
	@Path(value = "/getSaleOrderDetailsById")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String getSaleOrderDetailsById(CommonResultSetMapper mapper) {
		List<SaleOrderDetailsDTO> purchase = null;

		try {

			purchase = salesService.getSaleOrderDetailsById(mapper);

		} catch (Exception x) {
			x.printStackTrace();

		}
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		java.lang.reflect.Type type = new TypeToken<List<SaleOrderDetailsDTO>>() {
		}.getType();
		String json = gson.toJson(purchase, type);
		return json;
	}
	
	@Override
	@Path(value = "/getSaleOrderDetailsByInvNo")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String getSaleOrderDetailsByInvNo(CommonResultSetMapper mapper) {
		List<SaleOrderDetailsDTO> purchase = null;

		try {

			purchase = salesService.getSaleOrderDetailsByInvNo(mapper);

		} catch (Exception x) {
			x.printStackTrace();

		}
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		java.lang.reflect.Type type = new TypeToken<List<SaleOrderDetailsDTO>>() {
		}.getType();
		String json = gson.toJson(purchase, type);
		return json;
	}

	@Override
	@Path(value = "/closeSaleOrder")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String closeSaleOrder(CommonResultSetMapper mapper) {
		ResponseObj responseObj = new ResponseObj();
		try {
			responseObj = salesService.closeSaleOrder(mapper);
		} catch (Exception x) {
			x.printStackTrace();
			responseObj.setStatus(ReturnConstant.FAILURE);
			responseObj.setId(0);
			responseObj.setReason("PO not closed successfully.");
		}

		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		String json = gson.toJson(responseObj, ResponseObj.class);
		return json;
	}

	@Override
	@Path(value = "/deleteSaleOrder")
	@POST
	@Consumes("application/json")
	@Produces("text/plain")
	public String deleteSaleOrder(CommonResultSetMapper mapper) {
		ResponseObj responseObj = new ResponseObj();
		try {
			responseObj = salesService.deleteSaleOrder(mapper);

		} catch (Exception x) {
			x.printStackTrace();
			responseObj.setStatus(ReturnConstant.FAILURE);
			responseObj.setId(0);
			responseObj.setReason("PO not deleted successfully.");
		}

		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		String json = gson.toJson(responseObj, ResponseObj.class);
		return json;
	}

	@Override
	@Path(value = "/postSaleOrder")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String postSaleOrder(CommonResultSetMapper mapper) {
		ResponseObj responseObj = new ResponseObj();
		try {
			responseObj = salesService.postSaleOrder(mapper);
		} catch (Exception x) {
			x.printStackTrace();
			responseObj.setStatus(ReturnConstant.FAILURE);
			responseObj.setId(0);
			responseObj.setReason("Data not posted successfully.");
		}

		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		String json = gson.toJson(responseObj, ResponseObj.class);
		return json;
	}

	@Override
	@Path(value = "/getPendingSaleOrderDetails")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String getPendingSaleOrderDetails(CommonResultSetMapper mapper) {
		List<SaleOrderDetailsDTO> sales = null;

		try {

			sales = salesService.getPendingSaleOrderDetails(mapper);

		} catch (Exception x) {
			x.printStackTrace();

		}
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		java.lang.reflect.Type type = new TypeToken<List<SaleOrderDetailsDTO>>() {
		}.getType();
		String json = gson.toJson(sales, type);
		return json;
	}
	
	//added on 26.06.2019
	@Override
	@Path(value = "/createOrUpdateSaleTourPlan")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String createOrUpdateSaleTourPlan(SaleTourPlan saleTourPlan) {
		ResponseObj responseObj = new ResponseObj();
		//System.out.println("createOrUpdateSaleTourPlan saleTourPlan = " + saleTourPlan);
		try {
			responseObj = salesService.createOrUpdateSaleTourPlan(saleTourPlan);
		} catch (Exception x) {
			x.printStackTrace();
			responseObj.setStatus(ReturnConstant.FAILURE);
			responseObj.setId(0);
			responseObj.setReason("Record not saved successfully.");
		}

		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		String json = gson.toJson(responseObj, ResponseObj.class);
		return json;
	}
	
	//added on 27.06.2019
	@Override
	@Path(value = "/getAllSaleTourPlanDetails")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String getAllSaleTourPlanDetails(CommonResultSetMapper mapper) {
		List<SaleTourPlanDTO> stps = null;

		try {

			stps = salesService.getAllSaleTourPlanDetails(mapper);

		} catch (Exception x) {
			x.printStackTrace();

		}
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		java.lang.reflect.Type type = new TypeToken<List<SaleTourPlanDTO>>() {
		}.getType();
		String json = gson.toJson(stps, type);
		//System.out.println("getAllSaleTourPlanDetails result = " + json);
		return json;
	}
	
	@Override
	@Path(value = "/getSaleTourPlanHeaderById")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String getSaleTourPlanHeaderById(CommonResultSetMapper mapper) {
		SaleTourPlanDTO stp = null;

		try {

			stp = salesService.getSaleTourPlanHeaderById(mapper);

		} catch (Exception x) {
			x.printStackTrace();

		}
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		String json = gson.toJson(stp, SaleTourPlanDTO.class);

		return json;
	}

	@Override
	@Path(value = "/getSaleTourPlanDetailsById")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String getSaleTourPlanDetailsById(CommonResultSetMapper mapper) {
		List<SaleTourPlanDetailsDTO> stpDetails = null;

		try {

			stpDetails = salesService.getSaleTourPlanDetailsById(mapper);

		} catch (Exception x) {
			x.printStackTrace();

		}
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		java.lang.reflect.Type type = new TypeToken<List<SaleTourPlanDetailsDTO>>() {
		}.getType();
		String json = gson.toJson(stpDetails, type);
		return json;
	}

	@Override
	@Path(value = "/cancelSaleTourPlan")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String cancelSaleTourPlan(CommonResultSetMapper mapper) {
		ResponseObj responseObj = new ResponseObj();
		try {
			responseObj = salesService.cancelSaleTourPlan(mapper);
		} catch (Exception x) {
			x.printStackTrace();
			responseObj.setStatus(ReturnConstant.FAILURE);
			responseObj.setId(0);
			responseObj.setReason("STP not cancelled successfully.");
		}

		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		String json = gson.toJson(responseObj, ResponseObj.class);
		return json;
	}

	@Override
	@Path(value = "/deleteSaleTourPlan")
	@POST
	@Consumes("application/json")
	@Produces("text/plain")
	public String deleteSaleTourPlan(CommonResultSetMapper mapper) {
		ResponseObj responseObj = new ResponseObj();
		try {
			responseObj = salesService.deleteSaleTourPlan(mapper);

		} catch (Exception x) {
			x.printStackTrace();
			responseObj.setStatus(ReturnConstant.FAILURE);
			responseObj.setId(0);
			responseObj.setReason("STP not deleted successfully.");
		}

		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		String json = gson.toJson(responseObj, ResponseObj.class);
		return json;
	}

	@Override
	@Path(value = "/postSaleTourPlan")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String postSaleTourPlan(CommonResultSetMapper mapper) {
		ResponseObj responseObj = new ResponseObj();
		try {
			responseObj = salesService.postSaleTourPlan(mapper);
		} catch (Exception x) {
			x.printStackTrace();
			responseObj.setStatus(ReturnConstant.FAILURE);
			responseObj.setId(0);
			responseObj.setReason("Data not posted successfully.");
		}

		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		String json = gson.toJson(responseObj, ResponseObj.class);
		return json;
	}
	
	@Override
	@Path(value = "/createSaleManTourDetail")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String createSaleManTourDetail(SaleManTourDetails salesmanTour) {
		ResponseObj responseObj = new ResponseObj();
		System.out.println("createSaleManTourDetail = " + salesmanTour);
		try {
			responseObj = salesService.createSaleManTourDetail(salesmanTour);
		} catch (Exception x) {
			x.printStackTrace();
			responseObj.setStatus(ReturnConstant.FAILURE);
			responseObj.setId(0);
			responseObj.setReason("Record not saved successfully.");
		}

		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		String json = gson.toJson(responseObj, ResponseObj.class);
		return json;
	}
	
	@Override
	@Path(value = "/getSaleManTourDetails")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String getSaleManTourDetails(CommonResultSetMapper mapper) {
		List<SaleManTourDetailsDTO> smts = null;

		try {

			smts = salesService.getSaleManTourDetails(mapper);

		} catch (Exception x) {
			x.printStackTrace();

		}
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		java.lang.reflect.Type type = new TypeToken<List<SaleManTourDetailsDTO>>() {
		}.getType();
		String json = gson.toJson(smts, type);
		//System.out.println("getSaleManTourDetails result = " + json);
		return json;
	}
	
	@Override
	@Path(value = "/getSaleManCheckinStatus")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String getSaleManCheckinStatus(CommonResultSetMapper mapper) {
		ResponseObj responseObj = new ResponseObj();
		try {
			responseObj = salesService.getSaleManCheckinStatus(mapper);
		} catch (Exception x) {
			x.printStackTrace();
			responseObj.setStatus(ReturnConstant.FAILURE);
			responseObj.setId(0);
			responseObj.setReason("Not Checked In.");
		}

		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		String json = gson.toJson(responseObj, ResponseObj.class);
		return json;
	}
	
	@Override
	@Path(value = "/getSaleManCheckoutStatus")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String getSaleManCheckoutStatus(CommonResultSetMapper mapper) {
		ResponseObj responseObj = new ResponseObj();
		try {
			responseObj = salesService.getSaleManCheckoutStatus(mapper);
		} catch (Exception x) {
			x.printStackTrace();
			responseObj.setStatus(ReturnConstant.FAILURE);
			responseObj.setId(0);
			responseObj.setReason("Not Checked Out.");
		}

		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		String json = gson.toJson(responseObj, ResponseObj.class);
		return json;
	}
	
	//added on 10.07.2019
	@Override
	@Path(value = "/createSaleManTourDetailOffline")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String createSaleManTourDetailOffline(SaleManTour salesmanTour) {
		ResponseObj responseObj = new ResponseObj();
		//System.out.println("createSaleManTourDetail offline = " + salesmanTour);
		try {
			responseObj = salesService.createSaleManTourDetailOffline(salesmanTour);
		} catch (Exception x) {
			x.printStackTrace();
			responseObj.setStatus(ReturnConstant.FAILURE);
			responseObj.setId(0);
			responseObj.setReason("Record not saved successfully.");
		}

		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		String json = gson.toJson(responseObj, ResponseObj.class);
		return json;
	}

	@Path(value = "/report/sales")
	@GET
	public void getSalesSummaryReport(@QueryParam(value = "cmpnyId") String cmpnyId,
			@QueryParam(value = "storeId") String storeId, @QueryParam(value = "finYrId") String finYrId,
			@QueryParam(value = "customerId") String customerId, @QueryParam(value = "doctorId") String doctorId,
			@QueryParam(value = "itemId") String itemId, @QueryParam(value = "startDate") String startDate,
			@QueryParam(value = "endDate") String endDate, @QueryParam(value = "rptType") int rptType,
			@Context HttpServletRequest request, @Context HttpServletResponse response) {

		String fileName = null;
		Connection connection = null;
		EntityManagerFactory entityManagerFactory;
		EntityManager em = null;
		String jasperFile = null;
		try {
			String DATE_FORMAT_NEEDED = "MM/dd/yyyy";
			String DATE_FORMAT_RECEIVED = "yyyy-MM-dd";
			String convertdDateStrt = DateUtil.convertReceivedDateToNeededDateStr(DATE_FORMAT_RECEIVED,
					DATE_FORMAT_NEEDED, startDate);
			String convertdDateEnd = DateUtil.convertReceivedDateToNeededDateStr(DATE_FORMAT_RECEIVED,
					DATE_FORMAT_NEEDED, endDate);
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();

			// get connection object from entity manager
			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses.getSessionFactory();

			connection = sessionFactory.getConnectionProvider().getConnection();
			// String asOnDatestr=mapper.getAsOnDate();
			java.sql.Date strtDt = DateUtil.convertStringDateToSqlDate(convertdDateStrt, DATE_FORMAT_NEEDED);
			java.sql.Date endDt = DateUtil.convertStringDateToSqlDate(convertdDateEnd, DATE_FORMAT_NEEDED);

			// Date strtDt= DateUtil.convertStringDate(startDate, DATE_FORMAT);
			// java.sql.Date startDateSql=new java.sql.Date(strtDt.getTime());
			// Date strtDtnew =new SimpleDateFormat("MM/dd/yyyy").format(new
			// Date("startDate"));

			Map<String, Object> parameters = new HashMap<String, Object>();

			parameters.put("W_companyID", Integer.parseInt(cmpnyId));
			parameters.put("W_storeID", Integer.parseInt(storeId));
			parameters.put("W_finyrID", Integer.parseInt(finYrId));
			parameters.put("W_customerID", Integer.parseInt(customerId));
			parameters.put("W_doctorID", Integer.parseInt(doctorId));
			parameters.put("W_itemID", Integer.parseInt(itemId));
			parameters.put("W_startDate", strtDt);
			parameters.put("W_endDate", endDt);
			fileName = "sale_summary";
			jasperFile = "sale_summary.jrxml";

			if (Integer.parseInt(storeId) == 0) {
				fileName = "adm_" + fileName;
				jasperFile = "adm_" + jasperFile;
			}

			if (rptType == 1) {
				// call method to generate pdf
				fileName = fileName + ".pdf";
				generatePDF(request, response, fileName, parameters, connection, jasperFile);
			} else {
				fileName = fileName + ".xlsx";
				generateXLS(request, response, fileName, parameters, connection, jasperFile);
			}

			File file = new File(request.getRealPath("/") + "/jasper/sales/" + fileName);
			InputStream is = new FileInputStream(file);
			response.reset();
			if (rptType == 1) {
				response.setHeader("Content-Type", "application/pdf");
			} else {
				response.setHeader("Content-Type", "application/vnd.ms-excel");
			}
			response.setHeader("Content-Length", String.valueOf(file.length()));
			response.setHeader("Content-Disposition", "inline; filename=\"" + fileName + "\"");
			List<Byte> buf = new ArrayList<Byte>();
			int ch = -1;
			while ((ch = is.read()) != -1) {
				buf.add((byte) ch);
			}
			byte[] array = new byte[buf.size()];
			for (int i = 0; i < buf.size(); i++) {
				array[i] = buf.get(i);
			}
			ServletOutputStream os = response.getOutputStream();
			os.write(array);
			os.flush();
			os.close();
			is.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if (em != null)
				em.close();
		}
	}

	

	@Path(value = "/report/gstB2CS")
	@GET
	public void getGstB2CSReport(@QueryParam(value = "cmpnyId") String cmpnyId,
			@QueryParam(value = "storeId") String storeId, @QueryParam(value = "finYrId") String finYrId,
			@QueryParam(value = "startDate") String startDate, @QueryParam(value = "endDate") String endDate,
			@Context HttpServletRequest request, @Context HttpServletResponse response) {

		String fileName = null;
		Connection connection = null;
		EntityManagerFactory entityManagerFactory;
		EntityManager em = null;
		String jasperFile = null;
		try {
			String DATE_FORMAT_NEEDED = "MM/dd/yyyy";
			String DATE_FORMAT_RECEIVED = "yyyy-MM-dd";
			String convertdDateStrt = DateUtil.convertReceivedDateToNeededDateStr(DATE_FORMAT_RECEIVED,
					DATE_FORMAT_NEEDED, startDate);
			String convertdDateEnd = DateUtil.convertReceivedDateToNeededDateStr(DATE_FORMAT_RECEIVED,
					DATE_FORMAT_NEEDED, endDate);
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();

			// get connection object from entity manager
			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses.getSessionFactory();

			connection = sessionFactory.getConnectionProvider().getConnection();
			// String asOnDatestr=mapper.getAsOnDate();
			java.sql.Date strtDt = DateUtil.convertStringDateToSqlDate(convertdDateStrt, DATE_FORMAT_NEEDED);
			java.sql.Date endDt = DateUtil.convertStringDateToSqlDate(convertdDateEnd, DATE_FORMAT_NEEDED);

			Map<String, Object> parameters = new HashMap<String, Object>();

			parameters.put("W_companyID", Integer.parseInt(cmpnyId));
			parameters.put("W_storeID", Integer.parseInt(storeId));
			parameters.put("W_finyrID", Integer.parseInt(finYrId));
			parameters.put("W_startDate", strtDt);
			parameters.put("W_endDate", endDt);
			fileName = "gst_b2cs_report.xlsx";
			jasperFile = "GST_B2CS_REPORT.jrxml";

			// call method to generate xls
			generateXLS(request, response, fileName, parameters, connection, jasperFile);

			/*
			 * generatePDF(request, response, fileName, parameters, connection, jasperFile);
			 */

			File file = new File(request.getRealPath("/") + "/jasper/sales/" + fileName);
			InputStream is = new FileInputStream(file);
			response.reset();
			response.setHeader("Content-Type", "application/vnd.ms-excel");
			response.setHeader("Content-Length", String.valueOf(file.length()));
			response.setHeader("Content-Disposition", "inline; filename=\"" + fileName + "\"");
			List<Byte> buf = new ArrayList<Byte>();
			int ch = -1;
			while ((ch = is.read()) != -1) {
				buf.add((byte) ch);
			}
			byte[] array = new byte[buf.size()];
			for (int i = 0; i < buf.size(); i++) {
				array[i] = buf.get(i);
			}
			ServletOutputStream os = response.getOutputStream();
			os.write(array);
			os.flush();
			os.close();
			is.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if (em != null)
				em.close();
		}
	}

	@Path(value = "/report/gstHSN")
	@GET
	public void getHSNReport(@QueryParam(value = "cmpnyId") String cmpnyId,
			@QueryParam(value = "storeId") String storeId, @QueryParam(value = "finYrId") String finYrId,
			@QueryParam(value = "startDate") String startDate, @QueryParam(value = "endDate") String endDate,
			@Context HttpServletRequest request, @Context HttpServletResponse response) {

		String fileName = null;
		Connection connection = null;
		EntityManagerFactory entityManagerFactory;
		EntityManager em = null;
		String jasperFile = null;
		try {
			String DATE_FORMAT_NEEDED = "MM/dd/yyyy";
			String DATE_FORMAT_RECEIVED = "yyyy-MM-dd";
			String convertdDateStrt = DateUtil.convertReceivedDateToNeededDateStr(DATE_FORMAT_RECEIVED,
					DATE_FORMAT_NEEDED, startDate);
			String convertdDateEnd = DateUtil.convertReceivedDateToNeededDateStr(DATE_FORMAT_RECEIVED,
					DATE_FORMAT_NEEDED, endDate);
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();

			// get connection object from entity manager
			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses.getSessionFactory();

			connection = sessionFactory.getConnectionProvider().getConnection();
			// String asOnDatestr=mapper.getAsOnDate();
			java.sql.Date strtDt = DateUtil.convertStringDateToSqlDate(convertdDateStrt, DATE_FORMAT_NEEDED);
			java.sql.Date endDt = DateUtil.convertStringDateToSqlDate(convertdDateEnd, DATE_FORMAT_NEEDED);

			Map<String, Object> parameters = new HashMap<String, Object>();

			parameters.put("W_companyID", Integer.parseInt(cmpnyId));
			parameters.put("W_storeID", Integer.parseInt(storeId));
			parameters.put("W_finyrID", Integer.parseInt(finYrId));
			parameters.put("W_startDate", strtDt);
			parameters.put("W_endDate", endDt);
			fileName = "hsn_report.xlsx";
			jasperFile = "hsn_report.jrxml";

			// call method to generate xls
			generateXLS(request, response, fileName, parameters, connection, jasperFile);

			File file = new File(request.getRealPath("/") + "/jasper/sales/" + fileName);
			InputStream is = new FileInputStream(file);
			response.reset();
			response.setHeader("Content-Type", "application/vnd.ms-excel");
			response.setHeader("Content-Length", String.valueOf(file.length()));
			response.setHeader("Content-Disposition", "inline; filename=\"" + fileName + "\"");
			List<Byte> buf = new ArrayList<Byte>();
			int ch = -1;
			while ((ch = is.read()) != -1) {
				buf.add((byte) ch);
			}
			byte[] array = new byte[buf.size()];
			for (int i = 0; i < buf.size(); i++) {
				array[i] = buf.get(i);
			}
			ServletOutputStream os = response.getOutputStream();
			os.write(array);
			os.flush();
			os.close();
			is.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if (em != null)
				em.close();
		}
	}

	@Path(value = "/report/sales/register/EsiOngc")
	@GET
	public void getSalesRegisterEsiOngcReport(@QueryParam(value = "cmpnyId") String cmpnyId,
			@QueryParam(value = "storeId") String storeId, @QueryParam(value = "finYrId") String finYrId,
			@QueryParam(value = "startDate") String startDate, @QueryParam(value = "endDate") String endDate,
			@QueryParam(value = "type") String type, @Context HttpServletRequest request,
			@Context HttpServletResponse response) {

		String fileName = null;
		Connection connection = null;
		EntityManagerFactory entityManagerFactory;
		EntityManager em = null;
		String jasperFile = null;
		try {
			String DATE_FORMAT_NEEDED = "MM/dd/yyyy";
			String DATE_FORMAT_RECEIVED = "yyyy-MM-dd";
			String convertdDateStrt = DateUtil.convertReceivedDateToNeededDateStr(DATE_FORMAT_RECEIVED,
					DATE_FORMAT_NEEDED, startDate);
			String convertdDateEnd = DateUtil.convertReceivedDateToNeededDateStr(DATE_FORMAT_RECEIVED,
					DATE_FORMAT_NEEDED, endDate);
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();

			// get connection object from entity manager
			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses.getSessionFactory();

			connection = sessionFactory.getConnectionProvider().getConnection();
			// String asOnDatestr=mapper.getAsOnDate();
			java.sql.Date strtDt = DateUtil.convertStringDateToSqlDate(convertdDateStrt, DATE_FORMAT_NEEDED);
			java.sql.Date endDt = DateUtil.convertStringDateToSqlDate(convertdDateEnd, DATE_FORMAT_NEEDED);

			Map<String, Object> parameters = new HashMap<String, Object>();

			parameters.put("W_companyID", Integer.parseInt(cmpnyId));
			parameters.put("W_storeID", Integer.parseInt(storeId));
			parameters.put("W_finyrID", Integer.parseInt(finYrId));
			parameters.put("W_startDate", strtDt);
			parameters.put("W_endDate", endDt);
			parameters.put("W_type", type);

			if (type.equalsIgnoreCase("ONGC")) {
				fileName = "ongc_sale_register.xlsx";
				jasperFile = "ongc_sale_register.jrxml";
			} else if (type.equalsIgnoreCase("ESI")) {
				fileName = "esi_sale_register.xlsx";
				jasperFile = "esi_sale_register.jrxml";
			}

			// call method to generate xls
			generateXLS(request, response, fileName, parameters, connection, jasperFile);

			File file = new File(request.getRealPath("/") + "/jasper/sales/" + fileName);
			InputStream is = new FileInputStream(file);
			response.reset();
			response.setHeader("Content-Type", "application/vnd.ms-excel");
			response.setHeader("Content-Length", String.valueOf(file.length()));
			response.setHeader("Content-Disposition", "inline; filename=\"" + fileName + "\"");
			List<Byte> buf = new ArrayList<Byte>();
			int ch = -1;
			while ((ch = is.read()) != -1) {
				buf.add((byte) ch);
			}
			byte[] array = new byte[buf.size()];
			for (int i = 0; i < buf.size(); i++) {
				array[i] = buf.get(i);
			}
			ServletOutputStream os = response.getOutputStream();
			os.write(array);
			os.flush();
			os.close();
			is.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if (em != null)
				em.close();
		}
	}

	@Path(value = "/report/sales/register")
	@GET
	public void getSalesRegisterReport(@QueryParam(value = "cmpnyId") String cmpnyId,
			@QueryParam(value = "storeId") String storeId, @QueryParam(value = "finYrId") String finYrId,
			@QueryParam(value = "schId") String schId, @QueryParam(value = "customerId") String customerId,
			@QueryParam(value = "doctorId") String doctorId, @QueryParam(value = "startDate") String startDate,
			@QueryParam(value = "endDate") String endDate,
			@QueryParam(value = "rptType") int rptType,
			@Context HttpServletRequest request,
			@Context HttpServletResponse response) {

		String fileName = null;
		Connection connection = null;
		EntityManagerFactory entityManagerFactory;
		EntityManager em = null;
		String jasperFile = null;
		try {
			String DATE_FORMAT_NEEDED = "MM/dd/yyyy";
			String DATE_FORMAT_RECEIVED = "yyyy-MM-dd";
			String convertdDateStrt = DateUtil.convertReceivedDateToNeededDateStr(DATE_FORMAT_RECEIVED,
					DATE_FORMAT_NEEDED, startDate);
			String convertdDateEnd = DateUtil.convertReceivedDateToNeededDateStr(DATE_FORMAT_RECEIVED,
					DATE_FORMAT_NEEDED, endDate);
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();

			// get connection object from entity manager
			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses.getSessionFactory();

			connection = sessionFactory.getConnectionProvider().getConnection();
			java.sql.Date strtDt = DateUtil.convertStringDateToSqlDate(convertdDateStrt, DATE_FORMAT_NEEDED);
			java.sql.Date endDt = DateUtil.convertStringDateToSqlDate(convertdDateEnd, DATE_FORMAT_NEEDED);

			Map<String, Object> parameters = new HashMap<String, Object>();

			parameters.put("W_companyID", Integer.parseInt(cmpnyId));
			parameters.put("W_storeID", Integer.parseInt(storeId));
			parameters.put("W_finyrID", Integer.parseInt(finYrId));
			parameters.put("W_scheduleID", Integer.parseInt(schId));
			parameters.put("W_customerID", Integer.parseInt(customerId));
			parameters.put("W_doctorID", Integer.parseInt(doctorId));
			parameters.put("W_startDate", strtDt);
			parameters.put("W_endDate", endDt);

			fileName = "sale_register";
			jasperFile = "sale_register.jrxml";

			if (Integer.parseInt(storeId) == 0) {
				fileName = "adm_" + fileName;
				jasperFile = "adm_" + jasperFile;
			}
			
			if (rptType == 1) {
				// call method to generate pdf
				fileName = fileName + ".pdf";
				generatePDF(request, response, fileName, parameters, connection, jasperFile);
			} else {
				fileName = fileName + ".xlsx";
				generateXLS(request, response, fileName, parameters, connection, jasperFile);
			}

			File file = new File(request.getRealPath("/") + "/jasper/sales/" + fileName);
			InputStream is = new FileInputStream(file);
			response.reset();
			if (rptType == 1) {
				response.setHeader("Content-Type", "application/pdf");
			} else {
				response.setHeader("Content-Type", "application/vnd.ms-excel");
			}
			response.setHeader("Content-Length", String.valueOf(file.length()));
			response.setHeader("Content-Disposition", "inline; filename=\"" + fileName + "\"");
			List<Byte> buf = new ArrayList<Byte>();
			int ch = -1;
			while ((ch = is.read()) != -1) {
				buf.add((byte) ch);
			}
			byte[] array = new byte[buf.size()];
			for (int i = 0; i < buf.size(); i++) {
				array[i] = buf.get(i);
			}
			ServletOutputStream os = response.getOutputStream();
			os.write(array);
			os.flush();
			os.close();
			is.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if (em != null)
				em.close();
		}
	}

	@Path(value = "/report/sales/item")
	@GET
	public void getSalesItemReport(@QueryParam(value = "cmpnyId") String cmpnyId,
			@QueryParam(value = "storeId") String storeId, @QueryParam(value = "finYrId") String finYrId,
			@QueryParam(value = "customerId") String customerId, @QueryParam(value = "itemId") String itemId,
			@QueryParam(value = "contentId") String contentId,
			@QueryParam(value = "manufacturerId") String manufacturerId,
			@QueryParam(value = "startDate") String startDate,
			@QueryParam(value = "endDate") String endDate,
			@QueryParam(value = "rptType") int rptType,
			@Context HttpServletRequest request, @Context HttpServletResponse response) {

		String fileName = null;
		Connection connection = null;
		EntityManagerFactory entityManagerFactory;
		EntityManager em = null;
		String jasperFile = null;
		try {
			String DATE_FORMAT_NEEDED = "MM/dd/yyyy";
			String DATE_FORMAT_RECEIVED = "yyyy-MM-dd";
			String convertdDateStrt = DateUtil.convertReceivedDateToNeededDateStr(DATE_FORMAT_RECEIVED,
					DATE_FORMAT_NEEDED, startDate);
			String convertdDateEnd = DateUtil.convertReceivedDateToNeededDateStr(DATE_FORMAT_RECEIVED,
					DATE_FORMAT_NEEDED, endDate);
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();

			// get connection object from entity manager
			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses.getSessionFactory();

			connection = sessionFactory.getConnectionProvider().getConnection();
			// String asOnDatestr=mapper.getAsOnDate();
			java.sql.Date strtDt = DateUtil.convertStringDateToSqlDate(convertdDateStrt, DATE_FORMAT_NEEDED);
			java.sql.Date endDt = DateUtil.convertStringDateToSqlDate(convertdDateEnd, DATE_FORMAT_NEEDED);

			Map<String, Object> parameters = new HashMap<String, Object>();

			parameters.put("W_companyID", Integer.parseInt(cmpnyId));
			parameters.put("W_storeID", Integer.parseInt(storeId));
			parameters.put("W_finyrID", Integer.parseInt(finYrId));
			parameters.put("W_customerID", Integer.parseInt(customerId));
			parameters.put("W_itemID", Integer.parseInt(itemId));
			parameters.put("W_contentID", Integer.parseInt(contentId));
			parameters.put("W_manufacturerID", Integer.parseInt(manufacturerId));
			parameters.put("W_startDate", strtDt);
			parameters.put("W_endDate", endDt);
			fileName = "item_wise_sale";
			jasperFile = "item_wise_sale.jrxml";

			if (Integer.parseInt(storeId) == 0) {
				fileName = "adm_" + fileName;
				jasperFile = "adm_" + jasperFile;
			}

			if (rptType == 1) {
				// call method to generate pdf
				fileName = fileName + ".pdf";
				generatePDF(request, response, fileName, parameters, connection, jasperFile);
			} else {
				fileName = fileName + ".xlsx";
				generateXLS(request, response, fileName, parameters, connection, jasperFile);
			}

			File file = new File(request.getRealPath("/") + "/jasper/sales/" + fileName);
			InputStream is = new FileInputStream(file);
			response.reset();
			if (rptType == 1) {
				response.setHeader("Content-Type", "application/pdf");
			} else {
				response.setHeader("Content-Type", "application/vnd.ms-excel");
			}
			response.setHeader("Content-Length", String.valueOf(file.length()));
			response.setHeader("Content-Disposition", "inline; filename=\"" + fileName + "\"");
			List<Byte> buf = new ArrayList<Byte>();
			int ch = -1;
			while ((ch = is.read()) != -1) {
				buf.add((byte) ch);
			}
			byte[] array = new byte[buf.size()];
			for (int i = 0; i < buf.size(); i++) {
				array[i] = buf.get(i);
			}
			ServletOutputStream os = response.getOutputStream();
			os.write(array);
			os.flush();
			os.close();
			is.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if (em != null)
				em.close();
		}
	}

	@Path(value = "/report/sales/return/item")
	@GET
	public void getSalesReturnItemReport(@QueryParam(value = "cmpnyId") String cmpnyId,
			@QueryParam(value = "storeId") String storeId, @QueryParam(value = "finYrId") String finYrId,
			@QueryParam(value = "customerId") String customerId, @QueryParam(value = "itemId") String itemId,
			@QueryParam(value = "contentId") String contentId,
			@QueryParam(value = "manufacturerId") String manufacturerId,
			@QueryParam(value = "startDate") String startDate, 
			@QueryParam(value = "rptType") int rptType,
			@QueryParam(value = "endDate") String endDate,
			@Context HttpServletRequest request, @Context HttpServletResponse response) {

		String fileName = null;
		Connection connection = null;
		EntityManagerFactory entityManagerFactory;
		EntityManager em = null;
		String jasperFile = null;
		try {
			String DATE_FORMAT_NEEDED = "MM/dd/yyyy";
			String DATE_FORMAT_RECEIVED = "yyyy-MM-dd";
			String convertdDateStrt = DateUtil.convertReceivedDateToNeededDateStr(DATE_FORMAT_RECEIVED,
					DATE_FORMAT_NEEDED, startDate);
			String convertdDateEnd = DateUtil.convertReceivedDateToNeededDateStr(DATE_FORMAT_RECEIVED,
					DATE_FORMAT_NEEDED, endDate);
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();

			// get connection object from entity manager
			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses.getSessionFactory();

			connection = sessionFactory.getConnectionProvider().getConnection();
			// String asOnDatestr=mapper.getAsOnDate();
			java.sql.Date strtDt = DateUtil.convertStringDateToSqlDate(convertdDateStrt, DATE_FORMAT_NEEDED);
			java.sql.Date endDt = DateUtil.convertStringDateToSqlDate(convertdDateEnd, DATE_FORMAT_NEEDED);

			Map<String, Object> parameters = new HashMap<String, Object>();

			parameters.put("W_companyID", Integer.parseInt(cmpnyId));
			parameters.put("W_storeID", Integer.parseInt(storeId));
			parameters.put("W_finyrID", Integer.parseInt(finYrId));
			parameters.put("W_customerID", Integer.parseInt(customerId));
			parameters.put("W_itemID", Integer.parseInt(itemId));
			parameters.put("W_contentID", Integer.parseInt(contentId));
			parameters.put("W_manufacturerID", Integer.parseInt(manufacturerId));
			parameters.put("W_startDate", strtDt);
			parameters.put("W_endDate", endDt);
			fileName = "item_wise_sale_return";
			jasperFile = "item_wise_sale_return.jrxml";

			if (Integer.parseInt(storeId) == 0) {
				fileName = "adm_" + fileName;
				jasperFile = "adm_" + jasperFile;
			}

			if (rptType == 1) {
				// call method to generate pdf
				fileName = fileName + ".pdf";
				generatePDF(request, response, fileName, parameters, connection, jasperFile);
			} else {
				fileName = fileName + ".xlsx";
				generateXLS(request, response, fileName, parameters, connection, jasperFile);
			}

			File file = new File(request.getRealPath("/") + "/jasper/sales/" + fileName);
			InputStream is = new FileInputStream(file);
			response.reset();
			if (rptType == 1) {
				response.setHeader("Content-Type", "application/pdf");
			} else {
				response.setHeader("Content-Type", "application/vnd.ms-excel");
			}
			response.setHeader("Content-Length", String.valueOf(file.length()));
			response.setHeader("Content-Disposition", "inline; filename=\"" + fileName + "\"");
			List<Byte> buf = new ArrayList<Byte>();
			int ch = -1;
			while ((ch = is.read()) != -1) {
				buf.add((byte) ch);
			}
			byte[] array = new byte[buf.size()];
			for (int i = 0; i < buf.size(); i++) {
				array[i] = buf.get(i);
			}
			ServletOutputStream os = response.getOutputStream();
			os.write(array);
			os.flush();
			os.close();
			is.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if (em != null)
				em.close();
		}
	}

	@Path(value = "/report/sale/return")
	@GET
	public void getSalesReturnSummaryReport(@QueryParam(value = "cmpnyId") String cmpnyId,
			@QueryParam(value = "storeId") String storeId, @QueryParam(value = "finYrId") String finYrId,
			@QueryParam(value = "customerId") String customerId, @QueryParam(value = "doctorId") String doctorId,
			@QueryParam(value = "itemId") String itemId, @QueryParam(value = "startDate") String startDate,
			@QueryParam(value = "endDate") String endDate,
			@QueryParam(value = "rptType") int rptType,
			@Context HttpServletRequest request,
			@Context HttpServletResponse response) {

		String fileName = null;
		Connection connection = null;
		EntityManagerFactory entityManagerFactory;
		EntityManager em = null;
		String jasperFile = null;
		try {
			String DATE_FORMAT_NEEDED = "MM/dd/yyyy";
			String DATE_FORMAT_RECEIVED = "yyyy-MM-dd";
			String convertdDateStrt = DateUtil.convertReceivedDateToNeededDateStr(DATE_FORMAT_RECEIVED,
					DATE_FORMAT_NEEDED, startDate);
			String convertdDateEnd = DateUtil.convertReceivedDateToNeededDateStr(DATE_FORMAT_RECEIVED,
					DATE_FORMAT_NEEDED, endDate);
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();

			// get connection object from entity manager
			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses.getSessionFactory();

			connection = sessionFactory.getConnectionProvider().getConnection();
			// String asOnDatestr=mapper.getAsOnDate();
			java.sql.Date strtDt = DateUtil.convertStringDateToSqlDate(convertdDateStrt, DATE_FORMAT_NEEDED);
			java.sql.Date endDt = DateUtil.convertStringDateToSqlDate(convertdDateEnd, DATE_FORMAT_NEEDED);

			// Date strtDt= DateUtil.convertStringDate(startDate, DATE_FORMAT);
			// java.sql.Date startDateSql=new java.sql.Date(strtDt.getTime());
			// Date strtDtnew =new SimpleDateFormat("MM/dd/yyyy").format(new
			// Date("startDate"));

			Map<String, Object> parameters = new HashMap<String, Object>();

			parameters.put("W_companyID", Integer.parseInt(cmpnyId));
			parameters.put("W_storeID", Integer.parseInt(storeId));
			parameters.put("W_finyrID", Integer.parseInt(finYrId));
			parameters.put("W_customerID", Integer.parseInt(customerId));
			parameters.put("W_doctorID", Integer.parseInt(doctorId));
			parameters.put("W_itemID", Integer.parseInt(itemId));
			parameters.put("W_startDate", strtDt);
			parameters.put("W_endDate", endDt);
			fileName = "sale_return_summary";
			jasperFile = "sale_return_summary.jrxml";

			if (Integer.parseInt(storeId) == 0) {
				fileName = "adm_" + fileName;
				jasperFile = "adm_" + jasperFile;
			}

			if (rptType == 1) {
				// call method to generate pdf
				fileName = fileName + ".pdf";
				generatePDF(request, response, fileName, parameters, connection, jasperFile);
			} else {
				fileName = fileName + ".xlsx";
				generateXLS(request, response, fileName, parameters, connection, jasperFile);
			}

			File file = new File(request.getRealPath("/") + "/jasper/sales/" + fileName);
			InputStream is = new FileInputStream(file);
			response.reset();
			if (rptType == 1) {
				response.setHeader("Content-Type", "application/pdf");
			} else {
				response.setHeader("Content-Type", "application/vnd.ms-excel");
			}
			response.setHeader("Content-Length", String.valueOf(file.length()));
			response.setHeader("Content-Disposition", "inline; filename=\"" + fileName + "\"");
			List<Byte> buf = new ArrayList<Byte>();
			int ch = -1;
			while ((ch = is.read()) != -1) {
				buf.add((byte) ch);
			}
			byte[] array = new byte[buf.size()];
			for (int i = 0; i < buf.size(); i++) {
				array[i] = buf.get(i);
			}
			ServletOutputStream os = response.getOutputStream();
			os.write(array);
			os.flush();
			os.close();
			is.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if (em != null)
				em.close();
		}
	}

	@Path(value = "/report/sales/return/register")
	@GET
	public void getSalesReturnRegisterReport(@QueryParam(value = "cmpnyId") String cmpnyId,
			@QueryParam(value = "storeId") String storeId, @QueryParam(value = "finYrId") String finYrId,
			@QueryParam(value = "customerId") String customerId, @QueryParam(value = "doctorId") String doctorId,
			@QueryParam(value = "itemId") String itemId, @QueryParam(value = "startDate") String startDate,
			@QueryParam(value = "endDate") String endDate, 
			@QueryParam(value = "rptType") int rptType,
			@Context HttpServletRequest request,
			@Context HttpServletResponse response) {

		String fileName = null;
		Connection connection = null;
		EntityManagerFactory entityManagerFactory;
		EntityManager em = null;
		String jasperFile = null;
		try {
			String DATE_FORMAT_NEEDED = "MM/dd/yyyy";
			String DATE_FORMAT_RECEIVED = "yyyy-MM-dd";
			String convertdDateStrt = DateUtil.convertReceivedDateToNeededDateStr(DATE_FORMAT_RECEIVED,
					DATE_FORMAT_NEEDED, startDate);
			String convertdDateEnd = DateUtil.convertReceivedDateToNeededDateStr(DATE_FORMAT_RECEIVED,
					DATE_FORMAT_NEEDED, endDate);
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();

			// get connection object from entity manager
			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses.getSessionFactory();

			connection = sessionFactory.getConnectionProvider().getConnection();
			java.sql.Date strtDt = DateUtil.convertStringDateToSqlDate(convertdDateStrt, DATE_FORMAT_NEEDED);
			java.sql.Date endDt = DateUtil.convertStringDateToSqlDate(convertdDateEnd, DATE_FORMAT_NEEDED);

			Map<String, Object> parameters = new HashMap<String, Object>();

			parameters.put("W_companyID", Integer.parseInt(cmpnyId));
			parameters.put("W_storeID", Integer.parseInt(storeId));
			parameters.put("W_finyrID", Integer.parseInt(finYrId));
			parameters.put("W_customerID", Integer.parseInt(customerId));
			parameters.put("W_doctorID", Integer.parseInt(doctorId));
			parameters.put("W_itemID", Integer.parseInt(itemId));
			parameters.put("W_startDate", strtDt);
			parameters.put("W_endDate", endDt);
			fileName = "sale_return_register";
			jasperFile = "sale_return_register.jrxml";

			if (Integer.parseInt(storeId) == 0) {
				fileName = "adm_" + fileName;
				jasperFile = "adm_" + jasperFile;
			}

			if (rptType == 1) {
				// call method to generate pdf
				fileName = fileName + ".pdf";
				generatePDF(request, response, fileName, parameters, connection, jasperFile);
			} else {
				fileName = fileName + ".xlsx";
				generateXLS(request, response, fileName, parameters, connection, jasperFile);
			}

			File file = new File(request.getRealPath("/") + "/jasper/sales/" + fileName);
			InputStream is = new FileInputStream(file);
			response.reset();
			if (rptType == 1) {
				response.setHeader("Content-Type", "application/pdf");
			} else {
				response.setHeader("Content-Type", "application/vnd.ms-excel");
			}
			response.setHeader("Content-Length", String.valueOf(file.length()));
			response.setHeader("Content-Disposition", "inline; filename=\"" + fileName + "\"");
			List<Byte> buf = new ArrayList<Byte>();
			int ch = -1;
			while ((ch = is.read()) != -1) {
				buf.add((byte) ch);
			}
			byte[] array = new byte[buf.size()];
			for (int i = 0; i < buf.size(); i++) {
				array[i] = buf.get(i);
			}
			ServletOutputStream os = response.getOutputStream();
			os.write(array);
			os.flush();
			os.close();
			is.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if (em != null)
				em.close();
		}
	}

	@Path(value = "/report/ledger/customer")
	@GET
	public void getDistributorLedgerReport(@QueryParam(value = "cmpnyId") String cmpnyId,
			@QueryParam(value = "storeId") String storeId, @QueryParam(value = "finYrId") String finYrId,
			@QueryParam(value = "custId") String custId, @QueryParam(value = "startDate") String startDate,
			@QueryParam(value = "endDate") String endDate, @QueryParam(value = "status") String status,
			@QueryParam(value = "rptType") int rptType,
			@Context HttpServletRequest request, @Context HttpServletResponse response) {

		String fileName = null;
		Connection connection = null;
		EntityManagerFactory entityManagerFactory;
		EntityManager em = null;
		String jasperFile = null;
		try {
			String DATE_FORMAT_NEEDED = "MM/dd/yyyy";
			String DATE_FORMAT_RECEIVED = "yyyy-MM-dd";

			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();

			// get connection object from entity manager
			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses.getSessionFactory();

			connection = sessionFactory.getConnectionProvider().getConnection();

			Map<String, Object> parameters = new HashMap<String, Object>();

			parameters.put("W_companyID", Integer.parseInt(cmpnyId));
			parameters.put("W_storeID", Integer.parseInt(storeId));
			parameters.put("W_finyrID", Integer.parseInt(finYrId));
			parameters.put("W_customerID", Integer.parseInt(custId));
			if (!startDate.equalsIgnoreCase("null")) {
				String convertdDateStart = DateUtil.convertReceivedDateToNeededDateStr(DATE_FORMAT_RECEIVED,
						DATE_FORMAT_NEEDED, startDate);
				java.sql.Date startDate1 = DateUtil.convertStringDateToSqlDate(convertdDateStart, DATE_FORMAT_NEEDED);
				parameters.put("W_startDate", startDate1);
			} else {

				parameters.put("W_startDate", null);
			}

			if (!endDate.equalsIgnoreCase("null")) {
				String convertdDateend = DateUtil.convertReceivedDateToNeededDateStr(DATE_FORMAT_RECEIVED,
						DATE_FORMAT_NEEDED, endDate);
				java.sql.Date endDate1 = DateUtil.convertStringDateToSqlDate(convertdDateend, DATE_FORMAT_NEEDED);
				parameters.put("W_endDate", endDate1);
			} else {

				parameters.put("W_endDate", null);
			}
			parameters.put("W_status", status);
			fileName = "customer_ledger_report";
			jasperFile = "customer_ledger_report.jrxml";

			if (Integer.parseInt(storeId) == 0) {
				fileName = "adm_" + fileName;
				jasperFile = "adm_" + jasperFile;
			}

			if (rptType == 1) {
				// call method to generate pdf
				fileName = fileName + ".pdf";
				generatePDF(request, response, fileName, parameters, connection, jasperFile);
			} else {
				fileName = fileName + ".xlsx";
				generateXLS(request, response, fileName, parameters, connection, jasperFile);
			}

			File file = new File(request.getRealPath("/") + "/jasper/sales/" + fileName);
			InputStream is = new FileInputStream(file);
			response.reset();
			if (rptType == 1) {
				response.setHeader("Content-Type", "application/pdf");
			} else {
				response.setHeader("Content-Type", "application/vnd.ms-excel");
			}
			response.setHeader("Content-Length", String.valueOf(file.length()));
			response.setHeader("Content-Disposition", "inline; filename=\"" + fileName + "\"");
			List<Byte> buf = new ArrayList<Byte>();
			int ch = -1;
			while ((ch = is.read()) != -1) {
				buf.add((byte) ch);
			}
			byte[] array = new byte[buf.size()];
			for (int i = 0; i < buf.size(); i++) {
				array[i] = buf.get(i);
			}
			ServletOutputStream os = response.getOutputStream();
			os.write(array);
			os.flush();
			os.close();
			is.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if (em != null)
				em.close();
		}
	}
	
	@Path(value = "/download/salebill")
	@GET
	public void getSalesBillDownload(
			@QueryParam(value = "cmpnyId") String cmpnyId,
			@QueryParam(value = "storeId") String storeId,
			@QueryParam(value = "saleId") String saleId,
			@QueryParam(value = "isReprint") String isReprint,
			@QueryParam(value = "type") int type,
			@Context HttpServletRequest request,
			@Context HttpServletResponse response
			) {
		System.out.println("System path = "+request.getRealPath("/images"));
		String fileName = null;
		Connection connection = null;
		EntityManagerFactory entityManagerFactory;
		EntityManager em = null;
		String jasperFile = null;
		try {
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();

			// get connection object from entity manager
			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses.getSessionFactory();

			connection = sessionFactory.getConnectionProvider().getConnection();

			Map<String, Object> parameters = new HashMap<String, Object>();

			parameters.put("W_CompanyID", Integer.parseInt(cmpnyId));
			parameters.put("W_StoreID", Integer.parseInt(storeId));
			parameters.put("W_SaleID", Integer.parseInt(saleId));
			parameters.put("W_IsReprint", Integer.parseInt(isReprint));
			parameters.put("W_ReprintCount", 0);
			parameters.put("W_Logo_Path", request.getRealPath("/images"));
			parameters.put("W_Note1", "");
			parameters.put("W_Note2", "");
			fileName = "retailsalebill2100mm";
			jasperFile = "retailsalebill2100mm.jrxml";

			if (type == 1) {
				// call method to generate pdf
				fileName = fileName + ".pdf";
				generatePDF(request, response, fileName, parameters, connection, jasperFile);
			} else {
				fileName = fileName + ".xlsx";
				generateXLS(request, response, fileName, parameters, connection, jasperFile);
			}

			File file = new File(request.getRealPath("/") + "/jasper/sales/" + fileName);
			InputStream is = new FileInputStream(file);
			response.reset();
			if (type == 1) {
				response.setHeader("Content-Type", "application/pdf");
			} else {
				response.setHeader("Content-Type", "application/vnd.ms-excel");
			}
			response.setHeader("Content-Length", String.valueOf(file.length()));
			response.setHeader("Content-Disposition", "inline; filename=\"" + fileName + "\"");
			List<Byte> buf = new ArrayList<Byte>();
			int ch = -1;
			while ((ch = is.read()) != -1) {
				buf.add((byte) ch);
			}
			byte[] array = new byte[buf.size()];
			for (int i = 0; i < buf.size(); i++) {
				array[i] = buf.get(i);
			}
			ServletOutputStream os = response.getOutputStream();
			os.write(array);
			os.flush();
			os.close();
			is.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if (em != null)
				em.close();
		}
	}
	
	@Path(value = "/download/salequotation")
	@GET
	public void getSaleOrderDownload(
			@QueryParam(value = "cmpnyId") String cmpnyId,
			@QueryParam(value = "storeId") String storeId,
			@QueryParam(value = "saleOrderId") String saleOrderId,
			@QueryParam(value = "isReprint") String isReprint,
			@QueryParam(value = "type") int type,
			@Context HttpServletRequest request,
			@Context HttpServletResponse response
			) {
		String fileName = null;
		Connection connection = null;
		EntityManagerFactory entityManagerFactory;
		EntityManager em = null;
		String jasperFile = null;
		try {
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();

			// get connection object from entity manager
			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses.getSessionFactory();

			connection = sessionFactory.getConnectionProvider().getConnection();

			Map<String, Object> parameters = new HashMap<String, Object>();

			parameters.put("W_CompanyID", Integer.parseInt(cmpnyId));
			parameters.put("W_StoreID", Integer.parseInt(storeId));
			parameters.put("W_SaleOrderID", Integer.parseInt(saleOrderId));
			parameters.put("W_IsReprint", Integer.parseInt(isReprint));
			parameters.put("W_ReprintCount", 0);
			parameters.put("W_Logo_Path", request.getRealPath("/images"));
			parameters.put("W_Note1", "");
			parameters.put("W_Note2", "");
			fileName = "retailsaleorder2100mm";
			jasperFile = "retailsaleorder2100mm.jrxml";

			if (type == 1) {
				// call method to generate pdf
				fileName = fileName + ".pdf";
				generatePDF(request, response, fileName, parameters, connection, jasperFile);
			} else {
				fileName = fileName + ".xlsx";
				generateXLS(request, response, fileName, parameters, connection, jasperFile);
			}

			File file = new File(request.getRealPath("/") + "/jasper/sales/" + fileName);
			InputStream is = new FileInputStream(file);
			response.reset();
			if (type == 1) {
				response.setHeader("Content-Type", "application/pdf");
			} else {
				response.setHeader("Content-Type", "application/vnd.ms-excel");
			}
			response.setHeader("Content-Length", String.valueOf(file.length()));
			response.setHeader("Content-Disposition", "inline; filename=\"" + fileName + "\"");
			List<Byte> buf = new ArrayList<Byte>();
			int ch = -1;
			while ((ch = is.read()) != -1) {
				buf.add((byte) ch);
			}
			byte[] array = new byte[buf.size()];
			for (int i = 0; i < buf.size(); i++) {
				array[i] = buf.get(i);
			}
			ServletOutputStream os = response.getOutputStream();
			os.write(array);
			os.flush();
			os.close();
			is.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if (em != null)
				em.close();
		}
	}
	
	@Path(value = "/report/gstr3b")
	@GET
	public void gstr3bReport(
			@QueryParam(value = "cmpnyId") String cmpnyId,
			@QueryParam(value = "storeId") String storeId,
			@QueryParam(value = "finYrId") String finYrId,
			@QueryParam(value = "startDate") String startDate,
			@QueryParam(value = "endDate") String endDate,
			@Context HttpServletRequest request,
			@Context HttpServletResponse response) {

		String fileName = null;
		Connection connection = null;
		EntityManagerFactory entityManagerFactory;
		EntityManager em = null;
		String jasperFile = null;
		try {
			String DATE_FORMAT_NEEDED = "MM/dd/yyyy";
			String DATE_FORMAT_RECEIVED = "yyyy-MM-dd";

			entityManagerFactory = PersistenceListener.getEntityManager();;
			em = entityManagerFactory.createEntityManager();

			// get connection object from entity manager
			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();

			connection = sessionFactory.getConnectionProvider().getConnection();

			Map<String, Object> parameters = new HashMap<String, Object>();

			parameters.put("W_companyID", Integer.parseInt(cmpnyId));
			parameters.put("W_storeID", Integer.parseInt(storeId));
			parameters.put("W_finyrID", Integer.parseInt(finYrId));
			if (!startDate.equalsIgnoreCase("null")) {
				String convertdDateStart = DateUtil
						.convertReceivedDateToNeededDateStr(
								DATE_FORMAT_RECEIVED, DATE_FORMAT_NEEDED,
								startDate);
				java.sql.Date startDate1 = DateUtil.convertStringDateToSqlDate(
						convertdDateStart, DATE_FORMAT_NEEDED);
				parameters.put("W_startDate", startDate1);
			} else {

				parameters.put("W_startDate", null);
			}

			if (!endDate.equalsIgnoreCase("null")) {
				String convertdDateend = DateUtil
						.convertReceivedDateToNeededDateStr(
								DATE_FORMAT_RECEIVED, DATE_FORMAT_NEEDED,
								endDate);
				java.sql.Date endDate1 = DateUtil.convertStringDateToSqlDate(
						convertdDateend, DATE_FORMAT_NEEDED);
				parameters.put("W_endDate", endDate1);
			} else {

				parameters.put("W_endDate", null);
			}
			fileName = "gstr_3B.xlsx";
			jasperFile = "gstr_3B.jrxml";

			// call method to generate pdf
			generateXLS(request, response, fileName, parameters, connection,
					jasperFile);

			File file = new File(request.getRealPath("/") + "/jasper/sales/"
					+ fileName);
			InputStream is = new FileInputStream(file);
			response.reset();
			response.setHeader("Content-Type", "application/vnd.ms-excel");
			response.setHeader("Content-Length", String.valueOf(file.length()));
			response.setHeader("Content-Disposition", "inline; filename=\""
					+ fileName + "\"");
			List<Byte> buf = new ArrayList<Byte>();
			int ch = -1;
			while ((ch = is.read()) != -1) {
				buf.add((byte) ch);
			}
			byte[] array = new byte[buf.size()];
			for (int i = 0; i < buf.size(); i++) {
				array[i] = buf.get(i);
			}
			ServletOutputStream os = response.getOutputStream();
			os.write(array);
			os.flush();
			os.close();
			is.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Path(value = "/report/gstr9a")
	@GET
	public void gstr9aReport(
			@QueryParam(value = "cmpnyId") String cmpnyId,
			@QueryParam(value = "storeId") String storeId,
			@QueryParam(value = "finYrId") String finYrId,
			@QueryParam(value = "startDate") String startDate,
			@QueryParam(value = "endDate") String endDate,
			@QueryParam(value = "gstType") String gstType,
			@Context HttpServletRequest request,
			@Context HttpServletResponse response) {

		String fileName = null;
		Connection connection = null;
		EntityManagerFactory entityManagerFactory;
		EntityManager em = null;
		String jasperFile = null;
		try {
			String DATE_FORMAT_NEEDED = "MM/dd/yyyy";
			String DATE_FORMAT_RECEIVED = "yyyy-MM-dd";

			entityManagerFactory = PersistenceListener.getEntityManager();;
			em = entityManagerFactory.createEntityManager();

			// get connection object from entity manager
			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();

			connection = sessionFactory.getConnectionProvider().getConnection();

			Map<String, Object> parameters = new HashMap<String, Object>();

			parameters.put("W_companyID", Integer.parseInt(cmpnyId));
			parameters.put("W_storeID", Integer.parseInt(storeId));
			parameters.put("W_finyrID", Integer.parseInt(finYrId));
			if (!startDate.equalsIgnoreCase("null")) {
				String convertdDateStart = DateUtil
						.convertReceivedDateToNeededDateStr(
								DATE_FORMAT_RECEIVED, DATE_FORMAT_NEEDED,
								startDate);
				java.sql.Date startDate1 = DateUtil.convertStringDateToSqlDate(
						convertdDateStart, DATE_FORMAT_NEEDED);
				parameters.put("W_startDate", startDate1);
			} else {

				parameters.put("W_startDate", null);
			}

			if (!endDate.equalsIgnoreCase("null")) {
				String convertdDateend = DateUtil
						.convertReceivedDateToNeededDateStr(
								DATE_FORMAT_RECEIVED, DATE_FORMAT_NEEDED,
								endDate);
				java.sql.Date endDate1 = DateUtil.convertStringDateToSqlDate(
						convertdDateend, DATE_FORMAT_NEEDED);
				parameters.put("W_endDate", endDate1);
			} else {

				parameters.put("W_endDate", null);
			}
			//gstr 9=regular,9a=composite,9b=e commerce,9c=annual turnover above 2 crore
			if("0".equals(gstType))//for composite
			{
				fileName = "gstr_9A.xlsx";
				jasperFile = "gstr_9A.jrxml";
			}else//for regular
			{
				fileName = "gstr_9.xlsx";
				jasperFile = "gstr_9.jrxml";
			}
			

			// call method to generate pdf
			generateXLS(request, response, fileName, parameters, connection,
					jasperFile);

			File file = new File(request.getRealPath("/") + "/jasper/sales/"
					+ fileName);
			InputStream is = new FileInputStream(file);
			response.reset();
			response.setHeader("Content-Type", "application/vnd.ms-excel");
			response.setHeader("Content-Length", String.valueOf(file.length()));
			response.setHeader("Content-Disposition", "inline; filename=\""
					+ fileName + "\"");
			List<Byte> buf = new ArrayList<Byte>();
			int ch = -1;
			while ((ch = is.read()) != -1) {
				buf.add((byte) ch);
			}
			byte[] array = new byte[buf.size()];
			for (int i = 0; i < buf.size(); i++) {
				array[i] = buf.get(i);
			}
			ServletOutputStream os = response.getOutputStream();
			os.write(array);
			os.flush();
			os.close();
			is.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Path(value = "/report/gstB2B")
	@GET
	public void getGstB2BReport(@QueryParam(value = "cmpnyId") String cmpnyId,
			@QueryParam(value = "storeId") String storeId, @QueryParam(value = "finYrId") String finYrId,
			@QueryParam(value = "startDate") String startDate, @QueryParam(value = "endDate") String endDate,
			@Context HttpServletRequest request, @Context HttpServletResponse response) {

		String fileName = null;
		Connection connection = null;
		EntityManagerFactory entityManagerFactory;
		EntityManager em = null;
		String jasperFile = null;
		try {
			String DATE_FORMAT_NEEDED = "MM/dd/yyyy";
			String DATE_FORMAT_RECEIVED = "yyyy-MM-dd";
			String convertdDateStrt = DateUtil.convertReceivedDateToNeededDateStr(DATE_FORMAT_RECEIVED,
					DATE_FORMAT_NEEDED, startDate);
			String convertdDateEnd = DateUtil.convertReceivedDateToNeededDateStr(DATE_FORMAT_RECEIVED,
					DATE_FORMAT_NEEDED, endDate);
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();

			// get connection object from entity manager
			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses.getSessionFactory();

			connection = sessionFactory.getConnectionProvider().getConnection();
			// String asOnDatestr=mapper.getAsOnDate();
			java.sql.Date strtDt = DateUtil.convertStringDateToSqlDate(convertdDateStrt, DATE_FORMAT_NEEDED);
			java.sql.Date endDt = DateUtil.convertStringDateToSqlDate(convertdDateEnd, DATE_FORMAT_NEEDED);

			Map<String, Object> parameters = new HashMap<String, Object>();

			parameters.put("W_companyID", Integer.parseInt(cmpnyId));
			parameters.put("W_storeID", Integer.parseInt(storeId));
			parameters.put("W_finyrID", Integer.parseInt(finYrId));
			parameters.put("W_startDate", strtDt);
			parameters.put("W_endDate", endDt);
			fileName = "b2b_report.xlsx";
			jasperFile = "b2b_report.jrxml";

			// call method to generate xls
			generateXLS(request, response, fileName, parameters, connection, jasperFile);

			/*
			 * generatePDF(request, response, fileName, parameters, connection, jasperFile);
			 */

			File file = new File(request.getRealPath("/") + "/jasper/sales/" + fileName);
			InputStream is = new FileInputStream(file);
			response.reset();
			response.setHeader("Content-Type", "application/vnd.ms-excel");
			response.setHeader("Content-Length", String.valueOf(file.length()));
			response.setHeader("Content-Disposition", "inline; filename=\"" + fileName + "\"");
			List<Byte> buf = new ArrayList<Byte>();
			int ch = -1;
			while ((ch = is.read()) != -1) {
				buf.add((byte) ch);
			}
			byte[] array = new byte[buf.size()];
			for (int i = 0; i < buf.size(); i++) {
				array[i] = buf.get(i);
			}
			ServletOutputStream os = response.getOutputStream();
			os.write(array);
			os.flush();
			os.close();
			is.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if (em != null)
				em.close();
		}
	}

	// method to generate pdf
	public void generatePDF(HttpServletRequest request, HttpServletResponse response, String fileName,
			Map<String, Object> parameters, Connection connection, String jasperFile)
			throws FileNotFoundException, IOException {

		try {

			File file = new File(request.getRealPath("/") + "/jasper/sales/" + fileName);

			JasperReport report;

			report = JasperCompileManager.compileReport(request.getRealPath("/jasper") + "/sales/" + jasperFile);
			JasperPrint print = JasperFillManager.fillReport(report, parameters, connection);
			JasperExportManager.exportReportToPdfFile(print, request.getRealPath("/") + "/jasper/sales/" + fileName);

		}

		catch (JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

		}

		// Inform JSF that it doesn't need to handle response.
		// This is very important, otherwise you will get the following
		// exception in the logs:
		// java.lang.IllegalStateException: Cannot forward after response has
		// been committed.
		// context.responseComplete();
	}

	// Method to generate Excel report
	
	 public void generateXLS(HttpServletRequest request,
		      HttpServletResponse response, String fileName,
		      Map<String, Object> parameters, Connection connection,
		      String jasperFile) throws FileNotFoundException, IOException {

		    
		    try {
		      JasperReport report = JasperCompileManager.compileReport(request.getSession().getServletContext().getRealPath("/jasper"+ "/sales/" + jasperFile));
		      JasperPrint print = JasperFillManager.fillReport(report, parameters, connection);
		      
		      File xlsxFile = new File(request.getSession().getServletContext().getRealPath("/" + "/jasper/sales/" + fileName));
		      JRXlsxExporter xlsxExporter = new JRXlsxExporter();
		      
		      xlsxExporter.setExporterInput(new SimpleExporterInput(print));
	          xlsxExporter.setExporterOutput(new SimpleOutputStreamExporterOutput(xlsxFile));
		      
		      SimpleXlsxReportConfiguration configuration = new SimpleXlsxReportConfiguration(); 
		      configuration.setDetectCellType(true);
		      configuration.setCollapseRowSpan(false);
		      xlsxExporter.setConfiguration(configuration);
		      
		      /*xlsxExporter.setParameter(net.sf.jasperreports.engine.export.JRXlsExporterParameter.JASPER_PRINT, print);
		      xlsxExporter.setParameter(net.sf.jasperreports.engine.export.JRXlsExporterParameter.OUTPUT_FILE, xlsxFile);
		      xlsxExporter.setParameter(net.sf.jasperreports.engine.export.JRXlsExporterParameter.IS_DETECT_CELL_TYPE, Boolean.TRUE);*/
		      
		      xlsxExporter.exportReport(); //File is generated Correctly
		    }
		    catch (JRException e) {
		      // TODO Auto-generated catch block
		      e.printStackTrace();
		    } finally {

		    }
		  }
	

	public SalesService getSalesService() {
		return salesService;
	}

	public void setSalesService(SalesService salesService) {
		this.salesService = salesService;
	}

}
