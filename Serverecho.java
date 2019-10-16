import java.net.*;
import java.io.*;
import java.util.*;
import java.lang.*;
public class Serverecho{
	public static void main (String[]args) throws Exception{
	ServerSocket s=new ServerSocket (2000);
	System.out.println("created");
	Socket obj=s.accept();
		BufferedReader br= new BufferedReader(new InputStreamReader(obj.getInputStream()));
		DataOutputStream dos= new DataOutputStream(obj.getOutputStream());
		String str;
		while(true){
				while((str=br.readLine())!=null){
					System.out.println("sent");
					dos.writeBytes(str);
				}
			System.out.println("terminated");
		}
	}
}