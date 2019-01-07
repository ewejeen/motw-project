function nameFindFn() {
	var nameFindForm = document.nameFindForm;
	var userEmail = document.getElementById('userEmail');
	
	if (userEmail.value == null || userEmail.value == "") {
		alert('Enter email.');
		userEmail.focus();
		return false;
	}

	nameFindForm.submit();
}