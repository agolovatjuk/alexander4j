package ru.job4j.chesstest;

public class Board {
    final int N = 8;
    Cell[][] cells = new Cell[N][N];

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
            f = getcell(c.pos).figure;
            if (f != null) {
                throw new OccupiedWayException(String.format("Way occupied by %s %s on %s",
                        f.color, f.name, c.pos));
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
        String black = "black", white = "white";

        //init cells
        for (int letter = 0; letter < N; letter++) {
            for (int digit = 0; digit < N; digit++) {
                cells[letter][digit] = new Cell(letter, digit);
            }
        }
        getcell("c1").figure = new Bishop("Bishop", getcell("c1"), white);
        getcell("f1").figure = new Bishop("Bishop", getcell("f1"), white);
        // set 8 white pawns
        for (int i = 0; i < 8; i++) {
            cells[i][1].figure = new Pawn("Pawn", cells[i][1], white);
        }
        // set 8 black pawns
        for (int i = 0; i < 8; i++) {
            cells[i][6].figure = new Pawn("Pawn", cells[i][6], black);
        }
        getcell("c8").figure = new Bishop("Bishop", getcell("c8"), black);
        getcell("f8").figure = new Bishop("Bishop", getcell("f8"), black);
    }

    void step(String pos1, String pos2) {
        Cell src = getcell(pos1);
        Cell dst = getcell(pos2);
        if (move(src, dst) == true) {
            dst.figure = src.figure.clone(dst);
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
