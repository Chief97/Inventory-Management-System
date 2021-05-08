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
import POJO_MODEL.Employee;
import POJO_MODEL.Converter.DateConverter;

/**
 * Servlet implementation class AdminCreateEmployee
 */
public class AdminCreateEmployee extends HttpServlet {
	private static final long serialVersionUID = 102831973239L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminCreateEmployee() {
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
		System.out.println("Create Employee");
		
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
		System.out.println(request.getParameter("site"));
		System.out.println(request.getParameter("designation"));
		System.out.println(request.getParameter("username"));
		System.out.println(request.getParameter("password"));
		System.out.println("----------------------------------------------------------------------------------");
		
		
		
		try {
			Employee employee = new Employee(GeneratePrimaryKey.generateEmployeeId(), request.getParameter("firstName"), request.getParameter("middleName"), request.getParameter("lastName"), request.getParameter("gender"), request.getParameter("addressStreet1"), request.getParameter("addressStreet2"), request.getParameter("city"), request.getParameter("province"), request.getParameter("zipCode"), request.getParameter("nic"),DateConverter.getSqlDateFromString(request.getParameter("dob")), request.getParameter("email"), request.getParameter("mobile"), request.getParameter("designation"), request.getParameter("site"), request.getParameter("username"), request.getParameter("password"));
			
			if(RetreiveDAO.checkUniqueUsername(employee.getUsername())) {
				if(InsertDAO.insertNewEmployee(employee)) {
					System.out.println("Successfully Inserted");
				
				
				JOptionPane pane = new JOptionPane("Successfully Employee username " + employee.getUsername()+ " was created",JOptionPane.OK_OPTION);  
				JDialog dialog = pane.createDialog("Status");  
				dialog.setAlwaysOnTop(true);  
				dialog.show(); 
				
				request.getRequestDispatcher("Admin_register_employee.jsp").forward(request, response);
				}
				else {
					System.out.println("Unsuccessful");
					JOptionPane pane = new JOptionPane("Unsuccessful",JOptionPane.OK_OPTION);  
					JDialog dialog = pane.createDialog("Status");  
					dialog.setAlwaysOnTop(true);  
					dialog.show(); 
					
					request.getRequestDispatcher("Admin_register_employee.jsp").forward(request, response);
				} 
			}
			else {
				System.out.println("Username is not unique");
				JOptionPane pane = new JOptionPane("Please enter an unique username",JOptionPane.OK_OPTION);  
				JDialog dialog = pane.createDialog("Status");  
				dialog.setAlwaysOnTop(true);  
				dialog.show(); 
				
				request.getRequestDispatcher("Admin_register_employee.jsp").forward(request, response);
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
