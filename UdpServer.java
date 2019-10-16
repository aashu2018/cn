import java.io.IOException; 
import java.net.DatagramPacket; 
import java.net.DatagramSocket; 
import java.net.InetAddress; 
import java.net.SocketException; 
import java.util.Scanner;
public class UdpServer 
{ 
    public static void main(String[] args) throws IOException 
    { 
        Scanner sc = new Scanner(System.in); 
        DatagramSocket dss = new DatagramSocket(); 
  	InetAddress ip = InetAddress.getLocalHost(); 
        byte buf[] = null;
        DatagramSocket ds = new DatagramSocket(1234); 
        byte[] receive = new byte[65535]; 
  	DatagramPacket DpReceive = null; 
        while (true) 
        { 
  		DpReceive = new DatagramPacket(receive, receive.length); 
  		ds.receive(DpReceive); 
  		System.out.println("Client:-" + data(receive)); 
  		if (data(receive).toString().equals("bye")) 
            	{ 
                	System.out.println("Client sent bye.....EXITING"); 
                	break; 
                } 
  	receive = new byte[65535]; 
        String inp = sc.nextLine(); 
  	buf = inp.getBytes(); 
  	DatagramPacket DpSend = new DatagramPacket(buf, buf.length, ip, 1111); 
  	dss.send(DpSend); 
  	if (inp.equals("bye")) 
                break; 
} 
} 
  
    
    public static StringBuilder data(byte[] a) 
    { 
        if (a == null) 
            return null; 
        StringBuilder ret = new StringBuilder(); 
        int i = 0; 
        while (a[i] != 0) 
        { 
            ret.append((char) a[i]); 
            i++; 
        } 
        return ret; 
    } 
} 