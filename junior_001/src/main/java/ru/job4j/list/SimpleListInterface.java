package ru.job4j.list;

public interface SimpleListInterface<E> extends Iterable<E> {

    void add(E a);

    E get(int index);

}
