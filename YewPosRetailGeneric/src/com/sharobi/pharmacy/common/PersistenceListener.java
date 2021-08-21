package com.sharobi.pharmacy.common;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class PersistenceListener implements ServletContextListener {

	private static EntityManagerFactory entityManagerFactory;

	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("PersistenceListener::contextInitialized");
		ServletContext context = sce.getServletContext();
		entityManagerFactory = Persistence.createEntityManagerFactory("Pharmacy");
		System.out.println("In contextInitialized: "+entityManagerFactory);
	}

	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("In contextDestroyed: "+entityManagerFactory.isOpen());
		entityManagerFactory.close();
	}

	public static EntityManagerFactory getEntityManager() {
		
		return entityManagerFactory;
	}
}
