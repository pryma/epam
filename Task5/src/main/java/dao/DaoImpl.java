package dao;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import service.parser.SaxHandler;

import javax.xml.parsers.*;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

public class DaoImpl implements Dao {

    public DaoImpl() {
    }

    //@Override
    public Document createDocument(String nameXmlFile) {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = null;
        try {
            documentBuilder = documentBuilderFactory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        Document document = null;
        try {
            document = documentBuilder.parse(ClassLoader.getSystemResourceAsStream(nameXmlFile));
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return document;
    }

    //@Override
    public Document createNewDocument() {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = null;
        try {
            documentBuilder = documentBuilderFactory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        Document document = documentBuilder.newDocument();

        return document;
    }

    //@Override
    public void writeXmlFile(Document document, String nameXmlFile) {
        DOMSource domSource = new DOMSource(document);
        File file = new File(nameXmlFile);
        StreamResult streamResult = new StreamResult(file);
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = null;
        try {
            transformer = transformerFactory.newTransformer();
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        }
        if (transformer != null) {
            try {
                transformer.transform(domSource, streamResult);
            } catch (TransformerException e) {
                e.printStackTrace();
            }
        }
    }

    //@Override
    public List<Map> getPrintedMatters(String nameXmlFile, SaxHandler saxHandler) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = null;
        try {
            saxParser = saxParserFactory.newSAXParser();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
        if (saxParser != null) {
            try {
                saxParser.parse(ClassLoader.getSystemResourceAsStream(nameXmlFile), saxHandler);
            } catch (SAXException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return saxHandler.getPrintedMatters();
    }

    //@Override
    public XMLStreamReader createXmlStreamReader(String nameXmlFile) {
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        XMLStreamReader xmlStreamReader = null;
        try {
            xmlStreamReader = xmlInputFactory.createXMLStreamReader(ClassLoader.getSystemResourceAsStream(nameXmlFile));
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
        return xmlStreamReader;
    }
}
