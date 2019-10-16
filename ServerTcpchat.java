import java.util.*;
import java.io.*;
import java.lang.*;
import java.net.*;

public class ServerTcpchat{
    public static void main(String[] args) throws Exception
    {  
        ServerSocket s = new ServerSocket(156);
        System.out.println("Server started"); 
        System.out.println("Waiting for a client ...");
        Socket obj = s.accept();  
        System.out.println("Client accepted");  
        DataInputStream inn = new DataInputStream(obj.getInputStream());
        DataInputStream inj = new DataInputStream(System.in);
        DataOutputStream out = new DataOutputStream(obj.getOutputStream());
        String line = ""; 
        String lin = ""; 
  	while (!line.equals("Over")) 
            { 
		line = inn.readUTF(); 
                System.out.println("Client: "+line);
                lin =inj.readLine();
                out.writeUTF(lin);
           } 
        System.out.println("Closing connection"); 
        obj.close(); 
       }
        
}



