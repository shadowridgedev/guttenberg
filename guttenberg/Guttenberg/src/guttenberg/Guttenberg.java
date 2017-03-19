package guttenberg;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

public class Guttenberg {

	public static void main(String[] args) throws Exception {

	    GetProperties prop= new GetProperties();
	    
	    
	

        
//		GuttenbergHibernateStorage MySQLstorage = new GuttenbergHibernateStorage(prop.getPropValues("config.properties"));
//		GuttenbergNeo4JStorage Neo4jstorage = new GuttenbergNeo4JStorage(prop.getPropValues("config.properties"));
//		GuttenbergNeo4JStorage Neo4jstorage = new GuttenbergNeo4JStorage("bolt://" + neo4jhost + ":7687/", neo4jusername, neo4jpassword);
//		GuttenbergDataStaxStorage DataStaxstorage = new GuttenbergDataStaxStorage(prop);

//	GuttenbergHelper helper = new GuttenbergHelper(prop);

		GuttenbergIndex indexer = new GuttenbergIndex();


//		File base = new File(GuttenbergBase);

		ArrayList<File> Only = new ArrayList<File>();
		/*
		 * 
		 * List<String> OnlyName = indexer.GetGuttbergIndex(GuttenbergPath);
		 * List<Book> thebooks = filefinder.getinfo(OnlyName);
		 * MySQLstorage.emptyTable(); MySQLstorage.SaveBooks(thebooks);
		 * List<Book> SavedBooks = MySQLstorage.returnBooks();
		 * 
		 * 
		 * 
		 * List<Book> BookList = MySQLstorage.returnBook("idBook", "1"); for
		 * (Book result : BookList) { System.out.println(result.toString()); }
		 * // storage.DeleteBooks(SavedBooks);
		 * 
		 * 
		 * MySQLstorage.close();
		 */

//		int count = helper.searchForFilesExt(base, Only, ".txt", 30);

		String result = null;

	}


}
