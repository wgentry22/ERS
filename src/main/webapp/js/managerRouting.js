function myEmployees() {
	var xhr = XMLHttpRequest();
	xhr.open("POST", "http://localhost:8080/ERS/html/allEmployees.jsp");
	xhr.send();
	
}

function resolvedRequests() {
	var xhr = XMLHttpRequest();
	xhr.open("POST", "http://localhost:8080/ERS/html/allResolvedRequests.jsp");
	xhr.send();
}

function home() {
	var xhr = XMLHttpRequest();
	xhr.open("POST", "http://localhost:8080/ERS/manager.jsp");
}

function logout() {
	xhr = new XMLHttpRequest();
	xhr.open("GET", "http://localhost:8080/ERS/html/logout.do");
	xhr.send();
}