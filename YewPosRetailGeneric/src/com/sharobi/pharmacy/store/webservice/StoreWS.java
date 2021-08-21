package com.sharobi.pharmacy.store.webservice;

import javax.ws.rs.QueryParam;

import com.sharobi.pharmacy.common.CommonResultSetMapper;

/**
rajarshi
*/

public interface StoreWS {
		
		public String getStoreDetails(@QueryParam(value = "storeId") String storeId);
		public String getInvoicePrefixbyQS(CommonResultSetMapper mapper);
		public String updateInvoicePrefixbyQS(CommonResultSetMapper mapper);
		public String getPrintBillSetup(CommonResultSetMapper mapper);
		public String getPrintBillSetupDetails(CommonResultSetMapper mapper);
		public String getFinYrList(CommonResultSetMapper mapper);		
}


