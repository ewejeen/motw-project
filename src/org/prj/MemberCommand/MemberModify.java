package org.prj.MemberCommand;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.prj.MemberDAO.MemberDAO;
import org.prj.MemberDTO.MemberDTO;

public class MemberModify implements MemberCommand {
	@Override
	public void executeQueryCommand(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("username");
		String userPw = request.getParameter("userPw");
		String userEmail = request.getParameter("userEmail");

		MemberDAO dao = MemberDAO.getInstance();
		int result = dao.modify(new MemberDTO(username, userPw, userEmail));

		PrintWriter out = response.getWriter();
		out.write(result+"");
		out.flush();
	}
}
