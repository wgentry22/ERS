window.onload = function() {
	document.getElementById("btnUpdateEmployeeInformation").addEventListener("click", showUpdateInfo);
	document.getElementById("btnUpdateEmployeeInformationConfirmation").addEventListener("click", updateEmployee);
	
}

function showUpdateInfo() {
	var updateForm = document.getElementById("updateEmployeeInfoForm");
	var infoDisplay = document.getElementById("employeeInfoDisplay");
	if (updateForm.classList.contains("invisible")) {
		updateForm.classList.remove("invisible");
	} 
	
	if (!infoDisplay.classList.contains("invisible")) {
		infoDisplay.classList.add("invisible");
	}
}



function updateEmployee() {
	var xhr = new XMLHttpRequest();
	var updated = new Object();
	
	updated.firstname = document.getElementById("firstname").value;
	updated.lastname = document.getElementById("lastname").value;
	updated.email = document.getElementById("email").value;
	updated.address = document.getElementById("address").value;
	updated.city = document.getElementById("city").value;
	updated.state = document.getElementById("state").value;
	updated.zipcode = document.getElementById("zipcode").value;

	var stringifiedUpdatedEmployee = JSON.stringify(updated);
	console.log(stringifiedUpdatedEmployee);
	
	xhr.open("POST", "http://localhost:8080/ERS/html/updateEmployeeInformation.do", true);
	xhr.setRequestHeader("Content-Type","application/json");

	xhr.send(stringifiedUpdatedEmployee);
}