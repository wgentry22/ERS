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
		<h2>Welcome to the Manager Home Page</h2>
		
	
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
</body>
</html>