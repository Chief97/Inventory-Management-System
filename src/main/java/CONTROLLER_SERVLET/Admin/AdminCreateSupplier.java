package CONTROLLER_SERVLET.Admin;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

import DAO_SERVICE.CRUD.InsertDAO;
import DAO_SERVICE.Common.GeneratePrimaryKey;
import POJO_MODEL.Supplier;

/**
 * Servlet implementation class AdminCreateSupplier
 */
public class AdminCreateSupplier extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminCreateSupplier() {
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
		System.out.println("Create Supplier");
		
		System.out.println("Supplier Attributes ");
		System.out.println(request.getParameter("companyName"));
		System.out.println(request.getParameter("addressLine1"));
		System.out.println(request.getParameter("addressLine2"));
		System.out.println(request.getParameter("city"));
		System.out.println(request.getParameter("mobile"));
		System.out.println(request.getParameter("email"));
		System.out.println(request.getParameter("itemName"));
		System.out.println(request.getParameter("itemPrice"));
		System.out.println("----------------------------------------------------------------------------------");
		
	
		
		try {
			Supplier supplier = new Supplier(GeneratePrimaryKey.generateSupplierId(), request.getParameter("companyName"), request.getParameter("addressLine1"), request.getParameter("addressLine2"), request.getParameter("city"), request.getParameter("email"), request.getParameter("mobile"), request.getParameter("itemName"), Float.parseFloat(request.getParameter("itemPrice")));
			if(InsertDAO.insertNewSupplier(supplier)) {
				System.out.println("Successfully Inserted");
			JOptionPane pane = new JOptionPane("Successfully Supplier  " +supplier.getSupplierName()+ " was created",JOptionPane.OK_OPTION);  
			JDialog dialog = pane.createDialog("Status");  
			dialog.setAlwaysOnTop(true);  
			dialog.show(); 
			
			request.getRequestDispatcher("Admin_register_supplier.jsp").forward(request, response);
			}
			else {
				System.out.println("Unsuccessful");
				
				JOptionPane pane = new JOptionPane("Unsuccessful",JOptionPane.OK_OPTION);  
				JDialog dialog = pane.createDialog("Status");  
				dialog.setAlwaysOnTop(true);  
				dialog.show(); 
				
				request.getRequestDispatcher("Admin_register_supplier.jsp").forward(request, response);
			}
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
