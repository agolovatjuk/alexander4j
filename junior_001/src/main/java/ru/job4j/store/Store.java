package ru.job4j.store;

import java.util.List;

public class Store {

    Info diff(List<User> previous, List<User> current) {
        return new Info(previous, current);
    }

    static class User {
        int id;
        String name;
    }
}
