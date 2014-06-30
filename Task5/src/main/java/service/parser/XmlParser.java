package service.parser;

import org.w3c.dom.Document;
import pojos.Library;

import javax.xml.stream.XMLStreamException;
import java.util.List;
import java.util.Map;

public interface XmlParser {

    List<Map> DomParse(String nameXmlFile);

    void DomCreateLibraryXml(Library library, String nameXmlFile);

    List<Map> SaxParse(String nameXmlFile);

    List<Map> StAXParse(String nameXmlFile) throws XMLStreamException;

}
