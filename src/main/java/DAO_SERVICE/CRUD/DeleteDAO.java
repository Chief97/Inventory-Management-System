package DAO_SERVICE.CRUD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import DAO_SERVICE.Common.DBConnection;

public class DeleteDAO {
	
		public static boolean deleteRequest(String requestId) throws ClassNotFoundException, SQLException {
	
		String query;
		query = "DELETE FROM request where requestId=?";
	
		Connection con = DBConnection.connectDB();
		PreparedStatement pst = con.prepareStatement(query);
		pst.setString(1, requestId);
		pst.executeUpdate();
		
		
		return true;
		
		}
		
		public static boolean deleteEmployeeId(String employeeId) throws ClassNotFoundException, SQLException {
			
			String query;
			query = "DELETE FROM employee where employeeId=?";
		
			Connection con = DBConnection.connectDB();
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, employeeId);
			pst.executeUpdate();
			
			
			return true;
			
			}
		
			public static boolean deletePolicyId(String policyId) throws ClassNotFoundException, SQLException {
			
			String query;
			query = "DELETE FROM policy where policyId=?";
		
			Connection con = DBConnection.connectDB();
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, policyId);
			pst.executeUpdate();
			
			
			return true;
			
			}

}
