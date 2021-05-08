package CONTROLLER_SERVLET.SiteManager;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

import DAO_SERVICE.CRUD.UpdateDAO;
import POJO_MODEL.Request;
import POJO_MODEL.Converter.DateConverter;

/**
 * Servlet implementation class SiteManagerEditRequestSubmit
 */
public class SiteManagerEditRequestSubmit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SiteManagerEditRequestSubmit() {
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
		System.out.println("Edit Request");
		
		System.out.println(request.getParameter("requestId"));
		System.out.println(request.getParameter("reqItem"));
		System.out.println(request.getParameter("description"));
		System.out.println(request.getParameter("amount"));
		System.out.println(request.getParameter("deliveryDate"));
		
		try {
			UpdateDAO.UpdateRequest(new Request(request.getParameter("requestId"), request.getParameter("reqItem"), Integer.parseInt(request.getParameter("amount")), DateConverter.getSqlDateFromString(request.getParameter("deliveryDate")), request.getParameter("description")));
		
		
			JOptionPane pane = new JOptionPane("The request with id " + request.getParameter("requestId") + " was updated",JOptionPane.OK_OPTION);  
			JDialog dialog = pane.createDialog("Status");  
			dialog.setAlwaysOnTop(true);  
			dialog.show(); 
			
			request.getRequestDispatcher("SiteManager_RequestHistory.jsp").forward(request, response);
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
