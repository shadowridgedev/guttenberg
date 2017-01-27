package guttenberg;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class GuttenbergHibernateStorage {
	private static SessionFactory factory;
	private static ServiceRegistry serviceRegistry;
	private static Transaction newTransaction;
	private static Session newSession;
	
	GuttenbergHibernateStorage() {

		Configuration config = new Configuration().addResource("Book.hbm.xml");

		serviceRegistry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
		factory = config.buildSessionFactory(serviceRegistry);
		newSession = factory.openSession();

	}
	
	void saveBook( Book book)  {
		try {
			newSession.beginTransaction();
			newSession.save(book);
			newSession.getTransaction().commit();
		}
		catch (HibernateException e) {
			e.printStackTrace();
			newSession.getTransaction().rollback();
		}
		newSession.close();
	}
}
