function mManageDelete(username, userPw) {
	console.log(username);
	console.log(userPw);
	if (confirm('Do you really wish to delete this member?') == true) {

		$.ajax({
			url : "manageDelete.mo",
			type : 'POST',
			data : {
				"username" : username,
				"userPw" : userPw
			},
			success : function(data) {
				alert('Delete successful.');
				window.location.reload();
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