package simpleChat;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class CopyOfGUI extends JFrame{
private boolean set;

	public CopyOfGUI(){
		setupWindow();
		set = false;
		
		 
        // pack();
	}
	
	public void setR(boolean set)
	{
		this.set = set;
		Main m = new Main();
		m.setRun(set);
	}
	
	public void setupWindow()
	{
		setTitle("Chat Server");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setSize(600, 600);
		
		JButton start = new JButton("Start");
		JButton stop = new JButton("Stop");
		stop.setBounds(50, 110, 100, 50);
		start.setBounds(50, 50, 100, 50);
		
		JTextArea t = new JTextArea("Out", 50, 50);
		t.setEditable(false);
		add(t);
		add(start);
		add(stop);
		
		JTextArea text = new JTextArea("OutPut", 5, 20);//Output for the server
		JScrollPane scrollPane = new JScrollPane(text); 
		text.setEditable(false);
		add(text);
		
		
		
		
		
		start.addActionListener(new ActionListener()
		{
		  public void actionPerformed(ActionEvent e)
		  {
			  
			  System.out.println("Start");
			  if(set != true){
			  set = true;
			  setR(true);}
			  JTextArea message = new JTextArea(50,50);
			  message.setText("Server Started!");
		  }});
		
		stop.addActionListener(new ActionListener()
		{
		  public void actionPerformed(ActionEvent e)
		  {
			  
			  System.out.println("Stop");
			  if(set != false){
				  set = false;
				  setR(false);}
			  JTextArea message = new JTextArea();
			  message.setText("Server Stopped!");
		  }});
		
		//m.setRun(set);
		//System.out.println("Set");
	}
	
	 public static void main(String[] args) {
	                CopyOfGUI g = new CopyOfGUI();
	                g.setVisible(true);
	    }
	
}
