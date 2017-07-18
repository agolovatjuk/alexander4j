package ru.job4j.condition;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**.
 * test class Point
 * @author
 * @version $Id$
 * @since 0.1
 */
public class PointTest {
    /**.
     * test the point is on line
     */
    @Test
    public void whenPointOnLineThenTrue() {
        Point p = new Point(2, 5);
        boolean result = p.is(2, 1);
        assertThat(result, is(true));
    }

    /**.
     * test the point is not on line
     */
    @Test
    public void whenPointNotLineThenFalse() {
        Point p = new Point(2, 5);
        boolean result = p.is(2, 10);
        assertThat(result, is(false));
    }
}

