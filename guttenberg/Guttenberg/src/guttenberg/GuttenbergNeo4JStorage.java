package guttenberg;


import org.hibernate.HibernateException;
import org.neo4j.driver.internal.spi.Connection;
import org.neo4j.driver.v1.AuthTokens;
import org.neo4j.driver.v1.Driver;
import org.neo4j.driver.v1.GraphDatabase;
import org.neo4j.driver.v1.Session;
import org.neo4j.driver.v1.Statement;

public class GuttenbergNeo4JStorage {

    Connection connection = null;
	Statement stmt = null;
	private Session Neo4Jsession;
	
	GuttenbergNeo4JStorage(String DB_URL, String USER, String PASS) throws ClassNotFoundException {

	//	Class.forName("org.neo4.driver.v1;");
		Driver driver = GraphDatabase.driver( DB_URL, AuthTokens.basic( USER, PASS ) );

	    Session Neo4Jsession = driver.session();
	}

	public void InsertBook(Book book) {

		Neo4Jsession.beginTransaction();

			// System.out.println(book.getTitle() + " by " + book.getAuthor());
	//		saveBook(book);
		


	Neo4Jsession.close();
	}
	
	

	void saveBook(Book book) {

		try {

			Statement command = null;
			Neo4Jsession.run(command);
		} catch (HibernateException e) {
			e.printStackTrace();
		
			Neo4Jsession.close();
		}

	}
}
