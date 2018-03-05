package ru.job4j.matrixiterator;

import java.util.Iterator;

public class MatrixIterator implements Iterator<Integer> {
    int[][] ints;
    int row, col;

    public MatrixIterator(int[][] ints) {
        this.ints = ints;
    }

    @Override
    public boolean hasNext() {
        return (!(row == this.ints.length - 1 & col == this.ints[row].length));
    }

    @Override
    public Integer next() {
        Integer x;
        if (col < ints[row].length) {
            x = this.ints[row][col++];
        } else {
            col = 0;
            x = this.ints[++row][col++];
        }
        return x;
    }
}
