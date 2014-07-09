package by.epam.xmlparser.dao.staximpl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import by.epam.xmlparser.dao.XmlDao;
import by.epam.xmlparser.dao.exception.XmlDaoException;
import by.epam.xmlparser.pojo.Deposit;

public class StaxXmlDao implements XmlDao{
	
	private static final XmlDao INSTANCE = new StaxXmlDao();
	
	private StaxXmlDao() {
	}
	
	public static XmlDao getInstance() {
		return INSTANCE;
	}

	public List<Deposit> parse(String nameXmlFile) throws XmlDaoException {
		XMLStreamReader xmlStreamReader = createXmlStreamReader(nameXmlFile);
		return new StaxDepositParser().parse(xmlStreamReader);
	}
	
	private XMLStreamReader createXmlStreamReader(String nameXmlFile) throws XmlDaoException {
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        XMLStreamReader xmlStreamReader = null;
        try {
        	InputStream inputStream = new FileInputStream(nameXmlFile);
        	xmlStreamReader = xmlInputFactory.createXMLStreamReader(inputStream);
            //xmlStreamReader = xmlInputFactory.createXMLStreamReader(ClassLoader.getSystemResourceAsStream(nameXmlFile));
        } catch (FileNotFoundException e) {
			throw new XmlDaoException("Cannot create FileInputStream to " + nameXmlFile, e);
		} catch (XMLStreamException e) {
            throw new XmlDaoException("Cannot create XMLStreamReader", e);
        } 
        return xmlStreamReader;
    }

}
