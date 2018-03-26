package ru.job4j.generic;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import static org.hamcrest.Matchers.is;

public class RoleStoreTest {

    RoleStore rstore = new RoleStore(10);

    @Before
    public void setUp() {
        rstore.add(new Role("Manager001"));
        rstore.add(new Role("Manager002"));
        rstore.add(new Role("Manager003"));
    }

    @Test
    public void whenAddThen() {
        assertThat(rstore.findById("Manager001").getId(), is("Manager001"));
        assertThat(rstore.findById("Manager002").getId(), is("Manager002"));
        assertThat(rstore.findById("Manager003").getId(), is("Manager003"));
//        rstore.add(new User("User001"));
    }

    @Test
    public void whenReplaceThen() {
        rstore.replace("Manager001", new Role("Boss001"));
        assertThat(rstore.findById("Boss001").getId(), is("Boss001"));
        assertNull(rstore.findById("Manager001"));
//        rstore.replace("Manager001", new User("SuperUser"));
    }

    @Test
    public void whenDeleteThen() {
        assertTrue(rstore.delete("Manager003"));
        assertFalse(rstore.delete("SuperManager"));
    }
}