function cDeleteFn(no) {
	if (confirm('Do you really wish to delete this post?') == true) {
		$.ajax({
			url : "cDelete.bo",
			type : 'POST',
			data : {
				"no" : no
			},
			success : function(data) {
				alert('Delete successful.');
				location.href = 'cList.bo';
			},
			error : function(jqXHR, textStatus, errorThrown) {
				alert('Delete failed. Please try again.');
				return;
			}
		});
	}
}