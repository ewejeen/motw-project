function cWrite() {
	if ($('#title').val() == null || $('#title').val() == '') {
		alert('Enter title.');
		$('#title').focus();
		return;
	}
	if ($('#content').val() == null || $('#content').val() == '') {
		alert('Enter content.');
		$('#content').focus();
		return;
	}

	$('#writeForm').submit();
}