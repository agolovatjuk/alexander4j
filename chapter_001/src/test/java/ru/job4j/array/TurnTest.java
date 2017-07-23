package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**.
 * class for test array revert
 * @author
 * @version $Id$
 * @since 0.1
 */
public class TurnTest {
    /**.
     * test {1, 2, 3, 4, 5} to {5, 4, 3, 2, 1}
     */
    @Test
    public void whenOddOfElementsThen() {
        Turn t = new Turn();
        int[] m = new int[] {1, 2, 3, 4, 5};
        int[] r = t.back(m);
        int[] expected = new int[] {5, 4, 3, 2, 1};
        assertThat(r, is(expected));
    }
    /**.
     * test {2, 1, 4, 3} to {3, 4, 1, 2}
     */
    @Test
    public void whenEvenOfElementsThen() {
        Turn t = new Turn();
        int[] m = new int[] {2, 1, 4, 3};
        int[] r = t.back(m);
        int[] expected = new int[] {3, 4, 1, 2};
        assertThat(r, is(expected));
    }
}
