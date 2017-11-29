package guttenberg;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class Guttenberg {

	public static void main(String[] args) throws Exception {

		GetProperties localprop = new GetProperties(args[0]);
		Properties prop = localprop.getProp();
		String base = prop.getProperty("root");
		// GuttenbergHibernateStorage MySQLstorage = new
		// GuttenbergHibernateStorage();
		// GuttenbergNeo4JStorage Neo4jstorage = new
		// GuttenbergNeo4JStorage(prop);
		// GuttenbergNeo4JStorage Neo4jstorage = new
		// GuttenbergNeo4JStorage("bolt://" + neo4jhost + ":7687/",
		// neo4jusername, neo4jpassword);
		// GuttenbergDataStaxStorage DataStaxstorage = new
		// GuttenbergDataStaxStorage(prop);
		GuttenbergHelper helper = new GuttenbergHelper(base);

		GuttenbergIndex indexer = new GuttenbergIndex();

		ArrayList<File> Only = new ArrayList<File>();
		List<String> OnlyName = indexer.GetGuttbergIndex(base);
		List<String> Onlyfiles = indexer.getFiles(base);

		// List<Book> thebooks = filefinder.getinfo(OnlyName);
		// MySQLstorage.emptyTable(); MySQLstorage.SaveBooks(thebooks);
		// List<Book> SavedBooks = MySQLstorage.returnBooks();
		/*
		 * List<Book> BookList = MySQLstorage.returnBook("idBook", "1"); for (Book
		 * result : BookList) { System.out.println(result.toString()); }
		 * storage.DeleteBooks(SavedBooks); MySQLstorage.close();
		 * 
		 */

		// int count = helper.searchForFilesExt(base, Only, ".txt", 30);

		String result = null;

	}

}
