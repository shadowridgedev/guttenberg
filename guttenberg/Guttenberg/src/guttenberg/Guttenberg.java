package guttenberg;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Guttenberg {

	@SuppressWarnings("unchecked")
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

		int count;
		HashMap<String, String> metadata = new HashMap<String, String>();

		GuttenbergMYSQLStorage storage = new GuttenbergMYSQLStorage(url, username, password);
		GuttenbergHelper helper = new GuttenbergHelper(GuttenbergBase);
		GuttenbergIndex indexer = new GuttenbergIndex();
		FindGuttenbergInfo filefinder = new FindGuttenbergInfo();

		
		
		File root = new File(GuttenbergPath);
		ArrayList<String> OnlyName;
	//	ArrayList<File> Only = new ArrayList<File>();
	//	count = helper.searchForFilesExt(root, Only, ".txt", 30);
		
        OnlyName = indexer.GetGuttbergIndex(GuttenbergPath);
		ArrayList<Book> thebooks = filefinder.getinfo(OnlyName);
		for(Book book:thebooks) {
			storage.InsertBook(book);
		}
		/*
		 * for (File current : Only) { System.out.println("File  " +
		 * current.getName()); }
		 */
		String result = null;

	}
}


		