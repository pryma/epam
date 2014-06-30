package pojos;

import java.util.HashMap;
import java.util.Map;

public class Statistic {
    private Map<String, Long> statisticMap = new HashMap<String, Long>();
    private Map<Class, Map<String, Long>> statisticMapMap = new HashMap<Class, Map<String, Long>>();

    public Statistic() {
    }

    public Map<String, Long> getStatisticMap() {
        return statisticMap;
    }

    public void setStatisticMap(Map<String, Long> statisticMap) {
        this.statisticMap = statisticMap;
    }

    public Map<Class, Map<String, Long>> getStatisticMapMap() {
        return statisticMapMap;
    }

    public void setStatisticMapMap(Map<Class, Map<String, Long>> statisticMapMap) {
        this.statisticMapMap = statisticMapMap;
    }
}
