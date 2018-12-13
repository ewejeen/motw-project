function cEdit() {
	if ($('#title').val() == null || $('#title').val() == "") {
		alert('Enter title.');
		$('#title').focus();
		return;
	}
	if ($('#content').val() == null || $('#content').val() == "") {
		alert('Enter content.');
		$('#content').focus();
		return;
	}

	if (confirm('Edit this post?') == true) {

		$.ajax({
			url : "cEdit.bo",
			type : 'POST',
			data : {
				"no" : $('#no').val(),
				"title" : $('#title').val(),
				"content" : $('#content').val()
			},
			success : function(data) {
				location.href = 'cView.bo?no=' + $('#no').val();
			},
			error : function(jqXHR, textStatus, errorThrown) {
				alert('Edit failed. Please try again.');
				return;
			}
		});

	} else {
		return;
	}
}