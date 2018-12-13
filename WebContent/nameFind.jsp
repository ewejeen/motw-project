<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>#MOTW :: Find Username</title>
<link rel="stylesheet" href="css/nameFind.css" media="all" />
<script src="js/nameFindFn.js"></script>
</head>
<body>
	<div id="wrap">
		<jsp:include page="header.jsp" />
		<div class="nameFind">
			<form action="nameFind.mo" method="post" name="nameFindForm" id="nameFindForm">
				<ul>
				    <li class="top">
                        <img src="img/logo_v3.png" alt="logo">
				        <h1>Find Username</h1>    
				    </li>
					<li>
                        <span>Enter your <span style="text-decoration: underline;">email</span> to find your username</span>
                        <input type="text" name="userEmail" id="userEmail" placeholder="Your email">
					</li>
                    <li>
                        <input type="button" value="Find Username" onclick="nameFindFn()" />
                    </li>
					
				</ul>
			</form>
		</div>
	</div>
</body>
</html>	