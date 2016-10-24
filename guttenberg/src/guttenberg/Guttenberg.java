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
		String GuttenbergPath = GuttenbergBase+ "\\Guttenberg\\";
		String NotGuttenbergPath = GuttenbergBase +"\\NotGuttenberg\\";
		String RemoveText = GuttenbergBase + "\\RemoveText\\";
		int count;
		HashMap<String, String>  metadata = new HashMap<String, String> ();	
	
		GuttenbergStorage storage = new GuttenbergStorage(url, username, password);
        GuttenbergHelper  helper = new GuttenbergHelper();
        GuttenbergBook Guttenberg = new GuttenbergBook(RemoveText);
        
		File root = new File(path);
		ArrayList<File> Only = new ArrayList<File>();
		count = helper.searchForFilesExt(root, Only, ".txt");
		
		/*
		 * for (File current : Only) { System.out.println("File  " +
		 * current.getName()); }
		 */
		String result = null;
		for (File current : Only) {
			result = ("File " + current.getName());

			if (helper.isGuttenberg(current)) {
				result += (" is Guttenbberg");
				Path local = Paths.get(GuttenbergPath+current.getName());
				Files.copy(current.toPath(),local , REPLACE_EXISTING);
				Book book = Guttenberg.CreateGuttenbergBook(current);
				metadata = helper.GetBookMetadata(book.text);
				System.out.println(current.getPath() + "    " + current.getPath());
				 System.out.println(Arrays.asList(metadata)); // method 1
				
				
				// add own metadata
				book = helper.addMetadata(book, metadata);
						
						
						
				// storage.InsertBook(book);
			} else {
				Path local = Paths.get(NotGuttenbergPath+current.getName());
				Files.copy(current.toPath(),local , REPLACE_EXISTING);
		
				result += " is not Guttenberg";
			}
			System.out.println(result);

		}
		int problem = count -  (helper.GuttenbergFiles +  helper.NotGuttenbergFiles );
		if ( problem != 0)  System.out.println ( "Problem " + problem);
		System.out.println( "Final count Guttenberg Files" + helper.GuttenbergFiles + " Not Guttenberg Files " + helper.NotGuttenbergFiles);
	}

	
}
