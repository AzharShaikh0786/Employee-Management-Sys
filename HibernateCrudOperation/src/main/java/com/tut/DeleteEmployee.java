package com.tut;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class DeleteEmployee {

	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

		Session session = sessionFactory.openSession();
		Employee emp = session.get(Employee.class, 1);
		Transaction transactoin = session.beginTransaction();

		
		// Check if the employee exists before attempting to delete
		if (emp != null) {
			session.delete(emp);
			System.out.println("Deleted Successfully...");
		} else {
			System.out.println("Employee with this ID is not available.");
		}
		
		
		transactoin.commit();
		sessionFactory.close();

	}

}
