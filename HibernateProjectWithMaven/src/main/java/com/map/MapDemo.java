package com.map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MapDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

		// creating question
		Question q1 = new Question();
		q1.setQustionId(123);
		q1.setQuestion("What is Java?");

		// creating answer
		Answer a1 = new Answer();
		a1.setAnswerId(321);
		a1.setAnswer("Java is a programming language.");
		q1.setAnswer(a1);

		// creating question
		Question q2 = new Question();
		q2.setQustionId(456);
		q2.setQuestion("What is Python?");

		// creating answer
		Answer a2 = new Answer();
		a2.setAnswerId(653);
		a2.setAnswer("Python is a programming language used for ML.");
		q2.setAnswer(a2);

		// session
		Session s = factory.openSession();
		Transaction tx = s.beginTransaction();

		// save
		s.save(q1);
		s.save(q2);
		
		s.save(a1);
		s.save(a2);

		tx.commit();
		
		//fetching..........
		Question newQ=(Question)s.get(Question.class, 123);
		System.out.println(newQ.getQuestion());
		System.out.println(newQ.getAnswer().getAnswer());
		
		s.close();
		factory.close();

	}

}
