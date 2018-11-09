package ru.job4j.tree;

import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

public class TreeTest {

    @Test
    public void whenAddThen() {
        Tree<Integer> t = new Tree<>(1);
        t.add(1, 2);
        t.add(1, 3);
        t.add(1, 4);
        t.add(4, 5);
        t.add(5, 6);
        assertThat(t.findBy(1).isPresent(), is(true));
        assertThat(t.findBy(5).isPresent(), is(true));
        assertThat(t.findBy(6).isPresent(), is(true));
        assertThat(t.findBy(7).isPresent(), is(false));
    }

    @Test
    public void whenAddDoubleAndCheckSizeThen() {
        Tree<String> tree = new Tree<>("1");
        boolean res;
        res = tree.add("1", "2");
        assertThat(res, is(true));
        res = tree.add("1", "1");
        assertThat(res, is(false));
        res = tree.add("2", "2");
        assertThat(res, is(false));
        res = tree.add("2", "1");
        assertThat(res, is(false));
        res = tree.add("2", "3");
        assertThat(res, is(true));

        assertThat(tree.size(), is(3));
    }

    @Test
    public void whenFindByThen() {
        Tree<Integer> tree = new Tree<>(1);
        tree.add(1, 2);
        tree.add(1, 2); // doubled
        tree.add(1, 3);
        tree.add(1, 3); // doubled
        tree.add(1, 4);
        tree.add(4, 5);
        tree.add(5, 6);
        assertThat(tree.size(), is(6));
        assertThat(tree.findBy(1).isPresent(), is(true));
        assertThat(tree.findBy(5).isPresent(), is(true));
        assertThat(tree.findBy(6).isPresent(), is(true));
        assertThat(tree.findBy(7).isPresent(), is(false));
    }

    @Test
    public void testAnotherTree() {
        Tree<Integer> tree = new Tree<>(0);
        tree.add(0, 1);
        tree.add(0, 2);
        tree.add(2, 20);
        tree.add(2, 21);
        tree.add(21, 210);
        tree.add(0, 3);
        tree.add(3, 30);
        tree.add(3, 31);
        tree.add(31, 310);
        tree.add(0, 4);
        tree.add(0, 5);
        assertThat(tree.findBy(0).isPresent(), is(true));
        assertThat(tree.findBy(21).isPresent(), is(true));
        assertThat(tree.findBy(31).isPresent(), is(true));
        assertThat(tree.findBy(310).isPresent(), is(true));
        assertThat(tree.findBy(99).isPresent(), is(false));
        assertThat(tree.findByDepth(0).isPresent(), is(true));
        assertThat(tree.findByDepth(21).isPresent(), is(true));
        assertThat(tree.findByDepth(31).isPresent(), is(true));
        assertThat(tree.findByDepth(310).isPresent(), is(true));
        assertThat(tree.findByDepth(99).isPresent(), is(false));
    }

    @Test
    public void whenIteratorThen() {
        Tree<Integer> tree = new Tree<>(0);
        tree.add(0, 1);
        tree.add(1, 10);
        tree.add(1, 11);
        tree.add(0, 2);
        tree.add(2, 20);
        tree.add(2, 21);
        assertThat(tree.add(2, 10), is(false));
        Iterator<Node<Integer>> iterator = tree.iterator();
        assertThat(iterator.next().eqValue(0), is(true));
        assertThat(iterator.next().eqValue(1), is(true));
        assertThat(iterator.next().eqValue(2), is(true));
        assertThat(iterator.next().eqValue(10), is(true));
        assertThat(iterator.next().eqValue(11), is(true));
        assertThat(iterator.next().eqValue(20), is(true));
        assertThat(iterator.next().eqValue(21), is(true));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenIteratorNotHasNextThen() {
        Tree<String> tree = new Tree<String>("");
        tree.add("", "YES");
        tree.add("", "NO");
        Iterator<Node<String>> iterator = tree.iterator();
        assertThat(iterator.next().eqValue(""), is(true));
        assertThat(iterator.next().eqValue("YES"), is(true));
        assertThat(iterator.next().eqValue("NO"), is(true));
        iterator.next();
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenIteratorDataModifiedThen() {
        Tree<Character> tree = new Tree<Character>('A');
        tree.add('A', 'B');
        tree.add('A', 'C');
        Iterator<Node<Character>> iterator = tree.iterator();
        assertThat(iterator.next().eqValue('A'), is(true));
        tree.add('C', 'E');
        iterator.next();
    }
}
