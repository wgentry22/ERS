<!DOCTYPE html>
<html>
<head>
<link href="../styles/employee.css" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Raleway" rel="stylesheet">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
<meta charset="UTF-8">
<meta charset="UTF-8">
<title>Employee Detail</title>
</head>
<%@ page import="com.gtrain.model.Employee" %>
<% Employee employee = (Employee) request.getSession().getAttribute("employeeDetail"); %>

<body class="container">

	<div class="row">
	
	<h2>Employee Information</h2>
		<div class="navbar">
			<div class="navbar-header">
				<ul class="nav navbar-nav" >
					<li><a  href="http://ec2-52-90-166-210.compute-1.amazonaws.com:8080/ERS/html/manager.do" >Home</a></li>
					<li><a  href="http://ec2-52-90-166-210.compute-1.amazonaws.com:8080/ERS/html/allEmployees.do">My Employees</a></li>
					<li><a  href="http://ec2-52-90-166-210.compute-1.amazonaws.com:8080/ERS/html/resolvedRequests.do" >Resolved Requests</a></li>
					<li><a href="http://ec2-52-90-166-210.compute-1.amazonaws.com:8080/ERS/logout.do">Log Out</a></li>
				</ul>
			</div>
		</div>
		<div class="form-row ">
			<div id="employeeInfoDisplay" class="well col-md-4">
				<h4>Name: <%= employee.getFullname() %></h4>
				<h4>Email: <%= employee.getEmail() %></h4>
				<h4>Address: <%= employee.getAddress() %></h4>
				<h4>City: <%= employee.getCity() %></h4>
				<h4>State: <%= employee.getState() %></h4>
				<h4>Zipcode: <%= employee.getZipcode() %></h4>
				<br>
		</div>
		</div>
	</div>
		<br>
	<div class="row">
	<h2> <%= employee.getFirstname() %>'s Pending Requests</h2>
	<table class="table table-bordered table-striped table-hover">
		<thead class="table-header">
			<tr>
				<th scope="col">Request ID</th>
				<th scope="col">Amount</th>
				<th scope="col">Reason</th>
				<th scope="col">Time Created</th>
			</tr>		
		</thead>
		<tbody id="employeeDetailPendingRequests">
			
		</tbody>	
	</table>
	</div>
	
<% %>
<script type="text/javascript" src="../js/employeeDetailCompanion.js"></script>
<script type="text/javascript" src="../js/managerRouting.js"></script>
</body>
</html>