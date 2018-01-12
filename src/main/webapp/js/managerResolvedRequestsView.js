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
		var tdReqReason = document.createElement("td");
		var tdReqAmount = document.createElement("td");
		var tdTimeCreated = document.createElement("td");
		var tdStatus = document.createElement("td");
		var tdResolvingManager = document.createElement("td");
		var tdTimeResolved = document.createElement("td");
		
		tdResId.textContent = ajaxObject[i].resolvedRequestId;
		tdReqReason.textContent = ajaxObject[i].requestReason;
		tdReqAmount.textContent = ajaxObject[i].requestAmount;
		tdTimeCreated.textContent = ajaxObject[i].timeRequestWasCreated;
		tdStatus.textContent = ajaxObject[i].resolvedStatus;
		tdResolvingManager.textContent = ajaxObject[i].resolvingManagerName;
		tdTimeResolved.textContent = ajaxObject[i].timeRequestWasResolved;
		
		tr.appendChild(tdResId);
		tr.appendChild(tdReqReason);
		tr.appendChild(tdReqAmount);
		tr.appendChild(tdTimeCreated);
		tr.appendChild(tdStatus);
		tr.appendChild(tdResolvingManager);
		tr.appendChild(tdTimeResolved);
		
		document.getElementById("tblCurrentResolvedRequests").appendChild(tr);
	}
}