package guttenberg;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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

		HashMap<String, String> metadata = new HashMap<String, String>();

		GuttenbergHibernateStorage storage = new GuttenbergHibernateStorage();

		GuttenbergHelper helper = new GuttenbergHelper(GuttenbergBase);

		GuttenbergIndex indexer = new GuttenbergIndex();
		FindGuttenbergInfo filefinder = new FindGuttenbergInfo();

	
		
		// ArrayList<File> Only = new ArrayList<File>();
		// count = helper.searchForFilesExt(root, Only, ".txt", 30);

		List<String> OnlyName = indexer.GetGuttbergIndex(GuttenbergPath);
		List<Book> thebooks = filefinder.getinfo(OnlyName);
		storage.emptyTable();
		storage.SaveBooks(thebooks);
		List<Book> SavedBooks = storage.returnBooks();



		List<Book> BookList = storage.returnBook("idBook", "1");
		for (Book result : BookList) {
			System.out.println(result.toString());
		}
//		storage.DeleteBooks(SavedBooks);
		
		storage.close();
		String result = null;

	}
}
