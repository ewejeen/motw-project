package org.prj.MemberCommand;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.prj.MemberDAO.MemberDAO;
import org.prj.MemberDTO.MemberDTO;

public class MemberModifyView implements MemberCommand {
	@Override
	public void executeQueryCommand(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String username = request.getParameter("username");
		
		MemberDAO dao = MemberDAO.getInstance();
		MemberDTO dto = dao.view(username);
		
		request.setAttribute("dto", dto);
		request.setAttribute("url", "/mModify.jsp");
	}
}
