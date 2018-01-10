<!DOCTYPE html>
<html>
<head>
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
					<li><a  href="http://localhost:8080/ERS/html/employee.jsp" onclick="myHome();">Home</a></li>
					<li><a  href="http://localhost:8080/ERS/html/employeeInfo.jsp" onclick="myInfo();">My Information</a></li>
					<li><a href="http://localhost:8080/ERS/html/employeeResolvedRequest.jsp" onclick="myResolvedRequests();">My Resolved Requests</a></li>
					<li><a href="http://localhost:8080/ERS/html/employeePendingRequests.jsp" onclick="myPendingRequests();" >Create Request</a>
					<li><a href="http://localhost:8080/ERS/logout" onclick="logout();">Log Out</a></li>
				</ul>
			</div>
		</div>



<table class="table table-bordered table-striped table-hover">
		<thead class="table-header">
			<tr>
				<th scope="col">Resolved Request ID</th>
				<th scope="col">Pending Request Id</th>
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
</body>
</html>