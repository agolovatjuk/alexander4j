package ru.job4j.chesstest;

/**.
 * main chess board class
 */
public class Board {

    private Figure[] whiteFigures = new Figure[16];
    private Figure[] blackFigures = new Figure[16];

    public Figure[] getBlackFigures() {
        return blackFigures;
    }

    public Figure[] getWhiteFigures() {
        return whiteFigures;
    }

    /**.
     * Constructor
     */
    Board() {
        /**.
         * init
         */
        init();
    }

    /**.
     * Init chess board wit
     */
    void init() {
        String black = "black", white = "white";

        // white Figures
        for (int i = 0; i < 8; i++) {
            whiteFigures[i] = new Pawn("Pawn", new Cell(i, 1), white);
        }
        whiteFigures[10] = new Bishop("Bishop", new Cell("c1"), white);
        whiteFigures[13] = new Bishop("Bishop", new Cell("f1"), white);
        // black Figures
        for (int i = 0; i < 8; i++) {
            blackFigures[i] = new Pawn("Pawn", new Cell(i, 6), black);
        }
        blackFigures[10] = new Bishop("Bishop", new Cell("c8"), black);
        blackFigures[13] = new Bishop("Bishop", new Cell("f8"), black);
    }

    /**.
     * Try to move from source Cell to dest Cell
     * @param source Cell
     * @param dest Cell
     * @return boolean
     * @throws ImpossibleMoveException wrong move
     * @throws OccupiedWayException way is occupied
     * @throws FigureNotFoundException no figure to move
     */
    boolean move(Cell source, Cell dest) throws ImpossibleMoveException, OccupiedWayException, FigureNotFoundException {

        Figure f = getfigure(source.getPos());

        if (f == null) {
            throw new FigureNotFoundException("Figure not found");
        }

        Cell[] path = f.way(dest);

        if (path == null) {
            throw new ImpossibleMoveException(String.format("Impossible move %s to %s", f.getName(), dest.getPos()));
        }
        for (Cell c: path) {
            f = getfigure(c.getPos());
            if (f != null) {
                throw new OccupiedWayException(String.format("Way occupied by %s %s on %s",
                        f.getColor(), f.getName(), c.getPos()));
            }
        }
        return true;
    }

    Figure getfigure(String pos) {
        for (Figure f: whiteFigures) {
            if (f != null && f.getPosition().getPos().equals(pos)) {
                return f;
            }
        }
        for (Figure f: blackFigures) {
            if (f != null && f.getPosition().getPos().equals(pos)) {
                return f;
            }
        }
        return null;
    }
    Figure step(String source, String destination) {
        Cell src = new Cell(source);
        Cell dst = new Cell(destination);
        if (move(src, dst)) {
            Figure f = getfigure(source);
            return f.clone(dst);
        }
        return null;
    }

    public static void main(String[] args) {
        Board b = new Board();
        // White Pawn e2->e4 OK
        b.whiteFigures[4] = b.step("e2", "e4");
        b.blackFigures[4] = b.step("e7", "e5");
//        b.step("c2", "c5");
        // White Bishop c1->a3 Fail, no way
        b.whiteFigures[1]  = b.step("b2", "b3");
        b.whiteFigures[10] = b.step("c1", "a3");
//        b.step("a3", "d6");
//        b.step("d6", "g3");
    }
}
