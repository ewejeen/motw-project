<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>#MOTW :: Register a movie</title>
<script>
	if(${sessionId eq null }){
		alert('Access denied.');
		history.go(-1);	
	} else if(${sessionId != 'admin'}){
		alert('Only admin can register movies.');
		history.go(-1);
	}
</script>
<script src="js/jquery-3.3.1.js"></script>
<script src="js/searchFn.js"></script>
<script src="js/twWrite.js"></script>
<link rel="stylesheet" href="css/twWrite.css" media="all" />
</head>
<body>
	<div id="wrap">
		<jsp:include page="header.jsp" />
		
		<div class="twWrite">
			<div class="container">
				<jsp:include page="twTop.jsp" />
				
				<div class="con">
					<form action="movieRegister.mv" method="post" enctype="multipart/form-data" name="twWriteForm" id="twWriteForm">
						<div class="ttl"><h1>Register</h1></div>    
						<ul>
							<li>
		                        <span>Title</span>
		                        <input type="hidden" name="username" id="username" value="${sessionId }" />
						        <input type="text" name="title" id="title"  >
							</li>
							<li>
		                        <span>Release Date</span> 
		                        <input type="text" name="rlsDate" id="rlsDate">
							</li>
							<li>
		                        <span>Director</span>
						        <input type="text" name="director" id="director"  >
							</li>
							<li>
		                        <span>Stars</span> 
		                        <input type="text" name="stars" id="stars">
							</li>
							<li>
		                        <span>Catchphrase</span> 
		                        <input type="text" name="catchph" id="catchph">
							</li>
							<li>
		                        <span>Content</span>
		                        <textarea name="content" id="content" cols="30" rows="10"></textarea>
							</li>
							<li class="image">
								<span>Image</span>
								<input type="file" name="image" id="image" />
							</li>
							<li>
								<span>YouTube</span>
								<input type="text" name="youtube" id="youtube" />
							</li>
							<li>
								<span>Wikipedia</span>
								<input type="text" name="wiki" id="wiki" />
							</li>
							<li>
								<span>IMDB</span>
								<input type="text" name="imdb" id="imdb" />
							</li>
							<li>
								<span>Rotten Tomatoes</span>
								<input type="text" name="rotten" id="rotten" />
							</li>
		                    <li>
		                        <input type="button" value="Register" onclick="twWrite()"/>
		                    </li>
						</ul>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>