<%@page import="org.prj.BoardDTO.PagingClass"%>
<%@page import="java.util.ArrayList"%>
<%@page import="org.prj.BoardDTO.BoardDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/cView.css" media="all" />
<title>#MOTW :: ${dto.title }</title>
<script src="js/jquery-3.3.1.js"></script>
<script src="js/searchFn.js"></script>
<script src="js/cDeleteFn.js"></script>
<script src="js/replyDeleteFn.js"></script>
<script src="js/replyFn.js"></script>
<script src="js/denied.js"></script>
<script>
	window.onload = function() {
		replyList();
	}
	
	function replyFocus(){
		$('#content').focus();
	}
	
	function enterkey() {
        if (window.event.keyCode == 13) {
        	replyFn();
        }
	}
</script>
</head>
<body>
	<div id="wrap">
		<jsp:include page="header.jsp" />
		<div class="viewReply">
			<div class="cView">
				<div class="container">
					<jsp:include page="commTop.jsp" />
					<div class="con">
						<div class="ttl">
							<h1>${dto.title }</h1>
							<span><fmt:formatDate value="${dto.regDate }" pattern="yyyy-MM-dd hh:mm" var="regDate" />${regDate }</span>
						</div>    
						<ul>
							<li>
		                        <span class="label">Username</span> 
		                        <input type="hidden" name="no" id="no" value="${dto.no }" />
		                        <input type="hidden" name="cGroup" id="cGroup" value="${dto.cGroup }" />
								<input type="hidden" name="username" id="username" value="${sessionId }" />
		                        <span class="content">${dto.username } </span>
							</li>
							<li>
		                        <span class="label">Title</span>
						        <span class="content">${dto.title }</span>
							</li>
							<li>
		                        <span class="label">Content</span>
		                        <div class="content">${dto.content }</div>
							</li>					
		                    <li>
		                    	<c:choose>
		                    		<c:when test="${sessionId eq dto.username }">
			                    		<input type="button" class="lBtn" value="Edit" onclick="location.href='cEditView.bo?no=${dto.no}'">
			                    		<input type="button" class="lBtn" value="Delete" onclick="cDeleteFn(${dto.no})"/>	                    		
		                    		</c:when>
		                    		<c:otherwise>
		                    			<c:choose>
		                    				<c:when test="${sessionId!=null }">
					                    		<input type="hidden" name="likeCheck" id="likeCheck" value="${likeCheck }" />
					                    		<c:if test="${likeCheck==0 }">
					                    			<img src="img/heart_red_un.png" class="reply" id="like1" alt="like" onclick="likeFn()"/>
					                    			<img src="img/heart_red.png" class="reply" id="like2" alt="like" onclick="unlikeFn()" style="display: none;"/>
				                    			</c:if>
					                    		<c:if test="${likeCheck==1 }">
					                    			<img src="img/heart_red_un.png" class="reply" id="like1" alt="like" onclick="likeFn()" style="display: none;"/>
					                    			<img src="img/heart_red.png" class="reply" id="like2" alt="like" onclick="unlikeFn()" />
				                    			</c:if>
					                    		<img src="img/comment_bubble.png" class="reply" alt="comment" onclick="replyFocus()"/>	                    				
		                    				</c:when>
		                    				<c:otherwise>
					                    		<img src="img/heart_red_un.png" class="reply" id="like1" alt="like" onclick="denied()"/>
					                    		<img src="img/heart_red.png" class="reply" id="like2" alt="like" onclick="denied()" style="display: none;"/>
					                    		<img src="img/comment_bubble.png" class="reply" alt="comment" onclick="denied()"/>
		                    				</c:otherwise>
		                    			</c:choose>
		                    		</c:otherwise>
		                    	</c:choose>
		                        <input type="button" value="Go back to list" onclick="location.href='cList.bo'"/>
		                    </li>
						</ul>
					</div>
				</div>
			</div>
			<div class="cReply">
				<h2 id="comments">Comments</h2>
				<table>
					<tbody id="tb">
					</tbody>
				</table>
				<form action="cReply.bo">
					<input type="hidden" name="cGroup" id="cGroup" value="${dto.cGroup }" />
					<input type="hidden" name="step" id="step" value="${dto.step }" />
					<input type="hidden" name="indent" id="indent" value="${dto.indent }" />
					<input type="hidden" name="title" id="title" value="${dto.title }" />
						
					<c:choose>
						<c:when test="${sessionId==null }">
							<input type="text" name="content" id="content" placeholder="Your comment..." onclick="denied()"/>
							<input type="button" value="Submit" id="btn" onclick="denied()"/>
						</c:when>
						<c:otherwise>
							<input type="text" name="content" id="content" placeholder="Your comment..." onkeyup="enterkey()"/>
							<input type="button" value="Submit" id="btn" onclick="replyFn()"/>
							<!-- input 하나라서 엔터키 submit이 자동으로 적용됨. 방지 위해 hidden input 추가 -->
				            <input style="visibility: hidden; width: 0px;" />
						</c:otherwise>
					</c:choose>
				</form>
			</div>
		</div>
		<jsp:include page="footer.jsp" />
	</div>

<!-- js파일 분리시키면 완전한 실행이 안 돼서 그냥 붙여 쓴다 -->
<script>
	var xhr = new XMLHttpRequest();
	function replyList() {
		var cGroup = document.getElementById('cGroup');
		var url = 'replyList.bo';
		var data = '?cGroup=' + cGroup.value;
		xhr.open('post', url + data, true);
		xhr.setRequestHeader('Content-Type',
				'application/x-www-urlencoded;charset=utf8');
		xhr.onreadystatechange = replyListOk;
		xhr.send(null);
	}
	
	function replyListOk() {
	
		var table = document.getElementById('tb');
		table.innerHTML = "";
	
		if (xhr.readyState == 4 && xhr.status == 200) {
			var object = eval('(' + xhr.responseText + ')');
	
			var result = object.result; // JSON
	
			// result값(댓글)이 없으면 문구 출력
			if (result == "" || result == null) {
				var tr = document.createElement('tr');
				table.appendChild(tr);
				var td = document.createElement('td');
	
				td.innerHTML = 'No comments written for this post.';
				td.style.textAlign = 'center';
				tr.appendChild(td);
			}
	
			for (var i = 0; i < result.length; i++) {
				var tr = document.createElement('tr');
				table.appendChild(tr);
	
				for (var j = 0; j <= result[i].length - 8; j++) {
					var td = document.createElement('td');
					td.innerHTML = result[i][j].value;
					tr.appendChild(td);
	
					// 댓글 작성자가 로그인한 경우 댓글을 지울 수 있음
					if (result[i][1].value == '${sessionId }') {
						// 마지막 td에 댓글 삭제 버튼 설정
						if (j == (result[i].length - 8)) {
							td = document.createElement('td');
							td.innerHTML = "<input type='button' id='reDelete' onclick='replyDeleteFn("
									+ result[i][7].value + ")' value='Delete' />";
							tr.appendChild(td);
							break;
						}
					}
				}
			}
		}
	}
	
</script>
<script src="js/likeUnlike.js"></script>
</body>
</html>