package guttenberg;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.stream.Stream;

public class GuttenbergIndex {
	GuttenbergIndex(String path) {
	}

	public GuttenbergIndex() {
		// TODO Auto-generated constructor stub
	}

	public ArrayList<String> GetGuttbergIndex(String path) {	
		// read file into stream, try-with-resources
		ArrayList<String> Only = new ArrayList<String> ();
		File folder = new File(path);
		File[] listOfFiles = folder.listFiles();

		    for (int i = 0; i < listOfFiles.length; i++) {
		      if (listOfFiles[i].isFile()) {
		        System.out.println("File " + listOfFiles[i].getName());
		        if (listOfFiles[i].toString().contains("GUTINDEX")) {
			    	  Only.add(listOfFiles[i].toString());
			          System.out.println("File with G " + listOfFiles[i].getName());
			      }
		      } else if (listOfFiles[i].isDirectory()) {
		        System.out.println("Directory " + listOfFiles[i].getName());
		      }
		
		    }
			return Only;
	}

	
}	
	/*	
		try (Stream<String> stream = Files.lines(Paths.get(path + "\\GUTINDEX.ALL"))) {


			
			Iterator<String> i = Files.lines(Paths.get(path)).iterator();
			for (i = stream.iterator(); i.hasNext();) {

				{
					Only.add(i.next());

				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}	
		return Only;
	}

}
*/
		    