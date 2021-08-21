package com.sharobi.pharmacy.inventory.dao.impl;

import java.io.InputStream;
import java.io.StringWriter;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.internal.SessionFactoryImpl;
import org.hibernate.transform.Transformers;

import com.sharobi.pharmacy.accounts.model.ChartOfAccountDTO;
import com.sharobi.pharmacy.accounts.model.JournalDTO;
import com.sharobi.pharmacy.accounts.model.JournalListDTO;
import com.sharobi.pharmacy.accounts.model.ParaJournalTypeMaster;
import com.sharobi.pharmacy.common.CommonResultSetMapper;
import com.sharobi.pharmacy.common.PersistenceListener;
import com.sharobi.pharmacy.common.ReturnConstant;
import com.sharobi.pharmacy.common.model.GenderMaster;
import com.sharobi.pharmacy.common.model.ResponseObj;
import com.sharobi.pharmacy.common.model.ReturnReasonTypeDTO;
import com.sharobi.pharmacy.commonutil.DateUtil;
import com.sharobi.pharmacy.commonutil.StoredProcedures;
import com.sharobi.pharmacy.commonutil.Util;
import com.sharobi.pharmacy.commonutil.XlsToXml;
import com.sharobi.pharmacy.exceptions.DAOException;
import com.sharobi.pharmacy.exceptions.SearchCriteraException;
import com.sharobi.pharmacy.inventory.dao.InventoryDAO;
import com.sharobi.pharmacy.inventory.model.AccountDTO;
import com.sharobi.pharmacy.inventory.model.AccountGroupDTO;
import com.sharobi.pharmacy.inventory.model.AccountMaster;
import com.sharobi.pharmacy.inventory.model.AccountTypeDTO;
import com.sharobi.pharmacy.inventory.model.AreaDTO;
import com.sharobi.pharmacy.inventory.model.BrandDTO;
import com.sharobi.pharmacy.inventory.model.BrandMaster;
import com.sharobi.pharmacy.inventory.model.CategoryMaster;
import com.sharobi.pharmacy.inventory.model.ChargeDTO;
import com.sharobi.pharmacy.inventory.model.ChargeMaster;
import com.sharobi.pharmacy.inventory.model.CityDTO;
import com.sharobi.pharmacy.inventory.model.ContentMaster;
import com.sharobi.pharmacy.inventory.model.ControlAccessItemWiseDTO;
import com.sharobi.pharmacy.inventory.model.CountryMaster;
import com.sharobi.pharmacy.inventory.model.CustomerDTO;
import com.sharobi.pharmacy.inventory.model.CustomerMaster;
import com.sharobi.pharmacy.inventory.model.DistributorDTO;
import com.sharobi.pharmacy.inventory.model.DistributorMaster;
import com.sharobi.pharmacy.inventory.model.DoctorMaster;
import com.sharobi.pharmacy.inventory.model.Expiry;
import com.sharobi.pharmacy.inventory.model.ExpiryDTO;
import com.sharobi.pharmacy.inventory.model.ExpiryDetailsDTO;
import com.sharobi.pharmacy.inventory.model.GroupMaster;
import com.sharobi.pharmacy.inventory.model.ItemDTO;
import com.sharobi.pharmacy.inventory.model.ItemHistoryDTO;
import com.sharobi.pharmacy.inventory.model.ItemMaster;
import com.sharobi.pharmacy.inventory.model.ItemRackMapper;
import com.sharobi.pharmacy.inventory.model.ItemSearchByContentDTO;
import com.sharobi.pharmacy.inventory.model.ItemWithSameContentDTO;
import com.sharobi.pharmacy.inventory.model.LocationDTO;
import com.sharobi.pharmacy.inventory.model.ManufacturerMaster;
import com.sharobi.pharmacy.inventory.model.OpeningStock;
import com.sharobi.pharmacy.inventory.model.RackMaster;
import com.sharobi.pharmacy.inventory.model.RetailTypeControlDTO;
import com.sharobi.pharmacy.inventory.model.RetailTypeDTO;
import com.sharobi.pharmacy.inventory.model.SalesmanDTO;
import com.sharobi.pharmacy.inventory.model.SalesmanMaster;
import com.sharobi.pharmacy.inventory.model.ScheduleMaster;
import com.sharobi.pharmacy.inventory.model.SerialStockStatusDTO;
import com.sharobi.pharmacy.inventory.model.StateDTO;
import com.sharobi.pharmacy.inventory.model.StockDetailsAdjustmentDTO;
import com.sharobi.pharmacy.inventory.model.StockTransfer;
import com.sharobi.pharmacy.inventory.model.StockTransferDTO;
import com.sharobi.pharmacy.inventory.model.StockTransferDetails;
import com.sharobi.pharmacy.inventory.model.StockTransferDetailsDTO;
import com.sharobi.pharmacy.inventory.model.SubCategoryMaster;
import com.sharobi.pharmacy.inventory.model.SubcatByCatDTO;
import com.sharobi.pharmacy.inventory.model.TaxDTO;
import com.sharobi.pharmacy.inventory.model.TaxTypeDTO;
import com.sharobi.pharmacy.inventory.model.UnitMaster;
import com.sharobi.pharmacy.inventory.model.VariantDTO;
import com.sharobi.pharmacy.inventory.model.VariantMaster;
import com.sharobi.pharmacy.inventory.model.VariantTypeDTO;
import com.sharobi.pharmacy.inventory.model.ZoneDTO;
import com.sharobi.pharmacy.procurement.model.ItemCurrentStockDTO;
import com.sharobi.pharmacy.procurement.model.TaxGrpDetailsMaster;
import com.sharobi.pharmacy.procurement.model.TaxMaster;
import com.sharobi.pharmacy.sales.model.MarketerMaster;

import net.sf.resultsetmapper.ReflectionResultSetMapper;

/**
 * rajarshi
 */
public class InventoryDAOImpl implements InventoryDAO {

	private final static Logger logger = LogManager
			.getLogger(InventoryDAOImpl.class);

	private EntityManagerFactory entityManagerFactory;

	public InventoryDAOImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String addBrand(BrandMaster brand) throws DAOException {
		EntityManager em = null;
		String status = "";
		BrandMaster brand1=null;
		try {

			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();
			String name=brand.getName();
			try {
				Query qry = em
						.createQuery("SELECT b FROM BrandMaster b WHERE b.name=:name and b.isDeleted=0");

				qry.setParameter("name", name);
				brand1 = (BrandMaster) qry.getSingleResult();
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(brand1==null){
			Date currentDate = DateUtil
					.convertCurrentDateToFormattedDate("yyyy-MM-dd");
			brand.setCreatedDate(currentDate);
			em.persist(brand);

			em.getTransaction().commit();
			status = ReturnConstant.SUCCESS;
			//logger.info("Brand created successfully");
			}
			else {
				status = ReturnConstant.FAILURE;
			}
		} catch (Exception e) {
			e.printStackTrace();
			status = ReturnConstant.FAILURE;
			throw new DAOException("Check data to be inserted", e);
		} finally {
			if(em != null) em.close();
		}
		return status;
	}

	@Override
	public String addDistributor(DistributorMaster dist) throws DAOException {
		EntityManager em = null;
		String status = "";
		try {

			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();
			Date currentDate = DateUtil
					.convertCurrentDateToFormattedDate("yyyy-MM-dd");
			dist.setCreatedDate(currentDate);
			em.persist(dist);

			em.getTransaction().commit();
			//status = ReturnConstant.SUCCESS;
			status=""+dist.getId();
			//logger.info("Distributor created successfully");
		} catch (Exception e) {
			e.printStackTrace();
			//status = ReturnConstant.FAILURE;
			status=""+0;
			throw new DAOException("Check data to be inserted", e);
		} finally {
			if(em != null) em.close();
		}
		return status;
	}

	@Override
	public ResponseObj addItem(ItemMaster item) throws DAOException {
		EntityManager em = null;
		Connection connection = null;
		CallableStatement callableStatement = null;
		int result = 0;
		ResponseObj responseObj=new ResponseObj();	
		ItemMaster itemMaster=new ItemMaster();
		try {

			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();
			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();
			connection = sessionFactory.getConnectionProvider().getConnection();

			Date currentDate = DateUtil
					.convertCurrentDateToFormattedDate("yyyy-MM-dd");
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			String crntDate = df.format(currentDate);
			java.sql.Date crntDate1 = DateUtil.convertStringDateToSqlDate(
					crntDate, "yyyy-MM-dd");
			String LaunchDate = df.format(item.getLaunchDate());
			java.sql.Date LaunchDate1 = DateUtil.convertStringDateToSqlDate(
					LaunchDate, "yyyy-MM-dd");
			
			String DiscontinueDate = df.format(item.getDiscontinueDate());
			java.sql.Date DiscontinueDate1 = DateUtil.convertStringDateToSqlDate(
					DiscontinueDate, "yyyy-MM-dd");
			String name = item.getName();
			String code = item.getCode();
			int grpId = item.getGroupId();
			int catid = item.getCategoryId();
			int subCatId = item.getSubCategoryId();
			int schdId = item.getScheduleId();
			int contntId = item.getContentId();
			int brandId = item.getBrandId();
			int manuId = item.getManufacturerId();
			Date entryDate = item.getEntryDate();
			double vat = item.getVat();
			int isMrp = item.getIsOnMrp();
			int packUnitId = item.getPackUnitId();
			int conv = item.getConversion();
			String storage = item.getStorage();
			String care = item.getCare();
			int reOrderLevel = item.getReorderLevel();
			int reOrderLevelunit = item.getReorderLevelUnitId();
			int taxable = item.getIsTaxable();
			int rackId = item.getRackId();
			String note = item.getNote();
			int cmpnyId = item.getCompanyId(); // set company id 0
			// store id set 0
			int createdBy = item.getCreatedBy();
			double prce = item.getPrice();
			double markup = item.getMarkup();
			String strength = item.getStrength();
			int looseuntId = item.getLooseUnitId();
			String netContnt = item.getNetContent();

			callableStatement = connection
					.prepareCall(StoredProcedures.PROC_CREATE_ITEM);
			callableStatement.setString(1, name);
			callableStatement.setString(2, code);
			callableStatement.setString(3, item.getHsnCode());
			callableStatement.setString(4, item.getSku());
			callableStatement.setInt(5, grpId);
			callableStatement.setInt(6, catid);
			callableStatement.setInt(7, subCatId);
			callableStatement.setInt(8, schdId);
			callableStatement.setInt(9, contntId);
			callableStatement.setInt(10, brandId);
			callableStatement.setInt(11, manuId);
			callableStatement.setInt(12, item.getMarketerId());
			callableStatement.setDate(13, crntDate1);
			callableStatement.setDouble(14, vat);
			callableStatement.setInt(15, isMrp);
			//callableStatement.setInt(16, item.getTaxTypeId());
			
			callableStatement.setInt(16, item.getPurchaseTaxId());
			callableStatement.setDouble(17, item.getPurchaseTaxPercentage());
			callableStatement.setInt(18, item.getSaleTaxId());
			callableStatement.setDouble(19, item.getSaleTaxPercentage());
			callableStatement.setInt(20, packUnitId);
			callableStatement.setInt(21, conv);
			callableStatement.setInt(22, item.getIsLooseSale());
			
			callableStatement.setInt(23, looseuntId);
			
			callableStatement.setString(24, storage);
			callableStatement.setString(25, care);
			callableStatement.setInt(26, reOrderLevel);
			callableStatement.setInt(27, item.getReorderLevelQty());
			callableStatement.setInt(28, reOrderLevelunit);
			callableStatement.setDouble(29, prce);
			callableStatement.setInt(30, taxable);
			callableStatement.setDouble(31, markup);
			callableStatement.setInt(32, item.getIsDiscount());
			callableStatement.setDouble(33, item.getDiscount());
			callableStatement.setString(34, strength);
			callableStatement.setString(35, netContnt);
			callableStatement.setString(36, note);
			callableStatement.setString(37, item.getDescription());
			callableStatement.setString(38, item.getPrintName());
			callableStatement.setString(39, item.getImgUrl());
			callableStatement.setInt(40, item.getMaxLevel());
			callableStatement.setInt(41, item.getMinLevel());
			callableStatement.setInt(42, item.getIsActive());
			callableStatement.setString(43, item.getColour());
			callableStatement.setString(44, item.getSizeType());
			callableStatement.setString(45, item.getSize());
			callableStatement.setString(46, item.getWeight());
			callableStatement.setString(47, item.getPartNumber());
			callableStatement.setString(48, item.getAuthorName());
			callableStatement.setString(49, item.getEdition());
			callableStatement.setDouble(50, item.getMrp());
			callableStatement.setDouble(51, item.getPurchaseRate());
			callableStatement.setDouble(52, item.getListedMrp());
			callableStatement.setDouble(53, item.getWsp());
			callableStatement.setInt(54, item.getStockRequired());
			callableStatement.setInt(55, item.getBatchWiseStock());
			callableStatement.setInt(56, item.getExpiryDateRequired());
			callableStatement.setInt(57, item.getDualStockRequired());
			callableStatement.setString(58, item.getSaleRateOn());
			callableStatement.setInt(59, item.getLocationRequired());
			callableStatement.setInt(60, item.getPriceListRequired());
			callableStatement.setInt(61, item.getSizeWiseStockRequired());
			callableStatement.setInt(62, item.getWarrantyRequired());
			callableStatement.setString(63, item.getWarrantyTypeOn());
			callableStatement.setInt(64, item.getWarrantyMonth());
			callableStatement.setInt(65, item.getMrpRequired());
			callableStatement.setInt(66, item.getSerialNoRequired());
			callableStatement.setInt(67, item.getSerialNoSuffRequired());
			callableStatement.setInt(68, item.getSerialNoPrefRequired());
			callableStatement.setString(69, item.getSerialNoType());
			
			callableStatement.setDouble(70, item.getMaxDiscountLimit());
			callableStatement.setDouble(71, item.getTaxTypeId());
			callableStatement.setDouble(72, item.getMaximumQty());
			callableStatement.setDate(73,LaunchDate1);
			callableStatement.setDate(74,DiscontinueDate1);
			callableStatement.setDouble(75,item.getSaleRate());
			callableStatement.setInt(76,item.getRetailTypeId());
			
			callableStatement.setInt(77, rackId); 
			callableStatement.setInt(78, item.getExpiryMonthRequired()); 
			callableStatement.setInt(79, item.getColourWiseStockRequired()); 
			
			callableStatement.setInt(80, cmpnyId);
			callableStatement.setInt(81, 0);
			callableStatement.setInt(82, createdBy);

			callableStatement.registerOutParameter(83, java.sql.Types.INTEGER);

			callableStatement.execute();
			result = callableStatement.getInt(83);
			if(result>0){
				
				TaxMaster purTaxMaster=new TaxMaster();
				TaxMaster saleTaxMaster=new TaxMaster();
				responseObj.setStatus(ReturnConstant.SUCCESS);
				responseObj.setId(result);
				//fetch purchase tax and sale tax
				try {
					int purTaxId=item.getPurchaseTaxId();
					Query qry = em
							.createQuery("SELECT t FROM TaxMaster t WHERE t.id=:id and t.isDeleted=0");

					qry.setParameter("id", purTaxId);
					purTaxMaster= (TaxMaster) qry.getSingleResult();
					
					//get tax grp details
					int isGrp=purTaxMaster.getIsGroup();
					if(isGrp>0){
						
						List<TaxMaster> taxList = new ArrayList<TaxMaster>();
						Query qry2 = em
								.createQuery("SELECT t from TaxMaster t where t.id in (select g.taxId from TaxGrpDetailsMaster g,TaxMaster t1 where t1.id=g.parentId and t1.isDeleted=0)");
						
						taxList = (List<TaxMaster>) qry2.getResultList();
						List<TaxGrpDetailsMaster> grpList=new ArrayList<TaxGrpDetailsMaster>();
						Iterator<TaxMaster> iterator=taxList.iterator();
						while (iterator.hasNext()) {
							TaxMaster taxMaster = (TaxMaster) iterator.next();
							TaxGrpDetailsMaster detailsMaster=new TaxGrpDetailsMaster();
							detailsMaster.setDescription(taxMaster.getDescription());
							detailsMaster.setTaxId(taxMaster.getId());
							detailsMaster.setParentId(purTaxId);
							detailsMaster.setPercentage(taxMaster.getPercentage());
							detailsMaster.setTaxMode(taxMaster.getTaxMode());
							detailsMaster.setTaxName(taxMaster.getName());
							grpList.add(detailsMaster);
							
						}
						purTaxMaster.setTaxGrpDetailsMasters(grpList);
						
					}
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				item.setPurchaseTax(purTaxMaster);
				
				try {
					int saleTaxId=item.getSaleTaxId();
					Query qry1 = em
							.createQuery("SELECT t FROM TaxMaster t WHERE t.id=:id and t.isDeleted=0");

					qry1.setParameter("id", saleTaxId);
					saleTaxMaster= (TaxMaster) qry1.getSingleResult();
					
					//get tax grp details
					int isGrp=saleTaxMaster.getIsGroup();
					if(isGrp>0){
						
						List<TaxMaster> taxList = new ArrayList<TaxMaster>();
						Query qry2 = em
								.createQuery("SELECT t from TaxMaster t where t.id in (select g.taxId from TaxGrpDetailsMaster g,TaxMaster t1 where t1.id=g.parentId and t1.isDeleted=0)");
						
						taxList = (List<TaxMaster>) qry2.getResultList();
						List<TaxGrpDetailsMaster> grpList=new ArrayList<TaxGrpDetailsMaster>();
						Iterator<TaxMaster> iterator=taxList.iterator();
						while (iterator.hasNext()) {
							TaxMaster taxMaster = (TaxMaster) iterator.next();
							TaxGrpDetailsMaster detailsMaster=new TaxGrpDetailsMaster();
							detailsMaster.setDescription(taxMaster.getDescription());
							detailsMaster.setTaxId(taxMaster.getId());
							detailsMaster.setParentId(saleTaxId);
							detailsMaster.setPercentage(taxMaster.getPercentage());
							detailsMaster.setTaxMode(taxMaster.getTaxMode());
							detailsMaster.setTaxName(taxMaster.getName());
							grpList.add(detailsMaster);
							
						}
						saleTaxMaster.setTaxGrpDetailsMasters(grpList);
						
					}
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				item.setSaleTax(saleTaxMaster);
				//get group
				GroupMaster grp =new GroupMaster();
				try {
					
					Query qryg = em
							.createQuery("SELECT g FROM GroupMaster g WHERE g.id=:id and g.isDeleted=0");
					qryg.setParameter("id", grpId);
					grp=(GroupMaster) qryg.getSingleResult();
				} 
				catch (NoResultException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				item.setGroupMaster(grp);
				//get schedule
				ScheduleMaster sch =new ScheduleMaster();
				try {
					
					Query qrys = em
							.createQuery("SELECT s FROM ScheduleMaster s WHERE s.id=:id and s.isDeleted=0");
					qrys.setParameter("id", schdId);
					sch=(ScheduleMaster) qrys.getSingleResult();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				item.setScheduleMaster(sch);
				
				//get manufacturer
				ManufacturerMaster manu =new ManufacturerMaster();
				try {
					
					Query qrym = em
							.createQuery("SELECT m FROM ManufacturerMaster m WHERE m.id=:id and m.isDeleted=0");
					qrym.setParameter("id", manuId);
					manu=(ManufacturerMaster) qrym.getSingleResult();
				}
				
				catch (NoResultException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				item.setManufacturerMaster(manu);
				
				item.setId(result);
				responseObj.setItem(item);
				responseObj.setReason("Record save successfully.");
				em.getTransaction().commit();
			} else {
				
				responseObj.setStatus(ReturnConstant.FAILURE);
				responseObj.setId(result);
				responseObj.setItem(itemMaster);
				responseObj.setReason("Record not saved successfully.");
				logger.info("Item can't be updated.");
			}

		} catch (Exception e) {
			e.printStackTrace();
			responseObj.setStatus(ReturnConstant.FAILURE);
			responseObj.setId(0);
			responseObj.setItem(itemMaster);
			responseObj.setReason("Record not saved successfully.");
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
	public ResponseObj addSchedule(ScheduleMaster schedule) throws DAOException {
		EntityManager em = null;
		//String status = "";
		ScheduleMaster schedule1=null;
		ResponseObj responseObj=new ResponseObj();
		int result=0;
		try {

			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();
			String name=schedule.getName();
			try {
				Query qry = em
						.createQuery("SELECT b FROM ScheduleMaster b WHERE b.name=:name and b.isDeleted=0");

				qry.setParameter("name", name);
				schedule1 = (ScheduleMaster) qry.getSingleResult();
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(schedule1==null){
			Date currentDate = DateUtil
					.convertCurrentDateToFormattedDate("yyyy-MM-dd");
			schedule.setCreatedDate(currentDate);
			em.persist(schedule);

			em.getTransaction().commit();
			//status = ReturnConstant.SUCCESS;
			result=schedule.getId();
			if (result >0) {
				
				responseObj.setStatus(ReturnConstant.SUCCESS);
				responseObj.setId(result);
				responseObj.setReason("Schedule created successfully");
				
			} else {
				
				responseObj.setStatus(ReturnConstant.FAILURE);
				responseObj.setId(result);
				responseObj.setReason("Schedule not added successfully.");
				
			}
			//logger.info("Schedule created successfully");
			}
			else {
				responseObj.setStatus(ReturnConstant.FAILURE);
				responseObj.setId(result);
				responseObj.setReason("Schedule not added successfully.");
			}
		} catch (Exception e) {
			e.printStackTrace();
			responseObj.setStatus(ReturnConstant.FAILURE);
			responseObj.setId(0);
			responseObj.setReason("Schedule not added successfully.");
			throw new DAOException("Check data to be added", e);
		} finally {
			if(em != null) em.close();
		}
		return responseObj;
	}

	@Override
	public ResponseObj addGroup(GroupMaster groupMaster) throws DAOException {
		EntityManager em = null;
		//String status = "";
		GroupMaster groupMaster1=null;
		ResponseObj responseObj=new ResponseObj();
		int result=0;
		try {

			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();
			String name=groupMaster.getName();
			try {
				Query qry = em
						.createQuery("SELECT b FROM GroupMaster b WHERE b.name=:name and b.companyId=:companyId and b.isDeleted=0");

				qry.setParameter("companyId", groupMaster.getCompanyId());
				qry.setParameter("name", name);
				groupMaster1 = (GroupMaster) qry.getSingleResult();
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(groupMaster1==null){
			Date currentDate = DateUtil
					.convertCurrentDateToFormattedDate("yyyy-MM-dd");
			groupMaster.setCreatedDate(currentDate);
			em.persist(groupMaster);

			em.getTransaction().commit();
			//status = ReturnConstant.SUCCESS;
			result=groupMaster.getId();
			if (result >0) {
				
				responseObj.setStatus(ReturnConstant.SUCCESS);
				responseObj.setId(result);
				responseObj.setReason("group added successfully.");
				
			} else {
				
				responseObj.setStatus(ReturnConstant.FAILURE);
				responseObj.setId(result);
				responseObj.setReason("group not added successfully.");
				
			}
			//logger.info("Group created successfully");
			}
			else {
				responseObj.setStatus(ReturnConstant.FAILURE);
				responseObj.setId(result);
				responseObj.setReason("group not added successfully.");
			}
		} catch (Exception e) {
			e.printStackTrace();
			responseObj.setStatus(ReturnConstant.FAILURE);
			responseObj.setId(0);
			responseObj.setReason("group not added successfully.");
			throw new DAOException("Check data to be added", e);
		} finally {
			if(em != null) em.close();
		}
		return responseObj;
	}

	@Override
	public String addRack(RackMaster rackMaster) throws DAOException {
		EntityManager em = null;
		String status = "";
		RackMaster rackMaster1=null;
		try {

			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();
			String name=rackMaster.getName();
			try {
				Query qry = em
						.createQuery("SELECT b FROM RackMaster b WHERE b.name=:name and b.isDeleted=0");

				qry.setParameter("name", name);
				rackMaster1 = (RackMaster) qry.getSingleResult();
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(rackMaster1==null){
			Date currentDate = DateUtil
					.convertCurrentDateToFormattedDate("yyyy-MM-dd");
			rackMaster.setCreatedDate(currentDate);
			em.persist(rackMaster);

			em.getTransaction().commit();
			status = ReturnConstant.SUCCESS;
			//logger.info("Rack created successfully");
			}
			else {
				status = ReturnConstant.FAILURE;
			}
		} catch (Exception e) {
			e.printStackTrace();
			status = ReturnConstant.FAILURE;
			throw new DAOException("Check data to be inserted", e);
		} finally {
			if(em != null) em.close();
		}
		return status;
	}

	@Override
	public String addDoctor(DoctorMaster doc) throws DAOException {
		EntityManager em = null;
		DoctorMaster doc1=null;
		String status = "";
		try {

			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();
			String phoneNo=doc.getPhoneNo();
			if (phoneNo!=null) {
				if(phoneNo!="" && phoneNo.length()>0) 
				try {
					Query qry = em
							.createQuery("SELECT b FROM DoctorMaster b WHERE b.phoneNo=:phoneNo and b.isDeleted=0");

					qry.setParameter("phoneNo", phoneNo);
					doc1 = (DoctorMaster) qry.getSingleResult();

				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(doc1==null){
			Date currentDate = DateUtil
					.convertCurrentDateToFormattedDate("yyyy-MM-dd");
			doc.setCreatedDate(currentDate);
			em.persist(doc);

			em.getTransaction().commit();
			//status = ReturnConstant.SUCCESS;
			status=""+doc.getId();
			//logger.info("doctor created successfully");
			}
			else {
				//status = ReturnConstant.FAILURE;
				status=""+0;
			}
		} catch (Exception e) {
			e.printStackTrace();
			//status = ReturnConstant.FAILURE;
			status=""+0;
			throw new DAOException("Check data to be inserted", e);
		} finally {
			if(em != null) em.close();
		}
		return status;
	}
	
	@Override
	public String addCustomer(CustomerMaster cust) throws DAOException {
		EntityManager em = null;
		String status = "";
		CustomerMaster cust1=null;
		try {

			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();
			String phoneNo=cust.getPhoneNo();
			if (phoneNo!=null) {
				if(phoneNo!="" && phoneNo.length()>0)
			try {
				Query qry = em
						.createQuery("SELECT b FROM CustomerMaster b WHERE b.phoneNo=:phoneNo and b.isDeleted=0");

				qry.setParameter("phoneNo", phoneNo);
				cust1 = (CustomerMaster) qry.getSingleResult();
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
			if(cust1==null){
			Date currentDate = DateUtil
					.convertCurrentDateToFormattedDate("yyyy-MM-dd");
			cust.setCreatedDate(currentDate);
			em.persist(cust);

			em.getTransaction().commit();
			//status = ReturnConstant.SUCCESS;
			status=""+cust.getId();
			//logger.info("customer created successfully");
			}
			else {
				status = ReturnConstant.FAILURE;
			}
		} catch (Exception e) {
			e.printStackTrace();
			//status = ReturnConstant.FAILURE;
			status=""+0;
			throw new DAOException("Check data to be inserted", e);
		} finally {
			if(em != null) em.close();
		}
		return status;
	}

	@Override
	public ResponseObj addSubCategory(SubCategoryMaster subCat) throws DAOException {
		EntityManager em = null;
		String status = "";
		ResponseObj responseObj=new ResponseObj();
		int result=0;
		SubCategoryMaster subCat1=null;
		try {

			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();
			String name=subCat.getName();
			try {
				Query qry = em
						.createQuery("SELECT b FROM SubCategoryMaster b WHERE b.name=:name and b.companyId=:companyId and b.isDeleted=0");

				qry.setParameter("name", name);
				qry.setParameter("companyId", subCat.getCompanyId());
				subCat1 = (SubCategoryMaster) qry.getSingleResult();
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(subCat1==null){
			Date currentDate = DateUtil
					.convertCurrentDateToFormattedDate("yyyy-MM-dd");
			subCat.setCreatedDate(currentDate);
			em.persist(subCat);

			em.getTransaction().commit();
			result=subCat.getId();
			if (result >0) {
				
				responseObj.setStatus(ReturnConstant.SUCCESS);
				responseObj.setId(result);
				responseObj.setReason("Sub Category added successfully.");
				
			} else {
				
				responseObj.setStatus(ReturnConstant.FAILURE);
				responseObj.setId(result);
				responseObj.setReason("Sub Category not added successfully.");
				
			}
			//status=""+manufacturerMaster.getId();
			//logger.info("Sub Category created successfully");
			}
			else {
				responseObj.setStatus(ReturnConstant.FAILURE);
				responseObj.setId(result);
				responseObj.setReason("Sub Category not added successfully.");
				//status=""+0;
			}
		} catch (Exception e) {
			e.printStackTrace();
			responseObj.setStatus(ReturnConstant.FAILURE);
			responseObj.setId(0);
			responseObj.setReason("Sub Category not added successfully.");
			throw new DAOException("Check data to be added", e);
		} finally {
			if(em != null) em.close();
		}
		return responseObj;
	}

	@Override
	public ResponseObj addManufacturer(ManufacturerMaster manufacturerMaster)
			throws DAOException {
		EntityManager em = null;
		//String status = "";
		ResponseObj responseObj=new ResponseObj();
		int result=0;
		ManufacturerMaster manufacturerMaster1=null;
		try {

			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();
			String name=manufacturerMaster.getName();
			try {
				Query qry = em
						.createQuery("SELECT b FROM ManufacturerMaster b WHERE b.name=:name and b.companyId=:companyId and b.isDeleted=0");

				qry.setParameter("name", name);
				qry.setParameter("companyId", manufacturerMaster.getCompanyId());
				manufacturerMaster1 = (ManufacturerMaster) qry.getSingleResult();
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(manufacturerMaster1==null){
			Date currentDate = DateUtil
					.convertCurrentDateToFormattedDate("yyyy-MM-dd");
			manufacturerMaster.setCreatedDate(currentDate);
			em.persist(manufacturerMaster);

			em.getTransaction().commit();
			//status = ReturnConstant.SUCCESS;
			result=manufacturerMaster.getId();
			if (result >0) {
				
				responseObj.setStatus(ReturnConstant.SUCCESS);
				responseObj.setId(result);
				responseObj.setReason("manu added successfully.");
				
			} else {
				
				responseObj.setStatus(ReturnConstant.FAILURE);
				responseObj.setId(result);
				responseObj.setReason("manu not added successfully.");
				
			}
			//status=""+manufacturerMaster.getId();
			//logger.info("Manufacturer created successfully");
			}
			else {
				responseObj.setStatus(ReturnConstant.FAILURE);
				responseObj.setId(result);
				responseObj.setReason("Manufacturer not added successfully.");
				//status=""+0;
			}
		} catch (Exception e) {
			e.printStackTrace();
			responseObj.setStatus(ReturnConstant.FAILURE);
			responseObj.setId(0);
			responseObj.setReason("Manufacturer not added successfully.");
			throw new DAOException("Check data to be added", e);
		} finally {
			if(em != null) em.close();
		}
		return responseObj;
	}
	
	@Override
	public ResponseObj addMarketer(MarketerMaster marketerMaster)
			throws DAOException {
		EntityManager em = null;
		//String status = "";
		ResponseObj responseObj=new ResponseObj();
		int result=0;
		MarketerMaster marketerMaster2=null;
		try {

			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();
			String name=marketerMaster.getName();
			try {
				Query qry = em
						.createQuery("SELECT b FROM MarketerMaster b WHERE b.name=:name and b.isDeleted=0");

				qry.setParameter("name", name);
				marketerMaster2 = (MarketerMaster) qry.getSingleResult();
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(marketerMaster2==null){
			Date currentDate = DateUtil
					.convertCurrentDateToFormattedDate("yyyy-MM-dd");
			marketerMaster.setCreatedDate(currentDate);
			em.persist(marketerMaster);

			em.getTransaction().commit();
			//status = ReturnConstant.SUCCESS;
			result=marketerMaster.getId();
			if (result >0) {
				
				responseObj.setStatus(ReturnConstant.SUCCESS);
				responseObj.setId(result);
				responseObj.setReason("marketer added successfully.");
				
			} else {
				
				responseObj.setStatus(ReturnConstant.FAILURE);
				responseObj.setId(result);
				responseObj.setReason("marketer not added successfully.");
				
			}
			//status=""+manufacturerMaster.getId();
			//logger.info("marketer created successfully");
			}
			else {
				responseObj.setStatus(ReturnConstant.FAILURE);
				responseObj.setId(result);
				responseObj.setReason("marketer not added successfully.");
				//status=""+0;
			}
		} catch (Exception e) {
			e.printStackTrace();
			responseObj.setStatus(ReturnConstant.FAILURE);
			responseObj.setId(0);
			responseObj.setReason("marketer not added successfully.");
			throw new DAOException("Check data to be added", e);
		} finally {
			if(em != null) em.close();
		}
		return responseObj;
	}

	@Override
	public ResponseObj addContent(ContentMaster contentMaster) throws DAOException {
		EntityManager em = null;
		//String status = "";
		ContentMaster contentMaster1=null;
		ResponseObj responseObj=new ResponseObj();
		int result=0;
		try {

			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();
			String name=contentMaster.getName();
			try {
				Query qry = em
						.createQuery("SELECT b FROM ContentMaster b WHERE b.name=:name and b.isDeleted=0");

				qry.setParameter("name", name);
				contentMaster1 = (ContentMaster) qry.getSingleResult();
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(contentMaster1==null){
			Date currentDate = DateUtil
					.convertCurrentDateToFormattedDate("yyyy-MM-dd");
			contentMaster.setCreatedDate(currentDate);
			em.persist(contentMaster);

			em.getTransaction().commit();
			//status = ReturnConstant.SUCCESS;
			result=contentMaster.getId();
			if (result >0) {
				
				responseObj.setStatus(ReturnConstant.SUCCESS);
				responseObj.setId(result);
				responseObj.setReason("Content created successfully");
				
			} else {
				
				responseObj.setStatus(ReturnConstant.FAILURE);
				responseObj.setId(result);
				responseObj.setReason("Content not created successfully.");
				
			}
			//logger.info("Content created successfully");
			}
			else {
				responseObj.setStatus(ReturnConstant.FAILURE);
				responseObj.setId(result);
				responseObj.setReason("Content not created successfully.");
			}
		} catch (Exception e) {
			e.printStackTrace();
			responseObj.setStatus(ReturnConstant.FAILURE);
			responseObj.setId(0);
			responseObj.setReason("Content not created successfully.");
			throw new DAOException("Check data to be created", e);
		} finally {
			if(em != null) em.close();
		}
		return responseObj;
	}

	@Override
	public ResponseObj addUnit(UnitMaster unitMaster) throws DAOException {
		EntityManager em = null;
		//String status = "";
		UnitMaster unitMaster1=null;
		ResponseObj responseObj=new ResponseObj();
		int result=0;
		try {

			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();
			String name=unitMaster.getCode();
			int typeid=unitMaster.getTypeId();
			try {
				Query qry = em
						.createQuery("SELECT b FROM UnitMaster b WHERE b.code=:name and b.typeId=:typeId and b.isDeleted=0 and b.companyId=:companyId");

				qry.setParameter("name", name);
				qry.setParameter("typeId", typeid);
				qry.setParameter("companyId",unitMaster.getCompanyId());
				unitMaster1 = (UnitMaster) qry.getSingleResult();
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(unitMaster1==null){
			Date currentDate = DateUtil
					.convertCurrentDateToFormattedDate("yyyy-MM-dd");
			unitMaster.setCreatedDate(currentDate);
			em.persist(unitMaster);

			em.getTransaction().commit();
			result=unitMaster.getId();
			if (result >0) {
				
				responseObj.setStatus(ReturnConstant.SUCCESS);
				responseObj.setId(result);
				responseObj.setReason("Unit added successfully.");
				
			} else {
				
				responseObj.setStatus(ReturnConstant.FAILURE);
				responseObj.setId(result);
				responseObj.setReason("Unit not added successfully.");
				
			}
			//status = ReturnConstant.SUCCESS;
			//logger.info("Unit created successfully");
			}
			else {
				responseObj.setStatus(ReturnConstant.FAILURE);
				responseObj.setId(result);
				responseObj.setReason("Unit already present.");
			}
		} catch (Exception e) {
			e.printStackTrace();
			responseObj.setStatus(ReturnConstant.FAILURE);
			responseObj.setId(0);
			responseObj.setReason("Unit not added successfully.");
			throw new DAOException("Check data to be added", e);
		} finally {
			if(em != null) em.close();
		}
		return responseObj;
	}

	@Override
	public ResponseObj addCategory(CategoryMaster categoryMaster)
			throws DAOException {
		EntityManager em = null;
		CategoryMaster categoryMaster1=null;
		ResponseObj responseObj=new ResponseObj();
		int result=0;
		try {

			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();
			String name=categoryMaster.getName();
			try {
				Query qry = em
						.createQuery("SELECT b FROM CategoryMaster b WHERE b.name=:name and b.companyId=:companyId and b.isDeleted=0");

				qry.setParameter("name", name);
				qry.setParameter("companyId", categoryMaster.getCompanyId());
				categoryMaster1 = (CategoryMaster) qry.getSingleResult();
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(categoryMaster1==null){
			Date currentDate = DateUtil
					.convertCurrentDateToFormattedDate("yyyy-MM-dd");
			categoryMaster.setCreatedDate(currentDate);
			em.persist(categoryMaster);

			em.getTransaction().commit();
			result=categoryMaster.getId();
			if (result >0) {
				
				responseObj.setStatus(ReturnConstant.SUCCESS);
				responseObj.setId(result);
				responseObj.setReason("category added successfully.");
				
			} else {
				
				responseObj.setStatus(ReturnConstant.FAILURE);
				responseObj.setId(result);
				responseObj.setReason("category not added successfully.");
				
			}
			//status = ReturnConstant.SUCCESS;
			//logger.info("category created successfully");
			}
			else {
				responseObj.setStatus(ReturnConstant.FAILURE);
				responseObj.setId(result);
				responseObj.setReason("category not added successfully.");
			}
		} catch (Exception e) {
			e.printStackTrace();
			responseObj.setStatus(ReturnConstant.FAILURE);
			responseObj.setId(0);
			responseObj.setReason("category not added successfully.");
			throw new DAOException("Check data to be added", e);
		} finally {
			if(em != null) em.close();
		}
		return responseObj;
	}

	@Override
	public String updateBrand(BrandMaster brand) throws DAOException {
		EntityManager em = null;
		BrandMaster brand1 = null;
		String status = "";
		BrandMaster brand2=null;
		try {
			Date currentDate = DateUtil
					.convertCurrentDateToFormattedDate("yyyy-MM-dd");
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();
			String name=brand.getName();
			try {
				Query qry = em
						.createQuery("SELECT b FROM BrandMaster b WHERE b.name=:name and b.isDeleted=0");

				qry.setParameter("name", name);
				brand2 = (BrandMaster) qry.getSingleResult();
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if(brand2==null){
			Query qry = em
					.createQuery("SELECT b FROM BrandMaster b WHERE b.id=:id");

			qry.setParameter("id", brand.getId());
			brand1 = (BrandMaster) qry.getSingleResult();
			brand1.setName(brand.getName());
			brand1.setUpdatedDate(currentDate);
			brand1.setUpdatedBy(brand.getUpdatedBy());
			em.merge(brand1);

			em.getTransaction().commit();
			status = ReturnConstant.SUCCESS;
			//logger.info("Brand updated successfully");
			}
			else {
				status = ReturnConstant.FAILURE;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			status = ReturnConstant.FAILURE;
			throw new DAOException("Check data to be inserted", e);
		} finally {
			if(em != null) em.close();
		}
		return status;
	}

	@Override
	public String updateDistributor(DistributorMaster dist) throws DAOException {
		EntityManager em = null;
		DistributorMaster dist1 = null;
		String status = "";
		try {
			Date currentDate = DateUtil
					.convertCurrentDateToFormattedDate("yyyy-MM-dd");
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();

			Query qry = em
					.createQuery("SELECT d FROM DistributorMaster d WHERE d.id=:id");

			qry.setParameter("id", dist.getId());
			dist1 = (DistributorMaster) qry.getSingleResult();
			if (dist.getName() != null) {
				if (dist.getName().length() > 0) {
					dist1.setName(dist.getName());
				}
			}
			if (dist.getAddress() != null) {
				if (dist.getAddress().length() > 0) {
					dist1.setAddress(dist.getAddress());
				}
			}

			if (dist.getPin() != null) {
				if (dist.getPin().length() > 0) {
					dist1.setPin(dist.getPin());
				}
			}

			//if (dist.getCity() != null) {
				//if (dist.getCity().length() > 0) {
					dist1.setCity(dist.getCity());
			//	}
			//}

			//if (dist.getState() != null) {
			//	if (dist.getState().length() > 0) {
					dist1.setState(dist.getState());
				//}
			//}

			//if (dist.getCountry() != null) {
				//if (dist.getCountry().length() > 0) {
					dist1.setCountry(dist.getCountry());
				//}
		//	}

			//if (dist.getCreditLimit() != 0.0) {

				dist1.setCreditLimit(dist.getCreditLimit());

			//}

			//if (dist.getObBal() != 0.0) {

				dist1.setObBal(dist.getObBal());

			//}
			if (dist.getPhoneNo1() != null) {
				if (dist.getPhoneNo1().length() > 0) {
					dist1.setPhoneNo1(dist.getPhoneNo1());
				}
			}
			//if (dist.getPhoneNo2() != null) {
			//	if (dist.getPhoneNo2().length() > 0) {
					dist1.setPhoneNo2(dist.getPhoneNo2());
				//}
			//}
			//if (dist.getFax() != null) {
				//if (dist.getFax().length() > 0) {
					dist1.setFax(dist.getFax());
				//}
			//}
			//if (dist.getEmail() != null) {
				//if (dist.getEmail().length() > 0) {
					dist1.setEmail(dist.getEmail());
				//}
			//}
			//if (dist.getContactPerson() != null) {
			//	if (dist.getContactPerson().length() > 0) {
					dist1.setContactPerson(dist.getContactPerson());
				//}
			//}
			if (dist.getRegistrationNo() != null) {
				if (dist.getRegistrationNo().length() > 0) {
					dist1.setRegistrationNo(dist.getRegistrationNo());
				}
			}
			
			//if (dist.getDiscount() != 0.0) {
				
					dist1.setDiscount(dist.getDiscount());
				
			//}
			
			//if (dist.getDiscountAmount() != 0.0) {
				
				dist1.setDiscountAmount(dist.getDiscountAmount());
			
			//}
			if (dist.getLicenceNo() != null) {
				if (dist.getLicenceNo().length() > 0) {
					dist1.setLicenceNo(dist.getLicenceNo());
				}
			}

			dist1.setUpdatedDate(currentDate);
			dist1.setUpdatedBy(dist.getUpdatedBy());
			em.merge(dist1);

			em.getTransaction().commit();
			status = ReturnConstant.SUCCESS;
			//logger.info("Brand updated successfully");
		} catch (Exception e) {
			e.printStackTrace();
			status = ReturnConstant.FAILURE;
			throw new DAOException("Check data to be inserted", e);
		} finally {
			if(em != null) em.close();
		}
		return status;
	}

	@Override
	public String updateDoctor(DoctorMaster doc) throws DAOException {
		EntityManager em = null;
		DoctorMaster doc1 = null;
		String status = "";
		try {
			Date currentDate = DateUtil
					.convertCurrentDateToFormattedDate("yyyy-MM-dd");
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();
			//String phoneNo=doc.getPhoneNo();
			/*try {
				Query qry = em
						.createQuery("SELECT b FROM DoctorMaster b WHERE b.phoneNo=:phoneNo and b.isDeleted=0");

				qry.setParameter("phoneNo", phoneNo);
				doc2 = (DoctorMaster) qry.getSingleResult();
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/

			//if(doc2==null){
			Query qry = em
					.createQuery("SELECT d FROM DoctorMaster d WHERE d.id=:id");

			qry.setParameter("id", doc.getId());
			doc1 = (DoctorMaster) qry.getSingleResult();
			if (doc.getName() != null) {
				if (doc.getName().length() > 0) {
					doc1.setName(doc.getName());
				}
			}
			//if (doc.getCode() != null) {
				
					doc1.setCode(doc.getCode());
				
			//}

			//if (doc.getQualification() != null) {
				
					doc1.setQualification(doc.getQualification());
				
			//}

			//if (doc.getSpeciality() != null) {
				
					doc1.setSpeciality(doc.getSpeciality());
				
			//}
			//if (doc.getAddress() != null) {
				
					doc1.setAddress(doc.getAddress());
				
			//}

			//if (doc.getPin() != null) {
				
					doc1.setPin(doc.getPin());
				
			//}

			//if (doc.getCity() != null) {
				
					doc1.setCity(doc.getCity());
				
			//}

			//if (doc.getState() != null) {
				
					doc1.setState(doc.getState());
				
			//}
			
			//if (doc.getFax() != null) {
				
				doc1.setFax(doc.getFax());
			
		//}

			//if (doc.getCountry() != null) {
				
					doc1.setCountry(doc.getCountry());
				
			//}

			//if (doc.getPhoneNo() != null) {
				
					doc1.setPhoneNo(doc.getPhoneNo());
				
			//}

			//if (doc.getOpBal() != 0.0) {

				doc1.setOpBal(doc.getOpBal());

			//}

			//if (doc.getCommPer() != 0.0) {

				doc1.setCommPer(doc.getCommPer());

			//}
				
				doc1.setIsLocked(doc.getIsLocked());

			doc1.setUpdatedDate(currentDate);
			doc1.setUpdatedBy(doc.getUpdatedBy());
			em.merge(doc1);

			em.getTransaction().commit();
			status = ReturnConstant.SUCCESS;
			//logger.info("doctor updated successfully");
			/*}
			else {
				status = ReturnConstant.FAILURE;
			}*/
		} catch (Exception e) {
			e.printStackTrace();
			status = ReturnConstant.FAILURE;
			throw new DAOException("Check data to be inserted", e);
		} finally {
			if(em != null) em.close();
		}
		return status;
	}
	
	@Override
	public String updateCustomer(CustomerMaster cust) throws DAOException {
		EntityManager em = null;
		CustomerMaster cust1 = null;
		CustomerMaster cust2 = null;
		String status = "";
		try {
			Date currentDate = DateUtil
					.convertCurrentDateToFormattedDate("yyyy-MM-dd");
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();
			String phoneNo=cust.getPhoneNo();
			/*try {
				Query qry = em
						.createQuery("SELECT b FROM CustomerMaster b WHERE b.phoneNo=:phoneNo and b.isDeleted=0");

				qry.setParameter("phoneNo", phoneNo);
				cust2 = (CustomerMaster) qry.getSingleResult();
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
			//if(cust2!=null){
				//if (cust.getId()==cust2.getId()) {
				Query qry = em
						.createQuery("SELECT d FROM CustomerMaster d WHERE d.id=:id");
				qry.setParameter("id", cust.getId());
				cust1 = (CustomerMaster) qry.getSingleResult();
				if (cust.getName() != null) {
					if (cust.getName().length() > 0) {
						cust1.setName(cust.getName());
					}
				}
				//if (cust.getCode() != null) {

					cust1.setCode(cust.getCode());

				//}
				//if (cust.getAddress() != null) {

					cust1.setAddress(cust.getAddress());

				//}
				//if (cust.getPin() != null) {

					cust1.setPin(cust.getPin());

				//}
				//if (cust.getCity() != null) {

					cust1.setCity(cust.getCity());

				//}
				//if (cust.getState() != null) {

					cust1.setState(cust.getState());

				//}
				//if (cust.getCountry() != null) {

					cust1.setCountry(cust.getCountry());

				//}
				if (cust.getPhoneNo() != null) {

					cust1.setPhoneNo(cust.getPhoneNo());

				}
				//if (cust.getFax() != null) {

					cust1.setFax(cust.getFax());

				//}
				//if (cust.getObBal() != 0.0) {

					cust1.setObBal(cust.getObBal());

				//}
				//if (cust.getCreditLimit() != 0.0) {

					cust1.setCreditLimit(cust.getCreditLimit());

				//}
				cust1.setUpdatedDate(currentDate);
				cust1.setUpdatedBy(cust.getUpdatedBy());
				em.merge(cust1);
				em.getTransaction().commit();
				status = ReturnConstant.SUCCESS;
				//logger.info("customer updated successfully");
			/*}
				else {
					status = ReturnConstant.FAILURE;
				}
			}
			else {
				status = ReturnConstant.FAILURE;
			}*/
		} catch (Exception e) {
			e.printStackTrace();
			status = ReturnConstant.FAILURE;
			throw new DAOException("Check data to be inserted", e);
		} finally {
			if(em != null) em.close();
		}
		return status;
	}

	@Override
	public ResponseObj updateItem(ItemMaster item) throws DAOException {
		EntityManager em = null;
		String status = "";
		Connection connection = null;
		CallableStatement callableStatement = null;
		int result = 0;
		ResponseObj responseObj=new ResponseObj();
		ItemMaster itemMaster=new ItemMaster();
		try {

			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();
			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();
			connection = sessionFactory.getConnectionProvider().getConnection();

			Date currentDate = DateUtil
					.convertCurrentDateToFormattedDate("yyyy-MM-dd");
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			String crntDate = df.format(currentDate);
			java.sql.Date crntDate1 = DateUtil.convertStringDateToSqlDate(
					crntDate, "yyyy-MM-dd");
			
			String LaunchDate = df.format(item.getLaunchDate());
			java.sql.Date LaunchDate1 = DateUtil.convertStringDateToSqlDate(
					LaunchDate, "yyyy-MM-dd");
			
			String DiscontinueDate = df.format(item.getDiscontinueDate());
			java.sql.Date DiscontinueDate1 = DateUtil.convertStringDateToSqlDate(
					DiscontinueDate, "yyyy-MM-dd");
			
			int id = item.getId();
			String name = item.getName();
			String code = item.getCode();
			int grpId = item.getGroupId();
			int catid = item.getCategoryId();
			int subCatId = item.getSubCategoryId();
			int schdId = item.getScheduleId();
			int contntId = item.getContentId();
			int brandId = item.getBrandId();
			int manuId = item.getManufacturerId();
			Date entryDate = item.getEntryDate();
			double vat = item.getVat();
			int isMrp = item.getIsOnMrp();
			int packUnitId = item.getPackUnitId();
			int conv = item.getConversion();
			String storage = item.getStorage();
			String care = item.getCare();
			int reOrderLevel = item.getReorderLevel();
			int reOrderLevelunit = item.getReorderLevelUnitId();
			int taxable = item.getIsTaxable();
			int rackId = item.getRackId();
			String note = item.getNote();
			int cmpnyId = item.getCompanyId(); // set company id 0
			// store id set 0
			int createdBy = item.getCreatedBy();
			double price = item.getPrice();
			double markup = item.getMarkup();
			String strength = item.getStrength();
			int looseuntId = item.getLooseUnitId();
			String netContnt = item.getNetContent();

			callableStatement = connection
					.prepareCall(StoredProcedures.PROC_UPDATE_ITEM);
			callableStatement.setInt(1, item.getId());
			callableStatement.setString(2, name);
			callableStatement.setString(3, code);
			callableStatement.setString(4, item.getHsnCode());
			callableStatement.setString(5, item.getSku());
			callableStatement.setInt(6, grpId);
			callableStatement.setInt(7, catid);
			callableStatement.setInt(8, subCatId);
			callableStatement.setInt(9, schdId);
			callableStatement.setInt(10, contntId);
			callableStatement.setInt(11, brandId);
			callableStatement.setInt(12, manuId);
			callableStatement.setInt(13, item.getMarketerId());
			callableStatement.setDate(14, crntDate1);
			callableStatement.setDouble(15, vat);
			callableStatement.setInt(16, isMrp);
			//callableStatement.setInt(16, item.getTaxTypeId());
			
			callableStatement.setInt(17, item.getPurchaseTaxId());
			callableStatement.setDouble(18, item.getPurchaseTaxPercentage());
			callableStatement.setInt(19, item.getSaleTaxId());
			callableStatement.setDouble(20, item.getSaleTaxPercentage());
			callableStatement.setInt(21, packUnitId);
			callableStatement.setInt(22, conv);
			callableStatement.setInt(23, item.getIsLooseSale());
			
			callableStatement.setInt(24, looseuntId);
			
			callableStatement.setString(25, storage);
			callableStatement.setString(26, care);
			callableStatement.setInt(27, reOrderLevel);
			callableStatement.setInt(28, item.getReorderLevelQty());
			callableStatement.setInt(29, reOrderLevelunit);
			callableStatement.setDouble(30, item.getPrice());
			callableStatement.setInt(31, taxable);
			callableStatement.setDouble(32, markup);
			callableStatement.setInt(33, item.getIsDiscount());
			callableStatement.setDouble(34, item.getDiscount());
			callableStatement.setString(35, strength);
			callableStatement.setString(36, netContnt);
			callableStatement.setString(37, note);
			callableStatement.setString(38, item.getDescription());
			callableStatement.setString(39, item.getPrintName());
			callableStatement.setString(40, item.getImgUrl());
			callableStatement.setInt(41, item.getMaxLevel());
			callableStatement.setInt(42, item.getMinLevel());
			callableStatement.setInt(43, item.getIsActive());
			callableStatement.setString(44, item.getColour());
			callableStatement.setString(45, item.getSizeType());
			callableStatement.setString(46, item.getSize());
			callableStatement.setString(47, item.getWeight());
			callableStatement.setString(48, item.getPartNumber());
			callableStatement.setString(49, item.getAuthorName());
			callableStatement.setString(50, item.getEdition());
			callableStatement.setDouble(51, item.getMrp());
			callableStatement.setDouble(52, item.getPurchaseRate());
			callableStatement.setDouble(53, item.getListedMrp());
			callableStatement.setDouble(54, item.getWsp());
			callableStatement.setInt(55, item.getStockRequired());
			callableStatement.setInt(56, item.getBatchWiseStock());
			callableStatement.setInt(57, item.getExpiryDateRequired());
			callableStatement.setInt(58, item.getDualStockRequired());
			callableStatement.setString(59, item.getSaleRateOn());
			callableStatement.setInt(60, item.getLocationRequired());
			callableStatement.setInt(61, item.getPriceListRequired());
			callableStatement.setInt(62, item.getSizeWiseStockRequired());
			callableStatement.setInt(63, item.getWarrantyRequired());
			callableStatement.setString(64, item.getWarrantyTypeOn());
			callableStatement.setInt(65, item.getWarrantyMonth());
			callableStatement.setInt(66, item.getMrpRequired());
			callableStatement.setInt(67, item.getSerialNoRequired());
			callableStatement.setInt(68, item.getSerialNoSuffRequired());
			callableStatement.setInt(69, item.getSerialNoPrefRequired());
			callableStatement.setString(70, item.getSerialNoType());
			
			callableStatement.setDouble(71, item.getMaxDiscountLimit());
			callableStatement.setDouble(72, item.getTaxTypeId());
			callableStatement.setDouble(73, item.getMaximumQty());
			callableStatement.setDate(74,LaunchDate1);
			callableStatement.setDate(75,DiscontinueDate1);
			callableStatement.setDouble(76,item.getSaleRate());
			callableStatement.setInt(77,item.getRetailTypeId());
			
			callableStatement.setInt(78, rackId); 
			
			callableStatement.setInt(79, item.getExpiryMonthRequired());
			callableStatement.setInt(80, item.getColourWiseStockRequired());
			
			callableStatement.setInt(81, cmpnyId);
			callableStatement.setInt(82, 0);
			callableStatement.setInt(83, createdBy);

			callableStatement.registerOutParameter(84, java.sql.Types.INTEGER);

			callableStatement.execute();
			result = callableStatement.getInt(84);
			if(result>0){
				
				TaxMaster purTaxMaster=new TaxMaster();
				TaxMaster saleTaxMaster=new TaxMaster();
				responseObj.setStatus(ReturnConstant.SUCCESS);
				responseObj.setId(result);
				//fetch purchase tax and sale tax
				try {
					int purTaxId=item.getPurchaseTaxId();
					Query qry = em
							.createQuery("SELECT t FROM TaxMaster t WHERE t.id=:id and t.isDeleted=0");

					qry.setParameter("id", purTaxId);
					purTaxMaster= (TaxMaster) qry.getSingleResult();
					
					//get tax grp details
					int isGrp=purTaxMaster.getIsGroup();
					if(isGrp>0){
					
						List<TaxMaster> taxList = new ArrayList<TaxMaster>();
						Query qry2 = em
								.createQuery("SELECT t from TaxMaster t where t.id in (select g.taxId from TaxGrpDetailsMaster g,TaxMaster t1 where t1.id=g.parentId and t1.isDeleted=0)");
						
						taxList = (List<TaxMaster>) qry2.getResultList();
						List<TaxGrpDetailsMaster> grpList=new ArrayList<TaxGrpDetailsMaster>();
						Iterator<TaxMaster> iterator=taxList.iterator();
						while (iterator.hasNext()) {
							TaxMaster taxMaster = (TaxMaster) iterator.next();
							TaxGrpDetailsMaster detailsMaster=new TaxGrpDetailsMaster();
							detailsMaster.setDescription(taxMaster.getDescription());
							detailsMaster.setTaxId(taxMaster.getId());
							detailsMaster.setParentId(purTaxId);
							detailsMaster.setPercentage(taxMaster.getPercentage());
							detailsMaster.setTaxMode(taxMaster.getTaxMode());
							detailsMaster.setTaxName(taxMaster.getName());
							grpList.add(detailsMaster);
							
						}
						purTaxMaster.setTaxGrpDetailsMasters(grpList);
						
					}
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				item.setPurchaseTax(purTaxMaster);
				
				try {
					int saleTaxId=item.getSaleTaxId();
					Query qry1 = em
							.createQuery("SELECT t FROM TaxMaster t WHERE t.id=:id and t.isDeleted=0");

					qry1.setParameter("id", saleTaxId);
					saleTaxMaster= (TaxMaster) qry1.getSingleResult();
					
					//get tax grp details
					int isGrp=saleTaxMaster.getIsGroup();
					if(isGrp>0){
						
						List<TaxMaster> taxList = new ArrayList<TaxMaster>();
						Query qry2 = em
								.createQuery("SELECT t from TaxMaster t where t.id in (select g.taxId from TaxGrpDetailsMaster g,TaxMaster t1 where t1.id=g.parentId and t1.isDeleted=0)");
						
						taxList = (List<TaxMaster>) qry2.getResultList();
						List<TaxGrpDetailsMaster> grpList=new ArrayList<TaxGrpDetailsMaster>();
						Iterator<TaxMaster> iterator=taxList.iterator();
						while (iterator.hasNext()) {
							TaxMaster taxMaster = (TaxMaster) iterator.next();
							TaxGrpDetailsMaster detailsMaster=new TaxGrpDetailsMaster();
							detailsMaster.setDescription(taxMaster.getDescription());
							detailsMaster.setTaxId(taxMaster.getId());
							detailsMaster.setParentId(saleTaxId);
							detailsMaster.setPercentage(taxMaster.getPercentage());
							detailsMaster.setTaxMode(taxMaster.getTaxMode());
							detailsMaster.setTaxName(taxMaster.getName());
							grpList.add(detailsMaster);
							
						}
						saleTaxMaster.setTaxGrpDetailsMasters(grpList);
						
					}
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				item.setSaleTax(saleTaxMaster);
				//get group
				GroupMaster grp =new GroupMaster();
				try {
					
					Query qryg = em
							.createQuery("SELECT g FROM GroupMaster g WHERE g.id=:id and g.isDeleted=0");
					qryg.setParameter("id", grpId);
					grp=(GroupMaster) qryg.getSingleResult();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				item.setGroupMaster(grp);
				//get schedule
				ScheduleMaster sch =new ScheduleMaster();
				try {
					
					Query qrys = em
							.createQuery("SELECT s FROM ScheduleMaster s WHERE s.id=:id and s.isDeleted=0");
					qrys.setParameter("id", schdId);
					sch=(ScheduleMaster) qrys.getSingleResult();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				item.setScheduleMaster(sch);
				//get manufacturer
				ManufacturerMaster manu =new ManufacturerMaster();
				try {
					
					Query qrym = em
							.createQuery("SELECT m FROM ManufacturerMaster m WHERE m.id=:id and m.isDeleted=0");
					qrym.setParameter("id", manuId);
					manu=(ManufacturerMaster) qrym.getSingleResult();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				item.setManufacturerMaster(manu);
				item.setId(result);
				responseObj.setItem(item);
				responseObj.setReason("Record save successfully.");
				em.getTransaction().commit();
			} else {
				
				responseObj.setStatus(ReturnConstant.FAILURE);
				responseObj.setId(result);
				responseObj.setItem(itemMaster);
				responseObj.setReason("Record not saved successfully.");
				logger.info("Item can't be updated.");
			}
			

		} catch (Exception e) {
			e.printStackTrace();
			responseObj.setStatus(ReturnConstant.FAILURE);
			responseObj.setId(0);
			responseObj.setItem(itemMaster);
			responseObj.setReason("Record not saved successfully.");
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
	public ResponseObj updateSchedule(ScheduleMaster scheduleMaster)
			throws DAOException {
		EntityManager em = null;
		ScheduleMaster schdule = null;
		ScheduleMaster schdule1 = null;
		//String status = "";
		ResponseObj responseObj=new ResponseObj();
		int result=0;
		try {
			Date currentDate = DateUtil
					.convertCurrentDateToFormattedDate("yyyy-MM-dd");
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();

			String name=scheduleMaster.getName();
			try {
				Query qry = em
						.createQuery("SELECT b FROM ScheduleMaster b WHERE b.name=:name and b.isDeleted=0");

				qry.setParameter("name", name);
				schdule1 = (ScheduleMaster) qry.getSingleResult();
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(schdule1==null){
			Query qry = em
					.createQuery("SELECT s FROM ScheduleMaster s WHERE s.id=:id");

			qry.setParameter("id", scheduleMaster.getId());
			schdule = (ScheduleMaster) qry.getSingleResult();
			schdule.setName(scheduleMaster.getName());
			schdule.setUpdatedDate(currentDate);
			schdule.setUpdatedBy(scheduleMaster.getUpdatedBy());
			em.merge(schdule);

			em.getTransaction().commit();
			result=schdule.getId();
			if (result >0) {
				
				responseObj.setStatus(ReturnConstant.SUCCESS);
				responseObj.setId(result);
				responseObj.setReason("schedule updated successfully");
				
			} else {
				
				responseObj.setStatus(ReturnConstant.FAILURE);
				responseObj.setId(result);
				responseObj.setReason("schedule not updated successfully.");
				
			}
			//status = ReturnConstant.SUCCESS;
			//logger.info("schedule updated successfully");
			}
			else {
				responseObj.setStatus(ReturnConstant.FAILURE);
				responseObj.setId(result);
				responseObj.setReason("schedule not updated successfully.");
			}
		} catch (Exception e) {
			e.printStackTrace();
			responseObj.setStatus(ReturnConstant.FAILURE);
			responseObj.setId(0);
			responseObj.setReason("schedule not updated successfully.");
			throw new DAOException("Check data to be updated", e);
		} finally {
			if(em != null) em.close();
		}
		return responseObj;
	}

	@Override
	public ResponseObj updateGroup(GroupMaster groupMaster) throws DAOException {
		EntityManager em = null;
		GroupMaster group = null;
		GroupMaster group1 = null;
		ResponseObj responseObj=new ResponseObj();
		//String status = "";
		int result=0;
		try {
			Date currentDate = DateUtil
					.convertCurrentDateToFormattedDate("yyyy-MM-dd");
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();
			String name=groupMaster.getName();
			/*try {
				Query qry = em
						.createQuery("SELECT b FROM GroupMaster b WHERE b.name=:name and b.isDeleted=0");

				qry.setParameter("name", name);
				group1 = (GroupMaster) qry.getSingleResult();
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/

			//if(group1==null){
			Query qry = em
					.createQuery("SELECT g FROM GroupMaster g WHERE g.id=:id");

			qry.setParameter("id", groupMaster.getId());
			group = (GroupMaster) qry.getSingleResult();
			if (groupMaster.getName() != null) {
				if (groupMaster.getName().length() > 0) {
					group.setName(groupMaster.getName());
				}
			}
			if (groupMaster.getDescription() != null) {
				if (groupMaster.getDescription().length() > 0) {
					group.setDescription(groupMaster.getDescription());
				}
			}

			group.setUpdatedDate(currentDate);
			group.setUpdatedBy(groupMaster.getUpdatedBy());
			em.merge(group);

			em.getTransaction().commit();
			//status = ReturnConstant.SUCCESS;
			result=groupMaster.getId();
			if (result >0) {
				
				responseObj.setStatus(ReturnConstant.SUCCESS);
				responseObj.setId(result);
				responseObj.setReason("group updated successfully.");
				
			} else {
				
				responseObj.setStatus(ReturnConstant.FAILURE);
				responseObj.setId(result);
				responseObj.setReason("group not updated successfully.");
				
			}
			//logger.info("Group updated successfully");
			/*}
			else {
				responseObj.setStatus(ReturnConstant.FAILURE);
				responseObj.setId(result);
				responseObj.setReason("group not updated successfully.");
			}*/
		} catch (Exception e) {
			e.printStackTrace();
			responseObj.setStatus(ReturnConstant.FAILURE);
			responseObj.setId(0);
			responseObj.setReason("group not updated successfully.");
			throw new DAOException("Check data to be updated", e);
			
		} finally {
			if(em != null) em.close();
		}
		return responseObj;
	}

	@Override
	public String updateRack(RackMaster rack) throws DAOException {
		EntityManager em = null;
		RackMaster rack1 = null;
		RackMaster rack2 = null;
		String status = "";
		
		try {
			Date currentDate = DateUtil
					.convertCurrentDateToFormattedDate("yyyy-MM-dd");
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();
			String name=rack.getName();
			try {
				Query qry = em
						.createQuery("SELECT b FROM RackMaster b WHERE b.name=:name and b.isDeleted=0");

				qry.setParameter("name", name);
				rack2 = (RackMaster) qry.getSingleResult();
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(rack2==null){
			Query qry = em
					.createQuery("SELECT r FROM RackMaster r WHERE r.id=:id");

			qry.setParameter("id", rack.getId());
			rack1 = (RackMaster) qry.getSingleResult();
			rack1.setName(rack.getName());
			rack1.setUpdatedDate(currentDate);
			rack1.setUpdatedBy(rack.getUpdatedBy());
			em.merge(rack1);

			em.getTransaction().commit();
			status = ReturnConstant.SUCCESS;
			//logger.info("Rack updated successfully");
			}
			else {
				status = ReturnConstant.FAILURE;
			}
		} catch (Exception e) {
			e.printStackTrace();
			status = ReturnConstant.FAILURE;
			throw new DAOException("Check data to be inserted", e);
		} finally {
			if(em != null) em.close();
		}
		return status;
	}

	@Override
	public String updateCategory(CategoryMaster categoryMaster)
			throws DAOException {
		EntityManager em = null;
		CategoryMaster category = null;
		CategoryMaster category1 = null;
		String status = "";
		try {
			Date currentDate = DateUtil
					.convertCurrentDateToFormattedDate("yyyy-MM-dd");
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();

			String name=categoryMaster.getName();
			try {
				Query qry = em
						.createQuery("SELECT b FROM CategoryMaster b WHERE b.name=:name and b.isDeleted=0");

				qry.setParameter("name", name);
				category1 = (CategoryMaster) qry.getSingleResult();
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(category1==null){
			Query qry = em
					.createQuery("SELECT c FROM CategoryMaster c WHERE c.id=:id");

			qry.setParameter("id", categoryMaster.getId());
			category = (CategoryMaster) qry.getSingleResult();
			category.setName(categoryMaster.getName());
			category.setUpdatedDate(currentDate);
			category.setUpdatedBy(categoryMaster.getUpdatedBy());
			em.merge(category);

			em.getTransaction().commit();
			status = ReturnConstant.SUCCESS;
			//logger.info("Category updated successfully");
			}
			else {
				status = ReturnConstant.FAILURE;
			}
		} catch (Exception e) {
			e.printStackTrace();
			status = ReturnConstant.FAILURE;
			throw new DAOException("Check data to be inserted", e);
		} finally {
			if(em != null) em.close();
		}
		return status;
	}

	@Override
	public String updateSubCategory(SubCategoryMaster subCategoryMaster)
			throws DAOException {
		EntityManager em = null;
		SubCategoryMaster subcat = null;
		SubCategoryMaster subcat1 = null;
		String status = "";
		try {
			Date currentDate = DateUtil
					.convertCurrentDateToFormattedDate("yyyy-MM-dd");
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();
			String name=subCategoryMaster.getName();
			try {
				Query qry = em
						.createQuery("SELECT b FROM SubCategoryMaster b WHERE b.name=:name and b.isDeleted=0");

				qry.setParameter("name", name);
				subcat1 = (SubCategoryMaster) qry.getSingleResult();
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if(subcat1==null){
			Query qry = em
					.createQuery("SELECT s FROM SubCategoryMaster s WHERE s.id=:id");

			qry.setParameter("id", subCategoryMaster.getId());
			subcat = (SubCategoryMaster) qry.getSingleResult();
			subcat.setName(subCategoryMaster.getName());
			subcat.setUpdatedDate(currentDate);
			subcat.setUpdatedBy(subCategoryMaster.getUpdatedBy());
			em.merge(subcat);

			em.getTransaction().commit();
			status = ReturnConstant.SUCCESS;
			//logger.info("Sub Category updated successfully");
			}
			else {
				status = ReturnConstant.FAILURE;
			}
		} catch (Exception e) {
			e.printStackTrace();
			status = ReturnConstant.FAILURE;
			throw new DAOException("Check data to be inserted", e);
		} finally {
			if(em != null) em.close();
		}
		return status;
	}

	@Override
	public ResponseObj updateUnit(UnitMaster unitMaster) throws DAOException {
		EntityManager em = null;
		UnitMaster unit = null;
		//String status = "";
		ResponseObj responseObj=new ResponseObj();
		int result=0;
		try {
			Date currentDate = DateUtil
					.convertCurrentDateToFormattedDate("yyyy-MM-dd");
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();
	
			Query qry = em
					.createQuery("SELECT u FROM UnitMaster u WHERE u.id=:id and u.isDeleted=0");

			qry.setParameter("id", unitMaster.getId());
			unit = (UnitMaster) qry.getSingleResult();
			unit.setCode(unitMaster.getCode());
			if (unitMaster.getTypeId() != 0) {
				unit.setTypeId(unitMaster.getTypeId());
			}
			if(unitMaster.getDescription()!=null){
				unit.setDescription(unitMaster.getDescription());
			}
			unit.setUpdatedDate(currentDate);
			unit.setUpdatedBy(unitMaster.getUpdatedBy());

			em.getTransaction().commit();
			//status = ReturnConstant.SUCCESS;
			
			result=unitMaster.getId();
			if (result >0) {
				
				responseObj.setStatus(ReturnConstant.SUCCESS);
				responseObj.setId(result);
				responseObj.setReason("Unit updated successfully.");
				
			} else {
				
				responseObj.setStatus(ReturnConstant.FAILURE);
				responseObj.setId(result);
				responseObj.setReason("Unit not updated successfully.");
				
			}
			
			//logger.info("Unit updated successfully");
			
		} catch (Exception e) {
			e.printStackTrace();
			responseObj.setStatus(ReturnConstant.FAILURE);
			responseObj.setId(0);
			responseObj.setReason("Unit not updated successfully.");
			throw new DAOException("Check data to be updated", e);
		} finally {
			if(em != null) em.close();
		}
		return responseObj;
	}

	@Override
	public ResponseObj updateManufacturer(ManufacturerMaster manufacturerMaster)
			throws DAOException {
		EntityManager em = null;
		ManufacturerMaster manufactr1 = null;
		ManufacturerMaster manufactr2 = null;
		//String status = "";
		ResponseObj responseObj=new ResponseObj();
		int result=0;
		try {
			Date currentDate = DateUtil
					.convertCurrentDateToFormattedDate("yyyy-MM-dd");
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();
			String name=manufacturerMaster.getName();
			/*try {
				Query qry = em
						.createQuery("SELECT b FROM ManufacturerMaster b WHERE b.name=:name and b.isDeleted=0");

				qry.setParameter("name", name);
				manufactr2 = (ManufacturerMaster) qry.getSingleResult();
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/

			//if(manufactr2==null){
			Query qry = em
					.createQuery("SELECT m FROM ManufacturerMaster m WHERE m.id=:id");

			qry.setParameter("id", manufacturerMaster.getId());
			manufactr1 = (ManufacturerMaster) qry.getSingleResult();
			if (manufacturerMaster.getName() != null) {
				if (manufacturerMaster.getName().length() > 0) {
					manufactr1.setName(manufacturerMaster.getName());
				}
			}
			if (manufacturerMaster.getAddress() != null) {
				if (manufacturerMaster.getAddress().length() > 0) {
					manufactr1.setAddress(manufacturerMaster.getAddress());
				}
			}
			//if (manufacturerMaster.getPhone() != null) {
				//if (manufacturerMaster.getPhone().length() > 0) {
					manufactr1.setPhone(manufacturerMaster.getPhone());
				//}
			//}
			if (manufacturerMaster.getCode() != null) {
				if (manufacturerMaster.getCode().length() > 0) {
					manufactr1.setCode(manufacturerMaster.getCode());
				}
			}

			//if (manufacturerMaster.getFax() != null) {
				//if (manufacturerMaster.getFax().length() > 0) {
					manufactr1.setFax(manufacturerMaster.getFax());
				//}
			//}
			//if (manufacturerMaster.getEmail() != null) {
				//if (manufacturerMaster.getEmail().length() > 0) {
					manufactr1.setEmail(manufacturerMaster.getEmail());
				//}
			//}
			//if (manufacturerMaster.getUrl() != null) {
				//if (manufacturerMaster.getUrl().length() > 0) {
					manufactr1.setUrl(manufacturerMaster.getUrl());
				//}
			//}

			manufactr1.setUpdatedDate(currentDate);
			manufactr1.setUpdatedBy(manufacturerMaster.getUpdatedBy());
			em.merge(manufactr1);

			em.getTransaction().commit();
			result=manufactr1.getId();
			if (result >0) {
				
				responseObj.setStatus(ReturnConstant.SUCCESS);
				responseObj.setId(result);
				responseObj.setReason("manu updated successfully.");
				
			} else {
				
				responseObj.setStatus(ReturnConstant.FAILURE);
				responseObj.setId(result);
				responseObj.setReason("manu not updated successfully.");
				
			}
			//status = ReturnConstant.SUCCESS;
			//logger.info("Manufacturer updated successfully");
			/*}
			else {
				status = ReturnConstant.FAILURE;
			}*/
		} catch (Exception e) {
			e.printStackTrace();
			responseObj.setStatus(ReturnConstant.FAILURE);
			responseObj.setId(0);
			responseObj.setReason("manu not updated successfully.");
			throw new DAOException("Check data to be updated", e);
		} finally {
			if(em != null) em.close();
		}
		return responseObj;
	}
	
	@Override
	public ResponseObj updateMarketer(MarketerMaster marketerMaster)
			throws DAOException {
		EntityManager em = null;
		MarketerMaster manufactr1 = null;
		MarketerMaster manufactr2 = null;
		//String status = "";
		ResponseObj responseObj=new ResponseObj();
		int result=0;
		try {
			Date currentDate = DateUtil
					.convertCurrentDateToFormattedDate("yyyy-MM-dd");
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();
			String name=marketerMaster.getName();
			/*try {
				Query qry = em
						.createQuery("SELECT b FROM ManufacturerMaster b WHERE b.name=:name and b.isDeleted=0");

				qry.setParameter("name", name);
				manufactr2 = (ManufacturerMaster) qry.getSingleResult();
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/

			//if(manufactr2==null){
			Query qry = em
					.createQuery("SELECT m FROM MarketerMaster m WHERE m.id=:id");

			qry.setParameter("id", marketerMaster.getId());
			manufactr1 = (MarketerMaster) qry.getSingleResult();
			if (marketerMaster.getName() != null) {
				if (marketerMaster.getName().length() > 0) {
					manufactr1.setName(marketerMaster.getName());
				}
			}
			if (marketerMaster.getAddress() != null) {
				if (marketerMaster.getAddress().length() > 0) {
					manufactr1.setAddress(marketerMaster.getAddress());
				}
			}
			//if (manufacturerMaster.getPhone() != null) {
				//if (manufacturerMaster.getPhone().length() > 0) {
					manufactr1.setPhone(marketerMaster.getPhone());
				//}
			//}
			if (marketerMaster.getCode() != null) {
				if (marketerMaster.getCode().length() > 0) {
					manufactr1.setCode(marketerMaster.getCode());
				}
			}

			//if (manufacturerMaster.getFax() != null) {
				//if (manufacturerMaster.getFax().length() > 0) {
					manufactr1.setFax(marketerMaster.getFax());
				//}
			//}
			//if (manufacturerMaster.getEmail() != null) {
				//if (manufacturerMaster.getEmail().length() > 0) {
					manufactr1.setEmail(marketerMaster.getEmail());
				//}
			//}
			//if (manufacturerMaster.getUrl() != null) {
				//if (manufacturerMaster.getUrl().length() > 0) {
					manufactr1.setUrl(marketerMaster.getUrl());
				//}
			//}

			manufactr1.setUpdatedDate(currentDate);
			manufactr1.setUpdatedBy(marketerMaster.getUpdatedBy());
			em.merge(manufactr1);

			em.getTransaction().commit();
			result=manufactr1.getId();
			if (result >0) {
				
				responseObj.setStatus(ReturnConstant.SUCCESS);
				responseObj.setId(result);
				responseObj.setReason("marketer updated successfully.");
				
			} else {
				
				responseObj.setStatus(ReturnConstant.FAILURE);
				responseObj.setId(result);
				responseObj.setReason("marketer not updated successfully.");
				
			}
			//status = ReturnConstant.SUCCESS;
			//logger.info("marketer updated successfully");
			/*}
			else {
				status = ReturnConstant.FAILURE;
			}*/
		} catch (Exception e) {
			e.printStackTrace();
			responseObj.setStatus(ReturnConstant.FAILURE);
			responseObj.setId(0);
			responseObj.setReason("marketer not updated successfully.");
			throw new DAOException("Check data to be updated", e);
		} finally {
			if(em != null) em.close();
		}
		return responseObj;
	}

	@Override
	public ResponseObj updateContent(ContentMaster contentMaster)
			throws DAOException {
		EntityManager em = null;
		ContentMaster content = null;
		ContentMaster content1 = null;
		//String status = "";
		ResponseObj responseObj=new ResponseObj();
		int result=0;
		try {
			Date currentDate = DateUtil
					.convertCurrentDateToFormattedDate("yyyy-MM-dd");
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();

			String name=contentMaster.getName();
			/*try {
				Query qry = em
						.createQuery("SELECT b FROM ContentMaster b WHERE b.name=:name and b.isDeleted=0");

				qry.setParameter("name", name);
				content1 = (ContentMaster) qry.getSingleResult();
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
			//if(content1==null){
			Query qry = em
					.createQuery("SELECT c FROM ContentMaster c WHERE c.id=:id and c.isDeleted=:isDeleted");

			qry.setParameter("id", contentMaster.getId());
			qry.setParameter("isDeleted", 0);
			content = (ContentMaster) qry.getSingleResult();
			if (contentMaster.getName() != null) {
				if (contentMaster.getName().length() > 0) {
					content.setName(contentMaster.getName());
				}
			}
			//if (contentMaster.getCode() != null) {
				//if (contentMaster.getCode().length() > 0) {
					content.setCode(contentMaster.getCode());
				//}
			//}

			content.setUpdatedDate(currentDate);
			content.setUpdatedBy(contentMaster.getUpdatedBy());
			em.merge(content);

			em.getTransaction().commit();
			//status = ReturnConstant.SUCCESS;
			result=content.getId();
			if (result >0) {
				
				responseObj.setStatus(ReturnConstant.SUCCESS);
				responseObj.setId(result);
				responseObj.setReason("Content updated successfully");
				
			} else {
				
				responseObj.setStatus(ReturnConstant.FAILURE);
				responseObj.setId(result);
				responseObj.setReason("Content not updated successfully.");
				
			}
			//logger.info("Content updated successfully");
			/*}
			else {
				responseObj.setStatus(ReturnConstant.FAILURE);
				responseObj.setId(result);
				responseObj.setReason("Content not updated successfully.");
			}*/
		} catch (Exception e) {
			e.printStackTrace();
			responseObj.setStatus(ReturnConstant.FAILURE);
			responseObj.setId(0);
			responseObj.setReason("Content not updated successfully.");
			throw new DAOException("Check data to be updated", e);
		} finally {
			if(em != null) em.close();
		}
		return responseObj;
	}

	@Override
	public String deleteBrand(String id) throws DAOException {
		EntityManager em = null;
		BrandMaster brand1 = null;
		List<ItemMaster> items = null;
		String status = "";
		try {
			int id1 = Integer.parseInt(id);
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();

			// check if any item exists for this brand
			Query qry1 = em
					.createQuery("SELECT i FROM ItemMaster i WHERE i.brandId=:brandId and i.isDeleted=:isDeleted");

			qry1.setParameter("brandId", id1);
			qry1.setParameter("isDeleted", 0);
			items = (List<ItemMaster>) qry1.getResultList();

			if (items != null)
				if (items.size() > 0) {
					throw new DAOException();
				} else if (items.size() == 0) {
					brand1 = em.find(BrandMaster.class, id1);
					em.remove(brand1);
					em.getTransaction().commit();
					status = ReturnConstant.SUCCESS;
				}

			//logger.info("Brand deleted successfully");
		} catch (DAOException e) {
			status = ReturnConstant.MSG_DELETE_ERROR_ITEM_EXISTS;

		} catch (Exception e) {
			e.printStackTrace();
			status = ReturnConstant.FAILURE;
			throw new DAOException("Check data to be deleted", e);
		}

		finally {
			if(em != null) em.close();
		}
		return status;
	}

	@Override
	public String deleteDoctor(String id) throws DAOException {
		EntityManager em = null;
		DoctorMaster doctor = null;
		String status = "";
		try {
			int id1 = Integer.parseInt(id);
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();

			doctor = em.find(DoctorMaster.class, id1);
			em.remove(doctor);
			em.getTransaction().commit();
			status = ReturnConstant.SUCCESS;

			//logger.info("doctor deleted successfully");
		} catch (Exception e) {
			e.printStackTrace();
			status = ReturnConstant.FAILURE;
			throw new DAOException("Check data to be deleted", e);
		}

		finally {
			if(em != null) em.close();
		}
		return status;
	}
	
	@Override
	public String deleteCustomer(String id) throws DAOException {
		EntityManager em = null;
		CustomerMaster cust = null;
		String status = "";
		boolean isDataExist=false;
		try {
			int id1 = Integer.parseInt(id);
			String qryStr="%cust%_id";
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();
			
			//get all tables with column name like '%cust%_id'
		
			isDataExist = Util.checkChildTableDataExist(id,qryStr);

			if(!isDataExist){
				cust = em.find(CustomerMaster.class, id1);
				em.remove(cust);
				em.getTransaction().commit();
				status = ReturnConstant.SUCCESS;
				//logger.info("customer deleted successfully");
			}
			else if(isDataExist){
				status = ReturnConstant.FAILURE;
			}

			
		}
		catch (DAOException e) {
			e.printStackTrace();
			status = ReturnConstant.FAILURE;
			
		} 
		catch (Exception e) {
			e.printStackTrace();
			status = ReturnConstant.FAILURE;
			throw new DAOException("Check data to be deleted", e);
		}

		finally {
			if(em != null) em.close();
		}
		return status;
	}

	@Override
	public String deleteItem(CommonResultSetMapper mapper) throws DAOException {
		EntityManager em = null;
		Connection connection = null;
		CallableStatement callableStatement = null;
		String result = null;
		try {
			int itemId = mapper.getItemId();
			int storeId = mapper.getStoreId();
			int cmpnyId = mapper.getCompanyId();

			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();
			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();
			connection = sessionFactory.getConnectionProvider().getConnection();
			callableStatement = connection
					.prepareCall(StoredProcedures.PROC_DELETE_ITEM);
			callableStatement.setInt(1, cmpnyId);
			callableStatement.setInt(2, storeId);
			callableStatement.setInt(3, itemId);

			callableStatement.registerOutParameter(4, java.sql.Types.INTEGER);

			callableStatement.execute();
			result = "" + callableStatement.getInt(4);

		} catch (Exception e) {
			e.printStackTrace();
			result = ReturnConstant.FAILURE;
			throw new DAOException("Check data to be deleted", e);
		}

		finally {
			try {
				
				if(callableStatement != null) callableStatement.close();
				if(connection != null) connection.close(); 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(em != null) em.close();
		}
		return result;
	}
	
	@Override
	public ResponseObj deleteCustomer(CommonResultSetMapper mapper) throws DAOException {
		EntityManager em = null;
		Connection connection = null;
		CallableStatement callableStatement = null;
		int result = 0;
		ResponseObj responseObj=new ResponseObj();
		try {
			int custid = mapper.getCustId();
			int storeId = mapper.getStoreId();
			int cmpnyId = mapper.getCompanyId();

			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();
			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();
			connection = sessionFactory.getConnectionProvider().getConnection();
			callableStatement = connection
					.prepareCall(StoredProcedures.PROC_DELETE_CUSTOMER);
			callableStatement.setInt(1, cmpnyId);
			callableStatement.setInt(2, storeId);
			callableStatement.setInt(3, custid);

			callableStatement.registerOutParameter(4, java.sql.Types.INTEGER);

			callableStatement.execute();
			result = callableStatement.getInt(4);
			
			if (result >0) {
				
				responseObj.setStatus(ReturnConstant.SUCCESS);
				responseObj.setId(result);
				responseObj.setReason("customer deleted successfully.");
				
			} else {
				
				responseObj.setStatus(ReturnConstant.FAILURE);
				responseObj.setId(result);
				responseObj.setReason("customer not deleted successfully.");
				
			}

		} catch (Exception e) {
			e.printStackTrace();
			responseObj.setStatus(ReturnConstant.FAILURE);
			responseObj.setId(0);
			responseObj.setReason("customer not deleted successfully.");
			throw new DAOException("Check data to be deleted", e);
		}

		finally {
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
	public ResponseObj deleteDistributorByProc(CommonResultSetMapper mapper) throws DAOException {
		EntityManager em = null;
		Connection connection = null;
		CallableStatement callableStatement = null;
		int result = 0;
		ResponseObj responseObj=new ResponseObj();
		try {
			int distid = mapper.getDistributorId();
			int storeId = mapper.getStoreId();
			int cmpnyId = mapper.getCompanyId();

			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();
			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();
			connection = sessionFactory.getConnectionProvider().getConnection();
			callableStatement = connection
					.prepareCall(StoredProcedures.PROC_DELETE_DISTRIBUTOR);
			callableStatement.setInt(1, cmpnyId);
			callableStatement.setInt(2, storeId);
			callableStatement.setInt(3, distid);

			callableStatement.registerOutParameter(4, java.sql.Types.INTEGER);

			callableStatement.execute();
			result = callableStatement.getInt(4);
			
			if (result >0) {
				
				responseObj.setStatus(ReturnConstant.SUCCESS);
				responseObj.setId(result);
				responseObj.setReason("distributor deleted successfully.");
				
			} else {
				
				responseObj.setStatus(ReturnConstant.FAILURE);
				responseObj.setId(result);
				responseObj.setReason("distributor not deleted successfully.");
				
			}

		} catch (Exception e) {
			e.printStackTrace();
			responseObj.setStatus(ReturnConstant.FAILURE);
			responseObj.setId(0);
			responseObj.setReason("distributor not deleted successfully.");
			throw new DAOException("Check data to be deleted", e);
		}

		finally {
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
	public String deleteExpiry(CommonResultSetMapper mapper) throws DAOException {
		EntityManager em = null;
		Connection connection = null;
		CallableStatement callableStatement = null;
		String result = null;
		try {
			int expId = mapper.getExpiryId();
			int storeId = mapper.getStoreId();
			int cmpnyId = mapper.getCompanyId();
			int delBy = mapper.getDeletedBy();

			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();
			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();
			connection = sessionFactory.getConnectionProvider().getConnection();
			callableStatement = connection
					.prepareCall(StoredProcedures.PROC_DELETE_EXPIRY);
			callableStatement.setInt(1, cmpnyId);
			callableStatement.setInt(2, storeId);
			callableStatement.setInt(3, expId);
			callableStatement.setInt(4, delBy);

			callableStatement.registerOutParameter(5, java.sql.Types.INTEGER);

			callableStatement.execute();
			result = "" + callableStatement.getInt(5);

		} catch (Exception e) {
			e.printStackTrace();
			result = ReturnConstant.FAILURE;
			throw new DAOException("Check data to be deleted", e);
		}

		finally {
			try {
				
				if(callableStatement != null) callableStatement.close();
				if(connection != null) connection.close(); 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(em != null) em.close();
		}
		return result;
	}
	
	@Override
	public String postExpiry(CommonResultSetMapper mapper) throws DAOException {
		EntityManager em = null;
		Connection connection = null;
		CallableStatement callableStatement = null;
		String result = null;
		try {
			int expId = mapper.getExpiryId();
			int storeId = mapper.getStoreId();
			int cmpnyId = mapper.getCompanyId();
			
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();
			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();
			connection = sessionFactory.getConnectionProvider().getConnection();
			callableStatement = connection
					.prepareCall(StoredProcedures.PROC_POST_EXPIRY);
			callableStatement.setInt(1, cmpnyId);
			callableStatement.setInt(2, storeId);
			callableStatement.setInt(3, expId);
			
			callableStatement.registerOutParameter(4, java.sql.Types.INTEGER);

			callableStatement.execute();
			result = "" + callableStatement.getInt(4);

		} catch (Exception e) {
			e.printStackTrace();
			result = ReturnConstant.FAILURE;
			throw new DAOException("Check data to be posted", e);
		}

		finally {
			try {
				
				if(callableStatement != null) callableStatement.close();
				if(connection != null) connection.close(); 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(em != null) em.close();
		}
		return result;
	}

	@Override
	public String deleteDistributor(String id) throws DAOException {
		EntityManager em = null;
		DistributorMaster dist = null;
		String status = "";
		boolean isDataExist=false;
		try {
			int id1 = Integer.parseInt(id);
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();
			String qryStr="%dist%_id";
			
			//get all tables with column name like '%dist%_id'
			
			isDataExist = Util.checkChildTableDataExist(id,qryStr);

			if(!isDataExist){
				dist = em.find(DistributorMaster.class, id1);
				em.remove(dist);
				em.getTransaction().commit();
				status = ReturnConstant.SUCCESS;
			
			}
			else if(isDataExist){
				status = ReturnConstant.FAILURE;
			}
			
		}
		catch (DAOException e) {
			e.printStackTrace();
			status = ReturnConstant.FAILURE;
			
		}
		catch (Exception e) {
			e.printStackTrace();
			status = ReturnConstant.FAILURE;
			throw new DAOException("Check data to be inserted", e);
		}
		finally {
			if(em != null) em.close();
		}
		return status;
	}

	/*private boolean checkChildDataExist(String id, EntityManager em,
			String qryStr) {
		boolean isDataExist=false;
		String queryStr="SELECT TABLE_NAME, COLUMN_NAME FROM INFORMATION_SCHEMA.COLUMNS WHERE COLUMN_NAME LIKE '"+qryStr+"'";
		Query query1 = em.createNativeQuery(queryStr);
		
		List<Object> resultList=query1.getResultList();
		Iterator<Object> it=resultList.iterator();
		while (it.hasNext()) {
			Object[] row = (Object[]) it.next();
			
			String tablName=(String)row[0];
			String colName=(String)row[1];
			
			//check if data exists
			String queryStr1="SELECT * FROM "+ tablName+" where "+colName+"="+id;
			Query query2 = em.createNativeQuery(queryStr1);
			List<Object> resultList1=query2.getResultList();
			if(resultList1.size()>0){
				isDataExist=true;
				break;
			}
			
		}
		return isDataExist;
	}*/

	@Override
	public String deleteSchedule(String id) throws DAOException {
		EntityManager em = null;
		ScheduleMaster schule = null;
		List<ItemMaster> items = null;
		String status = "";
		try {
			int id1 = Integer.parseInt(id);
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();

			// check if any item exists for this brand
			Query qry1 = em
					.createQuery("SELECT i FROM ItemMaster i WHERE i.scheduleId=:scheduleId and i.isDeleted=:isDeleted");

			qry1.setParameter("scheduleId", id1);
			qry1.setParameter("isDeleted", 0);
			items = (List<ItemMaster>) qry1.getResultList();

			if (items != null)
				if (items.size() > 0) {
					throw new DAOException();
				} else if (items.size() == 0) {
					schule = em.find(ScheduleMaster.class, id1);
					em.remove(schule);

					em.getTransaction().commit();
					status = ReturnConstant.SUCCESS;
				}

			//logger.info("schedule deleted successfully");
		} catch (DAOException e) {
			status = ReturnConstant.MSG_DELETE_ERROR_ITEM_EXISTS;

		} catch (Exception e) {
			e.printStackTrace();
			status = ReturnConstant.FAILURE;
			throw new DAOException("Check data to be deleted", e);
		}

		finally {
			if(em != null) em.close();
		}
		return status;
	}

	@Override
	public String deleteGroup(String id) throws DAOException {
		EntityManager em = null;
		GroupMaster grp = null;
		List<ItemMaster> items = null;
		String status = "";
		try {
			int id1 = Integer.parseInt(id);
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();

			// check if any item exists for this group
			Query qry1 = em
					.createQuery("SELECT i FROM ItemMaster i WHERE i.groupId=:groupId and i.isDeleted=:isDeleted");

			qry1.setParameter("groupId", id1);
			qry1.setParameter("isDeleted", 0);
			items = (List<ItemMaster>) qry1.getResultList();

			if (items != null)
				if (items.size() > 0) {
					throw new DAOException();
				} else if (items.size() == 0) {
					grp = em.find(GroupMaster.class, id1);
					em.remove(grp);

					em.getTransaction().commit();
					status = ReturnConstant.SUCCESS;
				}

			//logger.info("Group deleted successfully");
		} catch (DAOException e) {
			status = ReturnConstant.MSG_DELETE_ERROR_ITEM_EXISTS;

		} catch (Exception e) {
			e.printStackTrace();
			status = ReturnConstant.FAILURE;
			throw new DAOException("Check data to be deleted", e);
		}

		finally {
			if(em != null) em.close();
		}
		return status;
	}

	@Override
	public String deleteRack(String id) throws DAOException {
		EntityManager em = null;
		RackMaster rack = null;
		String status = "";
		try {
			int id1 = Integer.parseInt(id);
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();

			rack = em.find(RackMaster.class, id1);
			em.remove(rack);

			em.getTransaction().commit();
			status = ReturnConstant.SUCCESS;

			//logger.info("Rack deleted successfully");
		} catch (Exception e) {
			e.printStackTrace();
			status = ReturnConstant.FAILURE;
			throw new DAOException("Check data to be inserted", e);
		} finally {
			if(em != null) em.close();
		}
		return status;
	}

	@Override
	public String deleteUnit(String id) throws DAOException {
		EntityManager em = null;
		UnitMaster unit = null;
		List<ItemMaster> items = null;
		String status = "";
		try {
			int id1 = Integer.parseInt(id);
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();

			// check if any item exists for this unit
			Query qry1 = em
					.createQuery("SELECT i FROM ItemMaster i WHERE i.packUnitId=:packUnitId and i.isDeleted=:isDeleted");

			qry1.setParameter("packUnitId", id1);
			qry1.setParameter("isDeleted", 0);
			items = (List<ItemMaster>) qry1.getResultList();

			if (items != null)
				if (items.size() > 0) {
					throw new DAOException();
				} else if (items.size() == 0) {
					unit = em.find(UnitMaster.class, id1);
					em.remove(unit);

					em.getTransaction().commit();
					status = ReturnConstant.SUCCESS;
				}

			//logger.info("Unit deleted successfully");
		} catch (DAOException e) {
			status = ReturnConstant.MSG_DELETE_ERROR_ITEM_EXISTS;

		} catch (Exception e) {
			e.printStackTrace();
			status = ReturnConstant.FAILURE;
			throw new DAOException("Check data to be deleted", e);
		}

		finally {
			if(em != null) em.close();
		}
		return status;
	}

	@Override
	public String deleteCategory(String id) throws DAOException {
		EntityManager em = null;
		CategoryMaster categ = null;
		List<ItemMaster> items = null;
		List<SubCategoryMaster> subCats = null;
		String status = "";
		boolean isItemExist = false;
		boolean isSubcatExist = false;
		try {
			int id1 = Integer.parseInt(id);
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();

			// check if any item exists for this category
			Query qry1 = em
					.createQuery("SELECT i FROM ItemMaster i WHERE i.categoryId=:categoryId and i.isDeleted=:isDeleted");

			qry1.setParameter("categoryId", id1);
			qry1.setParameter("isDeleted", 0);
			items = (List<ItemMaster>) qry1.getResultList();

			// check if any sub cat exists for this category
			Query qry2 = em
					.createQuery("SELECT s FROM SubCategoryMaster s WHERE s.categoryId=:categoryId and s.isDeleted=:isDeleted");

			qry2.setParameter("categoryId", id1);
			qry2.setParameter("isDeleted", 0);
			subCats = (List<SubCategoryMaster>) qry2.getResultList();

			if (items != null)
				if (items.size() > 0) {
					isItemExist = true;

				}
			if (subCats != null)
				if (subCats.size() > 0) {
					isSubcatExist = true;

				}
			if (isItemExist || isSubcatExist) {
				throw new DAOException();
			}

			if (items.size() == 0 && subCats.size() == 0) {
				/*
				 * Query qry = em .createQuery(
				 * "SELECT c FROM CategoryMaster c WHERE c.id=:id and c.isDeleted=:isDeleted"
				 * );
				 * 
				 * qry.setParameter("id", id1); qry.setParameter("isDeleted",
				 * 0); categ = (CategoryMaster) qry.getSingleResult();
				 * categ.setIsDeleted(1); em.merge(categ);
				 */

				categ = em.find(CategoryMaster.class, id1);
				em.remove(categ);

				em.getTransaction().commit();
				status = ReturnConstant.SUCCESS;
			}

			//logger.info("Category deleted successfully");
		} catch (DAOException e) {
			if (isItemExist)
				status = ReturnConstant.MSG_DELETE_ERROR_ITEM_EXISTS;
			else if (isSubcatExist) {
				status = ReturnConstant.MSG_DELETE_ERROR_SUB_CAT_EXISTS;
			} else if (isSubcatExist && isItemExist) {
				status = ReturnConstant.MSG_DELETE_ERROR_ITEM_SUB_CAT_EXISTS;
			}

		} catch (Exception e) {
			e.printStackTrace();
			status = ReturnConstant.FAILURE;
			throw new DAOException("Check data to be deleted", e);
		}

		finally {
			if(em != null) em.close();
		}
		return status;
	}

	@Override
	public String deleteSubCategory(String id) throws DAOException {
		EntityManager em = null;
		SubCategoryMaster categ = null;
		List<ItemMaster> items = null;
		String status = "";
		boolean isItemExist = false;

		try {
			int id1 = Integer.parseInt(id);
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();

			// check if any item exists for this sub category
			Query qry1 = em
					.createQuery("SELECT i FROM ItemMaster i WHERE i.subCategoryId=:subCategoryId and i.isDeleted=:isDeleted");

			qry1.setParameter("subCategoryId", id1);
			qry1.setParameter("isDeleted", 0);
			items = (List<ItemMaster>) qry1.getResultList();

			if (items != null)
				if (items.size() > 0) {
					isItemExist = true;
					throw new DAOException();

				}

			if (items.size() == 0) {
				/*
				 * Query qry = em .createQuery(
				 * "SELECT s FROM SubCategoryMaster s WHERE s.id=:id and s.isDeleted=:isDeleted"
				 * );
				 * 
				 * qry.setParameter("id", id1); qry.setParameter("isDeleted",
				 * 0); categ = (SubCategoryMaster) qry.getSingleResult();
				 * categ.setIsDeleted(1); em.merge(categ);
				 */

				categ = em.find(SubCategoryMaster.class, id1);
				em.remove(categ);

				em.getTransaction().commit();
				status = ReturnConstant.SUCCESS;
			}

			//logger.info("SubCategory deleted successfully");
		} catch (DAOException e) {
			if (isItemExist)
				status = ReturnConstant.MSG_DELETE_ERROR_ITEM_EXISTS;

		} catch (Exception e) {
			e.printStackTrace();
			status = ReturnConstant.FAILURE;
			throw new DAOException("Check data to be deleted", e);
		}

		finally {
			if(em != null) em.close();
		}
		return status;
	}

	@Override
	public String deleteManufacturer(String id) throws DAOException {
		EntityManager em = null;
		ManufacturerMaster manufacturer = null;
		List<ItemMaster> items = null;
		String status = "";
		try {
			int id1 = Integer.parseInt(id);
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();

			// check if any item exists for this manufacturer
			Query qry1 = em
					.createQuery("SELECT i FROM ItemMaster i WHERE i.manufacturerId=:manufacturerId and i.isDeleted=:isDeleted");

			qry1.setParameter("manufacturerId", id1);
			qry1.setParameter("isDeleted", 0);
			items = (List<ItemMaster>) qry1.getResultList();

			if (items != null)
				if (items.size() > 0) {
					throw new DAOException();
				} else if (items.size() == 0) {

					manufacturer = em.find(ManufacturerMaster.class, id1);
					em.remove(manufacturer);
					em.getTransaction().commit();
					status = ReturnConstant.SUCCESS;
				}

			//logger.info("Manufacturer deleted successfully");
		} catch (DAOException e) {
			status = ReturnConstant.MSG_DELETE_ERROR_ITEM_EXISTS;

		} catch (Exception e) {
			e.printStackTrace();
			status = ReturnConstant.FAILURE;
			throw new DAOException("Check data to be deleted", e);
		}

		finally {
			if(em != null) em.close();
		}
		return status;
	}
	
	@Override
	public String deleteMarketer(String id) throws DAOException {
		EntityManager em = null;
		MarketerMaster marketerMaster = null;
		List<ItemMaster> items = null;
		String status = "";
		try {
			int id1 = Integer.parseInt(id);
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();

			// check if any item exists for this marketer
			Query qry1 = em
					.createQuery("SELECT i FROM ItemMaster i WHERE i.marketerId=:marketerId and i.isDeleted=:isDeleted");

			qry1.setParameter("marketerId", id1);
			qry1.setParameter("isDeleted", 0);
			items = (List<ItemMaster>) qry1.getResultList();

			if (items != null)
				if (items.size() > 0) {
					throw new DAOException();
				} else if (items.size() == 0) {

					marketerMaster = em.find(MarketerMaster.class, id1);
					em.remove(marketerMaster);
					em.getTransaction().commit();
					status = ReturnConstant.SUCCESS;
				}

			//logger.info("marketer deleted successfully");
		} catch (DAOException e) {
			status = ReturnConstant.MSG_DELETE_ERROR_ITEM_EXISTS;

		} catch (Exception e) {
			e.printStackTrace();
			status = ReturnConstant.FAILURE;
			throw new DAOException("Check data to be deleted", e);
		}

		finally {
			if(em != null) em.close();
		}
		return status;
	}

	@Override
	public String deleteContent(String id) throws DAOException {
		EntityManager em = null;
		ContentMaster content1 = null;
		List<ItemMaster> items = null;
		String status = "";
		try {
			int id1 = Integer.parseInt(id);
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();

			// check if any item exists for this content
			Query qry1 = em
					.createQuery("SELECT i FROM ItemMaster i WHERE i.contentId=:contentId and i.isDeleted=:isDeleted");

			qry1.setParameter("contentId", id1);
			qry1.setParameter("isDeleted", 0);
			items = (List<ItemMaster>) qry1.getResultList();

			if (items != null)
				if (items.size() > 0) {
					throw new DAOException();
				} else if (items.size() == 0) {
					content1 = em.find(ContentMaster.class, id1);
					em.remove(content1);

					em.getTransaction().commit();
					status = ReturnConstant.SUCCESS;
				}

			//logger.info("Content deleted successfully");
		} catch (DAOException e) {
			status = ReturnConstant.MSG_DELETE_ERROR_ITEM_EXISTS;

		} catch (Exception e) {
			e.printStackTrace();
			status = ReturnConstant.FAILURE;
			throw new DAOException("Check data to be deleted", e);
		}

		finally {
			if(em != null) em.close();
		}
		return status;
	}

	@Override
	public List<BrandMaster> getBrands(String cmpnyId) throws DAOException {

		List<BrandMaster> brands = null;
		EntityManager em = null;

		try {
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();

			int cmpnyId1 = Integer.parseInt(cmpnyId);
			Query qry = em
					.createQuery("SELECT b FROM BrandMaster b WHERE b.companyId=:companyId and b.isDeleted=0");

			qry.setParameter("companyId", cmpnyId1);
			brands = (List<BrandMaster>) qry.getResultList();
			//logger.info("Brands fetched");

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("In DAOException", e);

		} finally {
			if(em != null) em.close();
		}

		return brands;
	}
	
	@Override
	public List<DoctorMaster> getDoctors(String cmpnyId) throws DAOException {

		List<DoctorMaster> docs = null;
		EntityManager em = null;

		try {
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();

			int cmpnyId1 = Integer.parseInt(cmpnyId);
			Query qry = em
					.createQuery("SELECT b FROM DoctorMaster b WHERE b.companyId=:companyId and b.isDeleted=0");

			qry.setParameter("companyId", cmpnyId1);
			docs = (List<DoctorMaster>) qry.getResultList();
			//logger.info("doctors fetched");

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("In DAOException", e);

		} finally {
			if(em != null) em.close();
		}

		return docs;
	}
	
	@Override
	public List<CustomerMaster> getCustomers(String cmpnyId) throws DAOException {

		List<CustomerMaster> cust = null;
		EntityManager em = null;

		try {
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();

			int cmpnyId1 = Integer.parseInt(cmpnyId);
			Query qry = em
					.createQuery("SELECT b FROM CustomerMaster b WHERE b.companyId=:companyId and b.isDeleted=0");

			qry.setParameter("companyId", cmpnyId1);
			cust = (List<CustomerMaster>) qry.getResultList();
			//logger.info("customers fetched");

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("In DAOException", e);

		} finally {
			if(em != null) em.close();
		}

		return cust;
	}
	
	@Override
	public List<GenderMaster> getGenders(CommonResultSetMapper mapper) throws DAOException {

		List<GenderMaster> gend = null;
		EntityManager em = null;

		try {
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();
		
			Query qry = em
					.createQuery("SELECT b FROM GenderMaster b order by b.id");
			
			gend = (List<GenderMaster>) qry.getResultList();
			//logger.info("genders fetched");

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("In DAOException", e);

		} finally {
			if(em != null) em.close();
		}

		return gend;
	}

	@Override
	public List<DistributorMaster> getDistributors(String cmpnyId)
			throws DAOException {

		List<DistributorMaster> dists = null;
		EntityManager em = null;

		try {
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();

			int cmpnyId1 = Integer.parseInt(cmpnyId);
			Query qry = em
					.createQuery("SELECT d FROM DistributorMaster d WHERE d.companyId=:companyId and d.isDeleted=0");

			qry.setParameter("companyId", cmpnyId1);
			dists = (List<DistributorMaster>) qry.getResultList();
			//logger.info("distributors fetched");

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("In DAOException", e);

		} finally {
			if(em != null) em.close();
		}

		return dists;
	}

	@Override
	public int checkDuplicateItem(String name, String id) throws DAOException {

		int result = 1;
		EntityManager em = null;
		Connection connection = null;
		CallableStatement callableStatement = null;

		try {
			int id1 = Integer.parseInt(id);
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();
			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();
			connection = sessionFactory.getConnectionProvider().getConnection();

			callableStatement = connection
					.prepareCall(StoredProcedures.PROC_CHK_DUPLICATE_ITEM);
			callableStatement.setInt(1, id1);
			callableStatement.setString(2, name);
			callableStatement.registerOutParameter(3, java.sql.Types.INTEGER);

			callableStatement.execute();
			result = callableStatement.getInt(3);
			//logger.info("Duplicate item checked");

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

		return result;
	}

	@Override
	public List<BrandDTO> getBrandsProc(String cmpnyId) throws DAOException {

		List<BrandDTO> brands = new ArrayList<BrandDTO>();
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
					.prepareCall(StoredProcedures.PROC_GET_ALL_BRANDS);
			callableStatement.setInt(1, 0);
			callableStatement.setInt(2, 0);
			callableStatement.setString(3, null);
			callableStatement.setString(4, null);
			callableStatement.execute();
			rs = callableStatement.getResultSet();

			ReflectionResultSetMapper<BrandDTO> resultSetMapper1 = new ReflectionResultSetMapper<BrandDTO>(
					BrandDTO.class);

			while (rs.next()) {
				BrandDTO brandDTO = resultSetMapper1.mapRow(rs);
				brands.add(brandDTO);

			}

			//logger.info("Brands fetched");

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

		return brands;
	}
	
	@Override
	public List<ReturnReasonTypeDTO> getReasonByReturnType(CommonResultSetMapper mapper) throws DAOException {

		List<ReturnReasonTypeDTO> types = new ArrayList<ReturnReasonTypeDTO>();
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
					.prepareCall(StoredProcedures.PROC_GET_ALL_REASON_BY_RETURN_TYPE);
			
			callableStatement.setString(1, mapper.getRetType());
			callableStatement.execute();
			rs = callableStatement.getResultSet();

			ReflectionResultSetMapper<ReturnReasonTypeDTO> resultSetMapper1 = new ReflectionResultSetMapper<ReturnReasonTypeDTO>(
					ReturnReasonTypeDTO.class);

			while (rs.next()) {
				ReturnReasonTypeDTO type = resultSetMapper1.mapRow(rs);
				types.add(type);

			}

			//logger.info("types fetched");

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

		return types;
	}
	
	@Override
	public List<DoctorMaster> getDoctorsByName(CommonResultSetMapper mapper) throws DAOException {

		List<DoctorMaster> docs = new ArrayList<DoctorMaster>();
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
					.prepareCall(StoredProcedures.PROC_GET_ALL_DOCS_BY_NAME);
			callableStatement.setInt(1, mapper.getCompanyId());
			callableStatement.setInt(2, mapper.getStoreId());
			callableStatement.setString(3, mapper.getDoctorName());
			callableStatement.setString(4, mapper.getDoctorPh());
			callableStatement.execute();
			rs = callableStatement.getResultSet();
			while (rs.next()) {
				DoctorMaster doctorMaster =new DoctorMaster();
				doctorMaster.setId(rs.getInt(1));
				doctorMaster.setName(rs.getString(2));
				doctorMaster.setPhoneNo(rs.getString(3));
				docs.add(doctorMaster);

			}

			//logger.info("doctors by name fetched");

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

		return docs;
	}
	
	@Override
	public List<ItemWithSameContentDTO> getItemSameContent(CommonResultSetMapper mapper) throws DAOException {

		List<ItemWithSameContentDTO> contentDTOs = new ArrayList<ItemWithSameContentDTO>();
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
					.prepareCall(StoredProcedures.PROC_GET_ITEMS_WITH_SAME_CONTENT);
			callableStatement.setInt(1, mapper.getCompanyId());
			callableStatement.setInt(2, mapper.getStoreId());
			callableStatement.setInt(3, mapper.getFinYrId());
			callableStatement.setInt(4, mapper.getItemId());
			
			if (mapper.getAsOnDate()!=null) {
				java.sql.Date asonDate = DateUtil.convertStringDateToSqlDate(
				mapper.getAsOnDate(), "yyyy-MM-dd");
				callableStatement.setDate(5, asonDate);
			}
			else {
				callableStatement.setDate(5, null);
			}
			
			callableStatement.execute();
			rs = callableStatement.getResultSet();

			ReflectionResultSetMapper<ItemWithSameContentDTO> resultSetMapper1 = new ReflectionResultSetMapper<ItemWithSameContentDTO>(
					ItemWithSameContentDTO.class);

			while (rs.next()) {
				ItemWithSameContentDTO contentDTO = resultSetMapper1.mapRow(rs);
				contentDTOs.add(contentDTO);

			}

			//logger.info("item with same content fetched");

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

		return contentDTOs;
	}
	
	@Override
	public List<SubcatByCatDTO> getAllSubcatByCat(CommonResultSetMapper mapper) throws DAOException {

		List<SubcatByCatDTO> byCatDTOs = new ArrayList<SubcatByCatDTO>();
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
					.prepareCall(StoredProcedures.PROC_GET_SUBCAT_BY_CAT);
			callableStatement.setInt(1, mapper.getCompanyId());
			callableStatement.setInt(2, mapper.getStoreId());
			callableStatement.setInt(3, mapper.getCatId());
		
			callableStatement.execute();
			rs = callableStatement.getResultSet();

			ReflectionResultSetMapper<SubcatByCatDTO> resultSetMapper1 = new ReflectionResultSetMapper<SubcatByCatDTO>(
					SubcatByCatDTO.class);

			while (rs.next()) {
				SubcatByCatDTO byCatDTO = resultSetMapper1.mapRow(rs);
				byCatDTOs.add(byCatDTO);

			}

			//logger.info("sub cat fetched");

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

		return byCatDTOs;
	}
	
	@Override
	public List<ItemHistoryDTO> getItemHistory(CommonResultSetMapper mapper) throws DAOException {

		List<ItemHistoryDTO> contentDTOs = new ArrayList<ItemHistoryDTO>();
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
					.prepareCall(StoredProcedures.PROC_GET_ITEM_HISTORY);
			callableStatement.setInt(1, mapper.getCompanyId());
			callableStatement.setInt(2, mapper.getStoreId());
			callableStatement.setInt(3, mapper.getFinYrId());
			callableStatement.setInt(4, mapper.getItemId());
			
			if (mapper.getFrmDate()!=null) {
				java.sql.Date frmDt = DateUtil.convertStringDateToSqlDate(
				mapper.getFrmDate(), "yyyy-MM-dd");
				callableStatement.setDate(5, frmDt);
			}
			else {
				callableStatement.setDate(5, null);
			}
			
			if (mapper.getToDate()!=null) {
				java.sql.Date toDt = DateUtil.convertStringDateToSqlDate(
				mapper.getToDate(), "yyyy-MM-dd");
				callableStatement.setDate(6, toDt);
			}
			else {
				callableStatement.setDate(6, null);
			}
			
			callableStatement.execute();
			rs = callableStatement.getResultSet();

			ReflectionResultSetMapper<ItemHistoryDTO> resultSetMapper1 = new ReflectionResultSetMapper<ItemHistoryDTO>(
					ItemHistoryDTO.class);

			while (rs.next()) {
				ItemHistoryDTO contentDTO = resultSetMapper1.mapRow(rs);
				contentDTOs.add(contentDTO);

			}

			//logger.info("item history fetched");

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

		return contentDTOs;
	}
	
	
	@Override
	public CommonResultSetMapper getItemByBarcode(CommonResultSetMapper mapper) throws DAOException {

		CommonResultSetMapper commonResultSetMapper = new CommonResultSetMapper();
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
					.prepareCall(StoredProcedures.PROC_GET_ITEM_BY_BARCODE);
			callableStatement.setInt(1, mapper.getCompanyId());
			callableStatement.setInt(2, mapper.getStoreId());
			callableStatement.setString(3, mapper.getSku());
			callableStatement.execute();
			rs = callableStatement.getResultSet();

			ReflectionResultSetMapper<CommonResultSetMapper> resultSetMapper1 = new ReflectionResultSetMapper<CommonResultSetMapper>(
					CommonResultSetMapper.class);

			while (rs.next()) {
				commonResultSetMapper= resultSetMapper1.mapRow(rs);
				commonResultSetMapper.setItemId(rs.getInt(1));
				commonResultSetMapper.setItemName(rs.getString(2));

			}

			//logger.info("item  fetched by barcode");

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

		return commonResultSetMapper;
	}
	
	@Override
	public ItemDTO getItemByName(CommonResultSetMapper mapper) throws DAOException {

		ItemDTO itemDTO = null;
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
					.prepareCall(StoredProcedures.PROC_GET_ITEM_BY_NAME);
			callableStatement.setInt(1, mapper.getCompanyId());
			callableStatement.setInt(2, mapper.getStoreId());
			callableStatement.setString(3, mapper.getItemName());
			callableStatement.execute();
			rs = callableStatement.getResultSet();

			ReflectionResultSetMapper<ItemDTO> resultSetMapper1 = new ReflectionResultSetMapper<ItemDTO>(ItemDTO.class);

			while (rs.next()) {
				itemDTO=new ItemDTO();
				itemDTO= resultSetMapper1.mapRow(rs);
				
			}

			//logger.info("item  fetched by name");

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

		return itemDTO;
	}
	
	@Override
	public AreaDTO getAreaById(CommonResultSetMapper mapper) throws DAOException {

		AreaDTO area = null;
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
					.prepareCall(StoredProcedures.PROC_GET_AREA_BY_ID);
			callableStatement.setInt(1, mapper.getCompanyId());
			callableStatement.setInt(2, mapper.getStoreId());
			callableStatement.setInt(3, mapper.getId());
						
			callableStatement.execute();
			rs = callableStatement.getResultSet();

			ReflectionResultSetMapper<AreaDTO> resultSetMapper1 = new ReflectionResultSetMapper<AreaDTO>(AreaDTO.class);

			while (rs.next()) {
				area=new AreaDTO();
				area= resultSetMapper1.mapRow(rs);
				
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

		return area;
	}
	
	@Override
	public ZoneDTO getZoneById(CommonResultSetMapper mapper) throws DAOException {

		ZoneDTO zone = null;
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
					.prepareCall(StoredProcedures.PROC_GET_ZONE_BY_ID);
			callableStatement.setInt(1, mapper.getCompanyId());
			callableStatement.setInt(2, mapper.getStoreId());
			callableStatement.setInt(3, mapper.getId());
						
			callableStatement.execute();
			rs = callableStatement.getResultSet();

			ReflectionResultSetMapper<ZoneDTO> resultSetMapper1 = new ReflectionResultSetMapper<ZoneDTO>(ZoneDTO.class);

			while (rs.next()) {
				zone=new ZoneDTO();
				zone= resultSetMapper1.mapRow(rs);
				
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

		return zone;
	}
	
	@Override
	public CityDTO getCityById(CommonResultSetMapper mapper) throws DAOException {

		CityDTO city = null;
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
					.prepareCall(StoredProcedures.PROC_GET_CITY_BY_ID);
			callableStatement.setInt(1, mapper.getId());
			
			callableStatement.execute();
			rs = callableStatement.getResultSet();

			ReflectionResultSetMapper<CityDTO> resultSetMapper1 = new ReflectionResultSetMapper<CityDTO>(CityDTO.class);

			while (rs.next()) {
				city=new CityDTO();
				city= resultSetMapper1.mapRow(rs);
				
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

		return city;
	}

	@Override
	public List<ContentMaster> getContents(String cmpnyId) throws DAOException {

		List<ContentMaster> contnts = null;
		EntityManager em = null;

		try {
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();

			int cmpnyId1 = Integer.parseInt(cmpnyId);
			Query qry = em
					.createQuery("SELECT c FROM ContentMaster c WHERE c.companyId=:companyId and c.isDeleted=0");

			qry.setParameter("companyId", cmpnyId1);
			contnts = (List<ContentMaster>) qry.getResultList();

			//logger.info("Contents fetched");

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("In DAOException", e);

		} finally {
			if(em != null) em.close();
		}

		return contnts;
	}

	@Override
	public List<ScheduleMaster> getSchedules(String cmpnyId)
			throws DAOException {

		List<ScheduleMaster> schdls = null;
		EntityManager em = null;

		try {
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();

			int cmpnyId1 = Integer.parseInt(cmpnyId);
			Query qry = em
					.createQuery("SELECT s FROM ScheduleMaster s WHERE s.companyId=:companyId and s.isDeleted=0");

			qry.setParameter("companyId", cmpnyId1);
			schdls = (List<ScheduleMaster>) qry.getResultList();

			//logger.info("schedules fetched");

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("In DAOException", e);

		} finally {
			if(em != null) em.close();
		}

		return schdls;
	}

	@Override
	public List<GroupMaster> getGroups(String cmpnyId) throws DAOException {

		List<GroupMaster> grps = null;
		EntityManager em = null;

		try {
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();

			int cmpnyId1 = Integer.parseInt(cmpnyId);
			Query qry = em
					.createQuery("SELECT g FROM GroupMaster g WHERE g.companyId=:companyId and g.isDeleted=0");

			qry.setParameter("companyId", cmpnyId1);
			grps = (List<GroupMaster>) qry.getResultList();

			//logger.info("groups fetched");

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("In DAOException", e);

		} finally {
			if(em != null) em.close();
		}

		return grps;
	}

	@Override
	public List<RackMaster> getRacks(String cmpnyId) throws DAOException {

		List<RackMaster> racks = null;
		EntityManager em = null;

		try {
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();

			int cmpnyId1 = Integer.parseInt(cmpnyId);
			Query qry = em
					.createQuery("SELECT r FROM RackMaster r WHERE r.companyId=:companyId and r.isDeleted=0");

			qry.setParameter("companyId", cmpnyId1);
			racks = (List<RackMaster>) qry.getResultList();

			//logger.info("Racks fetched");

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("In DAOException", e);

		} finally {
			if(em != null) em.close();
		}

		return racks;
	}

	@Override
	public List<CategoryMaster> getCategories(String cmpnyId)
			throws DAOException {

		List<CategoryMaster> cats = null;
		EntityManager em = null;

		try {
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();

			int cmpnyId1 = Integer.parseInt(cmpnyId);
			Query qry = em
					.createQuery("SELECT c FROM CategoryMaster c WHERE c.companyId=:companyId and c.isDeleted=0");

			qry.setParameter("companyId", cmpnyId1);
			cats = (List<CategoryMaster>) qry.getResultList();

			//logger.info("Categories fetched");

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("In DAOException", e);

		} finally {
			if(em != null) em.close();
		}

		return cats;
	}

	@Override
	public List<SubCategoryMaster> getSubCategories(String cmpnyId)
			throws DAOException {

		List<SubCategoryMaster> subcats = null;
		EntityManager em = null;

		try {
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();

			int cmpnyId1 = Integer.parseInt(cmpnyId);
			Query qry = em
					.createQuery("SELECT s FROM SubCategoryMaster s WHERE s.companyId=:companyId and s.isDeleted=0");

			qry.setParameter("companyId", cmpnyId1);
			subcats = (List<SubCategoryMaster>) qry.getResultList();

			//logger.info("sub Categories fetched");

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("In DAOException", e);

		} finally {
			if(em != null) em.close();
		}

		return subcats;
	}

	@Override
	public List<ManufacturerMaster> getManufacturers(String cmpnyId)
			throws DAOException {

		List<ManufacturerMaster> manufcturers = null;
		EntityManager em = null;

		try {
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();

			int cmpnyId1 = Integer.parseInt(cmpnyId);
			Query qry = em
					.createQuery("SELECT m FROM ManufacturerMaster m WHERE m.companyId=:companyId and m.isDeleted=0");

			qry.setParameter("companyId", cmpnyId1);
			manufcturers = (List<ManufacturerMaster>) qry.getResultList();

			//logger.info("Manufacturers fetched");

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("In DAOException", e);

		} finally {
			if(em != null) em.close();
		}

		return manufcturers;
	}
	
	@Override
	public List<MarketerMaster> getMarketers(String cmpnyId)
			throws DAOException {

		List<MarketerMaster> marketers = null;
		EntityManager em = null;

		try {
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();

			int cmpnyId1 = Integer.parseInt(cmpnyId);
			Query qry = em
					.createQuery("SELECT m FROM MarketerMaster m WHERE m.companyId=:companyId and m.isDeleted=0");

			qry.setParameter("companyId", cmpnyId1);
			marketers = (List<MarketerMaster>) qry.getResultList();

			//logger.info("marketers fetched");

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("In DAOException", e);

		} finally {
			if(em != null) em.close();
		}

		return marketers;
	}

	@Override
	public List<UnitMaster> getUnits(String cmpnyId) throws DAOException {

		List<UnitMaster> units = null;
		EntityManager em = null;

		try {
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();

			int cmpnyId1 = Integer.parseInt(cmpnyId);
			Query qry = em
					.createQuery("SELECT u FROM UnitMaster u WHERE u.companyId=:companyId and u.isDeleted=0");

			qry.setParameter("companyId", cmpnyId1);
			units = (List<UnitMaster>) qry.getResultList();

			//logger.info("units fetched");

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("In DAOException", e);

		} finally {
			if(em != null) em.close();
		}

		return units;
	}

	@Override
	public BrandMaster getBrand(String id) throws DAOException {

		BrandMaster brand = null;
		EntityManager em = null;

		try {
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();

			int id1 = Integer.parseInt(id);
			Query qry = em
					.createQuery("SELECT b FROM BrandMaster b WHERE b.id=:id and b.isDeleted=0");

			qry.setParameter("id", id1);
			brand = (BrandMaster) qry.getSingleResult();

			//logger.info("Brand fetched");

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("In DAOException", e);

		} finally {
			if(em != null) em.close();
		}

		return brand;
	}
	
	@Override
	public List<ItemCurrentStockDTO> getCurrentStockItem(CommonResultSetMapper mapper) throws DAOException {

		List<ItemCurrentStockDTO> currentStockDTOs=new ArrayList<ItemCurrentStockDTO>();
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
					.prepareCall(StoredProcedures.PROC_GET_CURRENT_STOCK_ITEM);
			callableStatement.setInt(1, mapper.getCompanyId());
			callableStatement.setInt(2, mapper.getStoreId());
			callableStatement.setInt(3, mapper.getFinYrId());
			if (mapper.getUpToDate()!=null) {
				java.sql.Date upToDate = DateUtil.convertStringDateToSqlDate(
				mapper.getUpToDate(), "yyyy-MM-dd");
				callableStatement.setDate(4, upToDate);
			}
			else {
				callableStatement.setDate(4, null);
			}
			callableStatement.setInt(5, mapper.getItemId());
			callableStatement.setInt(6, mapper.getNoOfExpiryMonth());
			callableStatement.execute();
			
			rs = callableStatement.getResultSet();
			ReflectionResultSetMapper<ItemCurrentStockDTO> resultSetMapper = new ReflectionResultSetMapper<ItemCurrentStockDTO>(
					ItemCurrentStockDTO.class);
			while(rs.next()){
				ItemCurrentStockDTO stck = new ItemCurrentStockDTO();
				stck = resultSetMapper.mapRow(rs);
				//System.out.println("curr stk="+stck.getStockQty());	
				currentStockDTOs.add(stck);
			}
			//logger.info("current stock fetched");

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

		return currentStockDTOs;
	}
	
	@Override
	public CustomerDTO getCustomerById(CommonResultSetMapper mapper) throws DAOException {

		CustomerDTO customers=new CustomerDTO();
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
					.prepareCall(StoredProcedures.PROC_GET_CUSTOMER_BY_ID);
			callableStatement.setInt(1, mapper.getCustId());
			callableStatement.setInt(2, mapper.getCompanyId());
			callableStatement.setInt(3, mapper.getStoreId());
			callableStatement.setInt(4, mapper.getFinYrId());
			
			callableStatement.execute();
			
			rs = callableStatement.getResultSet();
			ReflectionResultSetMapper<CustomerDTO> resultSetMapper = new ReflectionResultSetMapper<CustomerDTO>(
					CustomerDTO.class);
			while(rs.next()){
				
				customers = resultSetMapper.mapRow(rs);
				
			}
			//logger.info("customer fetched");

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

		return customers;
	}
	
	@Override
	public DistributorDTO getDistributorById(CommonResultSetMapper mapper) throws DAOException {

		DistributorDTO dist=new DistributorDTO();
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
					.prepareCall(StoredProcedures.PROC_GET_DISTRIBUTOR_BY_ID);
			callableStatement.setInt(1, mapper.getDistributorId());
			callableStatement.setInt(2, mapper.getCompanyId());
			callableStatement.setInt(3, mapper.getStoreId());
			callableStatement.setInt(4, mapper.getFinYrId());
			
			callableStatement.execute();
			
			rs = callableStatement.getResultSet();
			ReflectionResultSetMapper<DistributorDTO> resultSetMapper = new ReflectionResultSetMapper<DistributorDTO>(
					DistributorDTO.class);
			while(rs.next()){
				
				dist = resultSetMapper.mapRow(rs);
				
			}
			//logger.info("distributor fetched");

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

		return dist;
	}
	
	@Override
	public List<ItemCurrentStockDTO> getCurrentStockItemBySku(CommonResultSetMapper mapper) throws DAOException {

		List<ItemCurrentStockDTO> currentStockDTOs=new ArrayList<ItemCurrentStockDTO>();
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
					.prepareCall(StoredProcedures.PROC_GET_CURRENT_STOCK_ITEM_BY_SKU);
			callableStatement.setInt(1, mapper.getCompanyId());
			callableStatement.setInt(2, mapper.getStoreId());
			callableStatement.setInt(3, mapper.getFinYrId());
			if (mapper.getAsOnDate()!=null) {
				java.sql.Date asonDate = DateUtil.convertStringDateToSqlDate(
				mapper.getAsOnDate(), "yyyy-MM-dd");
				callableStatement.setDate(4, asonDate);
			}
			else {
				callableStatement.setDate(4, null);
			}
			callableStatement.setString(5, mapper.getSku());
			callableStatement.setInt(6, mapper.getNoOfExpiryMonth());
			callableStatement.execute();
			
			rs = callableStatement.getResultSet();
			ReflectionResultSetMapper<ItemCurrentStockDTO> resultSetMapper = new ReflectionResultSetMapper<ItemCurrentStockDTO>(
					ItemCurrentStockDTO.class);
			while(rs.next()){
				ItemCurrentStockDTO stck = new ItemCurrentStockDTO();
				stck = resultSetMapper.mapRow(rs);
				currentStockDTOs.add(stck);
			}
			//logger.info("current stock by sku fetched");

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

		return currentStockDTOs;
	}
	
	@Override
	public List<DistributorMaster> getDistributorsAll(CommonResultSetMapper mapper) throws DAOException {

		List<DistributorMaster> dists=new ArrayList<DistributorMaster>();
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
					.prepareCall(StoredProcedures.PROC_GET_DISTRIBUTORS_ALL);
			callableStatement.setInt(1, mapper.getCompanyId());
			callableStatement.setInt(2, mapper.getStoreId());
			callableStatement.setInt(3, mapper.getFinYrId());
			if (mapper.getAsOnDate()!=null) {
				java.sql.Date asonDate = DateUtil.convertStringDateToSqlDate(
				mapper.getAsOnDate(), "yyyy-MM-dd");
				callableStatement.setDate(4, asonDate);
			}
			else {
				callableStatement.setDate(4, null);
			}
		
			callableStatement.execute();
			
			rs = callableStatement.getResultSet();
			/*ReflectionResultSetMapper<DistributorDTO> resultSetMapper = new ReflectionResultSetMapper<DistributorDTO>(
					DistributorDTO.class);*/
			while(rs.next()){
				DistributorMaster dist = new DistributorMaster();
				dist.setId(rs.getInt(1));
				dist.setName(rs.getString(2));
				dist.setAddress(rs.getString(3));
				dist.setPin(rs.getString(4));
				dist.setCity(rs.getString(5));
				dist.setState(rs.getString(6));
				dist.setCountry(rs.getString(7));
				dist.setPhoneNo1(rs.getString(8));
				dist.setPhoneNo2(rs.getString(9));
				dist.setFax(rs.getString(10));
				dist.setEmail(rs.getString(11));
				dist.setContactPerson(rs.getString(12));
				dist.setRegistrationNo(rs.getString(13));
				dist.setDiscount(rs.getDouble(14));
				dist.setDiscountAmount(rs.getDouble(15));
				dist.setLicenceNo(rs.getString(16));
				dist.setDueDays(rs.getInt(17));
				dist.setObBal(rs.getDouble(18));
				dist.setCreditLimit(rs.getDouble(19));
				dist.setPaybleAmount(rs.getDouble(20));
				dist.setPaybleText(rs.getString(21));
				dists.add(dist);
			}
			//logger.info("all distributors fetched");

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

		return dists;
	}
	
	@Override
	public List<CustomerDTO> getCustomersAll(CommonResultSetMapper mapper) throws DAOException {
		System.out.println("getCustomersAll mapping = "+mapper);
		List<CustomerDTO> custs=new ArrayList<CustomerDTO>();
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
					.prepareCall(StoredProcedures.PROC_GET_CUSTOMERS_ALL);
			callableStatement.setInt(1, mapper.getCompanyId());
			callableStatement.setInt(2, mapper.getStoreId());
			callableStatement.setInt(3, mapper.getFinYrId());
			if (mapper.getAsOnDate()!=null) {
				java.sql.Date asonDate = DateUtil.convertStringDateToSqlDate(
				mapper.getAsOnDate(), "yyyy-MM-dd");
				callableStatement.setDate(4, asonDate);
			}
			else {
				callableStatement.setDate(4, null);
			}
		
			callableStatement.execute();
			
			rs = callableStatement.getResultSet();
			ReflectionResultSetMapper<CustomerDTO> resultSetMapper = new ReflectionResultSetMapper<CustomerDTO>(
					CustomerDTO.class);
			while(rs.next()){
				CustomerDTO cust = new CustomerDTO();
				cust = resultSetMapper.mapRow(rs);
				custs.add(cust);
			}
			//System.out.println("getAllcustomers "+custs );
			logger.info("all customers fetched");

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
		
		return custs;
	}
	
	@Override
	public List<DistributorDTO> getDistributorsAllWithOutstanding(CommonResultSetMapper mapper) throws DAOException {

		List<DistributorDTO> dists=new ArrayList<DistributorDTO>();
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
					.prepareCall(StoredProcedures.PROC_GET_DISTRIBUTORS_ALL_WITH_OUTSTANDING);
			callableStatement.setInt(1, mapper.getCompanyId());
			callableStatement.setInt(2, mapper.getStoreId());
			callableStatement.setInt(3, mapper.getFinYrId());
			if (mapper.getAsOnDate()!=null) {
				java.sql.Date asonDate = DateUtil.convertStringDateToSqlDate(
				mapper.getAsOnDate(), "yyyy-MM-dd");
				callableStatement.setDate(4, asonDate);
			}
			else {
				callableStatement.setDate(4, null);
			}
		
			callableStatement.execute();
			
			rs = callableStatement.getResultSet();
			ReflectionResultSetMapper<DistributorDTO> resultSetMapper = new ReflectionResultSetMapper<DistributorDTO>(
					DistributorDTO.class);
			while(rs.next()){
				DistributorDTO dist = new DistributorDTO();
				dist = resultSetMapper.mapRow(rs);
				dists.add(dist);
			}
			//logger.info("all distributors with outstanding fetched");

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

		return dists;
	}
	
	@Override
	public List<ItemCurrentStockDTO> getCurrentStockItemAtSale(CommonResultSetMapper mapper) throws DAOException {

		List<ItemCurrentStockDTO> currentStockDTOs=new ArrayList<ItemCurrentStockDTO>();
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
					.prepareCall(StoredProcedures.PROC_GET_CURRENT_STOCK_ITEM_AT_SALE);
			callableStatement.setInt(1, mapper.getCompanyId());
			callableStatement.setInt(2, mapper.getStoreId());
			callableStatement.setInt(3, mapper.getFinYrId());
			if (mapper.getUpToDate()!=null) {
				java.sql.Date upToDate = DateUtil.convertStringDateToSqlDate(
				mapper.getUpToDate(), "yyyy-MM-dd");
				callableStatement.setDate(4, upToDate);
			}
			else {
				callableStatement.setDate(4, null);
			}
			callableStatement.setInt(5, mapper.getItemId());
			callableStatement.setString(6, mapper.getBatchNo());
			callableStatement.setString(7, mapper.getExpiryDateFormat());
			/*if (mapper.getExpDate()!=null) {
				java.sql.Date expDate = DateUtil.convertStringDateToSqlDate(
				mapper.getExpDate(), "yyyy-MM-dd");
				callableStatement.setDate(8, expDate);
			}
			else {
				callableStatement.setDate(8, null);
			}*/
			if (mapper.getExpDate().equalsIgnoreCase("NA")) {
				callableStatement.setDate(8, null);
			}
			else {
				
				java.sql.Date expDate = DateUtil.convertStringDateToSqlDate(
						mapper.getExpDate(), "yyyy-MM-dd");
						callableStatement.setDate(8, expDate);
			}
			callableStatement.setDouble(9, mapper.getMrp());
			callableStatement.setInt(10, mapper.getSaleId());
			callableStatement.execute();
			
			rs = callableStatement.getResultSet();
			ReflectionResultSetMapper<ItemCurrentStockDTO> resultSetMapper = new ReflectionResultSetMapper<ItemCurrentStockDTO>(
					ItemCurrentStockDTO.class);
			while(rs.next()){
				ItemCurrentStockDTO stck = new ItemCurrentStockDTO();
				stck = resultSetMapper.mapRow(rs);
				currentStockDTOs.add(stck);
			}
			//logger.info("current stock at sale time fetched");

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

		return currentStockDTOs;
	}
	
	@Override
	public List<StockDetailsAdjustmentDTO> getStockDetailsForAdjustment(CommonResultSetMapper mapper) throws DAOException {

		List<StockDetailsAdjustmentDTO> adjustmentDTOs=new ArrayList<StockDetailsAdjustmentDTO>();
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
					.prepareCall(StoredProcedures.PROC_GET_STOCK_DETAILS_FOR_ADJUSTMENT);
			callableStatement.setInt(1, mapper.getCompanyId());
			callableStatement.setInt(2, mapper.getStoreId());
			callableStatement.setInt(3, mapper.getFinYrId());
			callableStatement.setInt(4, mapper.getItemId());
			callableStatement.setString(5, mapper.getBatchNo());
			callableStatement.setString(6, mapper.getExpiryDateFormat());
			callableStatement.setString(7, mapper.getHsnCode());
			callableStatement.setString(8, mapper.getBarCode());
			callableStatement.setInt(9, mapper.getDistributorId());
			if (mapper.getStartDate()!=null) {
				java.sql.Date strtDate = DateUtil.convertStringDateToSqlDate(
				mapper.getStartDate(), "yyyy-MM-dd");
				callableStatement.setDate(10, strtDate);
			}
			else {
				callableStatement.setDate(10, null);
			}
			
			if (mapper.getEndDate()!=null) {
				java.sql.Date endDate = DateUtil.convertStringDateToSqlDate(
				mapper.getEndDate(), "yyyy-MM-dd");
				callableStatement.setDate(11, endDate);
			}
			else {
				callableStatement.setDate(11, null);
			}
			
			callableStatement.execute();
			
			rs = callableStatement.getResultSet();
			ReflectionResultSetMapper<StockDetailsAdjustmentDTO> resultSetMapper = new ReflectionResultSetMapper<StockDetailsAdjustmentDTO>(
					StockDetailsAdjustmentDTO.class);
			while(rs.next()){
				StockDetailsAdjustmentDTO stck = new StockDetailsAdjustmentDTO();
				stck = resultSetMapper.mapRow(rs);
				adjustmentDTOs.add(stck);
			}
			//logger.info("stock details adjustment fetched");

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

		return adjustmentDTOs;
	}
	
	@Override
	public List<ExpiryDTO> getAllExpiryDetails(CommonResultSetMapper mapper) throws DAOException {

		List<ExpiryDTO> expiryAllDTOs=new ArrayList<ExpiryDTO>();
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
					.prepareCall(StoredProcedures.PROC_GET_EXPIRY_DETAILS_ALL);
			callableStatement.setInt(1, mapper.getCompanyId());
			callableStatement.setInt(2, mapper.getStoreId());
			callableStatement.setInt(3, mapper.getFinYrId());
			
			if (mapper.getStartDate()!=null) {
				java.sql.Date startDate = DateUtil.convertStringDateToSqlDate(
				mapper.getStartDate(), "yyyy-MM-dd");
				callableStatement.setDate(4, startDate);
			}
			else {
				callableStatement.setDate(4, null);
			}
			
			if (mapper.getEndDate()!=null) {
				java.sql.Date endDate = DateUtil.convertStringDateToSqlDate(
				mapper.getEndDate(), "yyyy-MM-dd");
				callableStatement.setDate(5, endDate);
			}
			else {
				callableStatement.setDate(5, null);
			}
			callableStatement.setString(6, mapper.getInvoiceNo());
			
			callableStatement.execute();
			
			rs = callableStatement.getResultSet();
			ReflectionResultSetMapper<ExpiryDTO> resultSetMapper = new ReflectionResultSetMapper<ExpiryDTO>(
					ExpiryDTO.class);
			while(rs.next()){
				ExpiryDTO stck = new ExpiryDTO();
				stck = resultSetMapper.mapRow(rs);
				expiryAllDTOs.add(stck);
			}
			//logger.info("get all expiry details fetched");

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

		return expiryAllDTOs;
	}
	
	@Override
	public List<ExpiryDetailsDTO> getExpiryDetailsById(CommonResultSetMapper mapper) throws DAOException {

		List<ExpiryDetailsDTO> expiryAllDTOs=new ArrayList<ExpiryDetailsDTO>();
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
					.prepareCall(StoredProcedures.PROC_GET_EXPIRY_DETAILS_BY_ID);
			callableStatement.setInt(1, mapper.getExpiryId());
			
			callableStatement.execute();
			
			rs = callableStatement.getResultSet();
			ReflectionResultSetMapper<ExpiryDetailsDTO> resultSetMapper = new ReflectionResultSetMapper<ExpiryDetailsDTO>(
					ExpiryDetailsDTO.class);
			while(rs.next()){
				ExpiryDetailsDTO exp = new ExpiryDetailsDTO();
				exp = resultSetMapper.mapRow(rs);
				expiryAllDTOs.add(exp);
			}
			//logger.info("get expiry details by id fetched");

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

		return expiryAllDTOs;
	}
	
	@Override
	public List<ExpiryDetailsDTO> getAllPendingExpiryItems(CommonResultSetMapper mapper) throws DAOException {

		List<ExpiryDetailsDTO> expiryAllDTOs=new ArrayList<ExpiryDetailsDTO>();
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
					.prepareCall(StoredProcedures.PROC_GET_ALL_PENDING_EXPIRY_LIST);
			callableStatement.setInt(1, mapper.getCompanyId());
			callableStatement.setInt(2, mapper.getStoreId());
			callableStatement.setInt(3, mapper.getFinYrId());
			callableStatement.setInt(4, mapper.getDistributorId());
			callableStatement.setInt(5, mapper.getItemId());
			
			if (mapper.getAsOnDate()!=null) {
				java.sql.Date asOndt = DateUtil.convertStringDateToSqlDate(
				mapper.getAsOnDate(), "yyyy-MM-dd");
				callableStatement.setDate(6, asOndt);
			}
			else {
				callableStatement.setDate(6, null);
			}
			
			if (mapper.getStartDate()!=null) {
				java.sql.Date startDt = DateUtil.convertStringDateToSqlDate(
				mapper.getStartDate(), "yyyy-MM-dd");
				callableStatement.setDate(7, startDt);
			}
			else {
				callableStatement.setDate(7, null);
			}
			
			if (mapper.getEndDate()!=null) {
				java.sql.Date endDate = DateUtil.convertStringDateToSqlDate(
				mapper.getEndDate(), "yyyy-MM-dd");
				callableStatement.setDate(8, endDate);
			}
			else {
				callableStatement.setDate(8, null);
			}
			
			callableStatement.execute();
			
			rs = callableStatement.getResultSet();
			ReflectionResultSetMapper<ExpiryDetailsDTO> resultSetMapper = new ReflectionResultSetMapper<ExpiryDetailsDTO>(
					ExpiryDetailsDTO.class);
			while(rs.next()){
				ExpiryDetailsDTO exp = new ExpiryDetailsDTO();
				exp = resultSetMapper.mapRow(rs);
				expiryAllDTOs.add(exp);
			}
			//logger.info("get all pending expiry fetched");

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

		return expiryAllDTOs;
	}
	
	//added on 08.07.2019
	@Override
	public List<ExpiryDetailsDTO> getAllManualExpiryItemsByItemId(CommonResultSetMapper mapper) throws DAOException {

		List<ExpiryDetailsDTO> expiryAllDTOs=new ArrayList<ExpiryDetailsDTO>();
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
					.prepareCall(StoredProcedures.PROC_GET_ALL_MANUAL_EXPIRY_LIST_BY_ITEMID);
			callableStatement.setInt(1, mapper.getCompanyId());
			callableStatement.setInt(2, mapper.getStoreId());
			callableStatement.setInt(3, mapper.getFinYrId());
			callableStatement.setInt(4, mapper.getDistributorId());
			callableStatement.setInt(5, mapper.getItemId());
			
			if (mapper.getAsOnDate()!=null) {
				java.sql.Date asOndt = DateUtil.convertStringDateToSqlDate(
				mapper.getAsOnDate(), "yyyy-MM-dd");
				callableStatement.setDate(6, asOndt);
			}
			else {
				callableStatement.setDate(6, null);
			}
			
			callableStatement.execute();
			
			rs = callableStatement.getResultSet();
			ReflectionResultSetMapper<ExpiryDetailsDTO> resultSetMapper = new ReflectionResultSetMapper<ExpiryDetailsDTO>(
					ExpiryDetailsDTO.class);
			while(rs.next()){
				ExpiryDetailsDTO exp = new ExpiryDetailsDTO();
				exp = resultSetMapper.mapRow(rs);
				expiryAllDTOs.add(exp);
			}
			//logger.info("get all manual expiry fetched by item id");

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

		return expiryAllDTOs;
	}
	
	@Override
	public List<ExpiryDetailsDTO> getAllManualExpiryItemsByItemSKU(CommonResultSetMapper mapper) throws DAOException {

		List<ExpiryDetailsDTO> expiryAllDTOs=new ArrayList<ExpiryDetailsDTO>();
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
					.prepareCall(StoredProcedures.PROC_GET_ALL_MANUAL_EXPIRY_LIST_BY_ITEMSKU);
			callableStatement.setInt(1, mapper.getCompanyId());
			callableStatement.setInt(2, mapper.getStoreId());
			callableStatement.setInt(3, mapper.getFinYrId());
			callableStatement.setInt(4, mapper.getDistributorId());
			callableStatement.setString(5, mapper.getSku());
			
			if (mapper.getAsOnDate()!=null) {
				java.sql.Date asOndt = DateUtil.convertStringDateToSqlDate(
				mapper.getAsOnDate(), "yyyy-MM-dd");
				callableStatement.setDate(6, asOndt);
			}
			else {
				callableStatement.setDate(6, null);
			}
			callableStatement.execute();
			
			rs = callableStatement.getResultSet();
			ReflectionResultSetMapper<ExpiryDetailsDTO> resultSetMapper = new ReflectionResultSetMapper<ExpiryDetailsDTO>(
					ExpiryDetailsDTO.class);
			while(rs.next()){
				ExpiryDetailsDTO exp = new ExpiryDetailsDTO();
				exp = resultSetMapper.mapRow(rs);
				expiryAllDTOs.add(exp);
			}
			//logger.info("get all manual expiry fetched by item sku");

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

		return expiryAllDTOs;
	}
	
	@Override
	public List<ItemSearchByContentDTO> getAllItemSearchByContent(CommonResultSetMapper mapper) throws DAOException {

		List<ItemSearchByContentDTO> expiryAllDTOs=new ArrayList<ItemSearchByContentDTO>();
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
					.prepareCall(StoredProcedures.PROC_GET_ALL_ITEM_SEARCH_BY_CONTENT);
			callableStatement.setInt(1, mapper.getContentId());
			callableStatement.execute();
			
			rs = callableStatement.getResultSet();
			ReflectionResultSetMapper<ItemSearchByContentDTO> resultSetMapper = new ReflectionResultSetMapper<ItemSearchByContentDTO>(
					ItemSearchByContentDTO.class);
			while(rs.next()){
				ItemSearchByContentDTO exp = new ItemSearchByContentDTO();
				exp = resultSetMapper.mapRow(rs);
				expiryAllDTOs.add(exp);
			}
			//logger.info("get all item search by content fetched");

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

		return expiryAllDTOs;
	}
	
	@Override
	public List<ItemSearchByContentDTO> getAllItemStockSearchByContent(CommonResultSetMapper mapper) throws DAOException {

		List<ItemSearchByContentDTO> expiryAllDTOs=new ArrayList<ItemSearchByContentDTO>();
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
					.prepareCall(StoredProcedures.PROC_GET_ALL_ITEM__STOCK_SEARCH_BY_CONTENT);
			callableStatement.setInt(1, mapper.getCompanyId());
			callableStatement.setInt(2, mapper.getStoreId());
			callableStatement.setInt(3, mapper.getFinYrId());
			if (mapper.getAsOnDate()!=null) {
				java.sql.Date asonDate = DateUtil.convertStringDateToSqlDate(
				mapper.getAsOnDate(), "yyyy-MM-dd");
				callableStatement.setDate(4, asonDate);
			}
			else {
				callableStatement.setDate(4, null);
			}
			callableStatement.setInt(5, mapper.getContentId());
			callableStatement.execute();
			
			rs = callableStatement.getResultSet();
			ReflectionResultSetMapper<ItemSearchByContentDTO> resultSetMapper = new ReflectionResultSetMapper<ItemSearchByContentDTO>(
					ItemSearchByContentDTO.class);
			while(rs.next()){
				ItemSearchByContentDTO exp = new ItemSearchByContentDTO();
				exp = resultSetMapper.mapRow(rs);
				expiryAllDTOs.add(exp);
			}
			//logger.info("get all item stock search by content fetched");

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

		return expiryAllDTOs;
	}
	
	@Override
	public List<ExpiryDetailsDTO> getExpiryForAdjustment(CommonResultSetMapper mapper) throws DAOException {

		List<ExpiryDetailsDTO> expiryAllDTOs=new ArrayList<ExpiryDetailsDTO>();
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
					.prepareCall(StoredProcedures.PROC_GET_EXPIRY_FOR_ADJ);
			callableStatement.setInt(1, mapper.getCompanyId());
			callableStatement.setInt(2, mapper.getStoreId());
			callableStatement.setString(3, mapper.getInvoiceNo());
			callableStatement.setInt(4, mapper.getDistributorId());
			
			callableStatement.execute();
			
			rs = callableStatement.getResultSet();
			ReflectionResultSetMapper<ExpiryDetailsDTO> resultSetMapper = new ReflectionResultSetMapper<ExpiryDetailsDTO>(
					ExpiryDetailsDTO.class);
			while(rs.next()){
				ExpiryDetailsDTO exp = new ExpiryDetailsDTO();
				exp = resultSetMapper.mapRow(rs);
				expiryAllDTOs.add(exp);
			}
			//logger.info("get expiry for adj fetched");

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

		return expiryAllDTOs;
	}
	
	@Override
	public List<ExpiryDetailsDTO> getExpiryForAdjustmentByPurchase(CommonResultSetMapper mapper) throws DAOException {

		List<ExpiryDetailsDTO> expiryAllDTOs=new ArrayList<ExpiryDetailsDTO>();
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
					.prepareCall(StoredProcedures.PROC_GET_EXPIRY_FOR_ADJ_BY_PUR);
			callableStatement.setInt(1, mapper.getCompanyId());
			callableStatement.setInt(2, mapper.getStoreId());
			callableStatement.setInt(3, mapper.getPurInvId());
			
			callableStatement.execute();
			
			rs = callableStatement.getResultSet();
			ReflectionResultSetMapper<ExpiryDetailsDTO> resultSetMapper = new ReflectionResultSetMapper<ExpiryDetailsDTO>(
					ExpiryDetailsDTO.class);
			while(rs.next()){
				ExpiryDetailsDTO exp = new ExpiryDetailsDTO();
				exp = resultSetMapper.mapRow(rs);
				expiryAllDTOs.add(exp);
			}
			//logger.info("get expiry for adj by purchase fetched");

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

		return expiryAllDTOs;
	}
	
	@Override
	public ExpiryDTO getExpiryHeaderById(CommonResultSetMapper mapper) throws DAOException {

		ExpiryDTO exp=new ExpiryDTO();
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
					.prepareCall(StoredProcedures.PROC_GET_EXPIRY_HEADER_BY_ID);
			callableStatement.setInt(1, mapper.getExpiryId());
			
			callableStatement.execute();
			
			rs = callableStatement.getResultSet();
			ReflectionResultSetMapper<ExpiryDTO> resultSetMapper = new ReflectionResultSetMapper<ExpiryDTO>(
					ExpiryDTO.class);
			while(rs.next()){
				
				exp = resultSetMapper.mapRow(rs);
				
			}
			//logger.info("expiry header by id fetched");

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

		return exp;
	}
	
	@Override
	public List<SerialStockStatusDTO> getSerialStockStatus(CommonResultSetMapper mapper) throws DAOException {

		List<SerialStockStatusDTO> status=new ArrayList<SerialStockStatusDTO>();
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
					.prepareCall(StoredProcedures.PROC_GET_SERIAL_STOCK_STATUS);
			callableStatement.setInt(1, mapper.getCompanyId());
			callableStatement.setInt(2, mapper.getStoreId());
			callableStatement.setInt(3, mapper.getFinYrId());
			callableStatement.setInt(4, mapper.getItemId());
			callableStatement.setInt(5, mapper.getSaleId());
			if (mapper.getAsOnDate()!=null) {
				java.sql.Date asonDate = DateUtil.convertStringDateToSqlDate(
				mapper.getAsOnDate(), "yyyy-MM-dd");
				callableStatement.setDate(6, asonDate);
			}
			else {
				callableStatement.setDate(6, null);
			}
			
			callableStatement.execute();
			
			rs = callableStatement.getResultSet();
			ReflectionResultSetMapper<SerialStockStatusDTO> resultSetMapper = new ReflectionResultSetMapper<SerialStockStatusDTO>(
					SerialStockStatusDTO.class);
			while(rs.next()){
				SerialStockStatusDTO dto=new SerialStockStatusDTO();
				
				dto = resultSetMapper.mapRow(rs);
				status.add(dto);
				
			}
			//logger.info("serial stock status fetched");

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

		return status;
	}
	
	@Override
	public String uploadStock(InputStream fileInputStream, CommonResultSetMapper mapper) throws DAOException {

		int status=0;
		EntityManager em = null;
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
			
			XlsToXml xlsToXml = new XlsToXml();
			String xmlStr = xlsToXml.toXml(fileInputStream);
			
			//System.out.println("uploadStock xmlstr = "+xmlStr);
			
			callableStatement = connection
					.prepareCall(StoredProcedures.PROC_UPLOAD_STOCK_AUTO);
			callableStatement.setString(1, xmlStr);
			callableStatement.setString(2, "row");
			callableStatement.setInt(3, mapper.getCompanyId());
			callableStatement.setInt(4, mapper.getStoreId());
			callableStatement.setInt(5, mapper.getFinYrId());
			callableStatement.setInt(6, mapper.getCreatedBy());
			
			callableStatement.registerOutParameter(7,
					java.sql.Types.INTEGER);

			callableStatement.execute();
			status = callableStatement.getInt(7);
			//logger.info("stock fetched");

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

		return ""+status;
	}
	
	
	@Override
	public String uploadStockManual(OpeningStock openingStock)
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
				StringWriter sw = new StringWriter();
				// File file = new File("D:\\2017-05-30\\file_stock_upload_manual.xml");
				JAXBContext jaxbContext = JAXBContext
						.newInstance(OpeningStock.class);
				Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

				jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,
						true);
				//jaxbMarshaller.marshal(openingStock, file);
				// jaxbMarshaller.marshal(purchase, System.out);
				jaxbMarshaller.marshal(openingStock, sw);
				String result = sw.toString();
				//System.out.println("uploadStockManual xml:: "+result);
				callableStatement = connection
						.prepareCall(StoredProcedures.PROC_UPLOAD_STOCK_MANUAL);
				callableStatement.setString(1, result);
				callableStatement.setString(2, "openingStockDetails");
				callableStatement.setString(3, "invOpeningStockDetails");
				callableStatement.registerOutParameter(4,
						java.sql.Types.INTEGER);
				/*callableStatement.registerOutParameter(3,
						java.sql.Types.INTEGER);*/

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
				status=0;
				e.printStackTrace();
			}
			catch (Exception e) {
				status=0;
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
	public List<TaxDTO> getAllTaxByName(CommonResultSetMapper mapper) throws DAOException {

		List<TaxDTO> taxes = new ArrayList<TaxDTO>();
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
					.prepareCall(StoredProcedures.PROC_GET_TAX_BY_NAME);
			callableStatement.setInt(1, mapper.getCompanyId());
			callableStatement.setInt(2, mapper.getStoreId());
			callableStatement.setString(3, mapper.getTaxName());
			
			callableStatement.execute();
			rs = callableStatement.getResultSet();

			ReflectionResultSetMapper<TaxDTO> resultSetMapper1 = new ReflectionResultSetMapper<TaxDTO>(
					TaxDTO.class);

			while (rs.next()) {
				TaxDTO tax = resultSetMapper1.mapRow(rs);
				taxes.add(tax);

			}

			//logger.info("taxes name all fetched");

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

		return taxes;
	}
	
	@Override
	public List<TaxDTO> getTaxDetailsById(CommonResultSetMapper mapper) throws DAOException {

		
		EntityManager em = null;
		CallableStatement callableStatement = null;
		Connection connection = null;
		ResultSet rs = null;
		TaxDTO tax=new TaxDTO();
		List<TaxDTO> taxDTOs=new ArrayList<TaxDTO>();

		try {
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();

			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();
			connection = sessionFactory.getConnectionProvider().getConnection();

			callableStatement = connection
					.prepareCall(StoredProcedures.PROC_GET_TAX_DETAILS_BY_ID);
			callableStatement.setInt(1, mapper.getCompanyId());
			callableStatement.setInt(2, mapper.getStoreId());
			callableStatement.setInt(3, mapper.getTaxId());
			callableStatement.execute();
			rs = callableStatement.getResultSet();

			ReflectionResultSetMapper<TaxDTO> resultSetMapper1 = new ReflectionResultSetMapper<TaxDTO>(
					TaxDTO.class);

			while (rs.next()) {
				tax = resultSetMapper1.mapRow(rs);
				taxDTOs.add(tax);
				

			}

			//logger.info("tax fetched");

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

		return taxDTOs;
	}
	
	@Override
	public TaxDTO getTaxById(CommonResultSetMapper mapper) throws DAOException {

		
		EntityManager em = null;
		CallableStatement callableStatement = null;
		Connection connection = null;
		ResultSet rs = null;
		TaxDTO tax=new TaxDTO();

		try {
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();

			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();
			connection = sessionFactory.getConnectionProvider().getConnection();

			callableStatement = connection
					.prepareCall(StoredProcedures.PROC_GET_TAX_BY_ID);
			callableStatement.setInt(1, mapper.getCompanyId());
			callableStatement.setInt(2, mapper.getStoreId());
			callableStatement.setInt(3, mapper.getTaxId());
			callableStatement.execute();
			rs = callableStatement.getResultSet();

			ReflectionResultSetMapper<TaxDTO> resultSetMapper1 = new ReflectionResultSetMapper<TaxDTO>(
					TaxDTO.class);

			while (rs.next()) {
				tax = resultSetMapper1.mapRow(rs);
				

			}

			//logger.info("tax fetched");

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

		return tax;
	}
	@Override
	public ResponseObj createTax(TaxMaster taxMaster)
			throws DAOException {
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
				//File file = new	 File("D:\\2017-05-31\\file_tax_creation.xml");
				JAXBContext jaxbContext = JAXBContext
						.newInstance(TaxMaster.class);
				Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

				jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,
						true);
			//	jaxbMarshaller.marshal(taxMaster, file);
				
				jaxbMarshaller.marshal(taxMaster, sw);
				String result = sw.toString();
				
				callableStatement = connection
						.prepareCall(StoredProcedures.PROC_CREATE_TAX);
				callableStatement.setString(1, result);
				callableStatement.setString(2, "taxMaster");
				callableStatement.setString(3, "taxGrpDetailsMasters");
				
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
				responseObj.setStatus(ReturnConstant.FAILURE);
				responseObj.setId(0);
				responseObj.setReason("Record not saved successfully.");
			}
			em.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			responseObj.setStatus(ReturnConstant.FAILURE);
			responseObj.setId(0);
			responseObj.setReason("Record not saved successfully.");
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
	public ResponseObj insertCustomer(CustomerMaster customerMaster)
			throws DAOException {
		//System.out.println("insertCustomer customermaster:: "+customerMaster);
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
				
				
				callableStatement = connection
						.prepareCall(StoredProcedures.PROC_INSERT_CUST);
				callableStatement.setString(1, customerMaster.getName());
				callableStatement.setString(2, customerMaster.getCode());
				callableStatement.setString(3, customerMaster.getAddress());
				callableStatement.setString(4, customerMaster.getPin());
				callableStatement.setInt(5, customerMaster.getCity());
				callableStatement.setInt(6, customerMaster.getState());
				callableStatement.setInt(7, customerMaster.getCountry());
				callableStatement.setString(8, customerMaster.getPhoneNo());
				callableStatement.setString(9, customerMaster.getFax());
				callableStatement.setString(10, customerMaster.getAddharCardNo());
				
				if (customerMaster.getDob()!=null) {
					java.sql.Date dob = DateUtil.convertJavaDateToSqlDate(customerMaster.getDob());
					callableStatement.setDate(11, dob);
				}
				else {
					callableStatement.setDate(11, null);
				}
				callableStatement.setString(12, customerMaster.getGender());
				callableStatement.setDouble(13, customerMaster.getObBal());
				callableStatement.setDouble(14, customerMaster.getCreditLimit());
				callableStatement.setDouble(15, customerMaster.getCustomerTypeId());
				callableStatement.setInt(16, customerMaster.getCompanyId());
				callableStatement.setInt(17, customerMaster.getStoreId());
				callableStatement.setInt(18, customerMaster.getFinyrId());
				callableStatement.setInt(19, customerMaster.getCreatedBy());
				callableStatement.setString(20, customerMaster.getGstNo());
				/*callableStatement.setInt(19, customerMaster.getAge());
				callableStatement.setString(20, customerMaster.getGuardian_name());*/
				
				callableStatement.setInt(21, customerMaster.getCity());
				callableStatement.setString(22, customerMaster.getDlNo());
				callableStatement.setString(23, customerMaster.getPanNo());
				if (customerMaster.getAnniversaryDate()!=null) {
					java.sql.Date anniDate = DateUtil.convertJavaDateToSqlDate(customerMaster.getAnniversaryDate());
					callableStatement.setDate(24, anniDate);
				}
				else {
					callableStatement.setDate(24, null);
				}
				callableStatement.setString(25, customerMaster.getRelativeType());
				if (customerMaster.getRelativeDob()!=null) {
					java.sql.Date rdob = DateUtil.convertJavaDateToSqlDate(customerMaster.getRelativeDob());
					callableStatement.setDate(26, rdob);
				}
				else {
					callableStatement.setDate(26, null);
				}
				callableStatement.registerOutParameter(27,
						java.sql.Types.INTEGER);
                 System.out.println(callableStatement.toString());
				callableStatement.execute();
				status = callableStatement.getInt(27);
				
				if (status >0) {
					
					responseObj.setStatus(ReturnConstant.SUCCESS);
					responseObj.setId(status);
					responseObj.setReason("Record save successfully.");
					
				}
				else if(status == -2) {
					
					responseObj.setStatus(ReturnConstant.FAILURE);
					responseObj.setId(status);
					responseObj.setReason("Duplicate contact number. Record not saved successfully.");
					
				}else {
					
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
				responseObj.setStatus(ReturnConstant.FAILURE);
				responseObj.setId(0);
				responseObj.setReason("Record not saved successfully.");
			}
			em.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			responseObj.setStatus(ReturnConstant.FAILURE);
			responseObj.setId(0);
			responseObj.setReason("Record not saved successfully.");
			throw new DAOException("Check data to be inserted", e);
		} finally {
			try {
				
				if(callableStatement!=null)
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
	public ResponseObj insertDistributor(DistributorMaster distributorMaster)
			throws DAOException {
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
				
				
				callableStatement = connection
						.prepareCall(StoredProcedures.PROC_INSERT_DIST);
				callableStatement.setString(1, distributorMaster.getName());
				callableStatement.setString(2, distributorMaster.getAddress());
				callableStatement.setString(3, distributorMaster.getPin());
				callableStatement.setString(4, distributorMaster.getCity());
				callableStatement.setString(5, distributorMaster.getState());
				callableStatement.setString(6, distributorMaster.getCountry());
				callableStatement.setString(7, distributorMaster.getPhoneNo1());
				callableStatement.setString(8, distributorMaster.getPhoneNo2());
				callableStatement.setString(9, distributorMaster.getFax());
				callableStatement.setString(10, distributorMaster.getEmail());
				callableStatement.setString(11, distributorMaster.getContactPerson());
				callableStatement.setString(12, distributorMaster.getRegistrationNo());
				callableStatement.setDouble(13, distributorMaster.getObBal());
				callableStatement.setDouble(14, distributorMaster.getCreditLimit());
				callableStatement.setDouble(15, distributorMaster.getDiscount());
				callableStatement.setDouble(16, distributorMaster.getDiscountAmount());
				callableStatement.setString(17, distributorMaster.getLicenceNo());
				callableStatement.setInt(18, distributorMaster.getCityId());
				callableStatement.setInt(19, distributorMaster.getCompanyId());
				callableStatement.setInt(20, distributorMaster.getStoreId());
				callableStatement.setInt(21, distributorMaster.getFinyrId());
				callableStatement.setInt(22, distributorMaster.getCreatedBy());
				callableStatement.setInt(23, distributorMaster.getDueDays());
				callableStatement.setDouble(24, distributorMaster.getDuePer());
				callableStatement.registerOutParameter(25,
						java.sql.Types.INTEGER);

				callableStatement.execute();
				status = callableStatement.getInt(25);
				
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
				responseObj.setStatus(ReturnConstant.FAILURE);
				responseObj.setId(0);
				responseObj.setReason("Record not saved successfully.");
			}
			em.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			responseObj.setStatus(ReturnConstant.FAILURE);
			responseObj.setId(0);
			responseObj.setReason("Record not saved successfully.");
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
	public ResponseObj updateCustomerByProc(CustomerMaster customerMaster)
			throws DAOException {
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
				
				
				callableStatement = connection
						.prepareCall(StoredProcedures.PROC_UPDATE_CUST);
				callableStatement.setInt(1, customerMaster.getId());
				callableStatement.setString(2, customerMaster.getName());
				callableStatement.setString(3, customerMaster.getCode());
				callableStatement.setString(4, customerMaster.getAddress());
				callableStatement.setString(5, customerMaster.getPin());
				callableStatement.setInt(6, customerMaster.getCity());
				callableStatement.setInt(7, customerMaster.getState());
				callableStatement.setInt(8, customerMaster.getCountry());
				callableStatement.setString(9, customerMaster.getPhoneNo());
				callableStatement.setString(10, customerMaster.getFax());
				callableStatement.setString(11, customerMaster.getAddharCardNo());
				callableStatement.setString(12, customerMaster.getPanNo());
				callableStatement.setString(13, customerMaster.getGstNo());
				if (customerMaster.getDob()!=null) {
					java.sql.Date dob = DateUtil.convertJavaDateToSqlDate(customerMaster.getDob());
					callableStatement.setDate(14, dob);
				}
				else {
					callableStatement.setDate(14, null);
				}
				callableStatement.setString(15, customerMaster.getGender());
				callableStatement.setDouble(16, customerMaster.getObBal());
				callableStatement.setDouble(17, customerMaster.getCreditLimit());
				callableStatement.setInt(18, customerMaster.getCustomerTypeId());
				callableStatement.setInt(19, customerMaster.getCompanyId());
				callableStatement.setInt(20, customerMaster.getStoreId());
				callableStatement.setInt(21, customerMaster.getFinyrId());
				callableStatement.setInt(22, customerMaster.getCreatedBy());
				callableStatement.setInt(23, customerMaster.getCity());
				callableStatement.setString(24, customerMaster.getDlNo());
				if (customerMaster.getAnniversaryDate()!=null) {
					java.sql.Date annidate = DateUtil.convertJavaDateToSqlDate(customerMaster.getAnniversaryDate());
					callableStatement.setDate(25, annidate);
				}
				else {
					callableStatement.setDate(25, null);
				}
				callableStatement.setString(26, customerMaster.getRelativeType());
				if (customerMaster.getRelativeDob()!=null) {
					java.sql.Date rdob = DateUtil.convertJavaDateToSqlDate(customerMaster.getRelativeDob());
					callableStatement.setDate(27, rdob);
				}
				else {
					callableStatement.setDate(27, null);
				}
				callableStatement.registerOutParameter(28,
						java.sql.Types.INTEGER);
				callableStatement.execute();
				status = callableStatement.getInt(28);
				
				if (status >0) {
					
					responseObj.setStatus(ReturnConstant.SUCCESS);
					responseObj.setId(status);
					responseObj.setReason("Record updated successfully.");
					
				} else {
					
					responseObj.setStatus(ReturnConstant.FAILURE);
					responseObj.setId(status);
					responseObj.setReason("Record not updated successfully.");
					
				}
				
			} 
			
			catch (SQLException e) {
				e.printStackTrace();
				responseObj.setStatus(ReturnConstant.FAILURE);
				responseObj.setId(0);
				responseObj.setReason("Record not updated successfully.");
			}
			catch (Exception e) {
				e.printStackTrace();
				responseObj.setStatus(ReturnConstant.FAILURE);
				responseObj.setId(0);
				responseObj.setReason("Record not updated successfully.");
			}
			em.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			responseObj.setStatus(ReturnConstant.FAILURE);
			responseObj.setId(0);
			responseObj.setReason("Record not updated successfully.");
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
	public ResponseObj updateDistributorByProc(DistributorMaster distributorMaster)
			throws DAOException {
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
				
				
				callableStatement = connection
						.prepareCall(StoredProcedures.PROC_UPDATE_DIST);
				callableStatement.setInt(1, distributorMaster.getId());
				callableStatement.setString(2, distributorMaster.getName());
				callableStatement.setString(3, distributorMaster.getAddress());
				callableStatement.setString(4, distributorMaster.getPin());
				callableStatement.setString(5, distributorMaster.getCity());
				callableStatement.setString(6, distributorMaster.getState());
				callableStatement.setString(7, distributorMaster.getCountry());
				callableStatement.setString(8, distributorMaster.getPhoneNo1());
				callableStatement.setString(9, distributorMaster.getPhoneNo2());
				callableStatement.setString(10, distributorMaster.getFax());
				callableStatement.setString(11, distributorMaster.getEmail());
				callableStatement.setString(12, distributorMaster.getContactPerson());
				callableStatement.setString(13, distributorMaster.getRegistrationNo());
				callableStatement.setDouble(14, distributorMaster.getObBal());
				callableStatement.setDouble(15, distributorMaster.getCreditLimit());
				callableStatement.setDouble(16, distributorMaster.getDiscount());
				callableStatement.setDouble(17, distributorMaster.getDiscountAmount());
				callableStatement.setString(18, distributorMaster.getLicenceNo());
				callableStatement.setInt(19, distributorMaster.getCompanyId());
				callableStatement.setInt(20, distributorMaster.getStoreId());
				callableStatement.setInt(21, distributorMaster.getFinyrId());
				callableStatement.setInt(22, distributorMaster.getCreatedBy());
				callableStatement.setInt(23, distributorMaster.getCityId());
				callableStatement.setInt(24, distributorMaster.getDueDays());
				callableStatement.setDouble(25, distributorMaster.getDuePer());
				
				callableStatement.registerOutParameter(26,
						java.sql.Types.INTEGER);

				callableStatement.execute();
				status = callableStatement.getInt(26);
				
				if (status >0) {
					
					responseObj.setStatus(ReturnConstant.SUCCESS);
					responseObj.setId(status);
					responseObj.setReason("Record updated successfully.");
					
				} else {
					
					responseObj.setStatus(ReturnConstant.FAILURE);
					responseObj.setId(status);
					responseObj.setReason("Record not updated successfully.");
					
				}
				
			} 
			
			catch (SQLException e) {
				e.printStackTrace();
				responseObj.setStatus(ReturnConstant.FAILURE);
				responseObj.setId(0);
				responseObj.setReason("Record not updated successfully.");
			}
			catch (Exception e) {
				e.printStackTrace();
				responseObj.setStatus(ReturnConstant.FAILURE);
				responseObj.setId(0);
				responseObj.setReason("Record not updated successfully.");
			}
			em.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			responseObj.setStatus(ReturnConstant.FAILURE);
			responseObj.setId(0);
			responseObj.setReason("Record not updated successfully.");
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
	public ResponseObj deleteTax(CommonResultSetMapper mapper) throws DAOException {
		EntityManager em = null;
		Connection connection = null;
		CallableStatement callableStatement = null;
		int result = 0;
		ResponseObj responseObj=new ResponseObj();
		try {
			int storeId = mapper.getStoreId();
			int cmpnyId = mapper.getCompanyId();
		
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();
			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();
			connection = sessionFactory.getConnectionProvider().getConnection();
			callableStatement = connection
					.prepareCall(StoredProcedures.PROC_DELETE_TAX);
			callableStatement.setInt(1, cmpnyId);
			callableStatement.setInt(2, storeId);
			callableStatement.setInt(3, mapper.getTaxId());
			
			callableStatement.registerOutParameter(4, java.sql.Types.INTEGER);

			callableStatement.execute();
			result = callableStatement.getInt(4);
			
			if (result >0) {
				
				em.getTransaction().commit();
				responseObj.setStatus(ReturnConstant.SUCCESS);
				responseObj.setId(result);
				responseObj.setReason("Record deleted successfully.");
				
			} else {
				responseObj.setStatus(ReturnConstant.FAILURE);
				responseObj.setId(result);
				responseObj.setReason("Record not deleted successfully.");
			}

		} catch (Exception e) {
			e.printStackTrace();
			responseObj.setStatus(ReturnConstant.FAILURE);
			responseObj.setId(0);
			responseObj.setReason("Record not deleted successfully.");
			throw new DAOException("Check data to be deleted", e);
		}

		finally {
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
	public ResponseObj updateTax(TaxMaster taxMaster)
			throws DAOException {
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
				//File file = new	 File("D:\\2017-08-16\\file_tax_updation.xml");
				JAXBContext jaxbContext = JAXBContext
						.newInstance(TaxMaster.class);
				Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

				jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,
						true);
				//jaxbMarshaller.marshal(taxMaster, file);
				
				jaxbMarshaller.marshal(taxMaster, sw);
				String result = sw.toString();
				
				callableStatement = connection
						.prepareCall(StoredProcedures.PROC_UPDATE_TAX);
				callableStatement.setString(1, result);
				callableStatement.setString(2, "taxMaster");
				callableStatement.setString(3, "taxGrpDetailsMasters");
				
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
				responseObj.setStatus(ReturnConstant.FAILURE);
				responseObj.setId(0);
				responseObj.setReason("Record not saved successfully.");
			}
			em.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			responseObj.setStatus(ReturnConstant.FAILURE);
			responseObj.setId(0);
			responseObj.setReason("Record not saved successfully.");
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
	public ResponseObj updateStockAdj(StockDetailsAdjustmentDTO mapper)
			throws DAOException {
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
				callableStatement = connection
						.prepareCall(StoredProcedures.PROC_UPDATE_STOCK_ADJ);
				callableStatement.setInt(1, mapper.getId());
				callableStatement.setInt(2, mapper.getItemId());
				callableStatement.setString(3, mapper.getBatchNo());
				callableStatement.setString(4, mapper.getExpiryDateFormat());
				callableStatement.setDouble(5, mapper.getPackQty());
				callableStatement.setInt(6, mapper.getConversion());
				callableStatement.setInt(7, mapper.getLooseQty());
				callableStatement.setDouble(8, mapper.getMrp());
				callableStatement.setDouble(9, mapper.getRate());
				callableStatement.setDouble(10, mapper.getSaleRate());
				callableStatement.setInt(11, mapper.getDistributorId());
				callableStatement.setInt(12, mapper.getCompanyId());
				callableStatement.setInt(13, mapper.getStoreId());
				callableStatement.setInt(14, mapper.getFinyrId());
				callableStatement.setInt(15, mapper.getCreatedBy());
				
				callableStatement.registerOutParameter(16, java.sql.Types.INTEGER);

				callableStatement.execute();
				status = callableStatement.getInt(16);
				
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
				responseObj.setStatus(ReturnConstant.FAILURE);
				responseObj.setId(0);
				responseObj.setReason("Record not saved successfully.");
			}
			em.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			responseObj.setStatus(ReturnConstant.FAILURE);
			responseObj.setId(0);
			responseObj.setReason("Record not saved successfully.");
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
	public ResponseObj deleteStockAdj(CommonResultSetMapper mapper)
			throws DAOException {
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
				callableStatement = connection
						.prepareCall(StoredProcedures.PROC_DELETE_STCK_ADJ);
				callableStatement.setInt(1, mapper.getCompanyId());
				callableStatement.setInt(2, mapper.getStoreId());
				callableStatement.setInt(3, mapper.getId());
				
				callableStatement.registerOutParameter(4, java.sql.Types.INTEGER);

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
				responseObj.setStatus(ReturnConstant.FAILURE);
				responseObj.setId(0);
				responseObj.setReason("Record not saved successfully.");
			}
			em.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			responseObj.setStatus(ReturnConstant.FAILURE);
			responseObj.setId(0);
			responseObj.setReason("Record not saved successfully.");
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
	public List<TaxDTO> getAllTax(CommonResultSetMapper mapper) throws DAOException {

		List<TaxDTO> taxes = new ArrayList<TaxDTO>();
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
					.prepareCall(StoredProcedures.PROC_GET_ALL_TAX);
			callableStatement.setInt(1, mapper.getCompanyId());
			callableStatement.setInt(2, mapper.getStoreId());
			callableStatement.setInt(3, mapper.getTaxId());
			callableStatement.setInt(4, mapper.getIsGroup());
			callableStatement.execute();
			rs = callableStatement.getResultSet();

			ReflectionResultSetMapper<TaxDTO> resultSetMapper1 = new ReflectionResultSetMapper<TaxDTO>(
					TaxDTO.class);

			while (rs.next()) {
				TaxDTO tax = resultSetMapper1.mapRow(rs);
				taxes.add(tax);

			}

			//logger.info("taxes fetched");

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

		return taxes;
	}
	
	@Override
	public DoctorMaster getDoctor(String id) throws DAOException {

		DoctorMaster doc = null;
		EntityManager em = null;

		try {
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();

			int id1 = Integer.parseInt(id);
			Query qry = em
					.createQuery("SELECT b FROM DoctorMaster b WHERE b.id=:id and b.isDeleted=0");

			qry.setParameter("id", id1);
			doc = (DoctorMaster) qry.getSingleResult();

			//logger.info("doctor fetched");

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("In DAOException", e);

		} finally {
			if(em != null) em.close();
		}

		return doc;
	}
	
	@Override
	public CustomerMaster getCustomer(String id) throws DAOException {

		CustomerMaster cust = null;
		EntityManager em = null;

		try {
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();

			int id1 = Integer.parseInt(id);
			Query qry = em
					.createQuery("SELECT b FROM CustomerMaster b WHERE b.id=:id and b.isDeleted=0");

			qry.setParameter("id", id1);
			cust = (CustomerMaster) qry.getSingleResult();

			//logger.info("customer fetched");

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("In DAOException", e);

		} finally {
			if(em != null) em.close();
		}

		return cust;
	}

	@Override
	public ItemMaster getItemDetails(String id) throws DAOException {

		ItemMaster item = null;
		EntityManager em = null;
		GroupMaster groupMaster = null;
		CategoryMaster categoryMaster = null;
		SubCategoryMaster subCategoryMaster = null;
		ScheduleMaster scheduleMaster = null;
		ContentMaster contentMaster = null;
		BrandMaster brandMaster = null;
		ManufacturerMaster manufacturerMaster = null;
		UnitMaster packUnit = null;
		UnitMaster looseUnit = null;
		UnitMaster reorderLevelUnit = null;
		RackMaster rack = null;
		ItemRackMapper itemRackMapper = null;
		int rackId=0;
		TaxMaster saleTax = null;
		TaxMaster purchaseTax = null;
		MarketerMaster marketerMaster=null;

		try {
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();

			int id1 = Integer.parseInt(id);
			Query qry = em
					.createQuery("SELECT i FROM ItemMaster i WHERE i.id=:id and i.isDeleted=0");

			qry.setParameter("id", id1);
			item = (ItemMaster) qry.getSingleResult();

			try {
				Query qry12 = em
						.createQuery("SELECT i FROM ItemRackMapper i WHERE i.itemId=:itemId and i.isDeleted=0");

				qry12.setParameter("itemId", id1);
				itemRackMapper = (ItemRackMapper) qry12.getSingleResult();
				rackId = itemRackMapper.getRackId();
				item.setRackId(rackId);
	
			} catch (Exception e1) {
				item.setRackId(0);
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			int grpId = item.getGroupId();
			int catId = item.getCategoryId();
			int subCtId = item.getSubCategoryId();
			int schId = item.getScheduleId();
			int cntId = item.getContentId();
			int brandId = item.getBrandId();
			int manuId = item.getManufacturerId();
			int packUnitId = item.getPackUnitId();
			int losUntId = item.getLooseUnitId();
			int reorUntId = item.getReorderLevelUnitId();
			int marketerId = item.getMarketerId();
			

			try {
				// get grp
				Query qry1 = em
						.createQuery("SELECT g FROM GroupMaster g WHERE g.id=:id and g.isDeleted=0");

				qry1.setParameter("id", grpId);
				groupMaster = (GroupMaster) qry1.getSingleResult();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// get cat
			Query qry2;
			try {
				qry2 = em
						.createQuery("SELECT c FROM CategoryMaster c WHERE c.id=:id and c.isDeleted=0");

				qry2.setParameter("id", catId);
				categoryMaster = (CategoryMaster) qry2.getSingleResult();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				// get subcat
				Query qry3 = em
						.createQuery("SELECT s FROM SubCategoryMaster s WHERE s.id=:id and s.isDeleted=0");

				qry3.setParameter("id", subCtId);
				subCategoryMaster = (SubCategoryMaster) qry3.getSingleResult();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				// get schedule
				Query qry4 = em
						.createQuery("SELECT s FROM ScheduleMaster s WHERE s.id=:id and s.isDeleted=0");

				qry4.setParameter("id", schId);
				scheduleMaster = (ScheduleMaster) qry4.getSingleResult();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				// get content
				Query qry5 = em
						.createQuery("SELECT c FROM ContentMaster c WHERE c.id=:id and c.isDeleted=0");

				qry5.setParameter("id", cntId);
				contentMaster = (ContentMaster) qry5.getSingleResult();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				// get brand
				Query qry6 = em
						.createQuery("SELECT b FROM BrandMaster b WHERE b.id=:id and b.isDeleted=0");

				qry6.setParameter("id", brandId);
				brandMaster = (BrandMaster) qry6.getSingleResult();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				// get manu
				Query qry7 = em
						.createQuery("SELECT m FROM ManufacturerMaster m WHERE m.id=:id and m.isDeleted=0");

				qry7.setParameter("id", manuId);
				manufacturerMaster = (ManufacturerMaster) qry7
						.getSingleResult();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				// get packunit
				Query qry8 = em
						.createQuery("SELECT u FROM UnitMaster u WHERE u.id=:id and u.isDeleted=0");

				qry8.setParameter("id", packUnitId);
				packUnit = (UnitMaster) qry8.getSingleResult();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				// get loose unit
				Query qry9 = em
						.createQuery("SELECT u FROM UnitMaster u WHERE u.id=:id and u.isDeleted=0");

				qry9.setParameter("id", losUntId);
				looseUnit = (UnitMaster) qry9.getSingleResult();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				// get reorder level unit
				Query qry10 = em
						.createQuery("SELECT u FROM UnitMaster u WHERE u.id=:id and u.isDeleted=0");

				qry10.setParameter("id", reorUntId);
				reorderLevelUnit = (UnitMaster) qry10.getSingleResult();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				// get rack
				Query qry11 = em
						.createQuery("SELECT r FROM RackMaster r WHERE r.id=:id and r.isDeleted=0");

				qry11.setParameter("id", rackId);
				rack = (RackMaster) qry11.getSingleResult();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				// get sale tax
				Query qry10 = em
						.createQuery("SELECT t FROM TaxMaster t WHERE t.id=:id and t.isDeleted=0");

				qry10.setParameter("id", item.getSaleTaxId());
				saleTax = (TaxMaster) qry10.getSingleResult();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				// get purchase tax
				Query qry10 = em
						.createQuery("SELECT t FROM TaxMaster t WHERE t.id=:id and t.isDeleted=0");

				qry10.setParameter("id", item.getPurchaseTaxId());
				purchaseTax = (TaxMaster) qry10.getSingleResult();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				// get marketer
				Query qrymak = em
						.createQuery("SELECT mk FROM MarketerMaster mk WHERE mk.id=:maktid and mk.isDeleted=0");

				qrymak.setParameter("maktid", item.getMarketerId());
				marketerMaster = (MarketerMaster) qrymak.getSingleResult();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// set all
			item.setGroupMaster(groupMaster);
			item.setBrandMaster(brandMaster);
			item.setContentMaster(contentMaster);
			item.setManufacturerMaster(manufacturerMaster);
			item.setCategoryMaster(categoryMaster);
			item.setSubCategoryMaster(subCategoryMaster);
			item.setScheduleMaster(scheduleMaster);
			item.setPackUnit(packUnit);
			item.setLooseUnit(looseUnit);
			item.setReorderLevelUnit(reorderLevelUnit);
			item.setSaleTax(saleTax);
			item.setPurchaseTax(purchaseTax);
			item.setMarketerMaster(marketerMaster);
			if(rackId==0){
				rack=new RackMaster();
				rack.setId(0);
			}

			item.setRack(rack);
			//logger.info("Item fetched");

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("In DAOException", e);

		} finally {
			if(em != null) em.close();
		}

		return item;
	}
	
	
	public ItemMaster getItemByName(String name) throws DAOException {

		ItemMaster item = null;
		List<ItemMaster> listItem=new ArrayList<ItemMaster>();
		EntityManager em = null;
		GroupMaster groupMaster = null;
		CategoryMaster categoryMaster = null;
		SubCategoryMaster subCategoryMaster = null;
		ScheduleMaster scheduleMaster = null;
		ContentMaster contentMaster = null;
		BrandMaster brandMaster = null;
		ManufacturerMaster manufacturerMaster = null;
		UnitMaster packUnit = null;
		UnitMaster looseUnit = null;
		UnitMaster reorderLevelUnit = null;
		RackMaster rack = null;
		ItemRackMapper itemRackMapper = null;
		int rackId=0;
		TaxMaster saleTax = null;
		TaxMaster purchaseTax = null;

		try {
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();
			String name1=name.trim();
			name1="%"+name1+"%";
			Query qry = em
					.createQuery("SELECT i FROM ItemMaster i WHERE i.name like :name1 and i.isDeleted=0");

			qry.setParameter("name1", name1);
			listItem = (List<ItemMaster>) qry.getResultList();
			if(listItem.size()==1){
				item=listItem.get(0);
			}
			else if (listItem.size()>1) {
				//check for item with same name
				Iterator<ItemMaster> iterator=listItem.iterator();
				while (iterator.hasNext()) {
					ItemMaster itemMaster = (ItemMaster) iterator.next();
					if(itemMaster.getName().equalsIgnoreCase(name)){
						item=itemMaster;
						break;
					}
					
				}
				
			}
			//logger.info("Item fetched");

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("In DAOException", e);

		} finally {
			if(em != null) em.close();
		}

		return item;
	}

	@Override
	public DistributorMaster getDistributor(String id) throws DAOException {

		DistributorMaster dist = null;
		EntityManager em = null;

		try {
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();

			int id1 = Integer.parseInt(id);
			Query qry = em
					.createQuery("SELECT d FROM DistributorMaster d WHERE d.id=:id and d.isDeleted=0");

			qry.setParameter("id", id1);
			dist = (DistributorMaster) qry.getSingleResult();

			//logger.info("Distributor fetched");

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("In DAOException", e);

		} finally {
			if(em != null) em.close();
		}

		return dist;
	}

	@Override
	public ContentMaster getContent(String id) throws DAOException {

		ContentMaster cntnt = null;
		EntityManager em = null;

		try {
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();

			int id1 = Integer.parseInt(id);
			Query qry = em
					.createQuery("SELECT c FROM ContentMaster c WHERE c.id=:id and c.isDeleted=0");

			qry.setParameter("id", id1);
			cntnt = (ContentMaster) qry.getSingleResult();

			//logger.info("Content fetched");

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("In DAOException", e);

		} finally {
			if(em != null) em.close();
		}

		return cntnt;
	}

	@Override
	public ScheduleMaster getSchedule(String id) throws DAOException {

		ScheduleMaster schdl = null;
		EntityManager em = null;

		try {
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();

			int id1 = Integer.parseInt(id);
			Query qry = em
					.createQuery("SELECT s FROM ScheduleMaster s WHERE s.id=:id and s.isDeleted=0");

			qry.setParameter("id", id1);
			schdl = (ScheduleMaster) qry.getSingleResult();

			//logger.info("schedule fetched");

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("In DAOException", e);

		} finally {
			if(em != null) em.close();
		}

		return schdl;
	}

	@Override
	public GroupMaster getGroup(String id) throws DAOException {

		GroupMaster grp = null;
		EntityManager em = null;

		try {
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();

			int id1 = Integer.parseInt(id);
			Query qry = em
					.createQuery("SELECT g FROM GroupMaster g WHERE g.id=:id and g.isDeleted=0");

			qry.setParameter("id", id1);
			grp = (GroupMaster) qry.getSingleResult();

			//logger.info("Brand fetched");

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("In DAOException", e);

		} finally {
			if(em != null) em.close();
		}

		return grp;
	}

	@Override
	public RackMaster getRack(String id) throws DAOException {

		RackMaster rack = null;
		EntityManager em = null;

		try {
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();

			int id1 = Integer.parseInt(id);
			Query qry = em
					.createQuery("SELECT r FROM RackMaster r WHERE r.id=:id and r.isDeleted=0");

			qry.setParameter("id", id1);
			rack = (RackMaster) qry.getSingleResult();

			//logger.info("Rack fetched");

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("In DAOException", e);

		} finally {
			if(em != null) em.close();
		}

		return rack;
	}

	@Override
	public UnitMaster getUnit(String id) throws DAOException {

		UnitMaster unit = null;
		EntityManager em = null;

		try {
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();

			int id1 = Integer.parseInt(id);
			Query qry = em
					.createQuery("SELECT u FROM UnitMaster u WHERE u.id=:id and u.isDeleted=0");

			qry.setParameter("id", id1);
			unit = (UnitMaster) qry.getSingleResult();

			//logger.info("Unit fetched");

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("In DAOException", e);

		} finally {
			if(em != null) em.close();
		}

		return unit;
	}

	@Override
	public MarketerMaster getMarketer(String id) throws DAOException {

		MarketerMaster marketer = null;
		EntityManager em = null;

		try {
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();

			int id1 = Integer.parseInt(id);
			Query qry = em
					.createQuery("SELECT b FROM MarketerMaster b WHERE b.id=:id and b.isDeleted=0");

			qry.setParameter("id", id1);
			marketer = (MarketerMaster) qry.getSingleResult();

			//logger.info("marketer fetched");

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("In DAOException", e);

		} finally {
			if(em != null) em.close();
		}

		return marketer;
	}
	
	@Override
	public ManufacturerMaster getManufacturer(String id) throws DAOException {

		ManufacturerMaster manufacturerMaster = null;
		EntityManager em = null;

		try {
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();

			int id1 = Integer.parseInt(id);
			Query qry = em
					.createQuery("SELECT b FROM ManufacturerMaster b WHERE b.id=:id and b.isDeleted=0");

			qry.setParameter("id", id1);
			manufacturerMaster = (ManufacturerMaster) qry.getSingleResult();

			//logger.info("Manufacturer fetched");

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("In DAOException", e);

		} finally {
			if(em != null) em.close();
		}

		return manufacturerMaster;
	}

	@Override
	public CategoryMaster getCategory(String id) throws DAOException {

		CategoryMaster cat = null;
		EntityManager em = null;

		try {
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();

			int id1 = Integer.parseInt(id);
			Query qry = em
					.createQuery("SELECT c FROM CategoryMaster c WHERE c.id=:id and c.isDeleted=0");

			qry.setParameter("id", id1);
			cat = (CategoryMaster) qry.getSingleResult();

			//logger.info("category fetched");

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("In DAOException", e);

		} finally {
			if(em != null) em.close();
		}

		return cat;
	}

	@Override
	public SubCategoryMaster getSubCategory(String id) throws DAOException {

		SubCategoryMaster subcat = null;
		EntityManager em = null;

		try {
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();

			int id1 = Integer.parseInt(id);
			Query qry = em
					.createQuery("SELECT s FROM SubCategoryMaster s WHERE s.id=:id and s.isDeleted=0");

			qry.setParameter("id", id1);
			subcat = (SubCategoryMaster) qry.getSingleResult();

			//logger.info("sub category fetched");

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("In DAOException", e);

		} finally {
			if(em != null) em.close();
		}

		return subcat;
	}

	@Override
	public List<BrandMaster> searchBrand(BrandMaster brand)
			throws DAOException, SearchCriteraException {
		EntityManager em = null;
		List<BrandMaster> brands = null;
		int brandId = 0;
		String name = "";
		int cmpnyId = 0;

		try {
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();
			brandId = brand.getId();
			name = brand.getName();
			String nameLike = "%" + name + "%";
			cmpnyId = brand.getCompanyId();
			String deleteFlagCnd = " and b.isDeleted=0";
			String qryCndn = brand.getQryCondition();

			String query = "SELECT b FROM BrandMaster b WHERE";

			if (brandId != 0) {
				query = query + " b.id=:brandId";

			}
			
			if (name != null)
				if (name.length() > 0) {
					if (qryCndn.equalsIgnoreCase(ReturnConstant.LIKE))
						query = query + " b.name like :nameLike";
					else if (qryCndn.equalsIgnoreCase(ReturnConstant.EQUALS)) {
						query = query + " b.name=:name";
					}

				}
			if (cmpnyId != 0) {
				query = query + " b.companyId=:companyId";

			}
			query = query + deleteFlagCnd;
			System.out.println("query:: " + query);
			Query qry = em.createQuery(query);
			if (brandId != 0) {
				qry.setParameter(" brandId", brandId);

			}
			if (name != null)
				if (name.length() > 0) {
					if (qryCndn.equalsIgnoreCase(ReturnConstant.LIKE))
						qry.setParameter(" nameLike", nameLike);
					else if (qryCndn.equalsIgnoreCase(ReturnConstant.EQUALS)) {
						qry.setParameter(" name", name);
					}

				}

			if (cmpnyId != 0) {
				qry.setParameter(" companyId", cmpnyId);

			}
			System.out.println("query jpa:: " + qry.toString());
			brands = (List<BrandMaster>) qry.getResultList();

		} catch (Exception e) {
			e.printStackTrace();
			if (brandId == 0 && (name == null || name.length() == 0)
					&& cmpnyId == 0) {
				throw new SearchCriteraException();
			} else
				throw new DAOException("Check data to be searched", e);
		} finally {
			if(em != null) em.close();
		}
		return brands;
	}

	@Override
	public List<UnitMaster> searchUnit(UnitMaster unit) throws DAOException,
			SearchCriteraException {
		EntityManager em = null;
		List<UnitMaster> units = null;

		String code = "";
		int cmpnyId = 0;
		int typeId = 0;

		try {
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();

			code = unit.getCode();
			typeId = unit.getTypeId();
			String codeLike = code + "%";
			cmpnyId = unit.getCompanyId();
			String query = "SELECT u FROM UnitMaster u WHERE u.code like :codeLike and u.typeId=:typeId and u.companyId=:cmpnyId and u.isDeleted=0";

			Query qry = em.createQuery(query);

			qry.setParameter("codeLike", codeLike);
			qry.setParameter("typeId", typeId);
			qry.setParameter("cmpnyId", cmpnyId);
			units = (List<UnitMaster>) qry.getResultList();

		} catch (Exception e) {

			throw new DAOException("Check data to be searched", e);
		} finally {
			if(em != null) em.close();
		}
		return units;
	}

	@Override
	public List<CommonResultSetMapper> searchBrandAutoCom(BrandMaster brand)
			throws DAOException, SearchCriteraException {
		EntityManager em = null;
		List<CommonResultSetMapper> brands = new ArrayList<CommonResultSetMapper>();
		int storeId = 0;
		String name = "";
		int cmpnyId = 0;
		Connection connection = null;
		CallableStatement callableStatement = null;
		ResultSet rs = null;

		try {
			cmpnyId = brand.getCompanyId();
			storeId = brand.getStoreId();
			name = brand.getName();
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();
			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();
			connection = sessionFactory.getConnectionProvider().getConnection();
			callableStatement = connection
					.prepareCall(StoredProcedures.PROC_SEARCH_BRAND_AUTO_COMPLETE);
			callableStatement.setInt(1, cmpnyId);
			callableStatement.setInt(2, storeId);
			callableStatement.setString(3, name);

			callableStatement.execute();
			rs = callableStatement.getResultSet();
			while (rs.next()) {
				CommonResultSetMapper mapper = new CommonResultSetMapper();
				mapper.setId(rs.getInt(1));
				mapper.setName(rs.getString(2));
				brands.add(mapper);

			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("Check data to be searched", e);
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
		return brands;
	}

	@Override
	public List<CommonResultSetMapper> searchManuAutoCom(ManufacturerMaster manu)
			throws DAOException, SearchCriteraException {
		EntityManager em = null;
		List<CommonResultSetMapper> manus = new ArrayList<CommonResultSetMapper>();
		int storeId = 0;
		String name = "";
		int cmpnyId = 0;
		Connection connection = null;
		CallableStatement callableStatement = null;
		ResultSet rs = null;

		try {
			cmpnyId = manu.getCompanyId();
			storeId = manu.getStoreId();
			name = manu.getName();
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();
			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();
			connection = sessionFactory.getConnectionProvider().getConnection();
			callableStatement = connection
					.prepareCall(StoredProcedures.PROC_SEARCH_MANU_AUTO_COMPLETE);
			callableStatement.setInt(1, cmpnyId);
			callableStatement.setInt(2, storeId);
			callableStatement.setString(3, name);

			callableStatement.execute();
			rs = callableStatement.getResultSet();
			while (rs.next()) {
				CommonResultSetMapper mapper = new CommonResultSetMapper();
				mapper.setId(rs.getInt(1));
				mapper.setName(rs.getString(2));
				mapper.setManufacturerCode(rs.getString(3));
				manus.add(mapper);

			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("Check data to be searched", e);
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
		return manus;
	}
	
	@Override
	public List<CommonResultSetMapper> searchMarketerAutoCom(MarketerMaster marketerMaster)
			throws DAOException, SearchCriteraException {
		EntityManager em = null;
		List<CommonResultSetMapper> marks = new ArrayList<CommonResultSetMapper>();
		int storeId = 0;
		String name = "";
		int cmpnyId = 0;
		Connection connection = null;
		CallableStatement callableStatement = null;
		ResultSet rs = null;

		try {
			cmpnyId = marketerMaster.getCompanyId();
			storeId = marketerMaster.getStoreId();
			name = marketerMaster.getName();
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();
			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();
			connection = sessionFactory.getConnectionProvider().getConnection();
			callableStatement = connection
					.prepareCall(StoredProcedures.PROC_SEARCH_MARKETER_AUTO_COMPLETE);
			callableStatement.setInt(1, cmpnyId);
			callableStatement.setInt(2, storeId);
			callableStatement.setString(3, name);

			callableStatement.execute();
			rs = callableStatement.getResultSet();
			while (rs.next()) {
				CommonResultSetMapper mapper = new CommonResultSetMapper();
				mapper.setId(rs.getInt(1));
				mapper.setName(rs.getString(2));
				mapper.setMarketerCode(rs.getString(3));
				marks.add(mapper);

			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("Check data to be searched", e);
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
		return marks;
	}

	@Override
	public List<CommonResultSetMapper> searchItem(CommonResultSetMapper mapper)
			throws DAOException {
		EntityManager em = null;
		List<CommonResultSetMapper> data = new ArrayList<CommonResultSetMapper>();
		int storeId = 0;
		String itemName = "";
		String cntnName = "";
		String brandName = "";
		String manuName = "";
		int cmpnyId = 0;
		Connection connection = null;
		CallableStatement callableStatement = null;
		ResultSet rs = null;

		try {
			cmpnyId = mapper.getCompanyId();
			storeId = mapper.getStoreId();
			itemName = mapper.getItemName();
			cntnName = mapper.getContentName();
			brandName = mapper.getBrandName();
			manuName = mapper.getManufacturerName();
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();
			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();
			connection = sessionFactory.getConnectionProvider().getConnection();
			callableStatement = connection
					.prepareCall(StoredProcedures.PROC_SEARCH_ITEM);
			callableStatement.setInt(1, cmpnyId);
			callableStatement.setInt(2, storeId);
			callableStatement.setString(3, itemName);
			callableStatement.setString(4, brandName);
			callableStatement.setString(5, manuName);

			callableStatement.execute();
			rs = callableStatement.getResultSet();
			while (rs.next()) {
				CommonResultSetMapper mapper1 = new CommonResultSetMapper();
				mapper1.setItemId(rs.getInt(1));
				mapper1.setItemName(rs.getString(2));
				mapper1.setHsnCode(rs.getString(3));
				mapper1.setBrandName(rs.getString(4));
				mapper1.setManufacturerName(rs.getString(5));
				mapper1.setManufacturerCode(rs.getString(6));
				mapper1.setPackUnitName(rs.getString(7));
				mapper1.setLooseUnitName(rs.getString(8));
				mapper1.setRackName(rs.getString(9));
				mapper1.setConv(rs.getInt(10));
				mapper1.setGroupName(rs.getString(11));
				mapper1.setMrp(rs.getDouble(12));
				mapper1.setPurchaseRate(rs.getDouble(13));

				mapper1.setListedMrp(rs.getDouble(14));
				mapper1.setSaleRate(rs.getDouble(15));
				mapper1.setItemCode(rs.getString(16));
				data.add(mapper1);

			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("Check data to be searched", e);
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
		return data;
	}
	
	@Override
	public List<CommonResultSetMapper> searchItemLite(CommonResultSetMapper mapper)
			throws DAOException {
		EntityManager em = null;
		List<CommonResultSetMapper> data = new ArrayList<CommonResultSetMapper>();
		int storeId = 0;
		String itemName = "";
		String cntnName = "";
		String brandName = "";
		String manuName = "";
		int cmpnyId = 0;
		Connection connection = null;
		CallableStatement callableStatement = null;
		ResultSet rs = null;

		try {
			cmpnyId = mapper.getCompanyId();
			storeId = mapper.getStoreId();
			itemName = mapper.getItemName();
			cntnName = mapper.getContentName();
			brandName = mapper.getBrandName();
			manuName = mapper.getManufacturerName();
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();
			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();
			connection = sessionFactory.getConnectionProvider().getConnection();
			callableStatement = connection
					.prepareCall(StoredProcedures.PROC_SEARCH_ITEM_LITE);
			callableStatement.setInt(1, cmpnyId);
			callableStatement.setInt(2, storeId);
			callableStatement.setString(3, itemName);
			callableStatement.setString(4, cntnName);
			callableStatement.setString(5, brandName);
			callableStatement.setString(6, manuName);

			callableStatement.execute();
			rs = callableStatement.getResultSet();
			while (rs.next()) {
				CommonResultSetMapper mapper1 = new CommonResultSetMapper();
				mapper1.setItemId(rs.getInt(1));
				mapper1.setItemName(rs.getString(2));
				mapper1.setItemCode(rs.getString(3));
				data.add(mapper1);

			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("Check data to be searched", e);
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
		return data;
	}

	@Override
	public List<CommonResultSetMapper> searchContentAutoCom(
			ContentMaster content) throws DAOException, SearchCriteraException {
		EntityManager em = null;
		List<CommonResultSetMapper> contnts = new ArrayList<CommonResultSetMapper>();
		int storeId = 0;
		String name = "";
		int cmpnyId = 0;
		Connection connection = null;
		CallableStatement callableStatement = null;
		ResultSet rs = null;

		try {
			cmpnyId = content.getCompanyId();
			storeId = content.getStoreId();
			name = content.getName();
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();
			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();
			connection = sessionFactory.getConnectionProvider().getConnection();
			callableStatement = connection
					.prepareCall(StoredProcedures.PROC_SEARCH_CONTENT_AUTO_COMPLETE);
			callableStatement.setInt(1, cmpnyId);
			callableStatement.setInt(2, storeId);
			callableStatement.setString(3, name);

			callableStatement.execute();
			rs = callableStatement.getResultSet();
			while (rs.next()) {
				CommonResultSetMapper mapper = new CommonResultSetMapper();
				mapper.setId(rs.getInt(1));
				mapper.setName(rs.getString(2));
				contnts.add(mapper);

			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("Check data to be searched", e);
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
		return contnts;
	}

	@Override
	public List<ContentMaster> searchContent(ContentMaster content)
			throws DAOException {
		EntityManager em = null;
		List<ContentMaster> cntnts = null;
		int cntentId = 0;
		String name = "";
		String code = "";
		int cmpnyId = 0;

		try {
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();
			cntentId = content.getId();
			name = content.getName();
			code = content.getCode();
			String nameLike = "%" + name + "%";
			cmpnyId = content.getCompanyId();
			String qryCndn = content.getQryCondition();

			String query = "SELECT c FROM ContentMaster c WHERE c.isDeleted=0";

			// search by content id
			if (cntentId != 0) {
				query = query + " and c.id=:cntentId";

			}

			// search by content name
			if (name != null)
				if (name.length() > 0) {
					if (qryCndn.equalsIgnoreCase(ReturnConstant.LIKE))
						query = query + " and c.name like :nameLike";
					else if (qryCndn.equalsIgnoreCase(ReturnConstant.EQUALS)) {
						query = query + " and c.name=:name";
					}

				}
			// search by content code
			if (code != null)
				if (code.length() > 0) {
					query = query + " and c.code=:code";

				}
			// search by company id
			if (cmpnyId != 0) {
				query = query + " and c.companyId=:companyId";

			}

			// System.out.println("query:: " + query);
			boolean containerContainsContent = StringUtils.containsIgnoreCase(
					query, "and");
			if (containerContainsContent) {
				Query qry = em.createQuery(query);
				if (cntentId != 0) {
					qry.setParameter("cntentId", cntentId);

				}
				if (name != null)
					if (name.length() > 0) {
						if (qryCndn.equalsIgnoreCase(ReturnConstant.LIKE))
							qry.setParameter("nameLike", nameLike);
						else if (qryCndn
								.equalsIgnoreCase(ReturnConstant.EQUALS)) {
							qry.setParameter("name", name);
						}

					}

				if (code != null)
					if (code.length() > 0) {
						qry.setParameter("code", code);

					}
				if (cmpnyId != 0) {
					qry.setParameter("companyId", cmpnyId);

				}

				cntnts = (List<ContentMaster>) qry.getResultList();
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("Check data to be searched", e);
		} finally {
			if(em != null) em.close();
		}
		return cntnts;
	}

	@Override
	public List<MarketerMaster> searchMarketer(MarketerMaster marketerMaster) throws DAOException {
		EntityManager em = null;
		List<MarketerMaster> marketers = null;
		int markId = 0;
		String name = "";
		String code = "";
		int cmpnyId = 0;

		try {
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();
			markId = marketerMaster.getId();
			name = marketerMaster.getName();
			code = marketerMaster.getCode();
			String nameLike = "%" + name + "%";
			cmpnyId = marketerMaster.getCompanyId();
			String qryCndn = marketerMaster.getQryCondition();

			String query = "SELECT m FROM MarketerMaster m WHERE m.isDeleted=0";

			// search by marketer id
			if (markId != 0) {
				query = query + " and m.id=:manuId";

			}

			// search by marketer name
			if (name != null)
				if (name.length() > 0) {
					if (qryCndn.equalsIgnoreCase(ReturnConstant.LIKE))
						query = query + " and m.name like :nameLike";
					else if (qryCndn.equalsIgnoreCase(ReturnConstant.EQUALS)) {
						query = query + " and m.name=:name";
					}

				}
			// search by marketer code
			if (code != null)
				if (code.length() > 0) {
					query = query + " and m.code=:code";

				}
			// search by company id
			if (cmpnyId != 0) {
				query = query + " and m.companyId=:companyId";

			}

			System.out.println("query:: " + query);
			boolean containerContainsContent = StringUtils.containsIgnoreCase(
					query, "and");
			if (containerContainsContent) {
				Query qry = em.createQuery(query);
				if (markId != 0) {
					qry.setParameter("manuId", markId);

				}
				if (name != null)
					if (name.length() > 0) {
						if (qryCndn.equalsIgnoreCase(ReturnConstant.LIKE))
							qry.setParameter("nameLike", nameLike);
						else if (qryCndn
								.equalsIgnoreCase(ReturnConstant.EQUALS)) {
							qry.setParameter("name", name);
						}

					}

				if (code != null)
					if (code.length() > 0) {
						qry.setParameter("code", code);

					}
				if (cmpnyId != 0) {
					qry.setParameter("companyId", cmpnyId);

				}

				marketers = (List<MarketerMaster>) qry.getResultList();
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("Check data to be searched", e);
		} finally {
			if(em != null) em.close();
		}
		return marketers;
	}
	
	@Override
	public List<ManufacturerMaster> searchManufacturer(
			ManufacturerMaster manufacturerMaster) throws DAOException {
		EntityManager em = null;
		List<ManufacturerMaster> manus = null;
		int manuId = 0;
		String name = "";
		String code = "";
		int cmpnyId = 0;

		try {
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();
			manuId = manufacturerMaster.getId();
			name = manufacturerMaster.getName();
			code = manufacturerMaster.getCode();
			String nameLike = "%" + name + "%";
			cmpnyId = manufacturerMaster.getCompanyId();
			String qryCndn = manufacturerMaster.getQryCondition();

			String query = "SELECT m FROM ManufacturerMaster m WHERE m.isDeleted=0";

			// search by manufc id
			if (manuId != 0) {
				query = query + " and m.id=:manuId";

			}

			// search by manu name
			if (name != null)
				if (name.length() > 0) {
					if (qryCndn.equalsIgnoreCase(ReturnConstant.LIKE))
						query = query + " and m.name like :nameLike";
					else if (qryCndn.equalsIgnoreCase(ReturnConstant.EQUALS)) {
						query = query + " and m.name=:name";
					}

				}
			// search by manu code
			if (code != null)
				if (code.length() > 0) {
					query = query + " and m.code=:code";

				}
			// search by company id
			if (cmpnyId != 0) {
				query = query + " and m.companyId=:companyId";

			}

			System.out.println("query:: " + query);
			boolean containerContainsContent = StringUtils.containsIgnoreCase(
					query, "and");
			if (containerContainsContent) {
				Query qry = em.createQuery(query);
				if (manuId != 0) {
					qry.setParameter("manuId", manuId);

				}
				if (name != null)
					if (name.length() > 0) {
						if (qryCndn.equalsIgnoreCase(ReturnConstant.LIKE))
							qry.setParameter("nameLike", nameLike);
						else if (qryCndn
								.equalsIgnoreCase(ReturnConstant.EQUALS)) {
							qry.setParameter("name", name);
						}

					}

				if (code != null)
					if (code.length() > 0) {
						qry.setParameter("code", code);

					}
				if (cmpnyId != 0) {
					qry.setParameter("companyId", cmpnyId);

				}

				manus = (List<ManufacturerMaster>) qry.getResultList();
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("Check data to be searched", e);
		} finally {
			if(em != null) em.close();
		}
		return manus;
	}
	
	@Override
	public String createOrUpdateExpiryInvoice(Expiry expiry)
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
				StringWriter sw = new StringWriter();
				//File file = new	 File("D:\\2017-04-25\\file_expiry_invoice_creation.xml");
				JAXBContext jaxbContext = JAXBContext
						.newInstance(Expiry.class);
				Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

				jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,
						true);
				//jaxbMarshaller.marshal(expiry, file);
				//jaxbMarshaller.marshal(sales, System.out);
				jaxbMarshaller.marshal(expiry, sw);
				String result = sw.toString();
				//System.out.println("output string:: "+result);
				callableStatement = connection
						.prepareCall(StoredProcedures.PROC_CREATE_EXPIRY_INVOICE);
				callableStatement.setString(1, result);
				callableStatement.setString(2, "expiry");
				callableStatement.setString(3, "expiryDetails");
				
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
	public List<TaxTypeDTO> getAllTaxType(CommonResultSetMapper mapper)
			throws DAOException {

		EntityManager em = null;
		CallableStatement callableStatement = null;
		Connection connection = null;
		ResultSet rs = null;
		List<TaxTypeDTO> taxTypeDTOs=new ArrayList<>();

		try {
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();

			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();
			connection = sessionFactory.getConnectionProvider().getConnection();

			callableStatement = connection
					.prepareCall(StoredProcedures.PROC_GET_ALL_TAXTYPE);
			callableStatement.setInt(1, mapper.getCompanyId());
			callableStatement.setInt(2, mapper.getStoreId());
			callableStatement.execute();
			rs = callableStatement.getResultSet();

			ReflectionResultSetMapper<TaxTypeDTO> resultSetMapper1 = new ReflectionResultSetMapper<TaxTypeDTO>(
					TaxTypeDTO.class);

			while (rs.next()) {
				TaxTypeDTO taxTypeDTO=new TaxTypeDTO();
				taxTypeDTO = resultSetMapper1.mapRow(rs);
				taxTypeDTOs.add(taxTypeDTO);

			}

			//logger.info("taxtype fetched");

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

		return taxTypeDTOs;
	}
	
	@Override
	public List<VariantTypeDTO> getAllVariantType(CommonResultSetMapper mapper)
			throws DAOException {

		EntityManager em = null;
		CallableStatement callableStatement = null;
		Connection connection = null;
		ResultSet rs = null;
		List<VariantTypeDTO> variantTypeDTOs=new ArrayList<>();

		try {
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();

			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();
			connection = sessionFactory.getConnectionProvider().getConnection();

			callableStatement = connection
					.prepareCall(StoredProcedures.PROC_GET_ALL_VARIANT_TYPE);
			callableStatement.setInt(1, mapper.getCompanyId());
			callableStatement.setInt(2, mapper.getStoreId());
			callableStatement.execute();
			rs = callableStatement.getResultSet();

			ReflectionResultSetMapper<VariantTypeDTO> resultSetMapper1 = new ReflectionResultSetMapper<VariantTypeDTO>(
					VariantTypeDTO.class);

			while (rs.next()) {
				VariantTypeDTO variantTypeDTO=new VariantTypeDTO();
				variantTypeDTO = resultSetMapper1.mapRow(rs);
				variantTypeDTOs.add(variantTypeDTO);

			}

			//logger.info("getAllVariantType fetched");

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

		return variantTypeDTOs;
	}
	
	@Override
	public ControlAccessItemWiseDTO getControlAccessItemWise(CommonResultSetMapper mapper)
			throws DAOException {

		EntityManager em = null;
		CallableStatement callableStatement = null;
		Connection connection = null;
		ResultSet rs = null;
		ControlAccessItemWiseDTO accessItemWiseDTO=new ControlAccessItemWiseDTO();
		

		try {
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();

			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();
			connection = sessionFactory.getConnectionProvider().getConnection();

			callableStatement = connection
					.prepareCall(StoredProcedures.PROC_GET_ALL_CONTROL_ACCESS_ITEMWISE);
			callableStatement.setInt(1, mapper.getCompanyId());
			callableStatement.setInt(2, mapper.getStoreId());
			callableStatement.setInt(3, mapper.getItemId());
			callableStatement.execute();
			rs = callableStatement.getResultSet();

			ReflectionResultSetMapper<ControlAccessItemWiseDTO> resultSetMapper1 = new ReflectionResultSetMapper<ControlAccessItemWiseDTO>(
					ControlAccessItemWiseDTO.class);

			while (rs.next()) {
				
				accessItemWiseDTO = resultSetMapper1.mapRow(rs);

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

		return accessItemWiseDTO;
	}
	
	@Override
	public List<VariantDTO> getAllVariant(CommonResultSetMapper mapper)
			throws DAOException {

		EntityManager em = null;
		CallableStatement callableStatement = null;
		Connection connection = null;
		ResultSet rs = null;
		List<VariantDTO> variantDTOs=new ArrayList<>();

		try {
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();

			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();
			connection = sessionFactory.getConnectionProvider().getConnection();

			callableStatement = connection
					.prepareCall(StoredProcedures.PROC_GET_ALL_VARIANT);
			callableStatement.setInt(1, mapper.getCompanyId());
			callableStatement.setInt(2, mapper.getStoreId());
			callableStatement.setInt(3, mapper.getVariantTypeId());
			callableStatement.setString(4, mapper.getVariantTypeName());
			callableStatement.execute();
			rs = callableStatement.getResultSet();

			ReflectionResultSetMapper<VariantDTO> resultSetMapper1 = new ReflectionResultSetMapper<VariantDTO>(
					VariantDTO.class);

			while (rs.next()) {
				VariantDTO variantDTO=new VariantDTO();
				variantDTO = resultSetMapper1.mapRow(rs);
				variantDTOs.add(variantDTO);

			}

			//logger.info("getAllVariant fetched");

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

		return variantDTOs;
	}
	
	@Override
	public List<AccountTypeDTO> getAllAccountType(CommonResultSetMapper mapper)
			throws DAOException {

		EntityManager em = null;
		CallableStatement callableStatement = null;
		Connection connection = null;
		ResultSet rs = null;
		List<AccountTypeDTO> accountTypeDTOs=new ArrayList<>();

		try {
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();

			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();
			connection = sessionFactory.getConnectionProvider().getConnection();

			callableStatement = connection
					.prepareCall(StoredProcedures.PROC_GET_ALL_ACCOUNT_TYPE);
			callableStatement.setInt(1, mapper.getCompanyId());
			callableStatement.setInt(2, mapper.getStoreId());
			callableStatement.execute();
			rs = callableStatement.getResultSet();

			ReflectionResultSetMapper<AccountTypeDTO> resultSetMapper1 = new ReflectionResultSetMapper<AccountTypeDTO>(
					AccountTypeDTO.class);

			while (rs.next()) {
				AccountTypeDTO accountTypeDTO=new AccountTypeDTO();
				accountTypeDTO.setId(rs.getInt(1));
				accountTypeDTO.setTypeName(rs.getString(2));
				//accountTypeDTO = resultSetMapper1.mapRow(rs);
				accountTypeDTOs.add(accountTypeDTO);

			}

			//logger.info("getAllAccountType fetched");

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

		return accountTypeDTOs;
	}
	
	@Override
	public List<ChargeDTO> getAllCharges(CommonResultSetMapper mapper)
			throws DAOException {

		EntityManager em = null;
		CallableStatement callableStatement = null;
		Connection connection = null;
		ResultSet rs = null;
		List<ChargeDTO> chargeDTOs=new ArrayList<>();

		try {
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();

			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();
			connection = sessionFactory.getConnectionProvider().getConnection();

			callableStatement = connection
					.prepareCall(StoredProcedures.PROC_GET_ALL_CHARGES);
			callableStatement.setInt(1, mapper.getCompanyId());
			callableStatement.setInt(2, mapper.getStoreId());
			callableStatement.setInt(3, mapper.getId());
			callableStatement.setString(4, mapper.getName());
			callableStatement.execute();
			rs = callableStatement.getResultSet();

			ReflectionResultSetMapper<ChargeDTO> resultSetMapper1 = new ReflectionResultSetMapper<ChargeDTO>(
					ChargeDTO.class);

			while (rs.next()) {
				ChargeDTO chargeDTO =new ChargeDTO();
				chargeDTO = resultSetMapper1.mapRow(rs);
				chargeDTOs.add(chargeDTO);

			}

			//logger.info("charges fetched");

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

		return chargeDTOs;
	}
	
	@Override
	public List<AccountGroupDTO> getAllAccountGroup(CommonResultSetMapper mapper)
			throws DAOException {

		//System.out.println("getAllAccountGroup mapper = "+mapper);
		EntityManager em = null;
		CallableStatement callableStatement = null;
		Connection connection = null;
		ResultSet rs = null;
		List<AccountGroupDTO> accountGrpDTOs=new ArrayList<>();

		try {
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();

			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();
			connection = sessionFactory.getConnectionProvider().getConnection();

			callableStatement = connection
					.prepareCall(StoredProcedures.PROC_GET_ALL_ACCOUNT_GRP);
			callableStatement.setInt(1, mapper.getCompanyId());
			callableStatement.setInt(2, mapper.getStoreId());
			callableStatement.setString(3, mapper.getAccntGrpName());
			callableStatement.execute();
			rs = callableStatement.getResultSet();

			ReflectionResultSetMapper<AccountGroupDTO> resultSetMapper1 = new ReflectionResultSetMapper<AccountGroupDTO>(
					AccountGroupDTO.class);

			while (rs.next()) {
				AccountGroupDTO accountGRPDTO=new AccountGroupDTO();
				accountGRPDTO = resultSetMapper1.mapRow(rs);
				accountGrpDTOs.add(accountGRPDTO);

			}

			//logger.info("all accnt grps fetched");

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

		//System.out.println("getAllAccountGroup result accountGrpDTOs = "+accountGrpDTOs);
		return accountGrpDTOs;
	}
	
	@Override
	public AccountGroupDTO getAccountGroupById(CommonResultSetMapper mapper)
			throws DAOException {

		EntityManager em = null;
		CallableStatement callableStatement = null;
		Connection connection = null;
		ResultSet rs = null;
		AccountGroupDTO accountGrpDTO=new AccountGroupDTO();

		try {
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();

			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();
			connection = sessionFactory.getConnectionProvider().getConnection();

			callableStatement = connection
					.prepareCall(StoredProcedures.PROC_GET_ACCOUNT_GRP_BY_ID);
			callableStatement.setInt(1, mapper.getCompanyId());
			callableStatement.setInt(2, mapper.getStoreId());
			callableStatement.setInt(3, mapper.getId());
			callableStatement.execute();
			rs = callableStatement.getResultSet();

			ReflectionResultSetMapper<AccountGroupDTO> resultSetMapper1 = new ReflectionResultSetMapper<AccountGroupDTO>(
					AccountGroupDTO.class);

			while (rs.next()) {
				
				accountGrpDTO = resultSetMapper1.mapRow(rs);
				

			}

			//logger.info("accnt grp by idfetched");

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

		return accountGrpDTO;
	}
	
	@Override
	public VariantDTO getVariantById(CommonResultSetMapper mapper)
			throws DAOException {

		EntityManager em = null;
		CallableStatement callableStatement = null;
		Connection connection = null;
		ResultSet rs = null;
		VariantDTO variantDTO=new VariantDTO();

		try {
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();

			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();
			connection = sessionFactory.getConnectionProvider().getConnection();

			callableStatement = connection
					.prepareCall(StoredProcedures.PROC_GET_VARIANT_BY_ID);
			callableStatement.setInt(1, mapper.getCompanyId());
			callableStatement.setInt(2, mapper.getStoreId());
			callableStatement.setInt(3, mapper.getId());
			callableStatement.execute();
			rs = callableStatement.getResultSet();

			ReflectionResultSetMapper<VariantDTO> resultSetMapper1 = new ReflectionResultSetMapper<VariantDTO>(
					VariantDTO.class);

			while (rs.next()) {
				
				variantDTO = resultSetMapper1.mapRow(rs);
				

			}

			//logger.info("variant by idfetched");

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

		return variantDTO;
	}

	@Override
	public ResponseObj createAccountGroup(AccountGroupDTO accountGroupDTO)
			throws DAOException {
		// TODO Auto-generated method stub
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
				
				
				callableStatement = connection
						.prepareCall(StoredProcedures.PROC_CREATE_ACCOUNT_GROUP);
				callableStatement.setString(1, accountGroupDTO.getName());
				callableStatement.setString(2, accountGroupDTO.getCode());
				callableStatement.setString(3, accountGroupDTO.getDescription());
				callableStatement.setInt(4, accountGroupDTO.getAccountTypeId());
				callableStatement.setInt(5, accountGroupDTO.getCompanyId());
				callableStatement.setInt(6, accountGroupDTO.getStoreId());
				callableStatement.setInt(7, accountGroupDTO.getCreatedBy());
				
				
				
				callableStatement.registerOutParameter(8,
						java.sql.Types.INTEGER);

				callableStatement.execute();
				status = callableStatement.getInt(8);
				
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
				responseObj.setStatus(ReturnConstant.FAILURE);
				responseObj.setId(0);
				responseObj.setReason("Record not saved successfully.");
			}
			em.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			responseObj.setStatus(ReturnConstant.FAILURE);
			responseObj.setId(0);
			responseObj.setReason("Record not saved successfully.");
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
	public ResponseObj createCity(CommonResultSetMapper commonResultSetMapper)
			throws DAOException {
		// TODO Auto-generated method stub
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
				
				
				callableStatement = connection
						.prepareCall(StoredProcedures.PROC_CREATE_CITIES);
				callableStatement.setString(1, commonResultSetMapper.getName());
				callableStatement.setInt(2, commonResultSetMapper.getStateId());			
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
				responseObj.setStatus(ReturnConstant.FAILURE);
				responseObj.setId(0);
				responseObj.setReason("Record not saved successfully.");
			}
			em.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			responseObj.setStatus(ReturnConstant.FAILURE);
			responseObj.setId(0);
			responseObj.setReason("Record not saved successfully.");
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
	public ResponseObj createArea(CommonResultSetMapper commonResultSetMapper)
			throws DAOException {
		// TODO Auto-generated method stub
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
				
				callableStatement = connection
						.prepareCall(StoredProcedures.PROC_CREATE_AREAS);
				callableStatement.setString(1, commonResultSetMapper.getName());
				callableStatement.setInt(2, commonResultSetMapper.getZoneId());	
				callableStatement.setInt(3, commonResultSetMapper.getCompanyId());	
				callableStatement.setInt(4, commonResultSetMapper.getStoreId());	
				callableStatement.registerOutParameter(5,
						java.sql.Types.INTEGER);

				callableStatement.execute();
				status = callableStatement.getInt(5);
				
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
				responseObj.setStatus(ReturnConstant.FAILURE);
				responseObj.setId(0);
				responseObj.setReason("Record not saved successfully.");
			}
			em.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			responseObj.setStatus(ReturnConstant.FAILURE);
			responseObj.setId(0);
			responseObj.setReason("Record not saved successfully.");
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
	public ResponseObj createZone(CommonResultSetMapper commonResultSetMapper)
			throws DAOException {
		// TODO Auto-generated method stub
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
				
				callableStatement = connection
						.prepareCall(StoredProcedures.PROC_CREATE_ZONES);
				callableStatement.setString(1, commonResultSetMapper.getName());
				callableStatement.setString(2, commonResultSetMapper.getDistrictName());
				callableStatement.setInt(3, commonResultSetMapper.getCityId());
				callableStatement.setInt(4, commonResultSetMapper.getCompanyId());
				callableStatement.setInt(5, commonResultSetMapper.getStoreId());
				callableStatement.registerOutParameter(6,
						java.sql.Types.INTEGER);

				callableStatement.execute();
				status = callableStatement.getInt(6);
				
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
				responseObj.setStatus(ReturnConstant.FAILURE);
				responseObj.setId(0);
				responseObj.setReason("Record not saved successfully.");
			}
			em.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			responseObj.setStatus(ReturnConstant.FAILURE);
			responseObj.setId(0);
			responseObj.setReason("Record not saved successfully.");
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
	public ResponseObj updateCity(CommonResultSetMapper commonResultSetMapper)
			throws DAOException {
		// TODO Auto-generated method stub
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
				
				callableStatement = connection
						.prepareCall(StoredProcedures.PROC_UPDATE_CITIES);
				callableStatement.setInt(1, commonResultSetMapper.getId());
				callableStatement.setString(2, commonResultSetMapper.getName());
				callableStatement.setInt(3, commonResultSetMapper.getStateId());			
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
				responseObj.setStatus(ReturnConstant.FAILURE);
				responseObj.setId(0);
				responseObj.setReason("Record not saved successfully.");
			}
			em.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			responseObj.setStatus(ReturnConstant.FAILURE);
			responseObj.setId(0);
			responseObj.setReason("Record not saved successfully.");
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
	public ResponseObj updateZone(CommonResultSetMapper commonResultSetMapper)
			throws DAOException {
		// TODO Auto-generated method stub
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
				
				callableStatement = connection
						.prepareCall(StoredProcedures.PROC_UPDATE_ZONES);
				callableStatement.setInt(1, commonResultSetMapper.getId());
				callableStatement.setString(2, commonResultSetMapper.getName());
				callableStatement.setString(3, commonResultSetMapper.getDistrictName());
				callableStatement.setInt(4, commonResultSetMapper.getCityId());		
				callableStatement.setInt(5, commonResultSetMapper.getCompanyId());		
				callableStatement.setInt(6, commonResultSetMapper.getStoreId());		
				callableStatement.registerOutParameter(7,
						java.sql.Types.INTEGER);

				callableStatement.execute();
				status = callableStatement.getInt(7);
				
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
				responseObj.setStatus(ReturnConstant.FAILURE);
				responseObj.setId(0);
				responseObj.setReason("Record not saved successfully.");
			}
			em.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			responseObj.setStatus(ReturnConstant.FAILURE);
			responseObj.setId(0);
			responseObj.setReason("Record not saved successfully.");
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
	public ResponseObj updateArea(CommonResultSetMapper commonResultSetMapper)
			throws DAOException {
		// TODO Auto-generated method stub
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
				
				callableStatement = connection
						.prepareCall(StoredProcedures.PROC_UPDATE_AREAS);
				callableStatement.setInt(1, commonResultSetMapper.getId());
				callableStatement.setString(2, commonResultSetMapper.getName());
				callableStatement.setInt(3, commonResultSetMapper.getZoneId());		
				callableStatement.setInt(4, commonResultSetMapper.getCompanyId());		
				callableStatement.setInt(5, commonResultSetMapper.getStoreId());		
				callableStatement.registerOutParameter(6,
						java.sql.Types.INTEGER);

				callableStatement.execute();
				status = callableStatement.getInt(6);
				
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
				responseObj.setStatus(ReturnConstant.FAILURE);
				responseObj.setId(0);
				responseObj.setReason("Record not saved successfully.");
			}
			em.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			responseObj.setStatus(ReturnConstant.FAILURE);
			responseObj.setId(0);
			responseObj.setReason("Record not saved successfully.");
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
	public ResponseObj deleteCity(CommonResultSetMapper commonResultSetMapper)
			throws DAOException {
		// TODO Auto-generated method stub
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
				
				callableStatement = connection
						.prepareCall(StoredProcedures.PROC_DELETE_CITIES);
				callableStatement.setInt(1, commonResultSetMapper.getId());
				callableStatement.setInt(2, commonResultSetMapper.getStateId());			
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
				responseObj.setStatus(ReturnConstant.FAILURE);
				responseObj.setId(0);
				responseObj.setReason("Record not saved successfully.");
			}
			em.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			responseObj.setStatus(ReturnConstant.FAILURE);
			responseObj.setId(0);
			responseObj.setReason("Record not saved successfully.");
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
	public ResponseObj deleteZone(CommonResultSetMapper commonResultSetMapper)
			throws DAOException {
		// TODO Auto-generated method stub
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
				
				callableStatement = connection
						.prepareCall(StoredProcedures.PROC_DELETE_ZONES);
				callableStatement.setInt(1, commonResultSetMapper.getId());
				callableStatement.registerOutParameter(2,
						java.sql.Types.INTEGER);

				callableStatement.execute();
				status = callableStatement.getInt(2);
				
				if (status >0) {
					
					responseObj.setStatus(ReturnConstant.SUCCESS);
					responseObj.setId(status);
					responseObj.setReason("Record deleted successfully.");
					
				} else {
					
					responseObj.setStatus(ReturnConstant.FAILURE);
					responseObj.setId(status);
					responseObj.setReason("Record not deleted successfully.");
					
				}
				
			} 
			
			catch (SQLException e) {
				e.printStackTrace();
				responseObj.setStatus(ReturnConstant.FAILURE);
				responseObj.setId(0);
				responseObj.setReason("Record not deleted successfully.");
			}
			catch (Exception e) {
				e.printStackTrace();
				responseObj.setStatus(ReturnConstant.FAILURE);
				responseObj.setId(0);
				responseObj.setReason("Record not deleted successfully.");
			}
			em.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			responseObj.setStatus(ReturnConstant.FAILURE);
			responseObj.setId(0);
			responseObj.setReason("Record not deleted successfully.");
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
	public ResponseObj deleteArea(CommonResultSetMapper commonResultSetMapper)
			throws DAOException {
		// TODO Auto-generated method stub
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
				
				callableStatement = connection
						.prepareCall(StoredProcedures.PROC_DELETE_AREAS);
				callableStatement.setInt(1, commonResultSetMapper.getId());
				callableStatement.registerOutParameter(2,
						java.sql.Types.INTEGER);

				callableStatement.execute();
				status = callableStatement.getInt(2);
				
				if (status >0) {
					
					responseObj.setStatus(ReturnConstant.SUCCESS);
					responseObj.setId(status);
					responseObj.setReason("Record deleted successfully.");
					
				} else {
					
					responseObj.setStatus(ReturnConstant.FAILURE);
					responseObj.setId(status);
					responseObj.setReason("Record not deleted successfully.");
					
				}
				
			} 
			
			catch (SQLException e) {
				e.printStackTrace();
				responseObj.setStatus(ReturnConstant.FAILURE);
				responseObj.setId(0);
				responseObj.setReason("Record not deleted successfully.");
			}
			catch (Exception e) {
				e.printStackTrace();
				responseObj.setStatus(ReturnConstant.FAILURE);
				responseObj.setId(0);
				responseObj.setReason("Record not deleted successfully.");
			}
			em.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			responseObj.setStatus(ReturnConstant.FAILURE);
			responseObj.setId(0);
			responseObj.setReason("Record not deleted successfully.");
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
	public ResponseObj updateAccountGroup(AccountGroupDTO accountGroupDTO)
			throws DAOException {
		// TODO Auto-generated method stub
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
				
				
				callableStatement = connection
						.prepareCall(StoredProcedures.PROC_UPDATE_ACCOUNT_GROUP);
				callableStatement.setInt(1, accountGroupDTO.getId());
				callableStatement.setString(2, accountGroupDTO.getName());
				callableStatement.setString(3, accountGroupDTO.getCode());
				callableStatement.setString(4, accountGroupDTO.getDescription());
				callableStatement.setInt(5, accountGroupDTO.getAccountTypeId());
				callableStatement.setInt(6, accountGroupDTO.getCompanyId());
				callableStatement.setInt(7, accountGroupDTO.getStoreId());
				callableStatement.setInt(8, accountGroupDTO.getCreatedBy());
				
				
				
				callableStatement.registerOutParameter(9,
						java.sql.Types.INTEGER);

				callableStatement.execute();
				status = callableStatement.getInt(9);
				
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
				responseObj.setStatus(ReturnConstant.FAILURE);
				responseObj.setId(0);
				responseObj.setReason("Record not saved successfully.");
			}
			em.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			responseObj.setStatus(ReturnConstant.FAILURE);
			responseObj.setId(0);
			responseObj.setReason("Record not saved successfully.");
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
	public ResponseObj deleteVariant(CommonResultSetMapper mapper)
			throws DAOException {
		EntityManager em = null;
		Connection connection = null;
		CallableStatement callableStatement = null;
		int result = 0;
		ResponseObj responseObj=new ResponseObj();
		try {
			int id = mapper.getId();
			int storeId = mapper.getStoreId();
			int cmpnyId = mapper.getCompanyId();

			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();
			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();
			connection = sessionFactory.getConnectionProvider().getConnection();
			callableStatement = connection
					.prepareCall(StoredProcedures.PROC_DELETE_VARIANT);
			callableStatement.setInt(1, cmpnyId);
			callableStatement.setInt(2, storeId);
			callableStatement.setInt(3, id);

			callableStatement.registerOutParameter(4, java.sql.Types.INTEGER);

			callableStatement.execute();
			result = callableStatement.getInt(4);
			
			if (result >0) {
				
				responseObj.setStatus(ReturnConstant.SUCCESS);
				responseObj.setId(result);
				responseObj.setReason("variant deleted successfully.");
				
			} else {
				
				responseObj.setStatus(ReturnConstant.FAILURE);
				responseObj.setId(result);
				responseObj.setReason("variant not deleted successfully.");
				
			}

		} catch (Exception e) {
			e.printStackTrace();
			responseObj.setStatus(ReturnConstant.FAILURE);
			responseObj.setId(0);
			responseObj.setReason("variant not deleted successfully.");
			throw new DAOException("Check data to be deleted", e);
		}

		finally {
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
	public ResponseObj deleteAccountGroup(CommonResultSetMapper mapper)
			throws DAOException {
		EntityManager em = null;
		Connection connection = null;
		CallableStatement callableStatement = null;
		int result = 0;
		ResponseObj responseObj=new ResponseObj();
		try {
			int accgrpid = mapper.getId();
			int storeId = mapper.getStoreId();
			int cmpnyId = mapper.getCompanyId();

			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();
			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();
			connection = sessionFactory.getConnectionProvider().getConnection();
			callableStatement = connection
					.prepareCall(StoredProcedures.PROC_DELETE_ACCOUNT_GROUP);
			callableStatement.setInt(1, cmpnyId);
			callableStatement.setInt(2, storeId);
			callableStatement.setInt(3, accgrpid);

			callableStatement.registerOutParameter(4, java.sql.Types.INTEGER);

			callableStatement.execute();
			result = callableStatement.getInt(4);
			
			if (result >0) {
				
				responseObj.setStatus(ReturnConstant.SUCCESS);
				responseObj.setId(result);
				responseObj.setReason("account group deleted successfully.");
				
			} else {
				
				responseObj.setStatus(ReturnConstant.FAILURE);
				responseObj.setId(result);
				responseObj.setReason("account group not deleted successfully.");
				
			}

		} catch (Exception e) {
			e.printStackTrace();
			responseObj.setStatus(ReturnConstant.FAILURE);
			responseObj.setId(0);
			responseObj.setReason("distributor not deleted successfully.");
			throw new DAOException("Check data to be deleted", e);
		}

		finally {
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
	public List<CountryMaster> getCountryList(CommonResultSetMapper mapper)
			throws DAOException {
		List<CountryMaster> countryMasters = new ArrayList<>();
		EntityManager em = null;

		try {
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();

			Query qry = em
					.createQuery("SELECT cm FROM CountryMaster cm");

			countryMasters = (List<CountryMaster>) qry.getResultList();

			//logger.info("CountryMaster fetched");

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("In DAOException", e);

		} finally {
			if(em != null) em.close();
		}

		return countryMasters;
	}
	
	@Override
	public List<StateDTO> getStateByCountryList(CommonResultSetMapper mapper)
			throws DAOException {

		EntityManager em = null;
		CallableStatement callableStatement = null;
		Connection connection = null;
		ResultSet rs = null;
		List<StateDTO> states=new ArrayList<>();

		try {
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();

			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();
			connection = sessionFactory.getConnectionProvider().getConnection();

			callableStatement = connection
					.prepareCall(StoredProcedures.PROC_GET_ALL_STATES_BY_COUNTRY);
			callableStatement.setInt(1, mapper.getCompanyId());
			callableStatement.setInt(2, mapper.getStoreId());
			callableStatement.setInt(3, mapper.getCountryId());
			callableStatement.execute();
			rs = callableStatement.getResultSet();

			ReflectionResultSetMapper<StateDTO> resultSetMapper1 = new ReflectionResultSetMapper<StateDTO>(
					StateDTO.class);

			while (rs.next()) {
				StateDTO state=new StateDTO();
				state = resultSetMapper1.mapRow(rs);
				states.add(state);

			}

			//logger.info("all states fetched");

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

		return states;
	}
	
	@Override
	public List<CityDTO> getCityByStateList(CommonResultSetMapper mapper)
			throws DAOException {

		EntityManager em = null;
		CallableStatement callableStatement = null;
		Connection connection = null;
		ResultSet rs = null;
		List<CityDTO> cities=new ArrayList<>();

		try {
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();

			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();
			connection = sessionFactory.getConnectionProvider().getConnection();

			callableStatement = connection
					.prepareCall(StoredProcedures.PROC_GET_ALL_CITIES_BY_STATE);
			callableStatement.setInt(1, mapper.getCompanyId());
			callableStatement.setInt(2, mapper.getStoreId());
			callableStatement.setInt(3, mapper.getStateId());
			callableStatement.execute();
			rs = callableStatement.getResultSet();

			ReflectionResultSetMapper<CityDTO> resultSetMapper1 = new ReflectionResultSetMapper<CityDTO>(
					CityDTO.class);

			while (rs.next()) {
				CityDTO city=new CityDTO();
				city = resultSetMapper1.mapRow(rs);
				cities.add(city);

			}

			//logger.info("all cities fetched");

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

		return cities;
	}
	
	@Override
	public List<CityDTO> getCityByNameList(CommonResultSetMapper mapper)
			throws DAOException {

		EntityManager em = null;
		CallableStatement callableStatement = null;
		Connection connection = null;
		ResultSet rs = null;
		List<CityDTO> cities=new ArrayList<>();

		try {
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();

			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();
			connection = sessionFactory.getConnectionProvider().getConnection();

			callableStatement = connection
					.prepareCall(StoredProcedures.PROC_GET_ALL_CITIES_BY_NAME);
			callableStatement.setInt(1, mapper.getCompanyId());
			callableStatement.setInt(2, mapper.getStoreId());
			callableStatement.setInt(3, mapper.getStateId());
			callableStatement.setString(4, mapper.getName());
			callableStatement.execute();
			rs = callableStatement.getResultSet();

			ReflectionResultSetMapper<CityDTO> resultSetMapper1 = new ReflectionResultSetMapper<CityDTO>(
					CityDTO.class);

			while (rs.next()) {
				CityDTO city=new CityDTO();
				city = resultSetMapper1.mapRow(rs);
				cities.add(city);

			}

			//logger.info("all cities fetched");

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

		return cities;
	}
	
	@Override
	public List<ZoneDTO> getZoneByNameList(CommonResultSetMapper mapper)
			throws DAOException {

		EntityManager em = null;
		CallableStatement callableStatement = null;
		Connection connection = null;
		ResultSet rs = null;
		List<ZoneDTO> zones=new ArrayList<>();

		try {
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();

			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();
			connection = sessionFactory.getConnectionProvider().getConnection();

			callableStatement = connection
					.prepareCall(StoredProcedures.PROC_GET_ALL_ZONES_BY_NAME);
			callableStatement.setInt(1, mapper.getCompanyId());
			callableStatement.setInt(2, mapper.getStoreId());
			callableStatement.setInt(3, mapper.getCityId());
			callableStatement.setString(4, mapper.getName());
			callableStatement.execute();
			rs = callableStatement.getResultSet();

			ReflectionResultSetMapper<ZoneDTO> resultSetMapper1 = new ReflectionResultSetMapper<ZoneDTO>(
					ZoneDTO.class);

			while (rs.next()) {
				ZoneDTO zone=new ZoneDTO();
				zone = resultSetMapper1.mapRow(rs);
				zones.add(zone);

			}

			//logger.info("all zones fetched");

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

		return zones;
	}
	
	@Override
	public List<ZoneDTO> getZoneByCityList(CommonResultSetMapper mapper)
			throws DAOException {

		EntityManager em = null;
		CallableStatement callableStatement = null;
		Connection connection = null;
		ResultSet rs = null;
		List<ZoneDTO> zones=new ArrayList<>();

		try {
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();

			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();
			connection = sessionFactory.getConnectionProvider().getConnection();

			callableStatement = connection
					.prepareCall(StoredProcedures.PROC_GET_ALL_ZONES_BY_CITY);
			callableStatement.setInt(1, mapper.getCompanyId());
			callableStatement.setInt(2, mapper.getStoreId());
			callableStatement.setInt(3, mapper.getCityId());
			callableStatement.execute();
			rs = callableStatement.getResultSet();

			ReflectionResultSetMapper<ZoneDTO> resultSetMapper1 = new ReflectionResultSetMapper<ZoneDTO>(
					ZoneDTO.class);

			while (rs.next()) {
				ZoneDTO zone=new ZoneDTO();
				zone = resultSetMapper1.mapRow(rs);
				zones.add(zone);

			}

			//logger.info("all cities fetched");

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

		return zones;
	}
	
	@Override
	public List<AreaDTO> getAreaByZoneList(CommonResultSetMapper mapper)
			throws DAOException {

		EntityManager em = null;
		CallableStatement callableStatement = null;
		Connection connection = null;
		ResultSet rs = null;
		List<AreaDTO> areas=new ArrayList<>();

		try {
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();

			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();
			connection = sessionFactory.getConnectionProvider().getConnection();

			callableStatement = connection
					.prepareCall(StoredProcedures.PROC_GET_ALL_AREAS_BY_ZONE);
			callableStatement.setInt(1, mapper.getCompanyId());
			callableStatement.setInt(2, mapper.getStoreId());
			callableStatement.setInt(3, mapper.getZoneId());
			callableStatement.execute();
			rs = callableStatement.getResultSet();

			ReflectionResultSetMapper<AreaDTO> resultSetMapper1 = new ReflectionResultSetMapper<AreaDTO>(
					AreaDTO.class);

			while (rs.next()) {
				AreaDTO area=new AreaDTO();
				area = resultSetMapper1.mapRow(rs);
				areas.add(area);

			}

			//logger.info("all areas fetched");

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

		return areas;
	}
	
	@Override
	public List<AreaDTO> getAreaByNameList(CommonResultSetMapper mapper)
			throws DAOException {

		EntityManager em = null;
		CallableStatement callableStatement = null;
		Connection connection = null;
		ResultSet rs = null;
		List<AreaDTO> areas=new ArrayList<>();

		try {
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();

			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();
			connection = sessionFactory.getConnectionProvider().getConnection();

			callableStatement = connection
					.prepareCall(StoredProcedures.PROC_GET_ALL_AREAS_BY_NAME);
			callableStatement.setInt(1, mapper.getCompanyId());
			callableStatement.setInt(2, mapper.getStoreId());
			callableStatement.setInt(3, mapper.getZoneId());
			callableStatement.setString(4, mapper.getName());
			callableStatement.execute();
			rs = callableStatement.getResultSet();

			ReflectionResultSetMapper<AreaDTO> resultSetMapper1 = new ReflectionResultSetMapper<AreaDTO>(
					AreaDTO.class);

			while (rs.next()) {
				AreaDTO area=new AreaDTO();
				area = resultSetMapper1.mapRow(rs);
				areas.add(area);

			}

			//logger.info("all areas fetched");

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

		return areas;
	}

	@Override
	public ResponseObj createSalesMan(SalesmanMaster salesmanMaster)
			throws DAOException {
		// TODO Auto-generated method stub
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
						
						callableStatement = connection
								.prepareCall(StoredProcedures.PROC_CREATE_SALESMAN);
						callableStatement.setString(1, salesmanMaster.getName());
						callableStatement.setString(2, salesmanMaster.getEmpId());
						callableStatement.setString(3, salesmanMaster.getAddress());
						callableStatement.setInt(4, salesmanMaster.getCountryId());
						callableStatement.setInt(5, salesmanMaster.getStateId());
						callableStatement.setInt(6, salesmanMaster.getCityId());
						callableStatement.setString(7, salesmanMaster.getPin());
						callableStatement.setString(8, salesmanMaster.getPhoneNo());
						callableStatement.setString(9, salesmanMaster.getAddharCardNo());
						callableStatement.setString(10, salesmanMaster.getPanNo());
						callableStatement.setDouble(11, salesmanMaster.getCommissionPercentage());
						callableStatement.setInt(12, salesmanMaster.getCompanyId());
						callableStatement.setInt(13, salesmanMaster.getStoreId());
						callableStatement.setInt(14, salesmanMaster.getFinyrID());
						callableStatement.setInt(15, salesmanMaster.getCreatedBy());
						callableStatement.registerOutParameter(16,
								java.sql.Types.INTEGER);

						callableStatement.execute();
						status = callableStatement.getInt(16);
						
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
						responseObj.setStatus(ReturnConstant.FAILURE);
						responseObj.setId(0);
						responseObj.setReason("Record not saved successfully.");
					}
					em.getTransaction().commit();

				} catch (Exception e) {
					e.printStackTrace();
					responseObj.setStatus(ReturnConstant.FAILURE);
					responseObj.setId(0);
					responseObj.setReason("Record not saved successfully.");
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
	public ResponseObj createAccount(AccountMaster master)
			throws DAOException {
		// TODO Auto-generated method stub
		//System.out.println("createAccount AccountMaster = "+master);
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
				
				callableStatement = connection
						.prepareCall(StoredProcedures.PROC_CREATE_ACCOUNT);
				callableStatement.setString(1, master.getName());
				callableStatement.setString(2, master.getCode());
				callableStatement.setString(4, master.getGroup_code());
				callableStatement.setInt(3, master.getGroupId());
				//callableStatement.setInt(3, 0);
				callableStatement.setInt(5, master.getCityId());
				callableStatement.setInt(6, master.getZoneId());
				callableStatement.setInt(7, master.getAreaId());
				callableStatement.setString(8, master.getAddress());
				if(master.getPin().equals("") || master.getPin().equals(null))
					callableStatement.setString(9, "0");
				else
					callableStatement.setString(9, master.getPin());
				
				callableStatement.setString(10, master.getPhone());
				callableStatement.setString(11, master.getEmail());
				callableStatement.setString(12, master.getPanNo());
				callableStatement.setString(13, master.getGstRegistrationNo());
				callableStatement.setString(14, master.getBcdaRegistrationNo());
				callableStatement.setString(15, master.getDlNo());
				callableStatement.setDouble(16, master.getCashDiscountPercentage());
				callableStatement.setDouble(17, master.getTransLimit());
				callableStatement.setDouble(18, master.getIsActive());
				callableStatement.setDouble(19, master.getPst_type_id());
				callableStatement.setDouble(20, master.getOpBalance());
				if (master.getAsOnDate()!=null) {
					java.sql.Date asonDate = DateUtil.convertStringDateToSqlDate(
							master.getAsOnDate(), "yyyy-MM-dd");
					callableStatement.setDate(21, asonDate);
				}
				else {
					callableStatement.setDate(21, null);
				}
				callableStatement.setDouble(22, master.getCompanyId());
				callableStatement.setDouble(23, master.getStoreId());
				callableStatement.setDouble(24, master.getFinyrId());
				callableStatement.setDouble(25, master.getCreatedBy());
				callableStatement.setInt(26, master.getDueDays());
				callableStatement.setDouble(27, master.getDuePer());
				callableStatement.registerOutParameter(28,
						java.sql.Types.INTEGER);

				callableStatement.execute();
				status = callableStatement.getInt(28);
				
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
				responseObj.setStatus(ReturnConstant.FAILURE);
				responseObj.setId(0);
				responseObj.setReason("Record not saved successfully.");
			}
			em.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			responseObj.setStatus(ReturnConstant.FAILURE);
			responseObj.setId(0);
			responseObj.setReason("Record not saved successfully.");
			throw new DAOException("Check data to be inserted", e);
		} finally {
			try {
				
				if(callableStatement!=null)
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
	public ResponseObj createCharge(ChargeMaster master)
			throws DAOException {
		// TODO Auto-generated method stub
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
						
						callableStatement = connection
								.prepareCall(StoredProcedures.PROC_CREATE_CHARGE);
						callableStatement.setString(1, master.getName());
						callableStatement.setString(2, master.getCode());
						if (master.getWefDate()!=null) {
							java.sql.Date wefDate = DateUtil.convertStringDateToSqlDate(
									master.getWefDate(), "yyyy-MM-dd");
							callableStatement.setDate(3, wefDate);
						}
						else {
							callableStatement.setDate(3, null);
						}
						callableStatement.setDouble(4, master.getRate());
						callableStatement.setInt(5, master.getFactor());
						callableStatement.setInt(6, master.getIsTaxable());
						callableStatement.setInt(7, master.getCompanyId());
						callableStatement.setInt(8, master.getStoreId());
						callableStatement.setInt(9, master.getCreatedBy());
						
						callableStatement.registerOutParameter(10,
								java.sql.Types.INTEGER);

						callableStatement.execute();
						status = callableStatement.getInt(10);
						
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
						responseObj.setStatus(ReturnConstant.FAILURE);
						responseObj.setId(0);
						responseObj.setReason("Record not saved successfully.");
					}
					em.getTransaction().commit();

				} catch (Exception e) {
					e.printStackTrace();
					responseObj.setStatus(ReturnConstant.FAILURE);
					responseObj.setId(0);
					responseObj.setReason("Record not saved successfully.");
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
	public ResponseObj createVariant(VariantMaster master)
			throws DAOException {
		// TODO Auto-generated method stub
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
						
						callableStatement = connection
								.prepareCall(StoredProcedures.PROC_CREATE_VARIANT);
						callableStatement.setString(1, master.getValue());
						callableStatement.setInt(2, master.getVariantTypeId());
						callableStatement.setInt(3, master.getCompanyId());
						callableStatement.setInt(4, master.getStoreId());
						callableStatement.setInt(5, master.getCreatedBy());
						
						callableStatement.registerOutParameter(6,
								java.sql.Types.INTEGER);

						callableStatement.execute();
						status = callableStatement.getInt(6);
						
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
						responseObj.setStatus(ReturnConstant.FAILURE);
						responseObj.setId(0);
						responseObj.setReason("Record not saved successfully.");
					}
					em.getTransaction().commit();

				} catch (Exception e) {
					e.printStackTrace();
					responseObj.setStatus(ReturnConstant.FAILURE);
					responseObj.setId(0);
					responseObj.setReason("Record not saved successfully.");
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
	public ResponseObj updateVariant(VariantMaster master)
			throws DAOException {
		// TODO Auto-generated method stub
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
						
						callableStatement = connection
								.prepareCall(StoredProcedures.PROC_UPDATE_VARIANT);
						callableStatement.setInt(1, master.getId());
						callableStatement.setString(2, master.getValue());
						callableStatement.setInt(3, master.getVariantTypeId());
						callableStatement.setInt(4, master.getCompanyId());
						callableStatement.setInt(5, master.getStoreId());
						callableStatement.setInt(6, master.getCreatedBy());
						
						callableStatement.registerOutParameter(7,
								java.sql.Types.INTEGER);

						callableStatement.execute();
						status = callableStatement.getInt(7);
						
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
						responseObj.setStatus(ReturnConstant.FAILURE);
						responseObj.setId(0);
						responseObj.setReason("Record not saved successfully.");
					}
					em.getTransaction().commit();

				} catch (Exception e) {
					e.printStackTrace();
					responseObj.setStatus(ReturnConstant.FAILURE);
					responseObj.setId(0);
					responseObj.setReason("Record not saved successfully.");
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
	public ResponseObj updateCharge(ChargeMaster master)
			throws DAOException {
		// TODO Auto-generated method stub
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
						
						callableStatement = connection
								.prepareCall(StoredProcedures.PROC_UPDATE_CHARGE);
						callableStatement.setInt(1, master.getId());
						callableStatement.setString(2, master.getName());
						callableStatement.setString(3, master.getCode());
						if (master.getWefDate()!=null) {
							java.sql.Date wefDate = DateUtil.convertStringDateToSqlDate(
									master.getWefDate(), "yyyy-MM-dd");
							callableStatement.setDate(4, wefDate);
						}
						else {
							callableStatement.setDate(4, null);
						}
						callableStatement.setDouble(5, master.getRate());
						callableStatement.setInt(6, master.getFactor());
						callableStatement.setInt(7, master.getIsTaxable());
						callableStatement.setInt(8, master.getCompanyId());
						callableStatement.setInt(9, master.getStoreId());
						callableStatement.setInt(10, master.getCreatedBy());
						
						callableStatement.registerOutParameter(11,
								java.sql.Types.INTEGER);

						callableStatement.execute();
						status = callableStatement.getInt(11);
						
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
						responseObj.setStatus(ReturnConstant.FAILURE);
						responseObj.setId(0);
						responseObj.setReason("Record not saved successfully.");
					}
					em.getTransaction().commit();

				} catch (Exception e) {
					e.printStackTrace();
					responseObj.setStatus(ReturnConstant.FAILURE);
					responseObj.setId(0);
					responseObj.setReason("Record not saved successfully.");
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
	public ResponseObj updateSalesMan(SalesmanMaster salesmanMaster)
			throws DAOException {
		// TODO Auto-generated method stub
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
						
						callableStatement = connection
								.prepareCall(StoredProcedures.PROC_UPDATE_SALESMAN);
						callableStatement.setInt(1, salesmanMaster.getId());
						callableStatement.setString(2, salesmanMaster.getName());
						callableStatement.setString(3, salesmanMaster.getEmpId());
						callableStatement.setString(4, salesmanMaster.getAddress());
						callableStatement.setInt(5, salesmanMaster.getCountryId());
						callableStatement.setInt(6, salesmanMaster.getStateId());
						callableStatement.setInt(7, salesmanMaster.getCityId());
						callableStatement.setString(8, salesmanMaster.getPin());
						callableStatement.setString(9, salesmanMaster.getPhoneNo());
						callableStatement.setString(10, salesmanMaster.getAddharCardNo());
						callableStatement.setString(11, salesmanMaster.getPanNo());
						callableStatement.setDouble(12, salesmanMaster.getCommissionPercentage());
						callableStatement.setInt(13, salesmanMaster.getCompanyId());
						callableStatement.setInt(14, salesmanMaster.getStoreId());
						callableStatement.setInt(15, salesmanMaster.getFinyrID());
						callableStatement.setInt(16, salesmanMaster.getCreatedBy());
						callableStatement.registerOutParameter(17,
								java.sql.Types.INTEGER);

						callableStatement.execute();
						status = callableStatement.getInt(17);
						
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
						responseObj.setStatus(ReturnConstant.FAILURE);
						responseObj.setId(0);
						responseObj.setReason("Record not saved successfully.");
					}
					em.getTransaction().commit();

				} catch (Exception e) {
					e.printStackTrace();
					responseObj.setStatus(ReturnConstant.FAILURE);
					responseObj.setId(0);
					responseObj.setReason("Record not saved successfully.");
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
	public List<SalesmanDTO> getAllSalesman(CommonResultSetMapper mapper) throws DAOException {
		EntityManager em = null;
		CallableStatement callableStatement = null;
		Connection connection = null;
		ResultSet rs = null;
		List<SalesmanDTO> salesmanDTOs=new ArrayList<>();

		try {
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();

			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();
			connection = sessionFactory.getConnectionProvider().getConnection();

			callableStatement = connection
					.prepareCall(StoredProcedures.PROC_GET_ALL_SALESMAN);
			callableStatement.setInt(1, mapper.getCompanyId());
			callableStatement.setInt(2, mapper.getStoreId());
			callableStatement.setInt(3, mapper.getFinYrId());
			callableStatement.setString(4, mapper.getName());
			if (mapper.getAsOnDate()!=null) {
				java.sql.Date asonDate = DateUtil.convertStringDateToSqlDate(
				mapper.getAsOnDate(), "yyyy-MM-dd");
				callableStatement.setDate(5, asonDate);
			}
			else {
				callableStatement.setDate(5, null);
			}
			callableStatement.execute();
			rs = callableStatement.getResultSet();

			ReflectionResultSetMapper<SalesmanDTO> resultSetMapper1 = new ReflectionResultSetMapper<SalesmanDTO>(
					SalesmanDTO.class);

			while (rs.next()) {
				SalesmanDTO salesmanDTO=new SalesmanDTO();
				salesmanDTO = resultSetMapper1.mapRow(rs);
				salesmanDTOs.add(salesmanDTO);

			}

			//logger.info("taxtype fetched");

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

		return salesmanDTOs;
	}
	
	@Override
	public List<AccountDTO> getAllAccounts(CommonResultSetMapper mapper) throws DAOException {
		EntityManager em = null;
		CallableStatement callableStatement = null;
		Connection connection = null;
		ResultSet rs = null;
		List<AccountDTO> accnts=new ArrayList<>();

		try {
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();

			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();
			connection = sessionFactory.getConnectionProvider().getConnection();

			callableStatement = connection
					.prepareCall(StoredProcedures.PROC_GET_ALL_ACCOUNTS);
			callableStatement.setInt(1, mapper.getCompanyId());
			callableStatement.setInt(2, mapper.getStoreId());
			callableStatement.setInt(3, mapper.getFinYrId());
			callableStatement.setInt(4, mapper.getId());
			callableStatement.setString(5, mapper.getName());
			if (mapper.getAsOnDate()!=null) {
				java.sql.Date asonDate = DateUtil.convertStringDateToSqlDate(
				mapper.getAsOnDate(), "yyyy-MM-dd");
				callableStatement.setDate(6, asonDate);
			}
			else {
				callableStatement.setDate(6, null);
			}
			callableStatement.execute();
			rs = callableStatement.getResultSet();

			ReflectionResultSetMapper<AccountDTO> resultSetMapper1 = new ReflectionResultSetMapper<AccountDTO>(
					AccountDTO.class);

			while (rs.next()) {
				AccountDTO accnt=new AccountDTO();
				accnt = resultSetMapper1.mapRow(rs);
				accnts.add(accnt);

			}

			//logger.info("accnts fetched");

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

		return accnts;
	}

	@Override
	public SalesmanDTO getSalesmanById(CommonResultSetMapper mapper)
			throws DAOException {
		EntityManager em = null;
		CallableStatement callableStatement = null;
		Connection connection = null;
		ResultSet rs = null;
		SalesmanDTO salesmanDTO=new SalesmanDTO();

		try {
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();

			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();
			connection = sessionFactory.getConnectionProvider().getConnection();

			callableStatement = connection
					.prepareCall(StoredProcedures.PROC_GET_SALESMAN_BYID);
			callableStatement.setInt(1, mapper.getCompanyId());
			callableStatement.setInt(2, mapper.getStoreId());
			callableStatement.setInt(3, mapper.getFinYrId());
			callableStatement.setInt(4, mapper.getId());
			if (mapper.getAsOnDate()!=null) {
				java.sql.Date asonDate = DateUtil.convertStringDateToSqlDate(
				mapper.getAsOnDate(), "yyyy-MM-dd");
				callableStatement.setDate(5, asonDate);
			}
			else {
				callableStatement.setDate(5, null);
			}
			callableStatement.execute();
			rs = callableStatement.getResultSet();

			ReflectionResultSetMapper<SalesmanDTO> resultSetMapper1 = new ReflectionResultSetMapper<SalesmanDTO>(
					SalesmanDTO.class);

			while (rs.next()) {
				
				salesmanDTO = resultSetMapper1.mapRow(rs);
				

			}

			//logger.info("salesman fetched");

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

		return salesmanDTO;
	}

	@Override
	public ResponseObj deleteSalesman(CommonResultSetMapper mapper)
			throws DAOException {
		// TODO Auto-generated method stub
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
				
				callableStatement = connection
						.prepareCall(StoredProcedures.PROC_DELETE_SALESMAN);
				callableStatement.setInt(1, mapper.getCompanyId());
				callableStatement.setInt(2, mapper.getStoreId());
				callableStatement.setInt(3, mapper.getId());
				
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
				responseObj.setStatus(ReturnConstant.FAILURE);
				responseObj.setId(0);
				responseObj.setReason("Record not saved successfully.");
			}
			em.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			responseObj.setStatus(ReturnConstant.FAILURE);
			responseObj.setId(0);
			responseObj.setReason("Record not saved successfully.");
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
	public ResponseObj deleteCharge(CommonResultSetMapper mapper)
			throws DAOException {
		// TODO Auto-generated method stub
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
				
				callableStatement = connection
						.prepareCall(StoredProcedures.PROC_DELETE_CHARGE);
				callableStatement.setInt(1, mapper.getCompanyId());
				callableStatement.setInt(2, mapper.getStoreId());
				callableStatement.setInt(3, mapper.getId());
				
				callableStatement.registerOutParameter(4,
						java.sql.Types.INTEGER);

				callableStatement.execute();
				status = callableStatement.getInt(4);
				
				if (status >0) {
					
					responseObj.setStatus(ReturnConstant.SUCCESS);
					responseObj.setId(status);
					responseObj.setReason("Record deleted successfully.");
					
				} else {
					
					responseObj.setStatus(ReturnConstant.FAILURE);
					responseObj.setId(status);
					responseObj.setReason("Record not deleted successfully.");
					
				}
				
			} 
			
			catch (SQLException e) {
				e.printStackTrace();
				responseObj.setStatus(ReturnConstant.FAILURE);
				responseObj.setId(0);
				responseObj.setReason("Record not deleted successfully.");
			}
			catch (Exception e) {
				e.printStackTrace();
				responseObj.setStatus(ReturnConstant.FAILURE);
				responseObj.setId(0);
				responseObj.setReason("Record not deleted successfully.");
			}
			em.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
			responseObj.setStatus(ReturnConstant.FAILURE);
			responseObj.setId(0);
			responseObj.setReason("Record not deleted successfully.");
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
	public List<RetailTypeDTO> getAllRetailType(CommonResultSetMapper mapper)
			throws DAOException {
		// TODO Auto-generated method stub
		EntityManager em = null;
		CallableStatement callableStatement = null;
		Connection connection = null;
		ResultSet rs = null;
		List<RetailTypeDTO> retailTypeDTOs=new ArrayList<>();

		try {
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();

			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();
			connection = sessionFactory.getConnectionProvider().getConnection();

			callableStatement = connection
					.prepareCall(StoredProcedures.PROC_GET_ALL_RETAILTYPE_BYSTORE);
			callableStatement.setInt(1, mapper.getCompanyId());
			callableStatement.setInt(2, mapper.getStoreId());
			
			callableStatement.execute();
			rs = callableStatement.getResultSet();

			ReflectionResultSetMapper<RetailTypeDTO> resultSetMapper1 = new ReflectionResultSetMapper<RetailTypeDTO>(
					RetailTypeDTO.class);

			while (rs.next()) {
				RetailTypeDTO retailTypeDTO=new RetailTypeDTO();
				retailTypeDTO = resultSetMapper1.mapRow(rs);
				retailTypeDTOs.add(retailTypeDTO);

			}

			//logger.info("RetailTypeDTO fetched");

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

		return retailTypeDTOs;
	}

	@Override
	public List<RetailTypeControlDTO> getAllRetailTypeMenuControl(
			CommonResultSetMapper mapper) throws DAOException {
		// TODO Auto-generated method stub
		EntityManager em = null;
		CallableStatement callableStatement = null;
		Connection connection = null;
		ResultSet rs = null;
		List<RetailTypeControlDTO> retailTypeControlDTOs=new ArrayList<>();

		try {
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();

			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();
			connection = sessionFactory.getConnectionProvider().getConnection();

			callableStatement = connection
					.prepareCall(StoredProcedures.PROC_GET_ALL_RETAILTYPE_CONTROLS);
			callableStatement.setInt(1, mapper.getCompanyId());
			callableStatement.setInt(2, mapper.getStoreId());
			callableStatement.setInt(3, mapper.getMenuID());
			callableStatement.setInt(4, mapper.getRetailTypeID());
			
			callableStatement.execute();
			rs = callableStatement.getResultSet();

			ReflectionResultSetMapper<RetailTypeControlDTO> resultSetMapper1 = new ReflectionResultSetMapper<RetailTypeControlDTO>(
					RetailTypeControlDTO.class);

			while (rs.next()) {
				RetailTypeControlDTO retailTypeControlDTO=new RetailTypeControlDTO();
				retailTypeControlDTO = resultSetMapper1.mapRow(rs);
				retailTypeControlDTOs.add(retailTypeControlDTO);

			}

			//logger.info("RetailTypeDTO fetched");

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

		return retailTypeControlDTOs;
	}

	@Override
	public List<LocationDTO> getAllLocation(CommonResultSetMapper mapper) throws DAOException{
		// TODO Auto-generated method stub
				EntityManager em = null;
				CallableStatement callableStatement = null;
				Connection connection = null;
				ResultSet rs = null;
				List<LocationDTO> locationDTOs=new ArrayList<>();
				try {
					entityManagerFactory = PersistenceListener.getEntityManager();
					em = entityManagerFactory.createEntityManager();
					em.getTransaction().begin();

					Session ses = (Session) em.getDelegate();
					SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
							.getSessionFactory();
					connection = sessionFactory.getConnectionProvider().getConnection();

					callableStatement = connection
							.prepareCall(StoredProcedures.PROC_GET_ALL_LOCATIONS);
					callableStatement.setInt(1, mapper.getCompanyId());
					callableStatement.setInt(2, mapper.getStoreId());
					
					callableStatement.execute();
					rs = callableStatement.getResultSet();

					ReflectionResultSetMapper<LocationDTO> resultSetMapper1 = new ReflectionResultSetMapper<LocationDTO>(
							LocationDTO.class);

					while (rs.next()) {
						LocationDTO locationDTO=new LocationDTO();
						locationDTO = resultSetMapper1.mapRow(rs);
						locationDTOs.add(locationDTO);

					}
					//logger.info("locationDTOs fetched");
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

				return locationDTOs;
	}

	//26.03.2018
	
	//16.02.2018 end
	
		//17/02/2018 start
		
		//for testing
	@Override
		public List<AccountDTO> getAccountsByName(CommonResultSetMapper mapper) throws DAOException
		{
			//System.out.println("getAccountsByName mapper = "+mapper);
			List<AccountDTO> accnts = null;
			EntityManager em = null;
			try {

				entityManagerFactory = PersistenceListener.getEntityManager();
				em = entityManagerFactory.createEntityManager();
				Session session = (Session) em.getDelegate();
				session.beginTransaction();
				
				//Query qry = em.createNativeQuery("SELECT obj.id as id, obj.name as name FROM acc_m_account obj");
				org.hibernate.Query query = session.createSQLQuery("SELECT obj.id as id, obj.name as name FROM acc_m_account obj where obj.name like :name");
				query.setParameter("name", "%"+mapper.getName()+"%");
				
				query.setResultTransformer(Transformers.aliasToBean(AccountDTO.class));
				
				accnts = query.list();
				
				
				session.getTransaction().commit();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if(em != null) em.close();
			}
			System.out.println("Accnts = "+accnts);
			return accnts;
		}

	
		@Override
		public ResponseObj getDuplicateAccount(CommonResultSetMapper mapper)
				throws DAOException {
			ResponseObj responseObj=new ResponseObj();
			int status = 0;
			
			EntityManager em = null;
			CallableStatement callableStatement = null;
			Connection connection = null;
			ResultSet rs = null;
			List<AccountDTO> accnts=new ArrayList<AccountDTO>();

			try {
				entityManagerFactory = PersistenceListener.getEntityManager();
				em = entityManagerFactory.createEntityManager();
				em.getTransaction().begin();

				Session ses = (Session) em.getDelegate();
				SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
						.getSessionFactory();
				connection = sessionFactory.getConnectionProvider().getConnection();

				callableStatement = connection
						.prepareCall(StoredProcedures.GET_DUPLICATE_ACCOUNT);
				callableStatement.setInt(1, mapper.getId());
				callableStatement.setString(2, mapper.getName());
				callableStatement.setInt(3, mapper.getCompanyId());
				callableStatement.setInt(4, mapper.getStoreId());
				callableStatement.registerOutParameter(5, java.sql.Types.INTEGER);
				
				callableStatement.execute();
				
				//rs = callableStatement.getResultSet();

				status = callableStatement.getInt(5);
				
				if (status > 0) {
					
					responseObj.setStatus(ReturnConstant.SUCCESS);
					responseObj.setId(status);
					responseObj.setReason("Duplicate accounts found.");
					
				} else {
					
					responseObj.setStatus(ReturnConstant.FAILURE);
					responseObj.setId(status);
					responseObj.setReason("No Dupllicate records found.");
					
				}

				//logger.info("duplicate account fetched");

			} catch (Exception e) {
				e.printStackTrace();
				throw new DAOException("In DAOException", e);

			} finally {
				try {
					//if(rs != null) rs.close();
					if(callableStatement!=null)
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
		public ResponseObj deleteAccount(CommonResultSetMapper mapper) throws DAOException {
			// TODO Auto-generated method stub
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
					
					callableStatement = connection
							.prepareCall(StoredProcedures.PROC_DELETE_ACCOUNT);
					
					callableStatement.setInt(1, mapper.getCompanyId());
					callableStatement.setInt(2, mapper.getStoreId());
					callableStatement.setInt(3, mapper.getId());
					callableStatement.registerOutParameter(4,java.sql.Types.INTEGER);

					callableStatement.execute();
					status = callableStatement.getInt(4);
					
					if (status >0) {
						
						responseObj.setStatus(ReturnConstant.SUCCESS);
						responseObj.setId(status);
						responseObj.setReason("Record deleted successfully.");
						
					} else {
						
						responseObj.setStatus(ReturnConstant.FAILURE);
						responseObj.setId(status);
						responseObj.setReason("Record not deleted successfully.");
						
					}
					
				} 
				
				catch (SQLException e) {
					e.printStackTrace();
					responseObj.setStatus(ReturnConstant.FAILURE);
					responseObj.setId(0);
					responseObj.setReason("Record not deleted successfully.");
				}
				catch (Exception e) {
					e.printStackTrace();
					responseObj.setStatus(ReturnConstant.FAILURE);
					responseObj.setId(0);
					responseObj.setReason("Record not deleted successfully.");
				}
				em.getTransaction().commit();

			} catch (Exception e) {
				e.printStackTrace();
				responseObj.setStatus(ReturnConstant.FAILURE);
				responseObj.setId(0);
				responseObj.setReason("Record not deleted successfully.");
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
			return responseObj;
		}
		
		@Override
		public ResponseObj updateAccount(AccountMaster accountMaster) throws DAOException {
			// TODO Auto-generated method stub
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
					
					callableStatement = connection
							.prepareCall(StoredProcedures.PROC_UPDATE_ACCOUNT);
					
					callableStatement.setInt(1,accountMaster.getId());
					callableStatement.setString(2,accountMaster.getName());
					callableStatement.setString(3,accountMaster.getCode());
					callableStatement.setInt(4,accountMaster.getGroupId());
					callableStatement.setString(5,accountMaster.getGroup_code());
					callableStatement.setInt(6,accountMaster.getCityId());
					callableStatement.setInt(7,accountMaster.getZoneId());
					callableStatement.setInt(8,accountMaster.getAreaId());
					callableStatement.setString(9,accountMaster.getAddress());
					if(accountMaster.getPin().equals("") || accountMaster.getPin().equals(null))
						callableStatement.setString(10,"0");
					else
						callableStatement.setString(10,accountMaster.getPin());
					callableStatement.setString(11,accountMaster.getPhone());
					callableStatement.setString(12,accountMaster.getEmail());
					callableStatement.setString(13,accountMaster.getPanNo());
					callableStatement.setString(14,accountMaster.getGstRegistrationNo());
					callableStatement.setString(15,accountMaster.getBcdaRegistrationNo());
					callableStatement.setString(16,accountMaster.getDlNo());
					callableStatement.setDouble(17,accountMaster.getCashDiscountPercentage());
					callableStatement.setDouble(18,accountMaster.getTransLimit());
					callableStatement.setInt(19,accountMaster.getIsActive());
					callableStatement.setInt(20,accountMaster.getPst_type_id());
					callableStatement.setDouble(21,accountMaster.getOpBalance());
					callableStatement.setString(22,accountMaster.getAsOnDate());
					callableStatement.setInt(23,accountMaster.getCompanyId());
					callableStatement.setInt(24,accountMaster.getStoreId());
					callableStatement.setInt(25,accountMaster.getFinyrId());
					callableStatement.setInt(26,accountMaster.getUpdatedBy());
					callableStatement.setInt(27, accountMaster.getDueDays());
					callableStatement.setDouble(28, accountMaster.getDuePer());
					callableStatement.registerOutParameter(29,java.sql.Types.INTEGER);

					callableStatement.execute();
					status = callableStatement.getInt(29);
					
					if (status >0) {
						
						responseObj.setStatus(ReturnConstant.SUCCESS);
						responseObj.setId(status);
						responseObj.setReason("Record updated successfully.");
						
					} else {
						
						responseObj.setStatus(ReturnConstant.FAILURE);
						responseObj.setId(status);
						responseObj.setReason("Record not updated successfully.");
						
					}
					
				} 
				
				catch (SQLException e) {
					e.printStackTrace();
					responseObj.setStatus(ReturnConstant.FAILURE);
					responseObj.setId(0);
					responseObj.setReason("Record not updated successfully.");
				}
				catch (Exception e) {
					e.printStackTrace();
					responseObj.setStatus(ReturnConstant.FAILURE);
					responseObj.setId(0);
					responseObj.setReason("Record not updated successfully.");
				}
				em.getTransaction().commit();

			} catch (Exception e) {
				e.printStackTrace();
				responseObj.setStatus(ReturnConstant.FAILURE);
				responseObj.setId(0);
				responseObj.setReason("Record not updated successfully.");
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
			return responseObj;
		}

		@Override
		public List<AccountDTO> getAccountsAutocomplete(CommonResultSetMapper mapper) throws DAOException {

			EntityManager em = null;
			CallableStatement callableStatement = null;
			Connection connection = null;
			ResultSet rs = null;
			List<AccountDTO> accnts=new ArrayList<>();

			try {
				entityManagerFactory = PersistenceListener.getEntityManager();
				em = entityManagerFactory.createEntityManager();
				em.getTransaction().begin();

				Session ses = (Session) em.getDelegate();
				SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
						.getSessionFactory();
				connection = sessionFactory.getConnectionProvider().getConnection();

				callableStatement = connection
						.prepareCall(StoredProcedures.PROC_GET_ACCOUNTS_AUTOCOMPLETE);
				callableStatement.setInt(1, mapper.getCompanyId());
				callableStatement.setInt(2, mapper.getStoreId());
				callableStatement.setString(3, mapper.getName());
				callableStatement.execute();
				rs = callableStatement.getResultSet();

				ReflectionResultSetMapper<AccountDTO> resultSetMapper1 = new ReflectionResultSetMapper<AccountDTO>(
						AccountDTO.class);

				while (rs.next()) {
					AccountDTO acnt=new AccountDTO();
					acnt = resultSetMapper1.mapRow(rs);
					accnts.add(acnt);

				}

				logger.info("accounts fetched");

			} catch (Exception e) {
				e.printStackTrace();
				throw new DAOException("In DAOException", e);

			} finally {
				try {
					if(rs!=null)
						if(rs != null) rs.close();
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
			//System.out.println("auto accounts = "+accnts);
			return accnts;
		}

		//17/02/2018 end
		
		//22/02.2018
		@Override
		public String addJournal(JournalListDTO journallistDTO) throws DAOException {
			EntityManager em = null;
			int status = 0;
			Connection connection = null;
			CallableStatement callableStatement = null;

			try {
				journallistDTO.setQs(journallistDTO.getEntry_type());
				entityManagerFactory = PersistenceListener.getEntityManager();
				em = entityManagerFactory.createEntityManager();
				em.getTransaction().begin();
				Session ses = (Session) em.getDelegate();
				SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
						.getSessionFactory();
				connection = sessionFactory.getConnectionProvider().getConnection();

				try {
					StringWriter sw = new StringWriter();
					//File file = new	 File("D:\\2017-04-25\\file_expiry_invoice_creation.xml");
					JAXBContext jaxbContext = JAXBContext
							.newInstance(JournalListDTO.class);
					Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

					jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,
							true);
					//jaxbMarshaller.marshal(expiry, file);
					//jaxbMarshaller.marshal(sales, System.out);
					jaxbMarshaller.marshal(journallistDTO, sw);
					String result = sw.toString();
					//System.out.println("Journal output string:: "+result);
					callableStatement = connection
							.prepareCall(StoredProcedures.PROC_INSERT_JOURNAL);
					callableStatement.setString(1, result);
					callableStatement.setString(2, "journalListDTO");
					callableStatement.setString(3, "journallist");
					
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
					e.printStackTrace();
				}
				if(em!=null)
					if(em != null) em.close();
			}
			//System.out.println("journal insert status = "+status);
			return ""+status;

		}

		@Override
		public ResponseObj deleteJournal(CommonResultSetMapper mapper) throws DAOException {
			// TODO Auto-generated method stub
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
					
					callableStatement = connection
							.prepareCall(StoredProcedures.PROC_DELETE_JOURNAL);
					
					callableStatement.setInt(1, mapper.getCompanyId());
					callableStatement.setInt(2, mapper.getStoreId());
					callableStatement.setInt(3, mapper.getId());
					callableStatement.registerOutParameter(4,java.sql.Types.INTEGER);

					callableStatement.execute();
					status = callableStatement.getInt(4);
					
					if (status >0) {
						
						responseObj.setStatus(ReturnConstant.SUCCESS);
						responseObj.setId(status);
						responseObj.setReason("Record deleted successfully.");
						
					} else {
						
						responseObj.setStatus(ReturnConstant.FAILURE);
						responseObj.setId(status);
						responseObj.setReason("Record not deleted successfully.");
						
					}
					
				} 
				
				catch (SQLException e) {
					e.printStackTrace();
					responseObj.setStatus(ReturnConstant.FAILURE);
					responseObj.setId(0);
					responseObj.setReason("Record not deleted successfully.");
				}
				catch (Exception e) {
					e.printStackTrace();
					responseObj.setStatus(ReturnConstant.FAILURE);
					responseObj.setId(0);
					responseObj.setReason("Record not deleted successfully.");
				}
				em.getTransaction().commit();

			} catch (Exception e) {
				e.printStackTrace();
				responseObj.setStatus(ReturnConstant.FAILURE);
				responseObj.setId(0);
				responseObj.setReason("Record not deleted successfully.");
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
			return responseObj;
		}

		//22.02.2018
		
		//23.02.2018
		@Override
		public List<ParaJournalTypeMaster> getJournalTypeByQS(CommonResultSetMapper mapper) throws DAOException {

			EntityManager em = null;
			CallableStatement callableStatement = null;
			Connection connection = null;
			ResultSet rs = null;
			List<ParaJournalTypeMaster> pjtms=new ArrayList<>();

			try {
				entityManagerFactory = PersistenceListener.getEntityManager();
				em = entityManagerFactory.createEntityManager();
				em.getTransaction().begin();

				Session ses = (Session) em.getDelegate();
				SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
						.getSessionFactory();
				connection = sessionFactory.getConnectionProvider().getConnection();

				callableStatement = connection
						.prepareCall(StoredProcedures.PROC_GET_JOURNALTYPE_BYQS);
				callableStatement.setInt(1, mapper.getCompanyId());
				callableStatement.setInt(2, mapper.getStoreId());
				callableStatement.setString(3, mapper.getQs());
				callableStatement.execute();
				rs = callableStatement.getResultSet();

				ReflectionResultSetMapper<ParaJournalTypeMaster> resultSetMapper1 = new ReflectionResultSetMapper<ParaJournalTypeMaster>(
						ParaJournalTypeMaster.class);

				while (rs.next()) {
					ParaJournalTypeMaster pjtm=new ParaJournalTypeMaster();
					pjtm = resultSetMapper1.mapRow(rs);
					pjtms.add(pjtm);

				}

				//logger.info("ParaJournalTypeMaster fetched");

			} catch (Exception e) {
				e.printStackTrace();
				throw new DAOException("In DAOException", e);

			} finally {
				try {
					if(rs!=null)
						if(rs != null) rs.close();
					if(connection!=null)
						if(connection != null) connection.close(); 
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(em != null) em.close();
			}
			//System.out.println("ParaJournalTypeMaster = "+pjtms);
			return pjtms;
		}

		@Override
		public List<JournalDTO> getAllJournalByType(CommonResultSetMapper mapper) throws DAOException {

			EntityManager em = null;
			CallableStatement callableStatement = null;
			Connection connection = null;
			ResultSet rs = null;
			List<JournalDTO> journals=new ArrayList<>();

			try {
				entityManagerFactory = PersistenceListener.getEntityManager();
				em = entityManagerFactory.createEntityManager();
				em.getTransaction().begin();

				Session ses = (Session) em.getDelegate();
				SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
						.getSessionFactory();
				connection = sessionFactory.getConnectionProvider().getConnection();

				callableStatement = connection
						.prepareCall(StoredProcedures.PROC_GET_ALLJOURNAL_BYTYPE);
				callableStatement.setInt(1, mapper.getCompanyId());
				callableStatement.setInt(2, mapper.getStoreId());
				callableStatement.setInt(3, mapper.getFinYrId());
				callableStatement.setInt(4, mapper.getId());
				callableStatement.setString(5, mapper.getQs());
				callableStatement.execute();
				rs = callableStatement.getResultSet();

				ReflectionResultSetMapper<JournalDTO> resultSetMapper1 = new ReflectionResultSetMapper<JournalDTO>(
						JournalDTO.class);

				while (rs.next()) {
					JournalDTO journal=new JournalDTO();
					journal = resultSetMapper1.mapRow(rs);
					journals.add(journal);

				}

				//logger.info("ParaJournalTypeMaster fetched");

			} catch (Exception e) {
				e.printStackTrace();
				throw new DAOException("In DAOException", e);

			} finally {
				try {
					if(rs!=null)
						if(rs != null) rs.close();
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
			//System.out.println("JournalDTO = "+journals);
			return journals;
		}
		
		@Override
		public List<JournalListDTO> getJournalById(CommonResultSetMapper mapper) throws DAOException {

			EntityManager em = null;
			CallableStatement callableStatement = null;
			Connection connection = null;
			ResultSet rs = null;
			List<JournalDTO> journals=new ArrayList<>();
			List<JournalListDTO> journallsts=new ArrayList<>();

			try {
				entityManagerFactory = PersistenceListener.getEntityManager();
				em = entityManagerFactory.createEntityManager();
				em.getTransaction().begin();

				Session ses = (Session) em.getDelegate();
				SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
						.getSessionFactory();
				connection = sessionFactory.getConnectionProvider().getConnection();

				//JournalDTO list
				callableStatement = connection
						.prepareCall(StoredProcedures.PROC_GET_JOURNALDETAILS_BYID);
				callableStatement.setInt(1, mapper.getCompanyId());
				callableStatement.setInt(2, mapper.getStoreId());
				callableStatement.setInt(3, mapper.getFinYrId());
				callableStatement.setInt(4, mapper.getId());
				callableStatement.execute();
				rs = callableStatement.getResultSet();

				ReflectionResultSetMapper<JournalDTO> resultSetMapper = new ReflectionResultSetMapper<JournalDTO>(
						JournalDTO.class);

				while (rs.next()) {
					JournalDTO journal=new JournalDTO();
					journal = resultSetMapper.mapRow(rs);
					journals.add(journal);
				}
				
				//header
				callableStatement = connection
						.prepareCall(StoredProcedures.PROC_GET_JOURNALHEADER_BYID);
				callableStatement.setInt(1, mapper.getCompanyId());
				callableStatement.setInt(2, mapper.getStoreId());
				callableStatement.setInt(3, mapper.getFinYrId());
				callableStatement.setInt(4, mapper.getId());
				callableStatement.execute();
				rs = callableStatement.getResultSet();

				ReflectionResultSetMapper<JournalListDTO> resultSetMapper1 = new ReflectionResultSetMapper<JournalListDTO>(
						JournalListDTO.class);

				while (rs.next()) {
					JournalListDTO journallst=new JournalListDTO();
					journallst = resultSetMapper1.mapRow(rs);
					
					journallst.setJournallist(journals);
					
					journallsts.add(journallst);

				}

				//logger.info("JournalListDTO fetched");

			} catch (Exception e) {
				e.printStackTrace();
				throw new DAOException("In DAOException", e);

			} finally {
				try {
					if(rs!=null)
					{
						if(rs != null) rs.close();
					}
					if(connection!=null)
						if(connection != null) connection.close(); 
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(em != null) em.close();
			}
			//System.out.println("JournalListDTO = "+journals);
			return journallsts;
		}
		
		@Override
		public String updateJournal(JournalListDTO journallistDTO) throws DAOException {
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
					//File file = new	 File("D:\\2017-04-25\\file_expiry_invoice_creation.xml");
					JAXBContext jaxbContext = JAXBContext
							.newInstance(JournalListDTO.class);
					Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

					jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,
							true);
					//jaxbMarshaller.marshal(expiry, file);
					//jaxbMarshaller.marshal(sales, System.out);
					jaxbMarshaller.marshal(journallistDTO, sw);
					String result = sw.toString();
					//System.out.println("Journal output string:: "+result);
					callableStatement = connection
							.prepareCall(StoredProcedures.PROC_INSERT_JOURNAL);
					callableStatement.setString(1, result);
					callableStatement.setString(2, "journalListDTO");
					callableStatement.setString(3, "journallist");
					
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
			//System.out.println("journal update status = "+status);
			return ""+status;

		}

		@Override
		public List<AccountDTO> getLedgerDetailsByCode(CommonResultSetMapper mapper) throws DAOException {

			EntityManager em = null;
			CallableStatement callableStatement = null;
			Connection connection = null;
			ResultSet rs = null;
			List<AccountDTO> accountDTOs=new ArrayList<>();

			try {
				entityManagerFactory = PersistenceListener.getEntityManager();
				em = entityManagerFactory.createEntityManager();
				em.getTransaction().begin();

				Session ses = (Session) em.getDelegate();
				SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
						.getSessionFactory();
				connection = sessionFactory.getConnectionProvider().getConnection();

				//JournalDTO list
				if(mapper.getId()==1)
				{
					//System.out.println("PROC_GET_LEDGERDETAILS_BYCODE id = "+1);
					callableStatement = connection.prepareCall(StoredProcedures.PROC_GET_LEDGERDETAILS_BYCODE);
				}
				else {
					//System.out.println("PROC_GET_LEDGERDETAILS_BYCODE id = "+0);
					callableStatement = connection.prepareCall(StoredProcedures.PROC_GET_LEDGERDETAILS_BYCODE);
				}
				callableStatement.setInt(1, mapper.getCompanyId());
				callableStatement.setInt(2, mapper.getStoreId());
				callableStatement.setString(3, mapper.getGroupCode());
				callableStatement.setInt(4, mapper.getAccountID());
				callableStatement.setInt(5, mapper.getReferenceID());
//				callableStatement.setInt(4, mapper.getId());
				callableStatement.execute();
				rs = callableStatement.getResultSet();

				ReflectionResultSetMapper<AccountDTO> resultSetMapper = new ReflectionResultSetMapper<AccountDTO>(
						AccountDTO.class);

				while (rs.next()) {
					AccountDTO accountDTO=new AccountDTO();
					accountDTO = resultSetMapper.mapRow(rs);
					accountDTOs.add(accountDTO);
				}
				
				

				//logger.info("accountDTOs fetched");

			} catch (Exception e) {
				e.printStackTrace();
				throw new DAOException("In DAOException", e);

			} finally {
				try {
					if(rs!=null)
					{
						if(rs != null) rs.close();
					}
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
			//System.out.println("accountDTOs = "+accountDTOs);
			return accountDTOs;
		}
		
		//13.02.2018

		@Override
		public List<AccountDTO> getAccountsAutocompleteByCashBank(CommonResultSetMapper mapper) throws DAOException {

			EntityManager em = null;
			CallableStatement callableStatement = null;
			Connection connection = null;
			ResultSet rs = null;
			List<AccountDTO> accnts=new ArrayList<>();

			try {
				entityManagerFactory = PersistenceListener.getEntityManager();
				em = entityManagerFactory.createEntityManager();
				em.getTransaction().begin();

				Session ses = (Session) em.getDelegate();
				SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
						.getSessionFactory();
				connection = sessionFactory.getConnectionProvider().getConnection();

				callableStatement = connection
						.prepareCall(StoredProcedures.PROC_GET_ACCOUNTS_AUTOCOMPLETE_BYCASHBANK);
				callableStatement.setInt(1, mapper.getCompanyId());
				callableStatement.setInt(2, mapper.getStoreId());
				callableStatement.setString(3, mapper.getName());
				callableStatement.setInt(4, mapper.getId());  //1 bank :: 2 cash :: 3 cashNbank 
				callableStatement.execute();
				rs = callableStatement.getResultSet();

				ReflectionResultSetMapper<AccountDTO> resultSetMapper1 = new ReflectionResultSetMapper<AccountDTO>(
						AccountDTO.class);

				while (rs.next()) {
					AccountDTO acnt=new AccountDTO();
					acnt = resultSetMapper1.mapRow(rs);
					accnts.add(acnt);

				}

				//logger.info("accounts fetched");

			} catch (Exception e) {
				e.printStackTrace();
				throw new DAOException("In DAOException", e);

			} finally {
				try {
					if(rs!=null)
						if(rs != null) rs.close();
					if(connection!=null)
						if(connection != null) connection.close(); 
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(em != null) em.close();
			}
			//System.out.println("auto accounts = "+accnts);
			return accnts;
		}
		
		
		//14.03.2018
		@Override
		public List<ChartOfAccountDTO> getChartOfAccount(CommonResultSetMapper mapper) throws DAOException {

			EntityManager em = null;
			CallableStatement callableStatement = null;
			Connection connection = null;
			ResultSet rs = null;
			List<ChartOfAccountDTO> accnts=new ArrayList<>();

			try {
				entityManagerFactory = PersistenceListener.getEntityManager();
				em = entityManagerFactory.createEntityManager();
				em.getTransaction().begin();

				Session ses = (Session) em.getDelegate();
				SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
						.getSessionFactory();
				connection = sessionFactory.getConnectionProvider().getConnection();

				callableStatement = connection
						.prepareCall(StoredProcedures.PROC_CHART_OF_ACCOUNT);//chart_of_account
				callableStatement.setInt(1, mapper.getCompanyId());
				callableStatement.setInt(2, mapper.getStoreId());
				
				callableStatement.setInt(3, mapper.getFinYrId());
				callableStatement.setInt(4, mapper.getId()); //groupID
				callableStatement.setInt(5, mapper.getAccountID());
				//callableStatement.setString(6, mapper.getAsOnDate())
				if (mapper.getAsOnDate()!=null) {
					java.sql.Date asonDate = DateUtil.convertStringDateToSqlDate(
					mapper.getAsOnDate(), "yyyy-MM-dd");
					callableStatement.setDate(6, asonDate);
				}
				else {
					callableStatement.setDate(6, null);
				}
				
				/*callableStatement.setString(3, mapper.getName());
				callableStatement.setInt(4, mapper.getId());  //1 bank :: 2 cash :: 3 cashNbank */
				callableStatement.execute();
				rs = callableStatement.getResultSet();

				ReflectionResultSetMapper<ChartOfAccountDTO> resultSetMapper1 = new ReflectionResultSetMapper<ChartOfAccountDTO>(
						ChartOfAccountDTO.class);

				while (rs.next()) {
					ChartOfAccountDTO acnt=new ChartOfAccountDTO();
					acnt = resultSetMapper1.mapRow(rs);
					accnts.add(acnt);

				}

				//logger.info("accounts fetched");

			} catch (Exception e) {
				e.printStackTrace();
				throw new DAOException("In DAOException", e);

			} finally {
				try {
					if(rs!=null)
						if(rs != null) rs.close();
					
					if(connection!=null)
						if(connection != null) connection.close(); 
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(em != null) em.close();
			}
			//System.out.println("chart of accounts = "+accnts);
			return accnts;
		}

		@Override
		public List<AccountDTO> getAccountsAutocompleteByGroup(CommonResultSetMapper mapper) throws DAOException {

			EntityManager em = null;
			CallableStatement callableStatement = null;
			Connection connection = null;
			ResultSet rs = null;
			List<AccountDTO> accnts=new ArrayList<>();

			try {
				entityManagerFactory = PersistenceListener.getEntityManager();
				em = entityManagerFactory.createEntityManager();
				em.getTransaction().begin();

				Session ses = (Session) em.getDelegate();
				SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
						.getSessionFactory();
				connection = sessionFactory.getConnectionProvider().getConnection();

				callableStatement = connection
						.prepareCall(StoredProcedures.PROC_GET_ACCOUNTS_AUTOCOMPLETEBYGROUP);
				callableStatement.setInt(1, mapper.getCompanyId());
				callableStatement.setInt(2, mapper.getStoreId());
				callableStatement.setInt(3, mapper.getId());
				callableStatement.setString(4, mapper.getName());
				callableStatement.execute();
				rs = callableStatement.getResultSet();

				ReflectionResultSetMapper<AccountDTO> resultSetMapper1 = new ReflectionResultSetMapper<AccountDTO>(
						AccountDTO.class);

				while (rs.next()) {
					AccountDTO acnt=new AccountDTO();
					acnt = resultSetMapper1.mapRow(rs);
					accnts.add(acnt);

				}

				//logger.info("accounts fetched");

			} catch (Exception e) {
				e.printStackTrace();
				throw new DAOException("In DAOException", e);

			} finally {
				try {
					if(rs!=null)
						if(rs != null) rs.close();
					if(connection!=null)
						if(connection != null) connection.close(); 
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(em != null) em.close();
			}
			//System.out.println("auto accounts = "+accnts);
			return accnts;
		}
		
		//23.03.2018
		@Override
		public List<CustomerDTO> getCustomersAllByName(CommonResultSetMapper mapper) throws DAOException {

			System.out.println("getCustomersAllByName mapper = "+mapper);
			List<CustomerDTO> custs=new ArrayList<CustomerDTO>();
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
						.prepareCall(StoredProcedures.PROC_GET_CUSTOMERS_ALL_BYNAME);
				callableStatement.setInt(1, mapper.getCompanyId());
				callableStatement.setInt(2, mapper.getStoreId());
				callableStatement.setInt(3, mapper.getFinYrId());
				callableStatement.setString(4, mapper.getCustName());
				if (mapper.getAsOnDate()!=null) {
					java.sql.Date asonDate = DateUtil.convertStringDateToSqlDate(
					mapper.getAsOnDate(), "yyyy-MM-dd");
					callableStatement.setDate(5, asonDate);
				}
				else {
					callableStatement.setDate(5, null);
				}
				
				callableStatement.setString(6, mapper.getQryCondition());
				
			
				callableStatement.execute();
				
				rs = callableStatement.getResultSet();
				ReflectionResultSetMapper<CustomerDTO> resultSetMapper = new ReflectionResultSetMapper<CustomerDTO>(
						CustomerDTO.class);
				while(rs.next()){
					CustomerDTO cust = new CustomerDTO();
					cust = resultSetMapper.mapRow(rs);
					custs.add(cust);
				}
				//logger.info("all customers by name fetched");

			} catch (Exception e) {
				e.printStackTrace();
				throw new DAOException("In DAOException", e);

			} finally {
				try {
					if(rs != null) rs.close();
					if(callableStatement!=null)
					if(connection != null) connection.close(); 
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(em != null) em.close();
			}

			return custs;
		}
		
		
		@Override
		public int opStockTransferforYearEnd(CommonResultSetMapper mapper) throws DAOException {

			EntityManager em = null;
			Connection connection = null;
			CallableStatement callableStatement = null;
//			ResultSet rs = null;
			int status = 0;
			try {
				entityManagerFactory = PersistenceListener.getEntityManager();
				em = entityManagerFactory.createEntityManager();
				em.getTransaction().begin();

				Session ses = (Session) em.getDelegate();
				SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
						.getSessionFactory();
				connection = sessionFactory.getConnectionProvider().getConnection();
				
				callableStatement = connection
						.prepareCall(StoredProcedures.PROC_OP_STOCK_TRANSFER_FOR_YEAREND);
				callableStatement.setInt(1, mapper.getCompanyId());
				callableStatement.setInt(2, mapper.getStoreId());
				callableStatement.setInt(3, mapper.getFinYrId());
				if (mapper.getAsOnDate()!=null) {
					java.sql.Date asonDate = DateUtil.convertStringDateToSqlDate(
					mapper.getAsOnDate(), "yyyy-MM-dd");
					callableStatement.setDate(4, asonDate);
				}
				else {
					callableStatement.setDate(4, null);
				}
				callableStatement.setInt(5, mapper.getItemId());
				
				callableStatement.setInt(6, mapper.getCreatedBy());
				
				callableStatement.registerOutParameter(7,java.sql.Types.INTEGER);

				callableStatement.execute();
				
				status = callableStatement.getInt(7);
				
				logger.info("opStockTransferforYearEnd done");
				//status = 1;
			} catch (Exception e) {
				e.printStackTrace();
				status=0;
				throw new DAOException("In DAOException", e);
				
			} finally {
				try {
					if(callableStatement!=null)
					if(connection != null) connection.close(); 
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(em != null) em.close();
			}

			return status;
		}/**/

		@Override
		public List<ItemSearchByContentDTO> getAllItemStockSearchByManufacturerId(CommonResultSetMapper mapper) throws DAOException {

			List<ItemSearchByContentDTO> expiryAllDTOs=new ArrayList<ItemSearchByContentDTO>();
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
						.prepareCall(StoredProcedures.PROC_GET_ALL_ITEM__STOCK_SEARCH_BY_ManufacturerId);
				callableStatement.setInt(1, mapper.getCompanyId());
				callableStatement.setInt(2, mapper.getStoreId());
				callableStatement.setInt(3, mapper.getFinYrId());
				if (mapper.getAsOnDate()!=null) {
					java.sql.Date asonDate = DateUtil.convertStringDateToSqlDate(
					mapper.getAsOnDate(), "yyyy-MM-dd");
					callableStatement.setDate(4, asonDate);
				}
				else {
					callableStatement.setDate(4, null);
				}
				callableStatement.setInt(5, mapper.getManuId());
				callableStatement.execute();
				
				rs = callableStatement.getResultSet();
				ReflectionResultSetMapper<ItemSearchByContentDTO> resultSetMapper = new ReflectionResultSetMapper<ItemSearchByContentDTO>(
						ItemSearchByContentDTO.class);
				while(rs.next()){
					ItemSearchByContentDTO exp = new ItemSearchByContentDTO();
					exp = resultSetMapper.mapRow(rs);
					expiryAllDTOs.add(exp);
				}
				//logger.info("get all item stock search by manufacturer id fetched");

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

			return expiryAllDTOs;
		}

		@Override
		public List<CommonResultSetMapper> getItemByItemcode(CommonResultSetMapper mapper) throws DAOException {

			List<CommonResultSetMapper> commonResultSetMapper = new ArrayList<CommonResultSetMapper>();
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
						.prepareCall(StoredProcedures.PROC_GET_ITEM_BY_ITEMCODE);
				callableStatement.setInt(1, mapper.getCompanyId());
				callableStatement.setInt(2, mapper.getStoreId());
				callableStatement.setString(3, mapper.getItemCode());
				callableStatement.execute();
				rs = callableStatement.getResultSet();

				ReflectionResultSetMapper<CommonResultSetMapper> resultSetMapper1 = new ReflectionResultSetMapper<CommonResultSetMapper>(
						CommonResultSetMapper.class);

				while (rs.next()) {
					CommonResultSetMapper crsm = new CommonResultSetMapper();
					crsm = resultSetMapper1.mapRow(rs);
					/*commonResultSetMapper.setItemId(rs.getInt(1));
					commonResultSetMapper.setItemName(rs.getString(2));*/
					commonResultSetMapper.add(crsm);
				}

				//logger.info("items with code fetched by itemcode");

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

			return commonResultSetMapper;
		}
	
		@Override
		public List<ItemCurrentStockDTO> getAllItemStockSearch(CommonResultSetMapper mapper) throws DAOException {

			List<ItemCurrentStockDTO> expiryAllDTOs=new ArrayList<ItemCurrentStockDTO>();
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
						.prepareCall(StoredProcedures.PROC_GET_ALLITEM_STOCK_SEARCH);
				callableStatement.setInt(1, mapper.getCompanyId());
				callableStatement.setInt(2, mapper.getStoreId());
				callableStatement.setString(3, mapper.getUpToDate());
				callableStatement.setInt(4, mapper.getItemId());
				callableStatement.setString(5, mapper.getName());
				callableStatement.setInt(6, mapper.getNoOfExpiryMonth());
				callableStatement.execute();
				
				rs = callableStatement.getResultSet();
				ReflectionResultSetMapper<ItemCurrentStockDTO> resultSetMapper = new ReflectionResultSetMapper<ItemCurrentStockDTO>(
						ItemCurrentStockDTO.class);
				while(rs.next()){
					ItemCurrentStockDTO exp = new ItemCurrentStockDTO();
					exp = resultSetMapper.mapRow(rs);
					expiryAllDTOs.add(exp);
				}
				//logger.info("getAllItemStockSearch fetched");

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

			return expiryAllDTOs;
		}

		@Override
		public List<CommonResultSetMapper> searchItemByCode(CommonResultSetMapper mapper) throws DAOException {
			EntityManager em = null;
			List<CommonResultSetMapper> data = new ArrayList<CommonResultSetMapper>();
			int storeId = 0;
			String itemCode = "";
			String cntnName = "";
			String brandName = "";
			String manuName = "";
			int cmpnyId = 0;
			Connection connection = null;
			CallableStatement callableStatement = null;
			ResultSet rs = null;

			try {
				cmpnyId = mapper.getCompanyId();
				storeId = mapper.getStoreId();
				itemCode = mapper.getItemCode();
				cntnName = mapper.getContentName();
				brandName = mapper.getBrandName();
				manuName = mapper.getManufacturerName();
				entityManagerFactory = PersistenceListener.getEntityManager();
				em = entityManagerFactory.createEntityManager();
				em.getTransaction().begin();
				Session ses = (Session) em.getDelegate();
				SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
						.getSessionFactory();
				connection = sessionFactory.getConnectionProvider().getConnection();
				callableStatement = connection
						.prepareCall(StoredProcedures.PROC_SEARCH_ITEMBY_CODE);
				callableStatement.setInt(1, cmpnyId);
				callableStatement.setInt(2, storeId);
				callableStatement.setString(3, itemCode);
				callableStatement.setString(4, brandName);
				callableStatement.setString(5, manuName);

				callableStatement.execute();
				rs = callableStatement.getResultSet();
				while (rs.next()) {
					CommonResultSetMapper mapper1 = new CommonResultSetMapper();
					mapper1.setItemId(rs.getInt(1));
					mapper1.setItemName(rs.getString(2));
					mapper1.setHsnCode(rs.getString(3));
					mapper1.setBrandName(rs.getString(4));
					mapper1.setManufacturerName(rs.getString(5));
					mapper1.setManufacturerCode(rs.getString(6));
					mapper1.setPackUnitName(rs.getString(7));
					mapper1.setLooseUnitName(rs.getString(8));
					mapper1.setRackName(rs.getString(9));
					mapper1.setConv(rs.getInt(10));
					mapper1.setGroupName(rs.getString(11));
					mapper1.setMrp(rs.getDouble(12));
					mapper1.setPurchaseRate(rs.getDouble(13));

					mapper1.setListedMrp(rs.getDouble(14));
					mapper1.setSaleRate(rs.getDouble(15));
					mapper1.setItemCode(rs.getString(16));
					data.add(mapper1);

				}

			} catch (Exception e) {
				e.printStackTrace();
				throw new DAOException("Check data to be searched", e);
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
			return data;
		}

		@Override
		public List<CommonResultSetMapper> searchItemLiteByCode(CommonResultSetMapper mapper) throws DAOException {
			EntityManager em = null;
			List<CommonResultSetMapper> data = new ArrayList<CommonResultSetMapper>();
			int storeId = 0;
			String itemCode = "";
			String cntnName = "";
			String brandName = "";
			String manuName = "";
			int cmpnyId = 0;
			Connection connection = null;
			CallableStatement callableStatement = null;
			ResultSet rs = null;

			try {
				cmpnyId = mapper.getCompanyId();
				storeId = mapper.getStoreId();
				itemCode = mapper.getItemCode();
				cntnName = mapper.getContentName();
				brandName = mapper.getBrandName();
				manuName = mapper.getManufacturerName();
				entityManagerFactory = PersistenceListener.getEntityManager();
				em = entityManagerFactory.createEntityManager();
				em.getTransaction().begin();
				Session ses = (Session) em.getDelegate();
				SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
						.getSessionFactory();
				connection = sessionFactory.getConnectionProvider().getConnection();
				callableStatement = connection
						.prepareCall(StoredProcedures.PROC_SEARCH_ITEM_LITE_BYCODE);
				callableStatement.setInt(1, cmpnyId);
				callableStatement.setInt(2, storeId);
				callableStatement.setString(3, itemCode);
				callableStatement.setString(4, cntnName);
				callableStatement.setString(5, brandName);
				callableStatement.setString(6, manuName);

				callableStatement.execute();
				rs = callableStatement.getResultSet();
				while (rs.next()) {
					CommonResultSetMapper mapper1 = new CommonResultSetMapper();
					mapper1.setItemId(rs.getInt(1));
					mapper1.setItemName(rs.getString(2));
					mapper1.setItemCode(rs.getString(3));
					data.add(mapper1);

				}

			} catch (Exception e) {
				e.printStackTrace();
				throw new DAOException("Check data to be searched", e);
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
			return data;
		}
		
	//start stock transfer
		@Override
		public String createOrUpdateStockTransfer(StockTransfer stkTransfer)
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
					StringWriter sw = new StringWriter();
					//File file = new	 File("D:\\2017-04-25\\file_expiry_invoice_creation.xml");
					JAXBContext jaxbContext = JAXBContext
							.newInstance(StockTransfer.class);
					Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

					jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,
							true);
					//jaxbMarshaller.marshal(expiry, file);
					//jaxbMarshaller.marshal(sales, System.out);
					jaxbMarshaller.marshal(stkTransfer, sw);
					String result = sw.toString();
					//System.out.println("output string:: "+result);
					callableStatement = connection
							.prepareCall(StoredProcedures.PROC_CREATE_STOCK_TRANSFER);
					callableStatement.setString(1, result);
					callableStatement.setString(2, "stockTransfer");
					callableStatement.setString(3, "stockTransferDetails");
					
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
		public List<StockTransferDTO> getAllStockTransferDetails(CommonResultSetMapper mapper) throws DAOException {

			List<StockTransferDTO> stktrnsAllDTOs=new ArrayList<StockTransferDTO>();
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
						.prepareCall(StoredProcedures.PROC_GET_STOCK_TRANSFER_DETAILS_ALL);
				callableStatement.setInt(1, mapper.getCompanyId());
				callableStatement.setInt(2, mapper.getStoreId());
				callableStatement.setInt(3, mapper.getFinYrId());
				
				if (mapper.getStartDate()!=null) {
					java.sql.Date startDate = DateUtil.convertStringDateToSqlDate(
					mapper.getStartDate(), "yyyy-MM-dd");
					callableStatement.setDate(4, startDate);
				}
				else {
					callableStatement.setDate(4, null);
				}
				
				if (mapper.getEndDate()!=null) {
					java.sql.Date endDate = DateUtil.convertStringDateToSqlDate(
					mapper.getEndDate(), "yyyy-MM-dd");
					callableStatement.setDate(5, endDate);
				}
				else {
					callableStatement.setDate(5, null);
				}
				callableStatement.setString(6, mapper.getInvoiceNo());
				
				callableStatement.execute();
				
				rs = callableStatement.getResultSet();
				ReflectionResultSetMapper<StockTransferDTO> resultSetMapper = new ReflectionResultSetMapper<StockTransferDTO>(
						StockTransferDTO.class);
				while(rs.next()){
					StockTransferDTO stck = new StockTransferDTO();
					stck = resultSetMapper.mapRow(rs);
					stktrnsAllDTOs.add(stck);
				}
				//logger.info("get all stock transfer details fetched");

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

			return stktrnsAllDTOs;
		}
		
		@Override
		public StockTransferDTO getStockTransferHeaderById(CommonResultSetMapper mapper) throws DAOException {

			StockTransferDTO stk=new StockTransferDTO();
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
						.prepareCall(StoredProcedures.PROC_GET_STOCK_TRANSFER_HEADER_BY_ID);
				callableStatement.setInt(1, mapper.getTransferId());
				
				callableStatement.execute();
				
				rs = callableStatement.getResultSet();
				ReflectionResultSetMapper<StockTransferDTO> resultSetMapper = new ReflectionResultSetMapper<StockTransferDTO>(
						StockTransferDTO.class);
				while(rs.next()){
					
					stk = resultSetMapper.mapRow(rs);
					
				}
				//logger.info("stock transfer header by id fetched");

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

			return stk;
		}
		
		@Override
		public List<StockTransferDetailsDTO> getStockTransferDetailsById(CommonResultSetMapper mapper) throws DAOException {

			List<StockTransferDetailsDTO> stktransAllDTOs=new ArrayList<StockTransferDetailsDTO>();
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
						.prepareCall(StoredProcedures.PROC_GET_STOCK_TRANSFER_DETAILS_BY_ID);
				callableStatement.setInt(1, mapper.getTransferId());
				
				callableStatement.execute();
				
				rs = callableStatement.getResultSet();
				ReflectionResultSetMapper<StockTransferDetailsDTO> resultSetMapper = new ReflectionResultSetMapper<StockTransferDetailsDTO>(
						StockTransferDetailsDTO.class);
				while(rs.next()){
					StockTransferDetailsDTO trns = new StockTransferDetailsDTO();
					trns = resultSetMapper.mapRow(rs);
					stktransAllDTOs.add(trns);
				}
				//logger.info("get stock transfer details by id fetched");

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

			return stktransAllDTOs;
		}
		
		@Override
		public String dispatchStockTransfer(CommonResultSetMapper mapper) throws DAOException {
			EntityManager em = null;
			Connection connection = null;
			CallableStatement callableStatement = null;
			String result = null;
			try {
				int transId = mapper.getTransferId();
				
				entityManagerFactory = PersistenceListener.getEntityManager();
				em = entityManagerFactory.createEntityManager();
				em.getTransaction().begin();
				Session ses = (Session) em.getDelegate();
				SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
						.getSessionFactory();
				connection = sessionFactory.getConnectionProvider().getConnection();
				callableStatement = connection
						.prepareCall(StoredProcedures.PROC_DISPATCH_STOCK_TRANSFER);
				callableStatement.setInt(1, transId);
				callableStatement.registerOutParameter(2, java.sql.Types.INTEGER);

				callableStatement.execute();
				result = "" + callableStatement.getInt(2);

			} catch (Exception e) {
				e.printStackTrace();
				result = ReturnConstant.FAILURE;
				throw new DAOException("Check data to be dispatched", e);
			}

			finally {
				try {
					
					if(callableStatement != null) callableStatement.close();
					if(connection != null) connection.close(); 
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(em != null) em.close();
			}
			return result;
		}
		
		@Override
		public String deleteStockTransfer(CommonResultSetMapper mapper) throws DAOException {
			EntityManager em = null;
			Connection connection = null;
			CallableStatement callableStatement = null;
			String result = null;
			try {
				int transId = mapper.getTransferId();
				
				entityManagerFactory = PersistenceListener.getEntityManager();
				em = entityManagerFactory.createEntityManager();
				em.getTransaction().begin();
				Session ses = (Session) em.getDelegate();
				SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
						.getSessionFactory();
				connection = sessionFactory.getConnectionProvider().getConnection();
				callableStatement = connection
						.prepareCall(StoredProcedures.PROC_DELETE_STOCK_TRANSFER);
				callableStatement.setInt(1, transId);
				callableStatement.registerOutParameter(2, java.sql.Types.INTEGER);

				callableStatement.execute();
				result = "" + callableStatement.getInt(2);

			} catch (Exception e) {
				e.printStackTrace();
				result = ReturnConstant.FAILURE;
				throw new DAOException("Check data to be deleted", e);
			}

			finally {
				try {
					
					if(callableStatement != null) callableStatement.close();
					if(connection != null) connection.close(); 
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(em != null) em.close();
			}
			return result;
		}
		
		@Override
		public String createOrUpdateStockTransferReceive(StockTransfer stkTransfer)
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
					StringWriter sw = new StringWriter();
					//File file = new	 File("D:\\2017-04-25\\file_expiry_invoice_creation.xml");
					JAXBContext jaxbContext = JAXBContext
							.newInstance(StockTransfer.class);
					Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

					jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,
							true);
					//jaxbMarshaller.marshal(expiry, file);
					//jaxbMarshaller.marshal(sales, System.out);
					jaxbMarshaller.marshal(stkTransfer, sw);
					String result = sw.toString();
					//System.out.println("output string:: "+result);
					callableStatement = connection
							.prepareCall(StoredProcedures.PROC_CREATE_STOCK_TRANSFER_RECEIVE);
					callableStatement.setString(1, result);
					callableStatement.setString(2, "stockTransfer");
					callableStatement.setString(3, "stockTransferDetails");
					
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
		public List<StockTransferDTO> getAllStockTransferReceiveDetails(CommonResultSetMapper mapper) throws DAOException {

			List<StockTransferDTO> stktrnsAllDTOs=new ArrayList<StockTransferDTO>();
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
						.prepareCall(StoredProcedures.PROC_GET_STOCK_TRANSFER_RECEIVE_DETAILS_ALL);
				callableStatement.setInt(1, mapper.getCompanyId());
				callableStatement.setInt(2, mapper.getStoreId());
				callableStatement.setInt(3, mapper.getFinYrId());
				
				if (mapper.getStartDate()!=null) {
					java.sql.Date startDate = DateUtil.convertStringDateToSqlDate(
					mapper.getStartDate(), "yyyy-MM-dd");
					callableStatement.setDate(4, startDate);
				}
				else {
					callableStatement.setDate(4, null);
				}
				
				if (mapper.getEndDate()!=null) {
					java.sql.Date endDate = DateUtil.convertStringDateToSqlDate(
					mapper.getEndDate(), "yyyy-MM-dd");
					callableStatement.setDate(5, endDate);
				}
				else {
					callableStatement.setDate(5, null);
				}
				callableStatement.setString(6, mapper.getInvoiceNo());
				
				callableStatement.execute();
				
				rs = callableStatement.getResultSet();
				ReflectionResultSetMapper<StockTransferDTO> resultSetMapper = new ReflectionResultSetMapper<StockTransferDTO>(
						StockTransferDTO.class);
				while(rs.next()){
					StockTransferDTO stck = new StockTransferDTO();
					stck = resultSetMapper.mapRow(rs);
					stktrnsAllDTOs.add(stck);
				}
				//logger.info("get all stock transfer receive details fetched");

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

			return stktrnsAllDTOs;
		}
		
		@Override
		public String reStockTransitQty(StockTransferDetails stkDetails) throws DAOException {
			EntityManager em = null;
			Connection connection = null;
			CallableStatement callableStatement = null;
			String result = null;
			try {
				
				
				entityManagerFactory = PersistenceListener.getEntityManager();
				em = entityManagerFactory.createEntityManager();
				em.getTransaction().begin();
				Session ses = (Session) em.getDelegate();
				SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
						.getSessionFactory();
				connection = sessionFactory.getConnectionProvider().getConnection();
				callableStatement = connection
						.prepareCall(StoredProcedures.PROC_RESTOCK_TRANSIT_QTY);
				callableStatement.setInt(1, stkDetails.getStockTransId());
				callableStatement.setInt(2, stkDetails.getId());
				callableStatement.setDouble(3, stkDetails.getTransitPackQty());
				callableStatement.registerOutParameter(4, java.sql.Types.INTEGER);

				callableStatement.execute();
				result = "" + callableStatement.getInt(4);

			} catch (Exception e) {
				e.printStackTrace();
				result = ReturnConstant.FAILURE;
				throw new DAOException("Check data to be restockin", e);
			}

			finally {
				try {
					
					if(callableStatement != null) callableStatement.close();
					if(connection != null) connection.close(); 
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(em != null) em.close();
			}
			return result;
		}
		
		@Override
		public String closeStockTransferSend(CommonResultSetMapper mapper) throws DAOException {
			EntityManager em = null;
			Connection connection = null;
			CallableStatement callableStatement = null;
			String result = null;
			try {
				int transId = mapper.getTransferId();
				
				entityManagerFactory = PersistenceListener.getEntityManager();
				em = entityManagerFactory.createEntityManager();
				em.getTransaction().begin();
				Session ses = (Session) em.getDelegate();
				SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
						.getSessionFactory();
				connection = sessionFactory.getConnectionProvider().getConnection();
				callableStatement = connection
						.prepareCall(StoredProcedures.PROC_CLOSE_STOCK_TRANSFER_SEND);
				callableStatement.setInt(1, transId);
				callableStatement.registerOutParameter(2, java.sql.Types.INTEGER);

				callableStatement.execute();
				result = "" + callableStatement.getInt(2);

			} catch (Exception e) {
				e.printStackTrace();
				result = ReturnConstant.FAILURE;
				throw new DAOException("Check data to be closure", e);
			}

			finally {
				try {
					
					if(callableStatement != null) callableStatement.close();
					if(connection != null) connection.close(); 
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(em != null) em.close();
			}
			return result;
		}
		
		@Override
		public String closeStockTransferReceive(CommonResultSetMapper mapper) throws DAOException {
			EntityManager em = null;
			Connection connection = null;
			CallableStatement callableStatement = null;
			String result = null;
			try {
				int transId = mapper.getTransferId();
				
				entityManagerFactory = PersistenceListener.getEntityManager();
				em = entityManagerFactory.createEntityManager();
				em.getTransaction().begin();
				Session ses = (Session) em.getDelegate();
				SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
						.getSessionFactory();
				connection = sessionFactory.getConnectionProvider().getConnection();
				callableStatement = connection
						.prepareCall(StoredProcedures.PROC_CLOSE_STOCK_TRANSFER_RECEIVE);
				callableStatement.setInt(1, transId);
				callableStatement.registerOutParameter(2, java.sql.Types.INTEGER);

				callableStatement.execute();
				result = "" + callableStatement.getInt(2);

			} catch (Exception e) {
				e.printStackTrace();
				result = ReturnConstant.FAILURE;
				throw new DAOException("Check data to be closure", e);
			}

			finally {
				try {
					
					if(callableStatement != null) callableStatement.close();
					if(connection != null) connection.close(); 
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(em != null) em.close();
			}
			return result;
		}
	//end stock transfer

}
