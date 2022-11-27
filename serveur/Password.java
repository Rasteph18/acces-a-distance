package serveur.affichage;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

import serveur.connection.Connection;

public class Password extends JFrame implements ActionListener{
    JButton SUBMIT;
	JPanel panel;
	JLabel label1,label2;
	JTextField text1,text2;
	String value1;
	String value2;
	JLabel label;

    public Password(){
        label1=new JLabel();
         label1.setText("Set Password");
         text1 = new JTextField(15);
         
         label=new JLabel();
         label.setText("");
         
         
         this.setLayout(new BorderLayout());
         
         SUBMIT = new JButton("SUBMIT");
 
         panel=new JPanel(new GridLayout(2,1));
         panel.add(label1);
         panel.add(text1);
         
         panel.add(label);
         panel.add(SUBMIT);
         add(panel,BorderLayout.CENTER);
         SUBMIT.addActionListener(this);
         setTitle("Set Password to connect to the Client");
     }
	
    public void actionPerformed(ActionEvent ae){
		value1=text1.getText();
		dispose();
		new Connection(Integer.parseInt("5555"),value1);
	}

    public String getValue1(){
		return value1;
	}
	

	public static void main(String[] args){

		Password frame1= new Password();
	    frame1.setSize(300,80); 				
	    frame1.setLocation(500,300);
		frame1.setVisible(true);	 
		
	}
}
