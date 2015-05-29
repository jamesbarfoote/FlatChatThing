package simpleChatClient;

import java.io.IOException;
import java.net.Socket;

import javax.swing.JFrame;


public class Main {

	private final static int PORT = 6677;//SET A CONSTANT VARIABLE PORT	
	public static void main(String[] args) throws IOException
	{
            GUI frame = new GUI();
            while(true){
		try 
		{
                    
                    //String HOST = frame.getIP();//SET A CONSTANT VARIABLE HOST
                    String HOST = "192.168.20.112";//SET A CONSTANT VARIABLE HOST

                        if(frame.getIP() != null)//Change the host IP
                        {
                            HOST = frame.getIP();
                            
                        }
                        frame.getTextArea().append(HOST + "\n");
			Socket s = new Socket(HOST, PORT);//CONNECT TO THE SERVER
			frame.getTextArea().setText(null);//Clear the window once connected to server
			System.out.println("You connected to " + HOST);//IF CONNECTED THEN PRINT IT OUT
			frame.getTextArea().append("You connected to " + HOST);
			Client client = new Client(s, frame);//START NEW CLIENT OBJECT
			
			Thread t = new Thread(client);//INITIATE NEW THREAD
			t.start();//START THREAD
			
		} 
		catch (Exception noServer)//IF DIDNT CONNECT PRINT THAT THEY DIDNT
		{
                    frame.getTextArea().append("The server might not be up at this time. \n");
                    frame.getTextArea().append("Please try again later. \n");

			System.out.println("The server might not be up at this time.");
			System.out.println("Please try again later.");
		}
                try{
                    Thread.sleep(1000);
                }catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
}
	}
            }
}


