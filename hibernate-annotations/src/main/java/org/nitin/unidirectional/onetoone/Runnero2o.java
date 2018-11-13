package org.nitin.unidirectional.onetoone;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import util.HibernateUtil;

public class Runnero2o {
	
	public static void main(String[] args) 
	{
		System.err.println("Demoing one to one relationship...");
		Runnero2o runner = new Runnero2o();
		runner.create();
		//runner.read();
		HibernateUtil.getSessionFactory().close();
		
	}
	
	public void read()
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			
			Departmento2o department = new Departmento2o();
			
			// fetching department and then child
			department = (Departmento2o) session.get(Departmento2o.class, new Long("68"));

			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
			
		}

	}
	
	
	public void create()
	{
		
			Session session = HibernateUtil.getSessionFactory().openSession();
			Transaction transaction = null;
			try {
				transaction = session.beginTransaction();
				
				Departmento2o department = new Departmento2o();
				department.setDepartmentName("Sales");
				
				Employeeo2o emp1 = new Employeeo2o("Nina", "Mayers", "111");
				

				session.save(department);
				
				session.save(emp1);

				transaction.commit();
			} catch (HibernateException e) {
				transaction.rollback();
				e.printStackTrace();
			} finally {
				session.close();
			}

	}


}
