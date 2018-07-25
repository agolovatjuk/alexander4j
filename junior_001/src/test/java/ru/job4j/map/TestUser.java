package ru.job4j.map;

import org.junit.Test;
import java.text.SimpleDateFormat;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class TestUser {
    @Test
    public void whenNewUserThen() {
        User user = new User("First User", 2, new int[] {1900, 10, 20});
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        assertThat(user.name, is("First User"));
        assertThat(user.children, is(2));
        assertThat(sdf.format(user.birthday.getTime()), is("1900/10/20"));
    }
}
