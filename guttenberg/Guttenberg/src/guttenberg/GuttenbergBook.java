package guttenberg;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class GuttenbergBook {


	public GuttenbergBook( ) throws IOException {


	}
	

	Book3 CreateGuttenbergBook(File current) throws IOException {
		// TODO Auto-generated constructor stub
		Book3 book = new Book3();
		book.setPath(current.getPath());
		book.setText(new String(Files.readAllBytes(current.toPath())));
		book.setName(current.getName());
		return book;

	}

}
