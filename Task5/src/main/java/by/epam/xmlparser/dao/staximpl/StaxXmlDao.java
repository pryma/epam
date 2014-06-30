package by.epam.xmlparser.dao.staximpl;

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
            xmlStreamReader = xmlInputFactory.createXMLStreamReader(ClassLoader.getSystemResourceAsStream(nameXmlFile));
        } catch (XMLStreamException e) {
            throw new XmlDaoException("", e);
        }
        return xmlStreamReader;
    }

}
