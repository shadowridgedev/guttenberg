package guttenberg;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class GuttenbergBook {


	public GuttenbergBook( ) throws IOException {


	}
	

	Book CreateGuttenbergBook(File current) throws IOException {
		// TODO Auto-generated constructor stub
		Book book = new Book();
		book.setPath(current.getPath());
		book.setText(new String(Files.readAllBytes(current.toPath())));
		book.setName(current.getName());
		return book;

	}

}
