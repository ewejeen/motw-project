<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	Cookie[] cookies = request.getCookies();
	String cookieId = "";
	String cookiePw = "";
	if(cookies != null){	// 쿠키 cookies가 null이 아니라면 cookieId와 cookiePw 가져옴
		for(int i=0;i<cookies.length;i++){
			if(cookies[i].getName().trim().equals("cookieId")){
				cookieId = cookies[i].getValue();
			}
			if(cookies[i].getName().trim().equals("cookiePw")){
				cookiePw = cookies[i].getValue();
			}
		}
	}
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/reset.css" media="all" />
<link rel="stylesheet" href="css/signIn.css" media="all" />
<title>#MOTW :: Sign In</title>
<script src="js/signInFn.js"></script>
<script>
	if(${sessionId ne null }){
		alert('You are already signed in.');
		history.go(-1);	
	}

	function enterkey() {
        if (window.event.keyCode == 13) {
        	signInFn();
        }
	}
</script>
</head>
<body>
	<div id="wrap">
		<jsp:include page="header.jsp" />
		
		<div class="signIn">
			<div class="signInForm">
				<ul>
				    <li class="top">
                        <img src="img/logo_v3.png" alt="logo">
				        <h1>Sign In</h1>    
				    </li>
					
					<li>
                        <span>Username</span> 
                        <a class="fg" href="nameFind.jsp">Forgot username?</a>
                        <input type="text" name="username" id="username" value="<%=cookieId%>" onkeyup="enterkey()">
					</li>
					<li>
                        <span>Password</span> 
                        <a class="fg" href="pwFind.jsp">Forgot password?</a> 
				        <input type="password" name="userPw" id="userPw" value="<%=cookiePw%>" onkeyup="enterkey()">
					</li>
					<li>
                        <input type="checkbox" name="autoIn" id="autoIn"/>
                        <p>Remember me</p>
                    </li>
                    <li>
                        <input type="button" value="Sign in" onclick="signInFn()" />
                    </li>
					<span class="noacc">Don't have an account? <a class="noacc" href="signUp.jsp">Sign up now!</a></span>
				</ul>
			</div>
		</div>
	</div>
</body>
</html>