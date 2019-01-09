function deleteFnT() {
	if (confirm('Do you really wish to delete this from My Movies?') == true) {

		$.ajax({
			url : 'movieCartDeleteT.mv',
			type : 'POST',
			data : {
				'title' : $('#title').val(),
				'rlsDate' : $('#rlsDate').val(),
				'username' : $('#username').val()
			},
			success : function(data) {
				if (data == 1) {
					location.href = 'movieCartListT.mv?username='
							+ $('#username').val();
				} else {
					alert('Delete failed. Please try again.');
					return;
				}
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