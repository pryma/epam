package by.epam.task2.service.textchange;

import by.epam.task2.service.exception.ServiceException;
import by.epam.task2.service.textchange.composite.Composite;
import by.epam.task2.service.textchange.composite.IParticleComposite;
import by.epam.task2.service.textchange.composite.Particle;
import by.epam.task2.dao.Dao;
import by.epam.task2.dao.DaoImpl;
import by.epam.task2.dao.exception.DaoException;
import by.epam.task2.service.exception.ServiceErrorCode;

import by.epam.task2.service.textchange.parser.Parser;
import by.epam.task2.service.textchange.parser.RegExType;
import org.apache.log4j.Logger;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by Максим&Маша on 08.06.14.
 */
public class TextChangeServiceImpl implements TextChangeService {

    Logger logger = Logger.getLogger(TextChangeServiceImpl.class);

    Dao dao = new DaoImpl();

    @Override
    public void writeText(String path, StringBuilder text) throws ServiceException {
        try {
            dao.writeText(path, text.toString());
        } catch (DaoException e) {
            logger.error(ServiceErrorCode.SRVS_002, e);
            throw new ServiceException(ServiceErrorCode.SRVS_002, e);
        }
    }

    @Override
    public Composite parseText(String path, List<RegExType> regExTypeList) throws ServiceException {
        String text;
        try {
            text = dao.readText(path).toString();
        } catch (DaoException e) {
            logger.error(ServiceErrorCode.SRVS_001, e);
            throw new ServiceException(ServiceErrorCode.SRVS_001, e);
        }
        Composite composite = Parser.parseText(text, regExTypeList);

        return composite;
    }

    public StringBuilder sortAllSentences(Composite composite) {
        StringBuilder stringBuilder = new StringBuilder();
        Set<Composite> sentenceTreeSet = new TreeSet<Composite>();

        for (IParticleComposite IParticleCompositeSentence : composite.getParticleList()) {
            Composite sentence = (Composite) IParticleCompositeSentence;
            sentenceTreeSet.add(sentence);
        }
        Iterator<Composite> iterator = sentenceTreeSet.iterator();
        while (iterator.hasNext()) {
            Composite sent = iterator.next();
            for (IParticleComposite IParticleCompositeWord : sent.getParticleList()) {
                Particle particleWord = (Particle) IParticleCompositeWord.getParticleComposite();
                stringBuilder.append(particleWord.getParticle()).append(" ");
            }
            stringBuilder.append("\n");
        }
        return stringBuilder;
    }

    @Override
    public StringBuilder sortAllWords(Composite composite) {
        String[] wordArray = getWordArray(composite);
        String prefix = wordArray[0].substring(0, 1);
        StringBuilder stringBuilder = new StringBuilder();
        for (String word : wordArray) {
            if (word.startsWith(prefix)) {
                stringBuilder.append(word).append(" ");
            } else {
                stringBuilder.append("\n").append(word);
                prefix = word.substring(0, 1);
            }
        }
        return stringBuilder;
    }

    public StringBuilder removeNextLetters(Composite composite) {
        String[] wordArray = getWordArray(composite);
        StringBuilder stringBuilder = new StringBuilder();
        for (String word : wordArray) {
            String prefix = word.substring(0, 1);
            String[] split = word.split(prefix);
            stringBuilder.append(prefix);
            for (String s : split) {
                stringBuilder.append(s);
            }
            stringBuilder.append(" ");
        }
        return stringBuilder;
    }

    private String[] getWordArray(Composite composite) {
        Set<String> wordTreeSet = new TreeSet<String>();
        for (IParticleComposite IParticleCompositeSentence : composite.getParticleList()) {
            Composite sentence = (Composite) IParticleCompositeSentence;
            for (IParticleComposite IParticleCompositeWord : sentence.getParticleList()) {
                Particle particleWord = (Particle) IParticleCompositeWord.getParticleComposite();
                String word = particleWord.getParticle();
                if (!word.matches("[\\d\\s()\\->=<>,]*")) {
                    word = word.trim().toLowerCase();
                    wordTreeSet.add(word);
                }
            }
        }
        String[] wordArray = new String[wordTreeSet.size()];
        wordArray = wordTreeSet.toArray(wordArray);

        return wordArray;
    }
}
