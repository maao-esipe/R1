package view;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.lang.model.element.Element;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import controler.DAO;
import controler.DAOStair;
import model.Stair;

/**
 * 
 */

/**
 * @author mansa
 *
 */
public class WindowStair extends Window<Stair>{
	//private JPanel		component_panel		= new JPanel();
	//private JPanel 		information_panel 	= new JPanel();
	//private JPanel 		insert_panel  		= new JPanel();
	//private JPanel 		insertform_panel  	= new JPanel();
	
	//private JTextField 	name_textField 		= new JTextField();
	//private JLabel 		name_label			= new JLabel("Stair name");
	//private JLabel		information_label 	= new JLabel("");
	//private JOptionPane error_optionpane;
	
	public WindowStair() {
		super();
		this.setTitle("MAAO - Configuration stair");
		this.setTitle_label("Configuration stair");
	    //information_panel.setLayout(new BorderLayout());
	    //insert_panel.setLayout(new BorderLayout());
		 //component_panel.setLayout(new BorderLayout());
		 //this.setLayout(new BorderLayout());
		 //insertform_panel.setLayout(new FlowLayout());
	       
		 //Font police = new Font("Arial", Font.BOLD, 14);
		 //name_textField.setFont(police);
		 //name_textField.setPreferredSize(new Dimension(150, 30));
		 //name_textField.setForeground(Color.BLUE);
	    //////////////////////////////////////////////////
	    //////////////////////////////////////////////////
		/*Object[][] data_tab = {
                {"et1" 	},
                {"et2"},
                {"et3"	}
        };
        String[] head_string = {"Name"};
        super.setW_table(new JTable(data_tab, head_string));*/
      //table placement (study how to put in window class) ?
	    super.getComponent_panel().add(super.getW_table(), BorderLayout.CENTER);
		//////////////////////////////////////////////////
	    
	    
	    //getAdd_button().addActionListener(new BoutonListener());
	
	    //component_panel.add(insert_panel, BorderLayout.NORTH);
	    //component_panel.add(a_table, BorderLayout.CENTER);
	    
	    //information_panel.add(information_label);
	    //insert_panel.add(information_panel, BorderLayout.NORTH);
	    //insert_panel.add(insertform_panel, BorderLayout.CENTER);
	    
	    //insertform_panel.add(information_label);
	    //insertform_panel.add(name_label);
	    //insertform_panel.add(name_textField);
	    //insertform_panel.add(valid_button);
	    
	   
		//////////////////////////////////////////////////
      	    
	    
	    //this.getContentPane().add(new JButton("menu"), BorderLayout.NORTH);
	    //Au sud
	    this.setVisible(true);
	    
	}
	class BoutonListener implements ActionListener{
		  public void actionPerformed(ActionEvent e) {
		   /* System.out.println("STAIR : name: " + name_textField.getText());
		    
		    DAOStair daoStair;
			try {
				daoStair = new DAOStair();
				Stair stair = new Stair(name_textField.getText());
		        try {
					if(daoStair.create(stair)) {
						information_label.setOpaque(true);
						information_label.setBackground(Color.green);
						information_label.setText("Congratulation, your value is added");
						//actualis JTab
					}else {
						information_label.setOpaque(true);
						information_label.setBackground(Color.red);
						information_label.setText("Sorry, but you can't insert an existant data.");
						//error_optionpane = new JOptionPane();
					    //JOptionPane.showMessageDialog(null, "Sorry, but you can't insert an existant data.", "MAAO - Error message", JOptionPane.ERROR_MESSAGE);
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} catch (Exception e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			} */
		  }	 
	}
	
	@Override
	public void add_table(Stair obj) {
		// TODO Auto-generated method stub
		DefaultTableModel stair_dtm = (DefaultTableModel) super.getW_table().getModel();
		stair_dtm.addRow(new Object[] {obj.getStair_name()});
		System.out.println("ajoute : "+obj.getStair_name());
		this.setVisible(true);
	}
	@Override
	public void delete_table(Stair obj) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void update_table(Stair obj) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void initialise_table() {
		// TODO Auto-generated method stub
		DAOStair daostair;
		ArrayList<Stair> liste;
		try {
			daostair = new DAOStair();
			liste = daostair.presentData();
			System.out.println(liste);
			for(int i = 0 ; i<liste.size(); i++) {
				System.out.println("ecrire "+liste.get(i).getStair_name());
				this.add_table(liste.get(i));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public boolean update_action(Stair obj) {
		// TODO Auto-generated method stub
		Stair stair = new Stair();
		DAO daostair;
		try {
			daostair = new DAOStair();
			daostair.update(stair);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}
	@Override
	public boolean delete_action(Stair obj) {
		// TODO Auto-generated method stub
		Stair stair = new Stair();
		DAO daostair;
		try {
			daostair = new DAOStair();
			daostair.delete(stair);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}
	
	@Override
	public boolean add_action(Stair obj) {
		// TODO Auto-generated method stub
		Stair stair = new Stair();
		DAO daostair;
		try {
			daostair = new DAOStair();
			daostair.create(stair);
			this.add_table(stair);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}

}