$(document).ready(function() {
	$('#username').val(Cookies.get('key'));
	if ($('#username').val() != '') {
		$('#autoIn').attr('checked', true);
	}

	$('#autoIn').change(function() {
		if ($('#autoIn').is(':checked')) {
			Cookies.set('key', $('#username').val(), {
				expires : 7
			});
		} else {
			Cookies.remove('key');
		}
	});

	$('#username').keyup(function() {
		if ($('#autoIn').is(':checked')) {
			Cookies.set('key', $('#username').val(), {
				expires : 7
			});
		}
	});
});