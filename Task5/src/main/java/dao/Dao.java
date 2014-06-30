package dao;

import org.w3c.dom.Document;
import service.parser.SaxHandler;

import javax.xml.stream.XMLStreamReader;
import java.util.List;
import java.util.Map;

public interface Dao {

    Document createDocument(String nameXmlFile);

    Document createNewDocument();

    void writeXmlFile(Document document, String nameXmlFile);

    List<Map> getPrintedMatters(String nameXmlFile, SaxHandler saxHandler);

    XMLStreamReader createXmlStreamReader(String nameXmlFile);
}
