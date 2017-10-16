package ru.job4j.chesstest;

public class Board {
    Figure[] figures = new Figure[32];
    Cell[] cells = new Cell[64];
    Cell[][] cells2 = new Cell[8][9];
    static final char[] letters = "abcdefgh".toCharArray();

    Board() {
        init();
    }

    boolean move(Cell source, Cell dest) throws ImpossibleMoveException, OccupiedWayException, FigureNotFoundException{
        if (source == null) {
            throw new FigureNotFoundException("Figure not found");
        }
        if (dest != null) {
            throw new OccupiedWayException("Cell destination occupied");
        }

        source.figure.way(dest);
        return true;
    }

    Cell getcell(String pos) {
        char[] p = pos.toCharArray();
        int letter = Integer.valueOf(p[0] - 97);
        int dig = Integer.valueOf(p[1]);
        return this.cells2[dig][letter];
    }

    Cell putcell(String pos) {
        char[] p = pos.toCharArray();
        int letter = Integer.valueOf(p[0] - 97);
        int dig = Integer.valueOf(p[1]);
        Cell c = new Cell(pos);
        cells2[letter][dig] = c;
        return c;
    }

    /**.
     * e4->28
     * @param pos String
     * @return int
     */
    static int c2n(String pos) {
        char[] p = pos.toCharArray();
        char p0 = p[0];
        int letter = Integer.valueOf(p[0] - 97);
        int digit = Integer.valueOf(String.valueOf(p[1]));
        return 8 * (digit - 1) + letter;
    }

    /**.
     * 28->e4
     * @param idx int
     * @return String
     */
    static String n2c(int idx) {
        int letter = idx % 8;
        int digit = idx / 8 + 1;
        String pos = String.format("%c%d", letter + 97, digit);
        return pos;
    }

    void init(){
        String black = "black";
        String white = "white";
        Cell c;
        String p;

        // set white bishop c1
        c = new Cell("c1");
        this.figures[2] = new Bishop("Bishop", c, white);
        c.figure = this.figures[2];
        this.cells[c2n("c1")] = c;

        // set 8 white pawns
        for (int i = 0; i < 8; i++) {
            p = String.format("%c%d", letters[i], 2);
            c = new Cell(p);
            this.figures[8 + i] = new Pawn("Pawn", c, white);
            c.figure = this.figures[8 + i];
            this.cells[8 + i] = c;
        }

        // set 8 black pawns
        for (int i = 0; i < 8; i++) {
            p = String.format("%c%d", letters[i], 7);
            c = new Cell(p);
            this.figures[15 + i] = new Pawn("Pawn", c, black);
            c.figure = this.figures[15 + i];
            cells[48 + i] = c;
        }

        // set black bishop c8
        c = new Cell("c8");
        figures[15 + 8 + 2] = new Bishop("Bishop", c, black);
        c.figure = figures[15 + 8 + 2];
        cells[58] = c;
    }

    public static void main(String[] args) {
        Board b = new Board();
        // e2 -> e4
        Cell e2 = b.cells[c2n("e2")];
        Cell e4 = b.cells[c2n("e4")];
        b.move(e2, e4);
        b.move(b.cells[c2n("c1")], b.cells[c2n("a3")]);
        int a = b.c2n("e4");
        String pos = b.n2c(28);
        String pos2 = b.n2c(63);
    }
}
