package com.sharobi.pharmacy.store.service;

import java.util.List;

import com.sharobi.pharmacy.common.CommonResultSetMapper;
import com.sharobi.pharmacy.common.EmailBean;
import com.sharobi.pharmacy.common.model.ResponseObj;
import com.sharobi.pharmacy.exceptions.DAOException;
import com.sharobi.pharmacy.exceptions.ServiceException;
import com.sharobi.pharmacy.store.dao.StoreDAO;
import com.sharobi.pharmacy.store.dao.impl.StoreDAOImpl;
import com.sharobi.pharmacy.store.model.FinYrMaster;
import com.sharobi.pharmacy.store.model.PrintBill;
import com.sharobi.pharmacy.store.model.PrintBillDetails;
import com.sharobi.pharmacy.store.model.StoreMaster;

public class StoreService {

	private StoreDAO storeDAO = new StoreDAOImpl();

	public StoreService() {

	}

	public StoreMaster getStoreDetails(String storeId) throws ServiceException {

		StoreMaster store = null;
		try {

			store = storeDAO.getStoreDetails(storeId);

		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException(
					"problem occured while trying to get store", e);

		}
		return store;
	}
	
	public ResponseObj sendEmail(EmailBean emailBean)
			throws ServiceException {
		ResponseObj status=null;
		try {
			status = storeDAO.sendEmail(emailBean);

		} catch (DAOException e) {
			throw new ServiceException("error email", e);

		}
		return status;
	}

	public ResponseObj sendHtmlEmail(EmailBean emailBean)
			throws ServiceException {
		ResponseObj status=null;
		try {
			status = storeDAO.sendHtmlEmail(emailBean);

		} catch (DAOException e) {
			throw new ServiceException("error email", e);

		}
		return status;
	}
	
	public List<CommonResultSetMapper> getInvoicePrefixbyQS(
			CommonResultSetMapper mapper) throws ServiceException{
		List<CommonResultSetMapper> status=null;
		try {
			status = storeDAO.getInvoicePrefixbyQS(mapper);

		} catch (DAOException e) {
			throw new ServiceException("error getInvoicePrefixbyQS=", e);

		}
		return status;
	}

	public String updateInvoicePrefixbyQS(CommonResultSetMapper mapper) throws ServiceException{
		String invprefix = "";
		try {
			
			invprefix = storeDAO.updateInvoicePrefixbyQS(mapper);

		} catch (DAOException e) {
			throw new ServiceException("error creating Purchase stock in", e);

		}
		return invprefix;
	}
	
	public PrintBill getPrintBillSetup(
			CommonResultSetMapper mapper) throws ServiceException{
		PrintBill pb=null;
		try {
			pb = storeDAO.getPrintBillSetup(mapper);
		} catch (DAOException e) {
			throw new ServiceException("error getPrintBillSetup=", e);

		}
		return pb;
	}
	
	public List<PrintBillDetails> getPrintBillSetupDetails(
			CommonResultSetMapper mapper) throws ServiceException{
		List<PrintBillDetails> pbs=null;
		try {
			pbs = storeDAO.getPrintBillSetupDetails(mapper);
		} catch (DAOException e) {
			throw new ServiceException("error getPrintBillSetupDetails=", e);

		}
		return pbs;
	}
	
	public List<FinYrMaster> getFinYrList(CommonResultSetMapper mapper) throws ServiceException {
		List<FinYrMaster> finYrMasters = null;
		try {
			finYrMasters = storeDAO.getFinYrList(mapper);
		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceException(
					"problem occured while trying to get finyr list", e);
		}
		return finYrMasters;
	}

}
