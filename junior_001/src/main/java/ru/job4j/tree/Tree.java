package ru.job4j.tree;

import java.util.Optional;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.ConcurrentModificationException;

public class Tree<E extends Comparable<E>> implements SimpleTree<E> {

    private Node<E> root;
    private int modCount = 0;
    private int size = 1; // root is always present

    public Tree(E value) {
        this.root = new Node<>(value);
    }

    public Tree(Node<E> node) {
        this.root = node;
    }

    public int size() {
        return this.size;
    }

    public boolean isBinary() {
        Iterator<Node<E>> iterator = this.iterator();
        while (iterator.hasNext()) {
            Node<E> node = iterator.next();
            if (node.leaves().size() > 2) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean add(E parent, E child) {
        boolean result = false;

        if (!this.findBy(child).isPresent()) {
            Optional<Node<E>> parentNode = this.findBy(parent);
            if (parentNode.isPresent()) {
                parentNode.get().add(new Node<>(child));
                size++;
                modCount++;
                result = true;
            }
        }
        return result;
    }

    @Override
    public Optional<Node<E>> findBy(E value) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();

        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (el.eqValue(value)) {
                rsl = Optional.of(el);
                break;
            }
            for (Node<E> child : el.leaves()) {
                data.offer(child);
            }
        }
        return rsl;
    }

    public Optional<Node<E>> findByDepth(E value) {
        Optional<Node<E>> result = Optional.empty();

        if (root.eqValue(value)) {
            return Optional.of(root);
        }
        for (Node<E> curNode: root.leaves()) {
            if (curNode.eqValue(value)) {
                return Optional.of(curNode);
            } else {
                Tree<E> tree = new Tree<>(curNode);
                result = tree.findByDepth(value);
                if (result.isPresent()) {
                    break;
                }
            }
        }
        return result;
    }

    @Override
    public Iterator<Node<E>> iterator() {
        return new TreeIterator();
    }

    private class TreeIterator implements Iterator<Node<E>> {

        Queue<Node<E>> data = new LinkedList<>();
        Iterator<Node<E>> iterator;
        int expectedModCount = modCount;

        private TreeIterator() {
            Queue<Node<E>> tmpdata = new LinkedList<>();
            tmpdata.offer(root);
            while (!tmpdata.isEmpty()) {
                Node<E> el = tmpdata.poll();
                data.offer(el);
                for (Node<E> node: el.leaves()) {
                    tmpdata.offer(node);
                }
            }
            iterator = data.iterator();
        }

        @Override
        public boolean hasNext() {
            return iterator.hasNext();
        }

        @Override
        public Node<E> next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            if (expectedModCount != modCount) {
                throw new ConcurrentModificationException();
            }
            return iterator.next();
        }
    }
}
