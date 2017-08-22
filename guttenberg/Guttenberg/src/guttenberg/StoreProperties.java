package guttenberg;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

public class StoreProperties {
  public static void main(String[] args) {

	Properties prop = new Properties();
	OutputStream output = null;

	try {

		output = new FileOutputStream(args[0]);

		// set the properties value
		prop.setProperty("root", "C:\\\\rsync");
		prop.setProperty("dbuser", "root");
		prop.setProperty("dbpassword", "rs232x25");
		prop.setProperty("datastaxhost","192.168.0.173");
		prop.setProperty("datastaxusername", "cloudera");
		prop.setProperty("datastaxpassword","cloudera");
		prop.setProperty("Neo4JDB_URL","localhost");
		
		// save properties to project root folder
		prop.store(output, null);

	} catch (IOException io) {
		io.printStackTrace();
	} finally {
		if (output != null) {
			try {
				output.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
  }
}
