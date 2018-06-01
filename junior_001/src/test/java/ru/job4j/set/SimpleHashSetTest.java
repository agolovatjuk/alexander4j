package ru.job4j.set;

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

public class SimpleHashSetTest {

    @Test
    public void whenAddThen() {
        SimpleHashSet<Integer> dataset = new SimpleHashSet<>();
        for (int i = 0; i < 10; i++) {
            assertThat(dataset.size(), is(i));
            dataset.add(i);
            assertThat(dataset.contains(i), is(true));
        }
    }

    @Test
    public void whenContainsThen() {
        SimpleHashSet<String> dataset = new SimpleHashSet<>();
        dataset.add("hello_1");
        assertThat(dataset.contains("hello_1"), is(true));
        assertThat(dataset.contains("hello_2"), is(false));
        dataset.add("hello_2");
        assertThat(dataset.contains("hello_2"), is(true));
        dataset.remove("hello_1");
        assertThat(dataset.contains("hello_1"), is(false));
    }

    @Test
    public void whenRemoveThen() {
        SimpleHashSet<Integer> dataset = new SimpleHashSet<>();
        for (int i = 0; i < 10; i++) {
            dataset.add(i);
        }
        assertThat(dataset.size(), is(10));
        dataset.remove(120); // bad item
        assertThat(dataset.size(), is(10));
        for (int i = 0; i < 5; i++) {
            dataset.remove(i);
            assertThat(dataset.contains(i), is(false));
        }
        assertThat(dataset.size(), is(5));
    }

    @Test
    public void whenSizeThen() {
        SimpleHashSet<Integer> dataset = new SimpleHashSet<>(3);

        for (int i = 0; i < 10; i++) {
            dataset.add(i);
        }
        assertThat(dataset.size(), is(10));
        dataset.remove(5);
        assertThat(dataset.size(), is(9));
        dataset.remove(5);
        assertThat(dataset.size(), is(9));
        dataset.remove(4);
        assertThat(dataset.size(), is(8));
        dataset.add(100);
        assertThat(dataset.size(), is(9));
    }
}