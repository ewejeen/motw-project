package org.prj.MovieCommand;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.prj.MovieDTO.Cart;

public class MovieCartAddS implements MovieCommand {
	@Override
	public void executeQueryCommand(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int no = Integer.parseInt(request.getParameter("no"));

		HttpSession session = request.getSession();
		Cart cartId = (Cart) session.getAttribute("cartId");

		if (cartId == null) {
			cartId = new Cart();
		}

		// 카트 중복 확인: 값이 1이면 중복, 0이면 중복 아님
		if (cartId.dupItem(no) != 1) {
			cartId.addItem(no);
			session.setAttribute("cartId", cartId);
			session.setMaxInactiveInterval(60 * 60 * 3); // 비회원 장바구니 세션 3시간 동안 유지
			request.setAttribute("url", "addCart.jsp?addNum=" + 1);
		} else if (cartId.dupItem(no) == 1) {
			request.setAttribute("url", "addCart.jsp?addNum=" + 0);
		}
	}
}
