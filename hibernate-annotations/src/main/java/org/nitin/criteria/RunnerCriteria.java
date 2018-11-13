package org.nitin.criteria;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import util.HibernateUtil;

/**
 * 
 * @author nitin-windows
 *  This class works with HR user in local db.
 *
 */
public class RunnerCriteria {

	public static void main(String[] args) {
		
		System.err.println("Demoing criteria ...");
		RunnerCriteria runner = new RunnerCriteria();
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

			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.DATE,-1);
			Date date = cal.getTime();
			
			Criteria cr = session.createCriteria(EmployeeCriteria.class);
			//cr.add(Restrictions.ilike("firstname", "tin", MatchMode.ANYWHERE));
			//cr.setProjection(Projections.property("departmentbo2o"))
			//cr.add(Restrictions.or(Restrictions.eq("cellphone", "111"), Restrictions.eq("lastname", "Saxena")));
			cr.add(Restrictions.eq("birthDate", date))
			.createCriteria("departmentbo2o","dep")
			.add(Restrictions.or(Restrictions.eq("dep.departmentName", "Sales"),Restrictions.ilike("dep.departmentName", "Tech")));
			//.add(Restrictions.eq("departmentName", "Sales"));
			List<EmployeeCriteria> list  = cr.list();
			for(EmployeeCriteria obj : list)
			{
				System.out.println(obj.getFirstname());
			}
			
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
				
				DepartmentCriteria department = new DepartmentCriteria();
				department.setDepartmentName("Ops");
				
				EmployeeCriteria emp1 = new EmployeeCriteria("patel", "patel", "333");
				
				department.setEmployees(emp1);
				emp1.setDepartmentbo2o(department);
				
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
