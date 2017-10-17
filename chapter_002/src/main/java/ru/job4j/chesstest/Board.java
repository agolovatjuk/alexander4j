package ru.job4j.chesstest;

public class Board {
    final int N = 8;
    Figure[] figures = new Figure[32];
    Cell[][] cells = new Cell[N][N];
    static final char[] letters = "abcdefgh".toCharArray();

    Board() {
        init();
    }

    boolean move(Cell source, Cell dest) throws ImpossibleMoveException, OccupiedWayException, FigureNotFoundException{
        if (source.figure == null) {
            throw new FigureNotFoundException("Figure not found");
        }
        Figure f = source.figure;
        Cell[] path = f.way(dest);
        if (path == null) {
            throw new ImpossibleMoveException(String.format("Impossible move %s to %s", f.name, dest.pos));
        }
        for (Cell c: path) {
            Cell tmp = getcell(c.pos);
            if (tmp.figure != null) {
                throw new OccupiedWayException(String.format("Way occupied by %s %s on %s",
                        tmp.figure.color, tmp.figure.name, tmp.pos));
            }
        }
        return true;
    }

    Cell getcell(String pos) {
        char[] p = pos.toCharArray();
        int letter = Integer.valueOf(p[0] - 97);
        int digit = Integer.valueOf(String.valueOf(p[1])) - 1;
        return this.cells[letter][digit];
    }

    void init(){
        String black = "black";
        String white = "white";
        String p;

        //init cells
        for (int letter = 0; letter < N; letter++) {
            for (int digit = 0; digit < N; digit++) {
                cells[letter][digit] = new Cell(letter, digit);
            }
        }
        // set white bishop c1
        this.figures[2] = new Bishop("Bishop", getcell("c1"), white);
        // set white bishop f1
        this.figures[5] = new Bishop("Bishop", getcell("f1"), white);
        // set 8 white pawns
        for (int i = 0; i < 8; i++) {
            p = String.format("%c%d", letters[i], 2);
            this.figures[8 + i] = new Pawn("Pawn", getcell(p), white);
        }

        // set 8 black pawns
        for (int i = 0; i < 8; i++) {
            p = String.format("%c%d", letters[i], 7);
            this.figures[15 + i] = new Pawn("Pawn", getcell(p), black);
        }
        // set black bishop c8
        figures[15 + 8 + 2] = new Bishop("Bishop", getcell("c8"), black);
    }

    void step(String pos1, String pos2) {
        Cell src = getcell(pos1);
        Cell dst = getcell(pos2);
        if (move(src, dst) == true) {
            Figure f;
            f = src.figure.clone(dst);
            src.figure = null;
        }
    }

    public static void main(String[] args) {
        Board b = new Board();
        // White Pawn e2->e4 OK
        b.step("e2", "e4");
        b.step("e7", "e5");
//        b.step("c2", "c5");
        // White Bishop c1->a3 Fail, no way
        b.step("b2", "b3");
        b.step("c1", "a3");
        b.step("a3", "d6");
        b.step("d6", "g3");
    }
}
