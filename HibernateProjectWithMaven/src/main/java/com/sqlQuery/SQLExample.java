package com.sqlQuery;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

import com.tut.Student;

public class SQLExample {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure().buildSessionFactory();

		Session s = factory.openSession();

		// sql query
		String q = "select * from student";

		NativeQuery nq = s.createSQLQuery(q);

		List<Object[]> list = nq.list();

		for (Object[] x : list) {
			// System.out.println(Arrays.deepToString(x));

			System.out.println(x[4] + " : " + x[3]);
		}

		s.close();
		factory.close();
	}

}