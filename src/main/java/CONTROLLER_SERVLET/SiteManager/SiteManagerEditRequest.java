package CONTROLLER_SERVLET.SiteManager;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

import DAO_SERVICE.CRUD.RetreiveDAO;
import POJO_MODEL.Request;

/**
 * Servlet implementation class SiteManagerEditRequest
 */
public class SiteManagerEditRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SiteManagerEditRequest() {
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
		HttpSession session = request.getSession();
		if(request.getParameter("status").contains("Order")) {
			
			JOptionPane pane = new JOptionPane("The request has been transfered as an order, Please contact the procurement staff",JOptionPane.OK_OPTION);  
			JDialog dialog = pane.createDialog("Status");  
			dialog.setAlwaysOnTop(true);  
			dialog.show(); 
			
			request.getRequestDispatcher("SiteManager_RequestHistory.jsp").forward(request, response);
		}else {
		
		try {
			Request siteRequest = RetreiveDAO.getSingleRequestById(request.getParameter("requestId"));
			session.setAttribute("siteRequest", siteRequest);
			
			request.getRequestDispatcher("SiteManager_RequestOrder_Edit.jsp").forward(request, response);
			
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
