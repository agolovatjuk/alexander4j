package ru.job4j.list;

import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

public class SimpleListTest {

    @Test
    public void whenAddThen() {
        SimpleList<Integer> lst = new SimpleList<>(3);
        for (int i = 0; i < 10; i++) {
            lst.add(i);
        }
        assertThat(lst.size(), is(10));

        lst = new SimpleList<>();
        for (int i = 0; i < 10; i++) {
            lst.add(i);
        }
        assertThat(lst.size(), is(10));
    }

    @Test
    public void whenGetThen() {
        SimpleList<String> lst = new SimpleList<>();
        for (int i = 0; i < 10; i++) {
            lst.add(String.format("String%s", i));
        }

        for (int i = 0; i < lst.size(); i++) {
            assertThat(lst.get(i), is(String.format("String%s", i)));
        }
    }

    @Test(expected = NoSuchElementException.class)
    public void whenIteratorThen() {
        SimpleList<Integer> lst = new SimpleList<>();

        for (int i = 0; i < 10; i++) {
            lst.add(i);
        }

        Iterator<Integer> it = lst.iterator();
        for (int i = 0; i < 10; i++) {
            assertThat(it.next(), is(i));
        }
        it.next(); // NoSuchElementException
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenIteratorModifiedThen() {
        SimpleList<String> lst = new SimpleList<>();
        lst.add("String1");
        lst.add("String2");
        Iterator<String> it = lst.iterator();
        assertThat(it.next(), is("String1"));
        lst.add("String3");
        it.next(); // ConcurrentModificationException
    }
}