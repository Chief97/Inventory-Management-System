<%@page import="javax.swing.JDialog"%>
<%@page import="javax.swing.JOptionPane"%>
<%@page import="POJO_MODEL.Employee"%>
<%@page import="DAO_SERVICE.CRUD.RetreiveDAO"%>
<%@page import="POJO_MODEL.Site"%>
<%@page import="POJO_MODEL.Item"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Profile</title>
	<link type ="text/css" rel="stylesheet" href="resources/css&js&jquery/bootstrap/css/bootstrap.css" >
	<link type ="text/css" rel="stylesheet" href="resources/customized.css" >
	
	<%
		ArrayList<Item> itemList = RetreiveDAO.retreiveAllItem();
		ArrayList<Site> siteList = RetreiveDAO.retreiveAllSite();
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
                        <a class="nav-link" href="Profile.jsp"><span class="fa fa-sign-in"></span> Profile</a>
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
                
                <%if(employee.getRole().equals("admin")){ %> 
                  <li class="nav-item" title="Click to See Your Duties">
                        <a class="nav-link nav-change"  href="#" role="button" aria-haspopup="true" aria-expanded="false" style="border-radius: 15px; text-align: center; background-color: white;color: #111E6C">Policies</a>   
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
                
                <%
                	
                }else if(employee.getRole().equals("siteManager")){ %> 
                
                <li class="nav-item" title="Click to See Your Duties">
                        <a class="nav-link nav-change"  href="SiteManager_Home.jsp" role="button" aria-haspopup="true" aria-expanded="false" style="border-radius: 15px; text-align: center; background-color: white;color: #111E6C">Policies</a>   
                    </li>
                
                    <li class="nav-item " title="Click to See Your Duties">
                        <a class="nav-link nav-change"  href="SiteManager_Inventory.jsp" role="button" aria-haspopup="true" aria-expanded="false" style="border-radius: 15px; text-align: center; background-color: white;color: #111E6C">Site Inventory</a>   
                    </li>
                    <li class="nav-item " title="Click to See Your Duties">
                        <a class="nav-link nav-change"  href="SiteManager_RequestOrder.jsp" role="button" aria-haspopup="true" aria-expanded="false" style="border-radius: 15px; text-align: center; background-color: white;color: #111E6C">Request Orders</a>   
                    </li>
                     <li class="nav-item " title="Click to See Your Duties">
                        <a class="nav-link nav-change"  href="SiteManager_RequestHistory.jsp" role="button" aria-haspopup="true" aria-expanded="false" style="border-radius: 15px; text-align: center; background-color: white;color: #111E6C">Request History</a>   
                    </li>
                     <li class="nav-item " title="Click to See Your Duties">
                        <a class="nav-link nav-change"  href="SiteManager_PendingDelivery.jsp" role="button" aria-haspopup="true" aria-expanded="false" style="border-radius: 15px; text-align: center; background-color: white;color: #111E6C">Pending delivery</a>   
                    </li>
                
                <%
                	
                
                }else if(employee.getRole().equals("procurementEmployee")){ %> 
                
                
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
                        <a class="nav-link nav-change"  href="" role="button" aria-haspopup="true" aria-expanded="false" style="border-radius: 15px; text-align: center; background-color: white;color: #111E6C">Manager - Pending</a>   
                    </li>
                
                <%
                	
                }else if(employee.getRole().equals("manager")){ %> 
                
                
                <%
                	
                }
               	%>
                  
                    
                    
                   
                </ul>
            </div>
        </header>
        
        <!-- Body ---------------------------------------------------------------------------------------------------------------- -->
        
          <div class="container-fluid" style="margin-bottom: 10px;min-height:510px;overflow: auto">
            
         <div class="container" style="margin-top: 50px">
            
<!-- 
	FORM FORM FORM FORM FORM FORM FORM FORM FORM FORM FORM FORM FORM FORM FORM FORM FORM FORM FORM FORM FORM FORM FORM FORM FORM FORM FORM FORM FORM FORM FORM
 -->
                <form action="UpdateProfileServlet" method="post">
                    <div style="float: left; margin-right: 5px;">
                        <div style="width: 550px; float: left; padding: 5px; border-width: 1px; border-style: solid; border-color: #111E6C; margin-bottom: 5px;">
                           <input name="employeeId" id="employeeId" value="<%=employee.getEmployeeId()%>" hidden>
                           <input name="username" id="username" value="<%=employee.getUsername()%>" hidden>
                            <h5>Basic Details</h5>
                            <div class="form-group row" style="padding: 4px; padding-left: 16px">
                                <label class="col-4 col-form-label" >First Name: *</label>
                                <div class="col-8">
                                	<input type="text" class="form-control" id="firstName" name="firstName" required="required" value="<%=employee.getFirstName() %>" >
                                </div>
                            </div>
                            <div class="form-group row" style="padding: 4px; padding-left: 16px">
                                <label class="col-4 col-form-label" >Middle Name:</label>
                                <div class="col-8">
                                    <input type="text" class="form-control" id="middleName" name="middleName" required="required" value="<%=employee.getMiddleName() %>" >
                                </div>
                            </div>
                            <div class="form-group row" style="padding: 4px; padding-left: 16px">
                                <label class="col-4 col-form-label" >Last Name: *</label>
                                <div class="col-8">
                                	<input type="text" class="form-control" id="lastName" name="lastName" required="required" value="<%=employee.getLastName() %>" >
                                </div>
                            </div>
                            
                            <div class="form-group row" style="padding: 4px; padding-left: 16px">
                                <label class="col-4 col-form-label" >Gender: *</label>
                                <div class="col-8">
                                    <select class="custom-select mr-sm-2" id="gender" name="gender" required="required">
                                        <option value="<%=employee.getGender() %>"  selected hidden="true"><%=employee.getGender() %></option>
                                        <option value="male">Male</option>
                                        <option value="female">Female</option>
                                        
                                    </select>
                                </div>
                            </div>
                        </div>

                        <div style="width: 550px; padding: 5px; padding: 5px; border-width: 1px; border-style: solid; border-color: #111E6C; clear: both">
                            <h5>Contact Details</h5>
                            <div class="form-group row" style="padding: 4px; padding-left: 16px">
                                <label class="col-4 col-form-label">Street Address:</label>
                                <div class="col-8">
                                    <div class="form-group">
                                        <label for="EmpForm01ContactDetails01">Line 01: *</label>
                                        <input type="text" class="form-control" id="addressStreet1" required="required" placeholder="No 53 " name="addressStreet1" value="<%=employee.getAddressStreet1() %>" >
                                    </div>
                                    <div class="form-group">
                                        <label for="EmpForm01ContactDetails02">Line 02: *</label>
                                        <input type="text" class="form-control" id="addressStreet2" required="required" placeholder="Street Name" name="addressStreet2" value="<%=employee.getAddressStreet2() %>" >
                                    </div>
                                </div>
                            </div>
                            <div class="form-group row" style="padding: 4px; padding-left: 16px">
                                <label class="col-2 col-form-label" >City: *</label>
                                <div class="col-4">
                                    <input type="text" class="form-control" required="required" id="city" name="city" value="<%=employee.getCity() %>" >
                                </div>
                                <label class="col-2 col-form-label" >Province:*</label>
                                <div class="col-4">
                                    <select class="custom-select mr-sm-2" required="required" id="province" name="province">
                                        <option value="<%=employee.getProvince() %>" selected hidden="ture"><%=employee.getProvince() %></option>
                                        <option value="western">Western</option>
                                        <option value="eastern">Eastern</option>
                                        <option value="central">Central</option>
                                        <option value="sourthern">Sourthern</option>
                                        <option value="northern">Northern</option>
                                        <option value="north western">North Western</option>
                                        <option value="sabaragamuwa">Sabaragamuwa</option>
                                        <option value="north central">North Central</option>
                                        <option value="uva">Uva</option>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group row" style="padding: 4px; padding-left: 16px">
                                <label class="col-3 col-form-label" for="EmpForm01ContactDetails05">ZIP Code: *</label>
                                <div class="col-4">
                                	<input type="number" class="form-control" required="required" id="zipCode" name="zipCode" title="5 digit number" value="<%=employee.getZipCode() %>" >
                                	<!-- pattern="[0-9]{3}" -->
                                </div>
                            </div>
                            
                            <div class="form-group row" style="padding: 4px; padding-left: 16px">
                                <label class="col-4 col-form-label" >Mobile:*</label>
                                <div class="col-8">
                                    <input type="text" class="form-control" required="required" id="mobile" name="mobile" value="<%=employee.getPhone() %>" >
                                    <!-- pattern="0[0-9]{9}" -->
                                </div>
                            </div>
                            <div class="form-group row" style="padding: 4px; padding-left: 16px">
                                <label class="col-4 col-form-label" >Personal Email: *</label>
                                <div class="col-8">
                               		<input type="email" class="form-control" required="required" id="email" name="email" value="<%=employee.getEmail() %>" >
                                </div>
                            </div>
                        </div>
                    </div>

                    <div style="float: left;">
                        <div style="width: 550px; padding: 5px; border-width: 1px; border-style: solid; border-color: #111E6C; margin-bottom: 5px;">
                            <h5>Identification</h5>
                            <div class="form-group row" style="padding: 4px; padding-left: 16px">
                                <label class="col-4 col-form-label">NIC: *</label>
                                <div class="col-8">
                                    <input type="text" class="form-control" id="nic" required="required" name="nic" title="9 digits followed by a v or a V" value="<%=employee.getNic() %>" >
                                    <!-- pattern="[0-9]{9}(v|V)" -->
                                </div>
                            </div>
                           
                            <div class="form-group row" style="padding: 4px; padding-left: 16px">
                                <label class="col-4 col-form-label">Date of Birth: *</label>
                                <div class="col-8">
                                    <input type="date" class="form-control" required="required" id="dob" name="dob" value="<%=employee.getDob() %>"  >
                                </div>
                            </div>
                        </div>

                        <div style="width: 550px; padding: 5px; padding: 5px; border-width: 1px; border-style: solid; border-color: #111E6C; clear: both; margin-bottom: 5px;">
                            <h5>Company Related</h5>
                            <div class="form-group row" style="padding: 4px; padding-left: 16px">
                                <label class="col-4 col-form-label" >Site: *</label>
                                <div class="col-8">
                                    <select class="custom-select mr-sm-2" id="site" required="required" name="site">
                                        <option value="<%=employee.getSite() %>"  selected ><%=employee.getSite() %></option>
                                        
                                        
                                    </select>
                                </div>
                            </div>
                           
                            <div class="form-group row" style="padding: 4px; padding-left: 16px">
                                <label class="col-4 col-form-label" >Designation: *</label>
                                <div class="col-8">
                                    <select class="custom-select mr-sm-2" id="designation" required="required" name="designation">
                                        <option value="<%=employee.getRole() %>"  selected ><%=employee.getRole() %></option>
                                         
                                    </select>
                                </div>
                            </div>
                           
                        </div>
                        
                         
			            <div style="clear: both; float: left; margin-top: 20px;margin-left: 180px">
			                <div class="form-group row">
			                    <div>
			                    	
			                        <input type="submit" value="Update" style="background-color: white; border-radius: 10px; color: black; border-color: #111E6C; border-width: 1px; border-style: solid; font-size: 22px; margin-right: 20px;color: #111E6C"/>
			                        
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
      


	    <!-- Footer -->
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="resources/css&js&jquery/jquery-3.3.1.slim.min.js"></script>
	    <script src="resources/css&js&jquery/popper.min.js"></script>
	    <script src="resources/css&js&jquery/bootstrap.min.js"></script>
</body>
</html>