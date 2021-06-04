package com.secondLevelCache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.cfg.Configuration;

import com.tut.Student;

public class SecondDemo {
	public static void main(String[] args) {
		

		SessionFactory factory = new Configuration().configure().buildSessionFactory();

		Session s1 = factory.openSession();
		Student st1 = s1.get(Student.class, 1);
		System.out.println(st1);

		s1.close();
		

		Session s2 = factory.openSession();
		Student st2 = s2.get(Student.class, 1);
		System.out.println(st2);
		s2.close();

	}

}
