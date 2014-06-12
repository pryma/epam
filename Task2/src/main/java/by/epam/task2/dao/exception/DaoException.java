package by.epam.task2.dao.exception;

/**
 * Created by Максим&Маша on 10.06.14.
 */
public class DaoException extends Exception{

    private DaoErrorCode daoErrorCode;
    private Object[] params;
    private String message;

    public DaoException(DaoErrorCode daoErrorCode, Throwable couse , Object... params) {
        super(couse);
        this.daoErrorCode = daoErrorCode;
        this.params = params;
        this.message = String.format(daoErrorCode.toString(), params);
    }

    public DaoErrorCode getDaoErrorCode() {
        return daoErrorCode;
    }

    public void setDaoErrorCode(DaoErrorCode daoErrorCode) {
        this.daoErrorCode = daoErrorCode;
    }

    public Object[] getParams() {
        return params;
    }

    public void setParams(Object[] params) {
        this.params = params;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
