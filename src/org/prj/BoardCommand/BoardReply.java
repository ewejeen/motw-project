package org.prj.BoardCommand;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.prj.BoardDAO.BoardDAO;

public class BoardReply implements BoardCommand {
	@Override
	public void executeQueryCommand(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int cGroup = Integer.parseInt(request.getParameter("cGroup"));
		int indent = Integer.parseInt(request.getParameter("indent"));
		int step = Integer.parseInt(request.getParameter("step"));
		String username = request.getParameter("username");
		String content = request.getParameter("content");
		
		BoardDAO dao = BoardDAO.getInstance();
		int result = dao.reply(cGroup, indent, step, content, username);
		
		PrintWriter out = response.getWriter();
		out.write(result+"");
		out.flush();
	}
}
