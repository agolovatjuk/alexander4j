package ru.job4j.list;

public class SimpleStack<T> {

    private SimpleLinkedList<T> container = new SimpleLinkedList<>();

    public T poll() {
        return container.removeFirst();
    }

    public void push(T value) {
        container.addFirst(value);
    }
}
