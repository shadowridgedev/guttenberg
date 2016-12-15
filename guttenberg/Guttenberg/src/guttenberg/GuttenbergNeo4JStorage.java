package guttenberg;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class GuttenbergNeo4JStorage {
	static final String JDBC_DRIVER = "jdbc:mysql://localhost:3306/books?autoReconnect=true&useSSL=false";

	Connection conn = null;
	Statement stmt = null;

	GuttenbergNeo4JStorage(String DB_URL, String USER, String PASS) throws ClassNotFoundException {

		Class.forName("org.neo4.driver.v1;");

		// Open a connection
		System.out.println("Connecting to database...");
		try {
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void InsertBook(Book book) {
		
	}
}