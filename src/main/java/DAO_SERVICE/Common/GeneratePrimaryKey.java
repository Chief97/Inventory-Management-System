package DAO_SERVICE.Common;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;

public class GeneratePrimaryKey {

	public static String generateItemId() throws SQLException, ClassNotFoundException {
		String query;
		query = "SELECT * FROM item";
		Connection con =DBConnection.connectDB();
		PreparedStatement pst = con.prepareStatement(query);
		String LastId = null;
		String NewId = null;
		ResultSet rst= pst.executeQuery();
		
		if (rst.next()==false) {
			return "ITM001";
		}
		else {
			rst = pst.executeQuery();
			while(rst.next()) {
				LastId = rst.getString(1);
			}
		}
		System.out.println("Last id " + LastId);
		int x = Integer.parseInt(LastId.substring(3));
		x = x+1;
		DecimalFormat formatter = new DecimalFormat("000");
		 String newX = formatter.format(x);
		 NewId = LastId.substring(0,3)+ newX;
		 System.out.println("NewId " + NewId);
		return NewId;
	}
	
	public static String generateSiteId() throws SQLException, ClassNotFoundException {
		String query;
		query = "SELECT * FROM site";
		Connection con =DBConnection.connectDB();
		PreparedStatement pst = con.prepareStatement(query);
		String LastId = null;
		String NewId = null;
		ResultSet rst= pst.executeQuery();
		
		if (rst.next()==false) {
			return "SIT001";
		}
		else {
			rst = pst.executeQuery();
			while(rst.next()) {
				LastId = rst.getString(1);
			}
		}
		
		int x = Integer.parseInt(LastId.substring(3));
		x = x+1;
		DecimalFormat formatter = new DecimalFormat("000");
		 String newX = formatter.format(x);
		 NewId = LastId.substring(0,3)+ newX;
		return NewId;
	}
	
	public static String generateSupplierId() throws SQLException, ClassNotFoundException {
		String query;
		query = "SELECT * FROM supplier";
		Connection con =DBConnection.connectDB();
		PreparedStatement pst = con.prepareStatement(query);
		String LastId = null;
		String NewId = null;
		ResultSet rst= pst.executeQuery();
		
		if (rst.next()==false) {
			return "SUP001";
		}
		else {
			rst = pst.executeQuery();
			while(rst.next()) {
				LastId = rst.getString(1);
			}
		}
		
		int x = Integer.parseInt(LastId.substring(3));
		x = x+1;
		DecimalFormat formatter = new DecimalFormat("000");
		 String newX = formatter.format(x);
		 NewId = LastId.substring(0,3)+ newX;
		return NewId;
	}
	
	public static String generateEmployeeId() throws SQLException, ClassNotFoundException {
		String query;
		query = "SELECT * FROM employee";
		Connection con =DBConnection.connectDB();
		PreparedStatement pst = con.prepareStatement(query);
		String LastId = null;
		String NewId = null;
		ResultSet rst= pst.executeQuery();
		
		if (rst.next()==false) {
			return "EMP001";
		}
		else {
			rst = pst.executeQuery();
			while(rst.next()) {
				LastId = rst.getString(1);
			}
		}
		
		int x = Integer.parseInt(LastId.substring(3));
		x = x+1;
		DecimalFormat formatter = new DecimalFormat("000");
		 String newX = formatter.format(x);
		 NewId = LastId.substring(0,3)+ newX;
		return NewId;
	}
	
	public static String generateInventoryId() throws SQLException, ClassNotFoundException {
		String query;
		query = "SELECT * FROM siteinventory";
		Connection con =DBConnection.connectDB();
		PreparedStatement pst = con.prepareStatement(query);
		String LastId = null;
		String NewId = null;
		ResultSet rst= pst.executeQuery();
		
		if (rst.next()==false) {
			return "INV001";
		}
		else {
			rst = pst.executeQuery();
			while(rst.next()) {
				LastId = rst.getString(1);
			}
		}
		
		int x = Integer.parseInt(LastId.substring(3));
		x = x+1;
		DecimalFormat formatter = new DecimalFormat("000");
		 String newX = formatter.format(x);
		 NewId = LastId.substring(0,3)+ newX;
		return NewId;
	}
	
	public static String generateRequestId() throws SQLException, ClassNotFoundException {
		String query;
		query = "SELECT * FROM request";
		Connection con =DBConnection.connectDB();
		PreparedStatement pst = con.prepareStatement(query);
		String LastId = null;
		String NewId = null;
		ResultSet rst= pst.executeQuery();
		
		if (rst.next()==false) {
			return "REQ001";
		}
		else {
			rst = pst.executeQuery();
			while(rst.next()) {
				LastId = rst.getString(1);
			}
		}
		
		int x = Integer.parseInt(LastId.substring(3));
		x = x+1;
		DecimalFormat formatter = new DecimalFormat("000");
		 String newX = formatter.format(x);
		 NewId = LastId.substring(0,3)+ newX;
		return NewId;
	}
	
	public static String generateOrderId() throws SQLException, ClassNotFoundException {
		String query;
		query = "SELECT * FROM procurementdb.order";
		Connection con =DBConnection.connectDB();
		PreparedStatement pst = con.prepareStatement(query);
		String LastId = null;
		String NewId = null;
		ResultSet rst= pst.executeQuery();
		
		if (rst.next()==false) {
			return "ORD001";
		}
		else {
			rst = pst.executeQuery();
			while(rst.next()) {
				LastId = rst.getString(1);
			}
		}
		
		int x = Integer.parseInt(LastId.substring(3));
		x = x+1;
		DecimalFormat formatter = new DecimalFormat("000");
		 String newX = formatter.format(x);
		 NewId = LastId.substring(0,3)+ newX;
		return NewId;
	}
	
	public static String generatePaymentId() throws SQLException, ClassNotFoundException {
		String query;
		query = "SELECT * FROM payment";
		Connection con =DBConnection.connectDB();
		PreparedStatement pst = con.prepareStatement(query);
		String LastId = null;
		String NewId = null;
		ResultSet rst= pst.executeQuery();
		
		if (rst.next()==false) {
			return "PAY001";
		}
		else {
			rst = pst.executeQuery();
			while(rst.next()) {
				LastId = rst.getString(1);
			}
		}
		
		int x = Integer.parseInt(LastId.substring(3));
		x = x+1;
		DecimalFormat formatter = new DecimalFormat("000");
		 String newX = formatter.format(x);
		 NewId = LastId.substring(0,3)+ newX;
		return NewId;
	}
	
	public static String generateApprovalId() throws SQLException, ClassNotFoundException {
		String query;
		query = "SELECT * FROM approval";
		Connection con =DBConnection.connectDB();
		PreparedStatement pst = con.prepareStatement(query);
		String LastId = null;
		String NewId = null;
		ResultSet rst= pst.executeQuery();
		
		if (rst.next()==false) {
			return "APP001";
		}
		else {
			rst = pst.executeQuery();
			while(rst.next()) {
				LastId = rst.getString(1);
			}
		}
		
		int x = Integer.parseInt(LastId.substring(3));
		x = x+1;
		DecimalFormat formatter = new DecimalFormat("000");
		 String newX = formatter.format(x);
		 NewId = LastId.substring(0,3)+ newX;
		return NewId;
	}
	
	public static String generatePolicyId() throws SQLException, ClassNotFoundException {
		String query;
		query = "SELECT * FROM policy";
		Connection con =DBConnection.connectDB();
		PreparedStatement pst = con.prepareStatement(query);
		String LastId = null;
		String NewId = null;
		ResultSet rst= pst.executeQuery();
		
		if (rst.next()==false) {
			return "POL001";
		}
		else {
			rst = pst.executeQuery();
			while(rst.next()) {
				LastId = rst.getString(1);
			}
		}
		
		int x = Integer.parseInt(LastId.substring(3));
		x = x+1;
		DecimalFormat formatter = new DecimalFormat("000");
		 String newX = formatter.format(x);
		 NewId = LastId.substring(0,3)+ newX;
		return NewId;
	}
	
}
