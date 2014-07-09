package by.epam.xmlparser.dao.domimpl;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import by.epam.xmlparser.dao.XmlDao;
import by.epam.xmlparser.dao.exception.XmlDaoException;
import by.epam.xmlparser.pojo.Deposit;

public class DomXmlDao implements XmlDao{
	
	private static final XmlDao INSTANCE = new DomXmlDao();
	
	private DomXmlDao() {
	}

	public static XmlDao getInstance() {
		return INSTANCE;
	}

	public List<Deposit> parse(String nameXmlFile) throws XmlDaoException {
		Document depositDocument = createDocument(nameXmlFile);
		return new DomDepositParser().parse(depositDocument);
	}
	
	private Document createDocument(String nameXmlFile) throws XmlDaoException {
		
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = null;
        
        try {
            documentBuilder = documentBuilderFactory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            throw new XmlDaoException("", e);
        }
        Document depositDocument = null;
        try {
        	InputStream inputStream = new FileInputStream(nameXmlFile);
        	depositDocument = documentBuilder.parse(inputStream);
            //depositDocument = documentBuilder.parse(ClassLoader.getSystemResourceAsStream(nameXmlFile));
        } catch (IOException e) {
        	throw new XmlDaoException("Cannot create FileInputStream to "+nameXmlFile, e);
        } catch (SAXException e) {
        	throw new XmlDaoException("Cannot DOM parse XML file "+nameXmlFile, e);
        }
        return depositDocument;
    } 
	
	

}
