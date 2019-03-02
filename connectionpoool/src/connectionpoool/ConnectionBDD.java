package connectionpoool;

import java.sql.*;
import javax.swing.JOptionPane;
public class ConnectionBDD {
            public static Statement state1;
            public static ResultSet res;
            protected static Connection connect = null;
           
                
            public static Connection getInst(){
            	try {
                String url="jdbc:mysql://localhost:3306/test";
                String user="root";
                String password="";

                Object newInstance = Class.forName("com.mysql.jdbc.Driver");
            	connect= DriverManager.getConnection(url, user, password);

            	}
                catch (Exception e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(null,"Error occured while connecting to database","",JOptionPane.ERROR_MESSAGE);
                    
                }
                 return connect;  
            }
 


}
