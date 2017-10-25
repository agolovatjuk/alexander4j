package ru.job4j.chesstest;

/**.
 * class
 */
public class Pawn extends Figure {
    /**.
     * COnstructor
     * @param name String
     * @param position Cell
     * @param color string
     */
    Pawn(String name, Cell position, String color) {
        super(name, position, color);
    }

    @Override
    Pawn clone(Cell cell) {
        return new Pawn(this.getName(), cell, this.getColor());
    }

    @Override
    Cell[] way(Cell dest) throws ImpossibleMoveException {
        Cell src = this.getPosition();
        int maxmove = 0;
        Cell[] path;

        int flag = this.getColor().equals("white") ? 1 : -1;

        if ((src.getDigit() == 1 | src.getDigit() == 6) & src.getDigit() + 2 * flag == dest.getDigit()) {
            maxmove += 2;
        } else if (src.getDigit() + 1 * flag == dest.getDigit()) {
            maxmove += 1;
        } else {
            throw new ImpossibleMoveException(String.format("Impossible move %s Pawn from %s to %s",
                    this.getColor(), src.getPos(), dest.getPos()));
        }
        path = new Cell[maxmove];
        for (int i = 0; i < maxmove; i++) {
            path[i] = new Cell(src.getLetter(), src.getDigit() + (i + 1) * flag);
        }
        return path;
    }
}
