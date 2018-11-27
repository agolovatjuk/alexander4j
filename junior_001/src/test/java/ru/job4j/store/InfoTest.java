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
    public void setUp() {
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
        assertThat(info.report.get("Added"), is(0));
        assertThat(info.report.get("Changed"), is(0));
        assertThat(info.report.get("Deleted"), is(0));
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
        assertThat(info.report.get("Added"), is(4));
        assertThat(info.report.get("Changed"), is(0));
        assertThat(info.report.get("Deleted"), is(0));
    }

    @Test
    public void whenDelete2EntriesThen() {
        current.remove(4);
        current.remove(0);
        info = new Store().diff(previous, current);
        assertThat(info.report.get("Added"), is(0));
        assertThat(info.report.get("Changed"), is(0));
        assertThat(info.report.get("Deleted"), is(2));
    }

    @Test
    public void whenChange2EntriesThen() {
        current.get(2).name = "ChangeN 111";
        current.get(0).name = "ChangeN 222";
        info = new Store().diff(previous, current);
        assertThat(info.report.get("Added"), is(0));
        assertThat(info.report.get("Changed"), is(2));
        assertThat(info.report.get("Deleted"), is(0));
    }

    @Test
    public void whenInfoThen() {
        info = new Store().diff(previous, current);
        assertThat(info.report.get("Added"), is(0));
        assertThat(info.report.get("Changed"), is(0));
        assertThat(info.report.get("Deleted"), is(0));

        for (int i = 2; i <= 5; i++) { // added 4 Entries - 2, 3, 4, 5
            user = new Store.User();
            user.id = i * 100;
            user.name = "User_" + i * 100;
            current.add(user);
        }

        info = new Store().diff(previous, current);
        assertThat(info.report.get("Added"), is(4));
        assertThat(info.report.get("Changed"), is(0));
        assertThat(info.report.get("Deleted"), is(0));

        current.remove(1);
        current.remove(2);

        info = new Store().diff(previous, current);
        assertThat(info.report.get("Added"), is(4));
        assertThat(info.report.get("Changed"), is(0));
        assertThat(info.report.get("Deleted"), is(2));

        current.get(1).name = "Changed01 in current";
        current.get(2).name = "Changed02 in current";

        info = new Store().diff(previous, current);
        assertThat(info.report.get("Added"), is(4));
        assertThat(info.report.get("Changed"), is(2));
        assertThat(info.report.get("Deleted"), is(2));
    }
}