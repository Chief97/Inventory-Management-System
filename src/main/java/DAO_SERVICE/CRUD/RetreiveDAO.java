package DAO_SERVICE.CRUD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DAO_SERVICE.Common.DBConnection;
import POJO_MODEL.Approval;
import POJO_MODEL.Employee;
import POJO_MODEL.Item;
import POJO_MODEL.Order;
import POJO_MODEL.Payment;
import POJO_MODEL.Policy;
import POJO_MODEL.Request;
import POJO_MODEL.Site;
import POJO_MODEL.SiteInventory;
import POJO_MODEL.Supplier;

public class RetreiveDAO {
	
	
	
	public static ArrayList<Item> retreiveAllItem() throws SQLException, ClassNotFoundException{
		String query;
		query = "SELECT * FROM item";
		ArrayList<Item> itemList = new ArrayList<Item>();
		
		
		Connection con = DBConnection.connectDB();
		PreparedStatement pst = con.prepareStatement(query);
		
		ResultSet rst = pst.executeQuery();
		
		while(rst.next()) {
			Item item = new Item(rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4),rst.getInt(5));
			itemList.add(item);
		}
		
		return itemList;
	}
	
	public static ArrayList<Site> retreiveAllSite() throws SQLException, ClassNotFoundException{
		String query;
		query = "SELECT * FROM site";
		ArrayList<Site> siteList = new ArrayList<Site>();
		
		
		Connection con = DBConnection.connectDB();
		PreparedStatement pst = con.prepareStatement(query);
		
		ResultSet rst = pst.executeQuery();
		
		while(rst.next()) {
			Site site = new Site(rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getString(5), rst.getString(6));
			siteList.add(site);
		}
		
		return siteList;
	}
	
	public static boolean checkUniqueUsername(String username) throws ClassNotFoundException, SQLException {
		
		String query;
		query = "SELECT * FROM employee where username = ? ";
		Connection con = DBConnection.connectDB();
		PreparedStatement pst = con.prepareStatement(query);
		
		pst.setString(1, username);
		ResultSet rst = pst.executeQuery();
		
		if (rst.next()==false) {
			return true;
		}
		return false;
		
	}
		public static Employee validateLogin (String username,String password) throws ClassNotFoundException, SQLException {
		
		String query;
		query = "SELECT * FROM employee where username = ? AND password = ? ";
		Connection con = DBConnection.connectDB();
		PreparedStatement pst = con.prepareStatement(query);
		
		pst.setString(1, username);
		pst.setString(2, password);
		ResultSet rst = pst.executeQuery();
		Employee employee = null;
		if (rst.next()==false) {
			return null;
		}
		rst = pst.executeQuery();
		if (rst.next()) {
			employee = new Employee(rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getString(5), rst.getString(6),rst.getString(7), rst.getString(8), rst.getString(9), rst.getString(10), rst.getString(11), rst.getDate(12), rst.getString(13), rst.getString(14), rst.getString(15), rst.getString(16), rst.getString(17), rst.getString(18));
		}
		
		return employee ;
		}
		
		public static Employee getEmployeeByUsername (String username) throws ClassNotFoundException, SQLException {
			
			String query;
			query = "SELECT * FROM employee where username = ? ";
			Connection con = DBConnection.connectDB();
			PreparedStatement pst = con.prepareStatement(query);
			
			pst.setString(1, username);
			
			ResultSet rst = pst.executeQuery();
			Employee employee = null;
			if (rst.next()==false) {
				return null;
			}
			rst = pst.executeQuery();
			if (rst.next()) {
				employee = new Employee(rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getString(5), rst.getString(6),rst.getString(7), rst.getString(8), rst.getString(9), rst.getString(10), rst.getString(11), rst.getDate(12), rst.getString(13), rst.getString(14), rst.getString(15), rst.getString(16), rst.getString(17), rst.getString(18));
			}
			
			return employee ;
			}
		
		public static ArrayList<Employee> retreiveAllEmployee() throws SQLException, ClassNotFoundException{
			String query;
			query = "SELECT * FROM employee where role != 'admin'";
			ArrayList<Employee> employeeList = new ArrayList<Employee>();
			
			
			Connection con = DBConnection.connectDB();
			PreparedStatement pst = con.prepareStatement(query);
			
			ResultSet rst = pst.executeQuery();
			
			while(rst.next()) {
				Employee employee = new Employee(rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getString(5), rst.getString(6),rst.getString(7), rst.getString(8), rst.getString(9), rst.getString(10), rst.getString(11), rst.getDate(12), rst.getString(13), rst.getString(14), rst.getString(15), rst.getString(16), rst.getString(17), rst.getString(18));
				employeeList.add(employee);
			}
			
			return employeeList;
		}
	
		public static Item getSingleItemById (String itemId) throws ClassNotFoundException, SQLException {
			String query;
			query = "SELECT * FROM item where itemId = ?";
			Connection con = DBConnection.connectDB();
			PreparedStatement pst = con.prepareStatement(query);
			
			pst.setString(1, itemId);
			ResultSet rst = pst.executeQuery();
			Item item = null;
			if (rst.next()) {
				item = new Item(rst.getString(1), rst.getString(2),  rst.getString(3),  rst.getString(4),  rst.getInt(5));
			}
			return item;
		}
		
		public static Site getSingleSiteById (String siteId) throws ClassNotFoundException, SQLException {
			String query;
			query = "SELECT * FROM site where siteId = ?";
			Connection con = DBConnection.connectDB();
			PreparedStatement pst = con.prepareStatement(query);
			
			pst.setString(1, siteId);
			ResultSet rst = pst.executeQuery();
			Site site = null;
			if (rst.next()) {
				site = new Site(rst.getString(1), rst.getString(2),  rst.getString(3),  rst.getString(4),  rst.getString(5),rst.getString(6));
			}
			return site;
		}
		
		public static SiteInventory getSingleInventorySiteById (String inventorySiteId) throws ClassNotFoundException, SQLException {
			String query;
			query = "SELECT * FROM siteinventory where siteInventoryId = ?";
			Connection con = DBConnection.connectDB();
			PreparedStatement pst = con.prepareStatement(query);
			
			pst.setString(1, inventorySiteId);
			ResultSet rst = pst.executeQuery();
			SiteInventory siteInventory = null;
			if (rst.next()) {
				siteInventory = new SiteInventory(rst.getString(1), rst.getString(2), rst.getString(3), rst.getInt(4));
			}
			return siteInventory;
		}
		
		public static SiteInventory getSingleInventorySiteByItemandSite (String itemId,  String siteId) throws ClassNotFoundException, SQLException {
			String query;
			query = "SELECT * FROM siteinventory where siteId = ? AND itemId = ?";
			Connection con = DBConnection.connectDB();
			PreparedStatement pst = con.prepareStatement(query);
			
			pst.setString(1, siteId);
			pst.setString(2, itemId);
			ResultSet rst = pst.executeQuery();
			SiteInventory siteInventory = null;
			if (rst.next()) {
				siteInventory = new SiteInventory(rst.getString(1), rst.getString(2), rst.getString(3), rst.getInt(4));
			}
			return siteInventory;
		}
		
		public static ArrayList<SiteInventory> getInventoryBySite (String siteId) throws ClassNotFoundException, SQLException{
			String query;
			query = "SELECT * FROM siteinventory where siteId = ?";
			ArrayList<SiteInventory> siteInventoryList = new ArrayList<SiteInventory>();
			
			Connection con = DBConnection.connectDB();
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, siteId);
			ResultSet rst = pst.executeQuery();
			
			if (rst.next()==false) {
				return null;
			}
			rst = pst.executeQuery();
			
			while (rst.next()) {
				
			  SiteInventory	inventory = new SiteInventory(rst.getString(1), rst.getString(2), rst.getString(3), rst.getInt(4));
			  
			  
			  
			  siteInventoryList.add(inventory);
			}
			
			return siteInventoryList;
			
		}
		
		public static ArrayList<Request> getRequestBySite (String siteId) throws ClassNotFoundException, SQLException{
			String query;
			query = "SELECT * FROM request where siteId = ?";
			ArrayList<Request> requestList = new ArrayList<Request>();
			
			Connection con = DBConnection.connectDB();
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, siteId);
			ResultSet rst = pst.executeQuery();
			
			if (rst.next()==false) {
				return null;
			}
			rst = pst.executeQuery();
			
			while (rst.next()) {
				
			  Request	request = new Request(rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getInt(5), rst.getDate(6), rst.getString(7), rst.getString(8));
			  
			  
			  
			  requestList.add(request);
			}
			
			return requestList;
			
		}
		
		public static ArrayList<Request> retreiveAllRequest () throws ClassNotFoundException, SQLException{
			String query;
			query = "SELECT * FROM request ";
			ArrayList<Request> requestList = new ArrayList<Request>();
			
			Connection con = DBConnection.connectDB();
			PreparedStatement pst = con.prepareStatement(query);
		
			ResultSet rst = pst.executeQuery();
			
			if (rst.next()==false) {
				return null;
			}
			rst = pst.executeQuery();
			
			while (rst.next()) {
				
			  Request	request = new Request(rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getInt(5), rst.getDate(6), rst.getString(7), rst.getString(8));
			  
			  
			  
			  requestList.add(request);
			}
			
			return requestList;
			
		}
		
		public static Request getSingleRequestById (String requestId) throws ClassNotFoundException, SQLException {
			String query;
			query = "SELECT * FROM request where requestId = ?";
			Connection con = DBConnection.connectDB();
			PreparedStatement pst = con.prepareStatement(query);
			
			pst.setString(1, requestId);
			ResultSet rst = pst.executeQuery();
			Request request = null;
			if (rst.next()) {
				request = new Request(rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getInt(5), rst.getDate(6), rst.getString(7), rst.getString(8));
			}
			return request;
		}
		
		public static Supplier getSingleSupplierById (String supplierId) throws ClassNotFoundException, SQLException {
			String query;
			query = "SELECT * FROM supplier where supplierId = ?";
			Connection con = DBConnection.connectDB();
			PreparedStatement pst = con.prepareStatement(query);
			
			pst.setString(1, supplierId);
			ResultSet rst = pst.executeQuery();
			Supplier supplier = null;
			if (rst.next()) {
				supplier = new Supplier(rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getString(5), rst.getString(7), rst.getString(6), rst.getString(8), rst.getFloat(9));
			}
			return supplier;
		}
		
		public static ArrayList<Supplier> retreiveAllSuppliersByItem (String itemId) throws ClassNotFoundException, SQLException{
			String query;
			query = "SELECT * FROM supplier where itemId=? ";
			ArrayList<Supplier> supplierList = new ArrayList<Supplier>();
			
			Connection con = DBConnection.connectDB();
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, itemId);
			ResultSet rst = pst.executeQuery();
			
			if (rst.next()==false) {
				return null;
			}
			rst = pst.executeQuery();
			
			while (rst.next()) {
				
			  Supplier supplier = new Supplier(rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getString(5), rst.getString(7), rst.getString(6), rst.getString(8), rst.getFloat(9));
			  
			  
			  
			  supplierList.add(supplier);
			}
			
			return supplierList;
			
		}
		
		public static ArrayList<Order> retreiveAllOrders () throws ClassNotFoundException, SQLException{
			String query;
			query = "SELECT * FROM procurementdb.order ";
			ArrayList<Order> orderList = new ArrayList<Order>();
			
			Connection con = DBConnection.connectDB();
			PreparedStatement pst = con.prepareStatement(query);
		
			ResultSet rst = pst.executeQuery();
			
			if (rst.next()==false) {
				return null;
			}
			rst = pst.executeQuery();
			
			while (rst.next()) {
				
			  Order	order = new Order(rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getString(5));
			  
			  
			  
			  orderList.add(order);
			}
			
			return orderList;
			
		}
		
		public static Order getSingleOrderById (String orderId) throws ClassNotFoundException, SQLException {
			String query;
			query = "SELECT * FROM procurementdb.order where orderId = ?";
			Connection con = DBConnection.connectDB();
			PreparedStatement pst = con.prepareStatement(query);
			
			pst.setString(1, orderId);
			ResultSet rst = pst.executeQuery();
			Order order = null;
			if (rst.next()) {
				order = new Order (rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getString(5));
			}
			return order;
		}
		
		public static Payment getPaymentByOrderId (String orderId) throws ClassNotFoundException, SQLException {
			String query;
			query = "SELECT * FROM payment where orderId = ?";
			Connection con = DBConnection.connectDB();
			PreparedStatement pst = con.prepareStatement(query);
			
			pst.setString(1, orderId);
			ResultSet rst = pst.executeQuery();
			Payment payment = null;
			if (rst.next()) {
				payment = new Payment(rst.getString(1), rst.getString(2), rst.getFloat(3), rst.getInt(4), rst.getInt(5), rst.getString(6), rst.getString(7));
			}
			return payment;
		}
		
		public static Payment getPaymentByPaymentId (String paymentId) throws ClassNotFoundException, SQLException {
			String query;
			query = "SELECT * FROM payment where paymentId = ?";
			Connection con = DBConnection.connectDB();
			PreparedStatement pst = con.prepareStatement(query);
			
			pst.setString(1, paymentId);
			ResultSet rst = pst.executeQuery();
			Payment payment = null;
			if (rst.next()) {
				payment = new Payment(rst.getString(1), rst.getString(2), rst.getFloat(3), rst.getInt(4), rst.getInt(5), rst.getString(6), rst.getString(7));
			}
			return payment;
		}
		
		public static ArrayList<Payment> retreiveAllPayment() throws ClassNotFoundException, SQLException{
			String query;
			query = "SELECT * FROM payment ";
			ArrayList<Payment> paymentList = new ArrayList<Payment>();
			
			Connection con = DBConnection.connectDB();
			PreparedStatement pst = con.prepareStatement(query);
		
			ResultSet rst = pst.executeQuery();
			
			if (rst.next()==false) {
				return null;
			}
			rst = pst.executeQuery();
			
			while (rst.next()) {
				
			  Payment	payment = new Payment(rst.getString(1), rst.getString(2), rst.getFloat(3), rst.getInt(4), rst.getInt(5), rst.getString(6), rst.getString(7));
			  
			  
			  
			  paymentList.add(payment);
			}
			
			return paymentList;
			
		}
		
		public static ArrayList<Approval> retreiveAllApproval() throws ClassNotFoundException, SQLException{
			String query;
			query = "SELECT * FROM approval ";
			ArrayList<Approval> approvalList = new ArrayList<Approval>();
			
			Connection con = DBConnection.connectDB();
			PreparedStatement pst = con.prepareStatement(query);
		
			ResultSet rst = pst.executeQuery();
			
			if (rst.next()==false) {
				return null;
			}
			rst = pst.executeQuery();
			
			while (rst.next()) {
				
			  Approval	approval = new Approval(rst.getString(1), rst.getString(2), rst.getString(4), rst.getString(3), rst.getString(5), rst.getString(6));
			  
			  
			  
			  approvalList.add(approval);
			}
			
			return approvalList;
			
		}
		
		public static Approval getSingleApprovalById (String approvalId) throws ClassNotFoundException, SQLException {
			String query;
			query = "SELECT * FROM approval where approvalId = ?";
			Connection con = DBConnection.connectDB();
			PreparedStatement pst = con.prepareStatement(query);
			
			pst.setString(1, approvalId);
			ResultSet rst = pst.executeQuery();
			Approval approval = null;
			if (rst.next()) {
				approval = new Approval(rst.getString(1), rst.getString(2), rst.getString(4), rst.getString(3), rst.getString(5), rst.getString(6));
			}
			return approval;
		}
		
		public static ArrayList<Policy> retreiveAllPolicy () throws ClassNotFoundException, SQLException{
			String query;
			query = "SELECT * FROM policy ";
			ArrayList<Policy> policyList = new ArrayList<Policy>();
			
			Connection con = DBConnection.connectDB();
			PreparedStatement pst = con.prepareStatement(query);
		
			ResultSet rst = pst.executeQuery();
			
			if (rst.next()==false) {
				return null;
			}
			rst = pst.executeQuery();
			
			while (rst.next()) {
				
			 Policy	policy = new Policy(rst.getString(1), rst.getString(2));
			  
			  
			  
			  policyList.add(policy);
			}
			
			return policyList;
			
		}
}
