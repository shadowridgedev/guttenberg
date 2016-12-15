package guttenberg;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.stream.Stream;

public class GuttenbergIndex {

	GuttenbergIndex(String path) { 
		ArrayList<String> lines = getfiles(path);
		Iterator<String> i = lines.iterator();
		while (i.hasNext()) 	System.out.println(i.next());
	}
	
	

	ArrayList<String> getfiles(String filepath) {
		ArrayList<String> Only = new ArrayList<String>();
		// read file into stream, try-with-resources

		try (Stream<String> stream = Files.lines(Paths.get(filepath + "\\GUTINDEX.ALL"))) {

			Iterator<String> i;
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
