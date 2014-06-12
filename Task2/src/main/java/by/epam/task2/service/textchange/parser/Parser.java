package by.epam.task2.service.textchange.parser;

import by.epam.task2.service.exception.ServiceErrorCode;
import by.epam.task2.service.exception.ServiceException;
import by.epam.task2.service.textchange.composite.Composite;
import by.epam.task2.service.textchange.composite.Particle;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/**
 * Created by Максим&Маша on 04.06.14.
 */
public class Parser {

    public Parser() {
    }

    private static final Logger logger = Logger.getLogger(Parser.class);

    public static Composite parseText(String text, List<RegExType> regExTypeList) throws ServiceException {
        int i = 0;
        Composite compositeText = ParsePart(text, regExTypeList, i);
        return compositeText;
    }

    private static Composite ParsePart(String partString, List<RegExType> regExTypeList, int i) throws ServiceException {
        Composite composite = new Composite();
        Pattern pattern;
        try {
            pattern = Pattern.compile(regExTypeList.get(i).getRegEx());
        } catch (PatternSyntaxException e) {
            logger.error(ServiceErrorCode.SRVS_003, e);
            throw new ServiceException(ServiceErrorCode.SRVS_003, e);
        }
        Matcher matcher = pattern.matcher(partString);
        while (matcher.find()) {
            String part = matcher.group();
            if (i < regExTypeList.size() - 1) {
                Composite compositePart = ParsePart(part, regExTypeList, i + 1);
                composite.addParticle(compositePart);
            } else {
                Particle particle = new Particle(part);
                composite.addParticle(particle);
            }
        }
        return composite;
    }

}
