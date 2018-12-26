<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/reset.css" media="all" />
<link rel="stylesheet" href="css/signIn.css" media="all" />
<title>#MOTW :: Sign In</title>
<script src="js/signInFn.js"></script>
<script src="https://cdn.jsdelivr.net/npm/js-cookie@2/src/js.cookie.min.js"></script>
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
	<script>
	$('#username').val(Cookies.get('key'));      
	if($('#username').val() != ''){
		$('#autoIn').attr('checked', true);
	}
    
	$('#autoIn').change(function(){
	    if($('#autoIn').is(':checked')){
	        Cookies.set('key', $('#username').val(), { expires: 7 });
	    }else{
	        Cookies.remove('key');
	    }
	});
	     
	$('#username').keyup(function(){
	    if($('#autoIn').is(':checked')){
	        Cookies.set('key', $('#username').val(), { expires: 7 });
	    }
	});		
	</script>
</body>
</html>
