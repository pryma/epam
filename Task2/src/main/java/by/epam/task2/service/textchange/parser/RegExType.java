package by.epam.task2.service.textchange.parser;

/**
 * Created by Максим&Маша on 06.06.14.
 */
public enum RegExType {

    SENTENCE("([A-Z].+[\\.!\\?:?])"),
    WORD            ("([^(\\s)]*)(\\s)*"),
    WORD_AND_SIGN   ("([\\.,!\\?:;@]{1})|([^\\.,!\\?:;@]*)");

    String regEx;

    RegExType(String regEx) {
        this.regEx = regEx;
    }

    public String getRegEx() {
        return regEx;
    }
}
