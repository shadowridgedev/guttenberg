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
		
		/*
		 * for (File current : Only) { System.out.println("File  " +
		 * current.getName()); }
		 */
		String result = null;

	}
}

/*		
		while (i++ != 100) {

			for (File current : Only) {
				result = ("File " + current.getName() + " ");
				if (helper.isGuttenberg(current)) {
					result += (" is Guttenbberg");
					Path local = Paths.get(GuttenbergPath + current.getName());
					Files.copy(current.toPath(), local, REPLACE_EXISTING);
					Book book = new Book();
					book.setPath(local.toString());
					book.setText(new String(Files.readAllBytes(local)));
					book.setName(current.getName());
					metadata = helper.GetBookMetadata(book.text);

					// add own metadata
					metadata.put("extra", "Things");

					System.out.println(Arrays.asList(metadata)); // method 1
					book = helper.addMetadata(book, metadata);

					book = helper.RemoveText(book);
					book.setPath(CleanBook + book.getName());
					Files.write(Paths.get(book.getPath()), book.getText().getBytes());

					result += current.getPath() + "    " + current.getName();
					storage.InsertBook(book);

				} else {
					Path local = Paths.get(NotGuttenbergPath + current.getName());
					Files.copy(current.toPath(), local, REPLACE_EXISTING);
					result += " is not Guttenberg";
				}
				System.out.println(result);

			}
			int problem = count - (helper.GuttenbergFiles + helper.NotGuttenbergFiles);
			if (problem != 0)
				System.out.println("Problem " + problem);
			System.out.println("Final count Guttenberg Files" + helper.GuttenbergFiles + " Not Guttenberg Files "
					+ helper.NotGuttenbergFiles);
		}
	}
}
*/
		