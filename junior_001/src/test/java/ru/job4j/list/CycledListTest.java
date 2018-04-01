package ru.job4j.list;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

public class CycledListTest {
    Node n1;
    Node n2;
    Node n3;
    Node n4;
    Node n5;
    Node n6;

    @Before
    public void setUp() throws Exception {
        n1 = new Node(1, null);
        n2 = new Node(2, null);
        n3 = new Node(3, null);
        n4 = new Node(4, null);
        n5 = new Node(5, null);
        n6 = new Node("Test", null);
    }


    @Test
    public void whetHasMiddleCycledThen() {

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n2;
        n5.next = n6;
        n6.next = n6;

        assertThat(new CycledList().hasCycled(n1), is(true));
        assertThat(new CycledList().hasCycled(n2), is(true));
        assertThat(new CycledList().hasCycled(n3), is(true));
        assertThat(new CycledList().hasCycled(n4), is(true));
        assertThat(new CycledList().hasCycled(n5), is(true));
        assertThat(new CycledList().hasCycled(n6), is(true));

    }


    @Test
    public void whetNotCycledThen() {

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;

        assertThat(new CycledList().hasCycled(n1), is(false));
        assertThat(new CycledList().hasCycled(n2), is(false));
        assertThat(new CycledList().hasCycled(n3), is(false));
        assertThat(new CycledList().hasCycled(n4), is(false));
        assertThat(new CycledList().hasCycled(n5), is(false));
        assertThat(new CycledList().hasCycled(n6), is(false));
    }
}