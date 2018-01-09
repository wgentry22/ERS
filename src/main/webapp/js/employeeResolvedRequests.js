window.onload = function() {
	populateResolvedTable();
}

function populateResolvedTable() {
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			addRows(JSON.parse(xhr.responseText));
			
		}
	};
	xhr.open("POST", "http://localhost:8080/ERS/populateResolvedRequest.ajax");
	xhr.send();
}


function addRows(ajaxObject) {
	for (var i = 0; i < ajaxObject.length; i++) {
		var tr = document.createElement("tr");
		var tdResId = document.createElement("td");
		var tdReqId = document.createElement("td");
		var tdStatus = document.createElement("td");
		var tdResolvingManager = document.createElement("td");
		var tdTimeResolved = document.createElement("td");
		
		tdResId.textContent = ajaxObject[i].resolvedRequestId;
		tdReqId.textContent = ajaxObject[i].pendingRequestId;
		tdStatus.textContent = ajaxObject[i].resolvedStatus;
		tdResolvingManager.textContent = ajaxObject[i].resolvingManagerName;
		tdTimeResolved.textContent = ajaxObject[i].timeRequestWasResolved;
		
		tr.appendChild(tdResId);
		tr.appendChild(tdReqId);
		tr.appendChild(tdStatus);
		tr.appendChild(tdResolvingManager);
		tr.appendChild(tdTimeResolved);
		
		
		document.getElementById("tblResolvedRequests").appendChild(tr);
	}
}

function myInfo() {
	var xhr = new XMLHttpRequest();
	xhr.open("POST", "http://localhost:8080/ERS/html/employeeInfo.do");
	xhr.send();
}

function myPendingRequests() {
	var xhr = new XMLHttpRequest();
	xhr.open("POST", "http://localhost:8080/ERS/html/createPendingRequest.do");
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

