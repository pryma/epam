package by.epam.task2.service.textchange;

import by.epam.task2.service.exception.ServiceException;
import by.epam.task2.service.textchange.composite.Composite;
import by.epam.task2.service.textchange.parser.RegExType;

import java.util.List;

/**
 * Created by Максим&Маша on 12.06.14.
 */
public interface TextChangeService {

    Composite parseText(String path, List<RegExType> regExTypeList) throws ServiceException;

    public StringBuilder sortAllSentences(Composite composite);

    StringBuilder sortAllWords(Composite composite);

    public StringBuilder removeNextLetters(Composite composite);

    void writeText(String path, StringBuilder text) throws ServiceException;

}
