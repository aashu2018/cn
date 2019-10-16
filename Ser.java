import java.util.*;
import java.io.*;
import java.lang.*;
import java.net.*;
public class Ser {
public static void main(String[] args) throws Exception{  
       int i,f;
       int[] flag= new int[100];
       int[] flag1= new int[100];
       flag[0]=1;
       flag1[0]=1;
       for(i=1;i<=10;i++){
          flag[i]=0;
          flag1[i]=0;
       }
       File fr=new File("C:/Users/karthik/file.txt");
       BufferedReader br=new BufferedReader(new FileReader(fr));
       FileReader fr1=new FileReader("C:/Users/karthik/file1.txt");
       BufferedReader br1=new BufferedReader(fr1);
       ServerSocket s = new ServerSocket(156);
       Socket obj = s.accept();
       while(true){
           DataInputStream din = new DataInputStream(obj.getInputStream());
           DataOutputStream dout = new DataOutputStream(obj.getOutputStream());
           String str = din.readLine();
           f=0;
           String ab=br.readLine();
           String cd=br1.readLine();
           String bc="00:00:00:00";
           System.out.println("ARP Request Packet"+'\n'+"Sender's Ip address"+ab+'\n'+"Sender's Physical address"+cd+'\n'+"Receiver's ip address"+str+'\n'+"Receiver's Physical address"+bc);
            for(i=0;i<10;i++){
               if(str.equals(br.readLine())){
                   flag[i]=1;
                   flag1[i]=1;
                   dout.writeBytes(ab+"\n");
                   dout.writeBytes(cd+"\n");   
                   dout.writeBytes(br1.readLine()+"\n");
                   f=1;
                   break;
              }
              else{
                   br1.readLine();
              }
        } 
        if(f!=1)
        {
            System.out.println("ip is not present");
        }
        DataInputStream inn = new DataInputStream(obj.getInputStream());
        DataInputStream inj = new DataInputStream(System.in);
        DataOutputStream out = new DataOutputStream(obj.getOutputStream());
        String line = ""; 
        String lin = ""; 
        while (!line.equals("Over")) {
               line = inn.readUTF(); 
               System.out.println("Client: "+line);
               lin =inj.readLine();
               out.writeUTF(lin);
        } 
        System.out.println("Closing connection"); 
        obj.close(); 
        break;
}        
}
}
