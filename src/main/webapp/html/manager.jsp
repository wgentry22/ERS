<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
<title>Manager ERS Portal</title>
</head>
<body class="container">
	<div class="row">
		<h2>Welcome to the Manager Reimbursement Portal</h2>
		
	<div class="navbar">
			<div class="navbar-header">
				<ul class="nav navbar-nav" >
					<li><a  href="http://localhost:8080/ERS/html/manager.jsp" onclick="home();">Home</a></li>
					<li><a  href="http://localhost:8080/ERS/html/allEmployees.jsp" onclick="myEmployees();">My Employees</a></li>
					<li><a  href="http://localhost:8080/ERS/html/resolvedRequests.jsp" onclick="resolvedRequests();">Resolved Requests</a></li>
					<li><a href="http://localhost:8080/ERS/html/login.html" onclick="logout();">Log Out</a></li>
				</ul>
			</div>
		</div>
	<h2>Current Pending Requests</h2>
	<table class="table table-bordered table-striped table-hover">
		<thead class="table-header">
			<tr>
				<th scope="col">Request ID</th>
				<th scope="col">Amount</th>
				<th scope="col">Reason</th>
				<th scope="col">Time Created</th>
			</tr>		
		</thead>
		<tbody id="tblCurrentPendingRequests">
			
		</tbody>	
	</table>
	
	
	</div>
	
	
<script type="text/javascript" src="../js/manager.js"></script>
<script type="text/javascript" src="../js/managerRouting.js"></script>
</body>
</html>