package by.epam.xmlparser.dao.saximpl;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
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
			throw new XmlDaoException("Cannot create SAXParser", e);
		} catch (SAXException e) {
			throw new XmlDaoException("Cannot create SAXParser", e);
		}
		 
		 SaxDepositHandler depositHandler = new SaxDepositHandler();
		 
		 try {
			 InputStream inputStream = new FileInputStream(nameXmlFile);
			 saxParser.parse(inputStream, depositHandler);
			//saxParser.parse(ClassLoader.getSystemResourceAsStream("D:\\bank.xml"), depositHandler);
		} catch (IOException e) {
			throw new XmlDaoException("Cannot create FileInputStream to "+nameXmlFile, e);
		} catch (SAXException e) {
			throw new XmlDaoException("Cannot SAX parse XML file "+nameXmlFile, e);
		}
		
		return depositHandler.getDeposits();
	}
	
	

}
