package by.epam.task1.entity;

/**
 * Created by Максим&Маша on 20.05.14.
 */
public class RepaymentCredit extends CreditLine {

    private boolean advancedRepayment;

    public RepaymentCredit() {
    }

    public boolean isAdvancedRepayment() {
        return advancedRepayment;
    }

    public void setAdvancedRepayment(boolean advancedRepayment) {
        this.advancedRepayment = advancedRepayment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        RepaymentCredit that = (RepaymentCredit) o;

        if (advancedRepayment != that.advancedRepayment) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (advancedRepayment ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return super.toString() + "{" +
            "advancedRepayment=" + advancedRepayment +
            '}';
    }
}
