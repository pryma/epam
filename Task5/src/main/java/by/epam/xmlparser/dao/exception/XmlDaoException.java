package by.epam.xmlparser.dao.exception;

import by.epam.xmlparser.exception.XmlparserException;

public class XmlDaoException extends XmlparserException{

	public XmlDaoException(String message) {
		super(message);
	}

	public XmlDaoException(String message, Exception e) {
		super(message, e);
	}
	

}
