package ru.job4j.chesstest;

/**.
 *
 */
public class ImpossibleMoveException extends RuntimeException {
    /**.
     *
     * @param msg String
     */
    public ImpossibleMoveException(String msg) {
        super(msg);
    }
}

/**.
 *
 */
class OccupiedWayException extends RuntimeException {
    /**.
     *
     * @param msg String
     */
    OccupiedWayException(String msg) {
        super(msg);
    }
}

/**.
 *
 */
class FigureNotFoundException extends RuntimeException {
    /**.
     *
     * @param msg String
     */
    FigureNotFoundException(String msg) {
        super(msg);
    }
}