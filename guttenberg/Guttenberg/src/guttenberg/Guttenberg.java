package guttenberg;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang3.tuple.Triple;

public class Guttenberg {

	public static void main(String[] args) throws Exception {
/*
"F:/sync"
"10.90.90.150"
"root"
"rs232x25"
"10.90.90.150:
"cloudera"
"cloudera"
"10.90.90.150"
"neo4j"
"Rs232x25"

 */
		String GuttenbergBase = args[0];
		String mysqlhost = args[1];
		String mysqlusername = args[2];
		String mysqlpassword = args[3];
		String datastaxhost = args[4];
		String datastaxusername = args[5];
		String datastaxpassword = args[6];
		String neo4jhost = args[7];
		String neo4jusername = args[8];
		String neo4jpassword = args[9];

		GuttenbergHibernateStorage MySQLstorage = new GuttenbergHibernateStorage();
		GuttenbergNeo4JStorage Neo4jstorage = new GuttenbergNeo4JStorage("bolt://" + neo4jhost + ":7687/",
				neo4jusername, neo4jpassword);
		GuttenbergDataStaxStorage DataStaxstorage = new GuttenbergDataStaxStorage(datastaxhost, datastaxusername,
				datastaxpassword);

		GuttenbergHelper helper = new GuttenbergHelper(GuttenbergBase);

		GuttenbergIndex indexer = new GuttenbergIndex();
		FindGuttenbergInfo filefinder = new FindGuttenbergInfo();

		File base = new File(GuttenbergBase);

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

		int count = helper.searchForFilesExt(base, Only, ".txt", 30);

		String result = null;

	}
}
