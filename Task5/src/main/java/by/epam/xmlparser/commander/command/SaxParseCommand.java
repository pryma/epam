package by.epam.xmlparser.commander.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import by.epam.xmlparser.commander.ICommand;
import by.epam.xmlparser.commander.exception.CommandException;
import by.epam.xmlparser.controller.JspUrl;
import by.epam.xmlparser.controller.RequestParameter;
import by.epam.xmlparser.dao.XmlDao;
import by.epam.xmlparser.dao.exception.XmlDaoException;
import by.epam.xmlparser.dao.factory.DaoType;
import by.epam.xmlparser.dao.factory.XmlDaoFactory;
import by.epam.xmlparser.pojo.Deposit;
import by.epam.xmlparser.service.DepositModel;
import by.epam.xmlparser.service.ParserService;
import by.epam.xmlparser.service.exception.ServiceException;

public class SaxParseCommand implements ICommand {

	public String execute(HttpServletRequest request) throws CommandException {
		try {
			List<DepositModel> deposits = ParserService.parse(DaoType.SAX, request.getParameter(RequestParameter.XML_FILE_NAME.getParameter()));
			request.setAttribute(RequestParameter.DEPOSIT_LIST.getParameter(), deposits);
		} catch (ServiceException e) {
			throw new CommandException("Cannot execute SaxParseCommand", e);
		}
		return JspUrl.PARSE_DEPOSIT_RESULT_PAGE.getUrl();
	}

}
