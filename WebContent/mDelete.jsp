<%@page import="org.prj.MemberDTO.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>#MOTW :: Delete Account</title>
<link rel="stylesheet" href="css/mDelete.css" media="all" />
<script src="js/jquery-3.3.1.js"></script>
<script src="js/mDeleteFn.js"></script>
<script>
	if(${sessionId eq null }){
		alert('Sign in is required.');
		location.href='signInForm.mo';
	}
	
	// input text 입력하고 enter키 치면 함수 실행
	function enterkey() {
        if (window.event.keyCode == 13) {
        	event.preventDefault();
        	mDeleteFn();
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
					<div class="mDelete">
						<form action="memberDelete.mo" method="post" name="memberDeleteForm" id="memberDeleteForm">
							<ul>
							    <li class="top">
			                        <img src="img/logo_v3.png" alt="logo">
							        <h1>Delete Account</h1>    
							    </li>
								<li>
			                        <span>Please verify your password to delete your account.</span>
			                        <input type="hidden" name="username" id="username" value="${sessionId }" />
							        <input type="password" name="userPw" id="userPw" onkeyup="enterkey()">
							        <input type="hidden" name="userPw2" id="userPw2" value="${dto.userPw }" />
								</li>
			                    <li>
			                        <input type="button" value="Delete account" onclick="mDeleteFn()" />
			                        <!-- input 하나라서 엔터키 submit이 자동으로 적용됨. 방지 위해 hidden input 추가 -->
			                        <input style="visibility: hidden; width: 0px;">
			                    </li>
							</ul>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="footer.jsp" />
	<script>
		$('.leftNav li:nth-child(4) a').css({
		    'font-size':'18px',
		    'font-weight':'bold'});	
	</script>
</body>
</html>