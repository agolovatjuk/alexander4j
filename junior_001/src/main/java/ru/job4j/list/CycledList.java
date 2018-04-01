package ru.job4j.list;

class Node<T> {
    T value;
    Node<T> next;

    Node(T item, Node next) {
        this.value = item;
        this.next = next;
    }
}

public class CycledList {

    public boolean hasCycled(Node first) {
        Node hare = first;
        Node turtle = first;
        boolean iscycled = false;

        while (hare != null && hare.next != null) {
            hare = hare.next;
            if (hare == turtle) {
                iscycled = true;
                break;
            }
            hare = hare.next;
            if (hare == turtle) {
                iscycled = true;
                break;
            }
            turtle = turtle.next;
        }
        return iscycled;
    }
}
