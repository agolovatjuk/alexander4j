package ru.job4j.store;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

class Info {

    HashMap<String, Integer> info = new HashMap<>();
    Map<Integer, String> prev, curr;

    protected Info(List<Store.User> previous, List<Store.User> current) {
        info.put("Added", 0);
        info.put("Changed", 0);
        info.put("Deleted", 0);
        prev = new HashMap<>();
        curr = new HashMap<>();
        // TODO lambda how to
        for (Store.User user: current) {
            curr.put(user.id, user.name);
        }
        for (Store.User user: previous) {
            prev.put(user.id, user.name);
        }
        calculateDifference();
    }

    private void calculateDifference() {
        Set<Integer> prvKeys = new TreeSet<>(prev.keySet());
        Set<Integer> curKeys = new TreeSet<>(curr.keySet());
        Set<Integer> addedKeys;
        // added Entries
        if (curKeys.removeAll(prvKeys)) {
            info.put("Added", curKeys.size());
            addedKeys = new TreeSet<>(curKeys);
        } else {
            throw new RuntimeException("Error to calculate Added Entries");
        }
        // deleted Entries
        curKeys = new TreeSet<>(curr.keySet());
        if (prvKeys.removeAll(curKeys)) {
            info.put("Deleted", prvKeys.size());
        } else {
            throw new RuntimeException("Error to calculate Deleted Entries");
        }
        // changed Entries
        curKeys.removeAll(addedKeys);
        int cntChanged = 0;
        for (Integer key: curKeys) {
            if (!prev.get(key).equals(curr.get(key))) {
                cntChanged++;
            }
        }
        info.put("Changed", cntChanged);
    }
}
