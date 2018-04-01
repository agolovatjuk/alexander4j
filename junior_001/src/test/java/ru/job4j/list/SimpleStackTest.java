package ru.job4j.list;

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

public class SimpleStackTest {
    // LIFO
    @Test
    public void whenPushAndPollThen() {
        SimpleStack<Integer> stack = new SimpleStack<>();
        for (int i = 0; i < 10; i++) {
            stack.push(i);
        }
        for (int i = 0; i < 10; i++) {
            assertThat(stack.poll(), is(9 - i));
        }
    }
}