package org.prj.MovieCommand;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.prj.MovieDAO.MovieDAO;

public class MovieDelete implements MovieCommand {
	@Override
	public void executeQueryCommand(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int no = Integer.parseInt(request.getParameter("no"));
		
		MovieDAO dao = MovieDAO.getInstance();
		int result = dao.delete(no);
		
		PrintWriter out = response.getWriter();
		out.write(result+"");
		out.flush();
	}
}
