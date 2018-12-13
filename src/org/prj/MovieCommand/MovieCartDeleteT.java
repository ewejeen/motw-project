package org.prj.MovieCommand;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.prj.MovieDAO.MovieDAO;

public class MovieCartDeleteT implements MovieCommand {
	@Override
	public void executeQueryCommand(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String title = request.getParameter("title");
		String username = request.getParameter("username");

		MovieDAO dao = MovieDAO.getInstance();
		int result = dao.cartDelete(title, username);

		PrintWriter out = response.getWriter();
		out.write(result + "");
		out.close();

	}
}
