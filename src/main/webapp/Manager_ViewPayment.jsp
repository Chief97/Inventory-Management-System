<%@page import="POJO_MODEL.Supplier"%>
<%@page import="POJO_MODEL.Payment"%>
<%@page import="DAO_SERVICE.CRUD.RetreiveDAO"%>
<%@page import="javax.swing.JDialog"%>
<%@page import="javax.swing.JOptionPane"%>
<%@page import="POJO_MODEL.Employee"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="ISO-8859-1">

<title>Manager View Payment</title>
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
              <br><br>
             <table style="border-weight:thick;border-color:black;text-align:center;" cellpadding="20px" cellspacing="20px" align="center" border="1"  >
            	<tr>
                   <th style="font=weight:bold;">Payment Id</th>
                    <th style="font=weight:bold;">Order Id</th>
                    <th style="font=weight:bold;">Original Units</th>
                    <th style="font=weight:bold;">Delivered Units</th>
                    <th style="font=weight:bold;">Unit Price</th>
                    <th style="font=weight:bold;">Amount Payable</th>
                    <th style="font=weight:bold;">Supplier Name</th>
                    <th style="font=weight:bold;">Supplier Email</th>
                    <th style="font=weight:bold;">Status</th>
                   
                  </tr>
                  
                  <% if(RetreiveDAO.retreiveAllPayment() == null) { %>
                	  </table>
                	  <br>
                	  <h4 style="margin-left: 680px">No Payment Found</h4>
               		 <%
                  } else { 
                  		for(Payment payment : RetreiveDAO.retreiveAllPayment()){
                  			Supplier supplier = RetreiveDAO.getSingleSupplierById(payment.getSupplierId());
                  %>
                   <tr>
                	  <td><%=payment.getPaymentId() %></td>
                	  <td><%=payment.getOrderId() %></td>
                	 
                	  <td><%=payment.getDeliveredAmount() + payment.getRequireAmount() %></td>
                	  <td><%=payment.getDeliveredAmount() %></td>
                	  <td><%=payment.getUnitPrice() %></td>
                	  <td><%=payment.getUnitPrice() * payment.getDeliveredAmount() %></td>
                	  <td><%=supplier.getSupplierName() %></td>
                	  <td><%=supplier.getEmail() %></td>
                	  <td><%=payment.getStatus() %></td>
                	  
                	  </tr>
                	<%
                  		}
                  } 
                  %>
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