<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="../styles/employee.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
<title>Employee Info</title>
</head>
<body class="container">
<%@ page import="com.gtrain.model.Employee" %>
<% Employee employee = (Employee) request.getSession().getAttribute("authorizedUser"); %>
	<div id="employeeInfo">
		<h2>Employee Information</h2>
		<div class="form-row ">
			<div id="employeeInfoDisplay" class="well col-md-4">
				<h4>Name: <%= employee.getFullname() %></h4>
				<h4>Email: <%= employee.getEmail() %></h4>
				<h4>Address: <%= employee.getAddress() %></h4>
				<h4>City: <%= employee.getCity() %></h4>
				<h4>State: <%= employee.getState() %></h4>
				<h4>Zipcode: <%= employee.getZipcode() %></h4>
				<br>
				<input type="button" id="btnUpdateEmployeeInformation" align="center" class="btn btn-success" value="Update" />
			</div>
			<div id="updateEmployeeInfoForm" class="invisible well col-md-8">
				<div class="form-group">
					<form  method="post" action="updateEmployeeInformation.do">
						<label for="updateName">Name</label>
						<input name="updateName" id="updateName" type="text" class="form-control" placeholder="Full Name, seperated by a space" 
						value="<%= employee.getFullname() %>" />
						<label for="updateEmail">Email</label>
						<input name="updateEmail" id="updateEmail" type="email" class="form-control" placeholder="Email Address"  
						value="<%= employee.getEmail() %>"/>
						<label for="updateAddress">Address</label>
						<input name="updateAddress" id="updateAddress" type="text" class="form-control" placeholder="Street Address"  
						value="<%= employee.getAddress() %>"/>
						<label for="updateCity">City</label>
						<input name="updateCity" id="updateCity" type="text" class="form-control" placeholder="City"  
						value="<%= employee.getCity() %>"/>
						<label for="updateState">State</label>
						<input name="updateState" id="updateState" type="text" class="form-control" placeholder="State"  
						value="<%= employee.getState() %>"/>
						<label for="updateZipcode">Zip Code</label>
						<input name="updateZipcode" id="updateZipcode" type="text" class="form-control" placeholder="Zip"  
						value="<%= employee.getZipcode() %>"/>
						<br>
						<input id="btnUpdateEmployeeInformationConfirmation"  type="button" class="btn btn-danger" value="Update" />
					</form>
				</div>
			</div>
		</div>
		<div>
				
		</div>
	</div>

<script type="text/javascript" src="../js/employeeInfo.js"></script>
</body>
</html>