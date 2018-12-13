package org.prj.MovieCommand;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.prj.MovieDAO.MovieDAO;
import org.prj.MovieDTO.CartList;

public class MovieCartListT implements MovieCommand {
	@Override
	public void executeQueryCommand(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String username = request.getParameter("username");
		
		MovieDAO dao = MovieDAO.getInstance();
		ArrayList<CartList> list = dao.cartListT(username);

		request.setAttribute("list", list);
		request.setAttribute("url", "/myMovies.jsp");
	}
}
