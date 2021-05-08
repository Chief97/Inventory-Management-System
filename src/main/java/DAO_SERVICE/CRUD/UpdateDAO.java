package DAO_SERVICE.CRUD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import DAO_SERVICE.Common.DBConnection;
import POJO_MODEL.Employee;
import POJO_MODEL.Request;


public class UpdateDAO {
	
	
	public static boolean  UpdateSiteInventory( String inventoryId, int newAmount) throws ClassNotFoundException, SQLException {
		String query;
		query = "UPDATE siteinventory set amount=? where siteInventoryId=?";
		Connection con = DBConnection.connectDB();
		PreparedStatement pst = con.prepareStatement(query);
		
		pst.setInt(1, newAmount);
		pst.setString(2, inventoryId);
		
		pst.executeUpdate();
		
		return true;
	}
	
	public static boolean  UpdateRequest( Request siteRequest) throws ClassNotFoundException, SQLException {
		String query;
		query = "UPDATE request set itemId=?, amount=? ,dateNeeded=?, description=?  where requestId=?";
		Connection con = DBConnection.connectDB();
		PreparedStatement pst = con.prepareStatement(query);
		
		pst.setString(1, siteRequest.getItemId());
		pst.setInt(2, siteRequest.getAmount());
		pst.setDate(3, siteRequest.getDateNeeded());
		pst.setString(4, siteRequest.getDescription());
		pst.setString(5, siteRequest.getRequestId());
		
		pst.executeUpdate();
		
		return true;
	}
	
	
	public static boolean  UpdateRequestStatus( String requestId, String status) throws ClassNotFoundException, SQLException {
		String query;
		query = "UPDATE request set status =?  where requestId=?";
		Connection con = DBConnection.connectDB();
		PreparedStatement pst = con.prepareStatement(query);
		
		pst.setString(1, status);
		pst.setString(2, requestId);
	
		
		pst.executeUpdate();
		
		return true;
	}
	
	public static boolean  UpdateOrderStatus( String orderId, String status) throws ClassNotFoundException, SQLException {
		String query;
		query = "UPDATE procurementdb.order set status =?  where orderId=?";
		Connection con = DBConnection.connectDB();
		PreparedStatement pst = con.prepareStatement(query);
		
		pst.setString(1, status);
		pst.setString(2, orderId);
	
		
		pst.executeUpdate();
		
		return true;
	}
	
	public static boolean  UpdatePaymentStatus( String paymentId, String status) throws ClassNotFoundException, SQLException {
		String query;
		query = "UPDATE payment set status =?  where paymentId=?";
		Connection con = DBConnection.connectDB();
		PreparedStatement pst = con.prepareStatement(query);
		
		pst.setString(1, status);
		pst.setString(2, paymentId);
	
		
		pst.executeUpdate();
		
		return true;
	}
	
	public static boolean  UpdateApprovalStatus( String approvalId, String status) throws ClassNotFoundException, SQLException {
		String query;
		query = "UPDATE approval set approval =?  where approvalId=?";
		Connection con = DBConnection.connectDB();
		PreparedStatement pst = con.prepareStatement(query);
		
		pst.setString(1, status);
		pst.setString(2, approvalId);
	
		
		pst.executeUpdate();
		
		return true;
	}
	
	public static boolean  UpdatePolicyById( String policyId, String policy) throws ClassNotFoundException, SQLException {
		String query;
		query = "UPDATE policy set policy =?  where policyId=?";
		Connection con = DBConnection.connectDB();
		PreparedStatement pst = con.prepareStatement(query);
		
		pst.setString(1, policy);
		pst.setString(2, policyId);
	
		
		pst.executeUpdate();
		
		return true;
	}
	
	public static boolean  UpdateEmployee( Employee employee) throws ClassNotFoundException, SQLException {
		String query;
		query = "UPDATE employee set firstName=? , middleName=? , lastName=? , gender=? , addressStreet01=? , addressStreet02=? , addressCity=? , province=? ,zipCode=?,nic=? ,dob=? ,email=?,phone=?   where employeeId=?";
		Connection con = DBConnection.connectDB();
		PreparedStatement pst = con.prepareStatement(query);
		
		pst.setString(1, employee.getFirstName());
		pst.setString(2, employee.getMiddleName());
		pst.setString(3, employee.getLastName());
		pst.setString(4, employee.getGender());
		pst.setString(5, employee.getAddressStreet1());
		pst.setString(6, employee.getAddressStreet2());
		pst.setString(7, employee.getCity());
		pst.setString(8, employee.getProvince());
		pst.setString(9, employee.getZipCode());
		pst.setString(10, employee.getNic());
		pst.setDate(11, employee.getDob());
		pst.setString(12, employee.getEmail());
		pst.setString(13, employee.getPhone());
		pst.setString(14, employee.getEmployeeId());
		
		pst.executeUpdate();
		
		return true;
	}

}
