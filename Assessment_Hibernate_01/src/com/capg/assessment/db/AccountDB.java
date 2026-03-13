package com.capg.assessment.db;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.classic.Session;

public class AccountDB {
	
	
	static SessionFactory factory =  new AnnotationConfiguration().configure().buildSessionFactory();

	public static Session getSession() {
		
		return factory.openSession();
		
		
	}
	
}
