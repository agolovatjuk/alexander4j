package ru.job4j.set;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

public class SimpleSetTest {

    SimpleSet<Integer> simpleset;

    @Before
    public void setUp() throws Exception {
        simpleset = new SimpleSet<>();
    }

    @Test
    public void add() {

        simpleset = new SimpleSet<>(10);

        boolean result = false;

        for (int i = 0; i < 5; i++) {
            result = simpleset.add(i);
            assertThat(result, is(true));
        }
        assertThat(simpleset.size(), is(5));

        result = simpleset.add(1);
        assertThat(result, is(false));
        assertThat(simpleset.size(), is(5));

        result = simpleset.add(10);
        assertThat(result, is(true));
        assertThat(simpleset.size(), is(6));

        assertThat(simpleset.contains(10), is(true));
        assertThat(simpleset.contains(50), is(false));
    }

    @Test
    public void size() {
        assertThat(simpleset.size(), is(0));
        assertThat(simpleset.isEmpty(), is(true));

        simpleset.add(1);
        assertThat(simpleset.size(), is(1));
        assertThat(simpleset.isEmpty(), is(false));
    }

    @Test
    public void remove() {
        for (int i = 0; i < 6; i++) {
            simpleset.add(i);
        }
        boolean result = simpleset.remove(4);
        assertThat(result, is(true));
        for (int i = 0; i < 4; i++) {
            assertThat(simpleset.contains(i), is(true));
        }

        result = simpleset.remove(55);
        assertThat(result, is(false));
    }

    @Test(expected = NoSuchElementException.class)
    public void iterator() {
        for (int i = 0; i < 10; i++) {
            simpleset.add(i);
        }

        Iterator<Integer> it = simpleset.iterator();
        for (int i = 0; i < 10; i++) {
            assertThat(it.next().equals(i), is(true));
        }
        it.next();
    }
}