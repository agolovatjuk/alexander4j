package ru.job4j.store;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

class Info {

    Map<Integer, String> prevMap, currMap;
    Map<String, Integer> report;

    protected Info(List<Store.User> previous, List<Store.User> current) {
        prevMap = new HashMap<>();
        currMap = new HashMap<>();
        report = new HashMap<>();

        current.forEach(x -> currMap.put(x.id, x.name));
        previous.forEach(x -> prevMap.put(x.id, x.name));

        calculateDifference();
    }

    private void calculateDifference() {
        int cntAdded = 0;
        int cntEdited = 0;
        int cntDeleted = 0;
        HashSet<Integer> totalKeys = new HashSet<>();

        totalKeys.addAll(prevMap.keySet());
        totalKeys.addAll(currMap.keySet());

        for (Integer key : totalKeys) {
            if (prevMap.containsKey(key) & currMap.containsKey(key)) {
                if (!prevMap.get(key).equals(currMap.get(key))) {
                    cntEdited++;
                }
            } else if (prevMap.containsKey(key) & !currMap.containsKey(key)) {
                cntDeleted++;
            } else if (!prevMap.containsKey(key) & currMap.containsKey(key)) {
                cntAdded++;
            }
        }
        report.put("Added", cntAdded);
        report.put("Changed", cntEdited);
        report.put("Deleted", cntDeleted);
    }
}
