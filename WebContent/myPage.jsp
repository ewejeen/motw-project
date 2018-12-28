<%@page import="org.prj.MovieDTO.MovieDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="org.prj.MemberDTO.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>#MOTW :: My Page</title>
<link rel="stylesheet" href="css/myPage.css" media="all" />
<c:if test="${sessionId==null }">
	<script>
		alert('Sign in is required.');
		location.href='signInForm.mo';
	</script>
</c:if>
</head>
<body>
	<div id="wrap">
		<jsp:include page="header.jsp" />
		<div class="mypage">
			<div class="container">
				<jsp:include page="conLeftNav.jsp" />
				<div class="rightCon">
					<div class="profile">
						<ul>
							<li class="top">
		                        <img src="img/logo_v3.png" alt="logo">
						        <h1>Profile</h1>    
						    </li>
							<li>
								<label for="username">Username</label>
								<span>${dto.username }</span>
							</li>
							<li>
								<label for="userEmail">Email</label>
								<span>${dto.userEmail }</span>
							</li>
							<li>
								<label for="myMovies">My Movies</label>
								<span>
									<c:forEach items="${requestScope.list}" var="item" varStatus="index">
										<c:if test="${!index.last }">
											<a href="movieView.mv?title=${item.title }">${item.title }, </a>
										</c:if>
										<c:if test="${index.last }">
											<a href="movieView.mv?title=${item.title }">${item.title }</a>
										</c:if>
									</c:forEach>
								</span>
							</li>
						</ul>
					</div>
				</div>
			</div>
		</div>
		<jsp:include page="footer.jsp" />
	</div>
	<script>
		$('.leftNav li:nth-child(2) a').css({
		    'font-size':'18px',
		    'font-weight':'bold'});	
	</script>
</body>
</html>