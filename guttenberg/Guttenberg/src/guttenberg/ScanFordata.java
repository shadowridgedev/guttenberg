package guttenberg;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

public class ScanFordata {


	public ArrayList<File> scan ( File root,  String path, ArrayList<File> Only,  GuttenbergHelper helper,String filetype, int depth)  {
	// count = helper.searchForFilesExt(root, Only, filetype, depth);
	GuttenbergIndex index = new GuttenbergIndex(path);
    return Only;
	}
}
    
  /*
	String result = null;
	int i = 0;
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
				// storage.InsertBook(book);

			} else {
				Path local = Paths.get(NotGuttenbergPath + current.getName());
				Files.copy(current.toPath(), local, REPLACE_EXISTING);

				result += " is not Guttenberg1";
			}
			System.out.println(result);

		}
		int problem = count - (helper.GuttenbergFiles + helper.NotGuttenbergFiles);
		if (problem != 0)
			System.out.println("Problem " + problem);
		System.out.println("Final count Guttenberg1 Files" + helper.GuttenbergFiles + " Not Guttenberg1 Files "
				+ helper.NotGuttenbergFiles);
	}


}


*/
