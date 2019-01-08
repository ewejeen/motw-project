<%@page import="org.prj.BoardDTO.PagingClass"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="org.prj.BoardDTO.BoardDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>#MOTW :: Community</title>
<link rel="stylesheet" href="css/reset.css">
<link rel="stylesheet" href="css/community.css">
</head>
<body>
	<div id="wrap">
		<jsp:include page="header.jsp" />
		
		<div class="community">
			<div class="container">
				<jsp:include page="commTop.jsp" />
				<div class="table">
					<table>
						<thead>
							<tr>
								<th class="title">Title</th>
								<th class="user">User</th>
								<th class="date">Date</th>
								<th class="hit"><img alt="hit" src="img/eye.png"></th>
								<th class="like"><img alt="like" src="img/heart_red.png"></th>
							</tr>
						</thead>
						<tbody id="tb">
							<c:forEach var="list" items="${requestScope.list }">
								<tr>
									<td class="title">
										<c:forEach begin="1" end="${list.indent }">
											<img src="img/reply_arrow.png" width="10" alt="reply" />
										</c:forEach>
										
										<c:if test="${sessionId==null }">
											<a href="cView.bo?no=${list.no }">${list.title }</a>
										</c:if>
										<c:if test="${sessionId!=null }">
											<!-- likeCheck 받아와서 꽉 찬 하트 띄우기 위함 -->
											<a href="cView.bo?no=${list.no }&username=${sessionId}">${list.title }</a>										
										</c:if>
									</td>
									<td class="user">${list.username }</td>
									<td class="date"><fmt:formatDate value="${list.regDate }" pattern="yyyy-MM-dd" /></td>
									<td class="hit">${list.hit }</td>
									<td class="like">${list.likeCnt }</td>
								</tr>
							</c:forEach>
							
						</tbody>
						<tr class="paging">
							<td colspan="5" align="center">
								<c:if test="${pagingList.total==0 }">
									<tr>
										<td colspan="5" class="nopost one">No posts written yet.</td>
									</tr>
									<tr>
										<td colspan="5" class="nopost two"><a href="cWrite.jsp">Want to be the first to post?</a></td>
									</tr>
								</c:if>
								
								<c:if test="${pagingList.pNum>pagingList.block }">
									<a href="cList.bo?pNum=1">◀◀　</a>
									<a href="cList.bo?pNum=${pagingList.startPage-1}">◀</a>								
								</c:if>
								
								<c:forEach var="i" begin="${pagingList.startPage }" end="${pagingList.endPage }">
									<c:if test="${i==pagingList.pNum }">
										<b><a href="cList.bo?pNum=${i }">${i }</a></b>									
									</c:if>
									<c:if test="${i!=pagingList.pNum }">
										<a href="cList.bo?pNum=${i }">${i }</a>																			
									</c:if>
								</c:forEach>
								
								<c:if test="${pagingList.endPage < pagingList.totalPage }">
									<a href="cList.bo?pNum=${pagingList.endPage+1}">▶　</a>
									<a href="cList.bo?pNum=${pagingList.totalPage}">▶▶</a>								
								</c:if>
								
							</td>
						</tr>
					</table>
				</div>
			</div>
		</div>
		
		<jsp:include page="footer.jsp" />
		
	</div>
	
	<script>
	$('.header li.menu:nth-child(3)').css({
	    'border-bottom':'3px solid #d10000'});	
	</script>
</body>
</html>