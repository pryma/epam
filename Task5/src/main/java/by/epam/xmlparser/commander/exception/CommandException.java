package by.epam.xmlparser.commander.exception;

import by.epam.xmlparser.exception.XmlparserException;

public class CommandException extends XmlparserException{

	public CommandException(String message, Exception e) {
		super(message, e);
	}

	public CommandException(String message) {
		super(message);
	}

}
