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
<link rel="stylesheet" href="css/mManage.css" media="all" />
<script>
	if(${sessionId != 'admin' }){
		alert('Access denied.');
		history.go(-1);		
	}
</script>
<script src="js/jquery-3.3.1.js"></script>
<script src="js/mManageDelete.js"></script>
</head>
<body>
	<div id="wrap">
		<jsp:include page="header.jsp" />
		
		<div class="mManage">
			<div class="container">
				<jsp:include page="conLeftNav.jsp" />
				<div class="rightCon">
					<div class="top">
						<h1>Manage Members</h1>
						<span>This page can only be accessed by admin.</span>
					</div>
					<div class="con">
						<c:if test="${fn:length(list) ==1 }">
							<h4>Total: ${fn:length(list) } member</h4>							
						</c:if>
						<c:if test="${fn:length(list)>1 }">
							<h4>Total: ${fn:length(list) } members</h4>							
						</c:if>
						<table>
							<thead>
								<tr>
									<th class="username">Username</th>
									<th class="password">Password</th>
									<th class="email">Email</th>
									<th class="delete">Delete</th>
								</tr>
							</thead>
							<tbody id="tb">
								<c:forEach var="list" items="${requestScope.list }">
									<tr>
										<td class="username">${list.username }
											<input type="hidden" name="username" id="username" value="${list.username }" />
										</td>
										<td class="password">${list.userPw }
											<input type="hidden" name="userPw" id="userPw" value="${list.userPw }" />
										</td>
										<td class="email">${list.userEmail }</td>
										<td class="delete"><input type="button" value="Delete" onclick="mManageDelete('${list.username}', '${list.userPw}')" /></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
		<jsp:include page="footer.jsp" />
	</div>
	<script>
		$('.leftNav li:nth-child(5) a').css({
		    'font-size':'18px',
		    'font-weight':'bold'});	
	</script>
	
</body>
</html>