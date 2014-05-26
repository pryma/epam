package by.epam.task1.logic;

import by.epam.task1.entity.BankCredit;
import by.epam.task1.entity.BaseCredit;
import by.epam.task1.logic.model.RequestCreditListModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Максим&Маша on 20.05.14.
 */
public class CreditSearchImpl implements CreditSearch {

    @Override
    public List<BaseCredit> getCreditList(List<BaseCredit> baseCredits, RequestCreditListModel requestCreditListModel) {

        List<BaseCredit> creditList = new ArrayList<BaseCredit>();

        if (baseCredits != null && requestCreditListModel != null) {

            for (BaseCredit baseCredit : baseCredits) {

                if (requestCreditListModel.getAmountOfCredit() <= baseCredit.getAmountOfCredit()
                    && requestCreditListModel.getCreditPeriod() <= baseCredit.getCreditPeriod()) {

                    creditList.add(baseCredit);
                }
            }
        }

        return creditList;
    }

    @Override
    public BaseCredit getCreditById(List<BaseCredit> baseCredits, int id) {
        if (baseCredits != null) {
            for (BaseCredit baseCredit : baseCredits) {
                if (baseCredit.getId() == id) {
                    return baseCredit;
                }
            }
        }
        return null;
    }
}
