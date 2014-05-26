package by.epam.task1.creator;

import by.epam.task1.entity.BaseCredit;

/**
 * Created by Максим&Маша on 18.05.14.
 */
public interface BaseCreditBuilder {

    BaseCredit buildBankCredit(String type,
                               int id,
                               int amountOfCredit,
                               double percentage,
                               int creditPeriod,
                               String bankCreditor,
                               String currencyOfCredit,
                               String ensuringType,
                               String description);

    BaseCredit buildPurposeCredit(String type,
                                  int id,
                                  int amountOfCredit,
                                  double percentage,
                                  int creditPeriod,
                                  String bankCreditor,
                                  String currencyOfCredit,
                                  String ensuringType,
                                  String description,
                                  String purposeOfCredit);

    BaseCredit buildCreditLine(String type,
                               int id,
                               int amountOfCredit,
                               double percentage,
                               int creditPeriod,
                               String bankCreditor,
                               String currencyOfCredit,
                               String ensuringType,
                               String description,
                               String purposeOfCredit,
                               String typeOfCreditLine);

    BaseCredit buildRepaymentCredit(String type,
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
                                    boolean advancedRepayment);

}
