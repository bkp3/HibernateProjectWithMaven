package com.pagination;

import org.hibernate.cfg.Configuration;

import com.tut.Student;

import java.util.List;

import org.hibernate.*;

public class HQLPagination {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

		Session s = factory.openSession();

		Query q1 = s.createQuery("from Student");

		// implementing pagination using hibernate

		q1.setFirstResult(0);

		q1.setMaxResults(5);

		List<Student> list = q1.list();

		for (Student x : list) {
			System.out.println(x.getId() + " : " + x.getName() + " : " + x.getCity());
		}

		s.close();
		factory.close();
	}

}
