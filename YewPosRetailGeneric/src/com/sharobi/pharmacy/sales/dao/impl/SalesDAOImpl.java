package com.sharobi.pharmacy.sales.dao.impl;

import java.io.StringWriter;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.internal.SessionFactoryImpl;

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
import com.sharobi.pharmacy.commonutil.StoredProcedures;
import com.sharobi.pharmacy.exceptions.DAOException;
import com.sharobi.pharmacy.inventory.dao.impl.InventoryDAOImpl;
import com.sharobi.pharmacy.inventory.model.AccountDTO;
import com.sharobi.pharmacy.inventory.model.CustomerMaster;
import com.sharobi.pharmacy.inventory.model.CustomerType;
import com.sharobi.pharmacy.sales.dao.SalesDAO;
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
import com.sharobi.pharmacy.sales.model.SaleReturnLedger;
import com.sharobi.pharmacy.sales.model.SaleTourPlan;
import com.sharobi.pharmacy.sales.model.SaleTourPlanDTO;
import com.sharobi.pharmacy.sales.model.SaleTourPlanDetailsDTO;
import com.sharobi.pharmacy.sales.model.Sales;
import com.sharobi.pharmacy.sales.model.SalesDetailsSerialMapper;
import com.sharobi.pharmacy.sales.model.TaxDetailsSaleBillDTO;

import net.sf.resultsetmapper.ReflectionResultSetMapper;

/**
 * rajarshi
 */
public class SalesDAOImpl implements SalesDAO {

	private final static Logger logger = LogManager
			.getLogger(SalesDAOImpl.class);

	private EntityManagerFactory entityManagerFactory;

	public SalesDAOImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public SaleHeaderDTO getSalesHeader(CommonResultSetMapper mapper) throws DAOException {

		SaleHeaderDTO sales = new SaleHeaderDTO();
		EntityManager em = null;
		Connection connection = null;
		CallableStatement callableStatement = null;
		ResultSet rs = null;

		try {
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();

			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();
			connection = sessionFactory.getConnectionProvider().getConnection();
			
			callableStatement = connection
					.prepareCall(StoredProcedures.PROC_GET_SALE_HEADER);
			callableStatement.setInt(1, mapper.getSaleId());			
			callableStatement.execute();
			
			rs = callableStatement.getResultSet();
			ReflectionResultSetMapper<SaleHeaderDTO> resultSetMapper = new ReflectionResultSetMapper<SaleHeaderDTO>(
					SaleHeaderDTO.class);
			while(rs.next()){
				sales = resultSetMapper.mapRow(rs);
			}
			//logger.info("sale header fetched");

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("In DAOException", e);

		} finally {
			try {
				if(rs != null) rs.close();
				if(callableStatement != null) callableStatement.close();
				if(connection != null) connection.close(); 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(em != null) em.close();
		}
		//System.out.println("Sales header : "+sales);
		return sales;
	}
	
	@Override
	public CustPaymentDetailsAllDTO getCustPaymentHeaderById(CommonResultSetMapper mapper) throws DAOException {

		CustPaymentDetailsAllDTO custPay = new CustPaymentDetailsAllDTO();
		EntityManager em = null;
		Connection connection = null;
		CallableStatement callableStatement = null;
		ResultSet rs = null;

		try {
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();

			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();
			connection = sessionFactory.getConnectionProvider().getConnection();
			
			callableStatement = connection
					.prepareCall(StoredProcedures.PROC_GET_CUST_PAYMENT_HEADER);
			callableStatement.setInt(1, mapper.getPaymentId());			
			callableStatement.execute();
			
			rs = callableStatement.getResultSet();
			ReflectionResultSetMapper<CustPaymentDetailsAllDTO> resultSetMapper = new ReflectionResultSetMapper<CustPaymentDetailsAllDTO>(
					CustPaymentDetailsAllDTO.class);
			while(rs.next()){
				custPay = resultSetMapper.mapRow(rs);
			}
			//logger.info("cust payment header fetched");

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("In DAOException", e);

		} finally {
			try {
				if(rs != null) rs.close();
				if(callableStatement != null) callableStatement.close();
				if(connection != null) connection.close(); 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(em != null) em.close();
		}

		return custPay;
	}
	
	@Override
	public List<CustomerInfoDTO> getCustWithCreditLimitByName(CommonResultSetMapper mapper) throws DAOException {

		List<CustomerInfoDTO> custInfoList = new ArrayList<CustomerInfoDTO>();
		EntityManager em = null;
		Connection connection = null;
		CallableStatement callableStatement = null;
		ResultSet rs = null;

		try {
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();

			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();
			connection = sessionFactory.getConnectionProvider().getConnection();
			
			callableStatement = connection
					.prepareCall(StoredProcedures.PROC_GET_CUST_CREDIT_LIMIT_BY_NAME);
			callableStatement.setInt(1, mapper.getCompanyId());	
			callableStatement.setInt(2, mapper.getStoreId());	
			callableStatement.setInt(3, mapper.getFinYrId());	
			callableStatement.setString(4, mapper.getCustName());	
			callableStatement.setString(5, mapper.getCustPh());	
			if (mapper.getAsOnDate()!=null) {
				java.sql.Date asonDate = DateUtil.convertStringDateToSqlDate(
				mapper.getAsOnDate(), "yyyy-MM-dd");
				callableStatement.setDate(6, asonDate);
			}
			else {
				callableStatement.setDate(6, null);
			}
			callableStatement.setInt(7, mapper.getSaleId());	
			callableStatement.execute();
			
			rs = callableStatement.getResultSet();
			ReflectionResultSetMapper<CustomerInfoDTO> resultSetMapper = new ReflectionResultSetMapper<CustomerInfoDTO>(
					CustomerInfoDTO.class);
			while(rs.next()){
				CustomerInfoDTO customerInfoDTO=new CustomerInfoDTO();
				customerInfoDTO = resultSetMapper.mapRow(rs);
				custInfoList.add(customerInfoDTO);
				
			}
			//logger.info("cust credit limit by name fetched");

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("In DAOException", e);

		} finally {
			try {
				if(rs != null) rs.close();
				if(callableStatement != null) callableStatement.close();
				if(connection != null) connection.close(); 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(em != null) em.close();
		}

		return custInfoList;
	}
	
	@Override
	public SaleHeaderDTO getSalesHeaderByInvNo(CommonResultSetMapper mapper) throws DAOException {

		SaleHeaderDTO sales = new SaleHeaderDTO();
		EntityManager em = null;
		Connection connection = null;
		CallableStatement callableStatement = null;
		ResultSet rs = null;

		try {
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();

			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();
			connection = sessionFactory.getConnectionProvider().getConnection();
			
			callableStatement = connection
					.prepareCall(StoredProcedures.PROC_GET_SALE_HEADER_BY_INV_NO);
			callableStatement.setInt(1, mapper.getCompanyId());			
			callableStatement.setInt(2, mapper.getStoreId());
			callableStatement.setString(3, mapper.getInvoiceNo());
			callableStatement.execute();
			
			rs = callableStatement.getResultSet();
			ReflectionResultSetMapper<SaleHeaderDTO> resultSetMapper = new ReflectionResultSetMapper<SaleHeaderDTO>(
					SaleHeaderDTO.class);
			while(rs.next()){
				sales = resultSetMapper.mapRow(rs);
			}
			//logger.info("sale header by inv no. fetched");

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("In DAOException", e);

		} finally {
			try {
				if(rs != null) rs.close();
				if(callableStatement != null) callableStatement.close();
				if(connection != null) connection.close(); 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(em != null) em.close();
		}

		return sales;
	}
	
	@Override
	public List<SaleDetailsDTO> getSalesDetailsById(CommonResultSetMapper mapper) throws DAOException {

		
		List<SaleDetailsDTO> list=new ArrayList<SaleDetailsDTO>();
		EntityManager em = null;
		Connection connection = null;
		CallableStatement callableStatement = null;
		ResultSet rs = null;
		ResultSet rs1 = null;
		List<SalesDetailsSerialMapper> detailsMapper=null;
		
		try {
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();

			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();
			connection = sessionFactory.getConnectionProvider().getConnection();
			
			callableStatement = connection
					.prepareCall(StoredProcedures.PROC_GET_SALE_DETAILS);
			callableStatement.setInt(1, mapper.getSaleId());			
			callableStatement.execute();
			
			rs = callableStatement.getResultSet();
			ReflectionResultSetMapper<SaleDetailsDTO> resultSetMapper = new ReflectionResultSetMapper<SaleDetailsDTO>(
					SaleDetailsDTO.class);
			while(rs.next()){
				SaleDetailsDTO sales = new SaleDetailsDTO();
				sales = resultSetMapper.mapRow(rs);
				
				//get purchase details serial mapper
				detailsMapper = new ArrayList<SalesDetailsSerialMapper>();
				callableStatement = connection
						.prepareCall(StoredProcedures.PROC_SALES_SERIAL_DETAILS_BY_ID);
				
				callableStatement.setInt(1, mapper.getCompanyId());
				callableStatement.setInt(2, mapper.getStoreId());
				callableStatement.setInt(3, mapper.getFinYrId());
				callableStatement.setInt(4, mapper.getSaleId());
				callableStatement.setInt(5, sales.getItemId());
				callableStatement.execute();
				rs1 = callableStatement.getResultSet();
				
				while (rs1.next()) {
					SalesDetailsSerialMapper salesDetailsSerialMapper = new SalesDetailsSerialMapper();
					salesDetailsSerialMapper.setUniqueIdentifierNo(rs1.getString(1));
					
					//logger.info("sales details serial mapper by id fetched");
					
					// add to list
					detailsMapper.add(salesDetailsSerialMapper);
				}
				
				sales.setSalesDetailsSerialMapper(detailsMapper);
				
				list.add(sales);
			}
			//logger.info("sale details fetched");

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("In DAOException", e);

		} finally {
			try {
				if(rs != null) rs.close();
				if(callableStatement != null) callableStatement.close();
				if(connection != null) connection.close(); 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(em != null) em.close();
		}

		return list;
	}
	
	@Override
	public List<SaleItemDetailsDTO> getSaleItemDetailsByItemId(CommonResultSetMapper mapper) throws DAOException {

		
		List<SaleItemDetailsDTO> list=new ArrayList<SaleItemDetailsDTO>();
		EntityManager em = null;
		Connection connection = null;
		CallableStatement callableStatement = null;
		ResultSet rs = null;

		try {
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();

			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();
			connection = sessionFactory.getConnectionProvider().getConnection();
			
			callableStatement = connection
					.prepareCall(StoredProcedures.PROC_GET_SALE_ITEM_DETAILS_BY_ITEM_ID);
			callableStatement.setInt(1, mapper.getCompanyId());
			callableStatement.setInt(2, mapper.getStoreId());
			callableStatement.setInt(3, mapper.getItemId());
			callableStatement.setInt(4, mapper.getNoOfDays());
			callableStatement.execute();
			
			rs = callableStatement.getResultSet();
			ReflectionResultSetMapper<SaleItemDetailsDTO> resultSetMapper = new ReflectionResultSetMapper<SaleItemDetailsDTO>(
					SaleItemDetailsDTO.class);
			while(rs.next()){
				SaleItemDetailsDTO sales = new SaleItemDetailsDTO();
				sales = resultSetMapper.mapRow(rs);
				list.add(sales);
			}
			//logger.info("sale item details fetched");

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("In DAOException", e);

		} finally {
			try {
				if(rs != null) rs.close();
				if(callableStatement != null) callableStatement.close();
				if(connection != null) connection.close(); 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(em != null) em.close();
		}

		return list;
	}
	
	@Override
	public List<CommonResultSetMapper> getAutoRemarks(CommonResultSetMapper mapper) throws DAOException {

		
		List<CommonResultSetMapper> list=new ArrayList<CommonResultSetMapper>();
		EntityManager em = null;
		Connection connection = null;
		CallableStatement callableStatement = null;
		ResultSet rs = null;
		

		try {
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();

			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();
			connection = sessionFactory.getConnectionProvider().getConnection();
			
			callableStatement = connection
					.prepareCall(StoredProcedures.PROC_GET_AUTO_REMARKS);
			callableStatement.setInt(1, mapper.getCompanyId());			
			callableStatement.setInt(2, mapper.getStoreId());
			callableStatement.setString(3, mapper.getRemarks());
			callableStatement.execute();
			
			rs = callableStatement.getResultSet();
			while(rs.next()){
				CommonResultSetMapper mapper2=new CommonResultSetMapper();
				mapper2.setRemarks(rs.getString("remarks"));
				list.add(mapper2);
			}
			//logger.info("all remarks fetched");

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("In DAOException", e);

		} finally {
			try {
				if(rs != null) rs.close();
				if(callableStatement != null) callableStatement.close();
				if(connection != null) connection.close(); 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(em != null) em.close();
		}

		return list;
	}
	
	@Override
	public List<TaxDetailsSaleBillDTO> getTaxDetailsForSaleBill(CommonResultSetMapper mapper) throws DAOException {

		
		List<TaxDetailsSaleBillDTO> list=new ArrayList<TaxDetailsSaleBillDTO>();
		EntityManager em = null;
		Connection connection = null;
		CallableStatement callableStatement = null;
		ResultSet rs = null;

		try {
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();

			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();
			connection = sessionFactory.getConnectionProvider().getConnection();
			
			callableStatement = connection
					.prepareCall(StoredProcedures.PROC_GET_TAX_DETAILS_SALE_BILL);
			callableStatement.setInt(1, mapper.getCompanyId());			
			callableStatement.setInt(2, mapper.getStoreId());
			callableStatement.setInt(3, mapper.getSaleId());
			callableStatement.execute();
			
			rs = callableStatement.getResultSet();
			ReflectionResultSetMapper<TaxDetailsSaleBillDTO> resultSetMapper = new ReflectionResultSetMapper<TaxDetailsSaleBillDTO>(
					TaxDetailsSaleBillDTO.class);
			while(rs.next()){
				TaxDetailsSaleBillDTO tax = new TaxDetailsSaleBillDTO();
				tax = resultSetMapper.mapRow(rs);
				list.add(tax);
			}
			//logger.info("tax details fetched");

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("In DAOException", e);

		} finally {
			try {
				if(rs != null) rs.close();
				if(callableStatement != null) callableStatement.close();
				if(connection != null) connection.close(); 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(em != null) em.close();
		}

		return list;
	}
	
	@Override
	public List<SaleDetailsDTO> getSalesDetailsByIdForBill(CommonResultSetMapper mapper) throws DAOException {

		
		List<SaleDetailsDTO> list=new ArrayList<SaleDetailsDTO>();
		EntityManager em = null;
		Connection connection = null;
		CallableStatement callableStatement = null;
		ResultSet rs = null;

		try {
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();

			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();
			connection = sessionFactory.getConnectionProvider().getConnection();
			
			callableStatement = connection
					.prepareCall(StoredProcedures.PROC_GET_SALE_DETAILS_FOR_BILL);
			callableStatement.setInt(1, mapper.getCompanyId());
			callableStatement.setInt(2, mapper.getStoreId());
			callableStatement.setInt(3, mapper.getSaleId());
			callableStatement.execute();
			
			rs = callableStatement.getResultSet();
			ReflectionResultSetMapper<SaleDetailsDTO> resultSetMapper = new ReflectionResultSetMapper<SaleDetailsDTO>(
					SaleDetailsDTO.class);
			while(rs.next()){
				SaleDetailsDTO sales = new SaleDetailsDTO();
				sales = resultSetMapper.mapRow(rs);
				list.add(sales);
			}
			//logger.info("sale details for bill fetched");

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("In DAOException", e);

		} finally {
			try {
				if(rs != null) rs.close();
				if(callableStatement != null) callableStatement.close();
				if(connection != null) connection.close(); 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(em != null) em.close();
		}

		return list;
	}
	
	@Override
	public List<PaymentMode> getPaymentModes(CommonResultSetMapper mapper) throws DAOException {

		List<PaymentMode> paymentTypeLst = new ArrayList<PaymentMode>();
		EntityManager em = null;
		try {
			int comnyId=mapper.getCompanyId();
			int storeId=mapper.getStoreId();
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			
			em.getTransaction().begin();
			
			//Query qry = em.createQuery("SELECT p FROM PaymentMode p where p.companyId=:companyId and p.storeId=:storeId");
			Query qry = em.createQuery("SELECT p FROM PaymentMode p");
			//qry.setParameter("companyId", comnyId);
			//qry.setParameter("storeId", storeId);
			paymentTypeLst = (List<PaymentMode>) qry.getResultList();
			

			/*Gson gson = new GsonBuilder()
					.excludeFieldsWithoutExposeAnnotation().create();
			java.lang.reflect.Type type = new TypeToken<List<PaymentMode>>() {
			}.getType();
			String json = gson.toJson(paymentTypeLst, type);*/
			
			em.getTransaction().commit();
			
		}

		catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("In DAOException of getPaymentModes", e);

		} finally {
			if(em != null) em.close();
		}
		return paymentTypeLst;
	}
	
	@Override
	public List<TypeMaster> getTypes(CommonResultSetMapper mapper) throws DAOException {

		List<TypeMaster> types = new ArrayList<TypeMaster>();
		EntityManager em = null;
		try {
			
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			
			em.getTransaction().begin();
			
			Query qry = em
					.createQuery("SELECT t FROM TypeMaster t");
			
			types = (List<TypeMaster>) qry.getResultList();
			

			Gson gson = new GsonBuilder()
					.excludeFieldsWithoutExposeAnnotation().create();
			java.lang.reflect.Type type = new TypeToken<List<TypeMaster>>() {
			}.getType();
			String json = gson.toJson(types, type);
			
			em.getTransaction().commit();
			
		}

		catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("In DAOException of types", e);

		} finally {
			if(em != null) em.close();
		}
		return types;
	}
	
	@Override
	public List<EsiCodeMaster> getEsiCodes(CommonResultSetMapper mapper) throws DAOException {

		List<EsiCodeMaster> codes = new ArrayList<EsiCodeMaster>();
		EntityManager em = null;
		try {
			
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			
			em.getTransaction().begin();
			
			TypedQuery<EsiCodeMaster> qry = em
					.createQuery("SELECT e FROM EsiCodeMaster e", EsiCodeMaster.class);
			
			codes = qry.getResultList();

			Gson gson = new GsonBuilder()
					.excludeFieldsWithoutExposeAnnotation().create();
			java.lang.reflect.Type type = new TypeToken<List<EsiCodeMaster>>() {
			}.getType();
			String json = gson.toJson(codes, type);
			
			em.getTransaction().commit();
			
		}

		catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("In DAOException of types", e);

		} finally {
			if(em != null) em.close();
		}
		return codes;
	}
	
	@Override
	public String postALLSalesInvoice(Sales sales) throws DAOException {
		EntityManager em = null;
		int status = 0;
		Connection connection = null;
		CallableStatement callableStatement = null;

		try {
			
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();
			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();
			connection = sessionFactory.getConnectionProvider().getConnection();

			try {
				StringWriter sw = new StringWriter();
				//File file = new	 File("D:\\2017-08-24\\file_sales_invoice_creation.xml");
				JAXBContext jaxbContext = JAXBContext
						.newInstance(Sales.class);
				Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

				jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,
						true);
				//jaxbMarshaller.marshal(sales, file);
				//jaxbMarshaller.marshal(sales, System.out);
				jaxbMarshaller.marshal(sales, sw);
				String result = sw.toString();
				 //System.out.println("output string:: "+result);
				callableStatement = connection
						.prepareCall(StoredProcedures.PROC_POST_ALL_SALES_INVOICE);
				callableStatement.setString(1, result);
				callableStatement.setString(2, "sales");
				callableStatement.setString(3, "salesDetails");
				
				callableStatement.registerOutParameter(4,
						java.sql.Types.INTEGER);

				callableStatement.execute();
				//invNo = callableStatement.getString(4);
				status = callableStatement.getInt(4);
				/*if (status == 0) {
					result1 = "" + status;
				} else if (status == 1) {
					result1 = invNo;
				}*/
				// result=result.replaceAll("\\<\\?xml(.+?)\\?\\>", "").trim();
				// System.out.println("formatted output::: "+result);

			} 
			
			catch (SQLException e) {
				e.printStackTrace();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			em.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("Check data to be inserted", e);
		} finally {
			try {
				
				if(callableStatement != null) callableStatement.close();
				if(connection != null) connection.close(); 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(em != null) em.close();
		}
		return ""+status;
	}
	
	@Override
	public String postALLReturnSalesInvoice(SaleReturn salereturn) throws DAOException {
		EntityManager em = null;
		int status = 0;
		Connection connection = null;
		CallableStatement callableStatement = null;

		try {
			
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();
			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();
			connection = sessionFactory.getConnectionProvider().getConnection();

			try {
				StringWriter sw = new StringWriter();
				//File file = new	 File("D:\\2017-08-24\\file_sales_invoice_creation.xml");
				JAXBContext jaxbContext = JAXBContext
						.newInstance(Sales.class);
				Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

				jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,
						true);
				//jaxbMarshaller.marshal(sales, file);
				//jaxbMarshaller.marshal(sales, System.out);
				jaxbMarshaller.marshal(salereturn, sw);
				String result = sw.toString();
				// System.out.println("output string:: "+result);
				callableStatement = connection
						.prepareCall(StoredProcedures.PROC_POST_ALL_SALES_RETURN);
				callableStatement.setString(1, result);
				callableStatement.setString(2, "saleReturn");
				callableStatement.setString(3, "saleReturnDetails");
				
				callableStatement.registerOutParameter(4,
						java.sql.Types.INTEGER);

				callableStatement.execute();
				//invNo = callableStatement.getString(4);
				status = callableStatement.getInt(4);
				/*if (status == 0) {
					result1 = "" + status;
				} else if (status == 1) {
					result1 = invNo;
				}*/
				// result=result.replaceAll("\\<\\?xml(.+?)\\?\\>", "").trim();
				// System.out.println("formatted output::: "+result);

			} 
			
			catch (SQLException e) {
				e.printStackTrace();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			em.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("Check data to be inserted", e);
		} finally {
			try {
				
				if(callableStatement != null) callableStatement.close();
				if(connection != null) connection.close(); 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(em != null) em.close();
		}
		return ""+status;
	}
	
	@Override
	public List<SaleDetailsDTO> getSalesDetailsByInvNo(CommonResultSetMapper mapper) throws DAOException {

		
		List<SaleDetailsDTO> list=new ArrayList<SaleDetailsDTO>();
		EntityManager em = null;
		Connection connection = null;
		CallableStatement callableStatement = null;
		ResultSet rs = null;

		try {
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();

			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();
			connection = sessionFactory.getConnectionProvider().getConnection();
			
			callableStatement = connection
					.prepareCall(StoredProcedures.PROC_GET_SALE_DETAILS_BY_INV_NO);
			callableStatement.setInt(1, mapper.getCompanyId());			
			callableStatement.setInt(2, mapper.getStoreId());
			callableStatement.setString(3, mapper.getInvoiceNo());
			callableStatement.execute();
			
			rs = callableStatement.getResultSet();
			ReflectionResultSetMapper<SaleDetailsDTO> resultSetMapper = new ReflectionResultSetMapper<SaleDetailsDTO>(
					SaleDetailsDTO.class);
			while(rs.next()){
				SaleDetailsDTO sales = new SaleDetailsDTO();
				sales = resultSetMapper.mapRow(rs);
				list.add(sales);
			}
			//logger.info("sale details by inv no. fetched");

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("In DAOException", e);

		} finally {
			try {
				if(rs != null) rs.close();
				if(callableStatement != null) callableStatement.close();
				if(connection != null) connection.close(); 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(em != null) em.close();
		}

		return list;
	}
	
	@Override
	public List<SaleReturnDTO> getAllSalesReturnDetails(CommonResultSetMapper mapper) throws DAOException {

		
		List<SaleReturnDTO> list=new ArrayList<SaleReturnDTO>();
		EntityManager em = null;
		Connection connection = null;
		CallableStatement callableStatement = null;
		ResultSet rs = null;

		try {
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();

			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();
			connection = sessionFactory.getConnectionProvider().getConnection();
			
			java.sql.Date startDt = DateUtil.convertStringDateToSqlDate(
					mapper.getStartDate(), "yyyy-MM-dd");

			java.sql.Date endDt1 = DateUtil.convertStringDateToSqlDate(mapper.getEndDate(),
					"yyyy-MM-dd");
			
			callableStatement = connection
					.prepareCall(StoredProcedures.PROC_GET_SALE_RETURN_DETAILS);
			callableStatement.setInt(1, mapper.getCompanyId());
			callableStatement.setInt(2, mapper.getStoreId());
			callableStatement.setInt(3, mapper.getFinYrId());
			callableStatement.setDate(4, startDt);
			callableStatement.setDate(5, endDt1);
			callableStatement.setString(6, mapper.getInvoiceNo());
			callableStatement.setInt(7, mapper.getCustId());
			callableStatement.setString(8, mapper.getCustName());
			callableStatement.execute();
			
			rs = callableStatement.getResultSet();
			ReflectionResultSetMapper<SaleReturnDTO> resultSetMapper = new ReflectionResultSetMapper<SaleReturnDTO>(
					SaleReturnDTO.class);
			while(rs.next()){
				SaleReturnDTO sales = new SaleReturnDTO();
				sales = resultSetMapper.mapRow(rs);
				list.add(sales);
			}
			//logger.info("sale return details fetched");

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("In DAOException", e);

		} finally {
			try {
				if(rs != null) rs.close();
				if(callableStatement != null) callableStatement.close();
				if(connection != null) connection.close(); 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(em != null) em.close();
		}

		return list;
	}
	
	@Override
	public SaleReturnDTO getSaleReturnHeader(CommonResultSetMapper mapper) throws DAOException {

	
		SaleReturnDTO sales = new SaleReturnDTO();
		EntityManager em = null;
		Connection connection = null;
		CallableStatement callableStatement = null;
		ResultSet rs = null;

		try {
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();

			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();
			connection = sessionFactory.getConnectionProvider().getConnection();
			
			callableStatement = connection
					.prepareCall(StoredProcedures.PROC_GET_SALE_RETURN_HEADER);
			callableStatement.setInt(1, mapper.getSaleReturnId());
			callableStatement.execute();
			
			rs = callableStatement.getResultSet();
			ReflectionResultSetMapper<SaleReturnDTO> resultSetMapper = new ReflectionResultSetMapper<SaleReturnDTO>(
					SaleReturnDTO.class);
			while(rs.next()){
				
				sales = resultSetMapper.mapRow(rs);
				
			}
			//logger.info("sale return header fetched");

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("In DAOException", e);

		} finally {
			try {
				if(rs != null) rs.close();
				if(callableStatement != null) callableStatement.close();
				if(connection != null) connection.close(); 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(em != null) em.close();
		}

		return sales;
	}
	
	@Override
	public List<SaleReturnDetailsDTO> getSaleReturnDetails(CommonResultSetMapper mapper) throws DAOException {

		
		List<SaleReturnDetailsDTO> list=new ArrayList<SaleReturnDetailsDTO>();
		EntityManager em = null;
		Connection connection = null;
		CallableStatement callableStatement = null;
		ResultSet rs = null;
		ResultSet rs1 = null;
		List<SaleReturnDetailsSerialMapper> detailsMapper=null;

		try {
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();

			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();
			connection = sessionFactory.getConnectionProvider().getConnection();
			
			callableStatement = connection
					.prepareCall(StoredProcedures.PROC_GET_SALE_RETURN_DETAILS_BY_ID);
			callableStatement.setInt(1, mapper.getSaleReturnId());
			callableStatement.execute();
			
			rs = callableStatement.getResultSet();
			ReflectionResultSetMapper<SaleReturnDetailsDTO> resultSetMapper = new ReflectionResultSetMapper<SaleReturnDetailsDTO>(
					SaleReturnDetailsDTO.class);
			while(rs.next()){
				SaleReturnDetailsDTO sales = new SaleReturnDetailsDTO();
				sales = resultSetMapper.mapRow(rs);
				
				////////////////////////////////////////////
				//get sale return details serial mapper
				detailsMapper = new ArrayList<SaleReturnDetailsSerialMapper>();
				callableStatement = connection
						.prepareCall(StoredProcedures.PROC_GET_SERIAL_SALE_RETURN_STATUS);
				callableStatement.setInt(1, mapper.getCompanyId());
				callableStatement.setInt(2,  mapper.getStoreId());
				callableStatement.setInt(3, mapper.getFinYrId());
				callableStatement.setInt(4, sales.getItemId());
				callableStatement.setInt(5, sales.getSaleReturnDetailsId());
				callableStatement.setInt(6, 0);
				if (mapper.getAsOnDate()!=null) {
					java.sql.Date asonDate = DateUtil.convertStringDateToSqlDate(
					mapper.getAsOnDate(), "yyyy-MM-dd");
					callableStatement.setDate(7, asonDate);
					System.out.println("sasonDate="+asonDate);
				}
				else {
					callableStatement.setDate(7, null);
				}
				System.out.println("mapper.getStoreId()="+mapper.getStoreId());
				System.out.println("mapper.getFinYrId()="+mapper.getFinYrId());
				System.out.println("mapper.getItemId()="+mapper.getItemId());
				System.out.println("sales.getSaleReturnDetailsId()="+sales.getSaleReturnDetailsId());
				
				callableStatement.execute();
				rs1 = callableStatement.getResultSet();
				
				while (rs1.next()) {
					SaleReturnDetailsSerialMapper saleReturnDetailsSerialMapper = new SaleReturnDetailsSerialMapper();
					saleReturnDetailsSerialMapper.setIsChecked(rs1.getInt(1));
					saleReturnDetailsSerialMapper.setItemId(rs1.getInt(2));
					saleReturnDetailsSerialMapper.setUniqueIdentifierNo(rs1.getString(3));
					saleReturnDetailsSerialMapper.setCheckStatus(rs1.getString(4));
					saleReturnDetailsSerialMapper.setMrp(rs1.getDouble(5));
					saleReturnDetailsSerialMapper.setPurchaseRate(rs1.getDouble(6));
					saleReturnDetailsSerialMapper.setSaleRate(rs1.getDouble(7));
					// add to list
					detailsMapper.add(saleReturnDetailsSerialMapper);
				}
				
				sales.setSaleReturnDetailsSerialMapper(detailsMapper);
				
				
				list.add(sales);
			}
			//logger.info("sale return details by id fetched");

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("In DAOException", e);

		} finally {
			try {
				if(rs != null) rs.close();
				if(callableStatement != null) callableStatement.close();
				if(connection != null) connection.close(); 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(em != null) em.close();
		}

		return list;
	}
	
	@Override
	public List<SaleDetailsForReturnDTO> getSaleDetailsForReturnByItem(CommonResultSetMapper mapper) throws DAOException {

		
		List<SaleDetailsForReturnDTO> list=new ArrayList<SaleDetailsForReturnDTO>();
		EntityManager em = null;
		Connection connection = null;
		CallableStatement callableStatement = null;
		ResultSet rs = null;
		ResultSet rs1 = null;
		List<SaleReturnDetailsSerialMapper> detailsMapper=null;

		try {
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();

			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();
			connection = sessionFactory.getConnectionProvider().getConnection();
			
			callableStatement = connection
					.prepareCall(StoredProcedures.PROC_GET_SALE_DETAILS_FOR_RETURN_BY_ITEM);
			callableStatement.setInt(1, mapper.getCompanyId());
			callableStatement.setInt(2, mapper.getStoreId());
			callableStatement.setInt(3, mapper.getItemId());
			if (mapper.getAsOnDate()!=null) {
				java.sql.Date asonDate = DateUtil.convertStringDateToSqlDate(
				mapper.getAsOnDate(), "yyyy-MM-dd");
				callableStatement.setDate(4, asonDate);
			}
			else {
				callableStatement.setDate(4, null);
			}
			
			callableStatement.setInt(5, mapper.getNoOfMonthBefore());
			callableStatement.execute();
			
			rs = callableStatement.getResultSet();
			ReflectionResultSetMapper<SaleDetailsForReturnDTO> resultSetMapper = new ReflectionResultSetMapper<SaleDetailsForReturnDTO>(
					SaleDetailsForReturnDTO.class);
			while(rs.next()){
				SaleDetailsForReturnDTO sales = new SaleDetailsForReturnDTO();
				sales = resultSetMapper.mapRow(rs);
				
				////////////////////////////////////////////////////////////////////////
				//get sale return details serial mapper
				detailsMapper = new ArrayList<SaleReturnDetailsSerialMapper>();
				callableStatement = connection
						.prepareCall(StoredProcedures.PROC_GET_SERIAL_SALE_RETURN_STATUS);
				callableStatement.setInt(1, mapper.getCompanyId());
				callableStatement.setInt(2,  mapper.getStoreId());
				callableStatement.setInt(3, mapper.getFinYrId());
				callableStatement.setInt(4, mapper.getItemId());
				callableStatement.setInt(5, 0);
				callableStatement.setInt(6, sales.getSaleDetailsId());
				if (mapper.getAsOnDate()!=null) {
					java.sql.Date asonDate = DateUtil.convertStringDateToSqlDate(
					mapper.getAsOnDate(), "yyyy-MM-dd");
					callableStatement.setDate(7, asonDate);
				}
				else {
					callableStatement.setDate(7, null);
				}
				callableStatement.execute();
				rs1 = callableStatement.getResultSet();
				
				while (rs1.next()) {
					SaleReturnDetailsSerialMapper saleReturnDetailsSerialMapper = new SaleReturnDetailsSerialMapper();
					saleReturnDetailsSerialMapper.setIsChecked(rs1.getInt(1));
					saleReturnDetailsSerialMapper.setItemId(rs1.getInt(2));
					saleReturnDetailsSerialMapper.setUniqueIdentifierNo(rs1.getString(3));
					saleReturnDetailsSerialMapper.setCheckStatus(rs1.getString(4));
					saleReturnDetailsSerialMapper.setMrp(rs1.getDouble(5));
					saleReturnDetailsSerialMapper.setPurchaseRate(rs1.getDouble(6));
					saleReturnDetailsSerialMapper.setSaleRate(rs1.getDouble(7));
					
					
					// add to list
					detailsMapper.add(saleReturnDetailsSerialMapper);
				}
				
				sales.setSaleReturnDetailsSerialMapper(detailsMapper);
				
				list.add(sales);
			}
			

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("In DAOException", e);

		} finally {
			try {
				if(rs != null) rs.close();
				if(callableStatement != null) callableStatement.close();
				if(connection != null) connection.close(); 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(em != null) em.close();
		}

		return list;
	}
	
	@Override
	public List<SaleReturnDetailsSerialMapper> getSerialSaleReturnStatus(CommonResultSetMapper mapper) throws DAOException {

		
		
		EntityManager em = null;
		Connection connection = null;
		CallableStatement callableStatement = null;
		ResultSet rs1 = null;
		List<SaleReturnDetailsSerialMapper> detailsMapper= new ArrayList<SaleReturnDetailsSerialMapper>();;

		try {
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();

			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();
			connection = sessionFactory.getConnectionProvider().getConnection();
		
				//get sale return details serial mapper
				
				callableStatement = connection
						.prepareCall(StoredProcedures.PROC_GET_SERIAL_SALE_RETURN_STATUS);
				callableStatement.setInt(1, mapper.getCompanyId());
				callableStatement.setInt(2,  mapper.getStoreId());
				callableStatement.setInt(3, mapper.getFinYrId());
				callableStatement.setInt(4, mapper.getItemId());
				callableStatement.setInt(5, 0);
				callableStatement.setInt(6, mapper.getSaleDetailsId());
				if (mapper.getAsOnDate()!=null) {
					java.sql.Date asonDate = DateUtil.convertStringDateToSqlDate(
					mapper.getAsOnDate(), "yyyy-MM-dd");
					callableStatement.setDate(7, asonDate);
				}
				else {
					callableStatement.setDate(7, null);
				}
				callableStatement.execute();
				rs1 = callableStatement.getResultSet();
				
				while (rs1.next()) {
					SaleReturnDetailsSerialMapper saleReturnDetailsSerialMapper = new SaleReturnDetailsSerialMapper();
					saleReturnDetailsSerialMapper.setIsChecked(rs1.getInt(1));
					saleReturnDetailsSerialMapper.setItemId(rs1.getInt(2));
					saleReturnDetailsSerialMapper.setUniqueIdentifierNo(rs1.getString(3));
					saleReturnDetailsSerialMapper.setCheckStatus(rs1.getString(4));
					saleReturnDetailsSerialMapper.setMrp(rs1.getDouble(5));
					saleReturnDetailsSerialMapper.setPurchaseRate(rs1.getDouble(6));
					saleReturnDetailsSerialMapper.setSaleRate(rs1.getDouble(7));
					
					// add to list
					detailsMapper.add(saleReturnDetailsSerialMapper);
				}
				
			

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("In DAOException", e);

		} finally {
			try {
				rs1.close();
				if(callableStatement != null) callableStatement.close();
				if(connection != null) connection.close(); 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(em != null) em.close();
		}

		return detailsMapper;
	}
	
	@Override
	public List<SaleDetailsForReturnDTO> getSaleDetailsForReturn(CommonResultSetMapper mapper) throws DAOException {

		
		List<SaleDetailsForReturnDTO> list=new ArrayList<SaleDetailsForReturnDTO>();
		EntityManager em = null;
		Connection connection = null;
		CallableStatement callableStatement = null;
		List<SaleReturnDetailsSerialMapper> detailsMapper=null;
		ResultSet rs = null;
		ResultSet rs1 = null;

		try {
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();

			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();
			connection = sessionFactory.getConnectionProvider().getConnection();
			
			callableStatement = connection
					.prepareCall(StoredProcedures.PROC_GET_SALE_DETAILS_FOR_RETURN_INV_NO);
			callableStatement.setInt(1, mapper.getCompanyId());
			callableStatement.setInt(2, mapper.getStoreId());
			callableStatement.setString(3, mapper.getInvoiceNo());
		
			callableStatement.execute();
			
			rs = callableStatement.getResultSet();
			ReflectionResultSetMapper<SaleDetailsForReturnDTO> resultSetMapper = new ReflectionResultSetMapper<SaleDetailsForReturnDTO>(
					SaleDetailsForReturnDTO.class);
			while(rs.next()){
				SaleDetailsForReturnDTO sales = new SaleDetailsForReturnDTO();
				sales = resultSetMapper.mapRow(rs);
				
				//get sale return details serial mapper
				detailsMapper = new ArrayList<SaleReturnDetailsSerialMapper>();
				callableStatement = connection
						.prepareCall(StoredProcedures.PROC_GET_SERIAL_SALE_RETURN_STATUS);
				callableStatement.setInt(1, mapper.getCompanyId());
				callableStatement.setInt(2,  mapper.getStoreId());
				callableStatement.setInt(3, mapper.getFinYrId());
				callableStatement.setInt(4, sales.getItemId());
				callableStatement.setInt(5, 0);
				callableStatement.setInt(6, sales.getSaleDetailsId());
				if (mapper.getAsOnDate()!=null) {
					java.sql.Date asonDate = DateUtil.convertStringDateToSqlDate(
						mapper.getAsOnDate(), "yyyy-MM-dd");
					callableStatement.setDate(7, asonDate);
				}
				else {
					callableStatement.setDate(7, null);
				}
					callableStatement.execute();
					rs1 = callableStatement.getResultSet();

			while (rs1.next()) {
				SaleReturnDetailsSerialMapper saleReturnDetailsSerialMapper = new SaleReturnDetailsSerialMapper();
				saleReturnDetailsSerialMapper.setIsChecked(rs1.getInt(1));
				saleReturnDetailsSerialMapper.setItemId(rs1.getInt(2));
				saleReturnDetailsSerialMapper.setUniqueIdentifierNo(rs1.getString(3));
				saleReturnDetailsSerialMapper.setCheckStatus(rs1.getString(4));
				saleReturnDetailsSerialMapper.setMrp(rs1.getDouble(5));
				saleReturnDetailsSerialMapper.setPurchaseRate(rs1.getDouble(6));
				saleReturnDetailsSerialMapper.setSaleRate(rs1.getDouble(7));
				// add to list
				detailsMapper.add(saleReturnDetailsSerialMapper);
			}

				sales.setSaleReturnDetailsSerialMapper(detailsMapper);
				
				list.add(sales);
			}
		

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("In DAOException", e);

		} finally {
			try {
				if(rs != null) rs.close();
				if(callableStatement != null) callableStatement.close();
				if(connection != null) connection.close(); 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(em != null) em.close();
		}

		return list;
	}
	
	@Override
	public List<SaleReturnDTO> getAdjSaleReturn(CommonResultSetMapper mapper) throws DAOException {

		
		List<SaleReturnDTO> list=new ArrayList<SaleReturnDTO>();
		EntityManager em = null;
		Connection connection = null;
		CallableStatement callableStatement = null;
		ResultSet rs = null;

		try {
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();

			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();
			connection = sessionFactory.getConnectionProvider().getConnection();
			
			callableStatement = connection
					.prepareCall(StoredProcedures.PROC_GET_SALE_RETURN_ADJ_INV_NO);
			callableStatement.setInt(1, mapper.getCompanyId());
			callableStatement.setInt(2, mapper.getStoreId());
			callableStatement.setString(3, mapper.getInvoiceNo());
			callableStatement.setInt(4, mapper.getCustId());
			callableStatement.setString(5, mapper.getCustPh());
		
			callableStatement.execute();
			
			rs = callableStatement.getResultSet();
			ReflectionResultSetMapper<SaleReturnDTO> resultSetMapper = new ReflectionResultSetMapper<SaleReturnDTO>(
					SaleReturnDTO.class);
			while(rs.next()){
				SaleReturnDTO sales = new SaleReturnDTO();
				sales = resultSetMapper.mapRow(rs);
				list.add(sales);
			}
			//logger.info("adjustment sale return by inv no. fetched");

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("In DAOException", e);

		} finally {
			try {
				if(rs != null) rs.close();
				if(callableStatement != null) callableStatement.close();
				if(connection != null) connection.close(); 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(em != null) em.close();
		}

		return list;
	}
	
	@Override
	public List<SaleReturnDTO> getAdjSaleReturnBySaleId(CommonResultSetMapper mapper) throws DAOException {

		
		List<SaleReturnDTO> list=new ArrayList<SaleReturnDTO>();
		EntityManager em = null;
		Connection connection = null;
		CallableStatement callableStatement = null;
		ResultSet rs = null;

		try {
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();

			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();
			connection = sessionFactory.getConnectionProvider().getConnection();
			
			callableStatement = connection
					.prepareCall(StoredProcedures.PROC_GET_SALE_RETURN_ADJ_SALEID);
			callableStatement.setInt(1, mapper.getCompanyId());
			callableStatement.setInt(2, mapper.getStoreId());
			callableStatement.setInt(3, mapper.getSaleId());
		
			callableStatement.execute();
			
			rs = callableStatement.getResultSet();
			ReflectionResultSetMapper<SaleReturnDTO> resultSetMapper = new ReflectionResultSetMapper<SaleReturnDTO>(
					SaleReturnDTO.class);
			while(rs.next()){
				SaleReturnDTO sales = new SaleReturnDTO();
				sales = resultSetMapper.mapRow(rs);
				list.add(sales);
			}
			//logger.info("adjustment sale return by sale id fetched");

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("In DAOException", e);

		} finally {
			try {
				if(rs != null) rs.close();
				if(callableStatement != null) callableStatement.close();
				if(connection != null) connection.close(); 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(em != null) em.close();
		}

		return list;
	}
	
	@Override
	public List<SaleDetailsAllDTO> getAllSaleDetails(CommonResultSetMapper mapper) throws DAOException {

		
		List<SaleDetailsAllDTO> list=new ArrayList<SaleDetailsAllDTO>();
		EntityManager em = null;
		Connection connection = null;
		CallableStatement callableStatement = null;
		ResultSet rs = null;

		try {
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();

			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();
			connection = sessionFactory.getConnectionProvider().getConnection();
			
			callableStatement = connection
					.prepareCall(StoredProcedures.PROC_GET_SALE_DETAILS_ALL);
			int cmpnyId = mapper.getCompanyId();
			int strId = mapper.getStoreId();
			int finId = mapper.getFinYrId();
			String starDate = mapper.getStartDate();
			String endDate = mapper.getEndDate();
			String invNo = mapper.getInvoiceNo();
			int custId  = mapper.getCustId();
			String custName = mapper.getCustName();		
			int rePrint = mapper.getStatus();
			
			java.sql.Date startDt = DateUtil.convertStringDateToSqlDate(
					starDate, "yyyy-MM-dd");

			java.sql.Date endDt1 = DateUtil.convertStringDateToSqlDate(endDate,
					"yyyy-MM-dd");
			callableStatement.setInt(1, cmpnyId);
			callableStatement.setInt(2, strId);
			callableStatement.setInt(3, finId);
			callableStatement.setDate(4, startDt);
			callableStatement.setDate(5, endDt1);
			callableStatement.setString(6, invNo);
			callableStatement.setInt(7, custId);
			callableStatement.setString(8, custName);
			callableStatement.setInt(9, rePrint);
			callableStatement.execute();
			
			rs = callableStatement.getResultSet();
			ReflectionResultSetMapper<SaleDetailsAllDTO> resultSetMapper = new ReflectionResultSetMapper<SaleDetailsAllDTO>(
					SaleDetailsAllDTO.class);
			while(rs.next()){
				SaleDetailsAllDTO sales = new SaleDetailsAllDTO();
				sales = resultSetMapper.mapRow(rs);
				list.add(sales);
			}
			//logger.info("all sale details fetched");

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("In DAOException", e);

		} finally {
			try {
				if(rs != null) rs.close();
				if(callableStatement != null) callableStatement.close();
				if(connection != null) connection.close(); 
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if(em != null) em.close();
		}

		return list;
	}
	
	@Override
	public List<CustPaymentDetailsAllDTO> getAllCustPaymentDetails(CommonResultSetMapper mapper) throws DAOException {

		
		List<CustPaymentDetailsAllDTO> list=new ArrayList<CustPaymentDetailsAllDTO>();
		EntityManager em = null;
		Connection connection = null;
		CallableStatement callableStatement = null;
		ResultSet rs = null;

		try {
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();

			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();
			connection = sessionFactory.getConnectionProvider().getConnection();
			
			callableStatement = connection
					.prepareCall(StoredProcedures.PROC_GET_CUST_PAYMENT_DETAILS_ALL);
			int cmpnyId = mapper.getCompanyId();
			int strId = mapper.getStoreId();
			int finId = mapper.getFinYrId();
			String starDate = mapper.getStartDate();
			String endDate = mapper.getEndDate();
			String invNo = mapper.getInvoiceNo();
			int custId  = mapper.getCustId();
			String custName = mapper.getCustName();		
			java.sql.Date startDt = DateUtil.convertStringDateToSqlDate(
					starDate, "yyyy-MM-dd");

			java.sql.Date endDt1 = DateUtil.convertStringDateToSqlDate(endDate,
					"yyyy-MM-dd");
			callableStatement.setInt(1, cmpnyId);
			callableStatement.setInt(2, strId);
			callableStatement.setInt(3, finId);
			callableStatement.setDate(4, startDt);
			callableStatement.setDate(5, endDt1);
			callableStatement.setString(6, invNo);
			callableStatement.setInt(7, custId);
			callableStatement.setString(8, custName);
			callableStatement.execute();
			
			rs = callableStatement.getResultSet();
			ReflectionResultSetMapper<CustPaymentDetailsAllDTO> resultSetMapper = new ReflectionResultSetMapper<CustPaymentDetailsAllDTO>(
					CustPaymentDetailsAllDTO.class);
			while(rs.next()){
				CustPaymentDetailsAllDTO custPayment = new CustPaymentDetailsAllDTO();
				custPayment = resultSetMapper.mapRow(rs);
				list.add(custPayment);
			}
			//logger.info("all cust payment details fetched");

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("In DAOException", e);

		} finally {
			try {
				if(rs != null) rs.close();
				if(callableStatement != null) callableStatement.close();
				if(connection != null) connection.close(); 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(em != null) em.close();
		}

		return list;
	}
	
	@Override
	public List<CustPaymentDetailsByIdDTO> getCustPaymentDetailsById(CommonResultSetMapper mapper) throws DAOException {

		
		List<CustPaymentDetailsByIdDTO> list=new ArrayList<CustPaymentDetailsByIdDTO>();
		EntityManager em = null;
		Connection connection = null;
		CallableStatement callableStatement = null;
		ResultSet rs = null;

		try {
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();

			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();
			connection = sessionFactory.getConnectionProvider().getConnection();
			
			callableStatement = connection
					.prepareCall(StoredProcedures.PROC_GET_CUST_PAYMENT_DETAILS_BY_ID);
			int payId = mapper.getPaymentId();
			
			callableStatement.setInt(1, payId);
			callableStatement.setInt(2, mapper.getCompanyId());
			callableStatement.setInt(3, mapper.getStoreId());
			callableStatement.setInt(4, mapper.getFinYrId());
			callableStatement.execute();
			
			rs = callableStatement.getResultSet();
			ReflectionResultSetMapper<CustPaymentDetailsByIdDTO> resultSetMapper = new ReflectionResultSetMapper<CustPaymentDetailsByIdDTO>(
					CustPaymentDetailsByIdDTO.class);
			while(rs.next()){
				CustPaymentDetailsByIdDTO custPayment = new CustPaymentDetailsByIdDTO();
				custPayment = resultSetMapper.mapRow(rs);
				list.add(custPayment);
			}
			//logger.info("cust payment details by id fetched");

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("In DAOException", e);

		} finally {
			try {
				if(rs != null) rs.close();
				if(callableStatement != null) callableStatement.close();
				if(connection != null) connection.close(); 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(em != null) em.close();
		}

		return list;
	}
	
	@Override
	public List<CustPaymentDetailsByIdDTO> getPendingPaymentByCustomer(CommonResultSetMapper mapper) throws DAOException {

		
		List<CustPaymentDetailsByIdDTO> list=new ArrayList<CustPaymentDetailsByIdDTO>();
		EntityManager em = null;
		Connection connection = null;
		CallableStatement callableStatement = null;
		ResultSet rs = null;

		try {
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();

			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();
			connection = sessionFactory.getConnectionProvider().getConnection();
			
			callableStatement = connection
					.prepareCall(StoredProcedures.PROC_GET_CUST_PAYMENT_PENDING);
			//int payId = mapper.getPaymentId();
			java.sql.Date paymntDt = DateUtil.convertStringDateToSqlDate(
					mapper.getPaymentDate(), "yyyy-MM-dd");
			callableStatement.setInt(1, mapper.getCustId());
			callableStatement.setDate(2, paymntDt);
			callableStatement.setInt(3, mapper.getCompanyId());
			callableStatement.setInt(4, mapper.getStoreId());
			callableStatement.setInt(5, mapper.getFinYrId());
			callableStatement.execute();
			
			rs = callableStatement.getResultSet();
			ReflectionResultSetMapper<CustPaymentDetailsByIdDTO> resultSetMapper = new ReflectionResultSetMapper<CustPaymentDetailsByIdDTO>(
					CustPaymentDetailsByIdDTO.class);
			while(rs.next()){
				CustPaymentDetailsByIdDTO custPayment = new CustPaymentDetailsByIdDTO();
				custPayment = resultSetMapper.mapRow(rs);
				list.add(custPayment);
			}
			//logger.info("cust payment pending details fetched");

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("In DAOException", e);

		} finally {
			try {
				if(rs != null) rs.close();
				if(callableStatement != null) callableStatement.close();
				if(connection != null) connection.close(); 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(em != null) em.close();
		}

		return list;
	}
	
	@Override
	public List<SaleHeaderDTO> getLastSaleByCustomer(CommonResultSetMapper mapper) throws DAOException {

		
		List<SaleHeaderDTO> list=new ArrayList<SaleHeaderDTO>();
		EntityManager em = null;
		Connection connection = null;
		CallableStatement callableStatement = null;
		ResultSet rs = null;

		try {
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();

			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();
			connection = sessionFactory.getConnectionProvider().getConnection();
			
			callableStatement = connection
					.prepareCall(StoredProcedures.PROC_GET_LAST_SALE_BY_CUSTOMER);
			int cmpnyId = mapper.getCompanyId();
			int strId = mapper.getStoreId();
			int custId = mapper.getCustId();
			
			callableStatement.setInt(1, cmpnyId);
			callableStatement.setInt(2, strId);
			callableStatement.setInt(3, custId);
			callableStatement.setString(4, mapper.getCustPh());
			
			callableStatement.execute();
			
			rs = callableStatement.getResultSet();
			ReflectionResultSetMapper<SaleHeaderDTO> resultSetMapper = new ReflectionResultSetMapper<SaleHeaderDTO>(
					SaleHeaderDTO.class);
			while(rs.next()){
				SaleHeaderDTO sales = new SaleHeaderDTO();
				sales = resultSetMapper.mapRow(rs);
				list.add(sales);
			}
			//logger.info("last sale details by cust fetched");

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("In DAOException", e);

		} finally {
			try {
				if(rs != null) rs.close();
				if(callableStatement != null) callableStatement.close();
				if(connection != null) connection.close(); 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(em != null) em.close();
		}

		return list;
	}
	
	@Override
	public List<CustomerMaster> getAllCustomerByNameOrPh(CommonResultSetMapper mapper) throws DAOException {

		
		List<CustomerMaster> list=new ArrayList<CustomerMaster>();
		EntityManager em = null;
		Connection connection = null;
		CallableStatement callableStatement = null;
		ResultSet rs = null;

		try {
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();

			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();
			connection = sessionFactory.getConnectionProvider().getConnection();
			
			callableStatement = connection
					.prepareCall(StoredProcedures.PROC_GET_CUSTOMER_PHONE_OR_NAME);
			int cmpnyId = mapper.getCompanyId();
			int strId = mapper.getStoreId();
			String custName = mapper.getCustName();
			String custPh = mapper.getCustPh();
			
			callableStatement.setInt(1, cmpnyId);
			callableStatement.setInt(2, strId);
			callableStatement.setString(3, custName);
			callableStatement.setString(4, custPh);
			callableStatement.execute();
			
			rs = callableStatement.getResultSet();
			while(rs.next()){
				CustomerMaster cust = new CustomerMaster();
				cust.setId(rs.getInt(1));
				cust.setName(rs.getString(2));
				cust.setPhoneNo(rs.getString(3));
				cust.setCreditLimit(rs.getDouble(4));
				list.add(cust);
			}
			//logger.info("fetched all customer");

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("In DAOException", e);

		} finally {
			try {
				if(rs != null) rs.close();
				if(callableStatement != null) callableStatement.close();
				if(connection != null) connection.close(); 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(em != null) em.close();
		}

		return list;
	}
	
	private int getLedgerIdByGroupCode(Sales sales, String grcode)
	{
		int id =0;
		InventoryDAOImpl inventoryDAOImpl = new InventoryDAOImpl();
		CommonResultSetMapper mapper = new CommonResultSetMapper();
		mapper.setCompanyId(sales.getCompanyId());
		mapper.setStoreId(sales.getStoreId());
		mapper.setGroupCode(grcode);
		/*mapper.setAccountID(mapper.getAccountID());
		mapper.setReferenceID(mapper.getReferenceID());*/
		
		List<AccountDTO> accountDTOs;
		try {
			accountDTOs = inventoryDAOImpl.getLedgerDetailsByCode(mapper);
			id = accountDTOs.get(0).getId();
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println("Ledger ID = "+id);
		return id;
	}
	
	@Override
	public String createOrUpdateSalesInvoice(Sales sales)
			throws DAOException {
		EntityManager em = null;
		int status = 0;
		Connection connection = null;
		CallableStatement callableStatement = null;
		
		if(sales.getIs_account()==1)
		{
		
			List<SaleReturnLedger> sls = new ArrayList<>();
			
			if(sales.getDuties_ledger_id()!=0)
			{
				sls.add(new SaleReturnLedger("cr", sales.getDuties_ledger_id(), sales.getTaxAmount()));
			}
			if(sales.getRound_ledger_id()!=0)
			{
				String type="";
				if(sales.getRoundoff()>0)
					type="cr";
				else
					type="dr";
				
				sls.add(new SaleReturnLedger(type, sales.getRound_ledger_id(), Math.abs(sales.getRoundoff())));
			}
			
			if(sales.getDiscount_ledger_id()!=0)
			{
				sls.add(new SaleReturnLedger("dr", sales.getDiscount_ledger_id(), sales.getDiscAmount()));
			}
			
			
			if(sales.getSale_ledger_id()!=0 && sales.getGrossAmount()>0)
			{
				sls.add(new SaleReturnLedger("cr", sales.getSale_ledger_id(), sales.getGrossAmount()));
			}
			
			if(sales.getAdjAmount()>0)
			{
				sls.add(new SaleReturnLedger("dr", getLedgerIdByGroupCode(sales,"REA"), sales.getAdjAmount()));
			}
			
			
			if(sales.getCustomerId()==0) //when customer not present
			{
				if(sales.getDebitor_ledger_id()!=0 && sales.getCashAmount()>0)
				{
					sls.add(new SaleReturnLedger("dr", sales.getDebitor_ledger_id(),sales.getCashAmount()));
				}
				
				if(sales.getCard_ledger_id()!=0 && sales.getCardAmount() != 0)
				{
					sls.add(new SaleReturnLedger("dr", sales.getCard_ledger_id(), sales.getCardAmount()));
				}
				
			}
			
			
			
			
			if(sales.getCustomerId()!=0) {//when customer present
				
					if(sales.getCard_ledger_id()!=0 && sales.getCardAmount() != 0)
					{
						sls.add(new SaleReturnLedger("dr", sales.getCard_ledger_id(), sales.getCardAmount()));
					}
					
					if(sales.getDebitor_ledger_id()!=0 && sales.getCreditAmount()>0)
					{
						sls.add(new SaleReturnLedger("dr", sales.getDebitor_ledger_id(), sales.getCreditAmount()));
					}
					if(sales.getDebitor_cash_ledger_id()!=0 && sales.getCashAmount()>0)
					{
						sls.add(new SaleReturnLedger("dr", sales.getDebitor_cash_ledger_id(), sales.getCashAmount()));
					}
				
			}
			
			if(sales.getLotAdjAmountId()!=0 && sales.getLotAdjAmount()>0)
			{
				sls.add(new SaleReturnLedger("dr", sales.getLotAdjAmountId(), sales.getLotAdjAmount()));
			}
			
			if(sales.getOthAdjAmountId()!=0 && sales.getOthAdjAmount()>0)
			{
				sls.add(new SaleReturnLedger("cr", sales.getOthAdjAmountId(), sales.getOthAdjAmount()));
			}
			
			
			sales.setSalels(sls);
		}
		
		try {
			
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();
			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();
			connection = sessionFactory.getConnectionProvider().getConnection();

			try {
				StringWriter sw = new StringWriter();
				//File file = new	 File("D:\\2017-08-24\\file_sales_invoice_creation.xml");
				JAXBContext jaxbContext = JAXBContext
						.newInstance(Sales.class);
				Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

				jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,
						true);
				//jaxbMarshaller.marshal(sales, file);
				//jaxbMarshaller.marshal(sales, System.out);
				jaxbMarshaller.marshal(sales, sw);
				String result = sw.toString();
				 //System.out.println("output string:: "+result);
				callableStatement = connection
						.prepareCall(StoredProcedures.PROC_CREATE_SALES_INVOICE);
				callableStatement.setString(1, result);
				callableStatement.setString(2, "sales");
				callableStatement.setString(3, "salesDetails");
				callableStatement.setString(4, "salesDetailsSerialMapper");
				
				callableStatement.registerOutParameter(5,
						java.sql.Types.INTEGER);

				callableStatement.execute();
				//invNo = callableStatement.getString(4);
				status = callableStatement.getInt(5);
				/*if (status == 0) {
					result1 = "" + status;
				} else if (status == 1) {
					result1 = invNo;
				}*/
				// result=result.replaceAll("\\<\\?xml(.+?)\\?\\>", "").trim();
				// System.out.println("formatted output::: "+result);

			} 
			
			catch (SQLException e) {
				e.printStackTrace();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			em.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("Check data to be inserted", e);
		} finally {
			try {
				if(callableStatement!=null)
					if(callableStatement != null) callableStatement.close();
				if(connection!=null)
					if(connection != null) connection.close(); 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(em != null) em.close();
		}
		return ""+status;

	}
	
	@Override
	public String createOrUpdateCustPayment(CustomerPayment customerPayment)
			throws DAOException {
		//System.out.println("createOrUpdateCustPayment customerPayment = "+customerPayment);
		EntityManager em = null;
		int status = 0;
		Connection connection = null;
		CallableStatement callableStatement = null;
		
		if(customerPayment.getIs_account()!=1)
		{
			customerPayment.setCr_account_id(0);
			customerPayment.setDr_account_id(0);
			customerPayment.setCr_amount(0);
			customerPayment.setCr_amount(0);
		}
		
		try {
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();
			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();
			connection = sessionFactory.getConnectionProvider().getConnection();

			try {
				StringWriter sw = new StringWriter();
				//File file = new	 File("D:\\2017-06-06\\file_cust_payment_creation.xml");
				JAXBContext jaxbContext = JAXBContext
						.newInstance(CustomerPayment.class);
				Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

				jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,
						true);
				//jaxbMarshaller.marshal(customerPayment, file);
				jaxbMarshaller.marshal(customerPayment, sw);
				String result = sw.toString();
				callableStatement = connection
						.prepareCall(StoredProcedures.PROC_CREATE_CUST_PAYMENT);
				callableStatement.setString(1, result);
				callableStatement.setString(2, "customerPayment");
				callableStatement.setString(3, "customerPaymentDetails");
				
				callableStatement.registerOutParameter(4,
						java.sql.Types.INTEGER);

				callableStatement.execute();
				status = callableStatement.getInt(4);
			
			} 
			
			catch (SQLException e) {
				e.printStackTrace();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			em.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("Check data to be inserted", e);
		} finally {
			try {
				if(callableStatement!=null)
					if(callableStatement != null) callableStatement.close();
				if(connection!=null)
					if(connection != null) connection.close(); 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(em != null) em.close();
		}
		return ""+status;

	}
	
	@Override
	public String createOrUpdateSalesReturn(SaleReturn sales)
			throws DAOException {
		//System.out.println("createOrUpdateSalesReturn salesreturn "+sales);
		EntityManager em = null;
		int status = 0;
		Connection connection = null;
		CallableStatement callableStatement = null;
		
		/*if (sales.!=null) {
			java.sql.Date asonDate = DateUtil.convertStringDateToSqlDate(
			mapper.getAsOnDate(), "yyyy-MM-dd");
			callableStatement.setDate(6, asonDate);
		}*/

		if(sales.getIs_account()==1)
		{
			List<SaleReturnLedger> saleReturnLedgers = new ArrayList<SaleReturnLedger>();
			
			if(sales.getDuties_ledger_id()!=0)
			{
				saleReturnLedgers.add(new SaleReturnLedger("dr", sales.getDuties_ledger_id(), sales.getTaxAmount()));
			}
			if(sales.getRound_ledger_id()!=0)
			{
				String type="";
				if(sales.getRoundoff()>0)
					type="dr";// debit
				else
					type="cr";//credit
				
				
				saleReturnLedgers.add(new SaleReturnLedger(type, sales.getRound_ledger_id(), Math.abs(sales.getRoundoff())));
			}
			if(sales.getSales_ledger_id()!=0)
			{
				saleReturnLedgers.add(new SaleReturnLedger("dr", sales.getSales_ledger_id(), sales.getSale_account_credit_amt()));
			}
			if(sales.getDebitor_ledger_id()!=0)
			{
				saleReturnLedgers.add(new SaleReturnLedger("cr", sales.getDebitor_ledger_id(), sales.getDebitor_credit_amt()));
			}
			
			if(sales.getLotAdjAmountId()!=0 && sales.getLotAdjAmount()>0)
			{
				saleReturnLedgers.add(new SaleReturnLedger("cr", sales.getLotAdjAmountId(), sales.getLotAdjAmount()));
			}
			
			if(sales.getOthAdjAmountId()!=0 && sales.getOthAdjAmount()>0)
			{
				saleReturnLedgers.add(new SaleReturnLedger("dr", sales.getOthAdjAmountId(), sales.getOthAdjAmount()));
			}
			
			sales.setSrls(saleReturnLedgers);
		
		}
		
		try {
			
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();
			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();
			connection = sessionFactory.getConnectionProvider().getConnection();

			try {
				StringWriter sw = new StringWriter();
				//File file = new	 File("D:\\2017-05-05\\file_sales_return_creation.xml");
				JAXBContext jaxbContext = JAXBContext
						.newInstance(SaleReturn.class);
				Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

				jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,
						true);
				//jaxbMarshaller.marshal(sales, file);
				//jaxbMarshaller.marshal(sales, System.out);
				jaxbMarshaller.marshal(sales, sw);
				String result = sw.toString();
				 System.out.println("output string PROC_CREATE_SALES_RETURN:: "+result);
				callableStatement = connection
						.prepareCall(StoredProcedures.PROC_CREATE_SALES_RETURN);
				callableStatement.setString(1, result);
				callableStatement.setString(2, "saleReturn");
				callableStatement.setString(3, "saleReturnDetails");
				callableStatement.setString(4, "saleReturnDetailsSerialMappers");
				
				
				
				
				callableStatement.registerOutParameter(5,
						java.sql.Types.INTEGER);

				callableStatement.execute();
				status = callableStatement.getInt(5);
				
			} 
			
			catch (SQLException e) {
				e.printStackTrace();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			em.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("Check data to be inserted", e);
		} finally {
			try {
				if(callableStatement!=null)
					if(callableStatement != null) callableStatement.close();
				if(connection!=null)
					if(connection != null) connection.close(); 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(em != null) em.close();
		}
		return ""+status;

	}
	
	@Override
	public String postSalesInvoice(CommonResultSetMapper mapper)
			throws DAOException {
		EntityManager em = null;
		int status = 0;
		Connection connection = null;
		CallableStatement callableStatement = null;

		try {
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();
			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();
			connection = sessionFactory.getConnectionProvider().getConnection();

			try {
				int cmpnyId=mapper.getCompanyId();
				int storeId=mapper.getStoreId();
				int saleId=mapper.getSaleId();
				callableStatement = connection
						.prepareCall(StoredProcedures.PROC_POST_SALES_INVOICE);
				callableStatement.setInt(1, cmpnyId);
				callableStatement.setInt(2, storeId);
				callableStatement.setInt(3, saleId);
				callableStatement.registerOutParameter(4,
						java.sql.Types.INTEGER);
				
				callableStatement.execute();
				status = callableStatement.getInt(4);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			em.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("Check data to be posted", e);
		} finally {
			try {
				
				if(callableStatement != null) callableStatement.close();
				if(connection != null) connection.close(); 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(em != null) em.close();
		}
		return ""+status;

	}
	
	@Override
	public String postCustPayment(CommonResultSetMapper mapper)
			throws DAOException {
		EntityManager em = null;
		int status = 0;
		Connection connection = null;
		CallableStatement callableStatement = null;

		try {
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();
			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();
			connection = sessionFactory.getConnectionProvider().getConnection();

			try {
				int cmpnyId=mapper.getCompanyId();
				int storeId=mapper.getStoreId();
				
				callableStatement = connection
						.prepareCall(StoredProcedures.PROC_POST_CUST_PAYMENT);
				callableStatement.setInt(1, cmpnyId);
				callableStatement.setInt(2, storeId);
				callableStatement.setInt(3, mapper.getPaymentId());
				callableStatement.registerOutParameter(4,
						java.sql.Types.INTEGER);
				
				callableStatement.execute();
				status = callableStatement.getInt(4);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			em.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("Check data to be posted", e);
		} finally {
			try {
				
				if(callableStatement != null) callableStatement.close();
				if(connection != null) connection.close(); 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(em != null) em.close();
		}
		return ""+status;

	}
	
	@Override
	public String postSalesReturn(CommonResultSetMapper mapper)
			throws DAOException {
		EntityManager em = null;
		int status = 0;
		Connection connection = null;
		CallableStatement callableStatement = null;

		try {
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();
			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();
			connection = sessionFactory.getConnectionProvider().getConnection();

			try {
				int cmpnyId=mapper.getCompanyId();
				int storeId=mapper.getStoreId();
				int saleRtrnId=mapper.getSaleReturnId();
				callableStatement = connection
						.prepareCall(StoredProcedures.PROC_POST_SALES_RETURN);
				callableStatement.setInt(1, cmpnyId);
				callableStatement.setInt(2, storeId);
				callableStatement.setInt(3, saleRtrnId);
				callableStatement.registerOutParameter(4,
						java.sql.Types.INTEGER);
				
				callableStatement.execute();
				status = callableStatement.getInt(4);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			em.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("Check data to be posted", e);
		} finally {
			try {
				
				if(callableStatement != null) callableStatement.close();
				if(connection != null) connection.close(); 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(em != null) em.close();
		}
		return ""+status;

	}
	
	@Override
	public int incrementPrintCount(String id)	throws DAOException {
		EntityManager em = null;
		Sales sales=null;
		int printCount=0;

		try {
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();
			int id1=Integer.parseInt(id);
				Query qry = em
						.createQuery("SELECT s FROM Sales s WHERE s.id=:id and s.isDeleted=0");

				qry.setParameter("id", id1);
				sales = (Sales) qry.getSingleResult();
				sales.setPrintCount(sales.getPrintCount()+1);
				em.merge(sales);
			
			em.getTransaction().commit();
			//status=ReturnConstant.SUCCESS;
			printCount=sales.getPrintCount();

		} catch (Exception e) {
			printCount=0;
			e.printStackTrace();
			throw new DAOException("Check data to be posted", e);
		} finally {
			if(em != null) em.close();
		}
		
		return printCount;

	}
	
	@Override
	public int getTotal(String id)
			throws DAOException {
		EntityManager em = null;
		Connection connection = null;
		CallableStatement callableStatement = null;
		int count = 0;
		

		try {
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();

			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();
			connection = sessionFactory.getConnectionProvider().getConnection();
			
			callableStatement = connection
					.prepareCall(StoredProcedures.PROC_GET_TOTAL_COUNT);
			int Id1 =Integer.parseInt(id);
			
			callableStatement.setInt(1, Id1);
			
			callableStatement.execute();
			
			count = callableStatement.getInt(1);
			
			//logger.info("fetched all getTotalCount");

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("In DAOException", e);

		} finally {
			try {
				if(callableStatement != null) callableStatement.close();
				if(connection != null) connection.close(); 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(em != null) em.close();
		}

		return count;
	}
	
	/*@Override
	public int printSaleBill(String id, String saleId)	throws DAOException {
		EntityManager em = null;
		String status = "";
		Sales sales=null;
		int printCount=0;

		try {
			int storeid=Integer.parseInt(id);
			int saleid=Integer.parseInt(saleId);
			BillPosPrinterMain billPosPrinterMain=new BillPosPrinterMain();
			billPosPrinterMain.a(storeid, saleid);
			System.out.println("print success");
			

		} catch (Exception e) {
			
			e.printStackTrace();
			throw new DAOException("Check data to be posted", e);
		} finally {
			//if(em != null) em.close();
		}
		
		return printCount;

	}*/
	
	@Override
	public String deleteSalesInvoice(CommonResultSetMapper mapper)
			throws DAOException {
		EntityManager em = null;
		int status = 0;
		Connection connection = null;
		CallableStatement callableStatement = null;

		try {
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();
			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();
			connection = sessionFactory.getConnectionProvider().getConnection();

			try {
				int cmpnyId=mapper.getCompanyId();
				int storeId=mapper.getStoreId();
				int saleid=mapper.getSaleId();
				callableStatement = connection
						.prepareCall(StoredProcedures.PROC_DELETE_SALES_INVOICE);
				callableStatement.setInt(1, cmpnyId);
				callableStatement.setInt(2, storeId);
				callableStatement.setInt(3, saleid);
				callableStatement.setInt(4, mapper.getDeletedBy());
				callableStatement.registerOutParameter(5,
						java.sql.Types.INTEGER);
				
				callableStatement.execute();
				status = callableStatement.getInt(5);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			em.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("Check data to be deleted", e);
		} finally {
			try {
				
				if(callableStatement != null) callableStatement.close();
				if(connection != null) connection.close(); 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(em != null) em.close();
		}
		return ""+status;

	}
	
	@Override
	public String deleteCustPayment(CommonResultSetMapper mapper)
			throws DAOException {
		EntityManager em = null;
		int status = 0;
		Connection connection = null;
		CallableStatement callableStatement = null;

		try {
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();
			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();
			connection = sessionFactory.getConnectionProvider().getConnection();

			try {
				int cmpnyId=mapper.getCompanyId();
				int storeId=mapper.getStoreId();
			
				callableStatement = connection
						.prepareCall(StoredProcedures.PROC_DELETE_CUST_PAYMENT);
				callableStatement.setInt(1, cmpnyId);
				callableStatement.setInt(2, storeId);
				callableStatement.setInt(3, mapper.getPaymentId());
				callableStatement.setInt(4, mapper.getCustId());
				callableStatement.setInt(5, mapper.getDeletedBy());
				callableStatement.registerOutParameter(6,
						java.sql.Types.INTEGER);
				
				callableStatement.execute();
				status = callableStatement.getInt(6);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			em.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("Check data to be deleted", e);
		} finally {
			try {
				
				if(callableStatement != null) callableStatement.close();
				if(connection != null) connection.close(); 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(em != null) em.close();
		}
		return ""+status;

	}
	
	@Override
	public String deleteSalesReturn(CommonResultSetMapper mapper)
			throws DAOException {
		EntityManager em = null;
		int status = 0;
		Connection connection = null;
		CallableStatement callableStatement = null;

		try {
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();
			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();
			connection = sessionFactory.getConnectionProvider().getConnection();

			try {
				int cmpnyId=mapper.getCompanyId();
				int storeId=mapper.getStoreId();
				int saleid=mapper.getSaleReturnId();
				callableStatement = connection
						.prepareCall(StoredProcedures.PROC_DELETE_SALES_RETURN);
				callableStatement.setInt(1, cmpnyId);
				callableStatement.setInt(2, storeId);
				callableStatement.setInt(3, saleid);
				callableStatement.setInt(4, mapper.getDeletedBy());
				callableStatement.registerOutParameter(5,
						java.sql.Types.INTEGER);
				
				callableStatement.execute();
				status = callableStatement.getInt(5);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			em.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("Check data to be deleted", e);
		} finally {
			try {
				
				if(callableStatement != null) callableStatement.close();
				if(connection != null) connection.close(); 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(em != null) em.close();
		}
		return ""+status;

	}
	
	@Override
	public SaleHeaderDTO getSalesHeaderForBill(CommonResultSetMapper mapper) throws DAOException {

		SaleHeaderDTO sales = new SaleHeaderDTO();
		EntityManager em = null;
		Connection connection = null;
		CallableStatement callableStatement = null;
		ResultSet rs = null;

		try {
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();

			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();
			connection = sessionFactory.getConnectionProvider().getConnection();
			
			callableStatement = connection
					.prepareCall(StoredProcedures.PROC_GET_SALE_HEADER_FOR_BILL);
			callableStatement.setInt(1, mapper.getCompanyId());			
			callableStatement.setInt(2, mapper.getStoreId());
			callableStatement.setInt(3, mapper.getSaleId());
			callableStatement.execute();
			
			rs = callableStatement.getResultSet();
			ReflectionResultSetMapper<SaleHeaderDTO> resultSetMapper = new ReflectionResultSetMapper<SaleHeaderDTO>(
					SaleHeaderDTO.class);
			while(rs.next()){
				sales = resultSetMapper.mapRow(rs);
			}
			//logger.info("sale header for bill fetched");

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("In DAOException", e);

		} finally {
			try {
				if(rs != null) rs.close();
				if(callableStatement != null) callableStatement.close();
				if(connection != null) connection.close(); 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(em != null) em.close();
		}

		return sales;
	}

	@Override
	public List<CustomerType> getCustomerType(CommonResultSetMapper mapper)
			throws DAOException {
		List<CustomerType> list=new ArrayList<CustomerType>();
		EntityManager em = null;
		Connection connection = null;
		CallableStatement callableStatement = null;
		ResultSet rs = null;

		try {
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();

			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();
			connection = sessionFactory.getConnectionProvider().getConnection();
			
			callableStatement = connection
					.prepareCall(StoredProcedures.PROC_GET_CUSTOMER_TYPE);
			int cmpnyId = mapper.getCompanyId();
			int strId = mapper.getStoreId();
			
			callableStatement.setInt(1, cmpnyId);
			callableStatement.setInt(2, strId);
			
			callableStatement.execute();
			
			rs = callableStatement.getResultSet();
			while(rs.next()){
				CustomerType cust = new CustomerType();
				cust.setId(rs.getInt(1));
				cust.setTypeName(rs.getString(2));
				list.add(cust);
			}
			//logger.info("fetched all customer");

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("In DAOException", e);

		} finally {
			try {
				if(rs != null) rs.close();
				if(callableStatement != null) callableStatement.close();
				if(connection != null) connection.close(); 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(em != null) em.close();
		}

		return list;
	}

	@Override
	public String insertCardPayment(CardPaymentStatus cardPaymentStatus) throws DAOException {
		EntityManager em = null;
		int status = 0;
		Connection connection = null;
		CallableStatement callableStatement = null;

		try {
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();
			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();
			connection = sessionFactory.getConnectionProvider().getConnection();

			try {
				int cmpnyId=cardPaymentStatus.getCompanyId();
				int storeId=cardPaymentStatus.getStoreId();
				callableStatement = connection
						.prepareCall(StoredProcedures.PROC_INSERT_CARD_PAYMENT);
				callableStatement.setInt(1, cardPaymentStatus.getInvId());
				callableStatement.setString(2, cardPaymentStatus.getCardNo());
				callableStatement.setDouble(3, cardPaymentStatus.getAmount());
				callableStatement.setString(4, cardPaymentStatus.getCardExpiryDate());
				callableStatement.setInt(5, cmpnyId);
				callableStatement.setInt(6, storeId);
				callableStatement.setInt(7, cardPaymentStatus.getCreatedBy());
				callableStatement.registerOutParameter(8,
						java.sql.Types.INTEGER);
				
				callableStatement.execute();
				status = callableStatement.getInt(8);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			em.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("Please Check data to be inserted", e);
		} finally {
			try {
				if(callableStatement!=null)
					if(callableStatement != null) callableStatement.close();
				if(connection!=null)
					if(connection != null) connection.close(); 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(em!=null)
				if(em != null) em.close();
		}
		return ""+status;

	}

	@Override
	public String updateCardPayment(CardPaymentStatus cardPaymentStatus) throws DAOException {
		System.out.println("cardPaymentStatus = "+cardPaymentStatus);
		EntityManager em = null;
		int status = 0;
		Connection connection = null;
		CallableStatement callableStatement = null;
		
		/*if (sales.!=null) {
			java.sql.Date asonDate = DateUtil.convertStringDateToSqlDate(
			mapper.getAsOnDate(), "yyyy-MM-dd");
			callableStatement.setDate(6, asonDate);
		}*/

		try {
			
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();
			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();
			connection = sessionFactory.getConnectionProvider().getConnection();

			try {
				StringWriter sw = new StringWriter();
				//File file = new	 File("D:\\2017-05-05\\file_sales_return_creation.xml");
				JAXBContext jaxbContext = JAXBContext
						.newInstance(CardPaymentStatus.class);
				Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

				jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,
						true);
				//jaxbMarshaller.marshal(sales, file);
				//jaxbMarshaller.marshal(sales, System.out);
				jaxbMarshaller.marshal(cardPaymentStatus, sw);
				String result = sw.toString();
				 //System.out.println("output string cardPaymentStatus: "+result);
				callableStatement = connection
						.prepareCall(StoredProcedures.PROC_UPDATE_CARD_PAYMENT);
				callableStatement.setString(1, result);
				callableStatement.setString(2, "cardPaymentStatus");
				
				
				callableStatement.registerOutParameter(3,
						java.sql.Types.INTEGER);

				callableStatement.execute();
				status = callableStatement.getInt(3);
				
			} 
			
			catch (SQLException e) {
				e.printStackTrace();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			em.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("Check data to be updated", e);
		} finally {
			try {
				if(callableStatement!=null)
					if(callableStatement != null) callableStatement.close();
				if(connection!=null)
					if(connection != null) connection.close(); 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(em != null) em.close();
		}
		return ""+status;

	}

	@Override
	public List<CardPaymentStatus> getAllCardPayments(CommonResultSetMapper mapper) throws DAOException {
		List<CardPaymentStatus> list=new ArrayList<CardPaymentStatus>();
		EntityManager em = null;
		Connection connection = null;
		CallableStatement callableStatement = null;
		ResultSet rs = null;

		try {
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();

			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();
			connection = sessionFactory.getConnectionProvider().getConnection();
			
			callableStatement = connection
					.prepareCall(StoredProcedures.PROC_GET_ALL_CARD_PAYMENT_STATUS);
			int cmpnyId = mapper.getCompanyId();
			int strId = mapper.getStoreId();
			
			callableStatement.setInt(1, cmpnyId);
			callableStatement.setInt(2, strId);
			
			callableStatement.execute();
			
			rs = callableStatement.getResultSet();
			ReflectionResultSetMapper<CardPaymentStatus> resultSetMapper = new ReflectionResultSetMapper<CardPaymentStatus>(
					CardPaymentStatus.class);
			while(rs.next()){
				CardPaymentStatus card = new CardPaymentStatus();
				card = resultSetMapper.mapRow(rs);
				list.add(card);
			}
			//logger.info("fetched all card payments");

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("In DAOException", e);

		} finally {
			try {
				if(rs != null) rs.close();
				if(callableStatement != null) callableStatement.close();
				if(connection != null) connection.close(); 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(em != null) em.close();
		}

		return list;
	}
	
	@Override
	public String deleteCardPaytmentID(CardPaymentStatus cardPStatus) throws DAOException {
		EntityManager em = null;
		int status = 0;
		Connection connection = null;
		CallableStatement callableStatement = null;

		try {
			System.out.println("cardPStatus::"+cardPStatus.getId()+", "+cardPStatus.getCompanyId()+", "+cardPStatus.getStoreId()+", "+cardPStatus.getUpdatedBy());
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();
			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();
			connection = sessionFactory.getConnectionProvider().getConnection();

			try {
				int id=cardPStatus.getId();
				int cmpnyId=cardPStatus.getCompanyId();
				int storeId=cardPStatus.getStoreId();
				int deletedBy=cardPStatus.getUpdatedBy();
				callableStatement = connection
						.prepareCall(StoredProcedures.PROC_DELETE_CARD_PAYMENT_ID);
				callableStatement.setInt(1, id);
				callableStatement.setInt(2, cmpnyId);
				callableStatement.setInt(3, storeId);
				callableStatement.setInt(4, deletedBy);
				callableStatement.registerOutParameter(5,
						java.sql.Types.INTEGER);
				
				callableStatement.execute();
				status = callableStatement.getInt(5);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			em.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("Check data to be deleted", e);
		} finally {
			try {
				
				if(callableStatement != null) callableStatement.close();
				if(connection != null) connection.close(); 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(em != null) em.close();
		}
		return ""+status;

	}

	@Override
	public List<CardPaymentStatus> getAllSaleTransaction(CommonResultSetMapper mapper) throws DAOException {

			List<CardPaymentStatus> list=new ArrayList<CardPaymentStatus>();
			EntityManager em = null;
			Connection connection = null;
			CallableStatement callableStatement = null;
			ResultSet rs = null;
			try {
				entityManagerFactory = PersistenceListener.getEntityManager();
				em = entityManagerFactory.createEntityManager();
				em.getTransaction().begin();

				Session ses = (Session) em.getDelegate();
				SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
						.getSessionFactory();
				connection = sessionFactory.getConnectionProvider().getConnection();
				
				
 callableStatement = connection.prepareCall(StoredProcedures.PROC_GET_ALL_SALE_TRANSACTION);
				callableStatement.setInt(1, mapper.getCompanyId());
				callableStatement.setInt(2, mapper.getStoreId());	
				callableStatement.execute();
				
				rs = callableStatement.getResultSet();
				ReflectionResultSetMapper<CardPaymentStatus> resultSetMapper = new ReflectionResultSetMapper<CardPaymentStatus>(
						CardPaymentStatus.class);
				while(rs.next()){
					CardPaymentStatus sales = new CardPaymentStatus();
					sales = resultSetMapper.mapRow(rs);
					list.add(sales);
				}
				//logger.info("sale header by inv no. fetched");


			} catch (Exception e) {
				e.printStackTrace();
				throw new DAOException("In DAOException", e);

			} finally {
				try {
					if(rs != null) rs.close();
					if(callableStatement != null) callableStatement.close();
					if(connection != null) connection.close(); 
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(em != null) em.close();
			}

			return list;
	}

	@Override
	public ResponseObj createOrUpdateSaleOrder(SaleOrder saleOrder) throws DAOException {
		EntityManager em = null;
		int status = 0;
		Connection connection = null;
		CallableStatement callableStatement = null;
		ResponseObj responseObj=new ResponseObj();

		try {
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();
			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();
			connection = sessionFactory.getConnectionProvider().getConnection();

			try {
				StringWriter sw = new StringWriter();
				//File file = new File("D:\\2017-07-14\\file_purchase_order_creation.xml");
				JAXBContext jaxbContext = JAXBContext
						.newInstance(SaleOrder.class);
				Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

				jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,
						true);
				//jaxbMarshaller.marshal(purchaseOrder, file);
				// jaxbMarshaller.marshal(purchase, System.out);
				jaxbMarshaller.marshal(saleOrder, sw);
				String result = sw.toString();
				
				//System.out.println("saleorder xml = "+result);
				callableStatement = connection
						.prepareCall(StoredProcedures.PROC_CREATE_SALE_ORDER);
				callableStatement.setString(1, result);
				callableStatement.setString(2, "saleOrder");
				callableStatement.setString(3, "saleOrderDetails");
				
				callableStatement.registerOutParameter(4,
						java.sql.Types.INTEGER);

				callableStatement.execute();
				
				status = callableStatement.getInt(4);
				if (status >0) {
					
					responseObj.setStatus(ReturnConstant.SUCCESS);
					responseObj.setId(status);
					responseObj.setReason("Record save successfully.");
					
				} else {
					
					responseObj.setStatus(ReturnConstant.FAILURE);
					responseObj.setId(status);
					responseObj.setReason("Record not saved successfully.");
					
				}

			} 
			
			catch (SQLException e) {
				e.printStackTrace();
				responseObj.setStatus(ReturnConstant.FAILURE);
				responseObj.setId(0);
				responseObj.setReason("Record not saved successfully.");
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			em.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("Check data to be inserted", e);
		} finally {
			try {
				
				if(callableStatement != null) callableStatement.close();
				if(connection != null) connection.close(); 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(em != null) em.close();
		}
		return responseObj;

	}

	@Override
	public List<SaleOrderDTO> getAllSaleOrderDetails(CommonResultSetMapper mapper)
			throws DAOException {

		List<SaleOrderDTO> list = new ArrayList<SaleOrderDTO>();
		EntityManager em = null;
		CallableStatement callableStatement = null;
		Connection connection = null;
		ResultSet rs = null;

		try {
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();

			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();
			connection = sessionFactory.getConnectionProvider().getConnection();
			
			int cmpnyId = mapper.getCompanyId();
			int strId = mapper.getStoreId();
			int finId = mapper.getFinYrId();
			String starDate = mapper.getStartDate();
			String endDate = mapper.getEndDate();
			String invNo = mapper.getInvoiceNo();
			int custId  = mapper.getCustId();
			String custName = mapper.getCustName();		
				
			java.sql.Date startDt = DateUtil.convertStringDateToSqlDate(
					starDate, "yyyy-MM-dd");

			java.sql.Date endDt1 = DateUtil.convertStringDateToSqlDate(endDate,
					"yyyy-MM-dd");

			callableStatement = connection
					.prepareCall(StoredProcedures.PROC_GET_ALL_SALE_ORDER_DETAILS);
			callableStatement.setInt(1, cmpnyId);
			callableStatement.setInt(2, strId);
			callableStatement.setInt(3, finId);
			callableStatement.setDate(4, startDt);
			callableStatement.setDate(5, endDt1);
			callableStatement.setString(6, invNo);
			callableStatement.setInt(7, custId);
			callableStatement.setString(8, custName);

			callableStatement.execute();
			rs = callableStatement.getResultSet();
		
			ReflectionResultSetMapper<SaleOrderDTO> resultSetMapper = new ReflectionResultSetMapper<SaleOrderDTO>(
					SaleOrderDTO.class);
			while(rs.next()){
				SaleOrderDTO rurchseRtrn=new SaleOrderDTO();
				rurchseRtrn = resultSetMapper.mapRow(rs);
				list.add(rurchseRtrn);
				
			}

			//logger.info("sale all sale order details fetched");

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("In DAOException", e);

		} finally {
			try {
				if(rs != null) rs.close();
				if(callableStatement != null) callableStatement.close();
				if(connection != null) connection.close(); 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(em != null) em.close();
		}

		return list;
	}

	@Override
	public SaleOrderDTO getSaleOrderHeaderById(CommonResultSetMapper mapper) throws DAOException {
		//List<PurchaseOrderDTO> list = new ArrayList<PurchaseOrderDTO>();
		SaleOrderDTO rurchseRtrn=new SaleOrderDTO();
		EntityManager em = null;
		CallableStatement callableStatement = null;
		Connection connection = null;
		ResultSet rs = null;

		try {
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();

			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();
			connection = sessionFactory.getConnectionProvider().getConnection();
			
			callableStatement = connection
					.prepareCall(StoredProcedures.PROC_GET_SALE_ORDER_HEADER_BY_ID);
			callableStatement.setInt(1, mapper.getPurchaseOrderId());
			
			callableStatement.execute();
			rs = callableStatement.getResultSet();
		
			ReflectionResultSetMapper<SaleOrderDTO> resultSetMapper = new ReflectionResultSetMapper<SaleOrderDTO>(
					SaleOrderDTO.class);
			while(rs.next()){
				
				rurchseRtrn = resultSetMapper.mapRow(rs);
			
				
			}

			//logger.info("sale order header by id fetched");

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("In DAOException", e);

		} finally {
			try {
				if(rs != null) rs.close();
				if(callableStatement != null) callableStatement.close();
				if(connection != null) connection.close(); 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(em != null) em.close();
		}

		return rurchseRtrn;
	}
	
	@Override
	public List<SaleOrderDetailsDTO> getSaleOrderDetailsById(CommonResultSetMapper mapper)
			throws DAOException {

		List<SaleOrderDetailsDTO> list = new ArrayList<SaleOrderDetailsDTO>();
		EntityManager em = null;
		CallableStatement callableStatement = null;
		Connection connection = null;
		ResultSet rs = null;

		try {
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();

			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();
			connection = sessionFactory.getConnectionProvider().getConnection();
			
			callableStatement = connection
					.prepareCall(StoredProcedures.PROC_GET_SALE_ORDER_DETAILS_BY_ID);
			callableStatement.setInt(1, mapper.getPurchaseOrderId());
			
			callableStatement.execute();
			rs = callableStatement.getResultSet();
		
			ReflectionResultSetMapper<SaleOrderDetailsDTO> resultSetMapper = new ReflectionResultSetMapper<SaleOrderDetailsDTO>(
					SaleOrderDetailsDTO.class);
			while(rs.next()){
				SaleOrderDetailsDTO rurchseRtrn=new SaleOrderDetailsDTO();
				rurchseRtrn = resultSetMapper.mapRow(rs);
				list.add(rurchseRtrn);
				
			}

			//logger.info("sale order details by id fetched");

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("In DAOException", e);

		} finally {
			try {
				if(rs != null) rs.close();
				if(callableStatement != null) callableStatement.close();
				if(connection != null) connection.close(); 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(em != null) em.close();
		}

		return list;
	}
	
	@Override
	public List<SaleOrderDetailsDTO> getSaleOrderDetailsByInvNo(CommonResultSetMapper mapper)
			throws DAOException {

		List<SaleOrderDetailsDTO> list = new ArrayList<SaleOrderDetailsDTO>();
		EntityManager em = null;
		CallableStatement callableStatement = null;
		Connection connection = null;
		ResultSet rs = null;

		try {
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();

			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();
			connection = sessionFactory.getConnectionProvider().getConnection();
			
			callableStatement = connection
					.prepareCall(StoredProcedures.PROC_GET_SALE_ORDER_DETAILS_BY_INV_NO);
			callableStatement.setInt(1, mapper.getCompanyId());
			callableStatement.setInt(2, mapper.getStoreId());
			callableStatement.setInt(3, mapper.getFinYrId());
			callableStatement.setString(4, mapper.getInvoiceNo());
			
			callableStatement.execute();
			rs = callableStatement.getResultSet();
		
			ReflectionResultSetMapper<SaleOrderDetailsDTO> resultSetMapper = new ReflectionResultSetMapper<SaleOrderDetailsDTO>(
					SaleOrderDetailsDTO.class);
			while(rs.next()){
				SaleOrderDetailsDTO rurchseRtrn=new SaleOrderDetailsDTO();
				rurchseRtrn = resultSetMapper.mapRow(rs);
				list.add(rurchseRtrn);
				
			}

			//logger.info("sale order details by inv no fetched");

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("In DAOException", e);

		} finally {
			try {
				if(rs != null) rs.close();
				if(callableStatement != null) callableStatement.close();
				if(connection != null) connection.close(); 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(em != null) em.close();
		}

		return list;
	}
	
	@Override
	public ResponseObj closeSaleOrder(CommonResultSetMapper mapper)
			throws DAOException {
		EntityManager em = null;
		int status = 0;
		Connection connection = null;
		CallableStatement callableStatement = null;
		ResponseObj responseObj = new ResponseObj();
		try {
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();
			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();
			connection = sessionFactory.getConnectionProvider().getConnection();

			try {
				int cmpnyId=mapper.getCompanyId();
				int storeId=mapper.getStoreId();
				int purchaseId=mapper.getPurchaseOrderId();
				callableStatement = connection
						.prepareCall(StoredProcedures.PROC_CLOSE_SALE_ORDER);
				callableStatement.setInt(1, cmpnyId);
				callableStatement.setInt(2, storeId);
				callableStatement.setInt(3, mapper.getFinYrId());
				callableStatement.setInt(4, purchaseId);
				callableStatement.registerOutParameter(5,
						java.sql.Types.INTEGER);
				
				callableStatement.execute();
				status = callableStatement.getInt(5);
				
				if (status >0) {
					
					responseObj.setStatus(ReturnConstant.SUCCESS);
					responseObj.setId(status);
					responseObj.setReason("PO closed successfully.");
					
				} else {
					
					responseObj.setStatus(ReturnConstant.FAILURE);
					responseObj.setId(status);
					responseObj.setReason("PO not closed successfully.");
					
				}
				
			} catch (Exception e) {
				e.printStackTrace();
				responseObj.setStatus(ReturnConstant.FAILURE);
				responseObj.setId(0);
				responseObj.setReason("PO not closed successfully.");
			}
			em.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("Check data to be posted", e);
		} finally {
			try {
				
				callableStatement.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			em.close();
		}
		return responseObj;
	}
	
	@Override
	public ResponseObj deleteSaleOrder(CommonResultSetMapper mapper) throws DAOException {
			EntityManager em = null;
			int status = 0;
			Connection connection = null;
			CallableStatement callableStatement = null;
			ResponseObj responseObj=new ResponseObj();
			try {
				entityManagerFactory = PersistenceListener.getEntityManager();
				em = entityManagerFactory.createEntityManager();
				em.getTransaction().begin();
				Session ses = (Session) em.getDelegate();
				SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
						.getSessionFactory();
				connection = sessionFactory.getConnectionProvider().getConnection();

				try {
					int cmpnyId=mapper.getCompanyId();
					int storeId=mapper.getStoreId();
					int purchaseId=mapper.getPurchaseOrderId();
					callableStatement = connection
							.prepareCall(StoredProcedures.PROC_DELETE_SALE_ORDER);
					callableStatement.setInt(1, cmpnyId);
					callableStatement.setInt(2, storeId);
					callableStatement.setInt(3, purchaseId);
					callableStatement.setInt(4, mapper.getDeletedBy());
					callableStatement.registerOutParameter(5,
							java.sql.Types.INTEGER);
					
					callableStatement.execute();
					status = callableStatement.getInt(5);
					
					if (status >0) {
						
						responseObj.setStatus(ReturnConstant.SUCCESS);
						responseObj.setId(status);
						responseObj.setReason("PO deleted successfully.");
						
					} else {
						
						responseObj.setStatus(ReturnConstant.FAILURE);
						responseObj.setId(status);
						responseObj.setReason("PO not deleted successfully.");
						
					}
					
				} catch (Exception e) {
					e.printStackTrace();
					responseObj.setStatus(ReturnConstant.FAILURE);
					responseObj.setId(0);
					responseObj.setReason("PO not deleted successfully.");
					throw new DAOException("Check data to be deleted", e);
				}
				em.getTransaction().commit();

			} catch (Exception e) {
				e.printStackTrace();
				throw new DAOException("Check data to be deleted", e);
			} finally {
				try {
					
					callableStatement.close();
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				em.close();
			}
			return responseObj;
	
	}
	
	@Override
	public ResponseObj postSaleOrder(CommonResultSetMapper mapper) throws DAOException {
		
		EntityManager em = null;
		int status = 0;
		Connection connection = null;
		CallableStatement callableStatement = null;
		ResponseObj responseObj = new ResponseObj();
		try {
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();
			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();
			connection = sessionFactory.getConnectionProvider().getConnection();

			try {
				int cmpnyId=mapper.getCompanyId();
				int storeId=mapper.getStoreId();
				int purchaseId=mapper.getPurchaseOrderId();
				callableStatement = connection
						.prepareCall(StoredProcedures.PROC_POST_SALE_ORDER);
				callableStatement.setInt(1, cmpnyId);
				callableStatement.setInt(2, storeId);
				callableStatement.setInt(3, purchaseId);
				callableStatement.registerOutParameter(4,
						java.sql.Types.INTEGER);
				
				callableStatement.execute();
				status = callableStatement.getInt(4);
				
				if (status >0) {
					
					responseObj.setStatus(ReturnConstant.SUCCESS);
					responseObj.setId(status);
					responseObj.setReason("Data posted successfully.");
					
				} else {
					
					responseObj.setStatus(ReturnConstant.FAILURE);
					responseObj.setId(status);
					responseObj.setReason("Data not posted successfully.");
					
				}
				
			} catch (Exception e) {
				e.printStackTrace();
				responseObj.setStatus(ReturnConstant.FAILURE);
				responseObj.setId(0);
				responseObj.setReason("Data not posted successfully.");
			}
			em.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("Check data to be posted", e);
		} finally {
			try {
				
				callableStatement.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			em.close();
		}
		return responseObj;

	}
	@Override
	public List<SaleOrderDetailsDTO> getPendingSaleOrderDetails(CommonResultSetMapper mapper)throws DAOException {
		
		List<SaleOrderDetailsDTO> list = new ArrayList<SaleOrderDetailsDTO>();
		EntityManager em = null;
		CallableStatement callableStatement = null;
		Connection connection = null;
		ResultSet rs = null;

		try {
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();

			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();
			connection = sessionFactory.getConnectionProvider().getConnection();
			
			callableStatement = connection
					.prepareCall(StoredProcedures.PROC_GET_PENDING_SALE_ORDER_DETAILS_BY_INV_NO);
			callableStatement.setInt(1, mapper.getCompanyId());
			callableStatement.setInt(2, mapper.getStoreId());
			callableStatement.setInt(3, mapper.getFinYrId());
			callableStatement.setString(4, mapper.getInvoiceNo());
			callableStatement.setInt(5, mapper.getCustId());
			
			//System.out.println("get pending so call = " + callableStatement);
			callableStatement.execute();
			rs = callableStatement.getResultSet();
		
			ReflectionResultSetMapper<SaleOrderDetailsDTO> resultSetMapper = new ReflectionResultSetMapper<SaleOrderDetailsDTO>(
					SaleOrderDetailsDTO.class);
			while(rs.next()){
				SaleOrderDetailsDTO rurchseRtrn=new SaleOrderDetailsDTO();
				rurchseRtrn = resultSetMapper.mapRow(rs);
				list.add(rurchseRtrn);
				
			}

			//logger.info("pending purchase order details by inv no. fetched");

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("In DAOException", e);

		} finally {
			try {
				rs.close();
				callableStatement.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			em.close();
		}

		return list;
	}

	@Override
	public List<SaleOrderDetailsDTO> getSalesOrderDetailsByIdForBill(CommonResultSetMapper mapper) throws DAOException {
			List<SaleOrderDetailsDTO> list=new ArrayList<SaleOrderDetailsDTO>();
			EntityManager em = null;
			Connection connection = null;
			CallableStatement callableStatement = null;
			ResultSet rs = null;

			try {
				entityManagerFactory = PersistenceListener.getEntityManager();
				em = entityManagerFactory.createEntityManager();
				em.getTransaction().begin();

				Session ses = (Session) em.getDelegate();
				SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
						.getSessionFactory();
				connection = sessionFactory.getConnectionProvider().getConnection();
				
				callableStatement = connection
						.prepareCall(StoredProcedures.PROC_GET_SALES_ORDER_DETAILS_By_Id_FOR_BILL);
				callableStatement.setInt(1, mapper.getCompanyId());
				callableStatement.setInt(2, mapper.getStoreId());
				callableStatement.setInt(3, mapper.getSaleId());
				callableStatement.execute();
				
				rs = callableStatement.getResultSet();
				ReflectionResultSetMapper<SaleOrderDetailsDTO> resultSetMapper = new ReflectionResultSetMapper<SaleOrderDetailsDTO>(
						SaleOrderDetailsDTO.class);
				while(rs.next()){
					SaleOrderDetailsDTO salesorder = new SaleOrderDetailsDTO();
					salesorder = resultSetMapper.mapRow(rs);
					list.add(salesorder);
				}
				//logger.info("sale order details for bill fetched");

			} catch (Exception e) {
				e.printStackTrace();
				throw new DAOException("In DAOException", e);

			} finally {
				try {
					rs.close();
					callableStatement.close();
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				em.close();
			}

			return list;
	}
	
	@Override
	public SaleOrderHeaderDTO getSalesOrderHeaderForBill(CommonResultSetMapper mapper) throws DAOException {

		SaleOrderHeaderDTO sales = new SaleOrderHeaderDTO();
			EntityManager em = null;
			Connection connection = null;
			CallableStatement callableStatement = null;
			ResultSet rs = null;

			try {
				entityManagerFactory = PersistenceListener.getEntityManager();
				em = entityManagerFactory.createEntityManager();
				em.getTransaction().begin();

				Session ses = (Session) em.getDelegate();
				SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
						.getSessionFactory();
				connection = sessionFactory.getConnectionProvider().getConnection();
				
				callableStatement = connection
						.prepareCall(StoredProcedures.PROC_GET_SALE_ORDER_HEADER_BY_ID_FOR_BILL);
				callableStatement.setInt(1, mapper.getCompanyId());			
				callableStatement.setInt(2, mapper.getStoreId());
				callableStatement.setInt(3, mapper.getSaleId());
				callableStatement.execute();
				
				rs = callableStatement.getResultSet();
				ReflectionResultSetMapper<SaleOrderHeaderDTO> resultSetMapper = new ReflectionResultSetMapper<SaleOrderHeaderDTO>(
						SaleOrderHeaderDTO.class);
				while(rs.next()){
					sales = resultSetMapper.mapRow(rs);
				}
				//logger.info("sale order header for bill fetched");

			} catch (Exception e) {
				e.printStackTrace();
				throw new DAOException("In DAOException", e);

			} finally {
				try {
					rs.close();
					callableStatement.close();
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				em.close();
			}

			return sales;
		}
	
	@Override
	public List<TaxDetailsSaleBillDTO> getTaxDetailsForSaleOrderBill(CommonResultSetMapper mapper) throws DAOException {

		
		List<TaxDetailsSaleBillDTO> list=new ArrayList<TaxDetailsSaleBillDTO>();
		EntityManager em = null;
		Connection connection = null;
		CallableStatement callableStatement = null;
		ResultSet rs = null;

		try {
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();

			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();
			connection = sessionFactory.getConnectionProvider().getConnection();
			
			callableStatement = connection
					.prepareCall(StoredProcedures.PROC_GET_SALE_ORDER_TAX_DETAILS_BY_ID_FOR_BILL);
			callableStatement.setInt(1, mapper.getCompanyId());			
			callableStatement.setInt(2, mapper.getStoreId());
			callableStatement.setInt(3, mapper.getSaleId());
			callableStatement.execute();
			
			rs = callableStatement.getResultSet();
			ReflectionResultSetMapper<TaxDetailsSaleBillDTO> resultSetMapper = new ReflectionResultSetMapper<TaxDetailsSaleBillDTO>(
					TaxDetailsSaleBillDTO.class);
			while(rs.next()){
				TaxDetailsSaleBillDTO tax = new TaxDetailsSaleBillDTO();
				tax = resultSetMapper.mapRow(rs);
				list.add(tax);
			}
			//logger.info("tax details fetched");

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("In DAOException", e);

		} finally {
			try {
				rs.close();
				callableStatement.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			em.close();
		}

		return list;
	}
	
	@Override
	public ResponseObj createOrUpdateSaleTourPlan(SaleTourPlan saleTourPlan) throws DAOException {
		EntityManager em = null;
		int status = 0;
		Connection connection = null;
		CallableStatement callableStatement = null;
		ResponseObj responseObj=new ResponseObj();

		try {
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();
			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();
			connection = sessionFactory.getConnectionProvider().getConnection();

			try {
				StringWriter sw = new StringWriter();
				//File file = new File("D:\\2017-07-14\\file_purchase_order_creation.xml");
				JAXBContext jaxbContext = JAXBContext
						.newInstance(SaleTourPlan.class);
				Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

				jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,
						true);
				//jaxbMarshaller.marshal(purchaseOrder, file);
				// jaxbMarshaller.marshal(purchase, System.out);
				jaxbMarshaller.marshal(saleTourPlan, sw);
				String result = sw.toString();
				
				//System.out.println("saletourplan xml = "+result);
				callableStatement = connection
						.prepareCall(StoredProcedures.PROC_CREATE_SALE_TOUR_PLAN);
				callableStatement.setString(1, result);
				callableStatement.setString(2, "saleTourPlan");
				callableStatement.setString(3, "saleTourPlanDetails");
				
				callableStatement.registerOutParameter(4,
						java.sql.Types.INTEGER);

				callableStatement.execute();
				
				status = callableStatement.getInt(4);
				if (status >0) {
					
					responseObj.setStatus(ReturnConstant.SUCCESS);
					responseObj.setId(status);
					responseObj.setReason("Record save successfully.");
					
				} else {
					
					responseObj.setStatus(ReturnConstant.FAILURE);
					responseObj.setId(status);
					responseObj.setReason("Record not saved successfully.");
					
				}

			} 
			
			catch (SQLException e) {
				e.printStackTrace();
				responseObj.setStatus(ReturnConstant.FAILURE);
				responseObj.setId(0);
				responseObj.setReason("Record not saved successfully.");
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			em.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("Check data to be inserted", e);
		} finally {
			try {
				
				if(callableStatement != null) callableStatement.close();
				if(connection != null) connection.close(); 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(em != null) em.close();
		}
		return responseObj;

	}
	
	//added on 27.06.2019
	@Override
	public List<SaleTourPlanDTO> getAllSaleTourPlanDetails(CommonResultSetMapper mapper)
			throws DAOException {

		List<SaleTourPlanDTO> list = new ArrayList<SaleTourPlanDTO>();
		EntityManager em = null;
		CallableStatement callableStatement = null;
		Connection connection = null;
		ResultSet rs = null;

		try {
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();

			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();
			connection = sessionFactory.getConnectionProvider().getConnection();
			
			int cmpnyId = mapper.getCompanyId();
			int strId = mapper.getStoreId();
			int finId = mapper.getFinYrId();
			String starDate = mapper.getStartDate();
			String endDate = mapper.getEndDate();
			int salemanId  = mapper.getSalesmanId();
					
				
			java.sql.Date startDt = DateUtil.convertStringDateToSqlDate(
					starDate, "yyyy-MM-dd");

			java.sql.Date endDt1 = DateUtil.convertStringDateToSqlDate(endDate,
					"yyyy-MM-dd");

			callableStatement = connection
					.prepareCall(StoredProcedures.PROC_GET_ALL_SALE_TOUR_PLAN_DETAILS);
			callableStatement.setInt(1, cmpnyId);
			callableStatement.setInt(2, strId);
			callableStatement.setInt(3, finId);
			callableStatement.setDate(4, startDt);
			callableStatement.setDate(5, endDt1);
			callableStatement.setInt(6, salemanId);
			callableStatement.execute();
			rs = callableStatement.getResultSet();
		
			ReflectionResultSetMapper<SaleTourPlanDTO> resultSetMapper = new ReflectionResultSetMapper<SaleTourPlanDTO>(
					SaleTourPlanDTO.class);
			while(rs.next()){
				SaleTourPlanDTO tourPlan=new SaleTourPlanDTO();
				tourPlan = resultSetMapper.mapRow(rs);
				list.add(tourPlan);
				
			}

			//logger.info("sale all sale tourplan details fetched");

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("In DAOException", e);

		} finally {
			try {
				if(rs != null) rs.close();
				if(callableStatement != null) callableStatement.close();
				if(connection != null) connection.close(); 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(em != null) em.close();
		}

		return list;
	}

	@Override
	public SaleTourPlanDTO getSaleTourPlanHeaderById(CommonResultSetMapper mapper) throws DAOException {
		//List<PurchaseOrderDTO> list = new ArrayList<PurchaseOrderDTO>();
		SaleTourPlanDTO tourPlan=new SaleTourPlanDTO();
		EntityManager em = null;
		CallableStatement callableStatement = null;
		Connection connection = null;
		ResultSet rs = null;

		try {
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();

			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();
			connection = sessionFactory.getConnectionProvider().getConnection();
			
			callableStatement = connection
					.prepareCall(StoredProcedures.PROC_GET_SALE_TOUR_PLAN_HEADER_BY_ID);
			callableStatement.setInt(1, mapper.getTourplanId());
			
			callableStatement.execute();
			rs = callableStatement.getResultSet();
		
			ReflectionResultSetMapper<SaleTourPlanDTO> resultSetMapper = new ReflectionResultSetMapper<SaleTourPlanDTO>(
					SaleTourPlanDTO.class);
			while(rs.next()){
				
				tourPlan = resultSetMapper.mapRow(rs);
			
				
			}

			//logger.info("sale tourplan header by id fetched");

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("In DAOException", e);

		} finally {
			try {
				if(rs != null) rs.close();
				if(callableStatement != null) callableStatement.close();
				if(connection != null) connection.close(); 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(em != null) em.close();
		}

		return tourPlan;
	}
	
	@Override
	public List<SaleTourPlanDetailsDTO> getSaleTourPlanDetailsById(CommonResultSetMapper mapper)
			throws DAOException {

		List<SaleTourPlanDetailsDTO> list = new ArrayList<SaleTourPlanDetailsDTO>();
		EntityManager em = null;
		CallableStatement callableStatement = null;
		Connection connection = null;
		ResultSet rs = null;

		try {
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();

			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();
			connection = sessionFactory.getConnectionProvider().getConnection();
			
			callableStatement = connection
					.prepareCall(StoredProcedures.PROC_GET_SALE_TOUR_PLAN_DETAILS_BY_ID);
			callableStatement.setInt(1, mapper.getTourplanId());
			
			callableStatement.execute();
			rs = callableStatement.getResultSet();
		
			ReflectionResultSetMapper<SaleTourPlanDetailsDTO> resultSetMapper = new ReflectionResultSetMapper<SaleTourPlanDetailsDTO>(
					SaleTourPlanDetailsDTO.class);
			while(rs.next()){
				SaleTourPlanDetailsDTO tourPlan=new SaleTourPlanDetailsDTO();
				tourPlan = resultSetMapper.mapRow(rs);
				list.add(tourPlan);
				
			}

			//logger.info("sale tourplan  details by id fetched");

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("In DAOException", e);

		} finally {
			try {
				if(rs != null) rs.close();
				if(callableStatement != null) callableStatement.close();
				if(connection != null) connection.close(); 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(em != null) em.close();
		}

		return list;
	}
	
	@Override
	public ResponseObj cancelSaleTourPlan(CommonResultSetMapper mapper)
			throws DAOException {
		EntityManager em = null;
		int status = 0;
		Connection connection = null;
		CallableStatement callableStatement = null;
		ResponseObj responseObj = new ResponseObj();
		try {
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();
			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();
			connection = sessionFactory.getConnectionProvider().getConnection();

			try {
				int cmpnyId=mapper.getCompanyId();
				int storeId=mapper.getStoreId();
				int tourplanId=mapper.getTourplanId();
				String cancelremarks=mapper.getRemarks();
				callableStatement = connection
						.prepareCall(StoredProcedures.PROC_CANCEL_SALE_TOUR_PLAN);
				callableStatement.setInt(1, cmpnyId);
				callableStatement.setInt(2, storeId);
				callableStatement.setInt(3, mapper.getFinYrId());
				callableStatement.setInt(4, tourplanId);
				callableStatement.setString(5, cancelremarks);
				callableStatement.registerOutParameter(6,
						java.sql.Types.INTEGER);
				
				callableStatement.execute();
				status = callableStatement.getInt(6);
				
				if (status ==-12) {
					
					responseObj.setStatus(ReturnConstant.SUCCESS);
					responseObj.setId(status);
					responseObj.setReason("STP cancelled successfully.");
					
				} else {
					
					responseObj.setStatus(ReturnConstant.FAILURE);
					responseObj.setId(status);
					responseObj.setReason("STP not cancelled successfully.");
					
				}
				
			} catch (Exception e) {
				e.printStackTrace();
				responseObj.setStatus(ReturnConstant.FAILURE);
				responseObj.setId(0);
				responseObj.setReason("STP not cancelled successfully.");
			}
			em.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("Check data to be posted", e);
		} finally {
			try {
				
				callableStatement.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			em.close();
		}
		return responseObj;
	}
	
	@Override
	public ResponseObj deleteSaleTourPlan(CommonResultSetMapper mapper) throws DAOException {
			EntityManager em = null;
			int status = 0;
			Connection connection = null;
			CallableStatement callableStatement = null;
			ResponseObj responseObj=new ResponseObj();
			try {
				entityManagerFactory = PersistenceListener.getEntityManager();
				em = entityManagerFactory.createEntityManager();
				em.getTransaction().begin();
				Session ses = (Session) em.getDelegate();
				SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
						.getSessionFactory();
				connection = sessionFactory.getConnectionProvider().getConnection();

				try {
					int cmpnyId=mapper.getCompanyId();
					int storeId=mapper.getStoreId();
					int tourplanId=mapper.getTourplanId();
					callableStatement = connection
							.prepareCall(StoredProcedures.PROC_DELETE_SALE_TOUR_PLAN);
					callableStatement.setInt(1, cmpnyId);
					callableStatement.setInt(2, storeId);
					callableStatement.setInt(3, tourplanId);
					callableStatement.setInt(4, mapper.getDeletedBy());
					callableStatement.registerOutParameter(5,
							java.sql.Types.INTEGER);
					
					callableStatement.execute();
					status = callableStatement.getInt(5);
					
					if (status ==-1) {
						
						responseObj.setStatus(ReturnConstant.SUCCESS);
						responseObj.setId(status);
						responseObj.setReason("STP deleted successfully.");
						
					} else {
						
						responseObj.setStatus(ReturnConstant.FAILURE);
						responseObj.setId(status);
						responseObj.setReason("STP not deleted successfully.");
						
					}
					
				} catch (Exception e) {
					e.printStackTrace();
					responseObj.setStatus(ReturnConstant.FAILURE);
					responseObj.setId(0);
					responseObj.setReason("STP not deleted successfully.");
					throw new DAOException("Check data to be deleted", e);
				}
				em.getTransaction().commit();

			} catch (Exception e) {
				e.printStackTrace();
				throw new DAOException("Check data to be deleted", e);
			} finally {
				try {
					
					callableStatement.close();
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				em.close();
			}
			return responseObj;
	
	}
	
	@Override
	public ResponseObj postSaleTourPlan(CommonResultSetMapper mapper) throws DAOException {
		
		EntityManager em = null;
		int status = 0;
		Connection connection = null;
		CallableStatement callableStatement = null;
		ResponseObj responseObj = new ResponseObj();
		try {
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();
			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();
			connection = sessionFactory.getConnectionProvider().getConnection();

			try {
				int cmpnyId=mapper.getCompanyId();
				int storeId=mapper.getStoreId();
				int tourplanId=mapper.getTourplanId();
				callableStatement = connection
						.prepareCall(StoredProcedures.PROC_POST_SALE_TOUR_PLAN);
				callableStatement.setInt(1, cmpnyId);
				callableStatement.setInt(2, storeId);
				callableStatement.setInt(3, tourplanId);
				callableStatement.registerOutParameter(4,
						java.sql.Types.INTEGER);
				
				callableStatement.execute();
				status = callableStatement.getInt(4);
				
				if (status ==-11) {
					
					responseObj.setStatus(ReturnConstant.SUCCESS);
					responseObj.setId(status);
					responseObj.setReason("Data posted successfully.");
					
				} else {
					
					responseObj.setStatus(ReturnConstant.FAILURE);
					responseObj.setId(status);
					responseObj.setReason("Data not posted successfully.");
					
				}
				
			} catch (Exception e) {
				e.printStackTrace();
				responseObj.setStatus(ReturnConstant.FAILURE);
				responseObj.setId(0);
				responseObj.setReason("Data not posted successfully.");
			}
			em.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("Check data to be posted", e);
		} finally {
			try {
				
				callableStatement.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			em.close();
		}
		return responseObj;

	}
	
	@Override
	public ResponseObj createSaleManTourDetail(SaleManTourDetails salesmanTour) throws DAOException {
		EntityManager em = null;
		int status = 0;
		Connection connection = null;
		CallableStatement callableStatement = null;
		ResponseObj responseObj=new ResponseObj();

		try {
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();
			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();
			connection = sessionFactory.getConnectionProvider().getConnection();

			try {
				StringWriter sw = new StringWriter();
				//File file = new File("D:\\2017-07-14\\file_purchase_order_creation.xml");
				JAXBContext jaxbContext = JAXBContext
						.newInstance(SaleManTourDetails.class);
				Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

				jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,
						true);
				//jaxbMarshaller.marshal(purchaseOrder, file);
				// jaxbMarshaller.marshal(purchase, System.out);
				jaxbMarshaller.marshal(salesmanTour, sw);
				String result = sw.toString();
				
				//System.out.println("salemantour xml = "+result);
				callableStatement = connection
						.prepareCall(StoredProcedures.PROC_CREATE_SALE_MAN_TOUR);
				callableStatement.setString(1, result);
				callableStatement.setString(2, "saleManTourDetails");
				
				callableStatement.registerOutParameter(3,
						java.sql.Types.INTEGER);

				callableStatement.execute();
				
				status = callableStatement.getInt(3);
				if (status >0) {
					
					responseObj.setStatus(ReturnConstant.SUCCESS);
					responseObj.setId(status);
					responseObj.setReason("Record save successfully.");
					
				} else {
					
					responseObj.setStatus(ReturnConstant.FAILURE);
					responseObj.setId(status);
					responseObj.setReason("Record not saved successfully.");
					
				}

			} 
			
			catch (SQLException e) {
				e.printStackTrace();
				responseObj.setStatus(ReturnConstant.FAILURE);
				responseObj.setId(0);
				responseObj.setReason("Record not saved successfully.");
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			em.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("Check data to be inserted", e);
		} finally {
			try {
				
				if(callableStatement != null) callableStatement.close();
				if(connection != null) connection.close(); 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(em != null) em.close();
		}
		return responseObj;

	}
	
	@Override
	public List<SaleManTourDetailsDTO> getSaleManTourDetails(CommonResultSetMapper mapper)
			throws DAOException {

		List<SaleManTourDetailsDTO> list = new ArrayList<SaleManTourDetailsDTO>();
		EntityManager em = null;
		CallableStatement callableStatement = null;
		Connection connection = null;
		ResultSet rs = null;

		try {
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();

			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();
			connection = sessionFactory.getConnectionProvider().getConnection();
			
			int cmpnyId = mapper.getCompanyId();
			int strId = mapper.getStoreId();
			int finId = mapper.getFinYrId();
			String invDate = mapper.getInvDate();
			int salemanId  = mapper.getSalesmanId();
					
				
			java.sql.Date invDt = DateUtil.convertStringDateToSqlDate(
					invDate, "yyyy-MM-dd");

			callableStatement = connection
					.prepareCall(StoredProcedures.PROC_GET_SALE_MAN_TOUR_DETAILS);
			callableStatement.setInt(1, cmpnyId);
			callableStatement.setInt(2, strId);
			callableStatement.setInt(3, finId);
			callableStatement.setDate(4, invDt);
			callableStatement.setInt(5, salemanId);
			callableStatement.execute();
			rs = callableStatement.getResultSet();
		
			ReflectionResultSetMapper<SaleManTourDetailsDTO> resultSetMapper = new ReflectionResultSetMapper<SaleManTourDetailsDTO>(
					SaleManTourDetailsDTO.class);
			while(rs.next()){
				SaleManTourDetailsDTO tour=new SaleManTourDetailsDTO();
				tour = resultSetMapper.mapRow(rs);
				list.add(tour);
				
			}

			//logger.info("sale  sale tour details fetched");

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("In DAOException", e);

		} finally {
			try {
				if(rs != null) rs.close();
				if(callableStatement != null) callableStatement.close();
				if(connection != null) connection.close(); 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(em != null) em.close();
		}

		return list;
	}
	
	@Override
	public ResponseObj getSaleManCheckinStatus(CommonResultSetMapper mapper) throws DAOException {
		
		EntityManager em = null;
		int status = 0;
		Connection connection = null;
		CallableStatement callableStatement = null;
		ResponseObj responseObj = new ResponseObj();
		try {
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();
			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();
			connection = sessionFactory.getConnectionProvider().getConnection();

			try {
				int cmpnyId=mapper.getCompanyId();
				int storeId=mapper.getStoreId();
				int finId = mapper.getFinYrId();
				String invDate = mapper.getInvDate();
				int salemanId  = mapper.getSalesmanId();
						
					
				java.sql.Date invDt = DateUtil.convertStringDateToSqlDate(
						invDate, "yyyy-MM-dd");
				callableStatement = connection
						.prepareCall(StoredProcedures.PROC_GET_SALE_MAN_CHECKIN_STATUS);
				callableStatement.setInt(1, cmpnyId);
				callableStatement.setInt(2, storeId);
				callableStatement.setInt(3, finId);
				callableStatement.setInt(4, salemanId);
				callableStatement.setDate(5, invDt);
				callableStatement.registerOutParameter(6,
						java.sql.Types.INTEGER);
				
				callableStatement.execute();
				status = callableStatement.getInt(6);
				
				if (status >0) {
					
					responseObj.setStatus("Checked In.");
					responseObj.setId(status);
					responseObj.setReason("Checked In.");
					
				} else {
					
					responseObj.setStatus("Not Checked In.");
					responseObj.setId(status);
					responseObj.setReason("Not Checked In.");
					
				}
				
			} catch (Exception e) {
				e.printStackTrace();
				responseObj.setStatus(ReturnConstant.FAILURE);
				responseObj.setId(0);
				responseObj.setReason("error getting check in status");
			}
			em.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("Check data to be posted", e);
		} finally {
			try {
				
				callableStatement.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			em.close();
		}
		return responseObj;

	}
	
	@Override
	public ResponseObj getSaleManCheckoutStatus(CommonResultSetMapper mapper) throws DAOException {
		
		EntityManager em = null;
		int status = 0;
		Connection connection = null;
		CallableStatement callableStatement = null;
		ResponseObj responseObj = new ResponseObj();
		try {
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();
			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();
			connection = sessionFactory.getConnectionProvider().getConnection();

			try {
				int cmpnyId=mapper.getCompanyId();
				int storeId=mapper.getStoreId();
				int finId = mapper.getFinYrId();
				String invDate = mapper.getInvDate();
				int salemanId  = mapper.getSalesmanId();
						
					
				java.sql.Date invDt = DateUtil.convertStringDateToSqlDate(
						invDate, "yyyy-MM-dd");
				callableStatement = connection
						.prepareCall(StoredProcedures.PROC_GET_SALE_MAN_CHECKOUT_STATUS);
				callableStatement.setInt(1, cmpnyId);
				callableStatement.setInt(2, storeId);
				callableStatement.setInt(3, finId);
				callableStatement.setInt(4, salemanId);
				callableStatement.setDate(5, invDt);
				callableStatement.registerOutParameter(6,
						java.sql.Types.INTEGER);
				
				callableStatement.execute();
				status = callableStatement.getInt(6);
				
				if (status >0) {
					
					responseObj.setStatus("Checked Out.");
					responseObj.setId(status);
					responseObj.setReason("Checked Out.");
					
				} else {
					
					responseObj.setStatus("Not Checked Out.");
					responseObj.setId(status);
					responseObj.setReason("Not Checked Out.");
					
				}
				
			} catch (Exception e) {
				e.printStackTrace();
				responseObj.setStatus(ReturnConstant.FAILURE);
				responseObj.setId(0);
				responseObj.setReason("error getting check out status");
			}
			em.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("Check data to be posted", e);
		} finally {
			try {
				
				callableStatement.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			em.close();
		}
		return responseObj;

	}
	
	
	@Override
	public ResponseObj createSaleManTourDetailOffline(SaleManTour salesmanTourList) throws DAOException {
		EntityManager em = null;
		int status = 0;
		Connection connection = null;
		CallableStatement callableStatement = null;
		ResponseObj responseObj=new ResponseObj();

		try {
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();
			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();
			connection = sessionFactory.getConnectionProvider().getConnection();

			try {
				StringWriter sw = new StringWriter();
				//File file = new File("D:\\2017-07-14\\file_purchase_order_creation.xml");
				JAXBContext jaxbContext = JAXBContext
						.newInstance(SaleManTour.class);
				Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

				jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,
						true);
				//jaxbMarshaller.marshal(purchaseOrder, file);
				// jaxbMarshaller.marshal(purchase, System.out);
				jaxbMarshaller.marshal(salesmanTourList, sw);
				String result = sw.toString();
				
				//System.out.println("salemantour offline xml = "+result);
				callableStatement = connection
						.prepareCall(StoredProcedures.PROC_CREATE_SALE_MAN_TOUR_OFFLINE);
				callableStatement.setString(1, result);
				callableStatement.setString(2, "saleManTour");
				callableStatement.setString(3, "saleManTourDetails");
				
				callableStatement.registerOutParameter(4,
						java.sql.Types.INTEGER);

				callableStatement.execute();
				
				status = callableStatement.getInt(4);
				if (status >0) {
					
					responseObj.setStatus(ReturnConstant.SUCCESS);
					responseObj.setId(status);
					responseObj.setReason("Record save successfully.");
					
				} else {
					
					responseObj.setStatus(ReturnConstant.FAILURE);
					responseObj.setId(status);
					responseObj.setReason("Record not saved successfully.");
					
				}

			} 
			
			catch (SQLException e) {
				e.printStackTrace();
				responseObj.setStatus(ReturnConstant.FAILURE);
				responseObj.setId(0);
				responseObj.setReason("Record not saved successfully.");
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			em.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("Check data to be inserted", e);
		} finally {
			try {
				
				if(callableStatement != null) callableStatement.close();
				if(connection != null) connection.close(); 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(em != null) em.close();
		}
		return responseObj;

	}
}
