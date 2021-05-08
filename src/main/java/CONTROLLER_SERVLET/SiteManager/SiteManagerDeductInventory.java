package CONTROLLER_SERVLET.SiteManager;

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
import POJO_MODEL.SiteInventory;

/**
 * Servlet implementation class SiteManagerDeductInventory
 */
public class SiteManagerDeductInventory extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SiteManagerDeductInventory() {
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
		System.out.println("Deduct Servlet");
		System.out.println(request.getParameter("itemId"));
		System.out.println(request.getParameter("amount"));
		
		int updateAmount;
		
		try {
			SiteInventory siteInventory = RetreiveDAO.getSingleInventorySiteById(request.getParameter("itemId"));
				updateAmount =  siteInventory.getAmount() - Integer.parseInt(request.getParameter("amount")) ;
				UpdateDAO.UpdateSiteInventory(request.getParameter("itemId"), updateAmount);
				
				System.out.println(updateAmount);
				
				JOptionPane pane = new JOptionPane("Successfully Updated",JOptionPane.OK_OPTION);  
				JDialog dialog = pane.createDialog("Status");  
				dialog.setAlwaysOnTop(true);  
				dialog.show(); 
				
				request.getRequestDispatcher("SiteManager_Inventory.jsp").forward(request, response);
				
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
