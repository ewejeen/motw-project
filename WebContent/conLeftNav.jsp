<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="css/conLeftNav.css" media="all" />
<div class="leftNav">
	<img src="img/logo_v4.png" alt="logo">
	<ul>
		<li>
			<span>Welcome, <b>${sessionId}</b></span>
		</li>
		<li><a href="memberView.mo?username=${sessionId}">Profile</a></li>
		<li><a href="memberModifyView.mo?username=${sessionId}">Edit Profile</a></li>
		<li><a href="memberDeleteView.mo?username=${sessionId}">Delete Account</a></li>
		<c:if test="${sessionId=='admin' }">		
			<li><a href="memberManage.mo">Manage Members</a></li>
		</c:if>
	</ul>
</div>