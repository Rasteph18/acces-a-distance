package src.affichage;

import java.awt.Graphics;
import java.awt.Image;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.DataInputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class ReceiveScreen extends Thread {
   
	JPanel cPanel = null;
	boolean boucle = true;
	InputStream in = null;
	Image image1 = null;

    public ReceiveScreen(InputStream in,JPanel p){
		this.in = in;
		cPanel = p;
		start();
	}

    public void run(){
		try{
			//lit et dessine les captures d'écrans du client
			while(boucle){
				byte[] bytes = new byte[1024*1024];
				int count = 0;
				do{
					count+=in.read(bytes,count,bytes.length-count);
				}while(!(count>4 && bytes[count-2]==(byte)-1 && bytes[count-1]==(byte)-39));
				
				image1 = ImageIO.read(new ByteArrayInputStream(bytes));
				image1 = image1.getScaledInstance(cPanel.getWidth(),cPanel.getHeight(),Image.SCALE_SMOOTH);

				//dessine les captures d'écrans recu

				Graphics graphics = cPanel.getGraphics();
				graphics.drawImage(image1, 0, 0, cPanel.getWidth(), cPanel.getHeight(), cPanel);
			}

		} catch(IOException ex) {
			ex.printStackTrace();
		}
	}
}