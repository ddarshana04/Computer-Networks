import java.net.*;  
public class sender{  
  public static void main(String[] args) throws Exception {  
    DatagramSocket ds = new DatagramSocket();  
    String str = "WELCOME TO COMPUTER NETWORKS LAB";  
    InetAddress ip = InetAddress.getByName("172.19.151.224");  
     
    DatagramPacket dp = new DatagramPacket(str.getBytes(), str.length(), ip, 3000);  
    ds.send(dp);  
    ds.close();  
  }  
}  