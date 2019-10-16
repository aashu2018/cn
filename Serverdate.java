import java.net.*;
import java.io.*;
import java.util.*;
import java.lang.*;
public class Serverdate{
	public static void main (String[]args) throws Exception{
	ServerSocket s=new ServerSocket (2000);
	System.out.println("created");
	Socket obj=s.accept();
	System.out.println("accepted");
	while(true){
		DataOutputStream in= new DataOutputStream(obj.getOutputStream());
		in.writeBytes("Server date:"+ (new Date()).toString()+"\n");
		in.close();
	
	}

	}
}