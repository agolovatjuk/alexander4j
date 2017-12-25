package ru.job4j.sorting;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.Arrays;

public class SortUser {
    public Set<User> sort(List<User> users) {
        return new TreeSet<>(users);
    }

    public static void main(String[] args) {
        List<User> users = new ArrayList<>(Arrays.asList(
                new User("User1", 10), new User("User2", 5), new User("User3", 7)));
        System.out.println(users);
        System.out.println(new SortUser().sort(users));
    }
}
