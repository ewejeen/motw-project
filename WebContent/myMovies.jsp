<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
<!doctype html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<title>#MOTW :: My Movies</title>
<link rel="stylesheet" href="css/myMovies.css" media="all" />
<script src="js/deleteFnT.js"></script>
<script src="js/deleteFnS.js"></script>
</head>
<body>
	<div id="wrap">
		<jsp:include page="header.jsp" />
		
		<div class="myMovies">
			<div class="container">
				<div class="top">
					<h1>My Movies</h1>
				</div>
				<div class="con">
					<!-- 비 로그인 시 -->
					<c:if test="${sessionId==null }">
						<c:if test="${cartList.size == 1 }">
							<h5 class="l1">You have added ${cartList.size } movie.</h5>							
							<h5>Your list lasts for <span style="text-decoration: underline;">3 hours</span> if you are not signed in.</h5>
						</c:if>
						<c:if test="${cartList.size > 1 }">
							<h5 class="l1">You have added ${cartList.size } movies.</h5>							
							<h5>Your list lasts for <span style="text-decoration: underline;">3 hours</span> if you are not signed in.</h5>
						</c:if>
						
						<c:choose>
							<c:when test="${cartList == null || cartList.size <= 0 }">
								<p class="empty">Your list is empty.</p>
								<a class="empty" href="movieList.mv">Want to browse #MOTW?</a>
							</c:when>
							<c:otherwise>
								<ul>
									<c:forEach var="i" begin="0" end="${cartList.size-1 }">
										<li>
											<img src="<%=request.getContextPath() %>/upload/${cartList.image[i] }" alt="${cartList.image[i] }" />
											<input type="hidden" name="no" id="no" value="${cartList.no[i] }" />
											<div class="sub">
												<span class="title" onclick="location.href='movieView.mv?title=${cartList.title[i]}&rlsDate=${cartList.rlsDate[i] }'">${cartList.title[i] }</span>
												<span class="rlsDate">${cartList.rlsDate[i] }</span>
												<p class="director">directed by <b>${cartList.director[i] }</b></p>
											</div>
											<div class="menu">
												<%-- <input type="button" value="Delete" onclick="location.href='movieCartDeleteS.mv?no=${cartList.no[i]}'" /> --%>
												<input type="button" value="Delete" onclick="deleteFnS(${cartList.no[i]})" />
											</div>
										</li>
									</c:forEach>
								</ul>
							</c:otherwise>
						</c:choose>
					</c:if>
					
					<!-- 로그인 시 -->
					<c:if test="${sessionId!=null }">
						<c:if test="${fn:length(list) ==1 }">
							<h5 class="l1 l2">You have added ${fn:length(list) } movie.</h5>							
						</c:if>
						<c:if test="${fn:length(list) > 1 }">
							<h5 class="l1 l2">You have added ${fn:length(list) } movies.</h5>							
						</c:if>
						
						<c:choose>
							<c:when test="${list == null || fn:length(list)  <= 0 }">
								<p class="empty">Your list is empty.</p>
								<a class="empty" href="movieList.mv">Want to browse #MOTW?</a>
							</c:when>
							<c:otherwise>
								<ul>
									<c:forEach var="list" items="${list }">
										<li>
											<img src="<%=request.getContextPath() %>/upload/${list.image }" alt="${list.image }" />
											<div class="sub">
												<span class="title" onclick="location.href='movieView.mv?title=${list.title}&rlsDate=${list.rlsDate }'">${list.title }</span>
												<span class="rlsDate">${list.rlsDate }</span>
												<p class="director">directed by <b>${list.director }</b></p>
												
												<input type="hidden" name="username" id="username" value="${sessionId }" />
												<input type="hidden" name="title" id="title" value="${list.title }" />												
												<input type="hidden" name="rlsDate" id="rlsDate" value="${list.rlsDate }" />												
											</div>
											<div class="menu">
												<input type="button" value="Delete" onclick="deleteFnT()"/>
											</div>
										</li>
									</c:forEach>
								</ul>
							</c:otherwise>
						</c:choose>
					</c:if>
					
				</div>
			</div>
		</div>
		
	</div>
	<jsp:include page="footer.jsp" />
	
	<script>
	$('.header li.menu:nth-child(4)').css({
	    'border-bottom':'3px solid #d10000'});	
	</script>
</body>
</html>