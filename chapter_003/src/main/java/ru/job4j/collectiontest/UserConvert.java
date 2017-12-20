package ru.job4j.collectiontest;

import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

class User {
    private int id;
    private String name;
    private String city;

    User(int id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }

    public int getId() {
        return this.id;
    }

    @Override
    public String toString() {
        return String.format("Id:%d, Name:%s, City:%s", this.id, this.name, this.city);
    }

}

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
            User u = new User(i, "Name_" + i * 10, "City_" + i * 100);
            userlist.add(u);
        }
        UserConvert uc = new UserConvert();
        Map usermap = uc.process(userlist);

        for (Object k: usermap.keySet()) {
            System.out.println(usermap.get(k));
        }
    }
}