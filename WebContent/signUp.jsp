<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>#MOTW :: Sign Up</title>
<link rel="stylesheet" href="css/reset.css">
<link rel="stylesheet" href="css/signUp.css">
<script src="js/jquery-3.3.1.js"></script>
<script src="js/pwCheck.js"></script>
<script src="js/nameCheck.js"></script>
<script src="js/emailCheck.js"></script>
<script src="js/signUpFn.js"></script>
<script>
	if(${sessionId ne null }){
		alert('You are already signed in.');
		history.go(-1);	
	}
	
	// input text 입력하고 enter키 치면 함수 실행
	function enterkey() {
        if (window.event.keyCode == 13) {
        	event.preventDefault();
        	signUpFn();
        }
	}
</script>
</head>
<body>
   <div id="wrap">
		<jsp:include page="header.jsp" />
		
		<div class="signUp">
			<form action="signUp.mo" method="post" name="signUpForm" id="signUpForm">
				<ul>
				    <li class="top">
                        <img src="img/logo_v3.png" alt="logo">
				        <h1>Sign Up</h1>    
				    </li>
					<li>
                        <span>Username</span> 
                        <input type="text" name="username" id="username" maxlength="30" onkeyup="nameCheck()" onkeydown="enterkey()">
                        <input type="hidden" name="nameCh" id="nameCh" value="unchecked"/>
					</li>
					<li>
                        <span>Password</span><span class="desc">*8 - 20 characters including letters and numbers</span>
				        <input type="password" name="userPw" id="userPw" maxlength="30" onkeyup="pwCheck()" onkeydown="enterkey()">
					</li>
					<li>
                        <span>Re-enter Password</span>
				        <input type="password" id="userPw2" maxlength="30" onkeyup="pwCheck()" onkeydown="enterkey()">
					</li>
					<li>
                        <span>Email</span>
				        <input type="text" name="userEmail" maxlength="30" id="userEmail" onkeyup="emailCheck()" onkeydown="enterkey()">
				        <input type="hidden" name="emailCh" id="emailCh" value="unchecked"/>
					</li>
                    <li>
                        <input type="button" value="Sign Up" onclick="signUpFn()"/>
                        <!-- input 하나라서 엔터키 submit이 자동으로 적용됨. 방지 위해 hidden input 추가 -->
			            <input style="visibility: hidden; width: 0px;">
                    </li>
					<span class="acc">Already have an account? <a class="acc" href="signInForm.mo">Sign in!</a></span>
				</ul>
			</form>
		</div>
		
	</div>
</body>
</html>