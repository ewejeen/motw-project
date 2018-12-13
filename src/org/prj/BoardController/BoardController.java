package org.prj.BoardController;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.prj.BoardCommand.BoardCommand;
import org.prj.BoardCommand.BoardDelete;
import org.prj.BoardCommand.BoardEdit;
import org.prj.BoardCommand.BoardEditView;
import org.prj.BoardCommand.BoardLike;
import org.prj.BoardCommand.BoardList;
import org.prj.BoardCommand.BoardReply;
import org.prj.BoardCommand.BoardSearch;
import org.prj.BoardCommand.BoardUnlike;
import org.prj.BoardCommand.BoardView;
import org.prj.BoardCommand.BoardWrite;
import org.prj.BoardCommand.ReplyList;

@WebServlet("*.bo")
public class BoardController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		String path = request.getContextPath();
		String uri = request.getRequestURI();
		String basicURL = uri.substring(path.length());

		BoardCommand command = null;
		String url = "";

		switch(basicURL) {
		case "/cList.bo":
			command = new BoardList();
			command.executeQueryCommand(request, response);
			url = (String) request.getAttribute("url");
			break;
		case "/cSearch.bo":
			command = new BoardSearch();
			command.executeQueryCommand(request, response);
			url = (String) request.getAttribute("url");
			break;
		case "/cWrite.bo":
			command = new BoardWrite();
			command.executeQueryCommand(request, response);
			url = (String) request.getAttribute("url");
			break;
		case "/cView.bo":
			command = new BoardView();
			command.executeQueryCommand(request, response);
			url = (String) request.getAttribute("url");
			break;
		case "/cDelete.bo":
			command = new BoardDelete();
			command.executeQueryCommand(request, response);
			return;		//AJAX
		case "/cEditView.bo": 
			command = new BoardEditView();
			command.executeQueryCommand(request, response);
			url = (String) request.getAttribute("url");
			break;
		case "/cEdit.bo":
			command = new BoardEdit();
			command.executeQueryCommand(request, response);
			return;		//AJAX
		case "/cLike.bo":
			command = new BoardLike();
			command.executeQueryCommand(request, response);
			return;		//AJAX
		case "/cUnlike.bo":
			command = new BoardUnlike();
			command.executeQueryCommand(request, response);
			return;		//AJAX
		case "/replyList.bo":
			command = new ReplyList();
			command.executeQueryCommand(request, response);
			return;		//AJAX
		case "/cReply.bo":
			command = new BoardReply();
			command.executeQueryCommand(request, response);
			return;		//AJAX
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
}
