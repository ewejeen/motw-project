package org.prj.BoardCommand;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.prj.BoardDAO.BoardDAO;
import org.prj.BoardDTO.BoardDTO;
import org.prj.BoardDTO.LikeDTO;

public class BoardView implements BoardCommand {
	@Override
	public void executeQueryCommand(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int no = Integer.parseInt(request.getParameter("no"));
		String username = request.getParameter("username");
		
		BoardDAO dao = BoardDAO.getInstance();
		BoardDTO dto = dao.view(no);
		int likeCheck = dao.getLikeCheck(username, no);
		
		request.setAttribute("likeCheck", likeCheck);
		request.setAttribute("dto", dto);
		request.setAttribute("url", "/cView.jsp");		
	}
}
