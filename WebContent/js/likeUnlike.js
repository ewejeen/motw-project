var like1 = $('#like1');
var like2 = $('#like2');

var no = $('#no');
var username = $('#username');
var likeCheck = $('#likeCheck');

function likeFn() {
	$.ajax({
		url : 'cLike.bo',
		type : 'POST',
		data : {
			'boardno' : no.val(),
			'username' : username.val()
		},
		success : function(data) {
			if (data == 1) {
				likeCheck.val(1);
				like1.css('display', 'none');
				like2.css('display', 'block');

				replyList();
			}
		},
		error : function(jqXHR, textStatus, errorThrown) {
			alert('Failed.');
			return;
		}
	});
}

function unlikeFn() {
	$.ajax({
		url : 'cUnlike.bo',
		type : 'POST',
		data : {
			'boardno' : no.val(),
			'username' : username.val()
		},
		success : function(data) {
			if (data == 1) {
				likeCheck.val(0);
				like1.css('display', 'block');
				like2.css('display', 'none');

				replyList();
			}
		}
	});
}