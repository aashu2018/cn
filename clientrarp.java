import java.io.*;
import java.util.*;
import java.net.*;
public class clientrarp{
    public static void main(String args[]){
        try{
            Random r= new Random();
            int i,j,s;
            ArrayList<String> arrll= new ArrayList<>();
            ArrayList<String> arrl= new ArrayList<>();
            BufferedReader brr=new BufferedReader(new FileReader("file1.txt"));
            while(brr.ready()){ 
              arrll.add(brr.readLine());
            }
            j=r.nextInt(10);
            System.out.println(arrll.get(j)+"\n");
            Socket sc = new Socket("127.0.0.1",156);
            DataInputStream din = new DataInputStream(sc.getInputStream());
            DataOutputStream dout = new DataOutputStream(sc.getOutputStream());
            String str1=arrll.get(j);
            dout.writeBytes(str1+'\n');
            String xy=din.readLine();
            String str=din.readLine();
            String bc=din.readLine();
            String bbc="00:00:00:00";
            System.out.println("RARP Request Packet"+'\n'+"Sender's Ip address"+str+'\n'+"Sender's Physical address"+xy+'\n'+"Receiver's ip address"+bbc+'\n'+"Receiver's Physical address"+str1);
            System.out.println("\n\n");
            System.out.println("The RARP Reply Packet "+ '\n'+"Sender's Ip address"+str+'\n'+"Sender's Physical address"+xy+'\n'+"Receiver's ip address"+bc+'\n'+"Receiver's Physical address"+str1); 
            System.out.println("The flag is set as one");
            brr.close();
            FileWriter fw = new FileWriter("file1.txt");
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
            while (!line.equals("Over")) { 
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