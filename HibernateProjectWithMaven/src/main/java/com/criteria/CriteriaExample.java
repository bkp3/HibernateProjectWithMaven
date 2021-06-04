package com.criteria;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.tut.Student;

public class CriteriaExample {
	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session s = factory.openSession();

		// hibernate criteria API
		Criteria c = s.createCriteria(Student.class);

		// adding restrictions
		// c.add(Restrictions.eq("certi.course", "Java"));

		List<Student> st = c.list();

		for (Student x : st) {
			System.out.println(x);
		}

		s.close();
		factory.close();
	}

}
