package by.epam.task1.loader;

import by.epam.task1.creator.BaseCreditBuilderImpl;
import by.epam.task1.entity.BaseCredit;
import by.epam.task1.logic.BaseCreditComparator;
import by.epam.task1.logic.CreditSearch;
import by.epam.task1.logic.CreditSearchImpl;
import by.epam.task1.logic.model.RequestCreditListModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Максим&Маша on 18.05.14.
 */
public class Loader {

    public static void main(String[] args) {
        BaseCreditBuilderImpl baseCreditBuilder = new BaseCreditBuilderImpl();
        BaseCredit baseCredit1 = baseCreditBuilder.buildBankCredit("BANK_CREDIT", 1, 4000, 6.4, 8, "AAA", "USD", "zalog", "Vygodnyj kredit");
        BaseCredit baseCredit2 = baseCreditBuilder.buildPurposeCredit("PURPOSE_CREDIT", 2, 3000, 7.1, 9, "BBB", "USD", "zalog", "10 000 USD", "Popolnienije oborotnych sredctv");
        BaseCredit baseCredit3 = baseCreditBuilder.buildCreditLine("CREDIT_LINE", 3, 2000, 5.5, 10, "CCC", "USD", "zalog", "20 000 USD", "Pokupka transporta", "Vozobnovliajemajz kreditnaja linija");
        BaseCredit baseCredit4 = baseCreditBuilder.buildRepaymentCredit("REPAYMENT_CREDIT", 4, 1000, 5.9, 14, "DDD", "USD", "zalog", "25 000 USD", "Pokupka transporta", "Vozobnovliajemajz kreditnaja linija", true);
        BaseCredit baseCredit5 = baseCreditBuilder.buildBankCredit("BANK_CREDIT", 5, 8000, 6.9, 15, "AAA", "USD", "zalog", "Vygodnyj kredit");
        BaseCredit baseCredit6 = baseCreditBuilder.buildPurposeCredit("PURPOSE_CREDIT", 6, 7000, 7.6, 16, "BBB", "USD", "zalog", "10 000 USD", "Popolnienije oborotnych sredctv");
        BaseCredit baseCredit7 = baseCreditBuilder.buildCreditLine("CREDIT_LINE", 7, 6000, 5.2, 17, "CCC", "USD", "zalog", "20 000 USD", "Pokupka transporta", "Vozobnovliajemajz kreditnaja linija");
        BaseCredit baseCredit8 = baseCreditBuilder.buildRepaymentCredit("REPAYMENT_CREDIT", 8, 5000, 5.8, 18, "DDD", "USD", "zalog", "25 000 USD", "Pokupka transporta", "Vozobnovliajemajz kreditnaja linija", true);

        List<BaseCredit> baseCredits = new ArrayList<BaseCredit>();
        baseCredits.add(baseCredit1);
        baseCredits.add(baseCredit2);
        baseCredits.add(baseCredit3);
        baseCredits.add(baseCredit4);
        baseCredits.add(baseCredit5);
        baseCredits.add(baseCredit6);
        baseCredits.add(baseCredit7);
        baseCredits.add(baseCredit8);
        for (BaseCredit baseCredit : baseCredits) {
            System.out.println(baseCredit);
        }

        System.out.println("Credit List-------------------");
        CreditSearch creditSearch = new CreditSearchImpl();

        RequestCreditListModel requestCreditListModel = new RequestCreditListModel();
        requestCreditListModel.setAmountOfCredit(3000);
        requestCreditListModel.setCreditPeriod(10);
        List<BaseCredit> baseCreditList = creditSearch.getCreditList(baseCredits, requestCreditListModel);
        for (BaseCredit baseCredit : baseCreditList) {
            System.out.println(baseCredit);
        }

        System.out.println("Sorted Credit List-------------------");
        Collections.sort(baseCreditList);
        for (BaseCredit baseCredit : baseCreditList) {
            System.out.println(baseCredit);
        }

        System.out.println("Sorted Credit List By Comparator-------------------");
        Comparator<BaseCredit> baseCreditComparator = new BaseCreditComparator();
        Collections.sort(baseCreditList, baseCreditComparator);
        for (BaseCredit baseCredit : baseCreditList) {
            System.out.println(baseCredit);
        }

        System.out.println("Get Credit by ID-----------------");
        BaseCredit baseCredit = creditSearch.getCreditById(baseCredits, 5);
        System.out.println(baseCredit);

    }
}
