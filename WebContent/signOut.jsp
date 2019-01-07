<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>#MOTW :: Sign Out</title>
</head>
<body>
	<script>
		window.onload = function() {
			if (confirm('Do you really wish to sign out?') == true) {
				location.href = 'signOutOk.jsp';
				return false;
			} else {
				history.go(-1);
				return false;
			}
		}
	</script>

</body>
</html>