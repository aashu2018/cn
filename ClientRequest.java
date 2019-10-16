import java.rmi.*;   
import java.util.Scanner;  
import java.util.Calendar;  
import java.util.GregorianCalendar;  
import java.io.IOException;  
import java.net.ServerSocket;  
import java.net.Socket;  
import java.util.Date; 
public class ClientRequest{      
public static void main(String args[]) throws IOException{        
try{       
String[] answer=new String[5];       
String value=" ",answer1;       
int i=0,ch=1;       
Search access =(Search)Naming.lookup("rmi://localhost:1900"+ "/hel");       
do{       
i++;  
answer[i] = access.query(value);      
System.out.println("Client :"+answer[i]);      
}while(!answer[i].equals("Exit"));}   
catch(Exception ae) {   
System.out.println(ae);}} }  
