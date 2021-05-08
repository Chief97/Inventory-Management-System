package CONTROLLER_SERVLET.ProcurementEmployee;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

import DAO_SERVICE.CRUD.RetreiveDAO;
import DAO_SERVICE.CRUD.UpdateDAO;
import POJO_MODEL.Order;
import POJO_MODEL.Payment;
import POJO_MODEL.Supplier;
import POJO_MODEL.Email.EmailClient;

/**
 * Servlet implementation class ProcurementEmployeeMakePayment
 */
public class ProcurementEmployeeMakePayment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProcurementEmployeeMakePayment() {
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
		System.out.println("Make Payment");
		System.out.println(	request.getParameter("paymentId"));
		
		try {
			Payment payment = RetreiveDAO.getPaymentByPaymentId(request.getParameter("paymentId"));
	
			Supplier supplier =  RetreiveDAO.getSingleSupplierById(payment.getSupplierId()) ;
			Order order = RetreiveDAO.getSingleOrderById(payment.getOrderId());
		
			String receiver = supplier.getEmail();
			String subject = "Payment for item purchased";
			String content = " Hello " + supplier.getSupplierName() + " Manager, \n"
					+ " The email has been sent to confirm the item delivered and to make the payment related to the Order Placed. \n"
					+ "\t Item Name : " + RetreiveDAO.getSingleItemById(supplier.getItemId()).getItemName() + " \n"
					+ "\t Amount Ordered : " + (payment.getDeliveredAmount()+payment.getRequireAmount()) + " \n"
					+ "\t Accepted amount :" + payment.getDeliveredAmount()  + " \n"
					+ "\t Unit Price : " + payment.getUnitPrice() + " \n"
					+ "\t Total Amount : " + payment.getUnitPrice()*payment.getDeliveredAmount() + " \n"
					+ "\n\n\n"
					+ "Thank You \n"
					+ request.getParameter("username");
		
			EmailClient.sendMail(receiver, subject, content);
			
			JOptionPane pane1 = new JOptionPane("Payment email successfully sent",JOptionPane.OK_OPTION);  
			JDialog dialog1 = pane1.createDialog("Status");  
			dialog1.setAlwaysOnTop(true);  
			dialog1.show(); 
		
			UpdateDAO.UpdatePaymentStatus(payment.getPaymentId(), "Payment Made");
		
			JOptionPane pane = new JOptionPane("Payment successfully added ",JOptionPane.OK_OPTION);  
			JDialog dialog = pane.createDialog("Status");  
			dialog.setAlwaysOnTop(true);  
			dialog.show(); 
			
			request.getRequestDispatcher("ProcurementStaff_Payment.jsp").forward(request, response);
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

}
