package simpleChat;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.ArrayList;

public class Main {
	private static boolean run = true;
	  public static void main(String[] args) throws IOException {
		           try{
		        	   GUI g = new GUI();
		        	   final int PORT = 6677;//Our port
		        	   ServerSocket server = new ServerSocket(PORT);//Bind the port
		        	   g.getTextOutputArea().append("Waiting for clients...\n");
		        	   System.out.println("Waiting for clients...");
		        	   
		        	   while(true)//While the program is running do this
		        	   {
		        		   Socket s = server.accept();//Client that has connected to us
		        		   g.getTextOutputArea().append("Client connected from " + s.getLocalAddress().getHostName());
		        		   System.out.println("Client connected from " + s.getLocalAddress().getHostName());	
		        		   				
		        		   Client chat = new Client(s);//new client object
		        		   Thread t = new Thread(chat);
		        		   t.start();//Start the new thread with the client


		        	   }


		           }
		           catch(Exception e){
		        	   
		           }
		      }
	  
	  public void setRun(boolean run)
	  {
		  this.run = run;
		  System.out.println("Run set " + run);
	  }
		   

}
