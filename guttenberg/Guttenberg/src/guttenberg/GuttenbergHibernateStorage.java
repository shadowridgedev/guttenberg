package guttenberg;

import java.util.ArrayList;

import org.hibernate.FlushMode;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class GuttenbergHibernateStorage {
	private static SessionFactory factory;
	private static ServiceRegistry serviceRegistry;
	private static Session newSession;

	GuttenbergHibernateStorage() {

		Configuration config = new Configuration();
		config.configure("hibernate.cfg.xml");
		config.addResource("Book.hbm.xml");
		serviceRegistry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
		factory = config.buildSessionFactory(serviceRegistry);

	}

	void SaveBooks(ArrayList<Book> thebooks) {
		newSession = factory.openSession();
		for (Book book : thebooks) {
			saveBook(book);
		}
		newSession.close();
	}

	void saveBook(Book book) {
		try {
			newSession.beginTransaction();
			newSession.save(book);
			newSession.getTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			newSession.getTransaction().rollback();
			newSession.close();
		}

	}

	public static void delete(Book book) {

		newSession.beginTransaction();
		newSession.delete(book);
		newSession.getTransaction().commit();
	}
}
