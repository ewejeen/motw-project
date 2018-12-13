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
		String autoIn = request.getParameter("autoIn"); // 자동 로그인이 체크되어 있으면 on, 아니면 null

		MemberDAO dao = MemberDAO.getInstance();
		int result = dao.signIn(username, userPw);
		String url = "";

		HttpSession session = request.getSession();
		Cookie cookieId = null;
		Cookie cookiePw = null;

		PrintWriter out = response.getWriter();

		if (result == 1) {
			// 세션 생성
			session.setMaxInactiveInterval(60 * 10); // 10분 간 로그인 세션 유지
			session.setAttribute("sessionId", username);

			// 쿠키 생성 - 자동 로그인이 체크되어 있으면
			if (autoIn != null && autoIn.equals("on")) {
				cookieId = new Cookie("cookieId", username);
				cookiePw = new Cookie("cookiePw", userPw);
				cookieId.setMaxAge(60 * 60 * 24 * 3); // 쿠키Id 유효시간 3일
				cookiePw.setMaxAge(60 * 60 * 24 * 3); // 쿠키Pw 유효시간 3일
				response.addCookie(cookieId);
				response.addCookie(cookiePw);
			} else {
				cookieId = new Cookie("cookieId", null);
				cookiePw = new Cookie("cookiePw", null);
				cookieId.setMaxAge(0);
				cookiePw.setMaxAge(0);
				response.addCookie(cookieId);
				response.addCookie(cookiePw);
			}

		}
		out.write(result + "");
		out.close();
	}
}
