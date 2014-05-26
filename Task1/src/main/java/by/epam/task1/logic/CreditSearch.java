package by.epam.task1.logic;

import by.epam.task1.entity.BaseCredit;
import by.epam.task1.logic.model.RequestCreditListModel;

import java.util.List;

/**
 * Created by Максим&Маша on 18.05.14.
 */
public interface CreditSearch {

    List<BaseCredit> getCreditList(List<BaseCredit> baseCredits, RequestCreditListModel requestCreditListModel);

    BaseCredit getCreditById(List<BaseCredit> baseCredits, int id);

}
