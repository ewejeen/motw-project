<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="css/reset.css" media="all" />
<link rel="stylesheet" href="css/header.css" media="all" />
<link href="https://fonts.googleapis.com/css?family=Noto+Sans+KR:300,400,500,700,900&amp;subset=korean" rel="stylesheet">
<script src="js/jquery-3.3.1.js"></script>

	<div class="header">
		<div class="topHeader">
			<ul>
				<li class="menu m1" onclick="location.href='index.jsp'">　</li>
				<li class="menu"><a href="movieList.mv">This Week</a></li>
				<li class="menu"><a href="cList.bo">Community</a></li>
				<c:if test="${sessionId==null }">
					<li class="menu"><a href="movieCartListS.mv">My Movies</a></li>
				</c:if>
				<c:if test="${sessionId!=null }">				
					<li class="menu"><a href="movieCartListT.mv?username=${sessionId }">My Movies</a></li>
				</c:if>
				<li class="menu"><a href="about.jsp">About</a></li>
				<li>
					<c:if test="${sessionId==null }">
						<button class="user v2"></button>
					</c:if>
					<c:if test="${sessionId!=null }">				
						<button class="user"></button>
					</c:if>
					<div class="userMenu">
						<c:if test="${sessionId==null }">
							<a href="signUp.jsp">Sign Up</a>					
							<a href="signInForm.mo">Sign In</a>
							<a href="about.jsp">About Developer</a>
						</c:if>
						<c:if test="${sessionId!=null }">
							<span>Signed in as <b>${sessionId }</b></span>
							<a href="memberView.mo?username=${sessionId }">My Profile</a>
							<c:if test="${sessionId=='admin' }">
								<a href="memberManage.mo">Manage Members</a>
							</c:if>
							<a href="about.jsp">About Developer</a>
							<a href="signOut.jsp">Sign Out</a>
						</c:if>
					</div>
				</li>
			</ul>
		</div>
	
	<script>
		$('button.user').click(function() {
			$('.userMenu').toggleClass('open');
		});
		
	</script>
</div>