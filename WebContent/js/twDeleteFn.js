function twDeleteFn() {
	var no = $('#no');

	if (confirm('Do you really wish to delete this movie?') == true) {

		$.ajax({
			url : "movieDelete.mv",
			type : 'POST',
			data : {
				"no" : no.val()
			},
			success : function(data) {
				location.href = 'movieList.mv';
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