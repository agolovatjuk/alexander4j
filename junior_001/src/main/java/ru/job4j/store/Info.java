package ru.job4j.store;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Info {
    private Map<String, Integer> report = new HashMap<>();

    public Info(List<Store.User> previous, List<Store.User> current) {
        int add = 0;
        int edit = 0;
        Map<Integer, String> mapPrevious = new HashMap<>();

        previous.forEach(x -> mapPrevious.put(x.id, x.name));

        for (Store.User user : current) {
            if (mapPrevious.containsKey(user.id)) {
                if (!user.name.equals(mapPrevious.get(user.id))) {
                    edit++;
                }
                mapPrevious.remove(user.id);
            } else {
                add++;
            }
        }
        report.put("Added", add);
        report.put("Changed", edit);
        report.put("Deleted", mapPrevious.size());
    }

    public Map<String, Integer> getReport() {
        return report;
    }
}
