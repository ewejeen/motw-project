<%@page import="org.prj.MemberDTO.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>#MOTW :: Delete Account</title>
<link rel="stylesheet" href="css/mDeleteOk.css" media="all" />
</head>
<body>
	<div id="wrap">
		<jsp:include page="header.jsp" />
		<div class="mypage">
			<div class="container">
				<jsp:include page="conLeftNav.jsp" />
				<div class="rightCon">
					<div class="mDeleteOk">
						<ul>
						    <li class="top">
			                       <img src="img/logo_v3.png" alt="logo">
						        <h1>Delete Account</h1>    
						    </li>
							<li>
			                       <span>Your account was successfully deleted.</span>
							</li>
							<li>
								<input type="button" value="Go to Main Page" onclick="location.href='index.jsp'"/>
							</li>
						</ul>
					</div>
				</div>
			</div>
		</div>
		<jsp:include page="footer.jsp" />
	</div>
	<script>
		$('.leftNav li:nth-child(4) a').css({
		    'font-size':'18px',
		    'font-weight':'bold'});	
	</script>
</body>
</html>