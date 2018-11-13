import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Fetch {

	

	public static void main(String[] args) {
		Fetch main = new Fetch();
		main.addData();
		// main.runHQL();

	}

	private void runHQL() {
		////session = sessionFactory.openSession();
		//Query query = session
		//		.createQuery("from Employee e, e.address  a where a.flat = '21'");
		//List<Object[]> object = query.list();
		//for (Object[] obj : object)
		//	System.out.println(obj[0]);

	}

	void addData() {

		Configuration cfg = new Configuration();
		SessionFactory sessionFactory = cfg.configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Set set = new HashSet();

		Address add1 = new Address();
		add1.setCity("bareilly");
		add1.setFlat(21);
		add1.setState("UP");
		add1.setStreet("gandhi puram");

		Address add2 = new Address();
		add2.setCity("mumbai");
		add2.setFlat(424);
		add2.setState("MH");
		add2.setStreet("Vanrai");

		set.add(add1);
		set.add(add2);
		session.save(add1);	
		session.save(add2);
		
		Employee employee = new Employee();	
		employee.setName("saxena");
		employee.setAddress(set);
		//session.save(add1);
		//session.save(add1);
		session.save(employee);
		
		//session.save(ud);

		transaction.commit();
		session.close();

		// session = sessionFactory.openSession();
		// transaction = session.beginTransaction();
		// System.out.println("object saved with id : " + id);
		//
		// Employee employee2 = new Employee();
		// employee2.setName("saxena");
		// employee2.setAddress(set); // since address object has already been
		// // persisted hence other entry will not
		// // be allowed for some other employee
		// // object
		// id = (int) session.save(employee2);
		// System.out.println("object saved with id : " + id);
		// transaction.commit();
		// session.close();

	}
}
