package org.prj.MemberCommand;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.prj.MemberDAO.MemberDAO;

public class NameCheck implements MemberCommand {
	@Override
	public void executeQueryCommand(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String username = request.getParameter("username");
		
		MemberDAO dao = MemberDAO.getInstance();
		int result = dao.nameCheck(username);
		
		PrintWriter out = response.getWriter();
		out.println(result+"");
		out.close();
	}
}
