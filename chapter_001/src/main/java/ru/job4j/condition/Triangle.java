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
     * calculate triangle area or -1 if impossible
     * S = 0.5*((x1-x3)(y2-y3)-(x2-x3)(y1-y3))
     * @return double
     */
    public double area() {
        double result;
        // points
        int x1 = a.getX(); int x2 = b.getX(); int x3 = c.getX();
        int y1 = a.getY(); int y2 = b.getY(); int y3 = c.getY();

        result = 0.5 * Math.abs((Math.abs((x1 - x3) * (y2 - y3)) - Math.abs((x2 - x3) * (y1 - y3))));
        if (Double.compare(result, 0.0) == 0) {
            result = -1;
        }
        return result;
        }
}
