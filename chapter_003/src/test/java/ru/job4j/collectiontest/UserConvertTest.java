package ru.job4j.collectiontest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class UserConvertTest {

    @Test
    public void whenUserToMap() {
        List<User> userlist = new ArrayList<>();
        Map<Integer, User> expected = new HashMap<>();

        for (int i = 0; i < 10; i++) {
            User u = new User(i, String.format("Name_%d", i * 10), String.format("City_%d", i * 100));
            userlist.add(u);
            expected.put(u.getId(), u);
        }

        UserConvert uc = new UserConvert();
        Map usermap = uc.process(userlist);

        assertThat(usermap, is(expected));
    }
}
