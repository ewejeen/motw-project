function twWrite() {
	if ($('#title').val() == null || $('#title').val() == "") {
		alert('Enter title.');
		$('#title').focus();
		return false;
	}
	if ($('#rlsDate').val() == null || $('#rlsDate').val() == "") {
		alert('Enter release date.');
		$('#rlsDate').focus();
		return false;
	}
	if ($('#director').val() == null || $('#director').val() == "") {
		alert('Enter director.');
		$('#director').focus();
		return false;
	}
	if ($('#stars').val() == null || $('#stars').val() == "") {
		alert('Enter stars.');
		$('#stars').focus();
		return false;
	}
	if ($('#content').val() == null || $('#content').val() == "") {
		alert('Enter content.');
		$('#content').focus();
		return false;
	}
	if ($('#catchph').val() == null || $('#catchph').val() == "") {
		alert('Enter catchph.');
		$('#catchph').focus();
		return false;
	}
	if ($('#image').val() == null || $('#image').val() == "") {
		alert('Enter image.');
		$('#image').focus();
		return false;
	}

	if (confirm('Register this movie?') == true) {
		$('#twWriteForm').submit();
	}
}