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
		// double expected = 2D;
		assertThat(result, closeTo(2.0, 0.1));
	}
}
