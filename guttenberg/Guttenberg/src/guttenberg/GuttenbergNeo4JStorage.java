package guttenberg;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import org.neo4j.driver.v1.*;

public class GuttenbergNeo4JStorage {


	Connection conn = null;
	Statement stmt = null;

	GuttenbergNeo4JStorage(String DB_URL, String USER, String PASS) throws ClassNotFoundException {

	//	Class.forName("org.neo4.driver.v1;");

		Driver driver = GraphDatabase.driver( DB_URL, AuthTokens.basic( USER, PASS ) );
		Session session = driver.session();
	}

	public void InsertBook(Book book) {
		
	}
}

