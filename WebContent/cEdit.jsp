<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/cEdit.css" media="all" />
<title>#MOTW :: Edit</title>
<script>
	if(${sessionId eq null || sessionId ne dto.username}){
		alert('Access denied.');
		history.go(-1);	
	}
</script>
<script src="js/jquery-3.3.1.js"></script>
<script src="js/searchFn.js"></script>
<script src="js/cEdit.js"></script>
</head>
<body>
	<div id="wrap">
		<jsp:include page="header.jsp" />
		
		<div class="cEdit">
			<div class="container">
				<jsp:include page="commTop.jsp"/>
				<div class="con">
					<div class="editForm">
						<div class="ttl"><h1>Edit</h1></div>    
						<ul>
							<li>
		                        <span>Username</span> 
		                        <input type="hidden" name="no" id="no" value="${dto.no }" />
		                        <input type="text" name="username" id="username" value="${dto.username }" readonly>
							</li>
							<li>
		                        <span>Title</span>
						        <input type="text" name="title" id="title" value="${dto.title }" autofocus="autofocus">
							</li>
							<li>
		                        <span>Content</span>
		                        <textarea name="content" id="content" cols="30" rows="10">${dto.content }</textarea>
							</li>
		                    <li>
		                        <input type="button" value="Edit" onclick="cEdit()"/>
		                    </li>
						</ul>
					</div>
				</div>
			</div>
		</div>
		<jsp:include page="footer.jsp" />
	</div>
</body>
</html>