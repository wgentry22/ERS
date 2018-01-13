<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="../styles/employee.css" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Raleway" rel="stylesheet">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
<title>Create Reimbursement Request</title>
</head>
<body class="container">
	<div class="row">
	<h2>Create Reimbursement Request</h2>
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
	
	<div id="" class=" well">
		<form method="post" action="/ERS/html/createPendingRequest.do" >
		<div class="form-group row">
		<div class="col-md-1">
			<label for="requestAmount">Amount</label>
		</div>
		<div class="col-md-3">
			<input name="requestAmount"id="requestAmount" type="text" class="form-control" required placeholder="$XXXX.XX"/>
		</div>
		<div class="col-md-1">
			<label for="requestReason">Reason</label>
		</div>
		<div class="col-md-5">
			<input name="requestReason" id="requestReason" type="text" class="form-control" required placeholder="Brief Description" />
		</div>
		<div class="col-md-1">
			<input id="submitRequest" type="submit" class="btn btn-primary form-control" value="Submit" />
		</div>
		</div>
		</form>
	</div>
	</div>
	
	
<script type="text/javascript" src="../js/employeeRouting.js"></script>
</body>
</html>