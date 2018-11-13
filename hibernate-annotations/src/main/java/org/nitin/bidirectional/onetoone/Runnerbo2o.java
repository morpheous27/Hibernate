package org.nitin.bidirectional.onetoone;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import util.HibernateUtil;

public class Runnerbo2o {

	public static void main(String[] args) {
		System.err.println("Demoing one to one relationship...");
		Runnerbo2o runner = new Runnerbo2o();
		// runner.create();
		runner.read();
		HibernateUtil.getSessionFactory().close();

	}

	public void read() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();

			Departmentbo2o department = new Departmentbo2o();

			// fetching department and then child
			department = (Departmentbo2o) session.get(Departmentbo2o.class, new Long("23"));

			// Employeebo2o emp = (Employeebo2o) session.get(Employeebo2o.class,
			// new Long("20"));

			// System.out.println(emp.getDepartmentbo2o().getDepartmentName());
			System.out.println(department.getEmployees().getFirstname());
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();

		}

	}

	public void create() {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();

			Departmentbo2o department = new Departmentbo2o();
			department.setDepartmentName("Sales");

			Employeebo2o emp1 = new Employeebo2o("Nina", "Mayers", "111");

			department.setEmployees(emp1);
			emp1.setDepartmentbo2o(department);
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
