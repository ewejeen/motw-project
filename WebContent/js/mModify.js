function mModify() {
	var name = $('#username');
	var pw = $('#userPw');
	var pw2 = $('#userPw2');
	var email = $('#userEmail');
	var emailCh = $('#emailCh');

	if (pw.val() == null || pw.val() == "") {
		alert('Enter password.');
		pw.focus();
		return;
	}
	if (pw2.val() == null || pw2.val() == "" || pwCheck() == false) {
		alert('Confirm password.');
		pw2.focus();
		return;
	}
	if (email.val() == null || email.val() == "") {
		alert('Enter email.');
		email.focus();
		return;
	}
	if (emailCh.val() != "checked") {
		alert('Email is not valid.');
		email.focus();
		return;
	}

	if (confirm('Do you really wish to edit your profile?') == true) {
		$.ajax({
			url : 'memberModify.mo',
			type : 'POST',
			data : {
				'username' : name.val(),
				'userPw' : pw.val(),
				'userEmail' : email.val()
			},
			success : function(data) {
				alert('Edit successful.');
				location.href = 'memberView.mo?username=' + name.val();
			},
			error : function(jqXHR, textStatus, errorThrown) {
				alert('Edit failed. Please try again.');
				return;
			}
		});
	}
}