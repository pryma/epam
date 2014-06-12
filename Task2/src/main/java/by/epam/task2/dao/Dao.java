package by.epam.task2.dao;


import by.epam.task2.dao.exception.DaoException;

public interface Dao {

    StringBuilder readText(String path) throws DaoException;

    void writeText(String path, String text) throws DaoException;

}
