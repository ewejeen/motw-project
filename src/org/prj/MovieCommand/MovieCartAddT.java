package org.prj.MovieCommand;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.prj.MovieDAO.MovieDAO;
import org.prj.MovieDTO.CartList;

public class MovieCartAddT implements MovieCommand {
	@Override
	public void executeQueryCommand(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("username");
		String title = request.getParameter("title");
		String image = request.getParameter("image");
		String director = request.getParameter("director");
		String rlsDate = request.getParameter("rlsDate");

		MovieDAO dao = MovieDAO.getInstance();
		int dup = dao.tCartCheck(username, title);

		String url = "";

		// dup값이 1이어서 중복인 경우 cartAdd 실행 X, param값 0으로 넘겨 줌
		if (dup == 1) {
			url = "addCart.jsp?addNum=" + 0;
		} else if (dup == 0) {
			int result = dao.cartAdd(username, title, image, director, rlsDate);
			if (result == 1) {
				url = "addCart.jsp?addNum=" + 1;
			}
		}

		request.setAttribute("url", url);
	}
}
