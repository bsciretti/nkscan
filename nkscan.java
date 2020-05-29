import java.util.Scanner;

public class nkscan {
  //funzione gestione
  public static void main(final String[] args) {
      System.out.println("Welcome to NKscan\nThis software scans the entire North Korean Internet");
      System.out.println(
              "Select the scan type:\n1) Range (can take a lot of time!)\n2) Webservices (HTTP and HTTPS)\n3) SMTP\n4) FTP\n5) Custom port");
      final Scanner in = new Scanner(System.in);

      // Acquisisco il valore per la scelta
      final int r = in.nextInt();

      // Effettuo la verifica per l'evento selezionato
      if (r == 1) {
          System.out.println("Select the minimum");
          final Scanner minim = new Scanner(System.in);

          // Acquisisco il valore per la scelta
          final int min = minim.nextInt();
          System.out.println("Select the maximum");
          final Scanner maxim = new Scanner(System.in);

          // Acquisisco il valore per la scelta
          final int max = maxim.nextInt();
          portscan.scan(min, max);
      }

      if (r == 2) {
          System.out.println("Starting a Web scan");
          webscan.scan();
      }

      if (r == 3) {
          System.out.println("Starting a SMTP search");
          singlescan.scan(25);
      }
      if (r == 4) {
          System.out.println("Starting a FTP search");
          singlescan.scan(21);
      }
      if (r == 5) {
          System.out.println("Please choose the port to scan: ");
          final Scanner portascan = new Scanner(System.in);

          // Acquisisco il valore per la scelta
          final int toscan = portascan.nextInt();
    singlescan.scan(toscan);
    }


    // Visualizzo l'errore di immissione di un valore non corretto
    if ( r != 0 && r != 1 && r != 2 && r != 3 && r != 4 && r != 5){
        System.out.println("Error");
    }
  }

}
