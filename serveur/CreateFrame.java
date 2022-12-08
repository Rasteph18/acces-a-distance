package src.affichage;

import java.awt.BorderLayout;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.zip.*;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;

import src.evenement.SendEvent;

public class CreateFrame extends Thread {

    JFrame frame = new JFrame();

    JDesktopPane desktop = new JDesktopPane();
    Socket cSocket = null;
    JInternalFrame interFrame = new JInternalFrame("Server Screen", true, true, true);
    JPanel cPanel = new JPanel();
    String width="";
    String height="";

    public CreateFrame(Socket cSocket, String width, String height) {

		this.width = width;
		this.height = height;
		this.cSocket = cSocket;
		start();
	}

    public void createGUI() {
        frame.add(desktop, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setExtendedState(frame.getExtendedState()|JFrame.MAXIMIZED_BOTH);	
        frame.setVisible(true);
		interFrame.setLayout(new BorderLayout());
		interFrame.getContentPane().add(cPanel, BorderLayout.CENTER);
		interFrame.setSize(100,100);
		desktop.add(interFrame);

        try {
			interFrame.setMaximum(true);
			}catch (PropertyVetoException ex) { 
				ex.printStackTrace();
		}

        //pour la manipulation du KeyListener
        cPanel.setFocusable(true);
		interFrame.setVisible(true);
    }

    public void run() { 
		//pour lire les captures d'écrans
		InputStream in = null;
		
		createGUI();

		try{
			in = cSocket.getInputStream();
			}catch (IOException ex){
			ex.printStackTrace();
		}

		//commence a recevoir les captures d'écrans 
		new ReceiveScreen(in,cPanel);
		//envoie d'événement au client
		new SendEvent(cSocket,cPanel,width,height);
	}
}