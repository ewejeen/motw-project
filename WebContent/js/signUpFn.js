function signUpFn() {
	var name = $('#username');
	var pw = $('#userPw');
	var pw2 = $('#userPw2');
	var email = $('#userEmail');
	var nameCh = $('#nameCh');
	var emailCh = $('#emailCh');

	if (name.val() == null || name.val() == '') {
		alert('Enter username.');
		name.focus();
		return;
	}
	if (nameCh.val() == 'unchecked') {
		alert('Username is not valid.');
		name.focus();
		return;
	}

	if (pw.val() == null || pw.val() == '') {
		alert('Enter password.');
		pw.focus();
		return;
	}
	if(validatePw(pw.val()) == false){
		alert('Password is not valid.');
		pw.focus();
		return;
	}
	if (pw2.val() == null || pw2.val() == '' || pwCheck() == false) {
		alert('Confirm password.');
		pw2.focus();
		return;
	}
	if (email.val() == null || email.val() == '') {
		alert('Enter email.');
		email.focus();
		return;
	}
	if (emailCh.val() != 'checked') {
		alert('Email is not valid.');
		email.focus();
		return;
	}

	if (confirm('Proceed sign up.') == true) {
		signUpForm.submit();
	} else {
		return;
	}

}