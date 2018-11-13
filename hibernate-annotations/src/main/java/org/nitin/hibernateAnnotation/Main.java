package org.nitin.hibernateAnnotation;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.nitin.model.Address;
import org.nitin.model.EmployeeEntity;

import util.HibernateUtil;

/**
 * Hello world!
 *
 */
public class Main 
{
	public static void main(String[] args) 
	{
		System.out.println("starting persistence...");
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			Address address = new Address();
			address.setCity("bareilly");
			address.setState("UP");
			address.setStreet("Gandhi Puram");
			address.setZipcode("243122");
			
		
			
			EmployeeEntity employeeEntity = new EmployeeEntity();
			employeeEntity.setFirstName("Nitin");
			employeeEntity.setLastName("Saxena");
			employeeEntity.setStudentAddress(address);
			
			session.save(employeeEntity );
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

	}

}
