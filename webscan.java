import java.net.*;
import java.io.File;  // Import the File class
import java.io.IOException;  // Import the IOException class to handle errors
import java.io.FileWriter;   // Import the FileWriter class

public class webscan {
	 public static void scan() {
    String nomefile = "nkscan-web-scan.txt";
 try {
      File myObj = new File(nomefile);
      if (myObj.createNewFile()) {
        System.out.println("File created: " + myObj.getName());
      } else {
        System.out.println("File already exists.");
      }
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
    for (int ip2 = 176; ip2 <= 179; ip2++) {

	      for (int ip  = 1; ip <= 254; ip++) {
            System.out.println("Scanning DPRK host 175.45."+ip2+"." + ip);
            int[] ports = {80, 443, 8080};
            for (int port : ports) {
	         try {
                System.out.println("Scanning on port: " + port);
	            Socket socket = new Socket();
                String target = "175.45."+ip2+"."+ip;
	            socket.connect(new InetSocketAddress(target, port), 1000);
	            socket.close();
                if (port == 80 || port == 8080) {
                System.out.println("Webserver found on " + target);
   try {
      FileWriter myWriter = new FileWriter(nomefile,true);
      if (port == 80 || port == 8080) {
      myWriter.write("[HTTP] Webserver found on " + target + ":" + port + "\n");
      }
      else {
        myWriter.write("[HTTPS] Webserver found on " + target + ":" + port + "\n");
      }
      myWriter.close();
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
                }
	            //System.out.println("Port " + port + " is open on " + target);
	        } catch (Exception ex) {
	        }
	      }
	   }
    }
  }
}
