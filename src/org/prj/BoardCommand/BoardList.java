package org.prj.BoardCommand;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.prj.BoardDAO.BoardDAO;
import org.prj.BoardDTO.BoardDTO;
import org.prj.BoardDTO.PagingClass;

public class BoardList implements BoardCommand {
	@Override
	public void executeQueryCommand(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int pNum;
		if(request.getParameter("pNum")==null) {
			pNum=1;
		} else {
			pNum = Integer.parseInt(request.getParameter("pNum"));
		}
		
		BoardDAO dao = BoardDAO.getInstance();
		
		PagingClass pagingList = dao.paging(pNum);
		ArrayList<BoardDTO> list = dao.list(pagingList.getStartNum(), pagingList.getEndNum());
			
		request.setAttribute("pagingList", pagingList);
		request.setAttribute("list", list);
		request.setAttribute("url", "/community.jsp");
	}
}
