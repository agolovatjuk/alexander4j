package ru.job4j.store;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

public class InfoTest {
    Store.User user;
    List<Store.User> previous = new ArrayList<>();
    List<Store.User> current = new ArrayList<>();
    Info info;

    @Before
    public void setUp() throws Exception {
        for (int i = 0; i < 5; i++) {
            user = new Store.User();
            user.id = i;
            user.name = "User_" + i;
            previous.add(user);

            user = new Store.User();
            user.id = i;
            user.name = "User_" + i;
            current.add(user);
        }
    }

    @Test
    public void whenPreviousEqualCurrentThen() {
        // see setUp()
        info = new Store().diff(previous, current);
        assertThat(info.info.get("Added"), is(0));
        assertThat(info.info.get("Changed"), is(0));
        assertThat(info.info.get("Deleted"), is(0));
    }

    @Test
    public void whenAdd4NewEntriesThen() {
        for (int i = 1; i <= 4; i++) {
            user = new Store.User();
            user.id = i * 100;
            user.name = "User_" + i * 100;
            current.add(user);
        }
        info = new Store().diff(previous, current);
        assertThat(info.info.get("Added"), is(4));
        assertThat(info.info.get("Changed"), is(0));
        assertThat(info.info.get("Deleted"), is(0));
    }

    @Test
    public void whenDelete2EntriesThen() {
        current.remove(4);
        current.remove(0);
        info = new Store().diff(previous, current);
        assertThat(info.info.get("Added"), is(0));
        assertThat(info.info.get("Changed"), is(0));
        assertThat(info.info.get("Deleted"), is(2));
    }

    @Test
    public void whenChange2EntriesThen() {
        current.get(2).name = "ChangeN 111";
        current.get(0).name = "ChangeN 222";
        info = new Store().diff(previous, current);
        assertThat(info.info.get("Added"), is(0));
        assertThat(info.info.get("Changed"), is(2));
        assertThat(info.info.get("Deleted"), is(0));
    }

    @Test
    public void whenInfoThen() {
        for (int i = 0; i <= 4; i++) {
            user = new Store.User();
            user.id = i * 100;
            user.name = "User_" + i * 100;
            current.add(user);
        }

        for (int i = 1; i <= 2; i++) {
            current.remove(i);
        }

        info = new Store().diff(previous, current);
        assertThat(info.info.get("Added"), is(4));
        assertThat(info.info.get("Changed"), is(0));
        assertThat(info.info.get("Deleted"), is(2));

        current.get(1).name = "Changed01 in current";
        current.get(2).name = "Changed02 in current";

        info = new Store().diff(previous, current);
        assertThat(info.info.get("Added"), is(4));
        assertThat(info.info.get("Changed"), is(2));
        assertThat(info.info.get("Deleted"), is(2));
    }

    @Test(expected = RuntimeException.class)
    public void whenNullEntriesThen() {
        List<Store.User> prv = new ArrayList<>();
        List<Store.User> cur = new ArrayList<>();
        info = new Store().diff(previous, cur);
        info = new Store().diff(prv, current);
    }

}