<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="css/commTop.css" media="all" />
<script src="js/searchFn.js"></script>
<div class="top">
	<c:if test="${sessionId!=null }">
		<div class="l1">
			<input type="button" value="Write a post" onclick="location.href='cWrite.jsp'"/>
		</div>
	</c:if>
	<div class="l2">
		<h1>Community</h1>
		<form action="cSearch.bo" id="searchForm">
			<select name="crit" id="crit">
				<option value="title">Title</option>
				<option value="username">Username</option>
			</select>
			<!--<select name="order" id=""></select>-->
			<input type="text" name="search" id="search" placeholder="Search community...">
			<img src="img/search.png" alt="search" size="20px" id="searchBtn" onclick="searchFn()"/>
		</form>
	</div>
</div>