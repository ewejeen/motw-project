package org.prj.MemberCommand;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.prj.MemberDAO.MemberDAO;
import org.prj.MemberDTO.MemberDTO;
import org.prj.MovieDAO.MovieDAO;
import org.prj.MovieDTO.CartList;

public class MemberView implements MemberCommand {
	@Override
	public void executeQueryCommand(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String username = request.getParameter("username");
		
		MemberDAO dao = MemberDAO.getInstance();
		MemberDTO dto = dao.view(username);
		
		MovieDAO dao2 = MovieDAO.getInstance();
		ArrayList<CartList> list = dao2.cartListT(username);

		request.setAttribute("list", list);
		request.setAttribute("dto", dto);
		request.setAttribute("url", "/myPage.jsp");
	}
}
