import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Fetch {

	public static void main(String[] args) {
		Fetch main = new Fetch();
		main.addData();

	}

	void addData() {
		Configuration cfg = new Configuration();
		SessionFactory sessionFactory = cfg.configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		Employee employee = new Employee();
		employee.setName("nitin");

		Employee employee2 = new Employee();
		employee2.setName("nitin2");

		Set seta = new HashSet();
		seta.add(employee);

		Address address1 = new Address();
		address1.setCity("bareilly");
		address1.setFlat(21);
		address1.setState("UP");
		address1.setStreet("gandhi puram");
		address1.setSet(seta);
		seta.add(employee2);
		Address address2 = new Address();
		address2.setCity("bly");
		address2.setFlat(22);
		address2.setState("UP2");
		address2.setStreet("gandhi puram2");
		address2.setSet(seta);

		Set set = new HashSet();
		set.add(address1);
		employee.setSet(set);
		set.add(address2);
		employee2.setSet(set);
		Integer id = (Integer) session.save(address1);
		Integer id2 = (Integer) session.save(address2);
		transaction.commit();
		session.close();
		sessionFactory.close();
	}
}
