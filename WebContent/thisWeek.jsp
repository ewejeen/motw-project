<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>#MOTW :: This Week</title>
<link rel="stylesheet" href="css/thisWeek.css" media="all" />
</head>
<body>
	<div id="wrap">
		<jsp:include page="header.jsp" />
		
		<div class="thisWeek">
			<div class="container">
				<jsp:include page="twTop.jsp" />
				
				<div class="con">
					
					<c:forEach var="list" items="${requestScope.list }">
						<ul>
							<li>
								<img src="<%=request.getContextPath() %>/upload/${list.image }" alt="image" onclick="location.href='movieView.mv?title=${list.title}'"/>
								<input type="hidden" name="image" id="image" value="${list.image }" />
								<p class="catchph">${list.catchph }</p>
								<div class="sub">
									<input type="hidden" name="username" id="username" value="${list.username }" />
									
									<%-- 영화 등록 날짜가 해당 날짜(등록 날짜)와 같으면 금주의 영화라고 표시 --%>
									<fmt:parseDate value="20181206" pattern="yyyyMMdd" var="critDate" />
									<fmt:formatDate value="${critDate }" pattern="yyyyMMdd" var="critDate2" />
									<fmt:formatDate value="${list.regDate }" pattern="yyyyMMdd" var="regDate" />
									
									<div class="ttl">
										<c:choose>
											<c:when test="${regDate eq critDate2}">
												<img src="img/new.png" alt="motw" class="motwImg" />
											</c:when>
											<c:otherwise>
												<div class="empty"></div>
											</c:otherwise>
										</c:choose>
										
										<span class="title" onclick="location.href='movieView.mv?title=${list.title}'">${list.title }</span>
										<input type="hidden" name="title" id="title" value="${list.title }" />
										<span class="rlsDate">${list.rlsDate }</span>
										<input type="hidden" name="rlsDate" id="rlsDate" value="${list.rlsDate }" />
									</div>
									
									<div class="ssub">
										<span class="director">Director</span><p class="director">${list.director }</p>
										<input type="hidden" name="director" id="director" value="${list.director }" />
										<span class="stars">Starring</span><p class="stars"> ${list.stars }</p>
									</div>
									
									<div class="logos">
										<%-- <c:set var="ttl1" value="${list.image }" />
										<c:set var="ttllength" value="${fn:length(ttl1) }" />
										<c:set var="ttl2" value="${fn:substring(ttl1, 0, ttllength-4)}" /> --%>
										
										<c:if test="${sessionId==null }">
											<span class="heart" onclick="window.open('movieCartAddS.mv?no=${list.no }','cart_result','width=400, height=250, left=500, top=300').focus()">Add to My Movies</span>											
										</c:if>
										<c:if test="${sessionId!=null }">
											<span class="heart" onclick="window.open('movieCartAddT.mv?username=${sessionId }&title=${list.title }&image=${list.image }&director=${list.director }&rlsDate=${list.rlsDate }','cart_result','width=400, height=250, left=500, top=300').focus()">Add to My Movies</span>																					
										</c:if>
										
									</div>
								</div>
							</li>
						</ul>
					</c:forEach>
				</div>
				
				<div class="paging">
					<c:if test="${pagingList.total==0 }">
						<ul>
							<li class="nopost one">No movies registered yet.</li>
							<c:if test="${sessionId eq 'admin' }">
								<li class="nopost two"><a href="twWrite.jsp">Click here to register.</a></li>
							</c:if>
						</ul>
					</c:if>
					
					<c:if test="${pagingList.pNum>pagingList.block }">
						<a href="movieList.mv?pNum=1">◀◀　</a>
						<a href="movieList.mv?pNum=${pagingList.startPage-1}">◀</a>								
					</c:if>
					
					<c:forEach var="i" begin="${pagingList.startPage }" end="${pagingList.endPage }">
						<c:if test="${i==pagingList.pNum }">
							<b><a href="movieList.mv?pNum=${i }">${i }</a></b>									
						</c:if>
						<c:if test="${i!=pagingList.pNum }">
							<a href="movieList.mv?pNum=${i }">${i }</a>																			
						</c:if>
					</c:forEach>
					
					<c:if test="${pagingList.endPage < pagingList.totalPage }">
						<a href="movieList.mv?pNum=${pagingList.endPage+1}">▶　</a>
						<a href="movieList.mv?pNum=${pagingList.totalPage}">▶▶</a>								
					</c:if>
				</div>
			</div>
		</div>
		
		<jsp:include page="footer.jsp" />
		
	</div>
	<script>
		/* for (var i = 0; i < 4; i++){
		    (function (i) {
		        var btn_la = document.getElementById('la_la_landBtn' + i);

		        btn_la.onclick = function () {
		           	switch(i){
		           	case 0:
		           		window.open('https://www.rottentomatoes.com/m/la_la_land');
			        	break;
		           	case 1:
		           		window.open('https://www.imdb.com/title/tt3783958/?ref_=nv_sr_1');
			        	break;
		           	case 2:
		           		window.open('https://en.wikipedia.org/wiki/La_La_Land_(film)');
			        	break;
		           	case 3:
		           		window.open('https://www.youtube.com/watch?v=0pdqf4P9MB8');
			        	break;
		           	}
	      		}
		        
	  		})(i);
		} */
		
	</script>

	<script>
		$('.header li.menu:nth-child(2)').css({
		    'border-bottom':'3px solid #d10000'});	
	</script>
</body>
</html>