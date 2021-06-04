package com.firstLevelCache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.tut.Student;

public class FirstDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();

		// by default enabled

		Student st = session.get(Student.class, 1);
		System.out.println(st);

		System.out.println("working something!!!");

		Student st1 = session.get(Student.class, 1);
		System.out.println(st1);

		System.out.println(session.contains(st1));

		session.close();
		factory.close();
	}

}
