package ru.job4j.sorting;

import org.junit.Test;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.Random;

import static java.lang.String.format;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SortUserTest {

    @Test
    public void whenUserSetSort() {
        List<User> users = new ArrayList<>();
        Random rnd = new Random();
        for (int i = 0; i < 10; i++) {
            int x = rnd.nextInt(100);
            users.add(new User(format("Name_%d", x), x));
        }
        Set<User> userset = new SortUser().sort(users);
        List<User> usr = new ArrayList<>(userset);
        for (int i = 1; i < usr.size(); i++) {
            assertThat(usr.get(i - 1).compareTo(usr.get(i)), is(-1));
        }
        System.out.println(usr);
    }
}
