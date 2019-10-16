import java.net.*;
import java.io.*;
import java.util.*;
import java.lang.*;
public class Clientdate{
	public static void main (String[]args) throws Exception{
	Socket s=new Socket (InetAddress.getLocalHost(),2000);
	System.out.println("created");
	while(true){
		BufferedReader inn= new BufferedReader(new InputStreamReader(s.getInputStream()));
		System.out.println(inn.readLine());
		inn.close();
		
	}

	}
}