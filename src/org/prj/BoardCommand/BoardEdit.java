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

public class BoardEdit implements BoardCommand {
	@Override
	public void executeQueryCommand(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int no = Integer.parseInt(request.getParameter("no"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");

		BoardDAO dao = BoardDAO.getInstance();
		int result = dao.edit(title, content, no);

		PrintWriter out = response.getWriter();
		out.write(result + "");
		out.flush();
	}
}
