package CONTROLLER_SERVLET.ProcurementEmployee;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

import DAO_SERVICE.CRUD.RetreiveDAO;
import POJO_MODEL.Supplier;

/**
 * Servlet implementation class ProcurementEmployeeRequest
 */
public class ProcurementEmployeeRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProcurementEmployeeRequest() {
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
		System.out.println("Make Order");
		System.out.println(request.getParameter("siteRequestId"));
		HttpSession session = request.getSession();
		
		if(request.getParameter("status").contains("Order")) {
			JOptionPane pane = new JOptionPane("Already order placed, Please check the order history",JOptionPane.OK_OPTION);  
			JDialog dialog = pane.createDialog("Status");  
			dialog.setAlwaysOnTop(true);  
			dialog.show(); 
			
			request.getRequestDispatcher("ProcurementStaff_OrderRequest.jsp").forward(request, response);
		}
		
		try {
			
			session.setAttribute("requestMade", RetreiveDAO.getSingleRequestById(request.getParameter("siteRequestId"))); 
		
		request.getRequestDispatcher("ProcurementStaff_FetchSupplier.jsp").forward(request, response);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
