import java.util.*;
import java.io.*;
import java.lang.*;
import java.net.*;

public class Ipmac {
	public static void main(String[] args) throws Exception
	{        
        int[] x = new int[4]; 
        int[] flag= new int[100];
        int[] flag1= new int[100];
        List<String> arr1 = new ArrayList<String>();
        List<String> arr = new ArrayList<String>();
		String l="";
        // FileWriter fw = new FileWriter("file.txt");
          //FileWriter fw1 = new FileWriter("file1.txt");
		Random t = new Random(); 
		int i,j,f,count=0,g=0,ch,k;
		 System.out.println("Logical Address");
		for (i=0;i<10;i++) {
			String ip1 = Integer.toString (t.nextInt(255)) ;
            String ip2 = Integer.toString(t.nextInt(255) );
            String ip3 = Integer.toString(t.nextInt(255)) ;
            String ip4 = Integer.toString(t.nextInt(255));
            String ip=ip1+"."+ip2+"."+ip3+"."+ip4;
            arr.add(ip);
            System.out.println(arr.get(i));
            String p1 = Integer.toHexString(t.nextInt(255)) ;
                 String p2 = Integer.toHexString(t.nextInt(255) );
                String p3 = Integer.toHexString(t.nextInt(255)) ;
                String p4 = Integer.toHexString(t.nextInt(255));
                String p=p1+":"+p2+":"+p3+":"+p4;
                arr1.add(p);
                System.out.println(arr1.get(i)+"\n"); 
    }
          FileWriter fw = new FileWriter("file.txt");
          FileWriter fw1 = new FileWriter("file1.txt");
          FileWriter fw2 = new FileWriter("C:/Users/karthik/file2.txt"); 
	  FileWriter fw3 = new FileWriter("C:/Users/karthik/file3.txt");
          flag[0]=1;
          flag1[0]=1;
          for(i=1;i<arr.size();i++)
          {
            flag[i]=0;
            flag1[i]=0;
          }
                for (i = 0; i < arr.size(); i++) 
                {
                    fw.write(arr.get(i)+","+flag[i]+"\n");
                    fw1.write(arr1.get(i)+","+flag1[i]+"\n");
                    fw2.write(arr.get(i)+","+flag[i]+"\n");
                    fw3.write(arr1.get(i)+","+flag1[i]+"\n");
                }
                

            
                fw.close();
                fw1.close();
}
}