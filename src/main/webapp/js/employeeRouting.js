function myInfo() {
	var xhr = new XMLHttpRequest();
	xhr.open("POST", "http://localhost:8080/ERS/html/employeeInfo.jsp");
	xhr.send();
}

function myPendingRequests() {
	var xhr = new XMLHttpRequest();
	xhr.open("POST", "http://localhost:8080/ERS/html/employeePendingRequests.jsp");
	xhr.send();
}

function myHome() {
	var xhr = new XMLHttpRequest();
	xhr.open("POST", "http://localhost:8080/ERS/html/employee.jsp");
	xhr.send();
}


function myResolvedRequests() {
	var xhr = new XMLHttpRequest();
	xhr.open("POST", "http://localhost:8080/ERS/html/employeeResolvedRequest.jsp");
	xhr.send();
}

function logout() {
	xhr = new XMLHttpRequest();
	xhr.open("GET", "http://localhost:8080/ERS/html/logout.do");
	xhr.send();
}

