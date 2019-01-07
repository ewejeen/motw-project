<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>#MOTW :: Find Password</title>
<link rel="stylesheet" href="css/pwFindRes.css" media="all" />
</head>
<body>
	<div id="wrap">
		<jsp:include page="header.jsp" />
		<div class="pwFindRes">
			<ul>
			    <li class="top">
                       <img src="img/logo_v3.png" alt="logo">
			        <h1>Find Password</h1>    
			    </li>
				
				<c:choose>
					<c:when test="${result==null || result==''}">
						<li>
							<span>Can't find your password. Please check your username and email again.</span>
						</li>
						<li>
		                    <input type="button" value="Go back to Find Password" onclick="location.href='pwFind.jsp'" />							
						</li>
					</c:when>
					
					<c:otherwise>
						<li>
		                       <span>Your password is</span>
		                       <span class="result"><b>${result }</b></span>
						</li>
		                <li>
		                    <input type="button" value="Sign In" onclick="location.href='signInForm.mo'" />
		                </li>					
					</c:otherwise>
				</c:choose>	
			</ul>
		</div>
	</div>
</body>
</html>	