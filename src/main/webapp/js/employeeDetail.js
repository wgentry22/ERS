window.onload = function() {
	populateEmployeeDetailTable();
}

function populateEmployeeDetailTable() {
	
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			var ajaxObject = JSON.parse(xhr.responseText);
			addRows(ajaxObject);
		}
	};
	xhr.open("POST", "http://localhost:8080/ERS/employeeDetailPendingRequest.ajax");
	xhr.send();
};

function addRows(ajaxObject) {
	for (var i = 0; i < ajaxObject.length; i++) {
		var tr = document.createElement("tr");
		var tdRequestId = document.createElement("td");
		var tdRequestAmount = document.createElement("td");
		var tdRequestReason = document.createElement("td");
		var tdTimeCreated = document.createElement("td");
		var tdResolve = document.createElement("td");
		var tdDeny = document.createElement("td");
		
		
		var resolveButton = document.createElement("input");
		resolveButton.setAttribute("type", "button");
		resolveButton.setAttribute("class", "btn btn-success");
		resolveButton.setAttribute("value", "Resolve");
		
		resolveButton.addEventListener("click", resolve);
		
		tdResolve.appendChild(resolveButton);
		
		var denyButton = document.createElement("input");
		denyButton.setAttribute("type", "button");
		denyButton.setAttribute("class", "btn btn-danger");
		denyButton.setAttribute("value", "Deny");
		
		denyButton.addEventListener("click", deny);
		
		tdDeny.appendChild(denyButton);
		
		tdRequestId.textContent = ajaxObject[i].requestId;
		tdRequestAmount.textContent = ajaxObject[i].requestAmount;
		tdRequestReason.textContent = ajaxObject[i].requestReason;
		tdTimeCreated.textContent = ajaxObject[i].timeRequestWasCreated;
		
		tr.appendChild(tdRequestId);
		tr.appendChild(tdRequestAmount);
		tr.appendChild(tdRequestReason);
		tr.appendChild(tdTimeCreated);
		tr.appendChild(tdResolve);
		tr.appendChild(tdDeny);
		
		document.getElementById("employeeDetailPendingRequests").appendChild(tr);
	}
}



function resolve(row) {
	var rowInTable = row.target.parentNode.parentNode;
	var decision = window.confirm("Are you sure you want to RESOLVE this request?");
	if (decision == true) {
		var resolvedRequest = new Object();
		resolvedRequest.pendingRequestId = rowInTable.firstChild.textContent;
		resolvedRequest.resolvedStatus = "Resolved";
		
		var xhr = new XMLHttpRequest();
		xhr.open("POST", "http://localhost:8080/ERS/html/managerCreateResolved.do");
		xhr.send(JSON.stringify(resolvedRequest));
		window.location = "http://localhost:8080/ERS/html/employeeDetail.jsp";
		
		
	} else {
		console.log("Do not create resolved request");
	}
}





function deny(row) {
	var rowInTable = row.target.parentNode.parentNode;
	var decision = window.confirm("Are you sure you want to DENY this request?");
	if (decision == true) {
		var resolvedRequest = new Object();
		resolvedRequest.pendingRequestId = rowInTable.firstChild.textContent;
		resolvedRequest.resolvedStatus = "Denied";
		
		var xhr = new XMLHttpRequest();
		xhr.open("POST", "http://localhost:8080/ERS/html/managerCreateResolved.do");
		xhr.send(JSON.stringify(resolvedRequest));
		window.location = "http://localhost:8080/ERS/html/employeeDetail.jsp";
	} else {
		console.log("Do not create resolved request");
	}
}







