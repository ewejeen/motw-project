package org.prj.MovieCommand;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.prj.MovieDTO.Cart;

public class MovieCartDeleteS implements MovieCommand {
	@Override
	public void executeQueryCommand(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int no = Integer.parseInt(request.getParameter("no"));

		HttpSession session = request.getSession();
		Cart cartId = (Cart) session.getAttribute("cartId");

		boolean result = cartId.deleteItem(no);
		int res;
		
		PrintWriter out = response.getWriter();
		
		if(result==true) {
			res = 1;
		} else {
			res = 0;
		}
		out.write(res+"");
		out.close();
		
		//request.setAttribute("url", "/movieCartListS.mv");
	}
}
