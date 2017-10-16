package ru.job4j.chesstest;

public class Board {
    Figure[] figures = new Figure[32];
    Cell[] cells = new Cell[64];
    Cell[][] cells2 = new Cell[8][8];
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
        int dig = Integer.valueOf(String.valueOf(p[1])) - 1;
        return this.cells2[dig][letter];
    }

    Cell initcell(String pos) {
        char[] p = pos.toCharArray();
        int letter = Integer.valueOf(p[0] - 97);
        int dig = Integer.valueOf(String.valueOf(p[1])) - 1;
        Cell c = new Cell(pos);
        cells2[dig][letter] = c;
        return c;
    }

    void init(){
        String black = "black";
        String white = "white";
        Cell c;
        String p;

        // set white bishop c1
        this.figures[2] = new Bishop("Bishop", initcell("c1"), white);

        // set 8 white pawns
        for (int i = 0; i < 8; i++) {
            p = String.format("%c%d", letters[i], 2);
            c = initcell(p);
            this.figures[8 + i] = new Pawn("Pawn", c, white);
        }

        // set 8 black pawns
        for (int i = 0; i < 8; i++) {
            p = String.format("%c%d", letters[i], 7);
            c = initcell(p);
            this.figures[15 + i] = new Pawn("Pawn", c, black);
        }

        // set black bishop c8
        figures[15 + 8 + 2] = new Bishop("Bishop", initcell("c8"), black);
    }

    public static void main(String[] args) {
        Board b = new Board();
        Cell e2 = b.getcell("e2");
        Cell e4 = b.getcell("e4");
        b.move(e2, e4);
//        b.move(b.cells[c2n("c1")], b.cells[c2n("a3")]);
        b.move(b.getcell("c1"), b.getcell("a3"));
    }
}
