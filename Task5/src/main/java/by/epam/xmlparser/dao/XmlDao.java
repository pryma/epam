package by.epam.xmlparser.dao;

import java.util.List;

import by.epam.xmlparser.dao.exception.XmlDaoException;
import by.epam.xmlparser.pojo.Deposit;

public interface XmlDao {
	
	List<Deposit> parse(String nameXmlFile) throws XmlDaoException;

}
