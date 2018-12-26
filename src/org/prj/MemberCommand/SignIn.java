package org.prj.MemberCommand;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.prj.MemberDAO.MemberDAO;

public class SignIn implements MemberCommand {
	@Override
	public void executeQueryCommand(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("username");
		String userPw = request.getParameter("userPw");

		MemberDAO dao = MemberDAO.getInstance();
		int result = dao.signIn(username, userPw);
		String url = "";

		HttpSession session = request.getSession();

		PrintWriter out = response.getWriter();

		if (result == 1) {
			// 세션 생성
			session.setMaxInactiveInterval(60 * 10); // 10분 간 로그인 세션 유지
			session.setAttribute("sessionId", username);
			}
		}
		out.write(result + "");
		out.close();
	}
}
