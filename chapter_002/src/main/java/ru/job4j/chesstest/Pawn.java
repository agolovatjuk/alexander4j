package ru.job4j.chesstest;

public class Pawn extends Figure{

    Pawn(String name, Cell position, String color) {
        super(name, position, color);
    }

    @Override
    Cell[] way(Cell dist) throws ImpossibleMoveException {
        return new Cell[0];
    }
}
