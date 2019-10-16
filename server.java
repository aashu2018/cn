import java.net.*; 
import java.io.*; 
import java.util.*;
public class Server 
{ 
    //initialize socket and input stream 
    private Socket          socket   = null; 
    private ServerSocket    server   = null; 
    private DataInputStream in       =  null; 
  
    // constructor with port 
    public Server(int port) 
    {
        
                    List<String> ip = new ArrayList<String>();
                    List<String> mac = new ArrayList<String>();
                    final String alphabet = "0123456789ABCDEF";
                    final int N = alphabet.length();

                    String ip1="";
                    String mac1="";
                    Random r1 = new Random();
                    for(int i=0;i<10;i++){
                            ip1=(r1.nextInt(256)+"."+r1.nextInt(256)+"."+r1.nextInt(256)+"."+r1.nextInt(256));
                            ip.add(ip1);
                            mac1=alphabet.charAt(r1.nextInt(N))+""+alphabet.charAt(r1.nextInt(N))+":"+alphabet.charAt(r1.nextInt(N))+""+alphabet.charAt(r1.nextInt(N))+":"+alphabet.charAt(r1.nextInt(N))
    +""+alphabet.charAt(r1.nextInt(N))+":"+alphabet.charAt(r1.nextInt(N))+""+alphabet.charAt(r1.nextInt(N))+":"+alphabet.charAt(r1.nextInt(N))+""+alphabet.charAt(r1.nextInt(N))+":"
    +alphabet.charAt(r1.nextInt(N))+""+alphabet.charAt(r1.nextInt(N));
                            mac.add(mac1);
                    }
                    for(int j=0;j<10;j++){
                            System.out.println(ip.get(j));
                            System.out.println(mac.get(j)+"\n");
                    }
                    
               
        // starts server and waits for a connection 
        try
        { 
            server = new ServerSocket(port); 
            System.out.println("Server started"); 
  
            System.out.println("Waiting for a client ..."); 
  
            socket = server.accept(); 
            System.out.println("Client accepted"); 
  
            // takes input from the client socket 
            in = new DataInputStream(new BufferedInputStream(socket.getInputStream())); 
  
            String line = ""; 
  
            // reads message from client until "Over" is sent 
            while (!line.equals("Over")) 
            { 
                try
                { 
                    line = in.readUTF(); 
                    System.out.println(line); 
  
                } 
                catch(IOException i) 
                { 
                    System.out.println(i); 
                } 
            } 
            System.out.println("Closing connection"); 
  
            // close connection 
            socket.close(); 
            in.close(); 
        } 
        catch(IOException i) 
        { 
            System.out.println(i); 
        } 
    } 
  
    public static void main(String args[]) 
    { 
        
        Server server = new Server(5000);
        try{
                    List<String> ip = new ArrayList<String>();
                    List<String> mac = new ArrayList<String>();
                    final String alphabet = "0123456789ABCDEF";
                    final int N = alphabet.length();

                    String ip1="";
                    String mac1="";
                    Random r1 = new Random();
                    for(int i=0;i<10;i++){
                            ip1=(r1.nextInt(256)+"."+r1.nextInt(256)+"."+r1.nextInt(256)+"."+r1.nextInt(256));
                            ip.add(ip1);
                            mac1=alphabet.charAt(r1.nextInt(N))+""+alphabet.charAt(r1.nextInt(N))+":"+alphabet.charAt(r1.nextInt(N))+""+alphabet.charAt(r1.nextInt(N))+":"+alphabet.charAt(r1.nextInt(N))
    +""+alphabet.charAt(r1.nextInt(N))+":"+alphabet.charAt(r1.nextInt(N))+""+alphabet.charAt(r1.nextInt(N))+":"+alphabet.charAt(r1.nextInt(N))+""+alphabet.charAt(r1.nextInt(N))+":"
    +alphabet.charAt(r1.nextInt(N))+""+alphabet.charAt(r1.nextInt(N));
                            mac.add(mac1);
                    }
                    for(int j=0;j<10;j++){
                            System.out.println(ip.get(j));
                            System.out.println(mac.get(j)+"\n");
                    }
                    //ARP Simulation
                ServerSocket s = new ServerSocket(156);
                Socket obj = s.accept();
                while(true){
                    DataInputStream din = new DataInputStream(obj.getInputStream());
                    DataOutputStream dout = new DataOutputStream(obj.getOutputStream());
                    String str = din.readLine();
                    for(int k=0;k<ip.size();k++){
                        if(str.equals(ip.get(k))){
                            dout.writeBytes(mac.get(k)+"\n");
                            break;
                        }
                    }
                    obj.close();
                }               
                
            }
            catch(Exception e){
                    System.out.println(e);
            } 
    } 
} 