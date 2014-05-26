package by.epam.task1.creator;

import by.epam.task1.entity.BankCredit;
import by.epam.task1.entity.BaseCredit;
import by.epam.task1.entity.CreditLine;
import by.epam.task1.entity.PurposeCredit;
import by.epam.task1.entity.RepaymentCredit;

/**
 * Created by Максим&Маша on 18.05.14.
 */
public class BaseCreditBuilderImpl implements BaseCreditBuilder {

    @Override
    public BaseCredit buildBankCredit(String type,
                                      int id,
                                      int amountOfCredit,
                                      double percentage,
                                      int creditPeriod,
                                      String bankCreditor,
                                      String currencyOfCredit,
                                      String ensuringType,
                                      String description) {

        BaseCredit baseCredit = CreditFactory.getCreditFromFactory(type);

        if (baseCredit.getClass() == BankCredit.class) {
            BankCredit bankCredit = (BankCredit) baseCredit;
            bankCredit.setId(id);
            bankCredit.setAmountOfCredit(amountOfCredit);
            bankCredit.setPercentage(percentage);
            bankCredit.setCreditPeriod(creditPeriod);
            bankCredit.setBankCreditor(bankCreditor);
            bankCredit.setCurrencyOfCredit(currencyOfCredit);
            bankCredit.setEnsuringType(ensuringType);
            bankCredit.setDescription(description);

            baseCredit = bankCredit;
        }
        return baseCredit;
    }

    @Override
    public BaseCredit buildPurposeCredit(String type,
                                         int id,
                                         int amountOfCredit,
                                         double percentage,
                                         int creditPeriod,
                                         String bankCreditor,
                                         String currencyOfCredit,
                                         String ensuringType,
                                         String description,
                                         String purposeOfCredit) {

        BaseCredit baseCredit = CreditFactory.getCreditFromFactory(type);

        if (baseCredit.getClass() == PurposeCredit.class) {
            PurposeCredit purposeCredit = (PurposeCredit) baseCredit;
            purposeCredit.setId(id);
            purposeCredit.setAmountOfCredit(amountOfCredit);
            purposeCredit.setPercentage(percentage);
            purposeCredit.setCreditPeriod(creditPeriod);
            purposeCredit.setBankCreditor(bankCreditor);
            purposeCredit.setCurrencyOfCredit(currencyOfCredit);
            purposeCredit.setEnsuringType(ensuringType);
            purposeCredit.setDescription(description);
            purposeCredit.setPurposeOfCredit(purposeOfCredit);

            baseCredit = purposeCredit;
        }
        return baseCredit;
    }

    @Override
    public BaseCredit buildCreditLine(String type,
                                      int id,
                                      int amountOfCredit,
                                      double percentage,
                                      int creditPeriod,
                                      String bankCreditor,
                                      String currencyOfCredit,
                                      String ensuringType,
                                      String description,
                                      String purposeOfCredit,
                                      String typeOfCreditLine) {

        BaseCredit baseCredit = CreditFactory.getCreditFromFactory(type);

        if (baseCredit.getClass() == CreditLine.class) {
            CreditLine creditLine = (CreditLine) baseCredit;
            creditLine.setId(id);
            creditLine.setAmountOfCredit(amountOfCredit);
            creditLine.setPercentage(percentage);
            creditLine.setCreditPeriod(creditPeriod);
            creditLine.setBankCreditor(bankCreditor);
            creditLine.setCurrencyOfCredit(currencyOfCredit);
            creditLine.setEnsuringType(ensuringType);
            creditLine.setDescription(description);
            creditLine.setPurposeOfCredit(purposeOfCredit);
            creditLine.setTypeOfCreditLine(typeOfCreditLine);

            baseCredit = creditLine;
        }
        return baseCredit;
    }

    @Override
    public BaseCredit buildRepaymentCredit(String type,
                                           int id,
                                           int amountOfCredit,
                                           double percentage,
                                           int creditPeriod,
                                           String bankCreditor,
                                           String currencyOfCredit,
                                           String ensuringType,
                                           String description,
                                           String purposeOfCredit,
                                           String typeOfCreditLine,
                                           boolean advancedRepayment) {

        BaseCredit baseCredit = CreditFactory.getCreditFromFactory(type);

        if (baseCredit.getClass() == RepaymentCredit.class) {
            RepaymentCredit repaymentCredit = (RepaymentCredit) baseCredit;
            repaymentCredit.setId(id);
            repaymentCredit.setAmountOfCredit(amountOfCredit);
            repaymentCredit.setPercentage(percentage);
            repaymentCredit.setCreditPeriod(creditPeriod);
            repaymentCredit.setBankCreditor(bankCreditor);
            repaymentCredit.setCurrencyOfCredit(currencyOfCredit);
            repaymentCredit.setEnsuringType(ensuringType);
            repaymentCredit.setDescription(description);
            repaymentCredit.setPurposeOfCredit(purposeOfCredit);
            repaymentCredit.setTypeOfCreditLine(typeOfCreditLine);
            repaymentCredit.setTypeOfCreditLine(typeOfCreditLine);
            repaymentCredit.setAdvancedRepayment(advancedRepayment);

            baseCredit = repaymentCredit;
        }
        return baseCredit;
    }
}
