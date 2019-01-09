function twDeleteFn() {
	if (confirm('Do you really wish to delete this movie?') == true) {

		$.ajax({
			url : 'movieDelete.mv',
			type : 'POST',
			data : {
				'no' : $('#no').val()
			},
			success : function(data) {
				if (data == 1) {
					location.href = 'movieList.mv';
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