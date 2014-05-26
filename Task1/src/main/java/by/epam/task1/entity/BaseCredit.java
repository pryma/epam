package by.epam.task1.entity;

/**
 * Created by Максим&Маша on 17.05.14.
 */
public abstract class BaseCredit implements Comparable<BaseCredit> {

    private int id;
    private int amountOfCredit;
    private double percentage;
    private int creditPeriod;
    private String currencyOfCredit;

    @Override
    public int compareTo(BaseCredit o) {
        return this.amountOfCredit - o.getAmountOfCredit();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAmountOfCredit() {
        return amountOfCredit;
    }

    public void setAmountOfCredit(int amountOfCredit) {
        this.amountOfCredit = amountOfCredit;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

    public int getCreditPeriod() {
        return creditPeriod;
    }

    public void setCreditPeriod(int creditPeriod) {
        this.creditPeriod = creditPeriod;
    }

    public String getCurrencyOfCredit() {
        return currencyOfCredit;
    }

    public void setCurrencyOfCredit(String currencyOfCredit) {
        this.currencyOfCredit = currencyOfCredit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BaseCredit that = (BaseCredit) o;

        if (amountOfCredit != that.amountOfCredit) return false;
        if (creditPeriod != that.creditPeriod) return false;
        if (id != that.id) return false;
        if (Double.compare(that.percentage, percentage) != 0) return false;
        if (currencyOfCredit != null ? !currencyOfCredit.equals(that.currencyOfCredit) : that.currencyOfCredit != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + amountOfCredit;
        temp = Double.doubleToLongBits(percentage);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + creditPeriod;
        result = 31 * result + (currencyOfCredit != null ? currencyOfCredit.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return getClass().getName() + "{" +
            "id=" + id +
            ", amountOfCredit=" + amountOfCredit +
            ", percentage=" + percentage +
            ", creditPeriod=" + creditPeriod +
            ", currencyOfCredit='" + currencyOfCredit + '\'' +
            '}';
    }
}
