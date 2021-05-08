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
import DAO_SERVICE.CRUD.RetreiveDAO;
import DAO_SERVICE.Common.GeneratePrimaryKey;
import POJO_MODEL.Item;
import POJO_MODEL.Site;
import POJO_MODEL.SiteInventory;

/**
 * Servlet implementation class AdminCreateSite
 */
public class AdminCreateSite extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminCreateSite() {
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
		System.out.println("Create Site");
		
		System.out.println("Site Attributes ");
		System.out.println(request.getParameter("siteName"));
		System.out.println(request.getParameter("addressLine1"));
		System.out.println(request.getParameter("addressLine2"));
		System.out.println(request.getParameter("city"));
		System.out.println(request.getParameter("phone"));
		System.out.println("----------------------------------------------------------------------------------");
		
		
		
		try {
			String siteId = GeneratePrimaryKey.generateSiteId();
			Site site = new Site(siteId, request.getParameter("siteName"), request.getParameter("addressLine1"), request.getParameter("addressLine2"), request.getParameter("city"), request.getParameter("phone"));
			if(InsertDAO.insertNewSite(site)) {
				System.out.println("Successfully Inserted");
				for(Item item : RetreiveDAO.retreiveAllItem()) {
					
					InsertDAO.insertNewSiteInventory(	new SiteInventory(GeneratePrimaryKey.generateInventoryId(), siteId, item.getItemId(), 0));
				}

				JOptionPane pane = new JOptionPane("Successfully Site  " +site.getSiteName()+ " was created",JOptionPane.OK_OPTION);  
				JDialog dialog = pane.createDialog("Status");  
				dialog.setAlwaysOnTop(true);  
				dialog.show(); 
				
				request.getRequestDispatcher("Admin_register_site.jsp").forward(request, response);
			}
				
			else {
				System.out.println("Unsuccessful");
				JOptionPane pane = new JOptionPane("Unsuccessful",JOptionPane.OK_OPTION);  
				JDialog dialog = pane.createDialog("Status");  
				dialog.setAlwaysOnTop(true);  
				dialog.show(); 
				
				request.getRequestDispatcher("Admin_register_site.jsp").forward(request, response);
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
