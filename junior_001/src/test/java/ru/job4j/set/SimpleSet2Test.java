package ru.job4j.set;

import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

public class SimpleSet2Test {

    @Test
    public void add() {
        SimpleSet2<Integer> simpleset = new SimpleSet2<>();
        for (int i = 0; i < 10; i++) {
            simpleset.add(i);
        }
        for (int i = 0; i < 10; i++) {
            simpleset.add(i);
        }
        assertThat(simpleset.size(), is(10));
        assertThat(simpleset.contains(100), is(false));
        assertThat(simpleset.contains(null), is(false));
        for (int i = 0; i < 10; i++) {
            assertThat(simpleset.contains(i), is(true));
        }
        simpleset.add(null);
        assertThat(simpleset.contains(null), is(true));
    }

    @Test(expected = NoSuchElementException.class)
    public void iterator() {

        SimpleSet2<Integer> simpleset = new SimpleSet2<>();

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