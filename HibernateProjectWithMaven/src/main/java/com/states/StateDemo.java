package com.states;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tut.Certificate;
import com.tut.Student;

/*
 
 Hibernate Object State:-
 	1. Transient
 	2. Persistent
 	3. Detached
 	4. Removed
 	
 
*/
public class StateDemo {

	public static void main(String[] args) {
		
		System.out.println("Example:- ");
		
		SessionFactory f = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		
		//creating student object;
		Student st=new Student();
		
		st.setId(12145);
		st.setName("Abhishek");
		st.setCity("Dhanbad");
		st.setCerti(new Certificate("Java Hibernate Course","2 months"));
		//st : Transient
		
		Session s = f.openSession();
		Transaction tx=s.beginTransaction();
		
		s.save(st);
		//st : Persistent - session, database
		st.setName("Mukesh");
		
		tx.commit();
		
		s.close();
		
		//st : Detached
		st.setName("Rahul");
		System.out.println(st.getName());
		f.close();
	}

}
