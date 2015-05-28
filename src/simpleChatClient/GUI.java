package simpleChatClient;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GUI extends JFrame {
	
	public final int WIDTH = 600;
	public final int HEIGHT = 600;
	
	private JTextArea chatBox;
	private JTextField messageBox;
	private JScrollPane scroll;
	private String currentMessage = "Testing";
	

	public GUI(){
		setupWindow();
		setVisible(true);
	}
	
	public void setupWindow(){
		
		setSize(HEIGHT, WIDTH);
		setLayout(new FlowLayout());
		chatBox = new JTextArea(5, 30);
		scroll = new JScrollPane(chatBox);
		add(scroll);
		
		messageBox = new JTextField("Message To Send");
		messageBox.setColumns(30);
		add(messageBox);
		
		messageBox.addKeyListener(new KeyListener(){

			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == e.VK_ENTER){
					if(!messageBox.getText().trim().equals("")){
						chatBox.append(messageBox.getText() + "\n");
						currentMessage = messageBox.getText();
					}
					messageBox.setText("");
				}	
			}
			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub	
			}
		});
		
	}
	
	
	public String getMessage(){
		return currentMessage;
	}

}
