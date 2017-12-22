package ru.job4j.sorting;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Set;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SortUserTest {

    @Test
    public void whenUserSetSort() {
        List<User> users = new ArrayList<>();
        users.addAll(Arrays.asList(
                new User("User1", 10), new User("User2", 5), new User("User3", 7)));
        Set<User> userset = new SortUser().sort(users);
        List<User> usr = new ArrayList<>();
        usr.addAll(userset);
        for (int i = 1; i < usr.size(); i++) {
            assertThat(usr.get(i - 1).compareTo(usr.get(i)), is(-1));
        }
    }
}
