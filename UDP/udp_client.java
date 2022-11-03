import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class udp_client {
	public static void main(String[] args) throws Exception
{
		DatagramSocket ds = new DatagramSocket();

		int radius = 4;
		byte[] b = String.valueOf(radius).getBytes();

		InetAddress ia = InetAddress.getLocalHost();
		DatagramPacket dp = new DatagramPacket(b,b.length,ia,9999);
		ds.send(dp);

		byte[] b1 = new byte[1024];
		DatagramPacket dp1 = new DatagramPacket(b1,b1.length);
		ds.receive(dp1);

		String str = new String(dp1.getData(),0,dp1.getLength());
		System.out.println("Area Of The Circle:" + str);
	}
}