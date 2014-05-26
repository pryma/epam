package by.epam.task1.logic.model;

/**
 * Created by Максим&Маша on 22.05.14.
 */
public class RequestCreditListModel {

    private int amountOfCredit;
    private String currencyOfCredit;
    private int creditPeriod;
    private String bankCreditor;
    private String purposeOfCredit;
    private String typeOfCreditLine;

    public RequestCreditListModel() {
    }

    public int getAmountOfCredit() {
        return amountOfCredit;
    }

    public void setAmountOfCredit(int amountOfCredit) {
        this.amountOfCredit = amountOfCredit;
    }

    public String getCurrencyOfCredit() {
        return currencyOfCredit;
    }

    public void setCurrencyOfCredit(String currencyOfCredit) {
        this.currencyOfCredit = currencyOfCredit;
    }

    public int getCreditPeriod() {
        return creditPeriod;
    }

    public void setCreditPeriod(int creditPeriod) {
        this.creditPeriod = creditPeriod;
    }

    public String getBankCreditor() {
        return bankCreditor;
    }

    public void setBankCreditor(String bankCreditor) {
        this.bankCreditor = bankCreditor;
    }

    public String getPurposeOfCredit() {
        return purposeOfCredit;
    }

    public void setPurposeOfCredit(String purposeOfCredit) {
        this.purposeOfCredit = purposeOfCredit;
    }

    public String getTypeOfCreditLine() {
        return typeOfCreditLine;
    }

    public void setTypeOfCreditLine(String typeOfCreditLine) {
        this.typeOfCreditLine = typeOfCreditLine;
    }
}
