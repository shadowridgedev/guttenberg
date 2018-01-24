package guttenberg;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class StoreProperties {

	StoreProperties() {

	}

	public Properties resetproperties(String propfile) {

		Properties prop = new Properties();

		try {
			FileOutputStream gut = new FileOutputStream(propfile);
			// set the properties value
			prop.setProperty("root", "Z:\\gut");
			prop.setProperty("dbuser", "root");
			prop.setProperty("dbpassword", "rs232x25");
			prop.setProperty("datastaxhost", "asrock");
			prop.setProperty("datastaxusername", "cloudera");
			prop.setProperty("datastaxpassword", "cloudera");
			prop.setProperty("fusionhost", "410-1");
			prop.setProperty("fusionusername", "cloudera");
			prop.setProperty("fusionpassword", "cloudera");
			prop.setProperty("Neo4JDB_URL", "localhost");

			// save properties to project root folder
			prop.store(gut, "Guttenberg generated properties file");
			gut.close();
		} catch (IOException io) {
			io.printStackTrace();
		}

		return prop;
	}

}