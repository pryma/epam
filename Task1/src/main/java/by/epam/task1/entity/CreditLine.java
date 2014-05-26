package by.epam.task1.entity;

/**
 * Created by Максим&Маша on 20.05.14.
 */
public class CreditLine extends PurposeCredit{

    private String typeOfCreditLine;

    public CreditLine() {
    }

    public String getTypeOfCreditLine() {
        return typeOfCreditLine;
    }

    public void setTypeOfCreditLine(String typeOfCreditLine) {
        this.typeOfCreditLine = typeOfCreditLine;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        CreditLine that = (CreditLine) o;

        if (typeOfCreditLine != null ? !typeOfCreditLine.equals(that.typeOfCreditLine) : that.typeOfCreditLine != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (typeOfCreditLine != null ? typeOfCreditLine.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return super.toString() + "{" +
            "typeOfCreditLine='" + typeOfCreditLine + '\'' +
            '}';
    }
}
