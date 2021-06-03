package com.cascade;

import java.util.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.map.Answer;
import com.map.Question;

public class CascadeExample {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session s = factory.openSession();

		Question q1 = new Question();

		q1.setQustionId(102);
		q1.setQuestion("What is swing framework?");

		Answer a1 = new Answer(204, "use fro development");
		Answer a2 = new Answer(205, "desktop");
		Answer a3 = new Answer(206, "learn by programmers");

		List<Answer> list = new ArrayList();

		list.add(a1);
		list.add(a2);
		list.add(a3);

		q1.setAnswers(list);

		Transaction tx=s.beginTransaction();
		
		s.save(q1);
		
		
		
		
		tx.commit();
		
		
		factory.close();

	}

}
