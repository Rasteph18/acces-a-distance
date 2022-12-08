package src.principal;

import java.net.Socket;
import javax.swing.JOptionPane;
import java.io.DataInputStream;
import java.io.DataOutputStream;

import src.affichage.*;
import src.commande.Command;
import src.evenement.*;

public class Test {
    DataInputStream verification = null;
    String width="",height="";
    public static void main(String[] args) {
        String ip = JOptionPane.showInputDialog("Entrer l'IP du client");
		new Test().initialize(ip, Integer.parseInt("5555"));
    }

    public void initialize(String ip, int port){
        
        try{
            
            Socket sc = new Socket(ip,port);
            System.out.println("Connecting to ...");
            
            verification = new DataInputStream(sc.getInputStream());
            width = verification.readUTF();
			height = verification.readUTF();

            CreateFrame frame = new CreateFrame(sc, width, height);
            
        } catch (Exception ex){
            ex.printStackTrace();
        }

    }
}
