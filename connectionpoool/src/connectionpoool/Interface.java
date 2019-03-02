package connectionpoool;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


import java.sql.*;

public class Interface extends JFrame implements ActionListener {

	private JTextField j1;
	private JTextField j2;
	private JPanel panelTitre, panelMilieu, panelAnnul;
	private JLabel l,l2,l3;
	private JButton b1, b2;
	public static Connection c;
	private String champ1,champ2;
	
	
	
	public Interface() {
		super("Data Connection Interface");
		this.setLayout(new BorderLayout());
		
		l= new JLabel("Welcome To MAAO Interface",SwingConstants.CENTER);
		l2= new JLabel("Login : ",SwingConstants.LEFT);
		l3= new JLabel("Password  : ",SwingConstants.LEFT);
	
		
		j1 = new JTextField("Enter your username in this field");
		j2 = new JPasswordField("password for the connection");
		
		b1 = new JButton("Connecion");
		b2 = new JButton("Cancel the entry");
		
		
		
		
		panelTitre=new JPanel();//fait appel au constructeur de la classe JPanel afin de considerer panelTitre �tant un panneau
		panelTitre.add(l);//joute dans ce panneau le labet du titre
		panelTitre.setBackground(Color.LIGHT_GRAY);//d�finit la couleur gris clair comme la couleur de fond de ce panneau



		panelMilieu =new JPanel();
		panelMilieu.setLayout(new GridLayout(8, 4));
		panelMilieu.add(l2);
		panelMilieu.add(j1);
		panelMilieu.add(l3);
		panelMilieu.add(j2);
		
		panelAnnul= new JPanel();
		panelAnnul.add(b1);
		panelAnnul.add(b2);
	
		
		this.add(panelTitre,BorderLayout.NORTH);
		this.add(panelMilieu,BorderLayout.CENTER);
		this.add(panelAnnul, BorderLayout.SOUTH);
		
	b1.addActionListener(this);
	b2.addActionListener(this);

		
		this.setSize(300,300);
		this.setLocationRelativeTo(null);
		
		this.setVisible(true);
		
		
		
	}
	
	public void actionPerformed(ActionEvent event) {
		
		if(event.getSource()==b1) {
			 champ1 = j1.getText();
				champ2 = j2.getText();
				ReadFichier r = new ReadFichier();
				try {
			             r.readFile(champ1,champ2);
				} catch (Exception e) {
					 
				}			
		}

		
		else if(event.getSource() ==b2) {
		
			j1.setText("");
			j2.setText("");
		}
	}
	


}
