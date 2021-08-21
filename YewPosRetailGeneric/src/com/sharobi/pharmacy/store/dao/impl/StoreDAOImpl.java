package com.sharobi.pharmacy.store.dao.impl;

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

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.internal.SessionFactoryImpl;

import com.sharobi.pharmacy.common.CommonResultSetMapper;
import com.sharobi.pharmacy.common.EmailBean;
import com.sharobi.pharmacy.common.PersistenceListener;
import com.sharobi.pharmacy.common.ReturnConstant;
import com.sharobi.pharmacy.common.WriteToExcelDTO;
import com.sharobi.pharmacy.common.model.ResponseObj;
import com.sharobi.pharmacy.commonutil.SendEmail;
import com.sharobi.pharmacy.commonutil.SendHtmlEmail;
import com.sharobi.pharmacy.commonutil.StoredProcedures;
import com.sharobi.pharmacy.exceptions.DAOException;
import com.sharobi.pharmacy.inventory.model.DistributorMaster;
import com.sharobi.pharmacy.procurement.dao.ProcurementDAO;
import com.sharobi.pharmacy.procurement.dao.impl.ProcurementDAOImpl;
import com.sharobi.pharmacy.procurement.model.PurchaseOrderDTO;
import com.sharobi.pharmacy.procurement.model.PurchaseOrderDetailsDTO;
import com.sharobi.pharmacy.store.dao.StoreDAO;
import com.sharobi.pharmacy.store.model.FinYrMaster;
import com.sharobi.pharmacy.store.model.PrintBill;
import com.sharobi.pharmacy.store.model.PrintBillDetails;
import com.sharobi.pharmacy.store.model.StoreMaster;

import net.sf.resultsetmapper.ReflectionResultSetMapper;

public class StoreDAOImpl implements StoreDAO {
	private final static Logger logger = LogManager
			.getLogger(StoreDAOImpl.class);

	private EntityManagerFactory entityManagerFactory;

	public StoreDAOImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public StoreMaster getStoreDetails(String storeId) throws DAOException {

		StoreMaster storeMaster = null;
		EntityManager em = null;

		try {
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();
			
			int storeid = Integer.parseInt(storeId);
			Query qrygetstore = em
					.createQuery("SELECT s FROM StoreMaster s WHERE s.id=:storeid and s.isDeleted=0");

			qrygetstore.setParameter("storeid", storeid);
			storeMaster = (StoreMaster) qrygetstore.getSingleResult();
			//logger.info("Store fetched");

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("In DAOException", e);

		} finally {
			if(em != null) em.close();
		}

		return storeMaster;
	}
	
	public FinYrMaster getFinYrDetailsById(String id) throws DAOException {

		FinYrMaster finYrMaster = null;
		EntityManager em = null;

		try {
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();
			
			int id1 = Integer.parseInt(id);
			Query qrygetstore = em
					.createQuery("SELECT s FROM FinYrMaster s WHERE s.id=:id1 and s.isDeleted=0");

			qrygetstore.setParameter("id1", id1);
			finYrMaster = (FinYrMaster) qrygetstore.getSingleResult();
			
			//logger.info("fin year fetched");

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("In DAOException", e);

		} finally {
			if(em != null) em.close();
		}

		return finYrMaster;
	}
	
	@Override
	public List<FinYrMaster> getFinYrList(CommonResultSetMapper comm) throws DAOException {

		List<FinYrMaster> finYrMasters = null;
		EntityManager em = null;

		try {
			entityManagerFactory = PersistenceListener.getEntityManager();;
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();
			TypedQuery<FinYrMaster> qrygetstore = em
					.createQuery("SELECT s FROM FinYrMaster s WHERE s.storeId=:storeId and s.isDeleted=0", FinYrMaster.class);
			qrygetstore.setParameter("storeId", comm.getStoreId());
			finYrMasters = qrygetstore.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("In DAOException", e);
		} finally {
			if(em != null) em.close();
		}
		return finYrMasters;
	}
	
	@Override
	public ResponseObj sendEmail(EmailBean emailBean) throws DAOException {

		StoreMaster storeMaster = null;
		EntityManager em = null;
		ResponseObj responseObj=new ResponseObj();
		String name="";
		String address="";
		String distAddr="";
		int distId=0;
		int poId=0;
		String mailPwd="";
		String mailPort="";
		String mailSmtp="";
		String phone="";
		String distPhone="";
		String distPincode="";
		String distCity="";
		ProcurementDAO dao=new ProcurementDAOImpl();
		PurchaseOrderDTO poDto=new PurchaseOrderDTO();
		DistributorMaster distributorMaster=new DistributorMaster();
		

		try {
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();
			
			int storeid = emailBean.getStoreId();
			Query qrygetstore = em
					.createQuery("SELECT s FROM StoreMaster s WHERE s.id=:storeid and s.isDeleted=0");

			qrygetstore.setParameter("storeid", storeid);
			storeMaster = (StoreMaster) qrygetstore.getSingleResult();
			name=storeMaster.getName();
			address=storeMaster.getAddress();
			mailPort=storeMaster.getMailPort();
			mailPwd=storeMaster.getMailPassword();
			mailSmtp=storeMaster.getMailSmtp();
			phone=storeMaster.getPhone();
			poId=emailBean.getTransId();
			CommonResultSetMapper mapper=new CommonResultSetMapper();
			mapper.setPurchaseOrderId(poId);
			poDto=dao.getPurchaseOrderHeaderById(mapper);
			distId=poDto.getDistributorId();
			Query qry = em
					.createQuery("SELECT d FROM DistributorMaster d WHERE d.id=:id and d.isDeleted=0");

			qry.setParameter("id", distId);
			distributorMaster = (DistributorMaster) qry.getSingleResult();
			distAddr=distributorMaster.getAddress();
			distPhone=distributorMaster.getPhoneNo1();
			distPincode=distributorMaster.getPin();
			distCity=distributorMaster.getCity();
			String retailerAddr="ADD:"+address+","+"Ph:"+phone;
			String disAdd="TO:"+distributorMaster.getName()+","+distAddr+","+distCity+"-"+distPincode+","+"PH:"+distPhone;
			String invDetls="Invoice No.:"+poDto.getInvNo()+","+"Invoice Dt.:"+poDto.getInvDate()+","+"Due Dt.:"+poDto.getDueDate();
			List<String> header=new ArrayList<String>();
			header.add("SL");
			header.add("ITEM NAME");
			header.add("CONVERSION");
			header.add("MFG");
			header.add("MRP");
			header.add("RATE");
			header.add("QTY");
			header.add("DIS%");
			header.add("TAX%");
			header.add("AMT");
			List<PurchaseOrderDetailsDTO> detailsDTOs=dao.getPurchaseOrderDetailsById(mapper);
			//create excel
			WriteToExcelDTO excelDTO=new WriteToExcelDTO();
			excelDTO.setFirstData(name);
			excelDTO.setSecondData(retailerAddr);
			excelDTO.setThirdData(disAdd);
			excelDTO.setFourthData(invDetls);
			excelDTO.setHeaderList(header);
			excelDTO.setValueList(detailsDTOs);
			excelDTO.writeToExcel();
			
			//send email
			emailBean.setFromAddr(storeMaster.getEmail());
			emailBean.setMailPort(mailPort);
			emailBean.setMailPwd(mailPwd);
			emailBean.setMailSmtp(mailSmtp);
			//emailBean.setAttchmntData(attchmentData);
			
			SendEmail email=new SendEmail();
			int status=email.sendEmail(emailBean);
			
			if (status >0) {
				
				responseObj.setStatus(ReturnConstant.SUCCESS);
				responseObj.setId(status);
				responseObj.setReason("Email sent successfully");
				
			} else {
				
				responseObj.setStatus(ReturnConstant.FAILURE);
				responseObj.setId(status);
				responseObj.setReason("Email not sent successfully");
				
			}
			

		} catch (Exception e) {
			e.printStackTrace();
			responseObj.setStatus(ReturnConstant.FAILURE);
			responseObj.setId(0);
			responseObj.setReason("Email not sent successfully.");
			throw new DAOException("In DAOException", e);

		} finally {
			if(em != null) em.close();
		}

		return responseObj;
	}

	@Override
	public ResponseObj sendHtmlEmail(EmailBean emailBean) throws DAOException {

		StoreMaster storeMaster = null;
		EntityManager em = null;
		ResponseObj responseObj=new ResponseObj();
		String name="";
		String address="";
		String mailPwd="";
		String mailPort="";
		String mailSmtp="";

		try {
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();
			
			int storeid = emailBean.getStoreId();
			Query qrygetstore = em
					.createQuery("SELECT s FROM StoreMaster s WHERE s.id=:storeid and s.isDeleted=0");

			qrygetstore.setParameter("storeid", storeid);
			storeMaster = (StoreMaster) qrygetstore.getSingleResult();
			name=storeMaster.getName();
			address=storeMaster.getAddress();
			mailPort=storeMaster.getMailPort();
			mailPwd=storeMaster.getMailPassword();
			mailSmtp=storeMaster.getMailSmtp();
			
			//send email
			emailBean.setFromAddr(storeMaster.getEmail());
			emailBean.setMailPort(mailPort);
			emailBean.setMailPwd(mailPwd);
			emailBean.setMailSmtp(mailSmtp);
			//emailBean.setAttchmntData(attchmentData);
			
			SendHtmlEmail email=new SendHtmlEmail();
			int status=email.sendEmail(emailBean);
			
			if (status >0) {
				
				responseObj.setStatus(ReturnConstant.SUCCESS);
				responseObj.setId(status);
				responseObj.setReason("Email sent successfully");
				
			} else {
				
				responseObj.setStatus(ReturnConstant.FAILURE);
				responseObj.setId(status);
				responseObj.setReason("Email not sent successfully");
				
			}
			

		} catch (Exception e) {
			e.printStackTrace();
			responseObj.setStatus(ReturnConstant.FAILURE);
			responseObj.setId(0);
			responseObj.setReason("Email not sent successfully.");
			throw new DAOException("In DAOException", e);

		} finally {
			if(em != null) em.close();
		}

		return responseObj;
	}
	
	@Override
	public List<CommonResultSetMapper> getInvoicePrefixbyQS(
			CommonResultSetMapper mapper) throws DAOException {
		EntityManager em = null;
		CallableStatement callableStatement = null;
		Connection connection = null;
		ResultSet rs = null;
		List<CommonResultSetMapper> commonResultSetMappers=new ArrayList<CommonResultSetMapper>();
		
		

		try {
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();

			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();
			connection = sessionFactory.getConnectionProvider().getConnection();

			callableStatement = connection
					.prepareCall(StoredProcedures.PROC_GET_INVOICEPREFIX_BYQS);
			callableStatement.setInt(1, mapper.getCompanyId());
			callableStatement.setInt(2, mapper.getStoreId());
			callableStatement.setInt(3, mapper.getFinYrId());
			callableStatement.setString(4, mapper.getQs());
			callableStatement.execute();
			rs = callableStatement.getResultSet();

			/*ReflectionResultSetMapper<CommonResultSetMapper> resultSetMapper1 = new ReflectionResultSetMapper<CommonResultSetMapper>(
					CommonResultSetMapper.class);*/

			while (rs.next()) {
				CommonResultSetMapper mapperret=new CommonResultSetMapper();
				mapperret.setId(rs.getInt(1));
				mapperret.setMulSeriesPrefix(rs.getString(2));
				mapperret.setQs(rs.getString(3));
				mapperret.setIsDefault(rs.getInt(4));
				commonResultSetMappers.add(mapperret);
			}

			//logger.info("getControlAccessItemWise fetched");

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

		return commonResultSetMappers;
	}

		
	@Override
	public String updateInvoicePrefixbyQS(CommonResultSetMapper mapper)
			throws DAOException {
		EntityManager em = null;
		String status = "";
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
				/*StringWriter sw = new StringWriter();
				//File file = new File("D:\\2017-10-04\\file_purchase_invoice_creation.xml");
				JAXBContext jaxbContext = JAXBContext
						.newInstance(Purchase.class);
				Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

				jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,
						true);
				//jaxbMarshaller.marshal(purchase, file);
				// jaxbMarshaller.marshal(purchase, System.out);
				jaxbMarshaller.marshal(mapper, sw);
				String result = sw.toString();*/
				// System.out.println("output string:: "+result);
				callableStatement = connection
						.prepareCall(StoredProcedures.PROC_UPDATE_INVOICEPREFIX_BYQS);
				callableStatement.setInt(1, mapper.getCompanyId());
				callableStatement.setInt(2, mapper.getStoreId());
				callableStatement.setInt(3, mapper.getFinYrId());
				callableStatement.setString(4, mapper.getQs());
				callableStatement.setString(5, mapper.getMulSeriesPrefix());
				/*callableStatement.registerOutParameter(4,
						java.sql.Types.VARCHAR);*/
				callableStatement.registerOutParameter(6,
						java.sql.Types.VARCHAR);

				callableStatement.execute();
				//invNo = callableStatement.getString(4);
				status = callableStatement.getString(6);
				//System.out.println("status:: "+status);
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
		return status;

	}
	
	@Override
	public PrintBill getPrintBillSetup(CommonResultSetMapper mapper) throws DAOException {
		EntityManager em = null;
		CallableStatement callableStatement = null;
		Connection connection = null;
		ResultSet rs = null;
		PrintBill pb=new PrintBill();
		try {
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();

			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();
			connection = sessionFactory.getConnectionProvider().getConnection();

			callableStatement = connection
					.prepareCall(StoredProcedures.PROC_GET_BILL_PRINT);
			callableStatement.setInt(1, mapper.getCompanyId());
			callableStatement.setInt(2, mapper.getStoreId());
			callableStatement.execute();
			rs = callableStatement.getResultSet();

			ReflectionResultSetMapper<PrintBill> resultSetMapper1 = new ReflectionResultSetMapper<PrintBill>(
					PrintBill.class);

			while (rs.next()) {
				pb=resultSetMapper1.mapRow(rs);
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

		return pb;
	}
	
	@Override
	public List<PrintBillDetails> getPrintBillSetupDetails(CommonResultSetMapper mapper) throws DAOException {
		EntityManager em = null;
		CallableStatement callableStatement = null;
		Connection connection = null;
		ResultSet rs = null;
		List<PrintBillDetails> pbs=new ArrayList<PrintBillDetails>();
		try {
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();

			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();
			connection = sessionFactory.getConnectionProvider().getConnection();

			callableStatement = connection
					.prepareCall(StoredProcedures.PROC_GET_BILL_PRINT_DETAILS);
			callableStatement.setInt(1, mapper.getCompanyId());
			callableStatement.setInt(2, mapper.getStoreId());
			callableStatement.execute();
			rs = callableStatement.getResultSet();

			ReflectionResultSetMapper<PrintBillDetails> resultSetMapper1 = new ReflectionResultSetMapper<PrintBillDetails>(
					PrintBillDetails.class);

			while (rs.next()) {
				PrintBillDetails pb=new PrintBillDetails();
				pb=resultSetMapper1.mapRow(rs);
				pbs.add(pb);
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

		return pbs;
	}
	
}

/**
 * rajarshi
 */
