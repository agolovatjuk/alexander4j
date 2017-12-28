package ru.job4j.sorting;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.Random;
import java.util.Collections;

import static java.lang.String.format;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SortUserTest {

    @Test
    public void whenUserSetSortThen() {
        List<User> users = new ArrayList<>();
        Random rnd = new Random();
        for (int i = 0; i < 10; i++) {
            users.add(new User(format("Name_%d", rnd.nextInt(100)), rnd.nextInt(100)));
        }
        Set<User> userset = new SortUser().sort(users);
        List<User> usr = new ArrayList<>(userset);
        for (int i = 1; i < usr.size(); i++) {
            assertThat(usr.get(i - 1).compareTo(usr.get(i)), is(-1));
        }
//        System.out.println(usr);
    }

    @Test
    public void whenSortByAllFieldsThen() {
        List<User> users = new ArrayList<>();
        Random rnd = new Random();
        for (int i = 0; i < 5; i++) {
            String name = format("Name_%d", rnd.nextInt(1000));
            User u1 = new User(name, rnd.nextInt(100));
            User u2 = new User(name, rnd.nextInt(100));
            users.add(u1);
            users.add(u2);
        }
        Collections.shuffle(users);
//        System.out.println(users);
        List<User> usr = new SortUser().sortByAllFields(users);
//        System.out.println(usr);
        Comparator<User> cmp = new SortUser().getSortByAllFieldCmp;
        for (int i = 1; i < users.size(); i++) {
            assertThat(cmp.compare(usr.get(i - 1), usr.get(i)) <= 0, is(true));
        }
    }

    @Test
    public void whenSortNameLengthThen() {
        List<User> users = new ArrayList<>();
        Random rnd = new Random();
        for (int i = 0; i < 5; i++) {
            users.add(new User(format("Name_%d", rnd.nextInt(1000)), rnd.nextInt(100)));
            users.add(new User(format("Name_%d", rnd.nextInt(100)), rnd.nextInt(100)));
            users.add(new User(format("Name_%d", rnd.nextInt(10)), rnd.nextInt(100)));
        }
        Collections.shuffle(users);
//        System.out.println(users);
        List<User> usr = new SortUser().sortNameLength(users);
//        System.out.println(usr);
        for (int i = 1; i < usr.size(); i++) {
            assertThat(usr.get(i - 1).getName().length() <= usr.get(i).getName().length(), is(true));
        }
    }
}
