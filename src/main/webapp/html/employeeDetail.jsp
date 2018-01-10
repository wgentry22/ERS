<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
<meta charset="UTF-8">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%@ page import="com.gtrain.model.Employee" %>
<% Employee employee = (Employee) request.getSession().getAttribute("pendingRequestByEmployee"); %>

<body class="container">

	<div class="row">
	
	<h2>Employee Information</h2>
		<div class="navbar">
			<div class="navbar-header">
				<ul class="nav navbar-nav" >
					<li><a  href="http://localhost:8080/ERS/html/manager.jsp" onclick="home();">Home</a></li>
					<li><a  href="http://localhost:8080/ERS/html/allEmployees.jsp" onclick="myEmployees();">My Employees</a></li>
					<li><a  href="http://localhost:8080/ERS/html/resolvedRequests.jsp" onclick="resolvedRequests();">Resolved Requests</a></li>
					<li><a href="http://localhost:8080/ERS/logout" onclick="logout();">Log Out</a></li>
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
<script type="text/javascript" src="../js/employeeDetail.js"></script>
</body>
</html>