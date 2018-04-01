package ru.job4j.list;

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

public class SimpleQueueTest {
    // FIFO
    @Test
    public void push() {
        SimpleQueue<Integer> queue = new SimpleQueue<>();
        for (int i = 0; i < 10; i++) {
            queue.push(i);
        }
        for (int i = 0; i < 10; i++) {
            assertThat(queue.poll(), is(i));
        }
    }
}