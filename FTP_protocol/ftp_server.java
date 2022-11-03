import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ftp_server {

  public static void main(String[] args) {
    try {
      ServerSocket ss = new ServerSocket(6666);
      Socket s = ss.accept(); //establishes connection
      DataInputStream dis = new DataInputStream(s.getInputStream());
      
      System.out.println("Reading the data.....");
      String str = (String) dis.readUTF();
      String p = "C:\\Users\\CH.EN.U4CSE20020\\Documents\\computer networks\\" ;
      String path = p.concat(str);
      
      File tempFile = new File(path);
      boolean exists = tempFile.exists();

      if(exists){
        Scanner sc = new Scanner(tempFile);
 
        // we just need to use \\Z as delimiter
        sc.useDelimiter("\\Z");
 
        System.out.println(sc.next());
      }
      else{
        System.out.println("File Dose Not Exists!!");
      }
      ss.close();
    } catch (Exception e) {
      System.out.println(e);
    }
  }
}