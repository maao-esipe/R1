/**
 * 
 */
package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.lang.model.element.Element;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;

import model.Stair;

/**
 * @author mansa
 * @param <T>
 *
 */
public abstract class Window<T> extends JFrame implements ActionListener{
	//Panel 
	private JPanel 		menu_panel	 		= new JPanel();
	private JPanel		component_panel		= new JPanel();
	private JPanel		buttons_panel		= new JPanel();
	
	//Button
	private JButton 	add_button 			= new JButton("Add"		);
	private JButton 	update_button 		= new JButton("Update"	);
	private JButton 	delete_button 		= new JButton("Delete"	);
	
	//Other element
	protected JTable		w_table				= new JTable();
	private JLabel		title_label			= new JLabel();

	public Window(){
		//Generality
		this.setSize(500, 500);
	    this.setLocationRelativeTo(null);               
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    //principal placement
	    this.setLayout(new BorderLayout());
	    this.getContentPane().add(menu_panel		, BorderLayout.NORTH	);
	    this.getContentPane().add(component_panel	, BorderLayout.CENTER	);
	    
	    //content page placement
	    component_panel.setLayout(new BorderLayout());
	    component_panel.add(title_label, BorderLayout.NORTH);
	    
	    //button size
	    add_button.setSize		(30, 20); 	// ? don't work
	    delete_button.setSize	(20, 20); 	// ? don't work
	    add_button.setSize		(30, 20); 	// ? don't work
	    
	    //placement in the grid layout
	    buttons_panel.setLayout(new GridLayout(10,1));
	    buttons_panel.add(	this.add_button		);
	    buttons_panel.add(	this.update_button	);
	    buttons_panel.add(	this.delete_button	);
	    component_panel.add(this.buttons_panel, BorderLayout.WEST);
	    
	    //Action listener
	    this.getAdd_button().addActionListener		(new ButonListener());
	    this.getUpdate_button().addActionListener	(new ButonListener());
	    this.getDelete_button().addActionListener	(new ButonListener());
	    this.initialise_table();
	}
	
	/**
	 *	@Override ButonListener ActionListener
	 */
	class ButonListener implements ActionListener{
	    public void actionPerformed(ActionEvent e) {
	        if ("Add".equals(e.getActionCommand())) {
	            // method add
	        	//this.add_action();
	        	System.out.println("add");
	        	setVisible(true);
	        } 
	        else if ("Update".equals(e.getActionCommand())) {
	            // method update line number
	        	//this.update_action(w_table[][]);
	        	System.out.println("update");
	        	setVisible(true);
	        }
	        else if ("Delete".equals(e.getActionCommand())) {
	            // method delete line number
	        	//this.delete_action(w_table[][]);
	        	System.out.println("delete");
	        	setVisible(true);
	        }
	        else {
	        }
	    }
	}
    public abstract boolean add_action(T obj);
    public abstract boolean update_action(T obj);
    public abstract boolean delete_action(T obj);
    
    /**
	 *	JMenu
	 */
	public void menu() {
		
	}
	
	/**
	 * @return the component_panel
	 */
	public JPanel getComponent_panel() {
		return this.component_panel;
	}
	/**
	 * @return the add_button
	 */
	public JButton getAdd_button() {
		return this.add_button;
	}
	/**
	 * @return the update_button
	 */
	public JButton getUpdate_button() {
		return this.update_button;
	}
	/**
	 * @return the delete_button
	 */
	public JButton getDelete_button() {
		
		return this.delete_button;
	}
	/**
	 * @return the w_table
	 */
	public JTable getW_table() {
		
		return this.w_table;
	}

	/**
	 * @param w_table the w_table to set
	 */
	public void setW_table(JTable the_table) {
		this.w_table = the_table;
	}
	
	/**
	 * Init the JTable
	 */
	public abstract void initialise_table	();
	
	/**
	 * add a line of the JTable
	 */
	public abstract void add_table 			(Stair obj);
	
	/**
	 * delete a line of the JTable
	 */
	public abstract void delete_table 		(Stair obj);
	
	/**
	 * update a line of the JTable
	 */
	public abstract void update_table 		(Stair obj);

	/**
	 * @return the title_label
	 */
	public JLabel getTitle_label() {
		return title_label;
	}

	/**
	 * @param title_label the title_label to set
	 */
	public void setTitle_label(String title_string) {
		this.title_label.setText(title_string);
	}
		
}
