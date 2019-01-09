function deleteFnS(no) {
	if (confirm('Do you really wish to delete this from My Movies?') == true) {

		$.ajax({
			url : 'movieCartDeleteS.mv',
			type : 'POST',
			data : {
				'no' : no
			},
			success : function(data) {
				if (data == 1) {
					location.href = 'movieCartListS.mv';
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