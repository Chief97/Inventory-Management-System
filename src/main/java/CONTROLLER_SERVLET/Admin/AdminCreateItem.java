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
 * Servlet implementation class AdminCreateItem
 */
public class AdminCreateItem extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminCreateItem() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			System.out.println(GeneratePrimaryKey.generateItemId());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Create Item");
		
		System.out.println("Item Attributes ");
		System.out.println(request.getParameter("itemName"));
		System.out.println(request.getParameter("description"));
		System.out.println(request.getParameter("units"));
		System.out.println(request.getParameter("lowStock"));
		System.out.println("----------------------------------------------------------------------------------");
		
	
		
		try {
			String itemId = GeneratePrimaryKey.generateItemId();
			Item item = new Item(itemId, request.getParameter("itemName"), request.getParameter("description"), request.getParameter("units"),Integer.parseInt(request.getParameter("lowStock")));
			if(InsertDAO.insertNewItem(item)) {
				
				System.out.println("Successfully Inserted");
				for(Site site : RetreiveDAO.retreiveAllSite()) {
					InsertDAO.insertNewSiteInventory(	new SiteInventory(GeneratePrimaryKey.generateInventoryId(), site.getSiteId(), itemId, 0));
				}

				JOptionPane pane = new JOptionPane("Successfully item  " + item.getItemName()+ " was created",JOptionPane.OK_OPTION);  
				JDialog dialog = pane.createDialog("Status");  
				dialog.setAlwaysOnTop(true);  
				dialog.show(); 
				
				request.getRequestDispatcher("Admin_register_item.jsp").forward(request, response);
			}
				
			else {
				System.out.println("Unsuccessful");
				
				JOptionPane pane = new JOptionPane("Unsuccessful",JOptionPane.OK_OPTION);  
				JDialog dialog = pane.createDialog("Status");  
				dialog.setAlwaysOnTop(true);  
				dialog.show(); 
				
				request.getRequestDispatcher("Admin_register_item.jsp").forward(request, response);
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
