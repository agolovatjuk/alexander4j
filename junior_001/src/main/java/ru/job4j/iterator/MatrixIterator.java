package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MatrixIterator implements Iterator<Integer> {
    private int[][] ints;
    private int row = 0, col = 0;

    public MatrixIterator(int[][] ints) {
        this.ints = ints;
    }

    @Override
    public boolean hasNext() {
        return (!(row == this.ints.length - 1 & col == this.ints[row].length));
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        if (col == this.ints[row].length) {
            row++;
            col = 0;
        }
        return this.ints[row][col++];
    }
}
