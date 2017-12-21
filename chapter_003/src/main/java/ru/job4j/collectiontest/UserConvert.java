package ru.job4j.collectiontest;

import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

class UserConvert {
    public Map<Integer, User> process(List<User> list) {
        Map<Integer, User> data = new HashMap<>();
        for (User u: list) {
            data.put(u.getId(), u);
        }
        return data;
    }

    public static void main(String[] args) {
        List<User> userlist = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            userlist.add(new User(i, String.format("Name_%d", i * 10), String.format("City_%d", i * 100)));
        }
        UserConvert uc = new UserConvert();
        Map usermap = uc.process(userlist);

        for (Object k: usermap.keySet()) {
            System.out.println(usermap.get(k));
        }
    }
}