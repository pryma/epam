package by.epam.task2.dao;

import by.epam.task2.dao.exception.DaoErrorCode;
import by.epam.task2.dao.exception.DaoException;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class DaoImpl implements Dao {

    private static final Logger logger = Logger.getLogger(DaoImpl.class);

    public StringBuilder readText(String path) throws DaoException {
        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader bufferedReader = null;

        try {
            bufferedReader = new BufferedReader(new FileReader(path));
            String next;
            while ((next = bufferedReader.readLine()) != null) {
                stringBuilder.append(next).append("\n");
            }

        } catch (FileNotFoundException e) {
            logger.error(DaoErrorCode.DAO_001, e);
            throw new DaoException(DaoErrorCode.DAO_001, e);

        } catch (IOException e) {
            logger.error(DaoErrorCode.DAO_004, e);
            throw new DaoException(DaoErrorCode.DAO_004, e);

        } finally {
            if (null != bufferedReader) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    logger.error(DaoErrorCode.DAO_002, e);
                    throw new DaoException(DaoErrorCode.DAO_002, e);
                }
            }
        }
        return stringBuilder;
    }

    public void writeText(String path, String text) throws DaoException {
        Writer writer = null;

        try {
            writer = new BufferedWriter(new FileWriter(path));
            writer.write(text);

        } catch (IOException e) {
            logger.error(DaoErrorCode.DAO_003, e);
            throw new DaoException(DaoErrorCode.DAO_003, e);

        } finally {
            if (null != writer) {
                try {
                    writer.close();
                } catch (IOException e) {
                    logger.error(DaoErrorCode.DAO_002, e);
                    throw new DaoException(DaoErrorCode.DAO_002, e);
                }
            }
        }
    }


}
