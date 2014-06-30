package by.epam.xmlparser.commander;

import javax.servlet.http.HttpServletRequest;

import by.epam.xmlparser.commander.exception.CommandException;

public interface ICommand {
	
	public String execute(HttpServletRequest request) throws CommandException;

}
