package com.psl.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtility {
	private static SessionFactory sf;

	public static Session getSesssion() {

		sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		
		Session session = sf.openSession();
		return session;
	}

}
