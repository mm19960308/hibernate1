package com.woniu.a;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
	
	private static SessionFactory sf;
	
	static {
		Configuration cfg = new Configuration();
		cfg.configure("com/woniu/a/hibernate.cfg.xml");
		sf = cfg.buildSessionFactory();
	}
	
	public static Session openSession() {
		return sf.openSession();
	}
	
	
}
