function replyFn() {
	var username = document.getElementById('username');
	var content = document.getElementById('content');

	if (username.value == null || username.value == "") {
		alert('Sign in is required.');
		location.href = 'signIn.jsp';
		return;
	}

	if (content.value == null || content.value == "") {
		alert('Enter comment.');
		content.focus();
		return;
	}

	ajaxReplyFn();
}

var xhr = new XMLHttpRequest();
function ajaxReplyFn() {
	var cGroup = document.getElementById('cGroup');
	var indent = document.getElementById('indent');
	var step = document.getElementById('step');
	var content = document.getElementById('content');
	var username = document.getElementById('username');

	var url = 'cReply.bo';
	var data = '?cGroup=' + cGroup.value + '&indent=' + indent.value + '&step='
			+ step.value + '&content='
			+ content.value + '&username=' + username.value;

	xhr.open('post', url + data, true);
	xhr.setRequestHeader('Content-Type',
			'application/x-www-urlencoded;charset=utf8');
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			replyList();
			content.value = "";
		}
	};
	xhr.send(null);
}