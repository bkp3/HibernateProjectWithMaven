package com.mapManyToMany;

import java.util.ArrayList;
import java.util.List;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MappingDemo {

	public static void main(String[] args) {
		
		SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		
		Emp e1 = new Emp();
		Emp e2 = new Emp();
		
		e1.setEid(10);
		e1.setEname("Ram");
		
		e2.setEid(20);
		e2.setEname("Shyam");
		
		Project p1=new Project();
		Project p2=new Project();
		
		p1.setPid(100);
		p1.setProjectName("Library Management System");
		
		p2.setPid(200);
		p2.setProjectName("Chatbot");

		List<Emp>list1=new ArrayList<Emp>();
		List<Project>list2=new ArrayList<Project>();
		
		list1.add(e1);
		list1.add(e2);
		
		list2.add(p1);
		list2.add(p2);
		
		e1.setProjects(list2);
		p2.setEmps(list1);
		
		//save
		Session s=factory.openSession();
		Transaction tx=s.beginTransaction();
		
		s.save(e1);
		s.save(e2);
		s.save(p1);
		s.save(p2);
		
		tx.commit();
		s.close();
		factory.close();
	}

}
