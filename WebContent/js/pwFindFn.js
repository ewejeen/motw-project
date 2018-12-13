function pwFindFn() {
	var pwFindForm = document.pwFindForm;
	var username = document.getElementById('username');
	var userEmail = document.getElementById('userEmail');

	if (username.value == null || username.value == "") {
		alert('Enter username.');
		username.focus();
		return false;
	}
	if (userEmail.value == null || userEmail.value == "") {
		alert('Enter email.');
		userEmail.focus();
		return false;
	}

	pwFindForm.submit();
}