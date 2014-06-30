package by.epam.xmlparser.dao.saximpl;

import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

import by.epam.xmlparser.dao.XmlDao;
import by.epam.xmlparser.dao.exception.XmlDaoException;
import by.epam.xmlparser.pojo.Deposit;

public class SaxXmlDao implements XmlDao{
	
	private static final XmlDao INSTANCE = new SaxXmlDao();
	
	private SaxXmlDao() {
	}

	public static XmlDao getInstance() {
		return INSTANCE;
	}

	public List<Deposit> parse(String nameXmlFile) throws XmlDaoException {
		
		 SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
		 SAXParser saxParser;
		 
		 try {
			saxParser = saxParserFactory.newSAXParser();
		} catch (ParserConfigurationException e) {
			throw new XmlDaoException("", e);
		} catch (SAXException e) {
			throw new XmlDaoException("", e);
		}
		 
		 SaxDepositHandler depositHandler = new SaxDepositHandler();
		 
		 try {
			saxParser.parse(ClassLoader.getSystemResourceAsStream(nameXmlFile), depositHandler);
		} catch (SAXException e) {
			throw new XmlDaoException("", e);
		} catch (IOException e) {
			throw new XmlDaoException("", e);
		}
		
		return depositHandler.getDeposits();
	}
	
	

}
