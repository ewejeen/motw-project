<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/reset.css" media="all" />
<link rel="stylesheet" href="css/signUpOk.css" media="all" />
<title>#MOTW :: Sign Up</title>
</head>
<body>
	<div id="wrap">
		<jsp:include page="header.jsp" />
		<div class="signUpOk">
			<ul>
			    <li class="top">
                    <img src="img/logo_v3.png" alt="logo">
			        <h1>Sign Up</h1>    
			    </li>
				<li>
                	<span>Welcome! You are successfully signed up.</span>
				</li>
				<li>
					<input type="button" value="Sign In" onclick="location.href='signInForm.mo'"/>
					<input type="button" value="Go to Main Page" onclick="location.href='index.jsp'"/>
				</li>
			</ul>
		</div>
	</div>
</body>
</html>