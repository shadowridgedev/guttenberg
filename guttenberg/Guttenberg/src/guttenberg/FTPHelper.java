package guttenberg;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

public class FTPHelper {
	 String server;
     int port;
     String user;
     String pass;
     FTPClient ftpClient;
     
	FTPHelper (String theserver, int theport, String theuser, String thepass) {
		 String server = theserver;
	        int port = theport;
	        String user = theuser;
	        String pass = thepass;
	   	    FTPClient ftpClient = new FTPClient();   
	}
	
	boolean connect() {
	
	        try {
	 
	            ftpClient.connect(server, port);
	            ftpClient.login(user, pass);
	            ftpClient.enterLocalPassiveMode();
	            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
	 /*
	            // APPROACH #1: using retrieveFile(String, OutputStream)
	            String remoteFile1 = "/test/video.mp4";
	            File downloadFile1 = new File("D:/Downloads/video.mp4");
	            OutputStream outputStream1 = new BufferedOutputStream(new FileOutputStream(downloadFile1));
	            boolean success = ftpClient.retrieveFile(remoteFile1, outputStream1);
	            outputStream1.close();
	 
	            if (success) {
	                System.out.println("File #1 has been downloaded successfully.");
	            }
	            
	            
	            */
	        } catch (IOException ex) {
	            System.out.println("Error: " + ex.getMessage());
	            ex.printStackTrace();
	            return false;
	        }
		
		return true;
		
	}
	
}
