<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">


<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
<title>Employee Info</title>
</head>
<body class="container">
<%@ page import="com.gtrain.model.Employee" %>
<% Employee employee = (Employee) request.getSession().getAttribute("authorizedUser"); %>
<h2>Employee Information</h2>
		<div class="navbar">
			<div class="navbar-header">
				<ul class="nav navbar-nav" >
					<li><a  href="http://localhost:8080/ERS/html/employee.jsp" onclick="myHome();">Home</a></li>
					<li><a  href="http://localhost:8080/ERS/html/employeeInfo.jsp" onclick="myInfo();">My Information</a></li>
					<li><a href="http://localhost:8080/ERS/html/employeeResolvedRequest.jsp" onclick="myResolvedRequests();">My Resolved Requests</a></li>
					<li><a href="http://localhost:8080/ERS/html/employeePendingRequests.jsp" onclick="myPendingRequests();" >Create Request</a>
					<li><a href="http://localhost:8080/ERS/html/login.html">Log Out</a></li>
				</ul>
			</div>
		</div>


	<div id="employeeInfo">
		<h2>My Information</h2>
		<div class="form-row ">
			<div id="employeeInfoDisplay" class="well col-md-4">
				<h4>Name: <%= employee.getFullname() %></h4>
				<h4>Email: <%= employee.getEmail() %></h4>
				<h4>Address: <%= employee.getAddress() %></h4>
				<h4>City: <%= employee.getCity() %></h4>
				<h4>State: <%= employee.getState() %></h4>
				<h4>Zipcode: <%= employee.getZipcode() %></h4>
				<br>
				<input type="button" id="btnUpdateEmployeeInformation" align="center" class="btn btn-success" value="Update" />
			</div>
			<div id="updateEmployeeInfoForm" class="invisible well col-md-8">
				<div class="form-group">
					<form method="post" action="updateEmployeeInformation.do">
					
						<label for="firstname">First Name</label>
						<input name="firstname" id="firstname" type="text" class="form-control" placeholder="Full Name, seperated by a space" 
						value="<%= employee.getFirstname() %>" />
						<label for="lastname">Last Name</label>
						<input name="lastname" id="lastname" type="text" class="form-control" placeholder="Full Name, seperated by a space" 
						value="<%= employee.getLastname() %>" />
						
						
						<label for="email">Email</label>
						<input name="email" id="email" type="email" class="form-control" placeholder="Email Address"  
						value="<%= employee.getEmail() %>"/>
						<label for="address">Address</label>
						<input name="address" id="address" type="text" class="form-control" placeholder="Street Address"  
						value="<%= employee.getAddress() %>"/>
						<label for="city">City</label>
						<input name="city" id="city" type="text" class="form-control" placeholder="City"  
						value="<%= employee.getCity() %>"/>
						<label for="state">State</label>
						<input name="state" id="state" type="text" class="form-control" placeholder="State"  
						value="<%= employee.getState() %>"/>
						<label for="zipcode">Zip Code</label>
						<input name="zipcode" id="zipcode" type="text" class="form-control" placeholder="Zip"  
						value="<%= employee.getZipcode() %>"/>
						<br>
						<input id="btnUpdateEmployeeInformationConfirmation"  type="submit" class="btn btn-danger" value="Update" />
					</form>
				</div>
			</div>
		</div>
		<div>
				
		</div>
	</div>

<script type="text/javascript" src="../js/employeeInfo.js"></script>
<script type="text/javascript" src="../js/employeeRouting.js"></script>
</body>
</html>