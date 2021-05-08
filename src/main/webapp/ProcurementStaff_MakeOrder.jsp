<%@page import="POJO_MODEL.Item"%>
<%@page import="POJO_MODEL.Request"%>
<%@page import="DAO_SERVICE.CRUD.RetreiveDAO"%>
<%@page import="POJO_MODEL.Supplier"%>
<%@page import="java.util.ArrayList"%>
<%@page import="javax.swing.JDialog"%>
<%@page import="javax.swing.JOptionPane"%>
<%@page import="POJO_MODEL.Employee"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="ISO-8859-1">

<title>Procurement Make Order</title>
	<link type ="text/css" rel="stylesheet" href="resources/css&js&jquery/bootstrap/css/bootstrap.css" >
	<link type ="text/css" rel="stylesheet" href="resources/customized.css" >
	
	<%
		Employee employee = (Employee)session.getAttribute("employee");
		Request requestMade = (Request) session.getAttribute("requestMade");
		Supplier supplierFetched = (Supplier) session.getAttribute("fetchedSupplier");
		
		Item item = RetreiveDAO.getSingleItemById(requestMade.getItemId());
		
		String email = supplierFetched.getEmail();
		float unitPrice = supplierFetched.getUnitPrice();
		float total = unitPrice * requestMade.getAmount();
	if(employee == null) {
		JOptionPane pane = new JOptionPane("Session has been closed, Please Login",JOptionPane.OK_OPTION);  
		JDialog dialog = pane.createDialog("Status");  
		dialog.setAlwaysOnTop(true);  
		dialog.show(); 
		
		request.getRequestDispatcher("Login.jsp").forward(request, response);
	}
	
	%>
	

		<script type="text/javascript">
		  function fetchSupplier() {
			  
			  <% String supplierId=request.getParameter("supplierId");
			  	System.out.println(supplierId);
			  %>
			  
			  document.getElementById('email').value = <%=supplierId %>;
		    
		  }
		</script>
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
                        <a class="nav-link" href="ProfileProcurement.jsp"><span class="fa fa-sign-in"></span> Profile</a>
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
                        <a class="nav-link nav-change"  href="ProcurementStaff_Home.jsp" role="button" aria-haspopup="true" aria-expanded="false" style="border-radius: 15px; text-align: center; background-color: white;color: #111E6C">Policies</a>   
                    </li>
                
                    <li class="nav-item " title="Click to See Your Duties">
                        <a class="nav-link nav-change"  href="ProcurementStaff_OrderRequest.jsp" role="button" aria-haspopup="true" aria-expanded="false" style="border-radius: 15px; text-align: center; background-color: white;color: #111E6C">Order Request</a>   
                    </li>
                    <li class="nav-item " title="Click to See Your Duties">
                        <a class="nav-link nav-change"  href="ProcurementStaff_OrderHistory.jsp" role="button" aria-haspopup="true" aria-expanded="false" style="border-radius: 15px; text-align: center; background-color: white;color: #111E6C">Order History</a>   
                    </li>
                     <li class="nav-item " title="Click to See Your Duties">
                        <a class="nav-link nav-change"  href="ProcurementStaff_Suppliers.jsp" role="button" aria-haspopup="true" aria-expanded="false" style="border-radius: 15px; text-align: center; background-color: white;color: #111E6C">View Suppliers</a>   
                    </li>
                     <li class="nav-item " title="Click to See Your Duties">
                        <a class="nav-link nav-change"  href="ProcurementStaff_Payment.jsp" role="button" aria-haspopup="true" aria-expanded="false" style="border-radius: 15px; text-align: center; background-color: white;color: #111E6C">Pending Payments</a>   
                    </li>
                   
                    <li class="nav-item " title="Click to See Your Duties">
                        <a class="nav-link nav-change"  href="ProcurementStaff_PendingApproval.jsp" role="button" aria-haspopup="true" aria-expanded="false" style="border-radius: 15px; text-align: center; background-color: white;color: #111E6C">Manager - Pending</a>   
                    </li>
                    
                   
                </ul>
            </div>
        </header>
        
        <!-- Body ---------------------------------------------------------------------------------------------------------------- -->
        
          <div class="container-fluid" style="margin-bottom: 10px;min-height:510px;overflow: auto">
            
             <form action="ProcurementEmployeeMakeOrder" method="POST">
                <br><br>
                    <div style="float: left; margin-right: 5px;margin-left: 550px">
                        <div style="width: 550px; float: left; padding: 5px; border-width: 1px; border-style: solid; border-color: #111E6C; margin-bottom: 5px;">
                            <h5>Order Details</h5>
                            <div class="form-group row" style="padding: 4px; padding-left: 16px">
                                <label class="col-4 col-form-label" for="EmpForm01BasicDetails02">Ordering Item: *</label>
                                <div class="col-8">
                                	<input type="text" value="<%=item.getItemId() %>" class="form-control" id="itemId" required="required" name="itemId" readonly hidden>
                                	<input type="text" value="<%=item.getItemName() %>" class="form-control" id="itemName" required="required" name="itemName" readonly>
                                </div>
                            </div>
                            
                            <div class="form-group row" style="padding: 4px; padding-left: 16px">
                                <label class="col-4 col-form-label" for="EmpForm01BasicDetails02">Units: *</label>
                                <div class="col-8">
                                	<input type="number" class="form-control" id="units" required="required" name="units" value="<%=requestMade.getAmount() %>" readonly>
                                </div>
                            </div>
                            
                             <div class="form-group row" style="padding: 4px; padding-left: 16px">
                                <label class="col-4 col-form-label" for="EmpForm01BasicDetails02">Date Needed: *</label>
                                <div class="col-8">
                                	<input type="Date" value="<%=requestMade.getDateNeeded() %>" class="form-control" id="reqDate" required="required" name="reqDate" readonly>
                                </div>
                            </div>
                            
                            <div class="form-group row" style="padding: 4px; padding-left: 16px">
                                <label class="col-4 col-form-label" for="EmpForm01BasicDetails02">Supplier Name: *</label>
                        
                                <input type="number" class="form-control" id="units" required="required" name="units" value="<%=requestMade.getAmount() %>" readonly hidden>
                                <div class="col-8">
                                
                                	<select   class="custom-select mr-sm-2" required="required" id="supplierId" name="supplierId">
                                        <option value="<%=supplierFetched.getSupplierId() %>"   ><%=supplierFetched.getSupplierName() %></option>
                                       
                                        
                                    </select>
                                   
                                    <input name="requestId" value="<%=requestMade.getRequestId() %>" hidden>
                                    <input name="itemId" value="<%=item.getItemId() %>" hidden>
                                    <input name="username" value="<%=employee.getUsername() %>" hidden>
                                </div>
                                 
                                
                                	
                                
                            </div>
                            
                            <div class="form-group row" style="padding: 4px; padding-left: 16px">
                                <label class="col-4 col-form-label" for="EmpForm01BasicDetails02">Unit Price: *</label>
                                <div class="col-8">
                                	<input type="number" value="<%=unitPrice %>" class="form-control" id="price" required="required" name="price" readonly>
                                </div>
                            </div>
                            
                            <div class="form-group row" style="padding: 4px; padding-left: 16px">
                                <label class="col-4 col-form-label" for="EmpForm01BasicDetails02">Total Amount : *</label>
                                <div class="col-8">
                                	<input type="number" value="<%=total %>" class="form-control" id="total" required="required" name="total" readonly>
                                </div>
                            </div>
                            
                            <div class="form-group row" style="padding: 4px; padding-left: 16px">
                                <label class="col-4 col-form-label" for="EmpForm01BasicDetails02">Supplier Email: *</label>
                                <div class="col-8">
                                	<input type="text" class="form-control" id="email" required="required" name="email" value="<%=email %>" readonly >
                                </div>
                            </div>
                            
                           
                           
                            
                            
                        </div>

                 
                    </div>

                 

                       
			            <div style="clear: both; float: left; margin-top: 20px;margin-left: 600px">
			                <div class="form-group row">
			                    <div>
			                    	
			                        <input type="submit" value="Make Order" style="background-color: white; border-radius: 10px; color: black; border-color: #111E6C; border-width: 1px; border-style: solid; font-size: 22px; margin-right: 20px;color: #111E6C"/>
			                        
			                    </div>
			                </div>
			            </div>
                    </div>
                        
                </form>
            
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