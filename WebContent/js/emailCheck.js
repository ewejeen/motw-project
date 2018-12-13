/* 이메일 주소 정규식
/^[a-zA-Z0-9._-]+
아이디가 반드시 알파벳 혹은 숫자로 시작. 알파벳은 대소문자를 모두 허용. 추가로 마침표(.), 밑줄(_), 하이픈(–)을 사용 가능.
@
반드시 @ 들어가야 함.
[a-zA-Z0-9.-]+
@ 다음에 오는 회사 도메인 주소는 아이디 부분과 동일 조건. (밑줄( _ )은 사용X, 필요에 따라 추가 가능.)
\.
회사 도메인명 다음에는 반드시 마침표( . ) 찍음. 회사 도메인 다음에 오는 com, co 같은 상위 그룹 도메인 구별.
[a-zA-Z]{2,4}$/
마지막으로 com, co와 같은 상위 도메인 규칙 정의. 대소문자를 모두 허용, 2~4글자의 알파벳. {2,4}는 각각 최소, 최대 글자 수를 지칭.
 */
function validateEmail(elementValue) {
	var emailPattern = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;
	if (emailPattern.test(elementValue) == false) {
		return false;
	} else {
		return true;
	}
}

var xhr = new XMLHttpRequest();

function emailCheck() {
	var userEmail = document.getElementById('userEmail');

	var url = 'emailCheck.mo';
	var data = '?userEmail=' + encodeURI(userEmail.value);

	xhr.open('post', url + data, true);
	xhr.setRequestHeader('Content-Type',
			'application/x-www-urlencoded;charset=utf8');
	xhr.onreadystatechange = emailCheckOk;
	xhr.send(null)
}

function emailCheckOk() {
	if (xhr.readyState == 4 && xhr.status == 200) {
		var result = xhr.responseText;
		var userEmail = document.getElementById('userEmail');
		var emailCh = document.getElementById('emailCh');
		if (result == 1 || validateEmail(userEmail.value) == false) {
			userEmail.style.background = 'url("img/cancel.png") no-repeat 50%';
			userEmail.style.backgroundSize = '20px 20px';
			userEmail.style.backgroundPosition = '96% 50%';
			emailCh.value = 'unchecked';
		} else if (result != 1 || validateEmail(userEmail.value) == true) {
			userEmail.style.background = 'url("img/checked.png") no-repeat 50%';
			userEmail.style.backgroundSize = '20px 20px';
			userEmail.style.backgroundPosition = '96% 50%';
			emailCh.value = 'checked';
		}
	}
}