package guttenberg;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class GetProperties {
	public Properties getPropValues(String file) throws IOException {
		InputStream inputStream = null;
		Properties prop;
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

		return prop;
	}
}
