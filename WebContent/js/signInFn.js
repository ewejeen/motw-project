function validateEncryptedForm() {
	var username = document.getElementById("username");
	var userPw = document.getElementById("userPw");

	if (username.value == null || username.value == "") {
		alert('Enter username.');
		username.focus();
		return false;
	}
	if (userPw.value == null || userPw.value == "") {
		alert('Enter password.');
		userPw.focus();
		return false;
	}

	try {
		var rsaPublicKeyModulus = document
				.getElementById("rsaPublicKeyModulus").value;
		var rsaPublicKeyExponent = document
				.getElementById("rsaPublicKeyExponent").value;
		submitEncryptedForm(username.value, userPw.value, rsaPublicKeyModulus,
				rsaPublicKeyExponent);
	} catch (err) {
		alert(err);
	}
	return false;
}

function submitEncryptedForm(username, userPw, rsaPublicKeyModulus,
		rsaPpublicKeyExponent) {
	var rsa = new RSAKey();
	rsa.setPublic(rsaPublicKeyModulus, rsaPpublicKeyExponent);

	// 사용자ID와 비밀번호를 RSA로 암호화한다.
	var securedName = rsa.encrypt(username);
	var securedPw = rsa.encrypt(userPw);

	// POST 로그인 폼에 값을 설정하고 submit 한다.
	var signInFormRSA = document.getElementById("signInFormRSA");
	signInFormRSA.securedName.value = securedName;
	signInFormRSA.securedPw.value = securedPw;
	signInFormRSA.submit();
}