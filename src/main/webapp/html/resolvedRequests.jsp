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
<title>Resolved Requests</title>
</head>
<body class="container">

	<div class="row">
		<h2>Resolved Requests</h2>
		
	<div class="navbar">
			<div class="navbar-header">
				<ul class="nav navbar-nav" >
					<li><a  href="http://localhost:8080/ERS/html/manager.jsp" onclick="home();">Home</a></li>
					<li><a  href="http://localhost:8080/ERS/html/allEmployees.jsp" onclick="myEmployees();">My Employees</a></li>
					<li><a  href="http://localhost:8080/ERS/html/resolvedRequests.jsp" onclick="resolvedRequests();">Resolved Requests</a></li>
					<li><a href="http://localhost:8080/ERS/" onclick="logout();">Log Out</a></li>
				</ul>
			</div>
		</div>
	
	
	<h2>All Resolved Requests</h2>
	<table class="table table-bordered table-striped table-hover">
		<thead class="table-header">
			<tr>
				<th scope="col">Resolved Request ID</th>
				<th scope="col">Request Reason</th>
				<th scope="col">Request Amount</th>
				<th scope="col">Time Created</th>
				<th scope="col">Status</th>
				<th scope="col">Resolving Manager</th>
				<th scope="col">Time Resolved</th>
			</tr>		
		</thead>
		<tbody id="tblCurrentResolvedRequests">
			
		</tbody>	
	</table>
	</div>
<script type="text/javascript" src="../js/managerResolvedRequestsView.js"></script>
<script type="text/javascript" src="../js/managerRouting.js"></script>
</body>
</html>