import java.net.*;
import java.io.File;  // Import the File class
import java.io.IOException;  // Import the IOException class to handle errors
import java.io.FileWriter;   // Import the FileWriter class

public class singlescan {
	 public static void scan(int scport) {
      String nomefile = "nkscan-port"+ scport + ".txt" ;
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
            int[] ports = {scport};
            for (int port : ports) {
	         try {
                System.out.println("Scanning on port: " + port);
	            Socket socket = new Socket();
                String target = "175.45."+ip2+"."+ip;
	            socket.connect(new InetSocketAddress(target, port), 1000);
	            socket.close();
                System.out.println("Service found on " + target);
   try {
      FileWriter myWriter = new FileWriter(nomefile,true);
      if (port == 25) {
      myWriter.write("SMTP found on " + target + ":" + port + "\n");
      }
      else if (port == 21) {
      myWriter.write("FTP found on " + target + ":" + port + "\n");
      }
      else if (port == 80 || port == 8080) {
      myWriter.write("Webserver found on " + target + ":" + port + "\n");
      }
      else if (port == 5900 || port == 5901) {
      myWriter.write("VNC found on " + target + ":" + port + "\n");
      }
      else {
      myWriter.write("Service found on " + target + ":" + port + "\n");
      }
      myWriter.close();
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
	            //System.out.println("Port " + port + " is open on " + target);
	        } catch (Exception ex) {
	        }
	      }
	   }
    }
  }
}
