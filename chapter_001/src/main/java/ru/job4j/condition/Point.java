package ru.job4j.condition;

/**.
 * check Point
 * @author Alexander Golovatyuk
 * @version $Id$
 * @since 0.1
 */
public class Point {
    /**. the first coordinate
     */
    private int x;
    /**. the second coordinate
     */
    private int y;

    /**.
     * constructor
     * @param x int
     * @param y int
     */
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**.
     * get x
     * @return x
     */
    public int getX() {
        return this.x;
    }

    /**.
     * get y
     * @return y
     */
    public int getY() {
        return this.y;
    }

    /**.
     * check point y(x) = ax + b
     * @param a int
     * @param b int
     * @return boolean
     */
    public boolean is(int a, int b) {
        return this.y == a * this.x + b;
    }
}

