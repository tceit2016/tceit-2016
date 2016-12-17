package org.hibernate.runTest1;

import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.example.DTO.StudentDTO;
import org.hibernate.Query;

public class HibernateExample1 {

	public static void main(String[] args) {
		Session hibernateSession = null;

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

		hibernateSession = sessionFactory.openSession();

		Transaction tx = null;
		
		

		try {
			tx = hibernateSession.beginTransaction();
			List students = hibernateSession.createQuery("FROM StudentDTO").list();
			
			for (Iterator iterator = students.iterator(); iterator.hasNext();) {
				StudentDTO student = (StudentDTO) iterator.next();
				System.out.println("ID: " + student.getId());
				System.out.println("NAME: " + student.getName());
			}
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			hibernateSession.close();
		}
	}

}

/** SQL Statements associated with this program
 * create table student(id number primary key, name varchar2(50));
 * 
 * insert into student values(1, 'Albert');
 * insert into student values(2, 'Bob');
 * insert into student values(3, 'Charle');
 * */
