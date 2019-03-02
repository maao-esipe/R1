package connectionpoool;

import javax.swing.JOptionPane;

public class TestMain {

	public static void main(String [] args) {
		
		DataSource j=new DataSource();
		j.remplir();
		System.out.println(JDBCConnectionPool.connex);
		
		for (int k =0 ; k<3 ; k++) {
		Interface i= new Interface();
		i.setVisible(true);
		}
	
		
	}
}
