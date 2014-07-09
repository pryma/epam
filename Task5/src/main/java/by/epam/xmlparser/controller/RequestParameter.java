package by.epam.xmlparser.controller;

public enum RequestParameter {
	
	COMMAND("command"),
	XML_FILE_NAME("nameXmlFIle"),
	DEPOSIT_LIST("depositList");
	
	private String parameter;
	
	private RequestParameter(String parameter) {
		this.parameter = parameter;
	}
	
	public String getParameter() {
		return parameter;
	}

}
