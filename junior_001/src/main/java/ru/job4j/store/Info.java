package ru.job4j.store;

import java.util.HashMap;
import java.util.List;
import java.util.HashSet;

class Info {

    HashMap<Integer, String> prev, curr;
    HashMap<String, Integer> report;

    protected Info(List<Store.User> previous, List<Store.User> current) {
        prev = new HashMap<>();
        curr = new HashMap<>();
        report = new HashMap<>();
        // TODO lambda how to
        for (Store.User user : current) {
            curr.put(user.id, user.name);
        }
        for (Store.User user : previous) {
            prev.put(user.id, user.name);
        }
        calculateDifference();
    }

    private void calculateDifference() {
        int cntAdded = 0;
        int cntEdited = 0;
        int cntDeleted = 0;
        HashSet<Integer> totalKeys = new HashSet<>();

        totalKeys.addAll(prev.keySet());
        totalKeys.addAll(curr.keySet());

        for (Integer key : totalKeys) {
            if (prev.containsKey(key) & curr.containsKey(key)) {
                if (!prev.get(key).equals(curr.get(key))) {
                    cntEdited++;
                }
            } else if (prev.containsKey(key) & !curr.containsKey(key)) {
                cntDeleted++;
            } else if (!prev.containsKey(key) & curr.containsKey(key)) {
                cntAdded++;
            }
        }
        report.put("Added", cntAdded);
        report.put("Changed", cntEdited);
        report.put("Deleted", cntDeleted);
    }
}
