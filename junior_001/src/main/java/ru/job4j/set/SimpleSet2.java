package ru.job4j.set;

import ru.job4j.list.SimpleList;

public class SimpleSet2<T> {

    private SimpleList<T> container;

    public SimpleSet2() {
        this.container = new SimpleList<>();
    }

    public void add(Object value) {
        if (!this.container.contains(value)) {
            if (value == null) {
                this.container.add(null);
            } else {
                this.container.add((T) value);
            }
        }
    }

    public Object contains(Object value) {
        return this.container.contains(value);
    }

    public int size() {
        return this.container.size();
    }
}
