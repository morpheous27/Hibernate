package org.nitin.bidirectional.manytomany;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import util.HibernateUtil;

public class Runnerbm2m {
	
	public static void main(String[] args) 
	{
		System.err.println("Demoing one to one relationship...");
		Runnerbm2m runner = new Runnerbm2m();
		//runner.create();
		runner.read();
		HibernateUtil.getSessionFactory().close();
		
	}
	
	public void read()
	{
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {	
			transaction = session.beginTransaction();
			
			Departmentbm2m department = new Departmentbm2m();
			
			// fetching department and then child
			department = (Departmentbm2m) session.get(Departmentbm2m.class, new Long("1"));
			
			Employeebm2m emp1 = (Employeebm2m) session.get(Employeebm2m.class, new Long("2"));

			Employeebm2m emp2 = (Employeebm2m) session.get(Employeebm2m.class, new Long("4"));
			
			System.out.println(emp1.getDepartmentbm2m());

			for(Departmentbm2m d : emp1.getDepartmentbm2m())
				System.out.println(d.getDepartmentName());
			
			System.out.println(emp2.getDepartmentbm2m());
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
				
				Departmentbm2m department1 = new Departmentbm2m();
				department1.setDepartmentName("Sales");
				
				Departmentbm2m department2 = new Departmentbm2m();
				department2.setDepartmentName("Finance");
				
				Set<Departmentbm2m> setD = new HashSet<Departmentbm2m>();
				setD.add(department1);
				setD.add(department2);
				
				Employeebm2m emp1 = new Employeebm2m("Nina", "Mayers", "111");
				Employeebm2m emp2 = new Employeebm2m("Toby", "Miller", "222");
				
				emp1.setDepartmentbm2m(setD);
				
				Set<Employeebm2m> set = new HashSet<Employeebm2m>();
				set.add(emp1);
				set.add(emp2);
				
				department1.setEmployee(set);
				
				session.save(department1);
				
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
