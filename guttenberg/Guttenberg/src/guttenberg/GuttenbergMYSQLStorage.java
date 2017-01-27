package guttenberg;

import java.io.File;
import java.sql.*;
import java.util.ArrayList;



public class GuttenbergMYSQLStorage {
//	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";


	Connection conn = null;
	Statement stmt = null;

	GuttenbergMYSQLStorage(String DB_URL, String USER, String PASS) throws ClassNotFoundException {

//		Class.forName("com.mysql.jdbc.Driver");

		// Open a connection
		System.out.println("Connecting to database...");
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/guttenberg","root","Rs232x25");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	void StoreBooks( ArrayList<Book> books)  {
		for(Book book:books) {
			InsertBook(book);
		}
	}
	public void InsertBook(Book book) {
		System.out.println("Writimg records into the table...");
		try {
			stmt = conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String path = book.getPath();
		String author = book.getAuthor();
		String title = book.getTitle();
		String date = book.getDate();
		String file = book.getFilename();
/*
	String sql = "INSERT  INTO guttenberg ( Author, Title, Text, Date, Path, File) VALUES ( `" + author +"`,`" +title +"`," + "LOAD_FILE(`" + path +"`),`" + date+"`,`" + path +"`,`"+file.getName()+ "` )";
//		String sql = "INSERT INTO guttenberg ( Title) VALUES ( 'Unknown')";
	//	String sql = "INSERT INTO `guttenberg` ( `Text`) VALUES (  LOAD_FILE( '" + Path +  "'))";
	//	String sql = "INSERT INTO `guttenberg` (  `Path`, `File`) VALUES ( " + "Test," + "twat" + ")";

		try {
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
	}
}