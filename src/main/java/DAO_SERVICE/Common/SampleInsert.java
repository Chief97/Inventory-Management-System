package DAO_SERVICE.Common;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.*;

public class SampleInsert {

	public static String query1="INSERT INTO  users VALUES(?,?)";
	
	public static  boolean insertNewItem(String username, String pass) throws ClassNotFoundException, SQLException {
		Connection con = DBConnection.connectDB();
		PreparedStatement pst = con.prepareStatement(query1);
		pst.setString(1, username);
		pst.setString(2, pass);
		
		pst.execute();
		return true;
	}
	
}
