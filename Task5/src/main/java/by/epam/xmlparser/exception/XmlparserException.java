package by.epam.xmlparser.exception;

public class XmlparserException extends Exception {
	private Exception hiddenException;

	public XmlparserException(String message) {
		super(message);
	}
	
	public XmlparserException(String message, Exception e) {
		super(message, e);
		this.hiddenException = e;
	}

	public Exception getHiddenException() {
		return hiddenException;
	}

}
