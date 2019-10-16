import java.net.*;
import java.io.*;
import java.util.*;
import java.lang.*;
public class Clientecho{
	public static void main (String[]args) throws Exception{
	Socket s=new Socket ("localhost",2000);
	System.out.println("created");
		BufferedReader in= new BufferedReader( new InputStreamReader(System.in));
		BufferedReader br= new BufferedReader(new InputStreamReader(s.getInputStream()));
		DataOutputStream dos= new DataOutputStream(s.getOutputStream());
		String str,str1=null;
		System.out.println("enter the text");
			while(!(str=in.readLine()).equals("quit")){
				dos.writeBytes(str+"\n");
				str1=br.readLine();
				System.out.println("server"+str1);
				System.out.println("enter the text");
		
		}
	}
}