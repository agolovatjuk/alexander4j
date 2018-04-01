package ru.job4j.list;

public class SimpleQueue<T> {

    private SimpleLinkedList<T> container = new SimpleLinkedList<T>();

    public T poll() {
        return container.removeLast();
    }

    public void push(T value) {
        container.addFirst(value);
    }
}
