package by.epam.task2;

import by.epam.task2.service.exception.ServiceException;
import by.epam.task2.service.textchange.TextChangeServiceImpl;
import by.epam.task2.service.textchange.composite.Composite;
import by.epam.task2.service.textchange.parser.RegExType;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] argv) throws ServiceException {
        String pathIn = "D:/text.txt";

        TextChangeServiceImpl textChangeService = new TextChangeServiceImpl();

        List<RegExType> regExTypeList = new ArrayList<RegExType>();
        regExTypeList.add(RegExType.SENTENCE);
        regExTypeList.add(RegExType.WORD);
        regExTypeList.add(RegExType.WORD_AND_SIGN);


        Composite composite = textChangeService.parseText(pathIn, regExTypeList);

        StringBuilder textSortAllWords = textChangeService.sortAllWords(composite);
        StringBuilder textRemoveNextLetters = textChangeService.removeNextLetters(composite);
        StringBuilder textSortAllSentences = textChangeService.sortAllSentences(composite);

        textChangeService.writeText("D:/text1.txt", textSortAllWords);
        textChangeService.writeText("D:/text2.txt", textRemoveNextLetters);
        textChangeService.writeText("D:/text3.txt", textSortAllSentences);


    }
}