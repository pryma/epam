package service.library;

import pojos.Book;
import pojos.Magazine;

import java.util.Map;

public interface LibraryUtil {

    Magazine createMagazine (Map<String, String> printedMatterMap);

    Book createBook (Map<String, String> printedMatterMap);
}
