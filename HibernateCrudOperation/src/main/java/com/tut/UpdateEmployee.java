package com.tut;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class UpdateEmployee {

	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

		Session session = sessionFactory.openSession();
		Employee emp = session.get(Employee.class, 1);
		Transaction transactoin = session.beginTransaction();

		// Check if the employee exists before attempting to update
		if (emp != null) {
			emp.setEmployee("Asadullah Shaikh");
			session.update(emp);
			System.out.println("Updated Successfully...");
		} else {
			System.out.println("Employee with this ID is not available.");
		}
		transactoin.commit();
		sessionFactory.close();

	}

}
