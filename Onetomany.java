package controllers;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.ArrayList;

import org.hibernate.Transaction;
import org.hibernate.Session;


public class Onetomany {
      
	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		
		Question q1 = new Question();
		q1.setQuestionId(12);
		q1.setQuestion("What is java?");
		
		Answer a1 = new Answer();
		a1.setAnswerId(3);
		a1.setAnswer("Java is programming language");
		a1.setQuestion(q1);
		
		Answer a2 = new Answer();
		a2.setAnswerId(21);
		a2.setAnswer("object oriented programming");
		a2.setQuestion(q1);
		
		Answer a3 = new Answer();
		a3.setAnswerId(2);
		a3.setAnswer("Java is case sensitive language");
		a3.setQuestion(q1);
		
		/*List<Answer> list=new ArrayList<Answer>();
		list.add(a1);
		list.add(a2);
		list.add(a3);
		
		q1.setAnswers(list);
		
		s.persist(q1);
		s.persist(a1);
		s.persist(a2);
		s.persist(a3);*/
		
		Session s=factory.openSession();
		Transaction tx =s.beginTransaction();
		
		Question q=(Question)s.get(Question.class,12);
		System.out.println(q.getQuestion());
		
		Question w =(Question)s.get(Question.class,121);
		
		
		for(Answer a: w.getAnswers()) {
			System.out.println(a.getAnswer());
		}
		

		tx.commit();
		
		factory.close();
		s.close();
		
		
	}
}
