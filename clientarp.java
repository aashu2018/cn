import java.io.*;
import java.util.*;
import java.net.*;

public class clientarp{
    public static void main(String args[]){
        try{
            Random r= new Random();
            int i,j,s;
            ArrayList<String> arrll= new ArrayList<>();
            ArrayList<String> arrl= new ArrayList<>();
           
           BufferedReader brr=new BufferedReader(new FileReader("file.txt"));
            
          
          while(brr.ready()){ 
              arrll.add(brr.readLine());
           }

          
           j=r.nextInt(10);
           
           
           //System.out.println(arrl.get(j)+"\n");
            //BufferedReader in = arrll.get(j);
            Socket sc = new Socket("127.0.0.1",156);
            DataInputStream din = new DataInputStream(sc.getInputStream());
            DataOutputStream dout = new DataOutputStream(sc.getOutputStream());
            
            //System.out.println("Enter the Logical address(IP):");
            String str1=arrll.get(j);
          
            
            //System.out.println("Give me the MAC address for this ip address");
            dout.writeBytes(str1+'\n');
            String str=din.readLine();
            String xy=din.readLine();
            String bc=din.readLine();
            String bbc="00:00:00:00";
            System.out.println("ARP Request Packet"+'\n'+"Sender's Ip address"+str+'\n'+"Sender's Physical address"+xy+'\n'+"Receiver's ip address"+str1+'\n'+"Receiver's Physical address"+bbc);
            System.out.println("\n\n");
            System.out.println("The ARP Reply Packet "+ '\n'+"Sender's Ip address"+str+'\n'+"Sender's Physical address"+xy+'\n'+"Receiver's ip address"+str1+'\n'+"Receiver's Physical address"+bc); 
            System.out.println("The flag is set as one");
            
            brr.close();
            FileWriter fw = new FileWriter("file.txt");
            int[] flag= new int[100];
            int[] flag1= new int[100];
            flag[0]=1;
            flag1[0]=1;

          for(i=1;i<arrll.size();i++)
          {
            flag[i]=0;
            flag1[i]=0;
          }
          flag[j]=1;
          flag1[j]=1;
          for (i = 0; i < arrll.size(); i++) 
                {
                    fw.write(arrll.get(i)+","+flag[i]+"\n");
                }

          fw.close();
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
            
        }catch(Exception e){
            System.out.println(e);
        }
    }
}