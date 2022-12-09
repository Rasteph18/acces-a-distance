package src.principal;

import javax.swing.JOptionPane;

import src.connection.Connection;

public class Test {
    public static void main(String[] args){
		String ip = JOptionPane.showInputDialog("Entrer l'IP du Serveur");
		Connection connex = new Connection(ip, Integer.parseInt("5555"));
	}
}
