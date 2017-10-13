package ru.job4j.chesstest;

abstract public class Figure {
    final String color;
    final String name;
    final Cell position;

    Figure(String name, Cell position, String color) {
        this.name = name;
        this.position = position;
        this.color = color;
    }

    abstract Cell[] way(Cell dest) throws ImpossibleMoveException;
}
