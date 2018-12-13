package org.prj.BoardCommand;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.prj.BoardDAO.BoardDAO;

public class BoardLike implements BoardCommand {
	@Override
	public void executeQueryCommand(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String username = request.getParameter("username");
		int boardno = Integer.parseInt(request.getParameter("boardno"));
		
		BoardDAO dao = BoardDAO.getInstance();
		int result = dao.like(username, boardno);
		
		PrintWriter out = response.getWriter();
		out.write(result+"");
		out.close();
	}
}
