<%@page import="org.prj.MemberDTO.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>#MOTW :: Edit Profile</title>
<link rel="stylesheet" href="css/mModify.css" media="all" />
<script src="js/jquery-3.3.1.js"></script>
<script src="js/pwCheck.js"></script>
<script src="js/mModify.js"></script>
<script>
	if(${sessionId eq null }){
		alert('Sign in is required.');
		location.href='signInForm.mo';		
	}
	
	function enterkey() {
        if (window.event.keyCode == 13) {
        	mModify();
        }
	}
</script>
</head>
<body>
	<div id="wrap">
		<jsp:include page="header.jsp" />
		<div class="mypage">
			<div class="container">
				<jsp:include page="conLeftNav.jsp" />
				<div class="rightCon">
					<div class="mModify">
						<div class="modifyForm">
							<ul>
							    <li class="top">
			                        <img src="img/logo_v3.png" alt="logo">
							        <h1>Edit Profile</h1>    
							    </li>
								
								<li>
			                        <span>Username</span> 
			                        <input type="text" name="username" id="username" maxlength="30" value="${sessionId }" disabled >
								</li>
								<li>
			                        <span>Password</span>
							        <input type="password" name="userPw" id="userPw" maxlength="30" value="${dto.userPw }" onkeydown="enterkey()">
								</li>
								<li>
			                        <span>Re-enter Password</span>
							        <input type="password" id="userPw2" maxlength="30" onkeyup="pwCheck()" onkeydown="enterkey()">
								</li>
								<li>
			                        <span>Email</span>
							        <input type="text" name="userEmail" maxlength="30" id="userEmail" value="${dto.userEmail }" onkeyup="emailCheck()" onkeydown="enterkey()">
							        <input type="hidden" name="emailCh" id="emailCh" value="unchecked"/>
								</li>
			                    <li>
			                        <input type="button" value="Edit" onclick="mModify()"/>
			                    </li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="footer.jsp" />
	<script>
		$('.leftNav li:nth-child(3) a').css({
		    'font-size':'18px',
		    'font-weight':'bold'
		});
	</script>

	<script>
	 	/* 이메일 변경을 안 하면 중복 검사에서 걸리므로 안 걸리게 하기 위해 emailCheck 함수 재정의 */
	 	/* EL 쓰므로 js파일 분리 X */
		var userEmail=document.getElementById('userEmail');
	 	if(userEmail.value=='${dto.userEmail }'){
			document.getElementById('emailCh').value='checked';
	 		userEmail.style.background = 'url("img/checked.png") no-repeat 50%';
			userEmail.style.backgroundSize = '20px 20px';
			userEmail.style.backgroundPosition = '96% 50%';
	 	}
	
	 	var xhr = new XMLHttpRequest();
	
	 	function emailCheck() {
	 		var userEmail = document.getElementById('userEmail');
	 		var url = 'emailCheck.mo';
	 		var data = '?userEmail=' + encodeURI(userEmail.value);
	
	 		xhr.open('post', url + data, true);
	 		xhr.setRequestHeader('Content-Type',
	 				'application/x-www-urlencoded;charset=utf8');
	 		xhr.onreadystatechange = emailCheckOk;
	 		xhr.send(null)
	 	}
	
	 	function emailCheckOk() {
	 		if (xhr.readyState == 4 && xhr.status == 200) {
	 			var result = xhr.responseText;
	 			var userEmail = document.getElementById('userEmail');
	 			var emailCh = document.getElementById('emailCh');
	 			if (result == 1) {
	 				userEmail.style.background = 'url("img/cancel.png") no-repeat 50%';
	 				userEmail.style.backgroundSize = '20px 20px';
	 				userEmail.style.backgroundPosition = '96% 50%';
	 				emailCh.value = 'unchecked';
	 			} else if(result == 0 || emailCh.value=='checked') {
	 				userEmail.style.background = 'url("img/checked.png") no-repeat 50%';
	 				userEmail.style.backgroundSize = '20px 20px';
	 				userEmail.style.backgroundPosition = '96% 50%';
	 				emailCh.value = 'checked';
	 			}
	 		}
	 	}
	 </script>
</body>
</html>