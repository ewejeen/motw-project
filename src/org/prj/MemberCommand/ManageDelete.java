package org.prj.MemberCommand;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
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

		Cookie[] cookies = request.getCookies();
		
		PrintWriter out = response.getWriter();

		// admin이 회원 탈퇴시키면 쿠키 삭제
		if (result == 1) {
			for (int i = 0; i < cookies.length; i++) {
				if (cookies[i].getValue().equals(username) || cookies[i].getValue().equals(userPw)) {
					cookies[i].setMaxAge(0);
					response.addCookie(cookies[i]);
				}
			}
		}
		out.write(result+"");
		out.close();
	}
}
