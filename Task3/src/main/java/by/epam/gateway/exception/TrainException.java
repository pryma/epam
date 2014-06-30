package by.epam.gateway.exception;

/**
 * Created by Максим&Маша on 23.06.14.
 */
public class TrainException extends Exception {

    private Exception _hidden;

    public TrainException(String message) {
        super(message);
    }

    public TrainException(String message, Exception e) {
        super(message);
        _hidden = e;
    }

    public Exception getHiddenException() {
        return _hidden;
    }


}
