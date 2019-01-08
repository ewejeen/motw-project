function replyDeleteFn(no) {
	if (confirm('Do you really wish to delete this comment?') == true) {
		$.ajax({
			url : 'cDelete.bo',
			type : 'POST',
			data : {
				'no' : no
			},
			success : function(data) {
				if (data == 1) {
					replyList();
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
