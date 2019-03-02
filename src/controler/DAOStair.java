package controler;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Stair;

public class DAOStair extends DAO<Stair>{
	/** 
	 * 
	 */
	private PreparedStatement preparedStatement = null;
	
	/** 
	 * 
	 */
	public DAOStair() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	// Add Stair in database
	@Override
	public boolean create(Stair obj) throws SQLException {
		boolean to_return = false;
		if(!ifFind(obj)) {
			// TODO Auto-generated method stub
			preparedStatement = connect
	                .prepareStatement("insert into  maao.stair (stair_name) values (?)");
	       // Parameter name
	        preparedStatement.setString(1, obj.getStair_name());
	        preparedStatement.executeUpdate();
			to_return = true;
		}
		return to_return;
	}

	@Override
	public boolean delete(Stair obj) throws SQLException {
		// TODO Auto-generated method stub
		//Remove
		boolean to_return = false;
		if(ifFind(obj)) {
			preparedStatement = connect.prepareStatement("delete from maao.stair where stair_name = ? ; ");
        	preparedStatement.setString(1, obj.getStair_name());
        	preparedStatement.executeUpdate();
        	to_return = true;
		}
		return to_return;
	}

	@Override
	public Stair find(int stair_id) throws SQLException {
		Stair stair = new Stair();
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(Stair obj) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean ifFind(Stair obj) throws SQLException {
		// TODO Auto-generated method stub
		// verification of the presence of the same value in the data base
		boolean to_return = false;
		preparedStatement = connect
                .prepareStatement("SELECT count(stair_name) as number from maao.stair where stair_name= ?");
		preparedStatement.setString(1, obj.getStair_name());
		ResultSet resultSet = preparedStatement.executeQuery();
		resultSet.next();
		if (resultSet.getInt("number") != 0) {
        	to_return = true;
        }
		return to_return;
	}

	@Override
	public void close() throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Stair> presentData() throws SQLException {
		// TODO Auto-generated method stub
		ResultSet 	resultSet 	= null	;
		ArrayList<Stair> table 	= new ArrayList<Stair>();
		Stair stair				= new Stair(); 
		preparedStatement = connect
                .prepareStatement("SELECT * from maao.stair ");
		resultSet = preparedStatement.executeQuery();
		while(resultSet.next()) {
            table.add(new Stair(resultSet.getInt("stair_id"		),resultSet.getString("stair_name")) );
            
            System.out.println("resul sql : "+resultSet.getString("stair_name"));
		}
		System.out.println(table);
		return table;
	}
}
