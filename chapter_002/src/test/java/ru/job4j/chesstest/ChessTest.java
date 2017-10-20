package ru.job4j.chesstest;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**.
 * test
 */
public class ChessTest {
    /**.
     * test if way to move occupied
     */
    @Test
    public void whenBishopGoFirstThen() {
        Board b = new Board();
        try {
            // Bishop f1->b5
            b.whiteFigures[13] = b.step("f1", "b5");
        } catch (OccupiedWayException e) {
            assertThat(e.getMessage(), is("Way occupied by white Pawn on e2"));
            b.whiteFigures[4] = b.step("e2", "e4");
            b.whiteFigures[13] = b.step("f1", "b5");
        }
    }

    /**.
     * test if bishop go to wrong position
     */
    @Test
    public void whenBishopGoWrongThen() {
        Board b = new Board();
        try {
            b.whiteFigures[4] = b.step("e2", "e4");
            b.whiteFigures[13] = b.step("f1", "b3");
        } catch (ImpossibleMoveException e) {
            assertThat(e.getMessage(), is("Impossible move"));
        }
    }

    /**.
     * test if no figure on source position
     */
    @Test
    public void whenNoFigureThen() {
        Board b = new Board();
        b.whiteFigures[4] = null;
        try {
            b.whiteFigures[4] = b.step("a4", "e4");
        } catch (FigureNotFoundException e) {
            assertThat(e.getMessage(), is("Figure not found"));
        }
    }
}
