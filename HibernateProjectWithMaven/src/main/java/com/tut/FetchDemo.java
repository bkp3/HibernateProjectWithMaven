package com.tut;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchDemo {

	public static void main(String[] args) {
		// get, load 
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		
		Session session = factory.openSession();
		
		//get-student:10
//		Student student=(Student)session.get(Student.class, 15);
		Student student=(Student)session.load(Student.class, 50);
		System.out.println(student);
		
		Address ad=(Address)session.get(Address.class, 50);
		System.out.println(ad);
		
		session.close();
		factory.close();

	}

}
