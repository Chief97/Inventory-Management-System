package DAO_SERVICE.Common;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class DBConnection {

private static Connection connection;
	
	public static Connection connectDB() throws SQLException, ClassNotFoundException {
		
		String url="jdbc:mysql://localhost:3306/procurementdb?autoReconnect=true&useSSL=false";
		String user="root";
		String pass="atheeq123456";
		
		
		if(connection== null || connection.isClosed()) {
		
				Class.forName("com.mysql.jdbc.Driver");
				connection = DriverManager.getConnection(url, user, pass);
			
			
		}
		
	
		return connection;
		
	}
	
}
