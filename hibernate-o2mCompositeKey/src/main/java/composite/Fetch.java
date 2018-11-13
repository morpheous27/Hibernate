package composite;
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

		ProductMaster productMaster  = new ProductMaster();
		ParentPK pk = new ParentPK();
		pk.setPid(1);
		pk.setPname("one");
		productMaster.setParentPK(pk);
		productMaster.setPclass("pclass");
		
		ClientMaster clientMaster = new ClientMaster();
		clientMaster.setProductMaster(productMaster);

		session.save(clientMaster);
		//session.save(productMaster);
		transaction.commit();
		session.close();
		

	}
}
