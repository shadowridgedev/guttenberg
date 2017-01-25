package guttenberg;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FindGuttenbergInfo {

	public FindGuttenbergInfo() {

		// TODO Auto-generated constructor stub
	}

	ArrayList<Book> getinfo(ArrayList<String> files) throws IOException {
		ArrayList<Book> books = new ArrayList<Book>();

		for (String filename : files) {
			getindexfileinfo(filename, books);
		}
		return books;

	}

	private ArrayList<Book> getindexfileinfo(String filename, ArrayList<Book> books) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new FileReader(filename));
		String line = null;

		while ((line = br.readLine()) != null) {
			int len = line.length();
			String index;
			if (line.substring(len-4, len).matches("^\\d.*?\\d$")) {
				index = line.substring(len-10, len).trim();
				System.out.println("Book   " + index + " line   " +line);
			}
//			Book current = new Book();
//			books.add(current);

		
		}
		br.close();
		return books;

	}

}

