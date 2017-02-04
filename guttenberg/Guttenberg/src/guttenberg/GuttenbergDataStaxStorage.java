package guttenberg;
import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Host;
import com.datastax.driver.core.Metadata;
import com.datastax.driver.core.Session;
import static java.lang.System.out;

public class GuttenbergDataStaxStorage {
private CassandraConnector connector;

public GuttenbergDataStaxStorage(String datastaxhost, String datastaxusername, String datastaxpassword) {
	// TODO Auto-generated constructor stub
	connector = new CassandraConnector();
	
//	connector.connect(node, port);
	
}
}



