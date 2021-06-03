package com.hql;

import java.util.*;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tut.Student;
import com.map.Answer;
import com.map.Question;

public class HQLExample {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

		Session s = factory.openSession();

		Transaction tx = s.beginTransaction();

		// HQL
		// syntax

		String query = "from Student";

		Query q = s.createQuery(query);

		// single result :- unique //multiple result :- list

		List<Student> list = q.list();

		for (Student x : list) {
			System.out.println(x.getName());
		}

		/*
		 * String query = "from Student where city='Dhanbad'";
		 * 
		 * Query q = s.createQuery(query);
		 * 
		 * //single result :- unique //multiple result :- list
		 * 
		 * List<Student> list=q.list();
		 * 
		 * for(Student x:list) {
		 * System.out.println(x.getName()+" : "+x.getCerti().getCourse()); }
		 */

		/*
		 * String query = "from Student where city=:x";
		 * 
		 * Query q = s.createQuery(query);
		 * 
		 * q.setParameter("x", "Dhanbad");
		 * 
		 * //single result :- unique //multiple result :- list
		 * 
		 * List<Student> list=q.list();
		 * 
		 * for(Student x:list) { System.out.println(x.getName()); }
		 * 
		 */

		System.out.println("----------------------------------------");

		// delete query

		/*
		 * Query q1 = s.createQuery("delete from Student where city=:c");
		 * 
		 * q1.setParameter("c", "Dhanbad");
		 * 
		 * int r=q1.executeUpdate(); System.out.println("Deleted :- "+r);
		 * 
		 */

		// update

		/*
		 * Query q2 = s.createQuery("update Student set city=:c where name=:n");
		 * q2.setParameter("c", "New York"); q2.setParameter("n", "Rakesh");
		 * 
		 * int r = q2.executeUpdate(); System.out.println(r + " objects updated");
		 */
		
		
		// join
		
		
		Query q3 = s.createQuery("select q.question, q.qustionId, a.answer from Question as q INNER JOIN q.answers as a");
		
		
		List<Object []>list3=q3.getResultList();
		
		for(Object[] arr: list3) {
			System.out.println(Arrays.toString(arr));
		}

		tx.commit();
		s.close();
		factory.close();

	}
}
