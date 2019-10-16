import java.net.*; 
import java.io.*; 
public class ClientTcp 
{ 
    private Socket socket            = null; 
    private DataInputStream  input   = null; 
    private DataOutputStream out     = null;
    private DataInputStream  inp   = null; 
    public ClientTcp(String address, int port) 
    { 
        try
        { 
            socket = new Socket(address, port); 
            System.out.println("Connected"); 
            input  = new DataInputStream(System.in); 
            inp  = new DataInputStream(socket.getInputStream()); 
            out    = new DataOutputStream(socket.getOutputStream()); 
        } 
        catch(UnknownHostException u) 
        { 
            System.out.println(u); 
        } 
        catch(IOException i) 
        { 
            System.out.println(i); 
        } 
        String line = ""; 
        String li="";
        while (!line.equals("Over")) 
        { 
            try
            { 
                line = input.readLine(); 
                out.writeUTF(line);
                li=inp.readUTF();
                System.out.println("Server: "+li);
            } 
            catch(IOException i) 
            { 
                System.out.println(i); 
            } 
        } 
        try
        { 
            input.close(); 
            out.close(); 
            socket.close(); 
        } 
        catch(IOException i) 
        { 
            System.out.println(i); 
        } 
    } 
  
    public static void main(String args[]) 
    { 
        ClientTcp client = new ClientTcp("127.0.0.1", 5000); 
    } 
} 