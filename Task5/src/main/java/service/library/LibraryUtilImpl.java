package service.library;

import pojos.Book;
import pojos.Magazine;
import service.enums.Tags;

import java.util.Map;

public class LibraryUtilImpl implements LibraryUtil {

    //@Override
    public Magazine createMagazine(Map<String, String> printedMatterMap) {
        Magazine magazine = new Magazine();
        if (printedMatterMap.containsKey(Tags.ID.toString())) {
            magazine.setId(printedMatterMap.get(Tags.ID.toString()));
        }
        if (printedMatterMap.containsKey(Tags.SORT.toString())) {
            magazine.setSort(printedMatterMap.get(Tags.SORT.toString()));
        }
        if (printedMatterMap.containsKey(Tags.PAGES.toString())) {
            magazine.setPages(printedMatterMap.get(Tags.PAGES.toString()));
        }
        if (printedMatterMap.containsKey(Tags.NAME.toString())) {
            magazine.setName(printedMatterMap.get(Tags.NAME.toString()));
        }
        return magazine;
    }

   // @Override
    public Book createBook(Map<String, String> printedMatterMap) {
        Book book = new Book();
        if (printedMatterMap.containsKey(Tags.ID.toString())) {
            book.setId(printedMatterMap.get(Tags.ID.toString()));
        }
        if (printedMatterMap.containsKey(Tags.SORT.toString())) {
            book.setSort(printedMatterMap.get(Tags.SORT.toString()));
        }
        if (printedMatterMap.containsKey(Tags.PAGES.toString())) {
            book.setPages(printedMatterMap.get(Tags.PAGES.toString()));
        }
        if (printedMatterMap.containsKey(Tags.NAME.toString())) {
            book.setName(printedMatterMap.get(Tags.NAME.toString()));
        }
        if (printedMatterMap.containsKey(Tags.AUTHOR.toString())) {
            book.setAuthor(printedMatterMap.get(Tags.AUTHOR.toString()));
        }
        return book;
    }
}
