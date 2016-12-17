package guttenberg;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.stream.Stream;

public class GuttenbergIndex {
	GuttenbergIndex(String path) {
	}

	public ArrayList<String> GetGuttbergIndex(String path, ArrayList<String> Only) {	
		// read file into stream, try-with-resources

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
