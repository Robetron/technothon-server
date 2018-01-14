package com.psl.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static SessionFactory sf;

	static {

		sf = new Configuration().configure("hibernate.cfg.xml")
				.buildSessionFactory();

	}

	public static Session getSession() {

		Session session = sf.openSession();

		return session;

	}

}
