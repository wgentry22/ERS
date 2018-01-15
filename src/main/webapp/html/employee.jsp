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
<title>Employee ERS Portal</title>
</head>
<body class="container">

<%@ page import="com.gtrain.model.Employee" %>
<% Employee employee = (Employee) request.getSession().getAttribute("authorizedUser"); %>
	<div class="row">
		<h2>Welcome to the Employee Reimbursement Portal, <%= employee.getFirstname() %></h2>
		
		<div class="navbar">
			<div class="navbar-header">
				<ul class="nav navbar-nav" >
					<li><a  href="http://localhost:8080/ERS/html/employee.do">Home</a></li>
					<li><a  href="http://localhost:8080/ERS/html/employeeInfo.do" >My Information</a></li>
					<li><a href="http://localhost:8080/ERS/html/employeeResolvedRequest.do">My Resolved Requests</a></li>
					<li><a href="http://localhost:8080/ERS/html/employeePendingRequests.do" >Create Request</a>
					<li><a href="http://localhost:8080/ERS/logout.do" >Log Out</a></li>
				</ul>
			</div>
		</div>
		
		
	</div>
	
	<h2>My Pending Requests</h2>
	<table class="table table-bordered table-striped table-hover">
		<thead class="table-header">
			<tr>
				<th scope="col">Request ID</th>
				<th scope="col">Amount</th>
				<th scope="col">Reason</th>
				<th scope="col">Time Created</th>
			</tr>		
		</thead>
		<tbody id="tblPendingRequests">
			
		</tbody>	
	</table>
	
<script type="text/javascript" src="../js/employee.js"></script>
<!--<script type="text/javascript" src="../js/employeeRouting.js"></script>-->
</body>
</html>