package guttenberg;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang3.tuple.Triple;

public class Guttenberg {

	public static void main(String[] args) throws Exception {

		String path = args[0];
		String GuttenbergBase = args[1];
		String url = "jdbc:mysql://localhost:3306/books?autoReconnect=true&useSSL=false";
		String username = "root";
		String password = "rs232x25";
		String GuttenbergPath = GuttenbergBase + "\\Guttenberg\\";
		String NotGuttenbergPath = GuttenbergBase + "\\NotGuttenberg\\";
		String CleanBook = GuttenbergBase + "\\CleanBook\\";
		String RemoveText = GuttenbergBase + "\\RemoveText\\";


		
		GuttenbergHibernateStorage MySQLstorage = new GuttenbergHibernateStorage();
   //     GuttenbergNeo4JStorage Neo4jstorage = new  GuttenbergNeo4JStorage("bolt://localhost:7687/","Neo4j","rs232x25");
   //     GuttenbergDataStaxStorage DataStaxstorage = new GuttenbergDataStaxStorage("esxi51",  9042);

        
		GuttenbergHelper helper = new GuttenbergHelper(GuttenbergBase);

		GuttenbergIndex indexer = new GuttenbergIndex();
		FindGuttenbergInfo filefinder = new FindGuttenbergInfo();

	   File base = new File(GuttenbergPath);
		
		 ArrayList<File> Only = new ArrayList<File>();
/*	

		List<String> OnlyName = indexer.GetGuttbergIndex(GuttenbergPath);
		List<Book> thebooks = filefinder.getinfo(OnlyName);
		MySQLstorage.emptyTable();
		MySQLstorage.SaveBooks(thebooks);
		List<Book> SavedBooks = MySQLstorage.returnBooks();



		List<Book> BookList = MySQLstorage.returnBook("idBook", "1");
		for (Book result : BookList) {
			System.out.println(result.toString());
		}
//		storage.DeleteBooks(SavedBooks);

		
		MySQLstorage.close();
*/		
		
		
		int  count = helper.searchForFilesExt( base, Only, ".txt", 30);
		
		
		
		String result = null;

	}
}
