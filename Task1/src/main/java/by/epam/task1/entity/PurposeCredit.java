package by.epam.task1.entity;

/**
 * Created by Максим&Маша on 18.05.14.
 */
public class PurposeCredit extends BankCredit {

    private String purposeOfCredit;

    public PurposeCredit() {
    }

    public String getPurposeOfCredit() {
        return purposeOfCredit;
    }

    public void setPurposeOfCredit(String purposeOfCredit) {
        this.purposeOfCredit = purposeOfCredit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        PurposeCredit that = (PurposeCredit) o;

        if (purposeOfCredit != null ? !purposeOfCredit.equals(that.purposeOfCredit) : that.purposeOfCredit != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (purposeOfCredit != null ? purposeOfCredit.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return super.toString() + "{" +
            "purposeOfCredit='" + purposeOfCredit + '\'' +
            '}';
    }
}
