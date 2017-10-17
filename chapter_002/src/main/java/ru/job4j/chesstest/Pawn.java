package ru.job4j.chesstest;

public class Pawn extends Figure{

    Pawn(String name, Cell position, String color) {
        super(name, position, color);
    }

    @Override
    Pawn clone(Cell cell) {
        return new Pawn(this.name, cell, this.color);
    }

    @Override
    Cell[] way(Cell dest) throws ImpossibleMoveException {
        Cell src = this.position;
        int max_v = 0;
        Cell[] path;

        int flag = 1;
        if (src.figure.color.equals("black")) {
            flag = -1;
        }
        if ((src.digit == 1 | src.digit == 6) & src.digit + 2 * flag == dest.digit) {
            max_v += 2;
        } else if (src.digit + 1 * flag == dest.digit) {
            max_v += 1;
        } else {
            throw new ImpossibleMoveException(String.format("Impossible move %s Pawn from %s to %s",
                    src.figure.color, src.pos, dest.pos));
        }
        path = new Cell[max_v];
        for (int i = 0; i < max_v; i++) {
            path[i] = new Cell(src.letter, src.digit + (i + 1) * flag);
        }
        return path;
    }
}
