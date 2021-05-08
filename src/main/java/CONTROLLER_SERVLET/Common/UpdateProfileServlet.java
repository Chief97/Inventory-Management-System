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
import DAO_SERVICE.CRUD.UpdateDAO;
import POJO_MODEL.Employee;
import POJO_MODEL.Converter.DateConverter;

/**
 * Servlet implementation class UpdateProfileServlet
 */
public class UpdateProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateProfileServlet() {
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
		HttpSession session = request.getSession();
		System.out.println("Update Profile");
		
		System.out.println("Employee Attributes ");
		System.out.println(request.getParameter("firstName"));
		System.out.println(request.getParameter("middleName"));
		System.out.println(request.getParameter("lastName"));
		System.out.println(request.getParameter("gender"));
		System.out.println(request.getParameter("addressStreet1"));
		System.out.println(request.getParameter("addressStreet2"));
		System.out.println(request.getParameter("city"));
		System.out.println(request.getParameter("province"));
		System.out.println(request.getParameter("zipCode"));
		System.out.println(request.getParameter("mobile"));
		System.out.println(request.getParameter("email"));
		System.out.println(request.getParameter("nic"));
		System.out.println(request.getParameter("dob"));

		System.out.println("----------------------------------------------------------------------------------");
		
		try {
			UpdateDAO.UpdateEmployee(new Employee(request.getParameter("employeeId"), request.getParameter("firstName"), request.getParameter("middleName"), request.getParameter("lastName"), request.getParameter("gender"), request.getParameter("addressStreet1"), request.getParameter("addressStreet2"), request.getParameter("city"), request.getParameter("province"), request.getParameter("zipCode"), request.getParameter("nic"), DateConverter.getSqlDateFromString(request.getParameter("dob")), request.getParameter("email"), request.getParameter("mobile")));
		Employee employee = RetreiveDAO.getEmployeeByUsername(request.getParameter("username"));
				session.setAttribute("employee", employee);
				
				JOptionPane pane = new JOptionPane("Successfully Employee was updated",JOptionPane.OK_OPTION);  
				JDialog dialog = pane.createDialog("Status");  
				dialog.setAlwaysOnTop(true);  
				dialog.show(); 
				if(employee.getRole().equals("admin")) {
					request.getRequestDispatcher("ProfileAdmin.jsp").forward(request, response);
				}
				
				if(employee.getRole().equals("siteManager")) {
					request.getRequestDispatcher("ProfileSiteManager.jsp").forward(request, response);
				}
				
				if(employee.getRole().equals("procurementEmployee")) {
					request.getRequestDispatcher("ProfileProcurement.jsp").forward(request, response);
				}
				
				if(employee.getRole().equals("manager")) {
					request.getRequestDispatcher("Profile.jsp").forward(request, response);
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
