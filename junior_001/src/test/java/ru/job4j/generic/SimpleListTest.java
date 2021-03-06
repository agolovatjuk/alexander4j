package ru.job4j.generic;

import org.junit.Test;

import java.util.Date;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SimpleListTest {

    @Test
    public void pushStringTest() {
        class Stack extends SimpleList<String> {
            Stack(int n) throws IllegalAccessException, ClassNotFoundException, InstantiationException {
                super(10);
            }
        }
        try {
            Stack stringStack = new Stack(10);
            String s = stringStack.getNewClassT();
            assertThat(s instanceof String, is(true));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void pushArrayListStack() {
        class Stack extends SimpleList<Date> {
            Stack(int n) throws IllegalAccessException, ClassNotFoundException, InstantiationException {
                super(10);
            }
        }
        try {
            Stack stringStack = new Stack(10);
            Date obj = stringStack.getNewClassT();
            assertThat(obj instanceof Date, is(true));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void size() {
        class Stack extends SimpleList<String> {
            Stack(int n) throws IllegalAccessException, ClassNotFoundException, InstantiationException {
                super(10);
            }
        }
        try {
            Stack stringStack = new Stack(10);
            stringStack.push("First");
            assertThat(stringStack.size(), is(1));
            stringStack.push("Second");
            assertThat(stringStack.size(), is(2));
            String result = stringStack.pop();
            assertThat(result, is("Second"));
            assertThat(stringStack.size(), is(1));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}