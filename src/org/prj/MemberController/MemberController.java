package org.prj.MemberController;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.prj.MemberCommand.EmailCheck;
import org.prj.MemberCommand.ManageDelete;
import org.prj.MemberCommand.MemberCommand;
import org.prj.MemberCommand.MemberDelete;
import org.prj.MemberCommand.MemberDeleteView;
import org.prj.MemberCommand.MemberManage;
import org.prj.MemberCommand.MemberModify;
import org.prj.MemberCommand.MemberModifyView;
import org.prj.MemberCommand.MemberView;
import org.prj.MemberCommand.NameCheck;
import org.prj.MemberCommand.NameFind;
import org.prj.MemberCommand.PwFind;
import org.prj.MemberCommand.SignIn;
import org.prj.MemberCommand.SignUp;

@WebServlet("*.mo")
public class MemberController extends HttpServlet {
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

		MemberCommand command = null;
		String url = "";

		switch (basicURL) {
		case "/signUp.mo":
			command = new SignUp();
			command.executeQueryCommand(request, response);
			url = (String) request.getAttribute("url");
			break;
		case "/signIn.mo":
			command = new SignIn();
			command.executeQueryCommand(request, response);
			return;
		case "/nameFind.mo":
			command = new NameFind();
			command.executeQueryCommand(request, response);
			url = (String) request.getAttribute("url");
			break;
		case "/pwFind.mo":
			command = new PwFind();
			command.executeQueryCommand(request, response);
			url = (String) request.getAttribute("url");
			break;
		case "/nameCheck.mo":
			command = new NameCheck();
			command.executeQueryCommand(request, response);
			return; // AJAX
		case "/emailCheck.mo":
			command = new EmailCheck();
			command.executeQueryCommand(request, response);
			return; // AJAX
		case "/memberView.mo":
			command = new MemberView();
			command.executeQueryCommand(request, response);
			url = (String) request.getAttribute("url");
			break;
		case "/memberModifyView.mo":
			command = new MemberModifyView();
			command.executeQueryCommand(request, response);
			url = (String) request.getAttribute("url");
			break;
		case "/memberModify.mo":
			command = new MemberModify();
			command.executeQueryCommand(request, response);
			return; // AJAX
		case "/memberDeleteView.mo":
			command = new MemberDeleteView();
			command.executeQueryCommand(request, response);
			url = (String) request.getAttribute("url");
			break;
		case "/memberDelete.mo":
			command = new MemberDelete();
			command.executeQueryCommand(request, response);
			url = (String) request.getAttribute("url");
			break;
		case "/memberManage.mo":
			command = new MemberManage();
			command.executeQueryCommand(request, response);
			url = (String) request.getAttribute("url");
			break;
		case "/manageDelete.mo":
			command = new ManageDelete();
			command.executeQueryCommand(request, response);
			return;
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);

	}
}
