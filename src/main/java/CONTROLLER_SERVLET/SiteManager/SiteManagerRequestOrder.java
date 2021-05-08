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
import DAO_SERVICE.Common.GeneratePrimaryKey;
import POJO_MODEL.Request;
import POJO_MODEL.Converter.DateConverter;

/**
 * Servlet implementation class SiteManagerRequestOrder
 */
public class SiteManagerRequestOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SiteManagerRequestOrder() {
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
		System.out.println("Request Order");
		System.out.println("Check Parameters");
		
		System.out.println(request.getParameter("reqItem"));
		System.out.println(request.getParameter("description"));
		System.out.println(request.getParameter("amount"));
		System.out.println(request.getParameter("deliveryDate"));
		System.out.println(request.getParameter("requestedBy"));
		System.out.println(request.getParameter("site"));
		
		try {
			String id = GeneratePrimaryKey.generateRequestId();
			InsertDAO.insertNewRequest(new Request(id, request.getParameter("requestedBy"), request.getParameter("site"), request.getParameter("reqItem"), Integer.parseInt(request.getParameter("amount")), DateConverter.getSqlDateFromString(request.getParameter("deliveryDate")), "Pending - Procurement Staff", request.getParameter("description")));
	
			JOptionPane pane = new JOptionPane("Successfully request with Id  " + id + " was created",JOptionPane.OK_OPTION);  
			JDialog dialog = pane.createDialog("Status");  
			dialog.setAlwaysOnTop(true);  
			dialog.show(); 
			
			request.getRequestDispatcher("SiteManager_RequestOrder.jsp").forward(request, response);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
