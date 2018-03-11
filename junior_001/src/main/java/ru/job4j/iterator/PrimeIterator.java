package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class PrimeIterator implements Iterator<Integer> {

    private final int[] num;
    private int pos;

    public PrimeIterator(int[] num) {
        this.num = num;
    }

    private boolean isPrime(int n) {
        if (n == 1) {
            return false;
        }
        for (int i = 2; i < n / 2 + 1; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean hasNext() {
        while (this.pos < num.length) {
            if (isPrime(num[pos])) {
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
