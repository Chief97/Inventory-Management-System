<%@page import="javax.swing.JDialog"%>
<%@page import="javax.swing.JOptionPane"%>
<%@page import="POJO_MODEL.Request"%>
<%@page import="java.time.LocalDate"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.ArrayList"%>
<%@page import="POJO_MODEL.Item"%>
<%@page import="POJO_MODEL.SiteInventory"%>
<%@page import="DAO_SERVICE.CRUD.RetreiveDAO"%>
<%@page import="POJO_MODEL.Employee"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Site Manager Request Orders - Edit</title>
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
	
	 ArrayList<Item> itemList = RetreiveDAO.retreiveAllItem();
	 String pattern = "yyyy-MM-dd";
	 SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
	 String date = simpleDateFormat.format(new Date());
	 
	Request siteRequest = (Request) session.getAttribute("siteRequest");
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
                        <a class="nav-link" href="ProfileSiteManager.jsp"><span class="fa fa-sign-in"></span> Profile</a>
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
                   
                    
                    
                   
                </ul>
            </div>
        </header>
        
        <!-- Body ---------------------------------------------------------------------------------------------------------------- -->
        
          <div class="container-fluid" style="margin-bottom: 10px;min-height:510px;overflow: auto">
          <br>
          	<h4>Site Id : <%=employee.getSite() %></h4>
          	<h4>Site Name : <%=RetreiveDAO.getSingleSiteById(employee.getSite()).getSiteName() %></h4>
        
        	     <form action="SiteManagerEditRequestSubmit" method="POST">
                <br>
                    <div style="float: left; margin-right: 5px;margin-left: 500px">
                        <div style="width: 550px; float: left; padding: 5px; border-width: 1px; border-style: solid; border-color: #111E6C; margin-bottom: 5px;">
                            <h5>Edit Request</h5>
                            
                            <div class="form-group row" style="padding: 4px; padding-left: 16px">
                                <label class="col-4 col-form-label" for="EmpForm01BasicDetails02">Request Id: *</label>
                                <div class="col-8">
                                	<input class="form-control" value="<%=siteRequest.getRequestId()%>"  id="requestId" name="requestId" readonly >
                                </div>
                            </div>
                            <div class="form-group row" style="padding: 4px; padding-left: 16px">
                                <label class="col-4 col-form-label" for="EmpForm01BasicDetails02">Request Item: *</label>
                                <select class="custom-select mr-sm-2" required="required" id="reqItem" name="reqItem">
                                        <option value="<%=siteRequest.getItemId() %>" selected hidden="ture"><%=RetreiveDAO.getSingleItemById(siteRequest.getItemId()).getItemName() %></option>
                                       <%for(Item item :  itemList) {%>
                                        <option value="<%=item.getItemId()%>"><%=item.getItemName()%></option>
                                        <%} %>
                                        
                                    </select>
                            </div>
                            
                            <div class="form-group row" style="padding: 4px; padding-left: 16px">
                                <label class="col-4 col-form-label" for="EmpForm01BasicDetails02">Description: *</label>
                                <div class="col-8">
                                	<textarea class="form-control" rows="3" id="description" name="description" value =""><%=siteRequest.getDescription()%></textarea>
                                </div>
                            </div>
                            
                            <div class="form-group row" style="padding: 4px; padding-left: 16px">
                                <label class="col-5 col-form-label" for="EmpForm01BasicDetails02">Requesting amount: *</label>
                                <div class="col-7">
                                	<input type="number" class="form-control" value ="<%=siteRequest.getAmount() %>" id="amount" required="required" name="amount">
                                </div>
                            </div>
                            
                            <div class="form-group row" style="padding: 4px; padding-left: 16px">
                                <label class="col-4 col-form-label" for="EmpForm01BasicDetails02">Required Date: *</label>
                                <div class="col-8">
                                	<input type="Date" value ="<%=siteRequest.getDateNeeded() %>" class="form-control" min =<%=date%> id="deliveryDate" required="required" name="deliveryDate">
                                </div>
                            </div>
                           
                            <input type="text" name="requestedBy" value=<%=employee.getUsername() %>  hidden>
                            <input type="text" name="site" value=<%=RetreiveDAO.getSingleSiteById(employee.getSite()).getSiteId() %>  hidden>
                            
                        </div>

                 
                    </div>

                 

                       
			            <div style="clear: both; float: left; margin-top: 20px;margin-left: 650px">
			                <div class="form-group row">
			                    <div>
			                    	<input type="reset" value="Reset" style="background-color: white;border-radius: 10px; color: black; border-color: #111E6C; border-width: 1px; border-style: solid; font-size: 22px; margin-right:10px;color: #111E6C"/>
			                        <input type="submit" value="Update Request" style="background-color: white; border-radius: 10px; color: black; border-color: #111E6C; border-width: 1px; border-style: solid; font-size: 22px; margin-right: 20px;color: #111E6C"/>
			                      
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