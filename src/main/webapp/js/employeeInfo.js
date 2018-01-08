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
	var stringifiedEmployee;
	var updatedEmployee = new Object();
	updatedEmployee.updateName = document.getElementById("updateName").value;
	updatedEmployee.updateEmail = document.getElementById("updateEmail").value;
	updatedEmployee.updateAddress = document.getElementById("updateAddress").value;
	updatedEmployee.updateCity = document.getElementById("updateCity").value;
	updatedEmployee.updateState = document.getElementById("updateState").value;
	updatedEmployee.updateZip = document.getElementById("updateZipcode").value;

	stringifiedEmployee = JSON.stringify(updatedEmployee);
	
	xhr.open("POST", "http://localhost:8080/ERS/html/updateEmployeeInformation.do", true);
	xhr.setRequestHeader("Content-Type","application/json");

	xhr.send(stringifiedEmployee);
}








