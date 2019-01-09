function twEdit() {
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
		alert('Enter catchphrase.');
		$('#catchph').focus();
		return false;
	}

	if (confirm('Edit this movie?') == true) {

		$.ajax({
			url : 'movieEdit.mv',
			type : 'POST',
			data : {
				'no' : $('#no').val(),
				'title' : $('#title').val(),
				'content' : $('#content').val(),
				'catchph' : $('#catchph').val(),
				'director' : $('#director').val(),
				'stars' : $('#stars').val(),
				'rlsDate' : $('#rlsDate').val(),
				'rotten' : $('#rotten').val(),
				'imdb' : $('#imdb').val(),
				'wiki' : $('#wiki').val(),
				'youtube' : $('#youtube').val()
			},
			success : function(data) {
				if (data == 1) {
					location.href = 'movieView.mv?title=' + $('#title').val();
				} else {
					alert('Edit failed. Please try again.');
					return;
				}
			},
			error : function(jqXHR, textStatus, errorThrown) {
				alert('Edit failed. Please try again.');
				return;
			}
		});

	} else {
		return;
	}
}