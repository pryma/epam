package by.epam.xmlparser.commander.command;

import javax.servlet.http.HttpServletRequest;

import by.epam.xmlparser.commander.ICommand;
import by.epam.xmlparser.commander.exception.CommandException;
import by.epam.xmlparser.controller.JspUrl;

public class NoCommand implements ICommand{

	//@Override
	public String execute(HttpServletRequest request) throws CommandException {
		
		
		
		return JspUrl.ERROR_PAGE.getUrl();
	}

}
