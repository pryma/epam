package by.epam.xmlparser.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.epam.xmlparser.commander.CommandDispatcher;
import by.epam.xmlparser.commander.ICommand;
import by.epam.xmlparser.commander.exception.CommandException;

public class Controller extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {
		
		String commandName = request.getParameter(RequestParameter.COMMAND);
		ICommand command = CommandDispatcher.getCommand(commandName);
		String jspUrl;
		try {
			jspUrl = command.execute(request);
		} catch (CommandException e) {
			jspUrl = JspUrl.ERROR_PAGE;
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(jspUrl);
		if (null != dispatcher) {
			dispatcher.forward(request, response);
		} else {
			
		}
		
		
	}
	
	

}
