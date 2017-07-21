package ru.job4j.condition;

import org.junit.Test;

// import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.hamcrest.number.IsCloseTo.closeTo;

/**.
 * @author
 * @version $Id$
 * @since 0.1
 */
public class TriangleTest {
    /**.
     * test area
     */
	@Test
	public void whenAreaSetTreePointsThenTriangleArea() {
		Point a = new Point(0, 0);
		Point b = new Point(0, 2);
		Point c = new Point(2, 0);
		Triangle t = new Triangle(a, b, c);
		double result = t.area();
		assertThat(result, closeTo(2.0, 0.1));
	}
    /**.
     * test impossible area
     */
	@Test
	public void whenAreaSetTreePointsOnLineThen() {
		Point a = new Point(0, 0);
		Point b = new Point(4, 2);
		Point c = new Point(-2, -1);
		Triangle t = new Triangle(a, b, c);
		double result = t.area();
		assertThat(result, closeTo(-1, 0.1));
	}
    /**.
     * test impossible area
     */
	@Test
	public void whenAreaSetTwoPointsTheSameThen() {
		Point a = new Point(2, -1);
		Point b = new Point(0, 0);
		Point c = new Point(0, 0);
		Triangle t = new Triangle(a, b, c);
		double result = t.area();
		assertThat(result, closeTo(-1, 0.1));
	}
    /**.
     * test impossible area
     */
	@Test
	public void whenAreaSetTreePointsTheSameThen() {
		Point a = new Point(1, 1);
		Point b = new Point(1, 1);
		Point c = new Point(1, 1);
		Triangle t = new Triangle(a, b, c);
		double result = t.area();
		assertThat(result, closeTo(-1, 0.1));
	}
}
