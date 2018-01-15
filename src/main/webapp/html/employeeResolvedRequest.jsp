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
<title>My Pending Requests</title>
</head>
<body class="container">

	<div class="row">
		<h2>My Resolved Reimbursements</h2>
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
		<tbody id="tblResolvedRequests">
			
		</tbody>	
	</table>

</div>

<script type="text/javascript" src="../js/employeeResolvedRequests.js"></script>
<script type="text/javascript" src="../js/employeeRouting.js"></script>
</body>
</html>