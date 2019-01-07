
/*
비밀번호 정규식
/^.*(?=.{8,20})(?=.*[0-9])(?=.*[a-zA-Z]).*$/
영문, 숫자 혼합. 최소 8글자, 최대 20글자로 구성.
 */

function validatePw(elementValue) {
	var pwPattern = /^.*(?=.{8,20})(?=.*[0-9])(?=.*[a-zA-Z]).*$/;
	if (pwPattern.test(elementValue) == false) {
		return false;
	} else {
		return true;
	}
}

function pwCheck() {
	var pw = $('#userPw');
	var pw2 = $('#userPw2');

	if (pw.val() == null || pw.val() == "" || pw2.val() == null
			|| pw2.val() == "") {
		return false;
	}

	if (pw.val() == pw2.val() && validatePw(pw.val()) == true) {
		pw2.css({
			'background' : 'url("img/checked.png") no-repeat 50%',
			'background-size' : '20px 20px',
			'background-position' : '96% 50%'
		});
		return true;
	} else if (pw.val() != pw2.val()) {
		pw2.css({
			'background' : 'url("img/cancel.png") no-repeat 50%',
			'background-size' : '20px 20px',
			'background-position' : '96% 50%'
		});
		return false;
	} else if(validatePw(pw.val()) == false){
		pw2.css({
			'background' : 'url("img/cancel.png") no-repeat 50%',
			'background-size' : '20px 20px',
			'background-position' : '96% 50%'
		});
		return 2;
	}
}