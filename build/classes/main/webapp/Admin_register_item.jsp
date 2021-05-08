<%@page import="javax.swing.JDialog"%>
<%@page import="javax.swing.JOptionPane"%>
<%@page import="POJO_MODEL.Employee"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register an item</title>
	<link type ="text/css" rel="stylesheet" href="resources/css&js&jquery/bootstrap/css/bootstrap.css" >
	<link type ="text/css" rel="stylesheet" href="resources/customized.css" >
	
	<%Employee employee = (Employee)session.getAttribute("employee");
	
	if(employee == null) {
		JOptionPane pane = new JOptionPane("Session has been closed, Please Login",JOptionPane.OK_OPTION);  
		JDialog dialog = pane.createDialog("Status");  
		dialog.setAlwaysOnTop(true);  
		dialog.show(); 
		
		request.getRequestDispatcher("Login.jsp").forward(request, response);
	}
	%>
	
		<script type="text/javascript">
		  function autoFill() {
			  
			  
		    document.getElementById('itemName').value = "item1";
		    document.getElementById('description').value = "About item1";
		    document.getElementById('units').value = "Cubes";
		    document.getElementById('lowStock').value = "100";
		
			    
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
                        <a class="nav-link" href="ProfileAdmin.jsp"><span class="fa fa-sign-in"></span> Profile</a>
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
                        <a class="nav-link nav-change"  href="Admin_home.jsp" role="button" aria-haspopup="true" aria-expanded="false" style="border-radius: 15px; text-align: center; background-color: white;color: #111E6C">Policies</a>   
                    </li>
                    <li class="nav-item " title="Click to See Your Duties">
                        <a class="nav-link nav-change"  href="Admin_register_employee.jsp" role="button" aria-haspopup="true" aria-expanded="false" style="border-radius: 15px; text-align: center; background-color: white;color: #111E6C">Create an employee</a>   
                    </li>
                    <li class="nav-item " title="Click to See Your Duties">
                        <a class="nav-link nav-change"  href="Admin_register_supplier.jsp" role="button" aria-haspopup="true" aria-expanded="false" style="border-radius: 15px; text-align: center; background-color: white;color: #111E6C">Create a supplier</a>   
                    </li>
                     <li class="nav-item " title="Click to See Your Duties">
                        <a class="nav-link nav-change"  href="Admin_register_site.jsp" role="button" aria-haspopup="true" aria-expanded="false" style="border-radius: 15px; text-align: center; background-color: white;color: #111E6C">Create a site</a>   
                    </li>
                    <li class="nav-item " title="Click to See Your Duties">
                        <a class="nav-link nav-change"  href="Admin_register_item.jsp" role="button" aria-haspopup="true" aria-expanded="false" style="border-radius: 15px; text-align: center; background-color: white;color: #111E6C">Create an item</a>   
                    </li>
                    
                    
                   
                </ul>
            </div>
        </header>
        
        <!-- Body ---------------------------------------------------------------------------------------------------------------- -->
        
          <div class="container-fluid" style="margin-bottom: 10px;min-height:510px;overflow: auto">
            
         <div class="container" style="margin-top: 50px">
            
<!-- 
	FORM FORM FORM FORM FORM FORM FORM FORM FORM FORM FORM FORM FORM FORM FORM FORM FORM FORM FORM FORM FORM FORM FORM FORM FORM FORM FORM FORM FORM FORM FORM
 -->
                <form action="AdminCreateItem" method="POST">
                <br>
                    <div style="float: left; margin-right: 5px;margin-left: 300px">
                        <div style="width: 550px; float: left; padding: 5px; border-width: 1px; border-style: solid; border-color: #111E6C; margin-bottom: 5px;">
                            <h5>Item Details</h5>
                            <div class="form-group row" style="padding: 4px; padding-left: 16px">
                                <label class="col-4 col-form-label" for="EmpForm01BasicDetails02">Item Name: *</label>
                                <div class="col-8">
                                	<input type="text" class="form-control" id="itemName" required="required" name="itemName">
                                </div>
                            </div>
                            
                            <div class="form-group row" style="padding: 4px; padding-left: 16px">
                                <label class="col-4 col-form-label" for="EmpForm01BasicDetails02">Item Description: *</label>
                                <div class="col-8">
                                	<input type="text" class="form-control" id="description" required="required" name="description">
                                </div>
                            </div>
                            
                            <div class="form-group row" style="padding: 4px; padding-left: 16px">
                                <label class="col-4 col-form-label" for="EmpForm01BasicDetails02">Units: *</label>
                                <div class="col-8">
                                	<input type="text" class="form-control" id="units" required="required" name="units">
                                </div>
                            </div>
                            
                            <div class="form-group row" style="padding: 4px; padding-left: 16px">
                                <label class="col-4 col-form-label" for="EmpForm01BasicDetails02">Re-Stock Level: *</label>
                                <div class="col-8">
                                	<input type="text" class="form-control" id="lowStock" required="required" name="lowStock">
                                </div>
                            </div>
                           
                            
                            
                        </div>

                 
                    </div>

                 

                       
			            <div style="clear: both; float: left; margin-top: 20px;margin-left: 470px">
			                <div class="form-group row">
			                    <div>
			                    	<input type="reset" value="Reset" style="background-color: white; border-radius: 10px; color: black; border-color: #111E6C; border-width: 1px; border-style: solid; font-size: 22px; margin-right:10px;color: #111E6C"/>
			                        <input type="submit" value="Submit" style="background-color: white; border-radius: 10px; color: black; border-color: #111E6C; border-width: 1px; border-style: solid; font-size: 22px; margin-right: 20px;color: #111E6C"/>
			                        <button type="button" onClick="autoFill();" style="background-color: white; border-radius: 10px; color: black; border-color: #111E6C; border-width: 1px; border-style: solid; font-size: 22px; margin-right: 20px;color: #111E6C">Demo</button>
			                    </div>
			                </div>
			            </div>
                    </div>
                        
                </form>
            </div>
        </div>
        
        <footer>
      	<div style="color: white;margin-left: 6px; " class="footer-copyright text-left py-1 footer_copyright" title="Disclaimer">© All Rights Reserved @2019 | CSSE-WE-01 | Privacy Policy.
                   
                </div>
      	</footer>
      
      	</footer>


	    <!-- Footer -->
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="resources/css&js&jquery/jquery-3.3.1.slim.min.js"></script>
	    <script src="resources/css&js&jquery/popper.min.js"></script>
	    <script src="resources/css&js&jquery/bootstrap.min.js"></script>
</body>
</html>