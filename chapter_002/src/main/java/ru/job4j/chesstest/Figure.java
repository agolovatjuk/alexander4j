package ru.job4j.chesstest;

/**.
 * abstract class Figure
 */
public abstract class Figure {
    /**.
     * color white or black
     */
    private final String color;
    /**.
     * figure's name
     */
    private final String name;
    /**.
     * figures position on board
     */
    private final Cell position;

    /**.
     * put figure on the position
     * @param name String
     * @param position Cell
     * @param color color
     */
    Figure(String name, Cell position, String color) {
        this.name = name;
        this.position = position;
        this.color = color;
    }


    abstract Figure clone(Cell cell);

    abstract Cell[] way(Cell dest) throws ImpossibleMoveException;

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public Cell getPosition() {
        return position;
    }
}
