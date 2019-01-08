function replyFn() {
	var username = $('#username');
	var content = $('#content');

	// 세션아이디 (input:hidden)
	if (username.val() == null || username.val() == '') {
		denied();
		return;
	}

	if (content.val() == null || content.val() == '') {
		alert('Enter comment.');
		content.focus();
		return;
	}

	ajaxReplyFn();
}

function ajaxReplyFn() {
	$.ajax({
		url : 'cReply.bo',
		type : 'POST',
		data : {
			'cGroup' : $('#cGroup').val(),
			'indent' : $('#indent').val(),
			'step' : $('#step').val(),
			'content' : $('#content').val(),
			'username' : $('#username').val()
		},
		success : function(data) {
			if (data == 1) {
				replyList();
				$('#content').val('');
			} else {
				alert('Failed.');
			}
		},
		error : function(jqXHR, textStatus, errorThrown) {
			alert('Failed.');
		}
	});
}