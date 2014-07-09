package by.epam.xmlparser.dao;

public enum DepositTags {
	
    DEPOSIT("deposit"),
    BANK_NAME("bankName"),
    BANK_COUNTRY("country"),
    DEPOSIT_TYPE("depositType"),
    DEPOSITOR("depositor"),
    ACCOUNT_ID("accountId"),
    AMOUNT_ON_DEPOSIT("amountOnDeposit"),
    PROFITABILITY("profitability"),
    TIME_CONSTRAINTS("timeConstraints");

    private String tag;

    private DepositTags(String tag) {
        this.tag = tag;
    }

    public String getTag() {
        return tag;
    }
}
