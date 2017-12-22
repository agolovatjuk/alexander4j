package ru.job4j.sorting;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.Arrays;

public class SortUser {
    public Set<User> sort(List<User> users) {
        Set<User> userset = new TreeSet<>();
        userset.addAll(users);
        return userset;
    }

    public static void main(String[] args) {

        List<User> users = new ArrayList<>();
        users.addAll(Arrays.asList(
                new User("User1", 10), new User("User2", 5), new User("User3", 7)));
        System.out.println(users);
        Set<User> userset = new SortUser().sort(users);
        System.out.println(userset);
    }
}
