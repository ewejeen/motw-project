var like1 = document.getElementById('like1');
var like2 = document.getElementById('like2');

var no = document.getElementById('no');
var username = document.getElementById('username');
var likeCheck = document.getElementById('likeCheck');

var xhr = new XMLHttpRequest();
function likeFn() {
	var url = 'cLike.bo';
	var data = '?boardno=' + no.value + '&username=' + username.value
			+ '&likeCheck=' + likeCheck.value;

	xhr.open('post', url + data, true);
	xhr.setRequestHeader('Content-Type',
			'application/x-www-urlencoded;charset=utf8');
	xhr.onreadystatechange = likeOk;
	xhr.send(null);
}
function likeOk() {
	if (xhr.readyState == 4 && xhr.status == 200) {
		var result = xhr.responseText;
		if (result == 1) {
			likeCheck.value = 1;
			like1.style.display = 'none';
			like2.style.display = 'block';

			replyList();
		}
	}
}

function unlikeFn() {
	var url = 'cUnlike.bo';
	var data = '?boardno=' + no.value + '&username=' + username.value
			+ '&likeCheck=' + likeCheck.value;

	xhr.open('post', url + data, true);
	xhr.setRequestHeader('Content-Type',
			'application/x-www-urlencoded;charset=utf8');
	xhr.onreadystatechange = unlikeOk;
	xhr.send(null);
}
function unlikeOk() {
	if (xhr.readyState == 4 && xhr.status == 200) {
		var result = xhr.responseText;
		if (result == 1) {
			likeCheck.value = 0;
			like1.style.display = 'block';
			like2.style.display = 'none';

			replyList();
		}
	}
}