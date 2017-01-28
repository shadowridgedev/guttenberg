package guttenberg;
import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Host;
import com.datastax.driver.core.Metadata;
import com.datastax.driver.core.Session;
import static java.lang.System.out;

public class GuttenbergDataStaxStorage {
private CassandraConnector connector;
GuttenbergDataStaxStorage(String node, int port) {
	
	connector = new CassandraConnector();
	
	connector.connect(node, port);
	
}
}



