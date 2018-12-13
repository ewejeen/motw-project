<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>#MOTW :: Find Password</title>
<link rel="stylesheet" href="css/pwFind.css" media="all" />
<script src="js/pwFindFn.js"></script>
</head>
<body>
	<div id="wrap">
		<jsp:include page="header.jsp" />
		<div class="pwFind">
			<form action="pwFind.mo" method="post" name="pwFindForm" id="pwFindForm">
				<ul>
				    <li class="top">
                        <img src="img/logo_v3.png" alt="logo">
				        <h1>Find Password</h1>    
				    </li>
					<li>
                        <span>Enter your <span style="text-decoration: underline;">email and username</span> to find your password</span>
                        <input type="text" name="username" id="username" placeholder="Your username">
					</li>
					<li>
                        <input type="text" name="userEmail" id="userEmail" placeholder="Your email">					
					</li>
                    <li>
                        <input type="button" value="Find Password" onclick="pwFindFn()" />
                    </li>
				</ul>
			</form>
		</div>
	</div>
</body>
</html>	