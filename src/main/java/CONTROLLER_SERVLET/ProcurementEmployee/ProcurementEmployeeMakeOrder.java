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
 * Servlet implementation class ProcurementEmployeeMakeOrder
 */
public class ProcurementEmployeeMakeOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProcurementEmployeeMakeOrder() {
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
		// TODO Auto-generated method stub
		System.out.println("Make order");
		
		if(Float.parseFloat(request.getParameter("total"))  > 100000) {
			JOptionPane pane = new JOptionPane("Order value is greater than 100,000 LKR, Order sent to Manager's approval",JOptionPane.OK_OPTION);  
			JDialog dialog = pane.createDialog("Status");  
			dialog.setAlwaysOnTop(true);  
			dialog.show(); 
			
			try {
				
				Supplier supplier = RetreiveDAO.getSingleSupplierById(request.getParameter("supplierId"));
				Request requestSite = RetreiveDAO.getSingleRequestById(request.getParameter("requestId"));
				Site site = RetreiveDAO.getSingleSiteById(requestSite.getSiteId());
				Item item =  RetreiveDAO.getSingleItemById(request.getParameter("itemId"));
				
				String approvalId = GeneratePrimaryKey.generateApprovalId() ;
				UpdateDAO.UpdateRequestStatus(requestSite.getRequestId(), "Request pending for Manager's Approval");
				Approval approval = new Approval(approvalId, supplier.getSupplierId(), item.getItemId(), requestSite.getRequestId(), site.getSiteId(), "Pending for approval");
			
				InsertDAO.insertNewApproval(approval);
				
				JOptionPane pane1 = new JOptionPane("Approval has been sent",JOptionPane.OK_OPTION);  
				JDialog dialog1 = pane1.createDialog("Status");  
				dialog1.setAlwaysOnTop(true);  
				dialog1.show(); 
				
				request.getRequestDispatcher("ProcurementStaff_OrderRequest.jsp").forward(request, response);
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else {
			try {
				
				Supplier supplier = RetreiveDAO.getSingleSupplierById(request.getParameter("supplierId"));
				Request requestSite = RetreiveDAO.getSingleRequestById(request.getParameter("requestId"));
				Site site = RetreiveDAO.getSingleSiteById(requestSite.getSiteId());
				Item item =  RetreiveDAO.getSingleItemById(request.getParameter("itemId"));
		
			String receiver = request.getParameter("email");
			String subject = "Ordering Raw Materials for a Procurement Company";
			String content = " Hello " + supplier.getSupplierName() + " Manager, \n"
							+ " Our Company is requiring the following item, Please Deliver the Item before the mentioned date. \n"
							+ "The prices mentioned below are the agreed price for a span of one Year \n\n"
							+ "Note -  Payment will be made after receiving the item \n \n \n"
							+ "\t Item Name : " + item.getItemName() + " \n"
							+ "\t Amount Needed : " + requestSite.getAmount() + " \n"
							+ "\t Unit Price : " + supplier.getUnitPrice() + " \n"
							+ "\t Total Amount : " + request.getParameter("total") + " \n"
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
			
			InsertDAO.insertNewOrder(new Order(orderId, request.getParameter("username"), request.getParameter("supplierId"), "Order Placed", request.getParameter("requestId")));
		
			
			
			JOptionPane pane1 = new JOptionPane("Order successfuly added",JOptionPane.OK_OPTION);  
			JDialog dialog1 = pane1.createDialog("Status");  
			dialog1.setAlwaysOnTop(true);  
			dialog1.show(); 
			
			request.getRequestDispatcher("ProcurementStaff_OrderRequest.jsp").forward(request, response);
			
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
