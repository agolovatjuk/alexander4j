package ru.job4j.list;

//import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleList<E> implements SimpleListInterface<E> {

    private Object[] container;
    private int size = 0;
    private int modCount = 0;

    public SimpleList() {
        this.container = new Object[5];
    }

    public SimpleList(int capacity) {
        this.container = new Object[capacity];
    }

    @Override
    public void add(E a) {
        if (container.length == size) {
            resize(2 * size);
        }
        container[size++] = a;
        modCount++;
    }

    public int size() {
        return size;
    }

    private void resize(int newsize) {
//        container = Arrays.copyOf(container, newsize); //OR
        Object[] newData = new Object[newsize];
//        System.arraycopy(container, 0, newData,0, container.length); // OR
        for (int i = 0; i < container.length; i++) {
            newData[i] = container[i];
        }
        container = newData;
    }

    @Override
    @SuppressWarnings("unchecked")
    public E get(int index) {
        return (E) container[index];
    }

    @Override
    public Iterator<E> iterator() {
        return new SimpleIterator();
    }

    private class SimpleIterator implements Iterator<E> {

        int idx = 0;
        int expectedModCount = modCount;

        @Override
        public boolean hasNext() {
            return idx < size;
        }

        @Override
        @SuppressWarnings("unchecked")
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            if (expectedModCount != modCount) {
                throw new ConcurrentModificationException();
            }
            return (E) container[idx++];
        }
    }
}
