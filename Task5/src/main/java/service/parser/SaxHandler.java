package service.parser;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import service.enums.Tags;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SaxHandler extends DefaultHandler {

    List<Map> printedMatters = new ArrayList<Map>();
    Map<String, String> printedMatterMap = null;
    String content = null;

    public List<Map> getPrintedMatters() {
        return printedMatters;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals(Tags.PRINTED_MATTER.toString())) {
            printedMatterMap = new HashMap<String, String>();
            printedMatterMap.put(Tags.ID.toString(), attributes.getValue(Tags.ID.toString()));
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {

        if (qName.equals(Tags.CATEGORY.toString())) {
            printedMatterMap.put(qName, content);
        }  else if (qName.equals(Tags.SORT.toString())) {
            printedMatterMap.put(qName, content);
        } else if (qName.equals(Tags.PAGES.toString())) {
            printedMatterMap.put(qName, content);
        } else if (qName.equals(Tags.AUTHOR.toString())) {
            printedMatterMap.put(qName, content);
        } else if (qName.equals(Tags.NAME.toString())) {
            printedMatterMap.put(qName, content);
        }
        else if (qName.equals(Tags.PRINTED_MATTER.toString())) {
            printedMatters.add(printedMatterMap);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        content = String.valueOf(ch, start, length).trim();
    }
}
