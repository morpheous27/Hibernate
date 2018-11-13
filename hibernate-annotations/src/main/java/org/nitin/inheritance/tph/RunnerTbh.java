package org.nitin.inheritance.tph;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.nitin.inheritance.tph.Bike.InjectionType;

import util.HibernateUtil;

public class RunnerTbh {
	
	public static void main(String[] args) 
	{
		System.err.println("Demoing one to one relationship...");
		RunnerTbh runner = new RunnerTbh();
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
			Bike b = (Bike) session.get(Bike.class, new Long(252));
			System.out.println(b.getInjectionType());
			
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
				
				Vehicle v = new Vehicle();
				v.setVname("vehicle");
				
				Car c = new Car();
				c.setVname("Car");
				c.setAutomatic(true);
				c.setIs4wheel(true);
				c.setType("4Wheeler");

				Bike b = new Bike();
				b.setVname("Bike");
				b.setAutomatic(true);
				b.setInjectionType(InjectionType.ANALOGU);
				
				session.save(v);
				session.save(c);
				session.save(b);
				
				transaction.commit();
			} catch (HibernateException e) {
				transaction.rollback();
				e.printStackTrace();
			} finally {
				session.close();
			}

	}


}
