package ru.job4j.list;

import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

public class SimpleLinkedListTest {

    @Test
    public void whenAddWithGetThen() {
        SimpleLinkedList<String> lst = new SimpleLinkedList<>();
        for (int i = 0; i < 20; i++) {
            lst.add(String.format("%s", i));
        }
        assertThat(lst.size(), is(20));
        assertThat(lst.get(5), is("5"));
        assertThat(lst.get(4), is("4"));
        assertThat(lst.get(15), is("15"));
        assertThat(lst.get(19), is("19"));
        assertThat(lst.indexOf("19"), is(19));
        assertThat(lst.indexOf(100), is(-1));
        assertThat(lst.contains(1), is(false));
        assertThat(lst.contains(null), is(false));
        lst.add(null);
        assertThat(lst.contains(null), is(true));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenIteratorThen() {
        SimpleLinkedList<Integer> lst = new SimpleLinkedList<>();

        for (int i = 0; i < 20; i++) {
            lst.add(i);
        }

        Iterator<Integer> it = lst.iterator();

        for (int i = 0; i < 20; i++) {
            assertThat(it.next(), is(i));
        }
        it.next(); // NoSuchElementException
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenIteratorModifyiedThen() {
        SimpleLinkedList<Integer> lst = new SimpleLinkedList<>();

        for (int i = 0; i < 20; i++) {
            lst.add(i);
        }

        Iterator<Integer> it = lst.iterator();
        assertThat(it.next(), is(0));
        lst.add(100);
        it.next(); // ConcurrentModificationException
    }

    @Test
    public void whenAddLastThen() {
        // FIFO
        SimpleLinkedList<Integer> lst = new SimpleLinkedList<>();
        for (int i = 0; i < 10; i++) {
            assertThat(lst.size(), is(i));
            lst.addLast(i);
        }
        for (int i = 0; i < 10; i++) {
            assertThat(lst.get(i), is(i));
        }
        assertThat(lst.size(), is(10));
    }

    @Test
    public void whenAddFirstThen() {
        //LIFO
        SimpleLinkedList<Integer> lst = new SimpleLinkedList<>();
        for (int i = 0; i < 10; i++) {
            assertThat(lst.size(), is(i));
            lst.addFirst(i);
        }
        for (int i = 0; i < 10; i++) {
            assertThat(lst.get(9 - i), is(i));
        }
        assertThat(lst.size(), is(10));
    }

    @Test
    public void whenRemoveFirstThen() {
        SimpleLinkedList<Integer> lst = new SimpleLinkedList<>();
        for (int i = 0; i < 10; i++) {
            assertThat(lst.size(), is(i));
            lst.addLast(i);
        }
        for (int i = 0; i < 10; i++) {
            assertThat(lst.removeFirst(), is(i));
        }
        assertThat(lst.size(), is(0));
    }

    @Test
    public void whenRemoveLastThen() {
        SimpleLinkedList<Integer> lst = new SimpleLinkedList<>();
        for (int i = 0; i < 10; i++) {
            assertThat(lst.size(), is(i));
            lst.addFirst(i);
        }
        for (int i = 0; i < 10; i++) {
            assertThat(lst.removeLast(), is(i));
        }
        assertThat(lst.size(), is(0));
    }

    @Test
    public void remove() {
        SimpleLinkedList<Integer> lst = new SimpleLinkedList<>();
        for (int i = 0; i < 10; i++) {
            assertThat(lst.size(), is(i));
            lst.add(i);
        }
        assertThat(lst.remove(0), is(true));
        assertThat(lst.remove(0), is(false));
        for (int i = 0; i < 9; i++) {
            assertThat(lst.get(i), is(i + 1));
        }
    }
}