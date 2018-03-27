package ru.job4j.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleLinkedList<E> implements SimpleListInterface<E> {

    private Node first;
    private Node last;
    private int size = 0;
    private int modCount;

    private class Node {
        E element;
        Node next;
        Node prev;

        Node(Node prev, E e, Node next) {
            this.prev = prev;
            this.element = e;
            this.next = next;
        }
    }

    public SimpleLinkedList() {
    }

    public int size() {
        return size;
    }

    /**
     *  add value as last element
     */
    @Override
    @SuppressWarnings("unchecked")
    public void add(E value) {
        Node oldlast = last;
        Node newNode = new Node(oldlast, value, null);
        last = newNode;
        if (oldlast == null) {
            first = newNode;
        } else {
            oldlast.next = newNode;
        }
        size++;
        modCount++;
    }

    @Override
    @SuppressWarnings("unchecked")
    public E get(int index) {
        Node x;
        if (index < size / 2) {
            x = first;
            for (int i = 0; i < index; i++) {
                x = x.next;
            }
        } else {
            x = last;
            for (int i = 0; i < size - 1 - index; i++) {
                x = x.prev;
            }
        }
        return (E) x.element;
    }

    @Override
    public Iterator<E> iterator() {
        return new SimpleIterator();
    }

    private class SimpleIterator implements Iterator<E> {

        private Node x = first;
        private int nextIndex = 0;
        private int expectedModCount = modCount;

        @Override
        public boolean hasNext() {
            return nextIndex < size;
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

            E elm = (E) x.element;
            x = x.next;
            nextIndex++;
            return elm;
        }
    }
}
