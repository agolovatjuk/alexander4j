package ru.job4j.set;

import ru.job4j.generic.SimpleArray;

import java.util.Iterator;

public class SimpleSet<T> implements Iterable<T> {

    protected SimpleArray<T> container;

    public SimpleSet(int capacity) {
        container = new SimpleArray<>(capacity);
    }

    public SimpleSet() {
        container = new SimpleArray<>(10);
    }

    public int size() {
        return container.size();
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean contains(T object) {
        Iterator<T> it = iterator();
        boolean result = false;

        while (it.hasNext()) {
            if (it.next().equals(object)) {
                result = true;
                break;
            }
        }
        return result;
    }

    public boolean add(T object) {
        boolean result = false;

        if (!contains(object)) {
            container.add(object);
            result = true;
        }
        return result;
    }

    public boolean remove(T object) {
        Iterator<T> it = this.iterator();
        boolean result = false;
        int cnt = 0;

        while (it.hasNext()) {
            if (it.next().equals(object)) {
                container.delete(cnt);
                result = true;
                break;
            }
            cnt++;
        }
        return result;
    }

    @Override
    public Iterator<T> iterator() {
        return container.iterator();
    }
}