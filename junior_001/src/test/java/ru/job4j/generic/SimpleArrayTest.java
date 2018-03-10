package ru.job4j.generic;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class SimpleArrayTest {

    SimpleArray<Integer> intArr;
    SimpleArray<String> strArr;

    @Before
    public void setUp() throws Exception {
        intArr = new SimpleArray<>(10);
        for (int i = 0; i < 10; i++) {
            intArr.add(i);
        }
        strArr = new SimpleArray<>(10);
        String[] s = new String[]{"A", "B", "C", "D", "E", "F", "G", "H"};
        for (String a: s) {
            strArr.add(a);
        }
    }

    @Test
    public void whenAddThen() {
        assertThat(intArr.toString(), is("SimpleArray{objects=[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]}"));
        assertThat(strArr.toString(), is("SimpleArray{objects=[A, B, C, D, E, F, G, H, null, null]}"));
    }

    @Test
    public void whenSetThen() {
        intArr.set(1, 99);
        strArr.set(3, "X");
        assertThat(intArr.toString(), is("SimpleArray{objects=[0, 99, 2, 3, 4, 5, 6, 7, 8, 9]}"));
        assertThat(strArr.toString(), is("SimpleArray{objects=[A, B, C, X, E, F, G, H, null, null]}"));
    }

    @Test
    public void whenDeleteThen() {
        intArr.delete(5);
        strArr.delete(2);
        assertThat(intArr.toString(), is("SimpleArray{objects=[0, 1, 2, 3, 4, 6, 7, 8, 9, null]}"));
        assertThat(strArr.toString(), is("SimpleArray{objects=[A, B, D, E, F, G, H, null, null, null]}"));
    }

    @Test
    public void get() {
        assertThat(intArr.get(5), is(5));
        assertThat(strArr.get(4), is("E"));
    }

    @Test(expected = NoSuchElementException.class)
    public void iterator() {
        Iterator<String> itStr = strArr.iterator();
        Iterator<Integer> itInt = intArr.iterator();
        assertThat(itStr.hasNext(), is(true));
        assertThat(itStr.hasNext(), is(true));
        assertThat(itInt.hasNext(), is(true));
        assertThat(itStr.next(), is("A"));
        assertThat(itStr.next(), is("B"));
        assertThat(itStr.next(), is("C"));
        assertThat(itStr.next(), is("D"));
        assertThat(itStr.next(), is("E"));
        assertThat(itStr.next(), is("F"));
        assertThat(itStr.next(), is("G"));
        assertThat(itStr.next(), is("H"));
        assertThat(itStr.hasNext(), is(false));
        itStr.next();
    }
}