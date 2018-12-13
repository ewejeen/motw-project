function deleteFnT() {
	var username = $('#username');
	var title = $('#title');

	if (confirm('Do you really wish to delete this from My Movies?') == true) {

		$.ajax({
			url : "movieCartDeleteT.mv",
			type : 'POST',
			data : {
				"username" : username.val(),
				"title" : title.val()
			},
			success : function(data) {
				location.href = 'movieCartListT.mv?username=' + username.val();
			},
			error : function(jqXHR, textStatus, errorThrown) {
				alert('Delete failed. Please try again.');
				return;
			}
		});

	} else {
		return;
	}
}