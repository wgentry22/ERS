window.onload = function() {
	populateResolvedRequests();
}


function populateResolvedRequests() {
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			var ajaxObject = JSON.parse(xhr.responseText);
			addRows(ajaxObject);
			
		}
	};
	xhr.open("POST", "http://localhost:8080/ERS/populateManagerResolvedRequestTable.ajax");
	xhr.send();
};

function addRows(ajaxObject) {
	for (var i = 0; i < ajaxObject.length; i++) {
		var tr = document.createElement("tr");
		var tdResId = document.createElement("td");
		var tdPendId = document.createElement("td");
		var tdManName = document.createElement("td");
		var tdStatus = document.createElement("td");
		var tdTime = document.createElement("td");
		
		
		
		tdResId.textContent = ajaxObject[i].resolvedRequestId;
		tdPendId.textContent = ajaxObject[i].pendingRequestId;
		tdManName.textContent = ajaxObject[i].resolvingManagerName;
		tdStatus.textContent = ajaxObject[i].resolvedStatus;
		tdTime.textContent = ajaxObject[i].timeRequestWasResolved;
		
		tr.appendChild(tdResId);
		tr.appendChild(tdPendId);
		tr.appendChild(tdManName);
		tr.appendChild(tdStatus);
		tr.appendChild(tdTime);
		
		document.getElementById("tblCurrentResolvedRequests").appendChild(tr);
	}
}

