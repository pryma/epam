package service.parser;

import dao.Dao;
import dao.DaoImpl;
import org.w3c.dom.*;
import pojos.Library;
import service.enums.Tags;

import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.util.*;

public class XmlParserImpl implements XmlParser {
    private List<Map> printedMatters = new ArrayList<Map>();
    private Dao domDao = new DaoImpl();

    public XmlParserImpl() {
    }

    //@Override
    public List<Map> DomParse(String nameXmlFile) {
        Document document = domDao.createDocument(nameXmlFile);
        Element root = document.getDocumentElement();

        NodeList rootNodes = root.getChildNodes();
        for (int i = 0; i < rootNodes.getLength(); i++) {
            Node rootNode = rootNodes.item(i);
            if (rootNode instanceof Element) {
                Map<String, String> printedMatterMap = new HashMap<String, String>();
                NamedNodeMap namedNodeMap = rootNode.getAttributes();
                Node nodeId = namedNodeMap.getNamedItem(Tags.ID.toString());
                if (nodeId != null) {
                    printedMatterMap.put(nodeId.getNodeName(), nodeId.getNodeValue().trim());
                }
                NodeList childNodes = rootNode.getChildNodes();
                for (int j = 0; j < childNodes.getLength(); j++) {
                    Node childNode = childNodes.item(j);

                    if (childNode instanceof Element) {
                        Node lastChildNode = childNode.getLastChild();

                        if (lastChildNode != null) {
                            String nodeContent = lastChildNode.getTextContent().trim();
                            String nodeName = childNode.getNodeName();

                            if (nodeName.equals(Tags.CATEGORY.toString())) {
                                printedMatterMap.put(nodeName, nodeContent);
                            } else if (nodeName.equals(Tags.SORT.toString())) {
                                printedMatterMap.put(nodeName, nodeContent);
                            } else if (nodeName.equals(Tags.PAGES.toString())) {
                                printedMatterMap.put(nodeName, nodeContent);
                            } else if (nodeName.equals(Tags.NAME.toString())) {
                                printedMatterMap.put(nodeName, nodeContent);
                            } else if (nodeName.equals(Tags.AUTHOR.toString())) {
                                printedMatterMap.put(nodeName, nodeContent);
                            }
                        }
                    }
                }
                printedMatters.add(printedMatterMap);
            }
        }
        return printedMatters;
    }

    //@Override
    public void DomCreateLibraryXml(Library library, String nameXmlFile) {
        Document document = domDao.createNewDocument();

        Element rootElement = document.createElement(Tags.LIBRARY.toString());
        document.appendChild(rootElement);

        Element statistic = document.createElement(Tags.STATISTIC.toString());
        rootElement.appendChild(statistic);

        Map<String, Long> statisticMap = library.getStatistic().getStatisticMap();

        Element pages = document.createElement(Tags.PAGES.toString());
        pages.appendChild(document.createTextNode(String.valueOf(statisticMap.get(Tags.PAGES.toString()))));
        statistic.appendChild(pages);

        Iterator<String> keys = statisticMap.keySet().iterator();
        while (keys.hasNext()) {
            String key = keys.next();
            if (!key.equals(Tags.PAGES.toString())) {
                Element element = document.createElement(key);
                element.appendChild(document.createTextNode(String.valueOf(statisticMap.get(key))));
                statistic.appendChild(element);
            }
        }
        Map<Class, Map<String, Long>> statisticMapMap = library.getStatistic().getStatisticMapMap();
        Iterator<Class> classes = statisticMapMap.keySet().iterator();
        while (classes.hasNext()) {
            Class clazz = classes.next();
            Element categoryElement = document.createElement(clazz.getSimpleName().toLowerCase());
            statistic.appendChild(categoryElement);
            Map<String, Long> map = statisticMapMap.get(clazz);
            Iterator<String> sorts = map.keySet().iterator();
            while (sorts.hasNext()) {
                String sort = sorts.next();
                Element sortElement = document.createElement(sort);
                sortElement.appendChild(document.createTextNode(String.valueOf(map.get(sort))));
                categoryElement.appendChild(sortElement);
            }

        }

        /*Map<Class, List> libraryMap = library.getLibraryMap();
        List<Book> books = libraryMap.get(Book.class);
        for (Book book : books) {
            Element printedMatterElement = document.createElement(Tags.BOOK.toString());
            rootElement.appendChild(printedMatterElement);

            Attr attr = document.createAttribute(Tags.ID.toString());
            attr.setValue(book.getId());
            printedMatterElement.setAttributeNode(attr);

            Element author = document.createElement(Tags.AUTHOR.toString());
            author.appendChild(document.createTextNode(book.getAuthor()));
            printedMatterElement.appendChild(author);

            Element name = document.createElement(Tags.NAME.toString());
            name.appendChild(document.createTextNode(book.getName()));
            printedMatterElement.appendChild(name);
        }*/

        domDao.writeXmlFile(document, nameXmlFile);
    }

    //@Override
    public List<Map> SaxParse(String nameXmlFile) {
        SaxHandler saxHandler = new SaxHandler();

        printedMatters = domDao.getPrintedMatters(nameXmlFile, saxHandler);

        return printedMatters;
    }

    //@Override
    public List<Map> StAXParse(String nameXmlFile) throws XMLStreamException {
        Map<String, String> printedMatterMap = null;
        String content = null;
        XMLStreamReader xmlStreamReader = domDao.createXmlStreamReader(nameXmlFile);
        while (xmlStreamReader.hasNext()) {
            int event = xmlStreamReader.next();

            switch (event) {
                case XMLStreamConstants.START_ELEMENT:
                    if (xmlStreamReader.getLocalName().equals(Tags.PRINTED_MATTER.toString())) {
                        printedMatterMap = new HashMap<String, String>();
                        printedMatterMap.put(Tags.ID.toString(), xmlStreamReader.getAttributeValue(0));
                    }
                    break;
                case XMLStreamConstants.CHARACTERS:
                    content = xmlStreamReader.getText().trim();
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    if (xmlStreamReader.getLocalName().equals(Tags.CATEGORY.toString())) {
                        printedMatterMap.put(xmlStreamReader.getLocalName(), content);
                    } else if (xmlStreamReader.getLocalName().equals(Tags.SORT.toString())) {
                        printedMatterMap.put(xmlStreamReader.getLocalName(), content);
                    } else if (xmlStreamReader.getLocalName().equals(Tags.PAGES.toString())) {
                        printedMatterMap.put(xmlStreamReader.getLocalName(), content);
                    } else if (xmlStreamReader.getLocalName().equals(Tags.AUTHOR.toString())) {
                        printedMatterMap.put(xmlStreamReader.getLocalName(), content);
                    } else if (xmlStreamReader.getLocalName().equals(Tags.NAME.toString())) {
                        printedMatterMap.put(xmlStreamReader.getLocalName(), content);
                    } else if (xmlStreamReader.getLocalName().equals(Tags.PRINTED_MATTER.toString())) {
                        printedMatters.add(printedMatterMap);
                    }
                    break;
            }
        }
        return printedMatters;
    }
}
