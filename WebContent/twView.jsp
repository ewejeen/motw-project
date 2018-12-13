<%@page import="org.prj.BoardDTO.PagingClass"%>
<%@page import="java.util.ArrayList"%>
<%@page import="org.prj.BoardDTO.BoardDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/twView.css" media="all" />
<title>#MOTW :: ${dto.title }</title>
<script src="js/jquery-3.3.1.js"></script>
<script src="js/twDeleteFn.js"></script>
</head>
<body>
	<div id="wrap">
		<jsp:include page="header.jsp" />
		
		<div class="twView">
			<div class="container">
				<jsp:include page="twTop.jsp" />
				<div class="con">
					<ul>
						<li>
	                        <img src="<%=request.getContextPath() %>/upload/${dto.image }" alt="image" />
	                        <c:if test="${sessionId==null }">
								<span class="heart" onclick="window.open('movieCartAddS.mv?no=${dto.no }','cart_result','width=400, height=250, left=200, top=200').focus()">Add to My Movies</span>											
							</c:if>
							<c:if test="${sessionId!=null }">
								<span class="heart" onclick="window.open('movieCartAddT.mv?username=${dto.username }&title=${dto.title }&image=${dto.image }&director=${dto.director }&rlsDate=${dto.rlsDate }','cart_result','width=400, height=250, left=200, top=200').focus()">Add to My Movies</span>																					
							</c:if>
						</li>
						<li>
							<input type="hidden" name="no" id="no" value="${dto.no }" />
	                        <span class="label">Title</span> 
	                        <span class="content">${dto.title } (${dto.rlsDate })</span>
						</li>
						<li>
	                        <span class="label">Director</span>
					        <span class="content">${dto.director }</span>
						</li>
						<li>
	                        <span class="label">Stars</span>
					        <span class="content">${dto.stars }</span>
						</li>
						<li>
	                        <p class="content">${dto.content }</p>
						</li>
					</ul>
					<div class="btn">
						<c:if test="${sessionId eq 'admin' }">
								<input type="button" value="Edit" onclick="location.href='movieEditView.mv?title=${dto.title}'">
		                   		<input type="button" value="Delete" onclick="twDeleteFn()"/>
						</c:if>
                 	</div>
					<div class="btn b2">
						<input type="button" value="Go back to list" onclick="location.href='movieList.mv'">
					</div>
				</div>
				<div class="menu">
					<h3>Need more info on " <em>${dto.title }</em> "?</h3>
					
					<div class="logo">
						<input type="button" class="youtube" onclick="window.open('${dto.youtube}')"/>
						<input type="button" class="wiki" onclick="window.open('${dto.wiki}')"/>
						<input type="button" class="imdb" onclick="window.open('${dto.imdb}')"/>
						<input type="button" class="rotten" onclick="window.open('${dto.rotten}')"/>
					</div>
				</div>
				
			</div>
		</div>
		<jsp:include page="footer.jsp" />
	</div>
</body>
</html>