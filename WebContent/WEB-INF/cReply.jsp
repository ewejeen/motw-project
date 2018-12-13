<%@page import="java.util.ArrayList"%>
<%@page import="org.prj.BoardDTO.PagingClass"%>
<%@page import="org.prj.BoardDTO.BoardDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	PagingClass pagingList = (PagingClass) request.getAttribute("pagingList");
	ArrayList<BoardDTO> reply = (ArrayList<BoardDTO>) request.getAttribute("reply");
%>
<div class="cReply">
	<div class="replyList">
		<table>
			<tbody id="tb">
				<%
				for(BoardDTO dto:reply){
				%>
					<tr>
						<td><%=dto.getUsername() %></td>
						<td><%=dto.getContent() %></td>
						<td><%=dto.getRegDate() %></td>
					</tr>
				<%							
				}
				%>
				
			
			</tbody>
		</table>
	</div>
	<div class="replyWrite">
		<form action="cReply.bo" method="post" name="replyForm" id="replyForm">
			<input type="hidden" name="cGroup2" id="cGroup2" value="${reply.cGroup }" />
			<input type="hidden" name="step2" id="step2" value="${reply.step }" />
			<input type="hidden" name="indent2" id="indent2" value="${reply.indent }" />
			<input type="hidden" name="title2" id="title2" value="${dto.title }" />
			<ul>
				<li>
					<input type="hidden" name="username2" id="username2" value="${sessionScope.sessionId }" />
					<input type="text" name="content2" id="content2" placeholder="Leave a comment" />
					<input type="button" value="답글 달기" onclick="replyFn()"/>
				</li>
			</ul>
		</form>
	</div>
</div>