package org.prj.MovieController;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.prj.MovieCommand.MovieCartAddS;
import org.prj.MovieCommand.MovieCartAddT;
import org.prj.MovieCommand.MovieCartDeleteS;
import org.prj.MovieCommand.MovieCartDeleteT;
import org.prj.MovieCommand.MovieCartListS;
import org.prj.MovieCommand.MovieCartListT;
import org.prj.MovieCommand.MovieCommand;
import org.prj.MovieCommand.MovieDelete;
import org.prj.MovieCommand.MovieEdit;
import org.prj.MovieCommand.MovieEditView;
import org.prj.MovieCommand.MovieList;
import org.prj.MovieCommand.MovieRegister;
import org.prj.MovieCommand.MovieSearch;
import org.prj.MovieCommand.MovieView;

@WebServlet("*.mv")
public class MovieController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String path = request.getContextPath();
		String uri = request.getRequestURI();
		String basicURL = uri.substring(path.length());

		MovieCommand command = null;
		String url = "";
		
		switch(basicURL) {
		case "/movieList.mv":
			command = new MovieList();
			command.executeQueryCommand(request, response);
			url = (String) request.getAttribute("url");
			break;
		case "/movieSearch.mv":
			command = new MovieSearch();
			command.executeQueryCommand(request, response);
			url = (String) request.getAttribute("url");
			break;
		case "/movieRegister.mv":
			command = new MovieRegister();
			command.executeQueryCommand(request, response);
			url = (String) request.getAttribute("url");
			break;
		case "/movieCartAddS.mv":
			command = new MovieCartAddS();
			command.executeQueryCommand(request, response);
			url = (String) request.getAttribute("url");
			break;
		case "/movieCartAddT.mv":
			command = new MovieCartAddT();
			command.executeQueryCommand(request, response);
			url = (String) request.getAttribute("url");
			break;
		case "/movieCartListS.mv":
			command = new MovieCartListS();
			command.executeQueryCommand(request, response);
			url = (String) request.getAttribute("url");
			break;
		case "/movieCartListT.mv":
			command = new MovieCartListT();
			command.executeQueryCommand(request, response);
			url = (String) request.getAttribute("url");
			break;
		case "/movieCartDeleteS.mv":
			command = new MovieCartDeleteS();
			command.executeQueryCommand(request, response);
			return;
		case "/movieCartDeleteT.mv":
			command = new MovieCartDeleteT();
			command.executeQueryCommand(request, response);
			return;
		case "/movieView.mv":
			command = new MovieView();
			command.executeQueryCommand(request, response);
			url = (String) request.getAttribute("url");
			break;
		case "/movieEditView.mv":
			command = new MovieEditView();
			command.executeQueryCommand(request, response);
			url = (String) request.getAttribute("url");
			break;
		case "/movieEdit.mv":
			command = new MovieEdit();
			command.executeQueryCommand(request, response);
			return;
		case "/movieDelete.mv":
			command = new MovieDelete();
			command.executeQueryCommand(request, response);
			return;
		
		}
		

		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}
