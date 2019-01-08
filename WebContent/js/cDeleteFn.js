function cDeleteFn(no) {
	if (confirm('Do you really wish to delete this post?') == true) {
		$.ajax({
			url : 'cDelete.bo',
			type : 'POST',
			data : {
				'no' : no
			},
			success : function(data) {
				if (data == 1) {
					alert('Delete successful.');
					location.href = 'cList.bo';
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
	}
}