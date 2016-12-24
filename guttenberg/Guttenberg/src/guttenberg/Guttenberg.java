package guttenberg;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

public class Guttenberg {

	public static void main(String[] args) throws Exception {

   
		
		String path = args[0];
		String GuttenbergBase = args[1];
		String MySqlusername = args[2];
		String MySqlpassword = args[3];
		String MySQLurl = args[4];

	
		HashMap<String, String> metadata = new HashMap<String, String>();

		GuttenbergMYSQLStorage MySqlstorage = new GuttenbergMYSQLStorage(MySQLurl,MySqlusername, MySqlpassword);
		GuttenbergNeo4JStorage	 Neo4JStorage = new  GuttenbergNeo4JStorage("bolt://localhost:7687", "neo4j", "rs232x25");
		
		GuttenbergHelper helper = new GuttenbergHelper(GuttenbergBase);

		File root = new File(path);
		ArrayList<File> Only = new ArrayList<File>();
		
}
}

/*
 * public void displayDirectoryContents(File dir,DefaultMutableTreeNode root2)
 * throws InterruptedException { DefaultMutableTreeNode newdir = new
 * DefaultMutableTreeNode();
 * 
 * File[] files = dir.listFiles(); //creates array of file type for all the
 * files found
 * 
 * for (File file : files) { if(file == null) {
 * System.out.println("NUll directory found "); continue; }
 * 
 * if (file.isDirectory()) { //file is a directory that is a folder has been
 * dound
 * 
 * if (file.listFiles()==null) { //skips null files continue; }
 * 
 * //gets the current model of the jtree // DefaultTreeModel model =
 * result.getModel();
 * 
 * //gets the root DefaultMutableTreeNode root=(DefaultMutableTreeNode)
 * model.getRoot();
 * 
 * //generates a node newdir using filename newdir = new
 * DefaultMutableTreeNode(file.getName());
 * 
 * //adds a node to the root of the jtree root2.add(newdir);
 * 
 * //refresh the model to show the changes model.reload();
 * 
 * //recursively calls the function again to explore the contents folder
 * displayDirectoryContents(file,newdir); } else { // Else part File is not a
 * directory
 * 
 * 
 * 
 * //gets the current model of the tree DefaultTreeModel model
 * =(DefaultTreeModel) result.getModel();
 * 
 * //selected node is the position where the new node will be inserted
 * DefaultMutableTreeNode selectednode = root2;
 * 
 * DefaultMutableTreeNode newfile =new DefaultMutableTreeNode(file.getName());
 * 
 * 
 * //inserts a node newfile under selected node which is the root
 * model.insertNodeInto(newfile, selectednode, selectednode.getChildCount());
 * 
 * //refresh the model to show the changes model.reload();
 * 
 * 
 * 
 * 
 * }
 * 
 * } }
 * 
 * 
 * public void scanner() throws InterruptedException { // creates a file with
 * the location filename String location
 * ="C:\\Users\\Ashish Padalkar\\Documents"; File currentDir = new
 * File(location);
 * 
 * //result is the variable name for jtree DefaultTreeModel model
 * =(DefaultTreeModel) result.getModel(); //gets the root of the current model
 * used only once at the starting DefaultMutableTreeNode
 * root=(DefaultMutableTreeNode) model.getRoot(); //function caled
 * displayDirectoryContents(currentDir,root); } }
 * 
 */
