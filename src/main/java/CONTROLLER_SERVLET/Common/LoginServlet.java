package CONTROLLER_SERVLET.Common;

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
import POJO_MODEL.Employee;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		System.out.println("Login Servlet");
		System.out.println("Checking the attributes");
		System.out.println(request.getParameter("username"));
		System.out.println(request.getParameter("password"));
		System.out.println("---------------------------------------------");
		
		HttpSession session = request.getSession();
		
		try {
			Employee employee = RetreiveDAO.validateLogin(request.getParameter("username"), request.getParameter("password"));
		
			if(employee == null) {
				JOptionPane pane = new JOptionPane("Invalid credentials, please try again",JOptionPane.OK_OPTION);  
				JDialog dialog = pane.createDialog("Status");  
				dialog.setAlwaysOnTop(true);  
				dialog.show(); 
				
				request.getRequestDispatcher("Login.jsp").forward(request, response);
			}
			
			else {
				
				session.setAttribute("employee", employee);
				
				if(employee.getRole().equals("siteManager")) {
					
					request.getRequestDispatcher("SiteManager_Home.jsp").forward(request, response);
				}
				
				if(employee.getRole().equals("procurementEmployee")) {
									
					request.getRequestDispatcher("ProcurementStaff_Home.jsp").forward(request, response);
				}

				if(employee.getRole().equals("manager")) {
					
					request.getRequestDispatcher("Manager_Home.jsp").forward(request, response);
				}
				if(employee.getRole().equals("admin")) {
					
					request.getRequestDispatcher("Admin_home.jsp").forward(request, response);
				}
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
