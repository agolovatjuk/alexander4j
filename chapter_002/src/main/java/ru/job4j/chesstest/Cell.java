package ru.job4j.chesstest;

public class Cell {
    private char letter;
    private int vert = 0;
    private boolean state = true;
    Figure figure = null;

    /**.
     *
     * @param pos String "e2"
     */
    Cell(String pos) {
        char[] p = pos.toCharArray();
        this.letter = p[0]; // a, b, c ... letter
        // a = 97
        this.vert = Integer.valueOf(String.valueOf(p[1]));
    }

    /**.
     * free Cell
     */
    public void freecell() {
        this.state = true;
    }

    /**.
     * occupy Cell
     */
    public void occupycell() {
        this.state = false;
    }

    /**.
     *
     * @return state boolean
     */
    public boolean getstate() {
        return this.state;
    }

    /**.
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        Cell c = new Cell("b5");
    }
}
