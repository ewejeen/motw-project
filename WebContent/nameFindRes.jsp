<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>#MOTW :: Find Username</title>
<link rel="stylesheet" href="css/nameFindRes.css" media="all" />
</head>
<body>
	<div id="wrap">
		<jsp:include page="header.jsp" />
		<div class="nameFindRes" id="nameFindRes">
			<ul>
			    <li class="top">
                       <img src="img/logo_v3.png" alt="logo">
			        <h1>Find Username</h1>    
			    </li>
				
				<c:choose>
					<c:when test="${result==null || result=='' }">
						<script>
								//버튼 개수에 따라 #nameFindRes 사이즈 동적으로 변경
								var nameFindRes = document.getElementById('nameFindRes');
								nameFindRes.style.minHeight='320px';
						</script>
						<li>
							<span>Can't find your username. Please check your email again.</span>
						</li>
						<li>
		                    <input type="button" value="Go back to Find Username" onclick="location.href='nameFind.jsp'" />							
						</li>
					</c:when>
					
					<c:otherwise>
						<li>
		                	<span>Your username is</span>
		                    <span class="result"><b>${result }</b></span>
						</li>
	                    <li>
	                        <input type="button" value="Sign In" onclick="location.href='signInForm.mo'" />
	                        <input type="button" value="Find Password" onclick="location.href='pwFind.jsp'" />
	                    </li>
					
					</c:otherwise>
				</c:choose>
				
			</ul>
		</div>
	</div>
</body>
</html>	