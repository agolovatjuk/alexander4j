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

        result = lst.add(1);
        assertThat(result, is(false));
        assertThat(lst.size(), is(5));

        result = lst.add(10);
        assertThat(result, is(true));
        assertThat(lst.size(), is(6));

        assertThat(lst.contains(10), is(true));
        assertThat(lst.contains(50), is(false));

    }

    @Test
    public void whenRemoveThen() {
        for (int i = 0; i < 5; i++) {
            lst.add(i);
        }
        boolean result = lst.remove(4);
        assertThat(result, is(true));
        for (int i = 0; i < 4; i++) {
            assertThat(lst.contains(i), is(true));
        }

        result = lst.remove(55);
        assertThat(result, is(false));
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