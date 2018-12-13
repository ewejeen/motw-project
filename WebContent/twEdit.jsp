<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>#MOTW :: Edit ${dto.title }</title>
<script>
	if(${sessionId eq null }){
		alert('Access denied.');
		history.go(-1);	
	} else if(${sessionId != 'admin'}){
		alert('Only admin can edit movies.');
		history.go(-1);
	}
</script>
<script src="js/jquery-3.3.1.js"></script>
<script src="js/searchFn.js"></script>
<script src="js/twEdit.js"></script>
<link rel="stylesheet" href="css/twEdit.css" media="all" />
</head>
<body>
	<div id="wrap">
		<jsp:include page="header.jsp" />
		
		<div class="twEdit">
			<div class="container">
				<jsp:include page="twTop.jsp" />
				
				<div class="con">
					<div class="editForm">
						<div class="ttl"><h1>Edit</h1></div>    
						<ul>
							<li>
		                        <span>Title</span>
		                        <input type="hidden" name="no" id="no" value="${dto.no }" />
		                        <input type="hidden" name="username" id="username" value="${sessionId }" />
						        <input type="text" name="title" id="title" value="${dto.title }" >
							</li>
							<li>
		                        <span>Release Date</span> 
		                        <input type="text" name="rlsDate" id="rlsDate" value="${dto.rlsDate}">
							</li>
							<li>
		                        <span>Director</span>
						        <input type="text" name="director" id="director" value="${dto.director }" >
							</li>
							<li>
		                        <span>Stars</span> 
		                        <input type="text" name="stars" id="stars" value="${dto.stars }">
							</li>
							<li>
		                        <span>Catchphrase</span> 
		                        <input type="text" name="catchph" id="catchph" value='${dto.catchph }' >
							</li>
							<li>
		                        <span>Content</span>
		                        <textarea name="content" id="content" cols="30" rows="10">${dto.content }</textarea>
							</li>
							<li>
								<span>YouTube</span>
								<input type="text" name="youtube" id="youtube" value="${dto.youtube }"/>
							</li>
							<li>
								<span>Wikipedia</span>
								<input type="text" name="wiki" id="wiki" value="${dto.wiki }"/>
							</li>
							<li>
								<span>IMDB</span>
								<input type="text" name="imdb" id="imdb" value="${dto.imdb }"/>
							</li>
							<li>
								<span>Rotten Tomatoes</span>
								<input type="text" name="rotten" id="rotten" value="${dto.rotten }" />
							</li>
		                    <li>
		                        <input type="button" value="Edit" onclick="twEdit()"/>
		                    </li>
						</ul>
					</div>
				</div>
			</div>
		</div>
		
		<jsp:include page="footer.jsp" />
	</div>
</body>
</html>