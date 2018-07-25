package ru.job4j.map;

import org.junit.Test;

import java.util.Map;
import java.util.HashMap;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

public class UserMapTest {

    @Test
    public void whenPutTwoSimpleUsersThen() {
        Map<User, String> usermap = new HashMap<>();
        User first  = new User("First User", 2, new int[] {1980, 10, 20});
        User second = new User("First User", 2, new int[] {1980, 10, 20});
        usermap.put(first,  "first");
        usermap.put(second, "second");
        System.out.println(usermap);
        assertThat(usermap.size(), is(2));
    }
}