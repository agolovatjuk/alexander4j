package ru.job4j.map;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class UserHashMap<K, V> {

    static final float DEFAULT_LOAD_FACTOR = 0.75f;
    static final int DEFAULT_INITIAL_CAPACITY = 8;

    final float loadfactor;
    int size;
    int modCount;

    Node<K, V>[] table;

    static class Node<K, V> {
        K key;
        V value;
        Node<K, V> next;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return key + ", " + value;
        }
    }

    public UserHashMap() {
        this(DEFAULT_INITIAL_CAPACITY);
    }

    public UserHashMap(int capacity) {
        this.loadfactor = DEFAULT_LOAD_FACTOR;
        this.table = new Node[Math.min(capacity, Integer.MAX_VALUE)];
    }

    public UserHashMap(int capacity, float loadFactor) {
        this.loadfactor = loadFactor;
        this.table = new Node[Math.min(capacity, Integer.MAX_VALUE)];
    }

    public int hash(K key) {
        double a = (Math.sqrt(5) - 1) / 2;
        double x = a * key.hashCode() % 1 * table.length;
        return (int) Math.abs(x);
    }

    public boolean insert(K key, V value) {
        return this.put(key, value);
    }

    public boolean put(K key, V value) {
        if ((float) this.size / table.length >= this.loadfactor) {
            resize(table.length * 2);
        }
        remove(key);
        Node<K, V> node = new Node<>(key, value);
        int idx = hash(key);
        if (table[idx] != null && !table[idx].key.equals(key)) {
            node.next = table[idx];
        }
        table[idx] = node;
        size++;
        modCount++;
        return true;
    }

    public V get(K key) {
        if (table[hash(key)] != null) {
            Node<K, V> node = table[hash(key)];
            while (node.next != null && !node.key.equals(key)) {
                node = node.next;
            }
            return node.key.equals(key) ? node.value : null;
        }
        return null;
    }

    public boolean delete(K key) {
        return remove(key);
    }

    public boolean remove(K key) {
        boolean value = false;
        Node<K, V> p = table[hash(key)];
        if (p != null) {
            Node<K, V> e = p.next;
            if (key.equals(p.key)) {
                table[hash(key)] = p.next;
                p = null;
                value = true;
            } else if (e != null) {
                do {
                    if (key.equals(e.key)) {
                        p.next = e.next;
                        e = null;
                        value = true;
                        break;
                    }
                    p = p.next;
                    e = e.next;
                } while (e != null);
            }
            if (value) {
                size--;
                modCount++;
            }
        }
        return value;
    }

    public boolean resize(int newsize) {
        if (newsize >= Integer.MAX_VALUE) {
            return false;
        }
        UserHashMap<K, V> tmpHashMap = new UserHashMap<>(newsize);
        populateUserHashMap(tmpHashMap);
        return true;
    }

    public boolean resize(int newsize, float loadFactor) {
        if (newsize >= Integer.MAX_VALUE) {
            return false;
        }
        UserHashMap<K, V> tmpHashMap = new UserHashMap<>(newsize, loadFactor);
        populateUserHashMap(tmpHashMap);
        return true;
    }

    private void populateUserHashMap(UserHashMap<K, V> tmpHashMap) {
        Iterator<Node<K, V>> it = getItemIterator();
        Node<K, V> n;
        while (it.hasNext()) {
            n = it.next();
            tmpHashMap.put(n.key, n.value);
        }
        this.table = tmpHashMap.table;
        this.size = tmpHashMap.size;
        this.modCount = tmpHashMap.modCount;
    }

    public Iterator<K> getKeyIterator() {
        return new KeyIterator();
    }

    public Iterator<Node<K, V>> getItemIterator() {
        return new ItemIterator();
    }

    abstract class MyHashIterator {
        int expectedModCount;
        int index;
        Node<K, V> nextNode;

        MyHashIterator() {
            expectedModCount = modCount;
            nextNode = null;
            index = 0;
            if (table != null && size > 0) {
                while (index < table.length && nextNode == null) {
                    nextNode = table[index++];
                }
            }
        }

        public boolean hasNext() {
            return nextNode != null;
        }

        public Node<K, V> nextNode() {
            Node<K, V> e = nextNode;
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            if (expectedModCount != modCount) {
                throw new ConcurrentModificationException();
            }
            nextNode = e.next;
            if (nextNode == null && table != null) {
                while (index < table.length && nextNode == null) {
                    nextNode = table[index++];
                }
            }
            return e;
        }
    }

    public final class KeyIterator extends MyHashIterator implements Iterator<K> {
        @Override
        public K next() {
            return nextNode().key;
        }
    }

    public final class ItemIterator extends MyHashIterator implements Iterator<Node<K, V>> {
        @Override
        public Node<K, V> next() {
            return nextNode();
        }
    }
}
