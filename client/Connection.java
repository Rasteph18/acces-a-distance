package src.connection;

import java.awt.Dimension;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.GraphicsDevice;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.*;

import src.capture.SendScreen;
import src.evenement.ReceiveEvent;

public class Connection {
   
	DataOutputStream verify = null;
	String width="";
	String height="";

    public Connection(String ip, int port){
        Robot robot = null;
		Rectangle rectangle = null;
		try{
			
			GraphicsEnvironment gEnv = GraphicsEnvironment.getLocalGraphicsEnvironment();
			GraphicsDevice gDev = gEnv.getDefaultScreenDevice();
	
			Dimension dim=Toolkit.getDefaultToolkit().getScreenSize();
			String width=""+dim.getWidth();
			String height=""+dim.getHeight();
			rectangle=new Rectangle(dim);
			robot=new Robot(gDev);

			drawGUI();

			Socket sc = new Socket(ip,port);
            System.out.println("Connecting to ...");
				
				
				verify=new DataOutputStream(sc.getOutputStream());
				
				verify.writeUTF(width);
				verify.writeUTF(height);
				new SendScreen(sc,robot,rectangle);
				new ReceiveEvent(sc,robot);
	
			}catch (Exception ex){
				ex.printStackTrace();
			}
	}
			
	public void drawGUI(){
	}
    
}
