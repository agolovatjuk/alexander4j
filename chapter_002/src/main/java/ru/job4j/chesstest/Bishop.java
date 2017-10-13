package ru.job4j.chesstest;

public class Bishop extends Figure {

    Bishop(String name, Cell position, String color) {
        super(name, position, color);
    }

    @Override
    Cell[] way(Cell dist) throws ImpossibleMoveException {
        return new Cell[0];
    }
}
