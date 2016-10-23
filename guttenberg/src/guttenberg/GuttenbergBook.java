package guttenberg;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

public class GuttenbergBook extends Book {
	List<String> removetext;
	GuttenbergHelper helper = new GuttenbergHelper();

	public GuttenbergBook(String RemoveDir) throws IOException {
		String[] paths = new File(RemoveDir).list();
		if (paths != null) {
			for (String path : paths) {
				removetext.add(new String(Files.readAllBytes(Paths.get(path))));
			}
		
		}

	}

	Book CreateGuttenbergBook(File current) throws IOException {
		// TODO Auto-generated constructor stub
		Book book = new Book();
		book.setPath(current.getPath());

		book.text = new String(Files.readAllBytes(current.toPath()));
		book.setFile(current);
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
