package org.prj.BoardCommand;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface BoardCommand {
	void executeQueryCommand(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException;
}
