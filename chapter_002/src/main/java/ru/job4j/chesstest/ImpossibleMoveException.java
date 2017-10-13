package ru.job4j.chesstest;

public class ImpossibleMoveException extends RuntimeException {

    public ImpossibleMoveException(String msg) {
        super(msg);
    }
}

class OccupiedWayException extends RuntimeException {
    public OccupiedWayException(String msg) {
        super(msg);
    }
}

class FigureNotFoundException extends RuntimeException {
    public FigureNotFoundException(String msg) {
        super(msg);
    }
}