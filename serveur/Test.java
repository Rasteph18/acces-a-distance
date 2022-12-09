package src.principal;

import java.net.Socket;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;

import src.affichage.*;
import src.commande.Command;
import src.evenement.*;

public class Test {
    DataInputStream verification = null;
    String width="",height="";
    ServerSocket socket = null;
    public static void main(String[] args) {
       
		new Test().initialize(Integer.parseInt("5555"));
    }

    public void initialize(int port){
        
        try{
            System.out.println("Attente de connection");
            socket=new ServerSocket(port);
            while(true){
                Socket sc=socket.accept();
                verification = new DataInputStream(sc.getInputStream());
                width = verification.readUTF();
			    height = verification.readUTF();

                CreateFrame frame = new CreateFrame(sc, width, height);
            }
            
        } catch (Exception ex){
            ex.printStackTrace();
        }

    }
}
