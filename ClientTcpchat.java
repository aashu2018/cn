import java.io.*;
import java.util.*;
import java.net.*;
public class ClientTcpchat{
    public static void main(String args[]){
        try{
            Socket sc = new Socket("127.0.0.1",156);
            DataInputStream din = new DataInputStream(sc.getInputStream());
            DataOutputStream dout = new DataOutputStream(sc.getOutputStream());
            System.out.println("Connected");
            DataInputStream inp = new DataInputStream(System.in);
            DataOutputStream outt = new DataOutputStream(sc.getOutputStream());
            DataInputStream ink = new DataInputStream(sc.getInputStream());
            String line = ""; 
            String li = "";
            while (!line.equals("Over")) 
        	{ 
                   line =inp.readLine(); 
                   outt.writeUTF(line);
                   li=ink.readUTF();
                   System.out.println("Server: "+li);  
            } 
          sc.close();  
        }  
        catch(Exception e){
            System.out.println(e);
        }
    }
}