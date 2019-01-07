package org.prj.MemberCommand;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.prj.MemberDAO.MemberDAO;

public class ManageDelete implements MemberCommand {
	@Override
	public void executeQueryCommand(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("username");
		String userPw = request.getParameter("userPw");

		MemberDAO dao = MemberDAO.getInstance();
		int result = dao.delete(username, userPw);
		
		PrintWriter out = response.getWriter();
		out.write(result+"");
		out.close();
	}
}
