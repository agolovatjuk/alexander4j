package ru.job4j.chesstest;

public class Bishop extends Figure {

    Bishop(String name, Cell position, String color) {
        super(name, position, color);
    }

    @Override
    Bishop clone(Cell cell) {
        return new Bishop(this.name, cell, this.color);
    }

    Cell[] possiblemove(Cell dest) {
        Cell src = this.position;
        Cell[] cell = new Cell[10];

        return cell;
    }

    @Override
    Cell[] way(Cell dest) throws ImpossibleMoveException {
        possiblemove(dest);
        return new Cell[0];
    }
}
