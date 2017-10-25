package ru.job4j.chesstest;

/**.
 * class Cell for save figure position
 */
public class Cell {
    /**.
     * position String
     */
    private final String pos;
    /**.
     * which letter from abcdefgh on board
     */
    private int letter;
    /**.
     * which digit on board
     */
    private int digit;

    /**.
     * Cell can be initiated with String
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
     * Cell can be initiated with two digits
     * @param letter int
     * @param digit int
     */
    Cell(int letter, int digit) {
        this.letter = letter;
        this.digit = digit;
        this.pos = String.format("%c%d", letter + 97, digit + 1);
    }

    public String getPos() {
        return this.pos;
    }

    public int getLetter() {
        return letter;
    }

    public int getDigit() {
        return digit;
    }
}
