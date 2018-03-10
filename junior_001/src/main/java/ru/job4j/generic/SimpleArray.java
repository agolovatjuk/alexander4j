package ru.job4j.generic;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleArray<T> implements Iterable<T> {

    private T[] objects;
    private int pos = -1;

    public SimpleArray(int capacity) {
        this.objects = (T[]) new Object[capacity];
    }

    public void add(T model) {
        objects[++pos] = model;
    }

    public void set(int index, T model) {
        objects[index] = model;
    }

    public T delete(int index) {
        T item = objects[index];
        System.arraycopy(objects, index + 1, objects, index, pos - index);
        objects[pos--] = null;
        return item;
    }

    public T get(int index) {
        return objects[index];
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("SimpleArray{");
        sb.append("objects=").append(objects == null ? "null" : Arrays.asList(objects).toString());
        sb.append('}');
        return sb.toString();
    }

    @Override
    public Iterator<T> iterator() {
        return new SimpleArrayIterator();
    }

    private class SimpleArrayIterator implements Iterator<T> {

        private int itcur = 0;

        @Override
        public boolean hasNext() {
            return itcur <= pos;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return objects[itcur++];
        }
    }
}
