<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add to my movies</title>
<link rel="stylesheet" href="css/addCart.css" media="all" />
</head>
<body>
	<div class="addCart">
		<div class="container">
			<c:choose>
				<c:when test="${param.addNum==0 }">
					<p>You have already added this to My Movies.</p>
				</c:when>
				<c:otherwise>
					<p>${param.addNum }
						movie was added to My Movies.<br>
					</p>
				</c:otherwise>
			</c:choose>

			<a onclick="sub(event)">Go to My Movies</a>
			<a href="#" onclick="self.close()">CLOSE</a>
		</div>
	</div>
</body>
<script>
	function sub(event){
		event.preventDefault();
		if(${sessionId eq null}){
			window.opener.top.location.href="movieCartListS.mv";				
		} else{
			window.opener.top.location.href="movieCartListT.mv?username=${sessionId }";				
		}
		//window.opener.top.location.reload();//새로고침
		window.close()
	}
</script>
</html>