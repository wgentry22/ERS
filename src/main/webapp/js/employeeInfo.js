window.onload = function() {
	document.getElementById("btnUpdateEmployeeInformation").addEventListener("click", showUpdateInfo);
	
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

