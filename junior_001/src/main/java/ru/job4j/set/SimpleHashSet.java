package ru.job4j.set;

import ru.job4j.list.SimpleLinkedList;

/**
 * 1) boolean add (E e)
 * 2) boolean contains (E e)
 * 3) boolean remove (E e)
 */
public class SimpleHashSet<T> {

    private int sizeOfContainer = 701;

    private double loadFactor = .75;
    private SimpleLinkedList<T>[] container;
    private int count = 0;

    public SimpleHashSet() {
        this.container =  new SimpleLinkedList[sizeOfContainer];
    }

    public SimpleHashSet(int hashTableSize) {
        this.container = new SimpleLinkedList[hashTableSize];
    }

    public void add(T item) {

        if (this.contains(item)) {
            return;
        }

        if ((double) count / (double) this.container.length > loadFactor) {
            this.resize((int) (count / loadFactor));
        }

        int h = getIndex(item);

        if (this.container[h] == null) {
            this.container[h] = new SimpleLinkedList<>();
        }

        this.container[h].addFirst(item);
        count++;
    }

    public boolean contains(T item) {
        int h = getIndex(item);
        boolean result = false;

        if (container[h] != null) {
            result = container[h].contains(item);
        }
        return result;
    }

    public void remove(T item) {
        int h = getIndex(item);

        if (this.contains(item)) {
            this.container[h].remove(item);
            if (this.container[h].size() == 0) {
                this.container[h] = null;
            }
            count--;
        }
    }

    public int size() {
        return this.count;
    }

    private int getIndex(T item) {
        return Math.abs(item.hashCode()) % this.container.length;
    }

    private void resize(int a) {
        int p = getNextPrime(2 * a);
        SimpleHashSet<T> newset = new SimpleHashSet<>(p);
        for (int i = 0; i < this.container.length; i++) {
            if (this.container[i] != null) {
                int sz = this.container[i].size();
                for (int k = 0; k < sz; k++) {
                    newset.add(this.container[i].removeFirst());
                }
            }
        }
        this.container = newset.container;
    }

    private int getNextPrime(int t) {
        while (!isPrime(t)) {
            t += 1;
        }
        return t;
    }

    private boolean isPrime(int t) {
        for (int i = 2; i < t / 2 + 1; i++) {
            if (t % i == 0) {
                return false;
            }
        }
        return true;
    }
}
