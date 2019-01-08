function searchFn() {
	if ($('#search').val() == null || $('#search').val() == '') {
		alert('Enter what you want to search.');
		$('#search').focus();
		return;
	}

	$('#searchForm').submit();
}