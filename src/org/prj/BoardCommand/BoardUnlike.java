package org.prj.BoardCommand;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.prj.BoardDAO.BoardDAO;
import org.prj.BoardDTO.BoardDTO;
import org.prj.BoardDTO.PagingClass;

public class BoardUnlike implements BoardCommand {
	@Override
	public void executeQueryCommand(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("username");
		int boardno = Integer.parseInt(request.getParameter("boardno"));

		BoardDAO dao = BoardDAO.getInstance();
		int result = dao.unlike(username, boardno);

		PrintWriter out = response.getWriter();
		out.write(result + "");
		out.close();

	}
}
