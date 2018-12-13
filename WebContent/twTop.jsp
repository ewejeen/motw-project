<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="css/twTop.css" media="all" />
<script src="js/searchFn.js"></script>
<div class="top">
	<c:if test="${sessionId=='admin' }">
		<div class="l1">
			<input type="button" value="Register a movie" onclick="location.href='twWrite.jsp'"/>
		</div>
	</c:if>
	<div class="l2">
		<h1>This Week</h1>
		<span>Dec 3rd's #MOTW: <b>Academy Award for Best Picture</b></span>
		<!-- <span>Nov 26th's #MOTW: <b>Based on Musicals</b></span> -->
		<!-- <span>Nov 19th's #MOTW: <b>Music + Movie</b></span> -->
		<form action="movieSearch.mv" id="searchForm">
			<select name="crit" id="crit">
				<option value="title">Title</option>
				<option value="rlsDate">Year</option>
				<option value="director">Director</option>
				<option value="stars">Starring</option>
			</select>
			<input type="text" name="search" id="search" placeholder="Search #motw...">
			<img src="img/search.png" alt="search" size="20px" id="searchBtn" onclick="searchFn()"/>
		</form>
	</div>
</div>