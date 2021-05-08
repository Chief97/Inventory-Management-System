<%@page import="DAO_SERVICE.CRUD.RetreiveDAO"%>
<%@page import="POJO_MODEL.Policy"%>
<%@page import="javax.swing.JDialog"%>
<%@page import="javax.swing.JOptionPane"%>
<%@page import="POJO_MODEL.Employee"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="ISO-8859-1">

<title>Manager Home</title>
	<link type ="text/css" rel="stylesheet" href="resources/css&js&jquery/bootstrap/css/bootstrap.css" >
	<link type ="text/css" rel="stylesheet" href="resources/customized.css" >
	
	<%
		Employee employee = (Employee)session.getAttribute("employee");
	
	if(employee == null) {
		JOptionPane pane = new JOptionPane("Session has been closed, Please Login",JOptionPane.OK_OPTION);  
		JDialog dialog = pane.createDialog("Status");  
		dialog.setAlwaysOnTop(true);  
		dialog.show(); 
		
		request.getRequestDispatcher("Login.jsp").forward(request, response);
	}
	
	%>
	
</head>
<body>

	<nav class="navbar fixed-top navbar-expand-md navbar-dark fixed-stuff">
            <div class="navbar-collapse collapse w-100 order-1 order-md-0 dual-collapse2 ">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item active">
                        <a class="nav-link" href="" title="Go to Common Homepage">Common Home</a>
                    </li>
                    
                </ul>
            </div>
            <div class="mx-auto order-0">
                <a class="navbar-brand mx-auto" href="" title="Go to Common Homepage">Procurement System</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target=".dual-collapse2">
                    <span class="navbar-toggler-icon"></span>
                </button>
            </div>
            <div class="navbar-collapse collapse w-100 order-3 dual-collapse2">
                <ul class="navbar-nav ml-auto">
                    <li class="nav-item" title="Profile">
                        <span class="nav-link">Hello <%=employee.getUsername() %></span>
                    </li>
                    <li class="nav-item" title="Profile">
                        <a class="nav-link" href="ProfileManager.jsp"><span class="fa fa-sign-in"></span> Profile</a>
                    </li>
                    <li class="nav-item" title="Logout">
                        <a class="nav-link" href="LogoutServlet"><span class="fa fa-sign-in"></span> Logout</a>
                    </li>
                </ul>
            </div>
        </nav>
        
        <header class="page-header" id="header01">
            <div class="header-mid">
            	<br>
                <h2 style="color:white;text-decoration: bold;margin-left: 15px">Procurement Management System </h2>      
            </div>

           <div class="container-fluid" style="margin-top:10px;">
                <ul class="nav nav-pills  nav-justified nav-header">
                
             <li class="nav-item" title="Click to See Your Duties">
                        <a class="nav-link nav-change"  href="Manager_Home.jsp" role="button" aria-haspopup="true" aria-expanded="false" style="border-radius: 15px; text-align: center; background-color: white;color: #111E6C">Policies</a>   
                    </li>
                
                <li class="nav-item" title="Click to See Your Duties">
                        <a class="nav-link nav-change"  href="Manager_ViewOrder.jsp" role="button" aria-haspopup="true" aria-expanded="false" style="border-radius: 15px; text-align: center; background-color: white;color: #111E6C">View Order</a>   
                    </li>
                    
                       <li class="nav-item" title="Click to See Your Duties">
                        <a class="nav-link nav-change"  href="Manager_ViewRequest.jsp" role="button" aria-haspopup="true" aria-expanded="false" style="border-radius: 15px; text-align: center; background-color: white;color: #111E6C">View Request</a>   
                    </li>
                
              	<li class="nav-item" title="Click to See Your Duties">
                        <a class="nav-link nav-change"  href="Manager_ViewPayment.jsp" role="button" aria-haspopup="true" aria-expanded="false" style="border-radius: 15px; text-align: center; background-color: white;color: #111E6C">View Payments</a>   
                     </li>
                    
                   
                    
                    <li class="nav-item" title="Click to See Your Duties">
                        <a class="nav-link nav-change"  href="Manager_ApproveOrder.jsp" role="button" aria-haspopup="true" aria-expanded="false" style="border-radius: 15px; text-align: center; background-color: white;color: #111E6C">Approve Order</a>   
                    </li>
                   
                </ul>
            </div>
        </header>
        
        <!-- Body ---------------------------------------------------------------------------------------------------------------- -->
        
          <div class="container-fluid" style="margin-bottom: 10px;min-height:510px;overflow: auto">
          <br>
          <h4> <b>Following are the company policies </b> </h4> 
          
          <br> 
          
            <table style="border-weight:thick;border-color:black;text-align:center;" cellpadding="20px" cellspacing="20px" align="center" border="1"  >
            	<tr>
                    <th style="font=weight:bold;">Policy</th>
                    <th style="font=weight:bold;">Edit </th>
                    <th style="font=weight:bold;">Delete</th>
                    <th style="font=weight:bold;">ADD</th>
                   
                   
                  </tr>
                  
                <%if(RetreiveDAO.retreiveAllPolicy() == null){ %>
                	
                	 <br>
                	  <h4 style="margin-left: 680px">No Policies Found</h4>
                	<%
                } else { 
                	for(Policy policy : RetreiveDAO.retreiveAllPolicy()) {
                
                %>
                	 <tr>
                	 <form method="post" action="ManagerEditPolicy">
                	 <td width="800px" ><input type="text" class="form-control" id="policy" required="required" width="300px" name="policy" value="<%=policy.getPolicy() %>">
                	 <input type="text" class="form-control" id="policy" required="required" name="policyId" value="<%=policy.getPolicyId() %>" hidden>
                	 </td>
                	<td>  <input type="submit" class="nav-link nav_change" style="border-radius: 15px; text-align: center;font-weight:bold;color::#fd4f00;background-color:white;width:100px;border-weight:10px;border-color:#111E6C" value="Edit"></td>
                	</form>
                	<td> 
                		<form action="ManagerDeletePolicy" method="post">
                	<input type="text" class="form-control" id="policy" required="required" name="policyId" value="<%=policy.getPolicyId() %>" hidden>
                	<input type="submit" class="nav-link nav_change" style="border-radius: 15px; text-align: center;font-weight:bold;color::#fd4f00;background-color:white;width:100px;border-weight:10px;border-color:#111E6C" value="Delete">
                		</form>
                	</td>
                	<td></td>
                	 </tr>
                	
                	
                	<%
                	}
                }%>
                 
                  <tr>
                	 <form method="post" action="ManagerAddPolicy">
                	 <td><input type="text" class="form-control" id="policy" required="required" name="policy" ></td>
                	 <td></td>
                	  <td></td>
                	<td>  <input type="submit" class="nav-link nav_change" style="border-radius: 15px; text-align: center;font-weight:bold;color::#fd4f00;background-color:white;width:100px;border-weight:10px;border-color:#111E6C" value="Add"></td>
                	</form>
                	</tr>
          </table>
          
         </div>
        
       <footer>
      	<div style="color: white;margin-left: 6px; " class="footer-copyright text-left py-1 footer_copyright" title="Disclaimer">© All Rights Reserved @2019 | CSSE-WE-01 | Privacy Policy.
                   
        </div>
      	</footer>
      

	    <!-- Footer -->
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="resources/css&js&jquery/jquery-3.3.1.slim.min.js"></script>
	    <script src="resources/css&js&jquery/popper.min.js"></script>
	    <script src="resources/css&js&jquery/bootstrap.min.js"></script>
</body>
</html>