package org.prj.MemberCommand;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.prj.MemberDAO.MemberDAO;
import org.prj.MemberDTO.MemberDTO;

public class MemberDelete implements MemberCommand {
	@Override
	public void executeQueryCommand(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("username");
		String userPw = request.getParameter("userPw");

		MemberDAO dao = MemberDAO.getInstance();
		int result = dao.delete(username, userPw);

		String url = "";

		HttpSession session = request.getSession();
		Cookie[] cookies = request.getCookies();

		// 탈퇴 성공하면 쿠키와 세션 삭제
		if (result == 1) {
			url = "/mDeleteOk.jsp";
			session.invalidate();

			for (int i = 0; i < cookies.length; i++) {
				if (cookies[i].getValue().equals(username) || cookies[i].getValue().equals(userPw)) {
					cookies[i].setMaxAge(0);
					response.addCookie(cookies[i]);
				}
			}

		} else {
			url = "/memberDeleteView.mo?username="+username;
		}

		request.setAttribute("url", url);
	}
}
