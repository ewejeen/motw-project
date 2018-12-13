package org.prj.MemberCommand;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.prj.MemberDAO.MemberDAO;
import org.prj.MemberDTO.MemberDTO;

public class MemberManage implements MemberCommand {
	@Override
	public void executeQueryCommand(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		MemberDAO dao = MemberDAO.getInstance();
		ArrayList<MemberDTO> list = dao.list();

		request.setAttribute("list", list);
		request.setAttribute("url", "/mManage.jsp");

	}
}
