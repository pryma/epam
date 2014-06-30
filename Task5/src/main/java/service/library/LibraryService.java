package service.library;

import pojos.Library;
import pojos.PrintedMatter;

public interface LibraryService {

    void putPrintedMatter (PrintedMatter printedMatter);

    Library createLibrary(String nameXmlFile);

    void createLibraryXml (Library library, String nameXmlFile);

}
