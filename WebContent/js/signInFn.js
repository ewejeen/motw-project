function signInFn() {
	var name = $('#username');
	var pw = $('#userPw');

	if (name.val() == null || name.val() == "") {
		alert('Enter username.');
		name.focus();
		return false;
	}
	if (pw.val() == null || pw.val() == "") {
		alert('Enter password.');
		pw.focus();
		return false;
	}

	ajaxSignIn();
}

var xhr = new XMLHttpRequest();
function ajaxSignIn() {
	var url = 'signIn.mo';
	var data = '?username=' + username.value + '&userPw=' + userPw.value;

	xhr.open('post', url + data, true);
	xhr.setRequestHeader('Content-Type',
			'application/x-www-urlencoded;charset=utf8');
	xhr.onreadystatechange = ajaxSignInOk;
	xhr.send(null);
}

function ajaxSignInOk() {
	if (xhr.readyState == 4 && xhr.status == 200) {
		var result = xhr.responseText;
		if (result == 1) {
			location.href = 'index.jsp';
		} else {
			alert('Incorrect username or password. Please try again.');
			return;
		}
	}
}