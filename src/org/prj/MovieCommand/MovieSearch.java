package org.prj.MovieCommand;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.prj.BoardDTO.PagingClass;
import org.prj.MovieDAO.MovieDAO;
import org.prj.MovieDTO.MovieDTO;

public class MovieSearch implements MovieCommand {
	@Override
	public void executeQueryCommand(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int pNum;
		if (request.getParameter("pNum") == null) {
			pNum = 1;
		} else {
			pNum = Integer.parseInt(request.getParameter("pNum"));
		}

		String crit = request.getParameter("crit");
		String search = request.getParameter("search");

		MovieDAO dao = MovieDAO.getInstance();

		PagingClass pagingList = dao.paging(pNum, crit, search);
		ArrayList<MovieDTO> list = dao.search(crit, search, pagingList.getStartNum(), pagingList.getEndNum());

		request.setAttribute("crit", crit);
		request.setAttribute("search", search);
		request.setAttribute("pagingList", pagingList);
		request.setAttribute("list", list);
		request.setAttribute("url", "/thisWeekSearch.jsp");

	}
}
