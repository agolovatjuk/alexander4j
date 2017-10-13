package ru.job4j.chesstest;

public class Board {
    Figure[] figures = new Figure[32];
    Cell[] cells = new Cell[64];

    Board() {
        init();
    }

    boolean move(Cell source, Cell dest) throws ImpossibleMoveException, OccupiedWayException, FigureNotFoundException{
        return true;
    }

    void init(){
        String black = "black";
        String white = "white";
        char[] hrz = "abcdefgh".toCharArray();
        // set 8 white pawns
        for (int i = 0; i < 8; i++) {
            figures[ 7 + i] = new Pawn("Pawn", new Cell(String.format("%c%d", hrz[i], 2)), white);
        }
        // set white bishop c1
        figures[10] = new Bishop("Bishop", new Cell("c1"), white);

        // set 8 black pawns
        for (int i = 0; i < 8; i++) {
            figures[15 + i] = new Pawn("Pawn", new Cell(String.format("%c%d", hrz[i], 7)), black);
        }
        // set black bishop c8
        figures[15 + 8 + 2] = new Bishop("Bishop", new Cell("c8"), black);
    }

    public static void main(String[] args) {
        Board b = new Board();
    }
}
