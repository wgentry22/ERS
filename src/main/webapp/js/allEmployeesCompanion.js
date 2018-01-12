window.onload = function() {
	getAllEmployees();
	document.getElementById("allEmployees").addEventListener("click", getUsername);
}

function getAllEmployees() {
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			addRows(JSON.parse(xhr.responseText));
		}
	};
	xhr.open("POST", "http://localhost:8080/ERS/allEmployees.ajax");
	xhr.send();
};


function addRows(ajaxObject) {
	for (var i = 0; i < ajaxObject.length; i++) {
		var tr = document.createElement("tr");
		var tdEmpId = document.createElement("td");
		var tdUsername = document.createElement("td");
		var tdName = document.createElement("td");
		var tdEmail = document.createElement("td");
		
		tdEmpId.textContent = ajaxObject[i].id;
		tdUsername.textContent = ajaxObject[i].username;
		tdName.textContent = ajaxObject[i].firstname +" " + ajaxObject[i].lastname;
		tdEmail.textContent = ajaxObject[i].email;
		
		
		tr.appendChild(tdEmpId);
		tr.appendChild(tdUsername);
		tr.appendChild(tdName);
		tr.appendChild(tdEmail);
		
		document.getElementById("allEmployees").appendChild(tr);
	}
}

function getUsername(row) {
	var rowInTable = row.target.parentNode;
	var username = rowInTable.firstChild.nextSibling.textContent;
	
	var emp = new Object();
	emp.username = username;
	
	var xhr = new XMLHttpRequest();
	xhr.open("POST", "http://localhost:8080/ERS/html/managerViewOfEmployeeInRow.do");
	xhr.send(JSON.stringify(emp));
	
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 3) {
			window.location = "http://localhost:8080/ERS/html/goToEmployeeDetail.do";
		}
	}
	
}
