package guttenberg;


import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.List;

public class Old {
	
	
	public static void searchForFilesExt(File root, ArrayList<File> only, String ext) {
		// TODO Auto-generated method stub
		int count = 0;
	    if(root == null || only == null) return; //just for safety   
	    if(root.isDirectory()) {
	    	System.out.println(root.toString());
	        for(File file : root.listFiles()) {
	        	if(file != null) {
	        		   searchForFilesExt(file, only, ext);
	        	}
	        }
	    } else if(root.isFile() && root.getName().endsWith(ext)) {
	    	
			count++;
	    	System.out.print(count);
	    	System.out.println("    " + root.getName());
	        only.add(root);
	    }	
	}
	
	
	
public	List<File> searchForFile(File rootDirectory, FileFilter filter){
	    List<File> results = new ArrayList<File>();
	    for(File currentItem : rootDirectory.listFiles(filter)){
	      if(currentItem.isDirectory()){
	          results.addAll(searchForFile(currentItem, filter));
	      }
	      else{
	          results.add(currentItem);
	      }
	    }
	    return results;
	}
	
}
