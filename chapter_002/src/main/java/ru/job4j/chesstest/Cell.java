package ru.job4j.chesstest;

public class Cell {
    final String pos;
    int letter;
    int digit;
    Figure figure;

    /**.
     *
     * @param pos String "e2"
     */
    Cell(String pos) {
        this.pos = pos;
        char[] p = pos.toCharArray();
        this.letter = Integer.valueOf(p[0]) - 97; // a, b, c ... letter
        // a = 97
        this.digit = Integer.valueOf(String.valueOf(p[1])) - 1;
    }

    /**.
     *
     * @param letter int
     * @param digit int
     */
    Cell(int letter, int digit) {
        this.letter = letter;
        this.digit = digit;
        this.pos = String.format("%c%d", letter + 97, digit + 1);
    }
}
