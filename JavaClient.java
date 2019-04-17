import java.io.*;
import java.net.*;
import java.util.Scanner;

public class JavaClient {

    public static void main(String[] args) throws IOException {
        
        
        int choice=0;
        String request="";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(choice!=2)
        {
        	System.out.println("Make a choice");
        	System.out.println("[1] Make API call");
        	System.out.println("[2] Exit");
        	choice=Integer.parseInt(br.readLine());
        	if(choice==1) {
        		System.out.println("enter the english text");
        		request=br.readLine();
        	}
        	else
        		break;
        
        	
        String query = "reqstring="+request;
        query=query.replaceAll(" " , "%20");
        URL url = new URL("http://localhost:9090/translate?"+query);
        
        //make connection
        URLConnection urlc = url.openConnection();




        //get result
        BufferedReader br1 = new BufferedReader(new InputStreamReader(urlc
                .getInputStream()));
        String l = null;
        while ((l=br1.readLine())!=null) {
            System.out.println(l);
        }
        br1.close();
        }
    }
}