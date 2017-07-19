package ru.job4j.condition;

/**.
 * class Triangle
 * @author
 * @version $Id$
 * @since 0.1
 */
public class Triangle {
    /**.
     * triangle
     */
    private Point a, b, c;

    /**.
     * constructor
     * @param a Point
     * @param b Point
     * @param c Point
     */
    public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    /**.
     * calculate triangle area
     * S = 0.5*((x1-x3)(y2-y3)-(x2-x3)(y1-y3))
     * @return double
     */
    public double area() {
        int x1, x2, x3, y1, y2, y3;
        x1 = a.getX(); x2 = b.getX(); x3 = c.getX();
        y1 = a.getY(); y2 = b.getY(); y3 = c.getY();
        return 0.5 * (Math.abs((x1 - x3) * (y2 - y3)) - Math.abs((x2 - x3) * (y1 - y3)));
    }
}
