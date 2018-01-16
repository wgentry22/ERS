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
					<li><a  href="http://ec2-52-90-166-210.compute-1.amazonaws.com:8080/ERS/html/employee.do">Home</a></li>
					<li><a  href="http://ec2-52-90-166-210.compute-1.amazonaws.com:8080/ERS/html/employeeInfo.do" >My Information</a></li>
					<li><a href="http://ec2-52-90-166-210.compute-1.amazonaws.com:8080/ERS/html/employeeResolvedRequest.do">My Resolved Requests</a></li>
					<li><a href="http://ec2-52-90-166-210.compute-1.amazonaws.com:8080/ERS/html/employeePendingRequests.do" >Create Request</a>
					<li><a href="http://ec2-52-90-166-210.compute-1.amazonaws.com:8080/ERS/logout.do" >Log Out</a></li>
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