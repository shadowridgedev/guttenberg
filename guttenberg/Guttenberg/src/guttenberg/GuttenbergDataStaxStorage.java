package guttenberg;
import java.util.Properties;

public class GuttenbergDataStaxStorage {
private CassandraConnector connector;
String host;
String username;
String password;

public GuttenbergDataStaxStorage(Properties prop) {
	// TODO Auto-generated constructor stub
	host = prop.getProperty("datastaxhost");
	username = prop.getProperty("datastaxusername");
	password = prop.getProperty("datastaxpassword");
	connector = new CassandraConnector();
	
	
	connector.connect(prop.getProperty("DatastaxNode"),Integer.parseInt(prop.getProperty("datastaxport"))) ;
	
}
}



