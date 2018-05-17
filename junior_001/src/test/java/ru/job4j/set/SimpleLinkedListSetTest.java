package ru.job4j.set;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

public class SimpleLinkedListSetTest {

    SimpleLinkedListSet<Integer> lst;

    @Before
    public void setUp() throws Exception {
        lst = new SimpleLinkedListSet<>();
    }

    @Test
    public void whenSizeThen() {
        assertThat(lst.isEmpty(), is(true));
        for (int i = 0; i < 10; i++) {
            lst.add(i);
            assertThat(lst.size(), is(i + 1));
        }
        assertThat(lst.isEmpty(), is(false));
    }

    @Test
    public void whenAddThen() {
        boolean result = false;

        for (int i = 0; i < 5; i++) {
            result = lst.add(i);
            assertThat(result, is(true));
        }
        assertThat(lst.size(), is(5));

        assertThat(lst.add(1), is(false));
        assertThat(lst.size(), is(5));

        assertThat(lst.add(10), is(true));
        assertThat(lst.size(), is(6));
    }

    @Test
    public void whenRemoveThen() {
        for (int i = 0; i < 5; i++) {
            lst.add(i);
        }
        assertThat(lst.remove(4), is(true));
        assertThat(lst.remove(55), is(false));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenIteratorThen() {
        for (int i = 0; i < 10; i++) {
            lst.add(i);
        }

        Iterator<Integer> it = lst.iterator();
        for (int i = 0; i < 10; i++) {
            assertThat(it.next().equals(i), is(true));
        }
        it.next();
    }
}