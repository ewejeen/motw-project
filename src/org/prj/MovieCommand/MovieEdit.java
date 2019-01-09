package org.prj.MovieCommand;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.prj.MovieDAO.MovieDAO;

public class MovieEdit implements MovieCommand {
	@Override
	public void executeQueryCommand(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String catchph = request.getParameter("catchph");
		String director = request.getParameter("director");
		String stars = request.getParameter("stars");
		String rlsDate = request.getParameter("rlsDate");
		String rotten = request.getParameter("rotten");
		String imdb = request.getParameter("imdb");
		String wiki = request.getParameter("wiki");
		String youtube = request.getParameter("youtube");
		int no = Integer.parseInt(request.getParameter("no"));
		
		MovieDAO dao = MovieDAO.getInstance();
		int result = dao.edit(title, content, catchph, director, stars, rlsDate, rotten, imdb, wiki, youtube, no);
		
		PrintWriter out = response.getWriter();
		out.write(result+"");
		out.flush();
	}
}
