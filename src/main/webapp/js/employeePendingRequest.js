window.onload = function() {
	document.getElementById("submitRequest").addEventListener("click", createRequest);
}

function createRequest() {
	var xhr = new XMLHttpRequest();
	var request = new Object();
	
	request.requestAmount = document.getElementById("requestAmount").value;
	request.requestReason = document.getElementById("requestReason").value;
	
	console.log(request);
	
	
	var stringifiedPending = JSON.stringify(request);
	xhr.open("POST", "http://localhost:8080/ERS/html/createPendingRequest.do");
	xhr.send(stringifiedPending);
}