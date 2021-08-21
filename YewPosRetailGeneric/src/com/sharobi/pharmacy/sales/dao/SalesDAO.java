package com.sharobi.pharmacy.sales.dao;

import java.util.List;

import com.sharobi.pharmacy.common.CommonResultSetMapper;
import com.sharobi.pharmacy.common.model.EsiCodeMaster;
import com.sharobi.pharmacy.common.model.ResponseObj;
import com.sharobi.pharmacy.common.model.TypeMaster;
import com.sharobi.pharmacy.exceptions.DAOException;
import com.sharobi.pharmacy.inventory.model.CustomerMaster;
import com.sharobi.pharmacy.inventory.model.CustomerType;
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


/**
 * rajarshi
 */
public interface SalesDAO {

	public List<CustomerInfoDTO> getCustWithCreditLimitByName(CommonResultSetMapper mapper)
			throws DAOException;
	
	public CustPaymentDetailsAllDTO getCustPaymentHeaderById(CommonResultSetMapper mapper)
			throws DAOException;
	public SaleHeaderDTO getSalesHeaderForBill(CommonResultSetMapper mapper)
			throws DAOException;
	public SaleHeaderDTO getSalesHeader(CommonResultSetMapper mapper)
			throws DAOException;
	public SaleHeaderDTO getSalesHeaderByInvNo(CommonResultSetMapper mapper)
			throws DAOException;
	public String postALLSalesInvoice(Sales sales)throws DAOException;
	
	public List<SaleDetailsDTO> getSalesDetailsByIdForBill(CommonResultSetMapper mapper)
			throws DAOException;
	
	public List<EsiCodeMaster> getEsiCodes(CommonResultSetMapper mapper) throws DAOException;
	
	public List<TypeMaster> getTypes(CommonResultSetMapper mapper) throws DAOException;
	
	public List<TaxDetailsSaleBillDTO> getTaxDetailsForSaleBill(CommonResultSetMapper mapper)
			throws DAOException;
	
	public List<CommonResultSetMapper> getAutoRemarks(CommonResultSetMapper mapper)
			throws DAOException;
	
	public List<SaleItemDetailsDTO> getSaleItemDetailsByItemId(CommonResultSetMapper mapper)
			throws DAOException;
	
	public List<SaleDetailsDTO> getSalesDetailsById(CommonResultSetMapper mapper)
			throws DAOException;
	
	public List<PaymentMode> getPaymentModes(CommonResultSetMapper mapper) throws DAOException;
	
	public List<SaleDetailsDTO> getSalesDetailsByInvNo(CommonResultSetMapper mapper)
			throws DAOException;
	
	public List<SaleReturnDTO> getAllSalesReturnDetails(CommonResultSetMapper mapper)
			throws DAOException;
	
	public SaleReturnDTO getSaleReturnHeader(CommonResultSetMapper mapper)
			throws DAOException;
	
	public List<SaleReturnDetailsDTO> getSaleReturnDetails(CommonResultSetMapper mapper)
			throws DAOException;
	
	public List<SaleReturnDetailsSerialMapper> getSerialSaleReturnStatus(CommonResultSetMapper mapper)
			throws DAOException;
	
	public List<SaleDetailsForReturnDTO> getSaleDetailsForReturnByItem(CommonResultSetMapper mapper)
			throws DAOException;
	
	public List<SaleDetailsForReturnDTO> getSaleDetailsForReturn(CommonResultSetMapper mapper)
			throws DAOException;
	
	public List<SaleReturnDTO> getAdjSaleReturn(CommonResultSetMapper mapper)
			throws DAOException;
	
	public List<SaleReturnDTO> getAdjSaleReturnBySaleId(CommonResultSetMapper mapper)
			throws DAOException;
	
	public List<SaleDetailsAllDTO> getAllSaleDetails(CommonResultSetMapper mapper)
			throws DAOException;
	
	public List<CustPaymentDetailsByIdDTO> getCustPaymentDetailsById(CommonResultSetMapper mapper)
			throws DAOException;
	
	public List<CustPaymentDetailsByIdDTO> getPendingPaymentByCustomer(CommonResultSetMapper mapper)
			throws DAOException;
	
	public List<CustPaymentDetailsAllDTO> getAllCustPaymentDetails(CommonResultSetMapper mapper)
			throws DAOException;
	
	public List<SaleHeaderDTO> getLastSaleByCustomer(CommonResultSetMapper mapper)
			throws DAOException;
	
	public List<CustomerMaster> getAllCustomerByNameOrPh(CommonResultSetMapper mapper)
			throws DAOException;
	
	public String createOrUpdateSalesInvoice(Sales sales)
			throws DAOException;
	
	public String createOrUpdateCustPayment(CustomerPayment customerPayment)
			throws DAOException;
	
	public String createOrUpdateSalesReturn(SaleReturn sales)
			throws DAOException;
	public String postSalesInvoice(CommonResultSetMapper mapper)
			throws DAOException;
	
	public String postCustPayment(CommonResultSetMapper mapper)
			throws DAOException;
	
	public String postSalesReturn(CommonResultSetMapper mapper)
			throws DAOException;
	
	/*public int printSaleBill(String id, String saleId)
			throws DAOException;*/
	
	public int incrementPrintCount(String id)
			throws DAOException;
	
	public String deleteCustPayment(CommonResultSetMapper mapper)
			throws DAOException;
	
	public String deleteSalesInvoice(CommonResultSetMapper mapper)
			throws DAOException;
	
	public String deleteSalesReturn(CommonResultSetMapper mapper)
			throws DAOException;

	public List<CustomerType> getCustomerType(CommonResultSetMapper mapper)throws DAOException;
	
	public int getTotal(String id)throws DAOException;
	
	public String postALLReturnSalesInvoice(SaleReturn salereturn) throws DAOException;

	public String insertCardPayment(CardPaymentStatus cardPaymentStatus) throws DAOException;

	public String updateCardPayment(CardPaymentStatus cardPaymentStatus) throws DAOException;

	public List<CardPaymentStatus> getAllCardPayments(CommonResultSetMapper mapper) throws DAOException;

	public String deleteCardPaytmentID(CardPaymentStatus cardPStatus) throws DAOException;

	public List<CardPaymentStatus> getAllSaleTransaction(CommonResultSetMapper mapper) throws DAOException;

	public ResponseObj createOrUpdateSaleOrder(SaleOrder saleOrder) throws DAOException;

	public List<SaleOrderDTO> getAllSaleOrderDetails(CommonResultSetMapper mapper) throws DAOException;

	public SaleOrderDTO getSaleOrderHeaderById(CommonResultSetMapper mapper) throws DAOException;
	
	public List<SaleOrderDetailsDTO> getSaleOrderDetailsById(CommonResultSetMapper mapper)
			throws DAOException;
	public List<SaleOrderDetailsDTO> getSaleOrderDetailsByInvNo(CommonResultSetMapper mapper)
			throws DAOException;

	 public ResponseObj closeSaleOrder(CommonResultSetMapper mapper) throws DAOException;

	 public ResponseObj deleteSaleOrder(CommonResultSetMapper mapper) throws DAOException;

	 public ResponseObj postSaleOrder(CommonResultSetMapper mapper) throws DAOException;

	public List<SaleOrderDetailsDTO> getPendingSaleOrderDetails(CommonResultSetMapper mapper) throws DAOException;

	public List<SaleOrderDetailsDTO> getSalesOrderDetailsByIdForBill(CommonResultSetMapper mapper) throws DAOException;

	public SaleOrderHeaderDTO getSalesOrderHeaderForBill(CommonResultSetMapper mapper) throws DAOException;

	public List<TaxDetailsSaleBillDTO> getTaxDetailsForSaleOrderBill(CommonResultSetMapper mapper) throws DAOException;

	public ResponseObj createOrUpdateSaleTourPlan(SaleTourPlan saleTourPlan) throws DAOException;
	//added on 27.06.2019
	public List<SaleTourPlanDTO> getAllSaleTourPlanDetails(CommonResultSetMapper mapper) throws DAOException;

	public SaleTourPlanDTO getSaleTourPlanHeaderById(CommonResultSetMapper mapper) throws DAOException;
	
	public List<SaleTourPlanDetailsDTO> getSaleTourPlanDetailsById(CommonResultSetMapper mapper)
			throws DAOException;

	 public ResponseObj cancelSaleTourPlan(CommonResultSetMapper mapper) throws DAOException;

	 public ResponseObj deleteSaleTourPlan(CommonResultSetMapper mapper) throws DAOException;

	 public ResponseObj postSaleTourPlan(CommonResultSetMapper mapper) throws DAOException;
	 
	 public ResponseObj createSaleManTourDetail(SaleManTourDetails salesmanTour) throws DAOException;
	 
	 public List<SaleManTourDetailsDTO> getSaleManTourDetails(CommonResultSetMapper mapper) throws DAOException;
	 
	 public ResponseObj getSaleManCheckinStatus(CommonResultSetMapper mapper) throws DAOException;
	 
	 public ResponseObj getSaleManCheckoutStatus(CommonResultSetMapper mapper) throws DAOException;
	 
	 public ResponseObj createSaleManTourDetailOffline(SaleManTour salesmanTourList) throws DAOException;
}
