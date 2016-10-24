package guttenberg;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class GuttenbergBook extends Book {
	List<String> removetext = new ArrayList<String>();
	GuttenbergHelper helper = new GuttenbergHelper();

	public GuttenbergBook(String RemoveDir ) throws IOException {

		String[] paths = new File(RemoveDir).list();
		if (paths != null) {
			for (String path : paths) {
				removetext.add(new String(Files.readAllBytes(Paths.get(RemoveDir+path))));
			}
		
		}

	}

	Book CreateGuttenbergBook(File current) throws IOException {
		// TODO Auto-generated constructor stub
		Book book = new Book();
		book.setPath(current.getPath());

		book.setText(new String(Files.readAllBytes(current.toPath())));
		book.setName(current.getName());


		return book;

	}

	Book RemoveText(Book book) {
		for (String remove : removetext) {
			book.text = book.text.replace(remove, "");
		}
		return book;

	}
}
