package ru.job4j.set;

import ru.job4j.list.SimpleLinkedList;
import java.util.Iterator;

public class SimpleLinkedListSet<T> implements Iterable<T> {

    private SimpleLinkedList<T> container;

    public SimpleLinkedListSet() {
        container = new SimpleLinkedList<>();
    }

    public int size() {
        return container.size();
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean add(T object) {
        boolean result = false;

        if (!container.contains(object)) {
            result = true;
            container.add(object);
        }
        return result;
    }

    public boolean remove(T object) {
        boolean result = false;

        if (container.contains(object)) {
            container.remove(object);
            result = true;
        }
        return result;
    }

    @Override
    public Iterator<T> iterator() {
        return container.iterator();
    }
}
