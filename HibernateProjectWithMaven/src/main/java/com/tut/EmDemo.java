package com.tut;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmDemo {
	
	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		
		Student st1=new Student();
		st1.setId(1001);
		st1.setName("Harish");
		st1.setCity("Kolkata");
		
		Certificate ct1=new Certificate();
		ct1.setCourse("Java");
		ct1.setDuration("2 months");
		
		st1.setCerti(ct1);
		
		Student st2=new Student();
		st2.setId(2001);
		st2.setName("Kaliya");
		st2.setCity("Mumbai");
		
		Certificate ct2=new Certificate();
		ct2.setCourse("Android");
		ct2.setDuration("5 months");
		
		st2.setCerti(ct2);
		
		Session s=factory.openSession();
		Transaction tx=s.beginTransaction();
		
		//object save
		s.save(st1);
		s.save(st2);
		
		tx.commit();
		s.close();
		
		factory.close();
	}

}
