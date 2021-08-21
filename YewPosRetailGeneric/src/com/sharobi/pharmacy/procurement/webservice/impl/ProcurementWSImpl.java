package com.sharobi.pharmacy.procurement.webservice.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
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
import javax.ws.rs.core.MediaType;

import org.hibernate.Session;
import org.hibernate.internal.SessionFactoryImpl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.sharobi.pharmacy.common.CommonResultSetMapper;
import com.sharobi.pharmacy.common.PersistenceListener;
import com.sharobi.pharmacy.common.PurchaseInvoiceExcelDTO;
import com.sharobi.pharmacy.common.ReturnConstant;
import com.sharobi.pharmacy.common.model.ResponseObj;
import com.sharobi.pharmacy.commonutil.DateUtil;
import com.sharobi.pharmacy.procurement.model.DistributorPayment;
import com.sharobi.pharmacy.procurement.model.PaymentDetailsAllDTO;
import com.sharobi.pharmacy.procurement.model.PaymentDetailsByIdDTO;
import com.sharobi.pharmacy.procurement.model.Purchase;
import com.sharobi.pharmacy.procurement.model.PurchaseChallanReturnDTO;
import com.sharobi.pharmacy.procurement.model.PurchaseDetails;
import com.sharobi.pharmacy.procurement.model.PurchaseDetailsForReturnDTO;
import com.sharobi.pharmacy.procurement.model.PurchaseHistoryDTO;
import com.sharobi.pharmacy.procurement.model.PurchaseInv;
import com.sharobi.pharmacy.procurement.model.PurchaseInvDetailsDTO;
import com.sharobi.pharmacy.procurement.model.PurchaseInvHeaderDTO;
import com.sharobi.pharmacy.procurement.model.PurchaseOrder;
import com.sharobi.pharmacy.procurement.model.PurchaseOrderDTO;
import com.sharobi.pharmacy.procurement.model.PurchaseOrderDetailsDTO;
import com.sharobi.pharmacy.procurement.model.PurchaseOrderQtyDTO;
import com.sharobi.pharmacy.procurement.model.PurchaseReturn;
import com.sharobi.pharmacy.procurement.model.PurchaseReturnDTO;
import com.sharobi.pharmacy.procurement.model.PurchaseReturnDetailsDTO;
import com.sharobi.pharmacy.procurement.service.ProcurementService;
import com.sharobi.pharmacy.procurement.webservice.ProcurementWS;
import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataParam;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimpleXlsxReportConfiguration;

/**
 * rajarshi
 */
@Path(value = "/procurement")
public class ProcurementWSImpl implements ProcurementWS {

	private ProcurementService procurementService = new ProcurementService();
	@Context HttpServletRequest request;

	public ProcurementWSImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	@Path(value = "/getPurchaseInvoice")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String getPurchase(CommonResultSetMapper mapper) {
		Purchase purchase = null;

		try {

			purchase = procurementService.getPurchase(mapper);

		} catch (Exception x) {
			x.printStackTrace();

		}
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		String json = gson.toJson(purchase, Purchase.class);

		return json;
	}
	
	@Path(value = "/getDuplicateBill")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String getDuplicateBill(CommonResultSetMapper mapper) {
		String status = "";
		//System.out.println("getDuplicateBill : "+mapper);
		try {
			status = procurementService.getDuplicateBill(mapper);
		} catch (Exception x) {
			x.printStackTrace();
		}

		return "" + status;
	}
	
	@Path(value = "/postAllPurchase")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String postAllPurchase(Purchase purchase) {
		String status = "";
		try {
			status = procurementService.postAllPurchase(purchase);
		} catch (Exception x) {
			x.printStackTrace();
		}

		return "" + status;
	}

	@Override
	@Path(value = "/getAllPurchaseInvoice")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String getAllPurchase(CommonResultSetMapper mapper) {
		//System.out.println("getAllPurchaseInvoice mapper = "+mapper);
		List<Purchase> details = null;

		try {

			details = procurementService.getAllPurchase(mapper);

		} catch (Exception x) {
			x.printStackTrace();

		}
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		java.lang.reflect.Type type = new TypeToken<List<Purchase>>() {
		}.getType();
		String json = gson.toJson(details, type);
		return json;
	}
	
	@Override
	@Path(value = "/getPurchaseInvoiceDetailsById")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String getPurchaseDetailsById(CommonResultSetMapper mapper) {
		List<PurchaseDetails> details = null;

		try {

			details = procurementService.getPurchaseDetailsById(mapper);

		} catch (Exception x) {
			x.printStackTrace();

		}
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		java.lang.reflect.Type type = new TypeToken<List<PurchaseDetails>>() {
		}.getType();
		String json = gson.toJson(details, type);
		return json;
	}
	
	@Override
	@Path(value = "/getLastPurchaseInvoiceDetailsByDistId")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String getLastPurchaseInvoiceDetailsByDistId(CommonResultSetMapper mapper) {
		List<PurchaseDetails> details = null;

		try {

			details = procurementService.getLastPurchaseInvoiceDetailsByDistId(mapper);

		} catch (Exception x) {
			x.printStackTrace();

		}
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		java.lang.reflect.Type type = new TypeToken<List<PurchaseDetails>>() {
		}.getType();
		String json = gson.toJson(details, type);
		return json;
	}
	
	@Override
	@Path(value = "/getPurchaseInvoiceDetailsByItemId")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String getPurchaseInvoiceDetailsByItemId(CommonResultSetMapper mapper) {
		List<PurchaseDetails> details = null;

		try {

			details = procurementService.getPurchaseInvoiceDetailsByItemId(mapper);

		} catch (Exception x) {
			x.printStackTrace();

		}
		Gson gson = new GsonBuilder().serializeNulls().excludeFieldsWithoutExposeAnnotation()
				.create();
		java.lang.reflect.Type type = new TypeToken<List<PurchaseDetails>>() {
		}.getType();
		String json = gson.toJson(details, type);
		//System.out.println("getPurchaseInvoiceDetailsByItemId response = "+json);
		return json;
	}
	
	@Override
	@Path(value = "/getPurchaseInvoiceDetailsByItemSku")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String getPurchaseInvoiceDetailsByItemSku(CommonResultSetMapper mapper) {
		List<PurchaseDetails> details = null;

		try {

			details = procurementService.getPurchaseInvoiceDetailsByItemSku(mapper);

		} catch (Exception x) {
			x.printStackTrace();

		}
		Gson gson = new GsonBuilder().serializeNulls().excludeFieldsWithoutExposeAnnotation()
				.create();
		java.lang.reflect.Type type = new TypeToken<List<PurchaseDetails>>() {
		}.getType();
		String json = gson.toJson(details, type);
		
		//System.out.println("/getPurchaseInvoiceDetailsByItemSku response = "+json);
		return json;
	}
	
	@Override
	@Path(value = "/createOrUpdatePurchaseInvoice")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String createOrUpdatePurchaseInvoice(Purchase purchase) {
		String status = "";
		//System.out.println("client IP:: "+ request.getRemoteAddr());
		try {
			status = procurementService.createOrUpdatePurchaseInvoice(purchase);
		} catch (Exception x) {
			x.printStackTrace();
		}

		return "" + status;
	}
	
	@Override
	@Path(value = "/createOrUpdatePurchaseOrder")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String createOrUpdatePurchaseOrder(PurchaseOrder purchaseOrder) {
		ResponseObj responseObj = new ResponseObj();
		try {
			responseObj = procurementService.createOrUpdatePurchaseOrder(purchaseOrder);
		} catch (Exception x) {
			x.printStackTrace();
			responseObj.setStatus(ReturnConstant.FAILURE);
			responseObj.setId(0);
			responseObj.setReason("Record not saved successfully.");
		}

		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		String json = gson.toJson(responseObj, ResponseObj.class);
		return json;
	}
	
	@Override
	@Path(value = "/postPurchaseInvoice") //for purchase challan
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String postPurchaseInvoice(CommonResultSetMapper mapper) {
		String status = "";
		try {
			status = procurementService.postPurchaseInvoice(mapper);
		} catch (Exception x) {
			x.printStackTrace();
		}

		return "" + status;
	}
	
	@Override
	@Path(value = "/postPurchaseInvoiceDirIndir") //for purchase invoice
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String postPurchaseInvoiceDirIndir(CommonResultSetMapper mapper) {
		String status = "";
		try {
			status = procurementService.postPurchaseInvoiceDirIndir(mapper);
		} catch (Exception x) {
			x.printStackTrace();
		}

		return "" + status;
	}
	
	
	@Path(value = "/postPurchaseOrder")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String postPurchaseOrder(CommonResultSetMapper mapper) {
		ResponseObj responseObj = new ResponseObj();
		try {
			responseObj = procurementService.postPurchaseOrder(mapper);
		} catch (Exception x) {
			x.printStackTrace();
			responseObj.setStatus(ReturnConstant.FAILURE);
			responseObj.setId(0);
			responseObj.setReason("Data not posted successfully.");
		}

		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		String json = gson.toJson(responseObj, ResponseObj.class);
		return json;
	}
	
	@Path(value = "/closePurchaseOrder")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String closePurchaseOrder(CommonResultSetMapper mapper) {
		ResponseObj responseObj = new ResponseObj();
		try {
			responseObj = procurementService.closePurchaseOrder(mapper);
		} catch (Exception x) {
			x.printStackTrace();
			responseObj.setStatus(ReturnConstant.FAILURE);
			responseObj.setId(0);
			responseObj.setReason("PO not closed successfully.");
		}

		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		String json = gson.toJson(responseObj, ResponseObj.class);
		return json;
	}
	
	
	@Path(value = "/assignTaxToItem")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String assignTaxToItem(CommonResultSetMapper mapper) {
		ResponseObj responseObj = new ResponseObj();
		try {
			responseObj = procurementService.assignTaxToItem(mapper);
		} catch (Exception x) {
			x.printStackTrace();
			responseObj.setStatus(ReturnConstant.FAILURE);
			responseObj.setId(0);
			responseObj.setReason("Record not saved successfully.");
		}

		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		String json = gson.toJson(responseObj, ResponseObj.class);
		return json;
	}
	
	@Override
	@Path(value = "/postPurchaseReturn")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String postPurchaseReturn(CommonResultSetMapper mapper) {
		String status = "";
		try {
			status = procurementService.postPurchaseReturn(mapper);
		} catch (Exception x) {
			x.printStackTrace();
		}

		return "" + status;
	}
	
	//for delete purchase challan
	@Override
	@Path(value = "/deletePurchaseInvoice")
	@POST
	@Consumes("application/json")
	@Produces("text/plain")
	public String deletePurchaseInvoice(CommonResultSetMapper mapper) {
		String status = "";
		try {
			status = procurementService.deletePurchaseInvoice(mapper);

		} catch (Exception x) {
			status = ""+0;
			x.printStackTrace();
		}

		return status;
	}
	
	@Path(value = "/deletePurchaseOrder")
	@POST
	@Consumes("application/json")
	@Produces("text/plain")
	public String deletePurchaseOrder(CommonResultSetMapper mapper) {
		ResponseObj responseObj=new ResponseObj();
		try {
			responseObj = procurementService.deletePurchaseOrder(mapper);

		} catch (Exception x) {
			x.printStackTrace();
			responseObj.setStatus(ReturnConstant.FAILURE);
			responseObj.setId(0);
			responseObj.setReason("PO not deleted successfully.");
		}

		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		String json = gson.toJson(responseObj, ResponseObj.class);
		return json;
	}
	
	@Override
	@Path(value = "/deletePurchaseReturn")
	@POST
	@Consumes("application/json")
	@Produces("text/plain")
	public String deletePurchaseReturn(CommonResultSetMapper mapper) {
		String status = "";
		try {
			status = procurementService.deletePurchaseReturn(mapper);

		} catch (Exception x) {
			status = ""+0;
			x.printStackTrace();
		}

		return status;
	}
	
	@Override
	@Path(value = "/getPurchaseReturnHeaderById")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String getPurchaseReturnHeaderById(CommonResultSetMapper mapper) {
		PurchaseReturnDTO purchase = null;

		try {

			purchase = procurementService.getPurchaseReturnHeaderById(mapper);

		} catch (Exception x) {
			x.printStackTrace();

		}
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		String json = gson.toJson(purchase, PurchaseReturnDTO.class);

		return json;
	}
	
	@Override
	@Path(value = "/getAllPurchaseOrderDetails")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String getAllPurchaseOrderDetails(CommonResultSetMapper mapper) {
		List<PurchaseOrderDTO> purchase = null;

		try {

			purchase = procurementService.getAllPurchaseOrderDetails(mapper);

		} catch (Exception x) {
			x.printStackTrace();

		}
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		java.lang.reflect.Type type = new TypeToken<List<PurchaseOrderDTO>>() {
		}.getType();
		String json = gson.toJson(purchase, type);
		return json;
	}
	
	@Override
	@Path(value = "/getPurchaseOrderHeaderById")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String getPurchaseOrderHeaderById(CommonResultSetMapper mapper) {
		PurchaseOrderDTO purchase = null;

		try {

			purchase = procurementService.getPurchaseOrderHeaderById(mapper);

		} catch (Exception x) {
			x.printStackTrace();

		}
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		String json = gson.toJson(purchase, PurchaseOrderDTO.class);

		return json;
	}
	
	@POST
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Produces(MediaType.TEXT_PLAIN)
	@Path(value = "/uploadPurInv")
	public String uploadPurInv(
			@FormDataParam("file") InputStream fileInputStream,
			@FormDataParam("file") FormDataContentDisposition cdh,
			@FormDataParam("purchaseInvoiceExcelDTO") PurchaseInvoiceExcelDTO purchaseInvoiceExcelDTO ) {

		String status = "";
		try {
			status=procurementService.uploadPurInv(fileInputStream,purchaseInvoiceExcelDTO);

		} catch (Exception ex) {
			status = "0";
		}
		return status;
	}
	
	@Override
	@Path(value = "/getPurchaseOrderDetailsById")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String getPurchaseOrderDetailsById(CommonResultSetMapper mapper) {
		List<PurchaseOrderDetailsDTO> purchase = null;

		try {

			purchase = procurementService.getPurchaseOrderDetailsById(mapper);

		} catch (Exception x) {
			x.printStackTrace();

		}
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		java.lang.reflect.Type type = new TypeToken<List<PurchaseOrderDetailsDTO>>() {
		}.getType();
		String json = gson.toJson(purchase, type);
		return json;
	}
	
	
	@Path(value = "/getPendingPurchaseOrderDetails")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String getPendingPurchaseOrderDetails(CommonResultSetMapper mapper) {
		List<PurchaseOrderDetailsDTO> purchase = null;

		try {

			purchase = procurementService.getPendingPurchaseOrderDetails(mapper);

		} catch (Exception x) {
			x.printStackTrace();

		}
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		java.lang.reflect.Type type = new TypeToken<List<PurchaseOrderDetailsDTO>>() {
		}.getType();
		String json = gson.toJson(purchase, type);
		return json;
	}
	
	
	@Path(value = "/generatePurchaseOrderByType")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String generatePurchaseOrderByType(CommonResultSetMapper mapper) {
		List<PurchaseOrderDetailsDTO> purchase = null;

		try {

			purchase = procurementService.generatePurchaseOrderByType(mapper);

		} catch (Exception x) {
			x.printStackTrace();

		}
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		java.lang.reflect.Type type = new TypeToken<List<PurchaseOrderDetailsDTO>>() {
		}.getType();
		String json = gson.toJson(purchase, type);
		return json;
	}
	
	@Override
	@Path(value = "/getPurchaseReturnHeaderAll")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String getPurchaseReturnHeaderAll(CommonResultSetMapper mapper) {
		List<PurchaseReturnDTO> list = null;

		try {

			list = procurementService.getPurchaseReturnHeaderAll(mapper);

		} catch (Exception x) {
			x.printStackTrace();

		}
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		java.lang.reflect.Type type = new TypeToken<List<PurchaseReturnDTO>>() {
		}.getType();
		String json = gson.toJson(list, type);
		return json;
	}
	
	@Override
	@Path(value = "/getPurchaseDetailsForReturnByInv")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String getPurchaseDetailsForReturnByInv(CommonResultSetMapper mapper) {
		List<PurchaseDetailsForReturnDTO> list = null;

		try {

			list = procurementService.getPurchaseDetailsForReturnByInv(mapper);

		} catch (Exception x) {
			x.printStackTrace();

		}
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		java.lang.reflect.Type type = new TypeToken<List<PurchaseDetailsForReturnDTO>>() {
		}.getType();
		String json = gson.toJson(list, type);
		return json;
	}
	
	@Override
	@Path(value = "/getPurchaseDetailsForReturnByItem")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String getPurchaseDetailsForReturnByItem(CommonResultSetMapper mapper) {
		List<PurchaseDetailsForReturnDTO> list = null;

		try {

			list = procurementService.getPurchaseDetailsForReturnByItem(mapper);

		} catch (Exception x) {
			x.printStackTrace();

		}
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		java.lang.reflect.Type type = new TypeToken<List<PurchaseDetailsForReturnDTO>>() {
		}.getType();
		String json = gson.toJson(list, type);
		return json;
	}
	
	
	@Path(value = "/getPurchaseDetailsForReturnBySku")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String getPurchaseDetailsForReturnBySku(CommonResultSetMapper mapper) {
		List<PurchaseDetailsForReturnDTO> list = null;

		try {

			list = procurementService.getPurchaseDetailsForReturnBySku(mapper);

		} catch (Exception x) {
			x.printStackTrace();

		}
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		java.lang.reflect.Type type = new TypeToken<List<PurchaseDetailsForReturnDTO>>() {
		}.getType();
		String json = gson.toJson(list, type);
		return json;
	}
	
	@Override
	@Path(value = "/getPurchaseReturnDetailsById")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String getPurchaseReturnDetailsById(CommonResultSetMapper mapper) {
		List<PurchaseReturnDetailsDTO> purchase = null;

		try {

			purchase = procurementService.getPurchaseReturnDetailsById(mapper);

		} catch (Exception x) {
			x.printStackTrace();

		}
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		java.lang.reflect.Type type = new TypeToken<List<PurchaseReturnDetailsDTO>>() {
		}.getType();
		String json = gson.toJson(purchase, type);
		return json;
	}
	
	@Override
	@Path(value = "/createOrUpdatePurchaseReturn")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String createOrUpdatePurchaseReturn(PurchaseReturn purchase) {
		String status = "";
		try {
			status = procurementService.createOrUpdatePurchaseReturn(purchase);
		} catch (Exception x) {
			x.printStackTrace();
		}

		return "" + status;
	}
	
	@Override
	@Path(value = "/getPaymentsDetailsAll")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String getPaymentsDetailsAll(CommonResultSetMapper mapper) {
		List<PaymentDetailsAllDTO> list = null;

		try {

			list = procurementService.getPaymentsDetailsAll(mapper);

		} catch (Exception x) {
			x.printStackTrace();

		}
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		java.lang.reflect.Type type = new TypeToken<List<PaymentDetailsAllDTO>>() {
		}.getType();
		String json = gson.toJson(list, type);
		return json;
	}
	
	@Override
	@Path(value = "/getPaymentHeaderById")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String getPaymentHeaderById(CommonResultSetMapper mapper) {
		PaymentDetailsAllDTO payment = null;

		try {

			payment = procurementService.getPaymentHeaderById(mapper);

		} catch (Exception x) {
			x.printStackTrace();

		}
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		String json = gson.toJson(payment, PaymentDetailsAllDTO.class);

		return json;
	}
	
	
	@Path(value = "/getPurchaseOrderQty")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String getPurchaseOrderQty(CommonResultSetMapper mapper) {
		PurchaseOrderQtyDTO purchaseOrderQtyDTO = null;

		try {

			purchaseOrderQtyDTO = procurementService.getPurchaseOrderQty(mapper);

		} catch (Exception x) {
			x.printStackTrace();

		}
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		String json = gson.toJson(purchaseOrderQtyDTO, PurchaseOrderQtyDTO.class);

		return json;
	}
	
	@Override
	@Path(value = "/getPaymentsDetailsById")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String getPaymentsDetailsById(CommonResultSetMapper mapper) {
		List<PaymentDetailsByIdDTO> list = null;

		try {

			list = procurementService.getPaymentsDetailsById(mapper);

		} catch (Exception x) {
			x.printStackTrace();

		}
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		java.lang.reflect.Type type = new TypeToken<List<PaymentDetailsByIdDTO>>() {
		}.getType();
		String json = gson.toJson(list, type);
		return json;
	}
	
	@Override
	@Path(value = "/getPendingPaymentBySupplier")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String getPendingPaymentBySupplier(CommonResultSetMapper mapper) {
		List<PaymentDetailsByIdDTO> list = null;

		try {

			list = procurementService.getPendingPaymentBySupplier(mapper);

		} catch (Exception x) {
			x.printStackTrace();

		}
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		java.lang.reflect.Type type = new TypeToken<List<PaymentDetailsByIdDTO>>() {
		}.getType();
		String json = gson.toJson(list, type);
		return json;
	}
	
	@Override
	@Path(value = "/createOrUpdateDistributorPayment")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String createOrUpdateDistributorPayment(DistributorPayment distributorPayment) {
		String status = "";
		try {
			status = procurementService.createOrUpdateDistributorPayment(distributorPayment);
		} catch (Exception x) {
			x.printStackTrace();
		}

		return "" + status;
	}
	
	@Override
	@Path(value = "/postDistributorPayment")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String postDistributorPayment(CommonResultSetMapper mapper) {
		String status = "";
		try {
			status = procurementService.postDistributorPayment(mapper);
		} catch (Exception x) {
			x.printStackTrace();
		}

		return "" + status;
	}
	
	@Override
	@Path(value = "/deleteDistributorPayment")
	@POST
	@Consumes("application/json")
	@Produces("text/plain")
	public String deleteDistributorPayment(CommonResultSetMapper mapper) {
		String status = "";
		try {
			status = procurementService.deleteDistributorPayment(mapper);

		} catch (Exception x) {
			status = ""+0;
			x.printStackTrace();
		}

		return status;
	}
	
	@Override
	@Path(value = "/getAdjPurchaseReturn")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String getAdjPurchaseReturn(CommonResultSetMapper mapper) {
		List<PurchaseReturnDTO> purchaseReturnAdjDTOs = null;

		try {

			purchaseReturnAdjDTOs = procurementService.getAdjPurchaseReturn(mapper);

		} catch (Exception x) {
			x.printStackTrace();

		}
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		java.lang.reflect.Type type = new TypeToken<List<PurchaseReturnDTO>>() {
		}.getType();
		String json = gson.toJson(purchaseReturnAdjDTOs, type);
		return json;
	}
	
	@Override
	@Path(value = "/getAdjPurchaseReturnByPurchaseId")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String getAdjPurchaseReturnByPurchaseId(CommonResultSetMapper mapper) {
		List<PurchaseReturnDTO> purchaseReturnAdjDTOs = null;

		try {

			purchaseReturnAdjDTOs = procurementService.getAdjPurchaseReturnByPurchaseId(mapper);

		} catch (Exception x) {
			x.printStackTrace();

		}
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		java.lang.reflect.Type type = new TypeToken<List<PurchaseReturnDTO>>() {
		}.getType();
		String json = gson.toJson(purchaseReturnAdjDTOs, type);
		return json;
	}
	
	@Override
	@Path(value = "/getPurchaseHistoryByItem")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String getPurchaseHistoryByItem(CommonResultSetMapper mapper) {
		List<PurchaseHistoryDTO> details = null;

		try {

			details = procurementService.getPurchaseHistoryByItem(mapper);

		} catch (Exception x) {
			x.printStackTrace();

		}
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		java.lang.reflect.Type type = new TypeToken<List<PurchaseHistoryDTO>>() {
		}.getType();
		String json = gson.toJson(details, type);
		return json;
	}
	
	@Override
	@Path(value = "/getPurchaseHistoryByItemIdBatch")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String getPurchaseHistoryByItemIdBatch(CommonResultSetMapper mapper) {
		List<PurchaseHistoryDTO> details = null;

		try {

			details = procurementService.getPurchaseHistoryByItemIdBatch(mapper);

		} catch (Exception x) {
			x.printStackTrace();

		}
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		java.lang.reflect.Type type = new TypeToken<List<PurchaseHistoryDTO>>() {
		}.getType();
		String json = gson.toJson(details, type);
		return json;
	}
	
	@Path(value = "/insertTempPurchaseFromSale")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String insertTempPurchaseFromSale(CommonResultSetMapper mapper) {
		ResponseObj responseObj = new ResponseObj();
		try {
			responseObj = procurementService.insertTempPurchaseFromSale(mapper);
		} catch (Exception x) {
			x.printStackTrace();
			responseObj.setStatus(ReturnConstant.FAILURE);
			responseObj.setId(0);
			responseObj.setReason("Record not saved successfully.");
		}

		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		String json = gson.toJson(responseObj, ResponseObj.class);
		return json;
	}
	
	
	/*New Services start for purchase challan */
	
	@Override
	@Path(value = "/createOrUpdatePurchaseInvoiceDirect")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String createOrUpdatePurchaseInvoiceDirect(PurchaseInv purchaseinv) {
		String status = "";
		//System.out.println("client IP:: "+ request.getRemoteAddr());
		try {
			status = procurementService.createOrUpdatePurchaseInvoiceDirect(purchaseinv);
		} catch (Exception x) {
			x.printStackTrace();
		}

		return "" + status;
	}
	
	@Override
	@Path(value = "/createOrUpdatePurchaseInvoiceIndirect")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String createOrUpdatePurchaseInvoiceIndirect(PurchaseInv purchaseinv) {
		String status = "";
		//System.out.println("client IP:: "+ request.getRemoteAddr());
		try {
			status = procurementService.createOrUpdatePurchaseInvoiceIndirect(purchaseinv);
		} catch (Exception x) {
			x.printStackTrace();
		}

		return "" + status;
	}
	
	@Override
	@Path(value = "/getAllPendingPurchaseChallan")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String getAllPendingPurchaseChallan(CommonResultSetMapper mapper) {
		
		//System.out.println("getAllPendingPurchaseChallan:: "+mapper.toString());
		List<PurchaseChallanReturnDTO> list = null;

		try {

			list = procurementService.getAllPendingPurchaseChallan(mapper);

		} catch (Exception x) {
			x.printStackTrace();

		}
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		java.lang.reflect.Type type = new TypeToken<List<PaymentDetailsByIdDTO>>() {
		}.getType();
		String json = gson.toJson(list, type);
		//System.out.println("getAllPendingPurchaseChallan return "+json);
		return json;
	}
	
	@Override
	@Path(value = "/getPurchaseChallanListByInvID")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String getPurchaseChallanListByInvID(CommonResultSetMapper mapper) {
		
		//System.out.println("getAllPendingPurchaseChallan:: "+mapper.toString());
		List<PurchaseChallanReturnDTO> list = null;

		try {

			list = procurementService.getPurchaseChallanListByInvID(mapper);

		} catch (Exception x) {
			x.printStackTrace();

		}
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		java.lang.reflect.Type type = new TypeToken<List<PaymentDetailsByIdDTO>>() {
		}.getType();
		String json = gson.toJson(list, type);
		//System.out.println("getAllPendingPurchaseChallan return "+json);
		return json;
	}
	
	//For direct purchase
	@Override
	@Path(value = "/getPurchaseInvDetailsById")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String getPurchaseInvDetailsById(CommonResultSetMapper mapper) {
		List<PurchaseInvDetailsDTO> purchase = null;

		try {

			purchase = procurementService.getPurchaseInvDetailsById(mapper);

		} catch (Exception x) {
			x.printStackTrace();

		}
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		java.lang.reflect.Type type = new TypeToken<List<PurchaseInvDetailsDTO>>() {
		}.getType();
		String json = gson.toJson(purchase, type);
		//System.out.println("getPurchaseInvDetailsById Return List:: "+json.toString());
		return json;
	}
	
	@Override
	@Path(value = "/getAllPurchaseInvoiceDetails")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String getAllPurchaseInvoiceDetails(CommonResultSetMapper mapper) {
		List<PurchaseChallanReturnDTO> purchase = null;

		try {

			purchase = procurementService.getAllPurchaseInvoiceDetails(mapper);

		} catch (Exception x) {
			x.printStackTrace();

		}
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		java.lang.reflect.Type type = new TypeToken<List<PurchaseOrderDTO>>() {
		}.getType();
		String json = gson.toJson(purchase, type);
		return json;
	}
	
	@Override
	@Path(value = "/getPurchaseInvHeaderByID")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String getPurchaseInvHeaderByID(CommonResultSetMapper mapper) {
		
			PurchaseInvHeaderDTO purchase = null;

			try {
				//System.out.println("PurchaseOrderId:: "+mapper.getPurchaseOrderId());

				purchase = procurementService.getPurchaseInvHeaderByID(mapper);

			} catch (Exception x) {
				x.printStackTrace();

			}
			Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
					.create();
			String json = gson.toJson(purchase, PurchaseInvHeaderDTO.class);
			//for list return
			/*Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
			java.lang.reflect.Type type = new TypeToken<PurchaseInvHeaderDTO>() {
			}.getType();
			String json = gson.toJson(purchase, type);*/
			//System.out.println("getPurchaseInvHeaderByID Return List:: "+json.toString());
			return json;
		}
	@Override
	@Path(value = "/getPurchaseDetailsbyPurchaseIDs")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String getPurchaseDetailsByPurchaseIDs(CommonResultSetMapper mapper) {
		List<PurchaseDetails> details = null;

		try {
			//System.out.println("PurchaseIds:: "+mapper.getPurchaseIds());

			details = procurementService.getPurchaseDetailsByPurchaseIDs(mapper);

		} catch (Exception x) {
			x.printStackTrace();

		}
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		java.lang.reflect.Type type = new TypeToken<List<PurchaseDetails>>() {
		}.getType();
		String json = gson.toJson(details, type);
		//System.out.println("Return List::"+json.toString());
		return json;
	}
	
	@Path(value = "/postAllPurchaseInvoice")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String postAllPurchaseInvoice(Purchase purchase) {
		String status = "";
		try {
			status = procurementService.postAllPurchaseInvoice(purchase);
		} catch (Exception x) {
			x.printStackTrace();
		}

		return "" + status;
	}
	
	
	//For purchase Invoice
	@Override
	@Path(value = "/deletePurchase")
	@POST
	@Consumes("application/json")
	@Produces("text/plain")
	public String deletePurchase(CommonResultSetMapper mapper) {
		String status = "";
		try {
			status = procurementService.deletePurchase(mapper);

		} catch (Exception x) {
			status = ""+0;
			x.printStackTrace();
		}

		return status;
	}
	
	/*New Services end*/
	
	@Path(value = "/report/purchase")
	@GET
	public void getPurchaseSummaryReport(@QueryParam(value = "cmpnyId") String cmpnyId,
			@QueryParam(value = "storeId") String storeId,
			@QueryParam(value = "finYrId") String finYrId,
			@QueryParam(value = "distributorId") String distributorId,
			@QueryParam(value = "startDate") String startDate,
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
			String convertdDateStrt=DateUtil.convertReceivedDateToNeededDateStr(DATE_FORMAT_RECEIVED,DATE_FORMAT_NEEDED,startDate);
			String convertdDateEnd=DateUtil.convertReceivedDateToNeededDateStr(DATE_FORMAT_RECEIVED,DATE_FORMAT_NEEDED,endDate);
			java.sql.Date strtDt= DateUtil.convertStringDateToSqlDate(convertdDateStrt, DATE_FORMAT_NEEDED);
			java.sql.Date endDt= DateUtil.convertStringDateToSqlDate(convertdDateEnd, DATE_FORMAT_NEEDED);
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();

			// get connection object from entity manager
			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();

			connection = sessionFactory.getConnectionProvider().getConnection();
			

			Map<String, Object> parameters = new HashMap<String,Object>();

			parameters.put("W_companyID", Integer.parseInt(cmpnyId));
			parameters.put("W_storeID", Integer.parseInt(storeId));
			parameters.put("W_finyrID", Integer.parseInt(finYrId));
			parameters.put("W_distributorID", Integer.parseInt(distributorId));
			parameters.put("W_startDate", strtDt);
			parameters.put("W_endDate", endDt);
			fileName = "purchase_summary";
			jasperFile = "purchase_summary.jrxml";
			
			if(Integer.parseInt(storeId) == 0) {
				fileName = "adm_"+fileName;
				jasperFile = "adm_"+jasperFile;
			}

			if (rptType == 1) {
				fileName = fileName + ".pdf";
				generatePDF(request, response, fileName, parameters, connection, jasperFile);
			} else {
				fileName = fileName + ".xlsx";
				generateXLSX(request, response, fileName, parameters, connection, jasperFile);
			}

			File file = new File(request.getRealPath("/") + "/jasper/procurement/"
					+ fileName);
			InputStream is = new FileInputStream(file);
			response.reset();
			if (rptType == 1) {
				response.setHeader("Content-Type", "application/pdf");
			} else {
				response.setHeader("Content-Type", "application/vnd.ms-excel");
			}
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
    finally {
      try {
        if(connection != null) connection.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
      if(em != null) em.close();
    }
	}
	
	@Path(value = "/report/po/adjustment")
	@GET
	public void getPurchaseOrderWithAdjReport(@QueryParam(value = "cmpnyId") String cmpnyId,
			@QueryParam(value = "storeId") String storeId,
			@QueryParam(value = "finYrId") String finYrId,
			@QueryParam(value = "distributorId") String distributorId,
			@QueryParam(value = "startDate") String startDate,
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
			String convertdDateStrt=DateUtil.convertReceivedDateToNeededDateStr(DATE_FORMAT_RECEIVED,DATE_FORMAT_NEEDED,startDate);
			String convertdDateEnd=DateUtil.convertReceivedDateToNeededDateStr(DATE_FORMAT_RECEIVED,DATE_FORMAT_NEEDED,endDate);
			java.sql.Date strtDt= DateUtil.convertStringDateToSqlDate(convertdDateStrt, DATE_FORMAT_NEEDED);
			java.sql.Date endDt= DateUtil.convertStringDateToSqlDate(convertdDateEnd, DATE_FORMAT_NEEDED);
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();

			// get connection object from entity manager
			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();

			connection = sessionFactory.getConnectionProvider().getConnection();
			

			Map<String, Object> parameters = new HashMap<String,Object>();

			parameters.put("W_companyID", Integer.parseInt(cmpnyId));
			parameters.put("W_storeID", Integer.parseInt(storeId));
			parameters.put("W_finyrID", Integer.parseInt(finYrId));
			parameters.put("W_distributorID", Integer.parseInt(distributorId));
			parameters.put("W_startDate", strtDt);
			parameters.put("W_endDate", endDt);
			fileName = "purchase_order_with_adjustment";
			jasperFile = "purchase_order_with_adjustment.jrxml";

			if(Integer.parseInt(storeId) == 0) {
				fileName = "adm_"+fileName;
				jasperFile = "adm_"+jasperFile;
			}
			
			if (rptType == 1) {
				// call method to generate pdf
				fileName = fileName + ".pdf";
				generatePDF(request, response, fileName, parameters, connection, jasperFile);
			} else {
				fileName = fileName + ".xlsx";
				generateXLSX(request, response, fileName, parameters, connection, jasperFile);
			}

			File file = new File(request.getRealPath("/") + "/jasper/procurement/"
					+ fileName);
			InputStream is = new FileInputStream(file);
			response.reset();
			if (rptType == 1) {
				response.setHeader("Content-Type", "application/pdf");
			} else {
				response.setHeader("Content-Type", "application/vnd.ms-excel");
			}
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
    finally {
      try {
        if(connection != null) connection.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
      if(em != null) em.close();
    }
	}
	
	@Path(value = "/report/purchaseSaleIntegrity")
	@GET
	public void getPurchaseSaleIntegrityReport(@QueryParam(value = "cmpnyId") String cmpnyId,
			@QueryParam(value = "storeId") String storeId,
			@QueryParam(value = "finYrId") String finYrId,
			@QueryParam(value = "startDate") String startDate,
			@QueryParam(value = "endDate") String endDate,
			@QueryParam(value = "type") String type,
			@QueryParam(value = "rptType") int rptType,
			@Context HttpServletRequest request,
			@Context HttpServletResponse response) {
		
		String fileName = null;
		String xlsxFileName = null;
		Connection connection = null;
		EntityManagerFactory entityManagerFactory;
		EntityManager em = null;
		String jasperFile = null;
		try {
			String DATE_FORMAT_NEEDED = "MM/dd/yyyy";
			String DATE_FORMAT_RECEIVED = "yyyy-MM-dd";
			String convertdDateStrt=DateUtil.convertReceivedDateToNeededDateStr(DATE_FORMAT_RECEIVED,DATE_FORMAT_NEEDED,startDate);
			String convertdDateEnd=DateUtil.convertReceivedDateToNeededDateStr(DATE_FORMAT_RECEIVED,DATE_FORMAT_NEEDED,endDate);
			java.sql.Date strtDt= DateUtil.convertStringDateToSqlDate(convertdDateStrt, DATE_FORMAT_NEEDED);
			java.sql.Date endDt= DateUtil.convertStringDateToSqlDate(convertdDateEnd, DATE_FORMAT_NEEDED);
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();

			// get connection object from entity manager
			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();

			connection = sessionFactory.getConnectionProvider().getConnection();
			

			Map<String, Object> parameters = new HashMap<String,Object>();

			parameters.put("W_companyID", Integer.parseInt(cmpnyId));
			parameters.put("W_storeID", Integer.parseInt(storeId));
			parameters.put("W_finyrID", Integer.parseInt(finYrId));
		
			parameters.put("W_startDate", strtDt);
			parameters.put("W_endDate", endDt);
			parameters.put("W_type", type);
			fileName = "purchase_sale_integrity_report";
			jasperFile = "purchase_sale_integrity_report.jrxml";
			
			//xlsxFileName = "purchase_sale_integrity_report.xls";

			if(Integer.parseInt(storeId) == 0) {
				fileName = "adm_"+fileName;
				jasperFile = "adm_"+jasperFile;
			}
			
			if (rptType == 1) {
				// call method to generate pdf
				fileName = fileName + ".pdf";
				generatePDF(request, response, fileName, parameters, connection, jasperFile);
			} else {
				fileName = fileName + ".xlsx";
				generateXLSX(request, response, fileName, parameters, connection, jasperFile);
			}
			
			
			// call method to generate xls
			/*generateXLS(request, response, xlsxFileName, parameters,
								connection, jasperFile);
			System.out.println("file created...");
			*/
			/*Desktop.getDesktop().open(new File(request.getRealPath("/") + "/jasper/procurement/"
					+ xlsxFileName));*/

			/*File file = new File(request.getRealPath("/") + "/jasper/procurement/"
					+ xlsxFileName);
			InputStream is = new FileInputStream(file);
			response.reset();
			response.setHeader("Content-Type", "application/vnd.ms-excel");
			response.setHeader("Content-Length", String.valueOf(file.length()));
			response.setHeader("Content-Disposition", "inline; filename=\""
					+ xlsxFileName + "\"");*/
			
			File file = new File(request.getRealPath("/") + "/jasper/procurement/"
					+ fileName);
			InputStream is = new FileInputStream(file);
			response.reset();
			if (rptType == 1) {
				response.setHeader("Content-Type", "application/pdf");
			} else {
				response.setHeader("Content-Type", "application/vnd.ms-excel");
			}
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
    finally {
      try {
        if(connection != null) connection.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
      if(em != null) em.close();
    }
	}
	
	@Path(value = "/report/purchase/freeQty")
	@GET
	public void getPurchaseFreeQtyReport(@QueryParam(value = "cmpnyId") String cmpnyId,
			@QueryParam(value = "storeId") String storeId,
			@QueryParam(value = "finYrId") String finYrId,
			@QueryParam(value = "distId") String distId,
			@QueryParam(value = "startDate") String startDate,
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
			String convertdDateStrt=DateUtil.convertReceivedDateToNeededDateStr(DATE_FORMAT_RECEIVED,DATE_FORMAT_NEEDED,startDate);
			String convertdDateEnd=DateUtil.convertReceivedDateToNeededDateStr(DATE_FORMAT_RECEIVED,DATE_FORMAT_NEEDED,endDate);
			java.sql.Date strtDt= DateUtil.convertStringDateToSqlDate(convertdDateStrt, DATE_FORMAT_NEEDED);
			java.sql.Date endDt= DateUtil.convertStringDateToSqlDate(convertdDateEnd, DATE_FORMAT_NEEDED);
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();

			// get connection object from entity manager
			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();

			connection = sessionFactory.getConnectionProvider().getConnection();
			

			Map<String, Object> parameters = new HashMap<String,Object>();

			parameters.put("W_companyID", Integer.parseInt(cmpnyId));
			parameters.put("W_storeID", Integer.parseInt(storeId));
			parameters.put("W_finyrID", Integer.parseInt(finYrId));
			parameters.put("W_distributorID", Integer.parseInt(distId));
			parameters.put("W_startDate", strtDt);
			parameters.put("W_endDate", endDt);
			fileName = "purchase_free_qty_details";
			jasperFile = "purchase_free_qty_details.jrxml";
			
			if(Integer.parseInt(storeId) == 0) {
				fileName = "adm_"+fileName;
				jasperFile = "adm_"+jasperFile;
			}

			if (rptType == 1) {
				// call method to generate pdf
				fileName = fileName + ".pdf";
				generatePDF(request, response, fileName, parameters, connection, jasperFile);
			} else {
				fileName = fileName + ".xlsx";
				generateXLSX(request, response, fileName, parameters, connection, jasperFile);
			}

			File file = new File(request.getRealPath("/") + "/jasper/procurement/"
					+ fileName);
			InputStream is = new FileInputStream(file);
			response.reset();
			if (rptType == 1) {
				response.setHeader("Content-Type", "application/pdf");
			} else {
				response.setHeader("Content-Type", "application/vnd.ms-excel");
			}
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
    finally {
      try {
        if(connection != null) connection.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
      if(em != null) em.close();
    }
	}
	
	@Path(value = "/report/purchase/return")
	@GET
	public void getPurchaseReturnSummaryReport(@QueryParam(value = "cmpnyId") String cmpnyId,
			@QueryParam(value = "storeId") String storeId,
			@QueryParam(value = "finYrId") String finYrId,
			@QueryParam(value = "distributorId") String distributorId,
			@QueryParam(value = "startDate") String startDate,
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
			String convertdDateStrt=DateUtil.convertReceivedDateToNeededDateStr(DATE_FORMAT_RECEIVED,DATE_FORMAT_NEEDED,startDate);
			String convertdDateEnd=DateUtil.convertReceivedDateToNeededDateStr(DATE_FORMAT_RECEIVED,DATE_FORMAT_NEEDED,endDate);
			java.sql.Date strtDt= DateUtil.convertStringDateToSqlDate(convertdDateStrt, DATE_FORMAT_NEEDED);
			java.sql.Date endDt= DateUtil.convertStringDateToSqlDate(convertdDateEnd, DATE_FORMAT_NEEDED);
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();

			// get connection object from entity manager
			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();

			connection = sessionFactory.getConnectionProvider().getConnection();
			

			Map<String, Object> parameters = new HashMap<String,Object>();

			parameters.put("W_companyID", Integer.parseInt(cmpnyId));
			parameters.put("W_storeID", Integer.parseInt(storeId));
			parameters.put("W_finyrID", Integer.parseInt(finYrId));
			parameters.put("W_distributorID", Integer.parseInt(distributorId));
			parameters.put("W_startDate", strtDt);
			parameters.put("W_endDate", endDt);
			fileName = "purchase_return_summary";
			jasperFile = "purchase_return_summary.jrxml";

			if(Integer.parseInt(storeId) == 0) {
				fileName = "adm_"+fileName;
				jasperFile = "adm_"+jasperFile;
			}
			
			if (rptType == 1) {
				// call method to generate pdf
				fileName = fileName + ".pdf";
				generatePDF(request, response, fileName, parameters, connection, jasperFile);
			} else {
				fileName = fileName + ".xlsx";
				generateXLSX(request, response, fileName, parameters, connection, jasperFile);
			}

			File file = new File(request.getRealPath("/") + "/jasper/procurement/"
					+ fileName);
			InputStream is = new FileInputStream(file);
			response.reset();
			if (rptType == 1) {
				response.setHeader("Content-Type", "application/pdf");
			} else {
				response.setHeader("Content-Type", "application/vnd.ms-excel");
			}
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
    finally {
      try {
        if(connection != null) connection.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
      if(em != null) em.close();
    }
	}
	
	@Path(value = "/report/purchase/register")
	@GET
	public void getPurchaseRegisterReport(@QueryParam(value = "cmpnyId") String cmpnyId,
			@QueryParam(value = "storeId") String storeId,
			@QueryParam(value = "finYrId") String finYrId,
			@QueryParam(value = "distributorId") String distributorId,
			@QueryParam(value = "startDate") String startDate,
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
			String convertdDateStrt=DateUtil.convertReceivedDateToNeededDateStr(DATE_FORMAT_RECEIVED,DATE_FORMAT_NEEDED,startDate);
			String convertdDateEnd=DateUtil.convertReceivedDateToNeededDateStr(DATE_FORMAT_RECEIVED,DATE_FORMAT_NEEDED,endDate);
			java.sql.Date strtDt= DateUtil.convertStringDateToSqlDate(convertdDateStrt, DATE_FORMAT_NEEDED);
			java.sql.Date endDt= DateUtil.convertStringDateToSqlDate(convertdDateEnd, DATE_FORMAT_NEEDED);
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();

			// get connection object from entity manager
			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();

			connection = sessionFactory.getConnectionProvider().getConnection();
			

			Map<String, Object> parameters = new HashMap<String,Object>();

			parameters.put("W_companyID", Integer.parseInt(cmpnyId));
			parameters.put("W_storeID", Integer.parseInt(storeId));
			parameters.put("W_finyrID", Integer.parseInt(finYrId));
			parameters.put("W_distributorID", Integer.parseInt(distributorId));
			parameters.put("W_startDate", strtDt);
			parameters.put("W_endDate", endDt);
			fileName = "purchase_register";
			jasperFile = "purchase_register.jrxml";

			if(Integer.parseInt(storeId) == 0) {
				fileName = "adm_"+fileName;
				jasperFile = "adm_"+jasperFile;
			}
			
			if (rptType == 1) {
				// call method to generate pdf
				fileName = fileName + ".pdf";
				generatePDF(request, response, fileName, parameters, connection, jasperFile);
			} else {
				fileName = fileName + ".xlsx";
				generateXLSX(request, response, fileName, parameters, connection, jasperFile);
			}

			File file = new File(request.getRealPath("/") + "/jasper/procurement/"
					+ fileName);
			InputStream is = new FileInputStream(file);
			response.reset();
			if (rptType == 1) {
				response.setHeader("Content-Type", "application/pdf");
			} else {
				response.setHeader("Content-Type", "application/vnd.ms-excel");
			}
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
    finally {
      try {
        if(connection != null) connection.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
      if(em != null) em.close();
    }
	}
	
	@Path(value = "/report/purchase/return/register")
	@GET
	public void getPurchaseReturnRegisterReport(@QueryParam(value = "cmpnyId") String cmpnyId,
			@QueryParam(value = "storeId") String storeId,
			@QueryParam(value = "finYrId") String finYrId,
			@QueryParam(value = "distributorId") String distributorId,
			@QueryParam(value = "startDate") String startDate,
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
			String convertdDateStrt=DateUtil.convertReceivedDateToNeededDateStr(DATE_FORMAT_RECEIVED,DATE_FORMAT_NEEDED,startDate);
			String convertdDateEnd=DateUtil.convertReceivedDateToNeededDateStr(DATE_FORMAT_RECEIVED,DATE_FORMAT_NEEDED,endDate);
			java.sql.Date strtDt= DateUtil.convertStringDateToSqlDate(convertdDateStrt, DATE_FORMAT_NEEDED);
			java.sql.Date endDt= DateUtil.convertStringDateToSqlDate(convertdDateEnd, DATE_FORMAT_NEEDED);
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();

			// get connection object from entity manager
			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();

			connection = sessionFactory.getConnectionProvider().getConnection();
			

			Map<String, Object> parameters = new HashMap<String,Object>();

			parameters.put("W_companyID", Integer.parseInt(cmpnyId));
			parameters.put("W_storeID", Integer.parseInt(storeId));
			parameters.put("W_finyrID", Integer.parseInt(finYrId));
			parameters.put("W_distributorID", Integer.parseInt(distributorId));
			parameters.put("W_startDate", strtDt);
			parameters.put("W_endDate", endDt);
			fileName = "purchase_return_register";
			jasperFile = "purchase_return_register.jrxml";

			if(Integer.parseInt(storeId) == 0) {
				fileName = "adm_"+fileName;
				jasperFile = "adm_"+jasperFile;
			}
			
			if (rptType == 1) {
				// call method to generate pdf
				fileName = fileName + ".pdf";
				generatePDF(request, response, fileName, parameters, connection, jasperFile);
			} else {
				fileName = fileName + ".xlsx";
				generateXLSX(request, response, fileName, parameters, connection, jasperFile);
			}

			File file = new File(request.getRealPath("/") + "/jasper/procurement/"
					+ fileName);
			InputStream is = new FileInputStream(file);
			response.reset();
			if (rptType == 1) {
				response.setHeader("Content-Type", "application/pdf");
			} else {
				response.setHeader("Content-Type", "application/vnd.ms-excel");
			}
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
    finally {
      try {
        if(connection != null) connection.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
      if(em != null) em.close();
    }
	}
	
	@Path(value = "/report/purchase/item")
	@GET
	public void getPurchaseItemReport(@QueryParam(value = "cmpnyId") String cmpnyId,
			@QueryParam(value = "storeId") String storeId,
			@QueryParam(value = "finYrId") String finYrId,
			@QueryParam(value = "distributorId") String distributorId,
			@QueryParam(value = "itemId") String itemId,
			@QueryParam(value = "contentId") String contentId,
			@QueryParam(value = "manufacturerId") String manufacturerId,
			@QueryParam(value = "startDate") String startDate,
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
			String convertdDateStrt=DateUtil.convertReceivedDateToNeededDateStr(DATE_FORMAT_RECEIVED,DATE_FORMAT_NEEDED,startDate);
			String convertdDateEnd=DateUtil.convertReceivedDateToNeededDateStr(DATE_FORMAT_RECEIVED,DATE_FORMAT_NEEDED,endDate);
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();

			// get connection object from entity manager
			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();

			connection = sessionFactory.getConnectionProvider().getConnection();
			//String asOnDatestr=mapper.getAsOnDate();
			java.sql.Date strtDt= DateUtil.convertStringDateToSqlDate(convertdDateStrt, DATE_FORMAT_NEEDED);
			java.sql.Date endDt= DateUtil.convertStringDateToSqlDate(convertdDateEnd, DATE_FORMAT_NEEDED);
			 
			
			Map<String, Object> parameters = new HashMap<String,Object>();

			parameters.put("W_companyID", Integer.parseInt(cmpnyId));
			parameters.put("W_storeID", Integer.parseInt(storeId));
			parameters.put("W_finyrID", Integer.parseInt(finYrId));
			parameters.put("W_distributorID", Integer.parseInt(distributorId));
			parameters.put("W_itemID", Integer.parseInt(itemId));
			parameters.put("W_contentID", Integer.parseInt(contentId));
			parameters.put("W_manufacturerID", Integer.parseInt(manufacturerId));
			parameters.put("W_startDate", strtDt);
			parameters.put("W_endDate", endDt);
			fileName = "item_wise_purchase";
			jasperFile = "item_wise_purchase.jrxml";

			if(Integer.parseInt(storeId) == 0) {
				fileName = "adm_"+fileName;
				jasperFile = "adm_"+jasperFile;
			}
			
			if (rptType == 1) {
				// call method to generate pdf
				fileName = fileName + ".pdf";
				generatePDF(request, response, fileName, parameters, connection, jasperFile);
			} else {
				fileName = fileName + ".xlsx";
				generateXLSX(request, response, fileName, parameters, connection, jasperFile);
			}

			File file = new File(request.getRealPath("/") + "/jasper/procurement/"
					+ fileName);
			InputStream is = new FileInputStream(file);
			response.reset();
			if (rptType == 1) {
				response.setHeader("Content-Type", "application/pdf");
			} else {
				response.setHeader("Content-Type", "application/vnd.ms-excel");
			}
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
    finally {
      try {
        if(connection != null) connection.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
      if(em != null) em.close();
    }
	}
	
	@Path(value = "/report/purchase/return/item")
	@GET
	public void getPurchaseReturnItemReport(@QueryParam(value = "cmpnyId") String cmpnyId,
			@QueryParam(value = "storeId") String storeId,
			@QueryParam(value = "finYrId") String finYrId,
			@QueryParam(value = "distributorId") String distributorId,
			@QueryParam(value = "itemId") String itemId,
			@QueryParam(value = "contentId") String contentId,
			@QueryParam(value = "manufacturerId") String manufacturerId,
			@QueryParam(value = "startDate") String startDate,
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
			String convertdDateStrt=DateUtil.convertReceivedDateToNeededDateStr(DATE_FORMAT_RECEIVED,DATE_FORMAT_NEEDED,startDate);
			String convertdDateEnd=DateUtil.convertReceivedDateToNeededDateStr(DATE_FORMAT_RECEIVED,DATE_FORMAT_NEEDED,endDate);
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();

			// get connection object from entity manager
			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();

			connection = sessionFactory.getConnectionProvider().getConnection();
			//String asOnDatestr=mapper.getAsOnDate();
			java.sql.Date strtDt= DateUtil.convertStringDateToSqlDate(convertdDateStrt, DATE_FORMAT_NEEDED);
			java.sql.Date endDt= DateUtil.convertStringDateToSqlDate(convertdDateEnd, DATE_FORMAT_NEEDED);
			 
			
			Map<String, Object> parameters = new HashMap<String,Object>();

			parameters.put("W_companyID", Integer.parseInt(cmpnyId));
			parameters.put("W_storeID", Integer.parseInt(storeId));
			parameters.put("W_finyrID", Integer.parseInt(finYrId));
			parameters.put("W_distributorID", Integer.parseInt(distributorId));
			parameters.put("W_itemID", Integer.parseInt(itemId));
			parameters.put("W_contentID", Integer.parseInt(contentId));
			parameters.put("W_manufacturerID", Integer.parseInt(manufacturerId));
			parameters.put("W_startDate", strtDt);
			parameters.put("W_endDate", endDt);
			fileName = "item_wise_purchase_return";
			jasperFile = "item_wise_purchase_return.jrxml";
			
			if(Integer.parseInt(storeId) == 0) {
				fileName = "adm_"+fileName;
				jasperFile = "adm_"+jasperFile;
			}

			if (rptType == 1) {
				// call method to generate pdf
				fileName = fileName + ".pdf";
				generatePDF(request, response, fileName, parameters, connection, jasperFile);
			} else {
				fileName = fileName + ".xlsx";
				generateXLSX(request, response, fileName, parameters, connection, jasperFile);
			}

			File file = new File(request.getRealPath("/") + "/jasper/procurement/"
					+ fileName);
			InputStream is = new FileInputStream(file);
			response.reset();
			if (rptType == 1) {
				response.setHeader("Content-Type", "application/pdf");
			} else {
				response.setHeader("Content-Type", "application/vnd.ms-excel");
			}
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
    finally {
      try {
        if(connection != null) connection.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
      if(em != null) em.close();
    }
	}
	
	
	//26.03.2018
	//14.03.2018
		@Path(value = "/report/accounts") //only ledger report
		@GET
		public void getAccountsReport(@QueryParam(value = "cmpnyId") int cmpnyId,
				@QueryParam(value = "storeId") int storeId,
				@QueryParam(value = "finYrId") int finYrId,
				
				@QueryParam(value = "startDate") String startDate,
				@QueryParam(value = "endDate") String endDate,
				
				@QueryParam(value = "accountgroup_id") int accountgroup_id,
				@QueryParam(value = "account_id") int account_id,
				//@QueryParam(value = "report_type") int report_type,
				
				@QueryParam(value = "report_format") int report_format,
				@Context HttpServletRequest request,
				@Context HttpServletResponse response) {
			
			//System.out.println("accounts ledger Parameters are : cmpnyId = "+cmpnyId +", storeId = "+storeId+", finYrId = "+finYrId+", startDate = "+startDate+", endDate = "+endDate+", accountgroup_id = "+accountgroup_id+", account_id = "+account_id+", report_format = "+report_format);
			String fileName = null;
			Connection connection = null;
			EntityManagerFactory entityManagerFactory;
			EntityManager em = null;
			String jasperFile = null;
			try {
				String DATE_FORMAT_NEEDED = "MM/dd/yyyy";
				String DATE_FORMAT_RECEIVED = "yyyy-MM-dd";
				String convertdDateStrt=DateUtil.convertReceivedDateToNeededDateStr(DATE_FORMAT_RECEIVED,DATE_FORMAT_NEEDED,startDate);
				String convertdDateEnd=DateUtil.convertReceivedDateToNeededDateStr(DATE_FORMAT_RECEIVED,DATE_FORMAT_NEEDED,endDate);
				entityManagerFactory = PersistenceListener.getEntityManager();
				em = entityManagerFactory.createEntityManager();

				// get connection object from entity manager
				Session ses = (Session) em.getDelegate();
				SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
						.getSessionFactory();

				connection = sessionFactory.getConnectionProvider().getConnection();
				//String asOnDatestr=mapper.getAsOnDate();
				java.sql.Date strtDt= DateUtil.convertStringDateToSqlDate(convertdDateStrt, DATE_FORMAT_NEEDED);
				java.sql.Date endDt= DateUtil.convertStringDateToSqlDate(convertdDateEnd, DATE_FORMAT_NEEDED);
				
				
				Map<String, Object> parameters = new HashMap<String,Object>();

				parameters.put("W_companyID", cmpnyId);
				parameters.put("W_storeID", storeId);
				parameters.put("W_finyrID", finYrId);
				parameters.put("W_startDate", strtDt);
				parameters.put("W_endDate", endDt);
				
				parameters.put("W_groupID", accountgroup_id);
				parameters.put("W_ledgerID", account_id);
				
				
				//fileName = "accounts.pdf";
				
					if(report_format==1)
					{
						fileName = "LedgerBalance.pdf";
						jasperFile = "LedgerBalance.jrxml";
					}
					else if(report_format==2)
					{
						fileName = "LedgerBalance.xlsx";
						jasperFile = "LedgerBalanceXls.jrxml";
					}

				if(report_format==1)
				{
					// call method to generate pdf
					generatePDF(request, response, fileName, parameters,connection, jasperFile);
				}
				else if(report_format==2) {
					// call method to generate xls
					generateXLSX(request, response, fileName, parameters,connection, jasperFile);
				}
				
				File file = new File(request.getRealPath("/") + "/jasper/procurement/" + fileName);
				InputStream is = new FileInputStream(file);
				
				if(report_format==1) //PDF
				{
					response.reset();
					response.setHeader("Content-Type", "application/pdf");
					response.setHeader("Content-Length", String.valueOf(file.length()));
					response.setHeader("Content-Disposition", "inline; filename=\""+ fileName + "\"");
				}
				else if(report_format==2) { //XLSX
					response.reset();
					response.setHeader("Content-Length", String.valueOf(file.length()));
					response.setHeader("Content-Disposition", "attachment; filename=\""+ fileName + "\""); //for excel file download
				}
				
				
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
	    finally {
	      try {
	        if(connection != null) connection.close();
	      } catch (SQLException e) {
	        e.printStackTrace();
	      }
	      if(em != null) em.close();
	    }
		}
		
		//19.03.2018
		@Path(value = "/report/trialBalance")
		@GET
		public void getTrialBalanceReport(@QueryParam(value = "cmpnyId") int cmpnyId,
				@QueryParam(value = "storeId") int storeId,
				@QueryParam(value = "finYrId") int finYrId,
				
				@QueryParam(value = "asOnDate") String asOnDate,
				
				//@QueryParam(value = "report_type") int report_type,
				
				@QueryParam(value = "trial_type") int trial_type, //1 : GroupTrial , 2 : LedgerTrial
				
				@QueryParam(value = "report_format") int report_format, //1:PDF / 2:XLS
				
				@QueryParam(value = "isExcludingZero") int isExcludingZero,
				@Context HttpServletRequest request,
				@Context HttpServletResponse response) {
			
			//System.out.println("trialBalance Parameters are : cmpnyId = "+cmpnyId +", storeId = "+storeId+", finYrId = "+finYrId+", asOnDate = "+asOnDate+", report_format = "+report_format+", trial_type = "+trial_type+", isExcludingZero = "+isExcludingZero);
			String fileName = null;
			Connection connection = null;
			EntityManagerFactory entityManagerFactory;
			EntityManager em = null;
			String jasperFile = null;
			try {
				String DATE_FORMAT_NEEDED = "MM/dd/yyyy";
				String DATE_FORMAT_RECEIVED = "yyyy-MM-dd";
				String convertdAsOnDate=DateUtil.convertReceivedDateToNeededDateStr(DATE_FORMAT_RECEIVED,DATE_FORMAT_NEEDED,asOnDate);
				entityManagerFactory = PersistenceListener.getEntityManager();
				em = entityManagerFactory.createEntityManager();

				// get connection object from entity manager
				Session ses = (Session) em.getDelegate();
				SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
						.getSessionFactory();

				connection = sessionFactory.getConnectionProvider().getConnection();
				//String asOnDatestr=mapper.getAsOnDate();
				java.sql.Date asOnDt= DateUtil.convertStringDateToSqlDate(convertdAsOnDate, DATE_FORMAT_NEEDED);
				
				
				Map<String, Object> parameters = new HashMap<String,Object>();

				parameters.put("W_companyID", cmpnyId);
				parameters.put("W_storeID", storeId);
				parameters.put("W_finyrID", finYrId);
				parameters.put("W_asOnDate", asOnDt);
				parameters.put("W_IsExcludingZero", isExcludingZero);
				
				//fileName = "accounts.pdf";
				if(trial_type == 1) //groupwise
				{
					if(report_format==1)
					{
						fileName = "GroupTrialBalance.pdf";
						jasperFile = "GroupTrialBalance.jrxml";
					}
					else if(report_format==2)
					{
						fileName = "GroupTrialBalance.xlsx";
						jasperFile = "GroupTrialBalanceXls.jrxml";
					}
				}
				if(trial_type == 2) //ledgerwise
				{
					if(report_format==1)
					{
						fileName = "LedgerTrialBalance.pdf";
						jasperFile = "LedgerTrialBalance.jrxml";
					}
					else if(report_format==2)
					{
						fileName = "LedgerTrialBalance.xlsx";
						jasperFile = "LedgerTrialBalanceXls.jrxml";
					}
				}

				if(report_format==1)
				{
					// call method to generate pdf
					generatePDF(request, response, fileName, parameters,connection, jasperFile);
				}
				else if(report_format==2) {
					// call method to generate xls
					generateXLSX(request, response, fileName, parameters,connection, jasperFile);
				}
				
				File file = new File(request.getRealPath("/") + "/jasper/procurement/" + fileName);
				InputStream is = new FileInputStream(file);
				
				if(report_format==1) //PDF
				{
					response.reset();
					response.setHeader("Content-Type", "application/pdf");
					response.setHeader("Content-Length", String.valueOf(file.length()));
					response.setHeader("Content-Disposition", "inline; filename=\""+ fileName + "\"");
				}
				else if(report_format==2) { //XLSX
					response.reset();
					response.setHeader("Content-Length", String.valueOf(file.length()));
					response.setHeader("Content-Disposition", "attachment; filename=\""+ fileName + "\""); //for excel file download
				}
				
				
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
	    finally {
	      try {
	        if(connection != null) connection.close();
	      } catch (SQLException e) {
	        e.printStackTrace();
	      }
	      if(em != null) em.close();
	    }
		}
		
		//20.03.2018
		@Path(value = "/report/dailyCollectionReport")
		@GET
		public void getdailyCollectionReport(@QueryParam(value = "cmpnyId") int cmpnyId,
				@QueryParam(value = "storeId") int storeId,
				@QueryParam(value = "finYrId") int finYrId,
				
				@QueryParam(value = "startDate") String startDate,
				@QueryParam(value = "endDate") String endDate,
				@QueryParam(value = "report_format") int report_format, //1:PDF / 2:XLS
				
				@Context HttpServletRequest request,
				@Context HttpServletResponse response) {
			
			//System.out.println("dailyCollectionReport Parameters are : cmpnyId = "+cmpnyId +", storeId = "+storeId+", finYrId = "+finYrId+", startDate = "+startDate+", endDate = "+endDate+", report_format = "+report_format);
			String fileName = null;
			Connection connection = null;
			EntityManagerFactory entityManagerFactory;
			EntityManager em = null;
			String jasperFile = null;
			try {
				String DATE_FORMAT_NEEDED = "MM/dd/yyyy";
				String DATE_FORMAT_RECEIVED = "yyyy-MM-dd";
				String convertdDateStrt=DateUtil.convertReceivedDateToNeededDateStr(DATE_FORMAT_RECEIVED,DATE_FORMAT_NEEDED,startDate);
				String convertdDateEnd=DateUtil.convertReceivedDateToNeededDateStr(DATE_FORMAT_RECEIVED,DATE_FORMAT_NEEDED,endDate);
				entityManagerFactory = PersistenceListener.getEntityManager();
				em = entityManagerFactory.createEntityManager();

				// get connection object from entity manager
				Session ses = (Session) em.getDelegate();
				SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
						.getSessionFactory();

				connection = sessionFactory.getConnectionProvider().getConnection();
				//String asOnDatestr=mapper.getAsOnDate();
				java.sql.Date startDt= DateUtil.convertStringDateToSqlDate(convertdDateStrt, DATE_FORMAT_NEEDED);
				java.sql.Date endDt= DateUtil.convertStringDateToSqlDate(convertdDateEnd, DATE_FORMAT_NEEDED);
				
				
				Map<String, Object> parameters = new HashMap<String,Object>();

				parameters.put("W_companyID", cmpnyId);
				parameters.put("W_storeID", storeId);
				parameters.put("W_finyrID", finYrId);
				parameters.put("W_startDate", startDt);
				parameters.put("W_endDate", endDt);
				
				
				if(report_format==1) //pdf
				{
					fileName = "DailyCollection.pdf";
					jasperFile = "DailyCollection.jrxml";
				}
				else if(report_format==2) //xls
				{
					fileName = "DailyCollection.xlsx";
					jasperFile = "DailyCollectionXls.jrxml";
				}
				

				if(report_format==1)
				{
					// call method to generate pdf
					generatePDF(request, response, fileName, parameters,connection, jasperFile);
				}
				else if(report_format==2) {
					// call method to generate xls
					generateXLSX(request, response, fileName, parameters,connection, jasperFile);
				}
				
				File file = new File(request.getRealPath("/") + "/jasper/procurement/" + fileName);
				InputStream is = new FileInputStream(file);
				
				if(report_format==1) //PDF
				{
					response.reset();
					response.setHeader("Content-Type", "application/pdf");
					response.setHeader("Content-Length", String.valueOf(file.length()));
					response.setHeader("Content-Disposition", "inline; filename=\""+ fileName + "\"");
				}
				else if(report_format==2) { //XLSX
					response.reset();
					response.setHeader("Content-Length", String.valueOf(file.length()));
					response.setHeader("Content-Disposition", "attachment; filename=\""+ fileName + "\""); //for excel file download
				}
				
				
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
	    finally {
	      try {
	        if(connection != null) connection.close();
	      } catch (SQLException e) {
	        e.printStackTrace();
	      }
	      if(em != null) em.close();
	    }
		}
		
		@Path(value = "/report/dailyPaymentReport")
		@GET
		public void getdailyPaymentReport (
				@QueryParam(value = "cmpnyId") int cmpnyId,
				@QueryParam(value = "storeId") int storeId,
				@QueryParam(value = "finYrId") int finYrId,
				
				@QueryParam(value = "startDate") String startDate,
				@QueryParam(value = "endDate") String endDate,
				@QueryParam(value = "report_format") int report_format, //1:PDF / 2:XLS
				
				@Context HttpServletRequest request,
				@Context HttpServletResponse response) {
			
			//System.out.println("dailyPaymentReport Parameters are : cmpnyId = "+cmpnyId +", storeId = "+storeId+", finYrId = "+finYrId+", startDate = "+startDate+", endDate = "+endDate+", report_format = "+report_format);
			String fileName = null;
			Connection connection = null;
			EntityManagerFactory entityManagerFactory;
			EntityManager em = null;
			String jasperFile = null;
			try {
				String DATE_FORMAT_NEEDED = "MM/dd/yyyy";
				String DATE_FORMAT_RECEIVED = "yyyy-MM-dd";
				String convertdDateStrt=DateUtil.convertReceivedDateToNeededDateStr(DATE_FORMAT_RECEIVED,DATE_FORMAT_NEEDED,startDate);
				String convertdDateEnd=DateUtil.convertReceivedDateToNeededDateStr(DATE_FORMAT_RECEIVED,DATE_FORMAT_NEEDED,endDate);
				entityManagerFactory = PersistenceListener.getEntityManager();
				em = entityManagerFactory.createEntityManager();

				// get connection object from entity manager
				Session ses = (Session) em.getDelegate();
				SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
						.getSessionFactory();

				connection = sessionFactory.getConnectionProvider().getConnection();
				//String asOnDatestr=mapper.getAsOnDate();
				java.sql.Date startDt= DateUtil.convertStringDateToSqlDate(convertdDateStrt, DATE_FORMAT_NEEDED);
				java.sql.Date endDt= DateUtil.convertStringDateToSqlDate(convertdDateEnd, DATE_FORMAT_NEEDED);
				
				
				Map<String, Object> parameters = new HashMap<String,Object>();

				parameters.put("W_companyID", cmpnyId);
				parameters.put("W_storeID", storeId);
				parameters.put("W_finyrID", finYrId);
				parameters.put("W_startDate", startDt);
				parameters.put("W_endDate", endDt);
				
				
				if(report_format==1) //pdf
				{
					fileName = "DailyPayment.pdf";
					jasperFile = "DailyPayment.jrxml";
				}
				else if(report_format==2) //xls
				{
					fileName = "DailyPayment.xlsx";
					jasperFile = "DailyPaymentXls.jrxml";
				}
				

				if(report_format==1)
				{
					// call method to generate pdf
					generatePDF(request, response, fileName, parameters,connection, jasperFile);
				}
				else if(report_format==2) {
					// call method to generate xls
					generateXLSX(request, response, fileName, parameters,connection, jasperFile);
				}
				
				File file = new File(request.getRealPath("/") + "/jasper/procurement/" + fileName);
				InputStream is = new FileInputStream(file);
				
				if(report_format==1) //PDF
				{
					response.reset();
					response.setHeader("Content-Type", "application/pdf");
					response.setHeader("Content-Length", String.valueOf(file.length()));
					response.setHeader("Content-Disposition", "inline; filename=\""+ fileName + "\"");
				}
				else if(report_format==2) { //XLSX
					response.reset();
					response.setHeader("Content-Length", String.valueOf(file.length()));
					response.setHeader("Content-Disposition", "attachment; filename=\""+ fileName + "\""); //for excel file download
				}
				
				
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
	    finally {
	      try {
	        if(connection != null) connection.close();
	      } catch (SQLException e) {
	        e.printStackTrace();
	      }
	      if(em != null) em.close();
	    }
		}
		
		@Path(value = "/report/balanceSheetReport")
		@GET
		public void getbalanceSheetReport (
				@QueryParam(value = "cmpnyId") int cmpnyId,
				@QueryParam(value = "storeId") int storeId,
				@QueryParam(value = "finYrId") int finYrId,
				
				@QueryParam(value = "asOnDate") String asOnDate,
				@QueryParam(value = "report_format") int report_format, //1:PDF / 2:XLS
				
				@Context HttpServletRequest request,
				@Context HttpServletResponse response) {
			
			//System.out.println("balanceSheet Parameters are : cmpnyId = "+cmpnyId +", storeId = "+storeId+", finYrId = "+finYrId+", asOnDate = "+asOnDate+", report_format = "+report_format);
			String fileName = null;
			Connection connection = null;
			EntityManagerFactory entityManagerFactory;
			EntityManager em = null;
			String jasperFile = null;
			try {
				String DATE_FORMAT_NEEDED = "MM/dd/yyyy";
				String DATE_FORMAT_RECEIVED = "yyyy-MM-dd";
				String convertdAsOnDate=DateUtil.convertReceivedDateToNeededDateStr(DATE_FORMAT_RECEIVED,DATE_FORMAT_NEEDED,asOnDate);
				entityManagerFactory = PersistenceListener.getEntityManager();
				em = entityManagerFactory.createEntityManager();

				// get connection object from entity manager
				Session ses = (Session) em.getDelegate();
				SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
						.getSessionFactory();

				connection = sessionFactory.getConnectionProvider().getConnection();
				//String asOnDatestr=mapper.getAsOnDate();
				java.sql.Date asOnDt= DateUtil.convertStringDateToSqlDate(convertdAsOnDate, DATE_FORMAT_NEEDED);
				
				
				Map<String, Object> parameters = new HashMap<String,Object>();

				parameters.put("W_companyID", cmpnyId);
				parameters.put("W_storeID", storeId);
				parameters.put("W_finyrID", finYrId);
				
				parameters.put("W_asOnDate", asOnDt);
				
				parameters.put("SUBREPORT_DIR",request.getRealPath("/jasper") + "/procurement/");
				
				//parameters.put("SUBREPORT_DIR",generateSubReport(request, response, "BalanceSheetAssets.jasper", parameters,connection, "BalanceSheetAssets.jrxml"));
				//parameters.put("SUBREPORT_DIR",generateSubReport(request, response, "BalanceSheetLiabilities.jasper", parameters,connection, "BalanceSheetLiabilities.jrxml"));
				
				generateSubReport(request, response, "BalanceSheetAssets.jasper", parameters,connection, "BalanceSheetAssets.jrxml");
				generateSubReport(request, response, "BalanceSheetLiabilities.jasper", parameters,connection, "BalanceSheetLiabilities.jrxml");
				
				if(report_format==1) //pdf
				{
					fileName = "BalanceSheet.pdf";
					jasperFile = "BalanceSheet.jrxml";
				}
				else if(report_format==2) //xls
				{
					fileName = "BalanceSheet.xlsx";
					jasperFile = "BalanceSheetXls.jrxml";
				}
				

				if(report_format==1)
				{
					// call method to generate pdf
					generatePDF(request, response, fileName, parameters,connection, jasperFile);
				}
				else if(report_format==2) {
					// call method to generate xls
					generateXLSX(request, response, fileName, parameters,connection, jasperFile);
				}
				
				File file = new File(request.getRealPath("/") + "/jasper/procurement/" + fileName);
				InputStream is = new FileInputStream(file);
				
				if(report_format==1) //PDF
				{
					response.reset();
					response.setHeader("Content-Type", "application/pdf");
					response.setHeader("Content-Length", String.valueOf(file.length()));
					response.setHeader("Content-Disposition", "inline; filename=\""+ fileName + "\"");
				}
				else if(report_format==2) { //XLSX
					response.reset();
					response.setHeader("Content-Length", String.valueOf(file.length()));
					response.setHeader("Content-Disposition", "attachment; filename=\""+ fileName + "\""); //for excel file download
				}
				
				
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
	    finally {
	      try {
	        if(connection != null) connection.close();
	      } catch (SQLException e) {
	        e.printStackTrace();
	      }
	      if(em != null) em.close();
	    }
		}
		
		@Path(value = "/report/accountBalanceReport")
		@GET
		public void getAccountBalanceReport (
				@QueryParam(value = "cmpnyId") int cmpnyId,
				@QueryParam(value = "storeId") int storeId,
				@QueryParam(value = "finYrId") int finYrId,
				
				@QueryParam(value = "accountgroup_id") int groupId,
				@QueryParam(value = "account_id") int ledgerId,
				
				@QueryParam(value = "asOnDate") String asOnDate,
				@QueryParam(value = "report_format") int report_format, //1:PDF / 2:XLS
				
				@Context HttpServletRequest request,
				@Context HttpServletResponse response) {
			
			//System.out.println("accountBalance Parameters are : cmpnyId = "+cmpnyId +", storeId = "+storeId+", finYrId = "+finYrId+", groupId = "+groupId+", ledgerId = "+ledgerId+", asOnDate = "+asOnDate+", report_format = "+report_format);
			String fileName = null;
			Connection connection = null;
			EntityManagerFactory entityManagerFactory;
			EntityManager em = null;
			String jasperFile = null;
			try {
				String DATE_FORMAT_NEEDED = "MM/dd/yyyy";
				String DATE_FORMAT_RECEIVED = "yyyy-MM-dd";
				String convertdAsOnDate=DateUtil.convertReceivedDateToNeededDateStr(DATE_FORMAT_RECEIVED,DATE_FORMAT_NEEDED,asOnDate);
				entityManagerFactory = PersistenceListener.getEntityManager();
				em = entityManagerFactory.createEntityManager();

				// get connection object from entity manager
				Session ses = (Session) em.getDelegate();
				SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
						.getSessionFactory();

				connection = sessionFactory.getConnectionProvider().getConnection();
				//String asOnDatestr=mapper.getAsOnDate();
				java.sql.Date asOnDt= DateUtil.convertStringDateToSqlDate(convertdAsOnDate, DATE_FORMAT_NEEDED);
				
				
				Map<String, Object> parameters = new HashMap<String,Object>();

				parameters.put("W_companyID", cmpnyId);
				parameters.put("W_storeID", storeId);
				parameters.put("W_finyrID", finYrId);
				
				parameters.put("W_groupID", groupId);
				parameters.put("W_ledgerID", ledgerId);
				
				parameters.put("W_asOnDate", asOnDt);
				
				if(report_format==1) //pdf
				{
					fileName = "AccountBalance.pdf";
					jasperFile = "AccountBalance.jrxml";
				}
				else if(report_format==2) //xls
				{
					fileName = "AccountBalance.xlsx";
					jasperFile = "AccountBalanceXls.jrxml";
				}
				

				if(report_format==1)
				{
					// call method to generate pdf
					generatePDF(request, response, fileName, parameters,connection, jasperFile);
				}
				else if(report_format==2) {
					// call method to generate xls
					generateXLSX(request, response, fileName, parameters,connection, jasperFile);
				}
				
				File file = new File(request.getRealPath("/") + "/jasper/procurement/" + fileName);
				InputStream is = new FileInputStream(file);
				
				if(report_format==1) //PDF
				{
					response.reset();
					response.setHeader("Content-Type", "application/pdf");
					response.setHeader("Content-Length", String.valueOf(file.length()));
					response.setHeader("Content-Disposition", "inline; filename=\""+ fileName + "\"");
				}
				else if(report_format==2) { //XLSX
					response.reset();
					response.setHeader("Content-Length", String.valueOf(file.length()));
					response.setHeader("Content-Disposition", "attachment; filename=\""+ fileName + "\""); //for excel file download
				}
				
				
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
	    finally {
	      try {
	        if(connection != null) connection.close();
	      } catch (SQLException e) {
	        e.printStackTrace();
	      }
	      if(em != null) em.close();
	    }
		}
		
		@Path(value = "/report/profitNLossReport")
		@GET
		public void getProfitLossReport (
				@QueryParam(value = "cmpnyId") int cmpnyId,
				@QueryParam(value = "storeId") int storeId,
				@QueryParam(value = "finYrId") int finYrId,

				@QueryParam(value = "asOnDate") String asOnDate,
				@QueryParam(value = "report_format") int report_format, //1:PDF / 2:XLS
				
				@Context HttpServletRequest request,
				@Context HttpServletResponse response) {
			
			//System.out.println("accountBalance Parameters are : cmpnyId = "+cmpnyId +", storeId = "+storeId+", finYrId = "+finYrId+", asOnDate = "+asOnDate+", report_format = "+report_format);
			String fileName = null;
			Connection connection = null;
			EntityManagerFactory entityManagerFactory;
			EntityManager em = null;
			String jasperFile = null;
			try {
				String DATE_FORMAT_NEEDED = "MM/dd/yyyy";
				String DATE_FORMAT_RECEIVED = "yyyy-MM-dd";
				String convertdAsOnDate=DateUtil.convertReceivedDateToNeededDateStr(DATE_FORMAT_RECEIVED,DATE_FORMAT_NEEDED,asOnDate);
				entityManagerFactory = PersistenceListener.getEntityManager();
				em = entityManagerFactory.createEntityManager();

				// get connection object from entity manager
				Session ses = (Session) em.getDelegate();
				SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
						.getSessionFactory();

				connection = sessionFactory.getConnectionProvider().getConnection();
				//String asOnDatestr=mapper.getAsOnDate();
				java.sql.Date asOnDt= DateUtil.convertStringDateToSqlDate(convertdAsOnDate, DATE_FORMAT_NEEDED);
				
				
				Map<String, Object> parameters = new HashMap<String,Object>();

				parameters.put("W_companyID", cmpnyId);
				parameters.put("W_storeID", storeId);
				parameters.put("W_finyrID", finYrId);
				
				parameters.put("W_asOnDate", asOnDt);
				
				if(report_format==1) //pdf
				{
					fileName = "ProfitNLoss.pdf";
					jasperFile = "ProfitNLoss.jrxml";
				}
				else if(report_format==2) //xls
				{
					fileName = "ProfitNLoss.xlsx";
					jasperFile = "ProfitNLossXls.jrxml";
				}
				

				if(report_format==1)
				{
					// call method to generate pdf
					generatePDF(request, response, fileName, parameters,connection, jasperFile);
				}
				else if(report_format==2) {
					// call method to generate xls
					generateXLSX(request, response, fileName, parameters,connection, jasperFile);
				}
				
				File file = new File(request.getRealPath("/") + "/jasper/procurement/" + fileName);
				InputStream is = new FileInputStream(file);
				
				if(report_format==1) //PDF
				{
					response.reset();
					response.setHeader("Content-Type", "application/pdf");
					response.setHeader("Content-Length", String.valueOf(file.length()));
					response.setHeader("Content-Disposition", "inline; filename=\""+ fileName + "\"");
				}
				else if(report_format==2) { //XLSX
					response.reset();
					response.setHeader("Content-Length", String.valueOf(file.length()));
					response.setHeader("Content-Disposition", "attachment; filename=\""+ fileName + "\""); //for excel file download
				}
				
				
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
	    finally {
	      try {
	        if(connection != null) connection.close();
	      } catch (SQLException e) {
	        e.printStackTrace();
	      }
	      if(em != null) em.close();
	    }
		}
	
		// method to generate sub report and return
		public void generateSubReport(HttpServletRequest request,
				HttpServletResponse response, String fileName,
				Map<String, Object> parameters, Connection connection,
				String jasperFile) throws FileNotFoundException, IOException {
			
			JasperReport report=null;
			try {
				//System.out.println("fileName = "+fileName);
				//System.out.println("jasperFile = "+jasperFile);
				//System.out.println("jasperfile path = "+request.getRealPath("/jasper") + "\\procurement\\" + jasperFile);
				
				
				File file = new File(request.getRealPath("/") + "/jasper/procurement/"+ fileName);
				
				//Create .jasper file as per filename
				JasperCompileManager.compileReportToFile(request.getRealPath("/jasper") + "/procurement/" + jasperFile,request.getRealPath("/jasper") + "/procurement/" + fileName);

				/*JasperPrint print = JasperFillManager.fillReport(report,
						parameters, connection);
				JasperExportManager.exportReportToPdfFile(print,
						request.getRealPath("/") + "/jasper/procurement/" + fileName);*/

			}

			catch (JRException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				
			}
//					return request.getRealPath("/jasper") + "/procurement/" + fileName;
			
			//return request.getRealPath("/jasper") + "/procurement/";
			
			// Inform JSF that it doesn't need to handle response.
			// This is very important, otherwise you will get the following
			// exception in the logs:
			// java.lang.IllegalStateException: Cannot forward after response has
			// been committed.
			// context.responseComplete();
		}
				
	
	// method to generate pdf
		public void generatePDF(HttpServletRequest request,
				HttpServletResponse response, String fileName,
				Map<String, Object> parameters, Connection connection,
				String jasperFile) throws FileNotFoundException, IOException {
			

			try {
				//System.out.println("fileName = "+fileName);
				//System.out.println("jasperFile = "+jasperFile);
				//System.out.println("jasperfile path = "+request.getRealPath("/jasper") + "\\procurement\\" + jasperFile);
				
				
				File file = new File(request.getRealPath("/") + "/jasper/procurement/"+ fileName);
				
				//File jfile = new File(request.getRealPath("/jasper") + "\\procurement\\" + jasperFile);
				
				//old script
				JasperReport report;
				report = JasperCompileManager.compileReport(request.getRealPath("/jasper") + "/procurement/" + jasperFile);

				//new scripts
				//File file2 = JRResourcesUtil.resolveFile(request.getRealPath("/jasper") + "\\procurement\\", (FileResolver) jfile);
			//	InputStream jasperStream = getClass().getResourceAsStream(request.getRealPath("/jasper") + "\\procurement\\" + jasperFile);
				
				//InputStream jasperStream = new FileInputStream(jfile);
				//JasperReport report = (JasperReport) JRLoader.loadObject(jasperStream);
				//JasperReport report = (JasperReport) JRLoader.loadObject(request.getRealPath("/jasper") + "\\procurement\\" + jasperFile);
				//JasperReport report = (JasperReport) JRLoader.loadObjectFromFile(request.getRealPath("/jasper") + "/procurement/" + jasperFile);
				
				JasperPrint print = JasperFillManager.fillReport(report,
						parameters, connection);
				JasperExportManager.exportReportToPdfFile(print,
						request.getRealPath("/") + "/jasper/procurement/" + fileName);

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
		  public void generateXLSX(HttpServletRequest request,
		      HttpServletResponse response, String fileName,
		      Map<String, Object> parameters, Connection connection,
		      String jasperFile) throws FileNotFoundException, IOException {

		    
		    try {
		      JasperReport report = JasperCompileManager.compileReport(request.getSession().getServletContext().getRealPath("/jasper"+ "/procurement/" + jasperFile));
		      JasperPrint print = JasperFillManager.fillReport(report, parameters, connection);
		      
		      File xlsxFile = new File(request.getSession().getServletContext().getRealPath("/" + "/jasper/procurement/" + fileName));
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
		  

	public ProcurementService getProcurementService() {
		return procurementService;
	}

	public void setProcurementService(ProcurementService procurementService) {
		this.procurementService = procurementService;
	}

}
