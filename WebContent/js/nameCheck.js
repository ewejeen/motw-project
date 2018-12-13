/* 아이디 정규식
/^[a-z0-9_]{4,20}$/
아이디가 반드시 알파벳 혹은 숫자로 시작. 알파벳은 소문자만 허용. 추가로 밑줄(_) 사용 가능.
최소 4글자, 최대 20글자로 구성.
 */

function validateName(elementValue) {
	var namePattern = /^[a-z0-9_]{4,20}$/;
	if(namePattern.test(elementValue)==false){
		return false;
	} else{
		return true;
	}
}

var xhr = new XMLHttpRequest();

function nameCheck() {
	var username = document.getElementById('username');
	var url = 'nameCheck.mo';
	var data = '?username=' + encodeURI(username.value);

	xhr.open('post', url + data, true);
	xhr.setRequestHeader('Content-Type',
			'application/x-www-urlencoded;charset=utf8');
	xhr.onreadystatechange = nameCheckOk;
	xhr.send(null)
}

function nameCheckOk() {
	if (xhr.readyState == 4 && xhr.status == 200) {
		var result = xhr.responseText;
		var username = document.getElementById('username');
		var nameCh = document.getElementById('nameCh');		
		if (result == 1 || validateName(username.value)==false) {
			username.style.background = 'url("img/cancel.png") no-repeat 50%';
			username.style.backgroundSize = '20px 20px';
			username.style.backgroundPosition = '96% 50%';
			nameCh.value='unchecked';
		} else if (result != 1 || validateName(username.value)==true){
			username.style.background = 'url("img/checked.png") no-repeat 50%';
			username.style.backgroundSize = '20px 20px';
			username.style.backgroundPosition = '96% 50%';
			nameCh.value='checked';
		}
	}
}