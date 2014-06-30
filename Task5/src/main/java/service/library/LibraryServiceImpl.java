package service.library;

import pojos.*;
import service.enums.Tags;
import service.parser.XmlParser;
import service.parser.XmlParserImpl;

import javax.xml.stream.XMLStreamException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LibraryServiceImpl implements LibraryService {
    XmlParser xmlParser = new XmlParserImpl();

    private Library library = new Library();
    private Map<Class, List> libraryMap = library.getLibraryMap();
    private Statistic statistic = library.getStatistic();
    private Map<String, Long> statisticMap = statistic.getStatisticMap();
    private Map<Class, Map<String, Long>> statisticMapMap = statistic.getStatisticMapMap();

    private LibraryUtil libraryUtil = new LibraryUtilImpl();


    //@Override
    public void putPrintedMatter(PrintedMatter printedMatter) {
        List<PrintedMatter> libraryList;
        if (libraryMap.containsKey(printedMatter.getClass())) {
            libraryList = libraryMap.get(printedMatter.getClass());
        } else {
            libraryList = new ArrayList<PrintedMatter>();
        }
        libraryList.add(printedMatter);
        libraryMap.put(printedMatter.getClass(), libraryList);

        if (printedMatter.getPages() != null) {
            String pages = printedMatter.getPages();
            if (pages.matches("[0-9]+")) {
                Long pagesLong = Long.valueOf(pages);
                if (statisticMap.containsKey(Tags.PAGES.toString())) {
                    pagesLong = pagesLong + statisticMap.get(Tags.PAGES.toString());
                    statisticMap.put(Tags.PAGES.toString(), pagesLong);
                } else {
                    statisticMap.put(Tags.PAGES.toString(), pagesLong);
                }
            }
        }

        if (printedMatter.getSort() != null && !printedMatter.getSort().equals("")) {
            if (statisticMap.containsKey(printedMatter.getSort())) {
                Long counter = statisticMap.get(printedMatter.getSort());
                counter++;
                statisticMap.put(printedMatter.getSort(), counter);
            } else {
                Long counter = 1L;
                statisticMap.put(printedMatter.getSort(), counter);
            }

            if (statisticMapMap.containsKey(printedMatter.getClass())) {
                Map<String, Long> map = statisticMapMap.get(printedMatter.getClass());
                Long counter;
                if (statisticMapMap.get(printedMatter.getClass()).containsKey(printedMatter.getSort())) {
                    counter = map.get(printedMatter.getSort());
                    counter++;
                } else {
                    counter = 1L;
                }
                map.put(printedMatter.getSort(), counter);
                statisticMapMap.put(printedMatter.getClass(), map);
            } else {
                Map<String, Long> map = new HashMap<String, Long>();
                Long counter = 1L;
                map.put(printedMatter.getSort(), counter);
                statisticMapMap.put(printedMatter.getClass(), map);
            }

        }
    }

    //@Override
    public Library createLibrary(String nameXmlFile) {

        List<Map> printedMatters = xmlParser.DomParse(nameXmlFile);
        //List<Map> printedMatters = xmlParser.SaxParse(nameXmlFile);
        /*List<Map> printedMatters = null;
        try {
            printedMatters = xmlParser.StAXParse(nameXmlFile);
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }*/


        for (Map<String, String> printedMatterMap : printedMatters) {
            if (printedMatterMap.containsKey(Tags.CATEGORY.toString())) {
                String categoryPrintedMatter = printedMatterMap.get(Tags.CATEGORY.toString());

                if (categoryPrintedMatter.equals(Tags.MAGAZINE.toString())) {
                    Magazine magazine = libraryUtil.createMagazine(printedMatterMap);
                    putPrintedMatter(magazine);
                } else if (categoryPrintedMatter.equals(Tags.BOOK.toString())) {
                    Book book = libraryUtil.createBook(printedMatterMap);
                    putPrintedMatter(book);
                }
            }
        }
        return library;
    }

    //@Override
    public void createLibraryXml(Library library,String nameXmlFile) {
        xmlParser.DomCreateLibraryXml(library, nameXmlFile);
    }
}
