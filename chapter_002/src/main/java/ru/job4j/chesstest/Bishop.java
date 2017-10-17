package ru.job4j.chesstest;

public class Bishop extends Figure {

    Bishop(String name, Cell position, String color) {
        super(name, position, color);
    }

    @Override
    Bishop clone(Cell cell) {
        return new Bishop(this.name, cell, this.color);
    }

    @Override
    Cell[] way(Cell dest) throws ImpossibleMoveException {
        Cell src = this.position;
        int flag_letter = 1, flag_digit = 1;
        int dlet = dest.letter - src.letter;
        int ddig = dest.digit - src.digit;
        if(Math.abs(dlet) != Math.abs(ddig)) {
            throw new ImpossibleMoveException("Impossible move");
        }
        if (dlet < 0) {
           flag_letter = -1;
        }
        if (ddig < 0) {
            flag_digit = -1;
        }
        int delta = Math.abs(dlet);
        Cell[] p = new Cell[delta];
        for (int i = 0; i < delta; i++) {
            p[i] = new Cell(src.letter + (i + 1) * flag_letter, src.digit + (i + 1) * flag_digit);
        }
        return p;
    }
}
