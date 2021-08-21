package com.sharobi.pharmacy.store.dao;

import java.util.List;

import com.sharobi.pharmacy.common.CommonResultSetMapper;
import com.sharobi.pharmacy.common.EmailBean;
import com.sharobi.pharmacy.common.model.ResponseObj;
import com.sharobi.pharmacy.exceptions.DAOException;
import com.sharobi.pharmacy.store.model.FinYrMaster;
import com.sharobi.pharmacy.store.model.PrintBill;
import com.sharobi.pharmacy.store.model.PrintBillDetails;
import com.sharobi.pharmacy.store.model.StoreMaster;


/**
rajarshi
*/
public interface StoreDAO {

	public StoreMaster getStoreDetails(String storeId) throws DAOException;
	
	public ResponseObj sendEmail(EmailBean emailBean) throws DAOException;
	
	public ResponseObj sendHtmlEmail(EmailBean emailBean) throws DAOException;

	public List<CommonResultSetMapper> getInvoicePrefixbyQS(CommonResultSetMapper mapper)throws DAOException;

	public String updateInvoicePrefixbyQS(CommonResultSetMapper mapper)throws DAOException;
	public PrintBill getPrintBillSetup(CommonResultSetMapper mapper)throws DAOException;
	public List<PrintBillDetails> getPrintBillSetupDetails(CommonResultSetMapper mapper)throws DAOException;
	public List<FinYrMaster> getFinYrList(CommonResultSetMapper comm) throws DAOException;
	

}

