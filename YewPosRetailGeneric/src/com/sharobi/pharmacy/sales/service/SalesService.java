package com.sharobi.pharmacy.sales.service;

import java.util.List;

import com.sharobi.pharmacy.common.CommonResultSetMapper;
import com.sharobi.pharmacy.common.model.EsiCodeMaster;
import com.sharobi.pharmacy.common.model.ResponseObj;
import com.sharobi.pharmacy.common.model.TypeMaster;
import com.sharobi.pharmacy.exceptions.DAOException;
import com.sharobi.pharmacy.exceptions.ServiceException;
import com.sharobi.pharmacy.inventory.model.CustomerMaster;
import com.sharobi.pharmacy.inventory.model.CustomerType;
import com.sharobi.pharmacy.sales.dao.SalesDAO;
import com.sharobi.pharmacy.sales.dao.impl.SalesDAOImpl;
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

public class SalesService {

	private SalesDAO salesDAO = new SalesDAOImpl();

	public SalesService() {

	}
	
	public List<CustomerInfoDTO> getCustWithCreditLimitByName(CommonResultSetMapper mapper) throws ServiceException {

		List<CustomerInfoDTO> custDTO = null;
		try {

			custDTO = salesDAO.getCustWithCreditLimitByName(mapper);

		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException(
					"problem occured while trying to get cust credit limit by name", e);

		}
		return custDTO;
	}
	
	public CustPaymentDetailsAllDTO getCustPaymentHeaderById(CommonResultSetMapper mapper) throws ServiceException {

		CustPaymentDetailsAllDTO saleHeaderDTO = null;
		try {

			saleHeaderDTO = salesDAO.getCustPaymentHeaderById(mapper);

		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException(
					"problem occured while trying to get cust payment header by id", e);

		}
		return saleHeaderDTO;
	}
	
	public SaleHeaderDTO getSalesHeaderForBill(CommonResultSetMapper mapper) throws ServiceException {

		SaleHeaderDTO saleHeaderDTO = null;
		try {

			saleHeaderDTO = salesDAO.getSalesHeaderForBill(mapper);

		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException(
					"problem occured while trying to get sale header for bill", e);

		}
		return saleHeaderDTO;
	}
	
	public SaleHeaderDTO getSalesHeader(CommonResultSetMapper mapper) throws ServiceException {

		SaleHeaderDTO saleHeaderDTO = null;
		try {

			saleHeaderDTO = salesDAO.getSalesHeader(mapper);

		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException(
					"problem occured while trying to get sale header", e);

		}
		return saleHeaderDTO;
	}
	
	public String postALLSalesInvoice(Sales sales) throws ServiceException {
		String stockInId = "";
		try {
			
			stockInId = salesDAO.postALLSalesInvoice(sales);
			

		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException("error postALLSalesInvoice", e);

		}
		return stockInId;
	}
	
	public SaleHeaderDTO getSalesHeaderByInvNo(CommonResultSetMapper mapper) throws ServiceException {

		SaleHeaderDTO saleHeaderDTO = null;
		try {

			saleHeaderDTO = salesDAO.getSalesHeaderByInvNo(mapper);

		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException(
					"problem occured while trying to get sale header by inv no.", e);

		}
		return saleHeaderDTO;
	}
	
	public String postSalesInvoice(CommonResultSetMapper mapper)
			throws ServiceException {
		String stockInId = "";
		try {
			
			stockInId = salesDAO.postSalesInvoice(mapper);
			

		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException("error posting sales invoice", e);

		}
		return stockInId;
	}
	
	public String postCustPayment(CommonResultSetMapper mapper)
			throws ServiceException {
		String stockInId = "";
		try {
			
			stockInId = salesDAO.postCustPayment(mapper);
			

		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException("error posting cust payment", e);

		}
		return stockInId;
	}
	
	public String postSalesReturn(CommonResultSetMapper mapper)
			throws ServiceException {
		String stockInId = "";
		try {
			
			stockInId = salesDAO.postSalesReturn(mapper);
			

		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException("error posting sales return", e);

		}
		return stockInId;
	}
	
	/*public int printSaleBill(String storeId, String saleId)
			throws ServiceException {
		int stockInId = 0;
		try {
			
			stockInId = salesDAO.printSaleBill(storeId,saleId);
			

		} catch (DAOException e) {
			throw new ServiceException("error printing sale bill", e);

		}
		return stockInId;
	}*/
	
	public int incrementPrintCount(String id)
			throws ServiceException {
		int stockInId = 0;
		try {
			
			stockInId = salesDAO.incrementPrintCount(id);
			

		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException("error incrementing print/reprint count", e);

		}
		return stockInId;
	}
	
	public String deleteCustPayment(CommonResultSetMapper mapper)
			throws ServiceException {
		String status = "";
		try {
			
			status = salesDAO.deleteCustPayment(mapper);
			

		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException("error deleting cust payment", e);

		}
		return status;
	}
	
	public String deleteSalesInvoice(CommonResultSetMapper mapper)
			throws ServiceException {
		String status = "";
		try {
			
			status = salesDAO.deleteSalesInvoice(mapper);
			

		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException("error deleting sales invoice", e);

		}
		return status;
	}
	
	public String deleteSalesReturn(CommonResultSetMapper mapper)
			throws ServiceException {
		String status = "";
		try {
			
			status = salesDAO.deleteSalesReturn(mapper);
			

		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException("error deleting sales return", e);

		}
		return status;
	}
	
	public List<SaleDetailsDTO> getSalesDetailsByIdForBill(CommonResultSetMapper mapper) throws ServiceException {

		List<SaleDetailsDTO> saleHeaderDTO = null;
		try {

			saleHeaderDTO = salesDAO.getSalesDetailsByIdForBill(mapper);

		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException(
					"problem occured while trying to get sale details fr bill", e);

		}
		return saleHeaderDTO;
	}
	
	public List<EsiCodeMaster> getEsiCodes(CommonResultSetMapper mapper) throws ServiceException {

		List<EsiCodeMaster> type = null;
		try {

			type = salesDAO.getEsiCodes(mapper);

		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException(
					"problem occured while trying to get esi codes", e);

		}
		return type;
	}
	
	public List<TypeMaster> getTypes(CommonResultSetMapper mapper) throws ServiceException {

		List<TypeMaster> type = null;
		try {

			type = salesDAO.getTypes(mapper);

		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException(
					"problem occured while trying to get types", e);

		}
		return type;
	}
	
	public List<TaxDetailsSaleBillDTO> getTaxDetailsForSaleBill(CommonResultSetMapper mapper) throws ServiceException {

		List<TaxDetailsSaleBillDTO> taxes = null;
		try {

			taxes = salesDAO.getTaxDetailsForSaleBill(mapper);

		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException(
					"problem occured while trying to get tax details for sale bill", e);

		}
		return taxes;
	}
	
	public List<CommonResultSetMapper> getAutoRemarks(CommonResultSetMapper mapper) throws ServiceException {

		List<CommonResultSetMapper> list = null;
		try {

			list = salesDAO.getAutoRemarks(mapper);

		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException(
					"problem occured while trying to get auto remarks", e);

		}
		return list;
	}
	
	public List<SaleItemDetailsDTO> getSaleItemDetailsByItemId(CommonResultSetMapper mapper) throws ServiceException {

		List<SaleItemDetailsDTO> detailsDTOs = null;
		try {

			detailsDTOs = salesDAO.getSaleItemDetailsByItemId(mapper);

		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException(
					"problem occured while trying to get sale item details by item id", e);

		}
		return detailsDTOs;
	}
	
	public List<SaleDetailsDTO> getSalesDetailsById(CommonResultSetMapper mapper) throws ServiceException {

		List<SaleDetailsDTO> saleHeaderDTO = null;
		try {

			saleHeaderDTO = salesDAO.getSalesDetailsById(mapper);

		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException(
					"problem occured while trying to get sale details by id", e);

		}
		return saleHeaderDTO;
	}
	
	public List<PaymentMode> getPaymentModes(CommonResultSetMapper mapper) throws ServiceException {

		List<PaymentMode> paymentModes = null;
		try {

			paymentModes = salesDAO.getPaymentModes(mapper);

		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException(
					"problem occured while trying to get payment modes", e);

		}
		return paymentModes;
	}
	
	
	
	public List<SaleDetailsDTO> getSalesDetailsByInvNo(CommonResultSetMapper mapper) throws ServiceException {

		List<SaleDetailsDTO> saleHeaderDTO = null;
		try {

			saleHeaderDTO = salesDAO.getSalesDetailsByInvNo(mapper);

		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException(
					"problem occured while trying to get sale details by inv no.", e);

		}
		return saleHeaderDTO;
	}
	
	public List<SaleReturnDTO> getAllSalesReturnDetails(CommonResultSetMapper mapper) throws ServiceException {

		List<SaleReturnDTO> saleHeaderDTO = null;
		try {

			saleHeaderDTO = salesDAO.getAllSalesReturnDetails(mapper);

		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException(
					"problem occured while trying to get sale return details", e);

		}
		return saleHeaderDTO;
	}
	
	public SaleReturnDTO getSaleReturnHeader(CommonResultSetMapper mapper) throws ServiceException {

		SaleReturnDTO saleHeaderDTO = null;
		try {

			saleHeaderDTO = salesDAO.getSaleReturnHeader(mapper);

		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException(
					"problem occured while trying to get sale return header", e);

		}
		return saleHeaderDTO;
	}
	
	public List<SaleReturnDetailsDTO> getSaleReturnDetails(CommonResultSetMapper mapper) throws ServiceException {

		List<SaleReturnDetailsDTO> saleHeaderDTO = null;
		try {

			saleHeaderDTO = salesDAO.getSaleReturnDetails(mapper);

		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException(
					"problem occured while trying to get sale return details by id", e);

		}
		return saleHeaderDTO;
	}
	
	public List<SaleReturnDetailsSerialMapper> getSerialSaleReturnStatus(CommonResultSetMapper mapper) throws ServiceException {

		List<SaleReturnDetailsSerialMapper> saleHeaderDTO = null;
		try {

			saleHeaderDTO = salesDAO.getSerialSaleReturnStatus(mapper);

		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException(
					"problem occured while trying to get serial sale return status.", e);

		}
		return saleHeaderDTO;
	}
	
	public List<SaleDetailsForReturnDTO> getSaleDetailsForReturnByItem(CommonResultSetMapper mapper) throws ServiceException {

		List<SaleDetailsForReturnDTO> saleHeaderDTO = null;
		try {

			saleHeaderDTO = salesDAO.getSaleDetailsForReturnByItem(mapper);

		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException(
					"problem occured while trying to get sale return details for return by inv no.", e);

		}
		return saleHeaderDTO;
	}
	
	public List<SaleDetailsForReturnDTO> getSaleDetailsForReturn(CommonResultSetMapper mapper) throws ServiceException {

		List<SaleDetailsForReturnDTO> saleHeaderDTO = null;
		try {

			saleHeaderDTO = salesDAO.getSaleDetailsForReturn(mapper);

		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException(
					"problem occured while trying to get sale return details for return by inv no.", e);

		}
		return saleHeaderDTO;
	}
	
	public List<SaleReturnDTO> getAdjSaleReturn(CommonResultSetMapper mapper) throws ServiceException {

		List<SaleReturnDTO> returnAdjDTOs = null;
		try {

			returnAdjDTOs = salesDAO.getAdjSaleReturn(mapper);

		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException(
					"problem occured while trying to get sale return adjustment by inv no.", e);

		}
		return returnAdjDTOs;
	}
	
	
	
	public List<SaleReturnDTO> getAdjSaleReturnBySaleId(CommonResultSetMapper mapper) throws ServiceException {

		List<SaleReturnDTO> returnAdjDTOs = null;
		try {

			returnAdjDTOs = salesDAO.getAdjSaleReturnBySaleId(mapper);

		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException(
					"problem occured while trying to get sale return adjustment by sale id", e);

		}
		return returnAdjDTOs;
	}
	
	public List<CustPaymentDetailsByIdDTO> getCustPaymentDetailsById(CommonResultSetMapper mapper) throws ServiceException {

		List<CustPaymentDetailsByIdDTO> saleHeaderDTO = null;
		try {

			saleHeaderDTO = salesDAO.getCustPaymentDetailsById(mapper);

		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException(
					"problem occured while trying to get cust payment details by id", e);

		}
		return saleHeaderDTO;
	}
	
	public List<CustPaymentDetailsByIdDTO> getPendingPaymentByCustomer(CommonResultSetMapper mapper) throws ServiceException {

		List<CustPaymentDetailsByIdDTO> saleHeaderDTO = null;
		try {

			saleHeaderDTO = salesDAO.getPendingPaymentByCustomer(mapper);

		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException(
					"problem occured while trying to get pending payment by cust", e);

		}
		return saleHeaderDTO;
	}
	
	public List<CustPaymentDetailsAllDTO> getAllCustPaymentDetails(CommonResultSetMapper mapper) throws ServiceException {

		List<CustPaymentDetailsAllDTO> saleHeaderDTO = null;
		try {

			saleHeaderDTO = salesDAO.getAllCustPaymentDetails(mapper);

		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException(
					"problem occured while trying to get all cust payment details", e);

		}
		return saleHeaderDTO;
	}
	
	public List<SaleDetailsAllDTO> getAllSaleDetails(CommonResultSetMapper mapper) throws ServiceException {

		List<SaleDetailsAllDTO> saleHeaderDTO = null;
		try {

			saleHeaderDTO = salesDAO.getAllSaleDetails(mapper);

		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException(
					"problem occured while trying to get all sale details", e);

		}
		return saleHeaderDTO;
	}
	
	
	public int getTotal(String id)
			throws ServiceException {
		int stockInId = 0;
		try {
			
			stockInId = salesDAO.getTotal(id);
			

		} catch (DAOException e) {
			throw new ServiceException("error getTotalCount", e);

		}
		return stockInId;
	}
	
	
	
	
	public List<SaleHeaderDTO> getLastSaleByCustomer(CommonResultSetMapper mapper) throws ServiceException {

		List<SaleHeaderDTO> lastSales = null;
		try {

			lastSales = salesDAO.getLastSaleByCustomer(mapper);

		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException(
					"problem occured while trying to get last sale by customer", e);

		}
		return lastSales;
	}
	
	public List<CustomerMaster> getAllCustomerByNameOrPh(CommonResultSetMapper mapper) throws ServiceException {

		List<CustomerMaster> customer = null;
		try {

			customer = salesDAO.getAllCustomerByNameOrPh(mapper);

		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException(
					"problem occured while trying to get all customer", e);

		}
		return customer;
	}
	
	public String createOrUpdateSalesInvoice(Sales sales)
			throws ServiceException {
		String stockInId = "";
		try {
			
			stockInId = salesDAO.createOrUpdateSalesInvoice(sales);
			

		} catch (DAOException e) {
			throw new ServiceException("error creating sales invoice", e);

		}
		return stockInId;
	}
	
	public String createOrUpdateCustPayment(CustomerPayment customerPayment)
			throws ServiceException {
		String stockInId = "";
		try {
			
			stockInId = salesDAO.createOrUpdateCustPayment(customerPayment);
			

		} catch (DAOException e) {
			throw new ServiceException("error creating cust payment", e);

		}
		return stockInId;
	}
	
	public String createOrUpdateSalesReturn(SaleReturn sales)
			throws ServiceException {
		String stockInId = "";
		try {
			
			stockInId = salesDAO.createOrUpdateSalesReturn(sales);
			

		} catch (DAOException e) {
			throw new ServiceException("error creating sales invoice", e);

		}
		return stockInId;
	}
	
	
	public SalesDAO getSalesDAO() {
		return salesDAO;
	}

	public void setSalesDAO(SalesDAO salesDAO) {
		this.salesDAO = salesDAO;
	}

	public List<CustomerType> getCustomerType(CommonResultSetMapper mapper) throws ServiceException{
		List<CustomerType> customer = null;
		try {

			customer = salesDAO.getCustomerType(mapper);

		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException(
					"problem occured while trying to get all customer", e);

		}
		return customer;
	}

	public String postALLReturnSalesInvoice(SaleReturn salereturn) throws ServiceException{
		String stockInId = "";
		try {
			
			stockInId = salesDAO.postALLReturnSalesInvoice(salereturn);
			

		} catch (DAOException e) {
			throw new ServiceException("error postALLSalesReturnInvoice", e);

		}
		return stockInId;
	}

	public String insertCardPayment(CardPaymentStatus cardPaymentStatus) throws ServiceException{
		String responseObj="";
		try {
			responseObj = salesDAO.insertCardPayment(cardPaymentStatus);

		}catch(DAOException e) {
			e.printStackTrace();
			throw new ServiceException("error inserting card payment", e);

		}
		return responseObj;
	}

	public String updateCardPayment(CardPaymentStatus cardPaymentStatus) throws ServiceException {
		String responseObj="";
		try {
			responseObj = salesDAO.updateCardPayment(cardPaymentStatus);

		}catch(DAOException e) {
			e.printStackTrace();
			throw new ServiceException("error inserting card payment", e);

		}
		return responseObj;
	}

	public List<CardPaymentStatus> getAllCardPayments(CommonResultSetMapper mapper) throws ServiceException {
		List<CardPaymentStatus> payments = null;
		try {

			payments = salesDAO.getAllCardPayments(mapper);

		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException(
					"problem occured while trying to get all payments", e);

		}
		return payments;
	}

	public String deleteCardPaytmentID(CardPaymentStatus cardPStatus)
			throws ServiceException {
			String status = "";
			try {
				
				status = salesDAO.deleteCardPaytmentID(cardPStatus);
				
	
			} catch (DAOException e) {
				throw new ServiceException("error deleting sales invoice", e);
	
			}
			return status;
	}

	 public List<CardPaymentStatus> getAllSaleTransaction(CommonResultSetMapper mapper) throws ServiceException {

         List<CardPaymentStatus> saleHeaderDTO = null;
		try {
		
		saleHeaderDTO = salesDAO.getAllSaleTransaction(mapper);
		
		} catch (DAOException e) {
		e.printStackTrace();
		throw new ServiceException(
				"problem occured while trying to get sale details", e);
		
		}
		return saleHeaderDTO;
		}

	public ResponseObj createOrUpdateSaleOrder(SaleOrder saleOrder)
			throws ServiceException {
		ResponseObj status = null;
		try {
			
			status = salesDAO.createOrUpdateSaleOrder(saleOrder);
			

		} catch (DAOException e) {
			throw new ServiceException("error creating Sale order", e);

		}
		return status;
	}

	 public List<SaleOrderDTO> getAllSaleOrderDetails(CommonResultSetMapper mapper) throws ServiceException {

		List<SaleOrderDTO> sales = null;
		try {

			sales = salesDAO.getAllSaleOrderDetails(mapper);

		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException(
					"problem occured while trying to get sale order details", e);

		}
		return sales;
	}

	public SaleOrderDTO getSaleOrderHeaderById(CommonResultSetMapper mapper) throws ServiceException {
		SaleOrderDTO sale = null;
		try {

			sale = salesDAO.getSaleOrderHeaderById(mapper);

		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException(
					"problem occured while trying to get purchase order header", e);

		}
		return sale;
	}
	
	
	public List<SaleOrderDetailsDTO> getSaleOrderDetailsById(CommonResultSetMapper mapper) throws ServiceException {

		List<SaleOrderDetailsDTO> sale = null;
		try {

			sale = salesDAO.getSaleOrderDetailsById(mapper);

		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException(
					"problem occured while trying to get sale order details by id", e);

		}
		return sale;
	}

	public List<SaleOrderDetailsDTO> getSaleOrderDetailsByInvNo(CommonResultSetMapper mapper) throws ServiceException {

		List<SaleOrderDetailsDTO> sale = null;
		try {

			sale = salesDAO.getSaleOrderDetailsByInvNo(mapper);

		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException(
					"problem occured while trying to get sale order details by inv no", e);

		}
		return sale;
	}
	public ResponseObj closeSaleOrder(CommonResultSetMapper mapper) throws ServiceException {
			ResponseObj responseObj = new ResponseObj();
			try {
				
				responseObj = salesDAO.closeSaleOrder(mapper);
				
	
			} catch (DAOException e) {
				throw new ServiceException("error closing PO", e);
	
			}
			return responseObj;
	}

	public ResponseObj deleteSaleOrder(CommonResultSetMapper mapper)
			throws ServiceException {
		ResponseObj responseObj=new ResponseObj();
		try {
			
			responseObj = salesDAO.deleteSaleOrder(mapper);
			

		} catch (DAOException e) {
			throw new ServiceException("error deleting Purchase order", e);

		}
		return responseObj;
	}

	public ResponseObj postSaleOrder(CommonResultSetMapper mapper)
			throws ServiceException {
		ResponseObj responseObj = new ResponseObj();
		try {
			
			responseObj = salesDAO.postSaleOrder(mapper);
			

		} catch (DAOException e) {
			throw new ServiceException("error posting PO", e);

		}
		return responseObj;
	}

	public List<SaleOrderDetailsDTO> getPendingSaleOrderDetails(CommonResultSetMapper mapper) throws ServiceException {

			List<SaleOrderDetailsDTO> sales = null;
			try {

				sales = salesDAO.getPendingSaleOrderDetails(mapper);

			} catch (DAOException e) {
				e.printStackTrace();
				throw new ServiceException(
						"problem occured while trying to get pending purchase order details by inv no.", e);

			}
			return sales;
	}

	public List<SaleOrderDetailsDTO> getSalesOrderDetailsByIdForBill(CommonResultSetMapper mapper) throws ServiceException {

		List<SaleOrderDetailsDTO> saleorderdetailDTO = null;
		try {

			saleorderdetailDTO = salesDAO.getSalesOrderDetailsByIdForBill(mapper);

		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException(
					"problem occured while trying to get sale order details fr bill", e);
		}
		return saleorderdetailDTO;
	}

	public SaleOrderHeaderDTO getSalesOrderHeaderForBill(CommonResultSetMapper mapper) throws ServiceException {

		SaleOrderHeaderDTO saleHeaderDTO = null;
		try {

			saleHeaderDTO = salesDAO.getSalesOrderHeaderForBill(mapper);

		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException(
					"problem occured while trying to get sale order header for bill", e);

		}
		return saleHeaderDTO;
	}

	 public List<TaxDetailsSaleBillDTO> getTaxDetailsForSaleOrderBill(CommonResultSetMapper mapper) throws ServiceException {

			List<TaxDetailsSaleBillDTO> taxes = null;
			try {

				taxes = salesDAO.getTaxDetailsForSaleOrderBill(mapper);

			} catch (DAOException e) {
				e.printStackTrace();
				throw new ServiceException(
						"problem occured while trying to get tax details", e);

			}
			return taxes;
		}
	 
	 public ResponseObj createOrUpdateSaleTourPlan(SaleTourPlan saleTourPlan)
				throws ServiceException {
			ResponseObj status = null;
			try {
				
				status = salesDAO.createOrUpdateSaleTourPlan(saleTourPlan);
				

			} catch (DAOException e) {
				throw new ServiceException("error creating SaleTourPlan", e);

			}
			return status;
		}
	 
	 // added on 27.06.2019
	 public List<SaleTourPlanDTO> getAllSaleTourPlanDetails(CommonResultSetMapper mapper) throws ServiceException {

			List<SaleTourPlanDTO> saletourPlans = null;
			try {

				saletourPlans = salesDAO.getAllSaleTourPlanDetails(mapper);

			} catch (DAOException e) {
				e.printStackTrace();
				throw new ServiceException(
						"problem occured while trying to get sale TourPlan details", e);

			}
			return saletourPlans;
		}

		public SaleTourPlanDTO getSaleTourPlanHeaderById(CommonResultSetMapper mapper) throws ServiceException {
			SaleTourPlanDTO saletourPlan = null;
			try {

				saletourPlan = salesDAO.getSaleTourPlanHeaderById(mapper);

			} catch (DAOException e) {
				e.printStackTrace();
				throw new ServiceException(
						"problem occured while trying to get purchase order header", e);

			}
			return saletourPlan;
		}
		
		
		public List<SaleTourPlanDetailsDTO> getSaleTourPlanDetailsById(CommonResultSetMapper mapper) throws ServiceException {

			List<SaleTourPlanDetailsDTO> stpDetails = null;
			try {

				stpDetails = salesDAO.getSaleTourPlanDetailsById(mapper);

			} catch (DAOException e) {
				e.printStackTrace();
				throw new ServiceException(
						"problem occured while trying to get sale tourplan details by id", e);

			}
			return stpDetails;
		}

		public ResponseObj cancelSaleTourPlan(CommonResultSetMapper mapper) throws ServiceException {
				ResponseObj responseObj = new ResponseObj();
				try {
					
					responseObj = salesDAO.cancelSaleTourPlan(mapper);
					
		
				} catch (DAOException e) {
					throw new ServiceException("error cancel STP", e);
		
				}
				return responseObj;
		}

		public ResponseObj deleteSaleTourPlan(CommonResultSetMapper mapper)
				throws ServiceException {
			ResponseObj responseObj=new ResponseObj();
			try {
				
				responseObj = salesDAO.deleteSaleTourPlan(mapper);
				

			} catch (DAOException e) {
				throw new ServiceException("error deleting sale tourplan", e);

			}
			return responseObj;
		}

		public ResponseObj postSaleTourPlan(CommonResultSetMapper mapper)
				throws ServiceException {
			ResponseObj responseObj = new ResponseObj();
			try {
				
				responseObj = salesDAO.postSaleTourPlan(mapper);
				

			} catch (DAOException e) {
				throw new ServiceException("error posting STP", e);

			}
			return responseObj;
		}
		
		public ResponseObj createSaleManTourDetail(SaleManTourDetails salesmanTour)
				throws ServiceException {
			ResponseObj status = null;
			try {
				
				status = salesDAO.createSaleManTourDetail(salesmanTour);
				

			} catch (DAOException e) {
				throw new ServiceException("error creating SalemanTour", e);

			}
			return status;
		}
		
		public List<SaleManTourDetailsDTO> getSaleManTourDetails(CommonResultSetMapper mapper) throws ServiceException {

			List<SaleManTourDetailsDTO> saletours = null;
			try {

				saletours = salesDAO.getSaleManTourDetails(mapper);

			} catch (DAOException e) {
				e.printStackTrace();
				throw new ServiceException(
						"problem occured while trying to get sale Tour details", e);

			}
			return saletours;
		}
		
		public ResponseObj getSaleManCheckinStatus(CommonResultSetMapper mapper)
				throws ServiceException {
			ResponseObj responseObj = new ResponseObj();
			try {
				
				responseObj = salesDAO.getSaleManCheckinStatus(mapper);
				

			} catch (DAOException e) {
				throw new ServiceException("error getting check in status", e);

			}
			return responseObj;
		}
		
		public ResponseObj getSaleManCheckoutStatus(CommonResultSetMapper mapper)
				throws ServiceException {
			ResponseObj responseObj = new ResponseObj();
			try {
				
				responseObj = salesDAO.getSaleManCheckoutStatus(mapper);
				

			} catch (DAOException e) {
				throw new ServiceException("error getting check out status", e);

			}
			return responseObj;
		}
		
		public ResponseObj createSaleManTourDetailOffline(SaleManTour salesmanTourList)
				throws ServiceException {
			ResponseObj status = null;
			try {
				
				status = salesDAO.createSaleManTourDetailOffline(salesmanTourList);
				

			} catch (DAOException e) {
				throw new ServiceException("error creating SalemanTour offline", e);

			}
			return status;
		}

	
}
