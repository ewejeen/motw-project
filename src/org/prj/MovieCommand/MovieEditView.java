package org.prj.MovieCommand;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.prj.BoardDAO.BoardDAO;
import org.prj.BoardDTO.BoardDTO;
import org.prj.MovieDAO.MovieDAO;
import org.prj.MovieDTO.MovieDTO;

public class MovieEditView implements MovieCommand {
	@Override
	public void executeQueryCommand(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String title = request.getParameter("title");
		
		MovieDAO dao = MovieDAO.getInstance();
		MovieDTO dto = dao.view(title);
		
		request.setAttribute("dto", dto);
		request.setAttribute("url", "/twEdit.jsp");		
	}
}
