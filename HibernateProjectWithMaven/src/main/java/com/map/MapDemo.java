package com.map;

import java.util.ArrayList;
import java.util.List;

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
		a1.setQuestion(q1);
		
		
		//creating more answer
		Answer a3 = new Answer();
		a3.setAnswerId(322);
		a3.setAnswer("Java is a object oriented language..");
		a3.setQuestion(q1);
		
		Answer a4 = new Answer();
		a4.setAnswerId(323);
		a4.setAnswer("Java is a multithreaded language.");
		a4.setQuestion(q1);
		
		List<Answer> list=new ArrayList<Answer>();
		list.add(a1);
		list.add(a3);
		list.add(a4);
		q1.setAnswers(list);
		
//		q1.setAnswer(a1);

//		// creating question
//		Question q2 = new Question();
//		q2.setQustionId(456);
//		q2.setQuestion("What is Python?");
//
//		// creating answer
//		Answer a2 = new Answer();
//		a2.setAnswerId(653);
//		a2.setAnswer("Python is a programming language used for ML.");
//		q2.setAnswer(a2);

		// session
		Session s = factory.openSession();
		Transaction tx = s.beginTransaction();

		// save
//		s.save(q1);
//		s.save(q2);
		
//		s.save(a1);
//		s.save(a2);

		s.save(q1);
		s.save(a1);
		s.save(a3);
		s.save(a4);
		
		tx.commit();
		
		//fetching..........
//		Question newQ=(Question)s.get(Question.class, 123);
//		System.out.println(newQ.getQuestion());
//		System.out.println(newQ.getAnswer().getAnswer());
//		
		Question qF=(Question)s.get(Question.class,123 );
		System.out.println(qF.getQuestion());
		for(Answer a:qF.getAnswers()) {
			System.out.println(a.getAnswer());
		}
		
		s.close();
		factory.close();

	}

}
