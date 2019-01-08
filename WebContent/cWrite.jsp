<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/cWrite.css" media="all" />
<title>#MOTW :: Write</title>
<script>
	if(${sessionId eq null }){
		alert('Sign in is required.');
		location.href='signInForm.mo';		
	}
</script>
<script src="js/searchFn.js"></script>
<script src="js/cWrite.js"></script>
</head>
<body>
	<div id="wrap">
		<jsp:include page="header.jsp" />
		
		<div class="cWrite">
			<div class="container">
				<jsp:include page="commTop.jsp" />
				<div class="con">
					<form action="cWrite.bo" method="post" name="writeForm" id="writeForm">
						<div class="ttl"><h1>Write</h1></div>    
						<ul>
							<li>
		                        <span>Username</span> 
		                        <input type="text" name="username" id="username" value="${sessionId }" readonly>
							</li>
							<li>
		                        <span>Title</span>
						        <input type="text" name="title" id="title"  >
							</li>
							<li>
		                        <span>Content</span>
		                        <textarea name="content" id="content" cols="30" rows="10"></textarea>
							</li>
		                    <li>
		                        <input type="button" value="Publish" onclick="cWrite()"/>
		                    </li>
						</ul>
					</form>
				</div>
			</div>
		</div>
		<jsp:include page="footer.jsp" />
	</div>
</body>
</html>