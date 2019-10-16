import java.rmi.*;   
import java.rmi.server.*;   
import java.rmi.*;   
import java.io.*;  
import java.util.*;  
interface Search extends Remote   {       
public String query(String search) throws RemoteException;   }   
public class SearchQuery extends UnicastRemoteObject  implements Search   {      
SearchQuery() throws RemoteException       {        }       
public String query(String search)                          throws RemoteException       {          
 String[] res=new String[2];          
 String d;          
 String answer=" ";          
 System.out.println("Enter the choice \n 1)greeting \n 2)Local Time \n 3)Exit");      
 Scanner c=new Scanner(System.in);      
 d=c.nextLine();      
 switch(d){          
 case "1":{      
 System.out.println("Enter the user name");      
 Scanner a=new Scanner(System.in);      
 String b=a.nextLine();          
 String value=b+"!!!!!!!!!!!!!!!!!!";   
 try{              
 answer="Welcome "+value;          
 }   
 catch(Exception ae) {   
 System.out.println(ae);}  
 break;  }  
 case "2":{  
 Calendar calendar = new GregorianCalendar();      
 String am_pm;  int hour = calendar.get(Calendar.HOUR);  
 int minute = calendar.get(Calendar.MINUTE);  
 int second = calendar.get(Calendar.SECOND);      
 if(calendar.get(Calendar.AM_PM) == 0)  
 am_pm = "AM";      else  am_pm = "PM"; 
 answer=hour+":"+minute+":"+second+" "+am_pm;      
 break;  }  
 case "3":  
 System.out.println("Exit!!!!!!!!!!!!!!!");  
answer="Exit";      
break;  
default:  System.out.println("Enter a valid choice");  }  
System.out.println("Server :"+answer);  return answer;         }   } 