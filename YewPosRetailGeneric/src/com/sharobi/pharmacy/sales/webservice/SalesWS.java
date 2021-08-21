package com.sharobi.pharmacy.sales.webservice;



import javax.ws.rs.QueryParam;

import com.sharobi.pharmacy.common.CommonResultSetMapper;
import com.sharobi.pharmacy.sales.model.CardPaymentStatus;
import com.sharobi.pharmacy.sales.model.CustomerPayment;
import com.sharobi.pharmacy.sales.model.SaleManTour;
import com.sharobi.pharmacy.sales.model.SaleManTourDetails;
import com.sharobi.pharmacy.sales.model.SaleOrder;
import com.sharobi.pharmacy.sales.model.SaleReturn;
import com.sharobi.pharmacy.sales.model.SaleTourPlan;
import com.sharobi.pharmacy.sales.model.Sales;


/**
 * rajarshi
 */
public interface SalesWS {

	public String getSalesHeader(CommonResultSetMapper mapper);
	public String getSalesDetailsById(CommonResultSetMapper mapper);
	public String getAllSaleDetails(CommonResultSetMapper mapper);
	public String createOrUpdateSalesInvoice(Sales sales);
	public String getAllCustomerByNameOrPh(CommonResultSetMapper mapper);
	public String getCustomerType(CommonResultSetMapper mapper);
	public String postSalesInvoice(CommonResultSetMapper mapper);
	public String deleteSalesInvoice(CommonResultSetMapper mapper);
	public String getLastSaleByCustomer(CommonResultSetMapper mapper);
	public String incrementPrintCount(@QueryParam(value = "id") String id, @QueryParam(value = "flag") String flag);
	public String getAllSalesReturnDetails(CommonResultSetMapper mapper);
	public String getSaleReturnHeader(CommonResultSetMapper mapper);
	public String getSaleReturnDetails(CommonResultSetMapper mapper);
	public String getSaleDetailsForReturnByItem(CommonResultSetMapper mapper);
	public String getSalesHeaderByInvNo(CommonResultSetMapper mapper);
	public String getSalesDetailsByInvNo(CommonResultSetMapper mapper);
	public String createOrUpdateSalesReturn(SaleReturn sales);
	public String getSaleDetailsForReturn(CommonResultSetMapper mapper);
	public String postSalesReturn(CommonResultSetMapper mapper);
	public String deleteSalesReturn(CommonResultSetMapper mapper);
	public String getAdjSaleReturn(CommonResultSetMapper mapper);
	public String getAdjSaleReturnBySaleId(CommonResultSetMapper mapper);
	public String getPaymentModes(CommonResultSetMapper mapper);
	public String getAllCustPaymentDetails(CommonResultSetMapper mapper);
	public String getCustPaymentHeaderById(CommonResultSetMapper mapper);
	public String getCustPaymentDetailsById(CommonResultSetMapper mapper);
	public String deleteCustPayment(CommonResultSetMapper mapper);
	public String postCustPayment(CommonResultSetMapper mapper);
	public String createOrUpdateCustPayment(CustomerPayment customerPayment);
	public String getPendingPaymentByCustomer(CommonResultSetMapper mapper);
	public String getCustWithCreditLimitByName(CommonResultSetMapper mapper);
	public String getSalesDetailsByIdForBill(CommonResultSetMapper mapper);
	public String getSalesHeaderForBill(CommonResultSetMapper mapper);
	public String getAutoRemarks(CommonResultSetMapper mapper);
	public String getAllCardPayments(CommonResultSetMapper mapper);
	public String deleteCardPaytmentID(CardPaymentStatus cardPStatus);
	public String getAllSaleTransaction(CommonResultSetMapper mapper);
	public String createOrUpdateSaleOrder(SaleOrder saleOrder);
	public String getAllSaleOrderDetails(CommonResultSetMapper mapper);
	public String getSaleOrderHeaderById(CommonResultSetMapper mapper);
	public String getSaleOrderDetailsById(CommonResultSetMapper mapper);
	public String getSaleOrderDetailsByInvNo(CommonResultSetMapper mapper);
	public String closeSaleOrder(CommonResultSetMapper mapper);
	public String deleteSaleOrder(CommonResultSetMapper mapper);
	public String postSaleOrder(CommonResultSetMapper mapper);
	public String getPendingSaleOrderDetails(CommonResultSetMapper mapper);
	public String getSalesOrderDetailsByIdForBill(CommonResultSetMapper mapper);
	public String getSalesOrderHeaderForBill(CommonResultSetMapper mapper);
	public String createOrUpdateSaleTourPlan(SaleTourPlan saleTourPlan);
	public String getAllSaleTourPlanDetails(CommonResultSetMapper mapper);
	public String getSaleTourPlanHeaderById(CommonResultSetMapper mapper);
	public String getSaleTourPlanDetailsById(CommonResultSetMapper mapper);
	public String cancelSaleTourPlan(CommonResultSetMapper mapper);
	public String deleteSaleTourPlan(CommonResultSetMapper mapper);
	public String postSaleTourPlan(CommonResultSetMapper mapper);
	public String createSaleManTourDetail(SaleManTourDetails salesmanTour);
	public String getSaleManTourDetails(CommonResultSetMapper mapper);
	public String getSaleManCheckinStatus(CommonResultSetMapper mapper);
	public String getSaleManCheckoutStatus(CommonResultSetMapper mapper);
	public String createSaleManTourDetailOffline(SaleManTour salesmanTourList);
}
