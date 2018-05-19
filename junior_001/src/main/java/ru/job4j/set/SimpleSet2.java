package ru.job4j.set;

import ru.job4j.list.SimpleList;

import java.util.Iterator;

public class SimpleSet2<T> {

    private SimpleList<T> container;

    public SimpleSet2() {
        this.container = new SimpleList<>();
    }

    public void add(T value) {
        if (!this.container.contains(value)) {
            if (value == null) {
                this.container.add(null);
            } else {
                this.container.add(value);
            }
        }
    }

    public boolean contains(T value) {
        return this.container.contains(value);
    }

    public int size() {
        return this.container.size();
    }

    public Iterator<T> iterator() {
        return this.container.iterator();

    }
}
