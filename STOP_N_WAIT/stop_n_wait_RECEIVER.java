import java.io.*;
import java.net.*;
import java.util.*;
public class stop_n_wait_RECEIVER {
    public static void main(String args[])
    {
        String h="172.19.151.223";
        int i,q=5000;
        try
        {
            ServerSocket ss2;
            ss2=new ServerSocket(5000);
            Socket s1=ss2.accept();
            DataInputStream dd1=new DataInputStream(s1.getInputStream());
            Integer i1=dd1.read();
            for(i=0;i<i1;i++)
            {
                ServerSocket ss1;
                ss1 = new ServerSocket(1000+i);
                Socket s=ss1.accept();
                DataInputStream dd=new DataInputStream(s.getInputStream());
                String sss1 = dd.readUTF();
                System.out.println(sss1);
                System.out.println("Frame " +i+ " received");
                DataOutputStream d1=new DataOutputStream(s.getOutputStream());
                d1.write(i);
                System.out.println("ACK sent for " +i);
            }
        }
        catch(Exception ex)
        {
            System.out.println("Error" +ex);
        }
    }
}
