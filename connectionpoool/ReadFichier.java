package connectionpoool;



import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.util.Enumeration;
import java.util.Properties;
import javax.swing.JOptionPane;
public class ReadFichier {
protected static String value;
protected static String key;
protected static Enumeration<?> enumeration ;
public static Connection c;
	
	public void readFile(String champ1, String champ2) throws IOException
	{
		
	Properties p = new Properties();
	
try (FileInputStream fis = new FileInputStream("properties.xml"))
{
	p.loadFromXML(fis);
	 enumeration = p.propertyNames();
	 
	  while (enumeration.hasMoreElements()){
		key =(String) enumeration.nextElement();
		 value = p.getProperty(key);
	  
		while(key.equals(champ1) && value.equals(champ2)) {
 			
 			
 			if (JDBCConnectionPool.connex.size()!=0) {
 				Interface2 k2 = new Interface2();
 				c=DataSource.renvoieConex();
 				System.out.println(c);
 				}
 				else {
 					JOptionPane.showMessageDialog(null,"Le nombre max de connexion est atteint  veuillez ressayer plus tard ");
 				}
 			break;
		} 
		  
	
	}
	
	}
	}
}


	


