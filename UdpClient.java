import java.io.IOException; 
import java.net.DatagramPacket; 
import java.net.DatagramSocket; 
import java.net.InetAddress; 
import java.net.SocketException;
import java.util.Scanner; 
public class UdpClient 
{ 
    public static void main(String args[]) throws IOException 
    { 
        Scanner sc = new Scanner(System.in);
	DatagramSocket ds = new DatagramSocket(); 
        DatagramSocket dss = new DatagramSocket(1111);
	InetAddress ip = InetAddress.getLocalHost(); 
        byte buf[] = null; 
        byte[] receive = new byte[65535];
        DatagramPacket DpReceive = null;
        while (true) 
        { 
            String inp = sc.nextLine(); 
  	    buf = inp.getBytes(); 
            DatagramPacket DpSend = new DatagramPacket(buf, buf.length, ip, 1234); 
            ds.send(DpSend); 
            if (inp.equals("bye")) 
                break; 
            DpReceive = new DatagramPacket(receive, receive.length); 
            dss.receive(DpReceive); 
            System.out.println("Server:-" + data(receive)); 
            if (data(receive).toString().equals("bye")) 
            { 
                System.out.println("Client sent bye.....EXITING"); 
                break; 
            } 
  
            
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