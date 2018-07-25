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

    @Test
    public void whenMapUserWithHashCode() {
        Map<UserWithHashCode, String> usermap = new HashMap<>();
        UserWithHashCode first = new UserWithHashCode("Big Boss", 3, new int[] {1900, 01, 01});
        UserWithHashCode second = new UserWithHashCode("Big Boss", 3, new int[] {1900, 01, 01});
        usermap.put(first, "boss");
        usermap.put(second, "boss");
        System.out.println(usermap);
        assertThat(usermap.size(), is(2));
        assertThat(first.hashCode(), is(second.hashCode()));
    }

    @Test
    public void whenMapUserWithEquals() {
        Map<UserWithEquals, String> usermap = new HashMap<>();
        UserWithEquals first = new UserWithEquals("Mr Smith", 4, new int[] {1990, 11, 24});
        UserWithEquals second = new UserWithEquals("Mr Smith", 4, new int[] {1990, 11, 24});
        usermap.put(first, "citizen");
        usermap.put(second, "citizen");
        System.out.println(usermap);
        assertThat(usermap.size(), is(2));
        assertThat(first.equals(second), is(true));
    }

    @Test
    public void whenMapUserOK() {
        Map<UserOK, String> usermap = new HashMap<>();
        UserOK first = new UserOK("Robert", 1, new int[] {1900, 01, 22});
        UserOK second = new UserOK("Robert", 3, new int[] {2000, 05, 10});
        usermap.put(first, "User_first");
        usermap.put(second, "User_second");
        System.out.println(usermap);
        assertThat(usermap.size(), is(1));
    }
}