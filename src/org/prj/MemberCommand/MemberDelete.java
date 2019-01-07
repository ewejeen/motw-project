package org.prj.MemberCommand;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.prj.MemberDAO.MemberDAO;

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

		// 탈퇴 성공하면 세션 삭제
		if (result == 1) {
			session.invalidate();
			url = "/mDeleteOk.jsp";
		} else {
			url = "/memberDeleteView.mo?username=" + username;
		}

		request.setAttribute("url", url);
	}
}
