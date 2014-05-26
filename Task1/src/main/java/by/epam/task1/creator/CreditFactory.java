package by.epam.task1.creator;

import by.epam.task1.entity.BaseCredit;
import by.epam.task1.entity.CreditLine;
import by.epam.task1.entity.BankCredit;
import by.epam.task1.entity.PurposeCredit;
import by.epam.task1.entity.RepaymentCredit;

/**
 * Created by Максим&Маша on 18.05.14.
 */
public class CreditFactory {
    private enum CreditEnum {BANK_CREDIT, PURPOSE_CREDIT, CREDIT_LINE, REPAYMENT_CREDIT}

    public static BaseCredit getCreditFromFactory(String id) {
        CreditEnum creditEnum = CreditEnum.valueOf(id.toUpperCase());
        switch (creditEnum) {
            case BANK_CREDIT: return new BankCredit();
            case PURPOSE_CREDIT: return new PurposeCredit();
            case CREDIT_LINE: return new CreditLine();
            case REPAYMENT_CREDIT: return new RepaymentCredit();

            default:
                throw new EnumConstantNotPresentException(CreditEnum.class, creditEnum.name());
        }
    }
}
