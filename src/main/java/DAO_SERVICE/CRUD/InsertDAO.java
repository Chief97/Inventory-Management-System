package DAO_SERVICE.CRUD;

import java.security.Policy;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;



import DAO_SERVICE.Common.DBConnection;
import POJO_MODEL.Approval;
import POJO_MODEL.Employee;
import POJO_MODEL.Item;
import POJO_MODEL.Order;
import POJO_MODEL.Payment;
import POJO_MODEL.Request;
import POJO_MODEL.Site;
import POJO_MODEL.SiteInventory;
import POJO_MODEL.Supplier;


public class InsertDAO {
	
	public static boolean  insertNewEmployee( Employee employee) throws ClassNotFoundException, SQLException {
		
		String query;
		
		Connection con = DBConnection.connectDB();
			query = "INSERT INTO employee VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, employee.getEmployeeId());
			pst.setString(2, employee.getFirstName());
			pst.setString(3, employee.getMiddleName());
			pst.setString(4, employee.getLastName());
			pst.setString(5, employee.getGender());
			pst.setString(6, employee.getAddressStreet1());
			pst.setString(7, employee.getAddressStreet2());
			pst.setString(8, employee.getCity());
			pst.setString(9, employee.getProvince());
			pst.setString(10, employee.getZipCode());
			pst.setString(11, employee.getNic());
			pst.setDate(12, employee.getDob());
			pst.setString(13, employee.getEmail());
			pst.setString(14, employee.getPhone());
			pst.setString(15, employee.getRole());
			pst.setString(16, employee.getSite());
			pst.setString(17, employee.getUsername());
			pst.setString(18, employee.getPassword());
			pst.execute();
		
		return true;
		
	} 
	
	public static boolean  insertNewSupplier( Supplier supplier) throws ClassNotFoundException, SQLException {
	String query;
	query = "INSERT INTO supplier VALUES (?,?,?,?,?,?,?,?,?)";
		Connection con = DBConnection.connectDB();
		
		PreparedStatement pst = con.prepareStatement(query);
		pst.setString(1, supplier.getSupplierId());
		pst.setString(2, supplier.getSupplierName());
		pst.setString(3, supplier.getAddressStreet1());
		pst.setString(4, supplier.getAddressStreet2());
		pst.setString(5, supplier.getCity());
		pst.setString(6, supplier.getPhone());
		pst.setString(7, supplier.getEmail());
		pst.setString(8, supplier.getItemId());
		pst.setFloat(9, supplier.getUnitPrice());
		pst.execute();
		return true;
	}
	
	public static boolean  insertNewItem( Item item) throws ClassNotFoundException, SQLException {
	String query;
	query = "INSERT INTO item VALUES (?,?,?,?,?)";
		Connection con = DBConnection.connectDB();
		PreparedStatement pst = con.prepareStatement(query);
		
		pst.setString(1, item.getItemId());
		pst.setString(2, item.getItemName());
		pst.setString(3, item.getDescription());
		pst.setString(4, item.getUnits());
		pst.setInt(5, item.getLowStock());
		pst.execute();
		return true;
	}
	
	public static boolean  insertNewSite( Site site) throws ClassNotFoundException, SQLException {
	String query;
	query = "INSERT INTO site VALUES (?,?,?,?,?,?)";
		Connection con = DBConnection.connectDB();
		PreparedStatement pst = con.prepareStatement(query);
		
		pst.setString(1,site.getSiteId());
		pst.setString(2,site.getSiteName());
		pst.setString(3,site.getAddressStreet1());
		pst.setString(4,site.getAddressStreet2());
		pst.setString(5,site.getCity());
		pst.setString(6,site.getPhone());
		
		pst.execute();
		return true;
	}
	
	public static boolean  insertNewSiteInventory( SiteInventory inventory) throws ClassNotFoundException, SQLException {
		String query;
		query = "INSERT INTO siteinventory VALUES (?,?,?,?)";
			Connection con = DBConnection.connectDB();
			PreparedStatement pst = con.prepareStatement(query);
			
			pst.setString(1,inventory.getSiteInventoryId());
			pst.setString(2,inventory.getSiteId());
			pst.setString(3,inventory.getItemId());
			pst.setInt(4,inventory.getAmount());
		
			
			pst.execute();
			return true;
		}
	
	public static boolean  insertNewRequest(Request request ) throws ClassNotFoundException, SQLException {
		String query;
		query = "INSERT INTO request VALUES (?,?,?,?,?,?,?,?)";
			Connection con = DBConnection.connectDB();
			PreparedStatement pst = con.prepareStatement(query);
			
			pst.setString(1,request.getRequestId());
			pst.setString(2,request.getRequestedBy());
			pst.setString(3,request.getSiteId());
			pst.setString(4,request.getItemId());
			pst.setInt(5,request.getAmount());
			pst.setDate(6,request.getDateNeeded());
			pst.setString(7,request.getStatus());
			pst.setString(8,request.getDescription());
		
			
			pst.execute();
			return true;
		}
	
	public static boolean  insertNewOrder(Order order) throws ClassNotFoundException, SQLException {
		String query;
		query = "INSERT INTO procurementdb.order VALUES (?,?,?,?,?)";
			Connection con = DBConnection.connectDB();
			PreparedStatement pst = con.prepareStatement(query);
			
			pst.setString(1,order.getOrderId());
			pst.setString(2,order.getPlacedBy());
			pst.setString(3,order.getSupplierId());
			pst.setString(4,order.getStatus());
			pst.setString(5,order.getRequestId());
		
		
			
			pst.execute();
			return true;
		}
	
	public static boolean  insertNewPayment(Payment payment) throws ClassNotFoundException, SQLException {
		String query;
		query = "INSERT INTO payment VALUES (?,?,?,?,?,?,?)";
			Connection con = DBConnection.connectDB();
			PreparedStatement pst = con.prepareStatement(query);
			
			pst.setString(1,payment.getPaymentId());
			pst.setString(2,payment.getOrderId());
			pst.setFloat(3,payment.getUnitPrice());
			pst.setInt(4,payment.getDeliveredAmount());
			pst.setInt(5,payment.getRequireAmount());
			pst.setString(6,payment.getSupplierId());
			pst.setString(7,payment.getStatus());
		
		
			
			pst.execute();
			return true;
		}
	
	public static boolean  insertNewApproval(Approval approval) throws ClassNotFoundException, SQLException {
		String query;
		query = "INSERT INTO approval VALUES (?,?,?,?,?,?)";
			Connection con = DBConnection.connectDB();
			PreparedStatement pst = con.prepareStatement(query);
			
			pst.setString(1,approval.getApprovalId());
			pst.setString(2,approval.getSupplierId());
			pst.setString(3,approval.getRequestId());
			pst.setString(4,approval.getItemId());
			pst.setString(5,approval.getSiteId());
			pst.setString(6,approval.getApproval());
			
		
		
			
			pst.execute();
			return true;
		}
	
	public static boolean  insertNewPolicy(POJO_MODEL.Policy policy) throws ClassNotFoundException, SQLException {
		String query;
		query = "INSERT INTO policy VALUES (?,?)";
			Connection con = DBConnection.connectDB();
			PreparedStatement pst = con.prepareStatement(query);
			
			pst.setString(1,policy.getPolicyId());
			pst.setString(2,policy.getPolicy());
	
		
		
			
			pst.execute();
			return true;
		}
}
