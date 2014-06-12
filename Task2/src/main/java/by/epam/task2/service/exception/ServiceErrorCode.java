package by.epam.task2.service.exception;

/**
 * Created by Максим&Маша on 10.06.14.
 */
public enum ServiceErrorCode {

    SRVS_001("Cannot read file %s"),
    SRVS_002("Cannot write file %s"),
    SRVS_003("Cannot parse file %s");

    private final String value;

    ServiceErrorCode(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
