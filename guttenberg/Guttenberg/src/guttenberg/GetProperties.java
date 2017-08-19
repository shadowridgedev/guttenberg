package guttenberg;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class GetProperties {
	public Properties getProp() {
		return prop;
	}
	public void setProp(Properties prop) {
		this.prop = prop;
	}
	Properties prop;
	public  GetProperties(String file) throws IOException {
		InputStream inputStream = null;

		try {
			prop = new Properties();
			String propFileName = file;

			inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

			if (inputStream != null) {
				prop.load(inputStream);
			} else {
				throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
			}
		} finally {
			inputStream.close();
		}


	}
}
