package by.epam.xmlparser.dao.factory;

import by.epam.xmlparser.dao.XmlDao;
import by.epam.xmlparser.dao.domimpl.DomXmlDao;
import by.epam.xmlparser.dao.exception.XmlDaoException;
import by.epam.xmlparser.dao.saximpl.SaxXmlDao;
import by.epam.xmlparser.dao.staximpl.StaxXmlDao;

public class XmlDaoFactory {
	
private static final XmlDaoFactory INSTANCE = new XmlDaoFactory();
	
	private XmlDaoFactory() {
	}

	public static XmlDaoFactory getInstance() {
		return INSTANCE;
	}
	
	public XmlDao getXmlDao (DaoType typeDao) throws XmlDaoException {
		
		switch (typeDao) {
		
		case DOM:
			return DomXmlDao.getInstance();
			
		case SAX:
			return SaxXmlDao.getInstance();
			
		case STAX:
			return StaxXmlDao.getInstance();
			
		default:
			throw new XmlDaoException("No such type of dao");
		}	
	}
}
