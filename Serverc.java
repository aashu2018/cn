import java.rmi.*; 
import java.rmi.registry.*; 
public class Serverc{ 
public static void main(String args[]){ 
try{ 
calinterface stub=new RemoteCalc(); 
LocateRegistry.createRegistry(8000); 
Naming.rebind("rmi://localhost:8000/aaa",stub); 
System.out.println("Server is Running");} 
catch(Exception e){
System.out.println(e);
}}} 
 