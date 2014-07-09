package by.epam.xmlparser.controller;

public enum JspUrl {
	
	PARSE_PAGE(""),
	PARSE_DEPOSIT_RESULT_PAGE("view/result.jsp"),
	ERROR_PAGE("error.jsp");
	
	private String jspUrl;
	
	private JspUrl(String jspUrl) {
		this.jspUrl = jspUrl;
	}
	
	public String getUrl() {
		return jspUrl;
	}

}
