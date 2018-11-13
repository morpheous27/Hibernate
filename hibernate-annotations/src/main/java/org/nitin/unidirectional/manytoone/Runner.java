package org.nitin.unidirectional.manytoone;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import util.HibernateUtil;

public class Runner {
	
	public static void main(String[] args) 
	{
		System.err.println("Demoing one to many relationship...");
		Runner runner = new Runner();
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
			
			Department department = new Department();
			
			// fetching department and then child
			department = (Department) session.get(Department.class, new Long("68"));

			//Employee employee = (Employee) session.get(Employee.class, new Long("66"));
			
			//System.out.println(employee.getDepartment().getDepartmentName());
			for(Employee e : department.getEmployees())
			{
				System.out.println(e.getFirstname());
			}
			

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
				
				Department department = new Department();
				department.setDepartmentName("Sales");
				
				Employee emp1 = new Employee("Nina", "Mayers", "111");
				Employee emp2 = new Employee("Tony", "Almeida", "222");
				
				Set<Employee> set = new HashSet<Employee>();
				set.add(emp1);
				set.add(emp2);
				//emp1.setDepartment(department);
				//emp2.setDepartment(department);
				
				department.setEmployees(set);
				

				//session.save(department);
				
				session.save(emp1);
				session.save(emp2);

				transaction.commit();
			} catch (HibernateException e) {
				transaction.rollback();
				e.printStackTrace();
			} finally {
				session.close();
			}

	}


}
