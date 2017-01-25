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

		BufferedReader br = new BufferedReader(new FileReader(filename));
		String line = null;

		while ((line = br.readLine()) != null) {
			int len = line.length();
			String index = null;
			index = line.substring(len - lastDigit(index), len).trim();
			if (index.matches("^\\d.*?\\d$") && line.contains("by")) {
				// System.out.println("Book stored " + index + " line " + line);
				Book current = new Book();
				parsebook(line, current);
				current.index = index;
				books.add(current);
			} else System.out.println("Book not stored  " + index + " line   " + line);

		}
		br.close();
		return books;
	}

	private void parsebook(String line, Book current) {
		// TODO Auto-generated method stub

	}

	public int lastDigit(String s) {
		int count = 0;

		if (s != null && !s.isEmpty()) {
			new StringBuilder(s).reverse().toString();
			for (char c : s.toCharArray()) {
				if (Character.isDigit(c)) {
					count++;
				} else
					break;
			}
		}

		return count;
	}

}
