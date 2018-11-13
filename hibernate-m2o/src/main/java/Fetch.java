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

		Address address = new Address();
		address.setCity("bareilly");
		address.setFlat(21);
		address.setState("UP");
		address.setStreet("gandhi puram");
		Employee employee = new Employee();
		employee.setName("nitin");
		employee.setAddress(address);
		Integer id = (Integer) session.save(employee);
		transaction.commit();
		session.close();
		session = sessionFactory.openSession();
		transaction = session.beginTransaction();
		System.out.println("object saved with id : " + id);

		Employee employee2 = new Employee();
		employee2.setName("saxena");
		employee2.setAddress(address);
		id = (Integer) session.save(employee2);
		System.out.println("object saved with id : " + id);
		transaction.commit();
		session.close();

	}
}
