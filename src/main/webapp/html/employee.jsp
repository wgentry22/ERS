<!DOCTYPE html>
<html>
<head>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
<meta charset="UTF-8">
<title>Employee ERS Portal</title>
</head>
<body class="container">
<%@ page import="java.util.List" %>
<%@ page import="com.gtrain.model.Employee" %>
<%@ page import="com.gtrain.model.PendingReq" %>
<%@ page import="com.gtrain.service.EmployeeService" %>
<%@ page import="com.gtrain.dao.PendingReqDaoImpl" %>
<% Employee employee = (Employee) request.getSession().getAttribute("authorizedUser"); %>


	<div class="row">
		<h2>Welcome to the Employee Reimbursement Portal, <%= employee.getFirstname() %> </h2>
		
		<a  href="http://localhost:8080/ERS/html/employeeInfo.jsp" onclick="myInfo();">My Information</a>
		
	</div>
	
	
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
</body>
</html>