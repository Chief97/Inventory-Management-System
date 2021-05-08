package CONTROLLER_SERVLET.ProcurementEmployee;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

import DAO_SERVICE.CRUD.InsertDAO;
import DAO_SERVICE.CRUD.RetreiveDAO;
import DAO_SERVICE.CRUD.UpdateDAO;
import DAO_SERVICE.Common.GeneratePrimaryKey;
import POJO_MODEL.Approval;
import POJO_MODEL.Item;
import POJO_MODEL.Order;
import POJO_MODEL.Request;
import POJO_MODEL.Site;
import POJO_MODEL.Supplier;
import POJO_MODEL.Email.EmailClient;

/**
 * Servlet implementation class ProcurementEmployeeMakeApprovedOrder
 */
public class ProcurementEmployeeMakeApprovedOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProcurementEmployeeMakeApprovedOrder() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Make Approved Order");
		
		try {
			Approval approval =RetreiveDAO.getSingleApprovalById(request.getParameter("approvalId"));
			
			Supplier supplier = RetreiveDAO.getSingleSupplierById(approval.getSupplierId());
			Request requestSite = RetreiveDAO.getSingleRequestById(approval.getRequestId());
			Site site = RetreiveDAO.getSingleSiteById(requestSite.getSiteId());
			Item item =  RetreiveDAO.getSingleItemById(approval.getItemId());
	
		String receiver = supplier.getEmail();
		String subject = "Ordering Raw Materials for a Procurement Company";
		String content = " Hello " + supplier.getSupplierName() + " Manager, \n"
						+ " Our Company is requiring the following item, Please Deliver the Item before the mentioned date. \n"
						+ "The prices mentioned below are the agreed price for a span of one Year \n\n"
						+ "Note -  Payment will be made after receiving the item \n \n \n"
						+ "\t Item Name : " + item.getItemName() + " \n"
						+ "\t Amount Needed : " + requestSite.getAmount() + " \n"
						+ "\t Unit Price : " + supplier.getUnitPrice() + " \n"
						+ "\t Total Amount : " + (requestSite.getAmount()* supplier.getUnitPrice()) + " \n"
						+ "\t Site Name : " + site.getSiteName() + " \n"
						+ "\t Delivery Address : " +  site.getAddressStreet1()+" , " + site.getAddressStreet2() +" , " + site.getCity() + " \n"
						+ "\t Delivery Date : " + requestSite.getDateNeeded().toString() + " \n"
						+ "\n\n\n"
						+ "Thank You \n"
						+ request.getParameter("username");
		
		EmailClient.sendMail(receiver, subject, content);
		
		JOptionPane pane = new JOptionPane("Order email sent successfully",JOptionPane.OK_OPTION);  
		JDialog dialog = pane.createDialog("Status");  
		dialog.setAlwaysOnTop(true);  
		dialog.show(); 
		
		
		String orderId= GeneratePrimaryKey.generateOrderId();
		UpdateDAO.UpdateRequestStatus(requestSite.getRequestId(), "Request transfered as Order - " + orderId);
		UpdateDAO.UpdateApprovalStatus(approval.getApprovalId(), "Approval Request transfered as Order - " + orderId);
		
		InsertDAO.insertNewOrder(new Order(orderId, request.getParameter("username"), supplier.getSupplierId(), "Order Placed", requestSite.getRequestId()));
	
		
		
		JOptionPane pane1 = new JOptionPane("Order successfuly added",JOptionPane.OK_OPTION);  
		JDialog dialog1 = pane1.createDialog("Status");  
		dialog1.setAlwaysOnTop(true);  
		dialog1.show(); 
		
		request.getRequestDispatcher("ProcurementStaff_PendingApproval.jsp").forward(request, response);
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}

}
