<%@page import="javax.swing.JDialog"%>
<%@page import="javax.swing.JOptionPane"%>
<%@page import="POJO_MODEL.Request"%>
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
<title>Site Manager Request History</title>
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

		  <table style="border-weight:thick;border-color:black;text-align:center;" cellpadding="20px" cellspacing="20px" align="center" border="1"  >
            	<tr>
                    <th style="font=weight:bold;">Request Id</th>
                    <th style="font=weight:bold;">Item Id</th>
                    <th style="font=weight:bold;">Item Name</th>
                    <th style="font=weight:bold;">Amount</th>
                    <th style="font=weight:bold;">Measurement</th>
                    <th style="font=weight:bold;">Description</th>
                    <th style="font=weight:bold;">Date Needed</th>
                    <th style="font=weight:bold;">Status</th>
                    <th style="font=weight:bold;">Edit Request</th>
                    <th style="font=weight:bold;">Delete Request</th>
                  </tr>
                  
                  <%
                  	if(RetreiveDAO.getRequestBySite(employee.getSite()) == null) { %>
                  	 </table>
                	  <br>
                	  <h4 style="margin-left: 680px">No requests found</h4>
                  	<% 	
                  	}else {
                  		for(Request siteRequest : RetreiveDAO.getRequestBySite(employee.getSite())){
                  			Item item =   RetreiveDAO.getSingleItemById(siteRequest.getItemId());
                  	%>
                  	<tr>
                  		<td><%=siteRequest.getRequestId() %></td>
                  		<td><%=item.getItemId() %></td>
                  		<td><%=item.getItemName() %></td>
                  		<td><%=siteRequest.getAmount() %></td>
                  		<td><%=item.getUnits() %></td>
                  		<td><%=siteRequest.getDescription() %></td>
                  		<td><%=siteRequest.getDateNeeded() %></td>
                  		<td><%=siteRequest.getStatus() %></td>
                  		<td>
                  		<form action="SiteManagerEditRequest" method="post" >
                  			<div class="input-group">
          						
          						<input type="text" name="requestId" value="<%=siteRequest.getRequestId()%>" hidden>
          						<input type="text" name="status" value="<%=siteRequest.getStatus()%>" hidden>
          						
          					
         					 <input type="submit" class="nav-link nav_change" style="border-radius: 15px; text-align: center;font-weight:bold;color::#fd4f00;background-color:white;width:100px;border-weight:10px;border-color:#111E6C" value="Edit">
    				  </div>
                  		
                  		</form>
                  		</td>
                  		
                  		<td>
                  		<form action="SiteManagerDeleteRequest" method="post" >
                  			<div class="input-group">
          						
          						<input type="text" name="requestId" value="<%=siteRequest.getRequestId()%>" hidden>
          						<input type="text" name="status" value="<%=siteRequest.getStatus()%>" hidden>
          						
          					
         					  <input type="submit" class="nav-link nav_change" style="border-radius: 15px; text-align: center;font-weight:bold;color::#fd4f00;background-color:white;width:100px;border-weight:10px;border-color:#111E6C" value="Delete">
    				  </div>
                  		
                  		</form>
                  		</td>
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