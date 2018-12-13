package org.prj.MemberCommand;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.prj.MemberDAO.MemberDAO;
import org.prj.MemberDTO.MemberDTO;

public class SignUp implements MemberCommand {
	@Override
	public void executeQueryCommand(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("username");
		String userPw = request.getParameter("userPw");
		String userEmail = request.getParameter("userEmail");
		
		MemberDAO dao = MemberDAO.getInstance();
		int result = dao.signUp(new MemberDTO(username, userPw, userEmail));
		
		String url = "";
		
		if(result==1) {
			url = "/signUpOk.jsp";
		} else {
			url = "/signUp.jsp";
		}
		
		request.setAttribute("url", url);
	}
}
