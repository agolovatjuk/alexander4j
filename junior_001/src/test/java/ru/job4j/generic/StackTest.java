package ru.job4j.generic;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class StackTest {

    @Test
    public void whenCreateStackThen() throws IllegalAccessException, ClassNotFoundException, InstantiationException {
        Stack stringStack = new Stack(10);
        stringStack.push("A");
        assertThat(stringStack.size(), is(1));
        String result = stringStack.pop();
        assertThat(result, is("A"));
        assertThat(stringStack.size(), is(0));
    }

}