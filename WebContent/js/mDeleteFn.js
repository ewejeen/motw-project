function mDeleteFn() {
	var userPw = $('#userPw');
	var userPw2 = $('#userPw2');
	var form = $('#memberDeleteForm');
	console.log(userPw.val());
	console.log(userPw2.val());
	if (userPw.val() != userPw2.val()) {
		alert('Incorrect password. Please try again.');
	} else {
		if (confirm('Do you really wish to delete your account?') == true) {
			form.submit();
		}
	}
}