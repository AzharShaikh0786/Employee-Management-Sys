package com.tut;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class AddEmployee {

	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

		Employee emp = new Employee();
		emp.setEmployee("Azhar Shaikh");
		emp.setSalary("47383");
		Employee emp1 = new Employee();
		emp1.setEmployee("Safdar Shaikh");
		emp1.setSalary("47383");

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(emp);
		session.save(emp1);
		transaction.commit();
		session.close();
		sessionFactory.close();
		System.out.println("Data Added Succesfully...");

	}

}
