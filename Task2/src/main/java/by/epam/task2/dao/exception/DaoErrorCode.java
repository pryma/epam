package by.epam.task2.dao.exception;

/**
 * Created by Максим&Маша on 10.06.14.
 */
public enum DaoErrorCode {

    DAO_001("Cannot find file %s"),
    DAO_002("Cannot close file %s"),
    DAO_003("Cannot write file");

    private final String value;

    DaoErrorCode(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
