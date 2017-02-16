package guttenberg;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class LocalSystem {
	
	
	InetAddress lookuphost(String hostname) {

		InetAddress inet;
		try {
			inet = InetAddress.getByName(hostname);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			return null;
		}
		return inet;
	}
	// System.out.println("Sending Ping Request to " + ipAddress);
	// System.out.println(inet.isReachable(5000) ? "Host is reachable" : "Host
	// is NOT reachable");

	boolean ping(InetAddress address) {
		// System.out.println("Sending Ping Request to " + ipAddress);
		try {
			return address.isReachable(500);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			return false;
		}
	}
}
