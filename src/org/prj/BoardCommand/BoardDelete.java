package org.prj.BoardCommand;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.prj.BoardDAO.BoardDAO;

public class BoardDelete implements BoardCommand {

	@Override
	public void executeQueryCommand(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int no = Integer.parseInt(request.getParameter("no"));
		
		BoardDAO dao = BoardDAO.getInstance();
		int result = dao.delete(no);
		
		System.out.println(result);
		
		PrintWriter out = response.getWriter();
		out.write(result+"");
		out.flush();
	}

}
