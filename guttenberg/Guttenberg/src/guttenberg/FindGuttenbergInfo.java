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
		String index = null;
		while ((line = br.readLine()) != null) {
			if (line.contains("by")) {
			int len = line.length();
			int numsize =  lastDigit(TrimLastChar(line));
			if (numsize > 0 ) {
				index = line.substring(len - (numsize+1), len).trim();
				System.out.println("Book stored " + index + " line " + line);
					Book current = new Book();
					parsebook(line, current);
					current.EtextNumber = index;
					books.add(current);
				} else System.out.println("Book not stored  " + index + " line   " + line);

			}
			
			
		
		}
		br.close();
		return books;
	}

	private void parsebook(String line, Book current) {
		// TODO Auto-generated method stub

	}

	String TrimLastChar(String s ) {
		char c = s.charAt(s.length()-1);
	    if( s.charAt(s.length()-1) == 'C') {
	    	return s.substring(0, s.length()-1);
	    }
		return s;
		
	}
	public int lastDigit(String s) {
		int count = 0;

		if (s != null && !s.isEmpty()) {
			String d = new StringBuilder(s).reverse().toString();
			for (char c : d.toCharArray()) {
				if (Character.isDigit(c)) {
					count++;
				} else
					break;
			}
		}

		return count;
	}

}
