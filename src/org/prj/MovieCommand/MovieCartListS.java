package org.prj.MovieCommand;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.prj.MovieDAO.MovieDAO;
import org.prj.MovieDTO.Cart;
import org.prj.MovieDTO.SessionCartList;

public class MovieCartListS implements MovieCommand {
	@Override
	public void executeQueryCommand(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		MovieDAO dao = MovieDAO.getInstance();
		
		HttpSession session = request.getSession();
		Cart cartId = (Cart) session.getAttribute("cartId");
		
		if(cartId!=null) {
			SessionCartList cartList = dao.cartListS(cartId);
			request.setAttribute("cartList", cartList);
		} else {
			request.setAttribute("cartList", null);
		}
		
		request.setAttribute("url", "/myMovies.jsp");
	}
}
