package ru.job4j.sorting;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.Arrays;
import java.util.Comparator;

public class SortUser {
    public Set<User> sort(List<User> users) {
        return new TreeSet<>(users);
    }

    public Comparator<User> getSortByAllFieldCmp = new CmpSortByAllFields();

    class CmpSortByAllFields implements Comparator<User> {
        public int compare(User o1, User o2) {
            int r = o1.getName().compareTo(o2.getName());
            return r != 0 ? r : o1.compareTo(o2);
        }
    }

    public List<User> sortByAllFields(List<User> users) {
        users.sort(new CmpSortByAllFields());
        return users;
    }

    public List<User> sortNameLength(List<User> users) {
        users.sort(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return Integer.compare(o1.getName().length(), o2.getName().length());
            }
        });
        return users;
    }

    public static void main(String[] args) {
        List<User> users = new ArrayList<>(Arrays.asList(
                new User("User1", 10), new User("User2", 5), new User("User3", 7)));
        System.out.println(users);
        System.out.println(new SortUser().sort(users));
    }
}
