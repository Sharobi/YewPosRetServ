package com.sharobi.pharmacy.roles.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.internal.SessionFactoryImpl;

import com.sharobi.license.struts.key.KeyBean;
import com.sharobi.license.struts.key.KeyDetails;
import com.sharobi.pharmacy.common.PersistenceListener;
import com.sharobi.pharmacy.common.ReturnConstant;
import com.sharobi.pharmacy.commonutil.DateUtil;
import com.sharobi.pharmacy.commonutil.StoredProcedures;
import com.sharobi.pharmacy.exceptions.DAOException;
import com.sharobi.pharmacy.roles.dao.RoleDAO;
import com.sharobi.pharmacy.roles.model.LoginInfoByUserDTO;
import com.sharobi.pharmacy.roles.model.Menu;
import com.sharobi.pharmacy.roles.model.MenuByUserDTO;
import com.sharobi.pharmacy.roles.model.Role;
import com.sharobi.pharmacy.roles.model.User;
import com.sharobi.pharmacy.store.model.StoreMaster;

import net.sf.resultsetmapper.ReflectionResultSetMapper;

public class RoleDAOImpl implements RoleDAO {
  
	private final static Logger logger = LogManager.getLogger(RoleDAOImpl.class);

	private EntityManagerFactory entityManagerFactory;

	@Override
	public String addRole(Role role) throws DAOException {
		EntityManager em = null;
		String status = "";
		try {

			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();
			em.persist(role);

			em.getTransaction().commit();
			status = ReturnConstant.SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			status = ReturnConstant.FAILURE;
			throw new DAOException("Check data to be inserted", e);
		} finally {
			em.close();
		}
		return status;
	}

	@Override
	public String addMenu(Menu menu) throws DAOException {
		EntityManager em = null;
		String status = "";
		try {

			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();
			em.persist(menu);

			em.getTransaction().commit();
			status = ReturnConstant.SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			status = ReturnConstant.FAILURE;
			throw new DAOException("Check data to be inserted", e);
		} finally {
			em.close();
		}
		return status;
	}

	@Override
	public String updateRole(Role role) throws DAOException {
		EntityManager em = null;
		String status = "";
		try {

			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();
			Role orginalRole = em.find(Role.class, role.getId());
			orginalRole.setName(role.getName());
			// em.persist(role);

			em.getTransaction().commit();
			status = ReturnConstant.SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			status = ReturnConstant.FAILURE;
			throw new DAOException("Check data to be inserted", e);
		} finally {
			em.close();
		}
		return status;
	}

	@Override
	public List<MenuByUserDTO> getMenuByUser(String cmpnyId, String storeId,
			String userId,String productTypeId) throws DAOException {

		List<MenuByUserDTO> menuLst = new ArrayList<MenuByUserDTO>();
		List<MenuByUserDTO> finalMenuLst = new ArrayList<MenuByUserDTO>();
		Map<Integer, List<MenuByUserDTO>> mapMenuNSubMenu = new HashMap<Integer, List<MenuByUserDTO>>();
		Map<Integer, List<MenuByUserDTO>> mapSubMenuNChildSubMenu = new HashMap<Integer, List<MenuByUserDTO>>();
		List<Integer> menuIds = new ArrayList<Integer>();
		List<Integer> subMenuIds = new ArrayList<Integer>();
		EntityManager em = null;
		CallableStatement callableStatement = null;
		Connection connection = null;
		ResultSet rs = null;

		try {
			// ResultSetMapper<MenuByUserDTO> resultSetMapper = new
			// ResultSetMapper<MenuByUserDTO>();
			//long startTime = System.currentTimeMillis();
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			// em.getTransaction().begin();
			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();
			connection = sessionFactory.getConnectionProvider().getConnection();
			int storeid = Integer.parseInt(storeId);
			int cmpnyid = Integer.parseInt(cmpnyId);
			int userid = Integer.parseInt(userId);
			int productTypeId1 = Integer.parseInt(productTypeId);

			callableStatement = connection
					.prepareCall(StoredProcedures.PROC_MENU_BY_USER);
			callableStatement.setInt(1, cmpnyid);
			callableStatement.setInt(2, storeid);
			callableStatement.setInt(3, userid);
			callableStatement.setInt(4, productTypeId1);

			callableStatement.execute();
			
			rs = callableStatement.getResultSet();

			ReflectionResultSetMapper<MenuByUserDTO> resultSetMapper1 = new ReflectionResultSetMapper<MenuByUserDTO>(
					MenuByUserDTO.class);

			while (rs.next()) {
				MenuByUserDTO menuByUserDTO = resultSetMapper1.mapRow(rs);
				if (menuByUserDTO.getParentMenuId() == 0) {
					menuIds.add(menuByUserDTO.getMenuId()); // separating the
																// parent menus
				}

				menuLst.add(menuByUserDTO);

			}
			for (Iterator iterator = menuIds.iterator(); iterator.hasNext();) {
				Integer menuId = (Integer) iterator.next();
				List<MenuByUserDTO> subMenuLst = new ArrayList<MenuByUserDTO>();
				for (Iterator iterator2 = menuLst.iterator(); iterator2
						.hasNext();) {
					MenuByUserDTO menu = (MenuByUserDTO) iterator2.next();
					int parentMenuId = menu.getParentMenuId();
					if (menuId == parentMenuId) {
						subMenuLst.add(menu);
						mapMenuNSubMenu.put(menuId, subMenuLst); // adding sub
																	// menus for
																	// a menu in
																	// a map
					}

				}
				for (Iterator iterator2 = subMenuLst.iterator(); iterator2
						.hasNext();) {
					MenuByUserDTO subMenu = (MenuByUserDTO) iterator2.next();
					int subMenuId = subMenu.getMenuId();
					subMenuIds.add(subMenuId); // separating the sub menus

				}

			}
			for (Iterator iterator = subMenuIds.iterator(); iterator.hasNext();) {
				Integer subMenuId = (Integer) iterator.next();
				List<MenuByUserDTO> childSubMenuLst = new ArrayList<MenuByUserDTO>();
				for (Iterator iterator2 = menuLst.iterator(); iterator2
						.hasNext();) {
					MenuByUserDTO menu = (MenuByUserDTO) iterator2.next();
					int parentMenuId = menu.getParentMenuId();
					if (subMenuId == parentMenuId) {
						childSubMenuLst.add(menu);
						mapSubMenuNChildSubMenu.put(subMenuId, childSubMenuLst); // adding
																					// child
																					// sub
																					// menus
																					// for
																					// a
																					// sub
																					// menu
																					// in
																					// a
																					// map

					}

				}
			}
			for (Map.Entry<Integer, List<MenuByUserDTO>> entry : mapMenuNSubMenu
					.entrySet()) {
				Integer menuId = entry.getKey();
				for (Iterator iterator1 = menuLst.iterator(); iterator1
						.hasNext();) {
					MenuByUserDTO menu = (MenuByUserDTO) iterator1.next();
					int id = menu.getMenuId();
					if (id == menuId) {
						List<MenuByUserDTO> subMenuList = entry.getValue();
						menu.setSubMenuList(subMenuList);
						for (Iterator iterator2 = subMenuList.iterator(); iterator2
								.hasNext();) {
							MenuByUserDTO subMenu = (MenuByUserDTO) iterator2
									.next();
							int subMenuId1 = subMenu.getMenuId();
							List<MenuByUserDTO> childSubMenuList = mapSubMenuNChildSubMenu
									.get(subMenuId1);
							subMenu.setSubMenuList(childSubMenuList);

						}
						finalMenuLst.add(menu);
						break;
					}

				}

			}

			//long endTime = System.currentTimeMillis();
			//System.out.println("time diff in  DAO:: " + (endTime - startTime));
		}

		catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("In DAOException", e);

		}
    finally {
      try {
        if(rs != null) rs.close();
        if(callableStatement != null) callableStatement.close();
        if(connection != null) connection.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
      if(em != null) em.close();
    }

		return finalMenuLst;
	}
	
	@Override
	public MenuByUserDTO getMenuDetailsByUser(String cmpnyId, String storeId,
			String userId, String productTypeId, String menuId) throws DAOException {

		
		EntityManager em = null;
		CallableStatement callableStatement = null;
		Connection connection = null;
		ResultSet rs = null;
		MenuByUserDTO menu=null;

		try {
			
			//long startTime = System.currentTimeMillis();
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			// em.getTransaction().begin();
			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses
					.getSessionFactory();
			connection = sessionFactory.getConnectionProvider().getConnection();
			int storeid = Integer.parseInt(storeId);
			int cmpnyid = Integer.parseInt(cmpnyId);
			int userid = Integer.parseInt(userId);
			int menuid = Integer.parseInt(menuId);
			int productTypeId1 = Integer.parseInt(productTypeId);

			callableStatement = connection
					.prepareCall(StoredProcedures.PROC_MENU_DETAILS_BY_USER);
			callableStatement.setInt(1, cmpnyid);
			callableStatement.setInt(2, storeid);
			callableStatement.setInt(3, userid);
			callableStatement.setInt(4, menuid);
			callableStatement.setInt(5, productTypeId1);

			callableStatement.execute();
			rs = callableStatement.getResultSet();

			ReflectionResultSetMapper<MenuByUserDTO> resultSetMapper1 = new ReflectionResultSetMapper<MenuByUserDTO>(
					MenuByUserDTO.class);

			while (rs.next()) {
				String qs=rs.getString("QS");
				menu = resultSetMapper1.mapRow(rs);
				//menu.setQS(qs);

			}
		
			//long endTime = System.currentTimeMillis();
			//System.out.println("time diff in DAO:: " + (endTime - startTime));
		}

		catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("In DAOException", e);

		}
		finally {
      try {
        if(rs != null) rs.close();
        if(callableStatement != null) callableStatement.close();
        if(connection != null) connection.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
      if(em != null) em.close();
    }


		return menu;
	}

	@Override
	public LoginInfoByUserDTO getUserByCredential(LoginInfoByUserDTO user)
			throws DAOException {

		EntityManager em = null;
		CallableStatement callableStatement = null;
		Connection connection = null;
		ResultSet rs = null;
		LoginInfoByUserDTO loggedUser = new LoginInfoByUserDTO();
		StoreMaster storeMaster = null;

		if (ReturnConstant.testLicense) {
			try {

				entityManagerFactory = PersistenceListener.getEntityManager();

				em = entityManagerFactory.createEntityManager();
				EntityTransaction transaction = em.getTransaction();
				transaction.begin();
				Query qry = em.createQuery("SELECT k FROM KeyBean k");
				List<KeyBean> listKey = qry.getResultList();

				if (listKey != null && listKey.size() == 0) {
					LoginInfoByUserDTO userLogged = new LoginInfoByUserDTO();
					userLogged.setId(0);
					userLogged
							.setMessage(ReturnConstant.MSG_LOGIN_NO_LICENSE);
					return userLogged;
				}
			}
			catch (Exception ex) {
				ex.printStackTrace();
			}
			finally {
				if(em != null) em.close();
			}
		}

		try {
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			
			Session ses = (Session) em.getDelegate();
			SessionFactoryImpl sessionFactory = (SessionFactoryImpl) ses.getSessionFactory();
			connection = sessionFactory.getConnectionProvider().getConnection();
			String userName = user.getUserName();
			String passwrd = user.getPassword();
			String loginDate = user.getLoginDate();
			java.sql.Date loginDate1 = DateUtil.convertStringDateToSqlDate(
					loginDate, "yyyy-MM-dd");

			callableStatement = connection
					.prepareCall(StoredProcedures.PROC_LOGIN_INFO_BY_USER);
			callableStatement.setString(1, userName);
			callableStatement.setString(2, passwrd);
			callableStatement.setDate(3, loginDate1);

			callableStatement.execute();
			rs = callableStatement.getResultSet();
			ReflectionResultSetMapper<LoginInfoByUserDTO> resultSetMapper = new ReflectionResultSetMapper<LoginInfoByUserDTO>(
					LoginInfoByUserDTO.class);

			if (!rs.next()) {
				System.out.println("no data");
				loggedUser
						.setMessage(ReturnConstant.MSG_LOGIN_INVALID_CREDENTIAL);
			}

			else {

				do {
					int id=rs.getInt(1);
					//System.out.println("Id is:: "+id);
					loggedUser = resultSetMapper.mapRow(rs);
					int id1=loggedUser.getId();
					System.out.println("logged id:: "+id1);

				} while (rs.next());
			}
			
			int storeId = loggedUser.getStoreId();
			Query qrygetstore = em
					.createQuery("SELECT s FROM StoreMaster s WHERE s.id=:storeid and s.isDeleted=0");

			qrygetstore.setParameter("storeid", storeId);
			storeMaster = (StoreMaster) qrygetstore.getSingleResult();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("In DAOException", e);

		}
    finally {
      try {
        if(rs != null) rs.close();
        if(callableStatement != null) callableStatement.close();
        if(connection != null) connection.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
      if(em != null) em.close();
    }

		// license

		if (ReturnConstant.testLicense)
			try {
				{
					entityManagerFactory = PersistenceListener.getEntityManager();

					em = entityManagerFactory.createEntityManager();
					EntityTransaction transaction = em.getTransaction();
					transaction.begin();
					Query qry = em
							.createQuery("SELECT k FROM KeyBean k WHERE k.store_id=:store_id order by k.id desc");
					qry.setMaxResults(1);

					qry.setParameter("store_id",
							Integer.toString(loggedUser.getStoreId()));
					KeyBean bean = (KeyBean) qry.getSingleResult();
					String license = bean.getLicense_key();

					boolean isValidKey = true;

					// TGFhZ05GemRtMDFEZ2Fk
					KeyDetails keyDetails = new KeyDetails();
					KeyBean key = keyDetails.getKeyDetails(license);
					
					//System.out.println("KeyBean:: "+key);

					//System.out.println("");
					if (!(Integer.parseInt(key.getStore_id()) == storeMaster
							.getId())) {
						isValidKey = false;
						loggedUser = new LoginInfoByUserDTO();
						loggedUser.setId(0);
						loggedUser.setMessage(ReturnConstant.MSG_LOGIN_INVALID_STORE);
						return loggedUser;

					}
					// 2016-10-30
					Date curntDate = new Date();
					SimpleDateFormat formatter = new SimpleDateFormat(
							"yyyy-MM-dd");
					String currentDate = formatter.format(curntDate);
					//System.out.println("currentDate :: "+currentDate);
					//System.out.println("to date :: "+key.getTo_date());
					//if (!(key.getTo_date().hashCode() > currentDate.hashCode())) {
					if (!(DateUtil.StringDateTojavaDate(key.getTo_date(),"yyyy-MM-dd")).after(DateUtil.StringDateTojavaDate(currentDate,"yyyy-MM-dd"))) {
						isValidKey = false;
						loggedUser = new LoginInfoByUserDTO();
						loggedUser.setId(0);
						loggedUser.setMessage(ReturnConstant.MSG_LOGIN_LICENSE_EXPIRE);
						return loggedUser;
					}
					List<User> noOfUsersList =getUsersByStore("" + storeMaster.getId());
					int noofUsers = noOfUsersList.size();
					if (!(noofUsers <= Integer.parseInt(key.getNo_of_users()))) {
						isValidKey = false;
						loggedUser = new LoginInfoByUserDTO();
						loggedUser.setId(0);
						loggedUser
								.setMessage(ReturnConstant.MSG_LOGIN_LICENSE_NO_OF_USERS_EXCEEDED);
						return loggedUser;
					}
				}
			} catch (Exception e) {
				loggedUser = new LoginInfoByUserDTO();
				loggedUser.setId(0);
				loggedUser
						.setMessage(ReturnConstant.MSG_LOGIN_NO_LICENSE);
			}
    finally {
      if(em != null) em.close();
    }

		System.out.println("loggedUser = "+loggedUser);
		return loggedUser;
	}
	
	public List<User> getUsersByStore(String id) throws DAOException {

		List<User> userList = null;
		EntityManager em = null;
		int storeId = Integer.parseInt(id);
		int isActive=1;
		try {
			entityManagerFactory = PersistenceListener.getEntityManager();
			em = entityManagerFactory.createEntityManager();
			em.getTransaction().begin();
			Query qry = em
					.createQuery("SELECT c FROM User c WHERE c.storeId=:storeId and c.isActive=:isActive");
			qry.setParameter("storeId", storeId);
			qry.setParameter("isActive", isActive);
			userList = (List<User>) qry.getResultList();
			em.getTransaction().commit();

		} catch (Exception e) {
			throw new DAOException("Check data to be shown", e);
		} finally {
			if(em != null) em.close();
		}
		return userList;

	}

}
