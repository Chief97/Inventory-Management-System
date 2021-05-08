package CONTROLLER_SERVLET.SiteManager;

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
import POJO_MODEL.Order;
import POJO_MODEL.Payment;
import POJO_MODEL.SiteInventory;

/**
 * Servlet implementation class SiteManagerAcceptDelivery
 */
public class SiteManagerAcceptDelivery extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SiteManagerAcceptDelivery() {
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
		System.out.println("Accept Delivery");
		
		if(Integer.parseInt(request.getParameter("deliveredAmount") )+ Integer.parseInt(request.getParameter("returnAmount"))  == Integer.parseInt(request.getParameter("totalAmount"))  ) {
			System.out.println("Correct");
			System.out.println(request.getParameter("orderId"));
			
			try {
				Order order = RetreiveDAO.getSingleOrderById(request.getParameter("orderId"));
				
				String paymentId = GeneratePrimaryKey.generatePaymentId();
				
				Payment payment = new Payment(paymentId, request.getParameter("orderId"), RetreiveDAO.getSingleSupplierById(RetreiveDAO.getSingleOrderById(request.getParameter("orderId")).getSupplierId()).getUnitPrice(), Integer.parseInt(request.getParameter("deliveredAmount") ), Integer.parseInt(request.getParameter("returnAmount")), RetreiveDAO.getSingleSupplierById(RetreiveDAO.getSingleOrderById(request.getParameter("orderId")).getSupplierId()).getSupplierId(),"Payment Pending");
				
				InsertDAO.insertNewPayment(payment);
				
				SiteInventory siteInventory = RetreiveDAO.getSingleInventorySiteByItemandSite(request.getParameter("itemId"), request.getParameter("siteId"));
				UpdateDAO.UpdateSiteInventory(siteInventory.getSiteInventoryId(), siteInventory.getAmount() + Integer.parseInt(request.getParameter("deliveredAmount")));
				
				UpdateDAO.UpdateOrderStatus(request.getParameter("orderId"), "Order Received") ;
				JOptionPane pane = new JOptionPane("Order Received and Payment request with Id " + paymentId+ " has been made",JOptionPane.OK_OPTION);  
				JDialog dialog = pane.createDialog("Status");  
				dialog.setAlwaysOnTop(true);  
				dialog.show(); 
				
				request.getRequestDispatcher("SiteManager_PendingDelivery.jsp").forward(request, response);
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			JOptionPane pane = new JOptionPane("The amount entered does not sum up, Please enter appropiate amount",JOptionPane.OK_OPTION);  
			JDialog dialog = pane.createDialog("Status");  
			dialog.setAlwaysOnTop(true);  
			dialog.show(); 
			
			request.getRequestDispatcher("SiteManager_PendingDelivery.jsp").forward(request, response);
			
		}
	}

}
