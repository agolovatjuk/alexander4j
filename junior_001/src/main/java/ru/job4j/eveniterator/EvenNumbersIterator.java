package ru.job4j.eveniterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenNumbersIterator implements Iterator<Integer> {
    int[] num;
    int pos;

    public EvenNumbersIterator(int[] num) {
        this.num = num;
    }

    @Override
    public boolean hasNext() {
        while (pos < num.length) {
            if (num[pos] % 2 == 0) {
                return true;
            } else {
                pos++;
            }
        }
        return false;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return num[pos++];
    }
}