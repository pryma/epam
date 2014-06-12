package by.epam.task2.service.exception;

import by.epam.task2.dao.exception.DaoException;

import java.util.regex.PatternSyntaxException;

/**
 * Created by Максим&Маша on 10.06.14.
 */
public class ServiceException extends Exception {

    private ServiceErrorCode serviceErrorCode;
    private Object[]  params;
    private String message;

    PatternSyntaxException patternSyntaxException;

    public ServiceException(ServiceErrorCode serviceErrorCode, DaoException cause, Object... params) {
        super(cause);
        this.serviceErrorCode = serviceErrorCode;
        this.params = params;
        this.message = String.format(serviceErrorCode.toString(), params);
    }

    public ServiceException(ServiceErrorCode serviceErrorCode, PatternSyntaxException e, Object... params) {
        this.serviceErrorCode = serviceErrorCode;
        this.patternSyntaxException = e;
        this.params = params;
        this.message = String.format(serviceErrorCode.toString(), params);

    }

    public ServiceErrorCode getServiceErrorCode() {
        return serviceErrorCode;
    }

    public void setServiceErrorCode(ServiceErrorCode serviceErrorCode) {
        this.serviceErrorCode = serviceErrorCode;
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
