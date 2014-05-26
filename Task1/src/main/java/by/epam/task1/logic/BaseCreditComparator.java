package by.epam.task1.logic;

import by.epam.task1.entity.BaseCredit;

import java.util.Comparator;

/**
 * Created by Максим&Маша on 23.05.14.
 */
public class BaseCreditComparator implements Comparator<BaseCredit> {

    @Override
    public int compare(BaseCredit o1, BaseCredit o2) {
        double percentage1 = o1.getPercentage();
        double percentage2 = o2.getPercentage();

        if (percentage1 < percentage2) {
            return -1;
        } else if (percentage1 == percentage2) {
            return 0;
        } else {
            return 1;
        }
    }
}
