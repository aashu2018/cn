import java.io.*;
import java.net.*;
import java.util.*;
class Serverdns
{
     public static void main(String args[])
     {
         try
            {
               DatagramSocket server=new DatagramSocket(1309);
               while(true)
                        {
                        byte[] sendbyte=new byte[1024];
                        byte[] receivebyte=new byte[1024];
                        DatagramPacket receiver=new DatagramPacket(receivebyte,receivebyte.length);
                        server.receive(receiver);
                        String str=new String(receiver.getData());
                        String s=str.trim();
                        InetAddress addr=receiver.getAddress();
                        int port=receiver.getPort();
                        String ip[]={"http://31.13.71.36","http://64.233.185.147","http://66.29.212.110","http://35.200.167.142","http://182.75.25.252","http://3.215.13.232","http://103.70.60.105","http://104.36.196.224","http://18.200.208.211","http://106.10.250.11","http://72.32.138.96"};
                        String name[]={"https://www.facebook.com","https://www.google.com","https://www.w3schools.com","https://www.cricbuzz.com","https://lms.ssn.edu.in","https://www.quora.com","https://coe1.annauniv.edu","https://www.uber.com","https://www.espncricinfo.com","https://in.yahoo.com","https://www.marvel.com"};
                        for(int i=0;i<ip.length;i++)
                        {
                             if(s.equals(ip[i]))
                             {
                                 sendbyte=name[i].getBytes();
                                 DatagramPacket sender=new DatagramPacket(sendbyte,sendbyte.length,addr,port);
                                 server.send(sender);
                                 break;
                             }
                             else if(s.equals(name[i]))
                             {
                                 sendbyte=ip[i].getBytes();
                                 DatagramPacket sender=new DatagramPacket(sendbyte,sendbyte.length,addr,port);
                                 server.send(sender);
                                 break;
                             }
                      }         
                      break;
                }
            }
            catch(Exception e)
            {
                        System.out.println(e);
            }
            }
}