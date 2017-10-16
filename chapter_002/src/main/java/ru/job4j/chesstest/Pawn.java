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

        return new Cell[0];
    }
}
