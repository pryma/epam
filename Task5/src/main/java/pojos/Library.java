package pojos;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Library {
    private Map<Class, List> libraryMap = new HashMap<Class, List>();
    private Statistic statistic = new Statistic();

    public Map<Class, List> getLibraryMap() {
        return libraryMap;
    }

    public void setLibraryMap(Map<Class, List> libraryMap) {
        this.libraryMap = libraryMap;
    }

    public Statistic getStatistic() {
        return statistic;
    }

    public void setStatistic(Statistic statistic) {
        this.statistic = statistic;
    }


}
