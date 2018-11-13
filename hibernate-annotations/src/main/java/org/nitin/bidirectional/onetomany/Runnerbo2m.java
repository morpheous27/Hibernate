package org.nitin.bidirectional.onetomany;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import util.HibernateUtil;

public class Runnerbo2m {
	
	public static void main(String[] args) 
	{
		System.err.println("Demoing one to one relationship...");
		Runnerbo2m runner = new Runnerbo2m();
		runner.create();
		runner.read();
		HibernateUtil.getSessionFactory().close();
		
	}
	
	public void read()
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {	
			transaction = session.beginTransaction();
			
			Departmentbo2m department = new Departmentbo2m();
			
			// fetching department and then child
			department = (Departmentbo2m) session.get(Departmentbo2m.class, new Long("31"));
			
			Employeebo2m emp1 = (Employeebo2m) session.get(Employeebo2m.class, new Long("32"));

			Employeebo2m emp2 = (Employeebo2m) session.get(Employeebo2m.class, new Long("33"));
			
			System.out.println(emp1.getDepartmentbo2o().getDepartmentName());
			System.out.println(emp2.getDepartmentbo2o().getDepartmentName());
			System.out.println(department.getEmployee().size());
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
				
				Departmentbo2m department = new Departmentbo2m();
				department.setDepartmentName("Sales");
				
				Employeebo2m emp1 = new Employeebo2m("Nina", "Mayers", "111");
				Employeebo2m emp2 = new Employeebo2m("Toby", "Miller", "222");
				
				Set<Employeebo2m> set = new HashSet<Employeebo2m>();
				set.add(emp1);
				set.add(emp2);
				department.setEmployee(set);
				
				emp1.setDepartmentbo2o(department);
				emp2.setDepartmentbo2o(department);
				
				session.save(department);
				
				//session.save(emp1);
				//session.save(emp2);

				transaction.commit();
			} catch (HibernateException e) {
				transaction.rollback();
				e.printStackTrace();
			} finally {
				session.close();
			}

	}


}
