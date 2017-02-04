package guttenberg;
import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Host;
import com.datastax.driver.core.Metadata;
import com.datastax.driver.core.Session;
import static java.lang.System.out;

public class GuttenbergDataStaxStorage {
private CassandraConnector connector;
String host;
String username;
String password;

public GuttenbergDataStaxStorage(String datastaxhost, String datastaxusername, String datastaxpassword) {
	// TODO Auto-generated constructor stub
	host = datastaxhost;
	username = datastaxusername;
	password = datastaxpassword;
	connector = new CassandraConnector();
	
//	connector.connect(node, port);
	
}
}



