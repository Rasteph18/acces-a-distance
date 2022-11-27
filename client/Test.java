package client.principal;

import java.net.Socket;
import javax.swing.JOptionPane;

import client.affichage.*;
import client.commande.Command;
import client.evenement.*;

public class Test {
    public static void main(String[] args) {
        String ip = JOptionPane.showInputDialog("Please enter server ip");
		new Test().initialize(ip, Integer.parseInt("5555"));
    }

    public void initialize(String ip, int port){
        try{
            
            Socket sc = new Socket(ip,port);
            System.out.println("Connecting to the Server");
            
            Authentification frame1= new Authentification(sc);

            frame1.setSize(300,80);
            frame1.setLocation(500,300);
            frame1.setVisible(true);
        } catch (Exception ex){
            ex.printStackTrace();
        }

    }
}
