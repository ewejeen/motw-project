function mManageDelete(username, userPw) {
	if (confirm('Do you really wish to delete this member?') == true) {

		$.ajax({
			url : 'manageDelete.mo',
			type : 'POST',
			data : {
				'username' : username,
				'userPw' : userPw
			},
			success : function(data) {
				if (data == 1) {
					alert('Delete successful.');
					window.location.reload();
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