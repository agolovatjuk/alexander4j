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

        return true;
    }

    void remcell(String pos) {
        char[] p = pos.toCharArray();
        int letter = Integer.valueOf(p[0] - 97);
        int dig = Integer.valueOf(String.valueOf(p[1])) - 1;
        this.cells2[dig][letter] = null;
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
        this.cells2[dig][letter] = new Cell(pos);
        return this.cells2[dig][letter];
    }

    void init(){
        String black = "black";
        String white = "white";
        String p;

        // set white bishop c1
        this.figures[2] = new Bishop("Bishop", initcell("c1"), white);
        // set 8 white pawns
        for (int i = 0; i < 8; i++) {
            p = String.format("%c%d", letters[i], 2);
            this.figures[8 + i] = new Pawn("Pawn", initcell(p), white);
        }

        // set 8 black pawns
        for (int i = 0; i < 8; i++) {
            p = String.format("%c%d", letters[i], 7);
            this.figures[15 + i] = new Pawn("Pawn", initcell(p), black);
        }
        // set black bishop c8
        figures[15 + 8 + 2] = new Bishop("Bishop", initcell("c8"), black);
    }

    void step(String pos1, String pos2) {
        Cell src = getcell(pos1);
        Cell dst = getcell(pos2);
        if (move(src, dst) == true) {
            dst = initcell(pos2);
            Cell[] possible = src.figure.way(dst);
            Figure f;
            f = src.figure.clone(dst);
            remcell(pos1);
        }
    }

    public static void main(String[] args) {
        Board b = new Board();
        // White Pawn e2->e4 OK
        b.step("e2", "e4");
        // White Bishop c1->a3 Fail, no way
        b.step("c1", "a3");
    }
}
