package org.prj.BoardCommand;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.prj.BoardDAO.BoardDAO;
import org.prj.BoardDTO.BoardDTO;
import org.prj.BoardDTO.PagingClass;

public class BoardWrite implements BoardCommand {
	@Override
	public void executeQueryCommand(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		BoardDAO dao = BoardDAO.getInstance();
		int result = dao.write(title, content, username);
		
		String url = "";
		if(result==1) {
			url = "/cList.bo";
		} else {
			url = "/cWrite.jsp";
		}
			
		request.setAttribute("url", url);
	}
}
