package ru.job4j.generic;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;

import static org.hamcrest.Matchers.is;

public class UserStoreTest {

    UserStore<User> ustore = new UserStore<>(10);

    @Before
    public void setUp() {
        ustore.add(new User("User001"));
        ustore.add(new User("User002"));
        ustore.add(new User("User003"));
//        ustore.add(new Role("Manager"));
    }

    @Test
    public void add() {
        assertThat(ustore.findById("User001").getId(), is("User001"));
        assertThat(ustore.findById("User002").getId(), is("User002"));
        assertThat(ustore.findById("User003").getId(), is("User003"));
    }

    @Test
    public void replace() {
        assertTrue(ustore.replace("User001", new User("SuperUser")));
        assertThat(ustore.findById("SuperUser").getId(), is("SuperUser"));
        assertFalse(ustore.replace("NullUser", new User("Boss")));
        assertNull(ustore.findById("User001"));
//        ustore.replace("Manager001", new Role("SuperUser"));
    }

    @Test
    public void delete() {
        assertTrue(ustore.delete("User003"));
        assertFalse(ustore.delete("SuperUser"));
    }
}