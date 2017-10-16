package ru.job4j.chesstest;

import ru.job4j.tracker.Input;

public class Cell {
    final String pos;
    int letter;
    int vert;
    Figure figure = null;

    /**.
     *
     * @param pos String "e2"
     */
    Cell(String pos) {
        this.pos = pos;
        char[] p = pos.toCharArray();
        this.letter = Integer.valueOf(p[0]) - 97; // a, b, c ... letter
        // a = 97
        this.vert = Integer.valueOf(String.valueOf(p[1])) - 1;
    }

}
