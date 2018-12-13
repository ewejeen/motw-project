function replyDeleteFn(no) {
	if (confirm('Do you really wish to delete this comment?') == true) {
		$.ajax({
			url : 'cDelete.bo',
			type : 'POST',
			data : {
				'no' : no
			},
			success : function(data) {
				replyList();
			},
			error : function(jqXHR, textStatus, errorThrown) {
				alert('Delete failed. Please try again.');
				return;
			}
		});
	}
}
