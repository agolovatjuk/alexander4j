package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**.
 * class for selection sort array (Bubble sort)
 * @author
 * @version $Id$
 * @since 0.1
 */
public class BubbleSortTest {
    /**.
     * test {1, 2, 3, 4, 5} to {5, 4, 3, 2, 1}
     */
    @Test
    public void whenOddOfElementsThen() {
        BubbleSort t = new BubbleSort();
        int[] m = new int[] {5, 1, 2, 7, 3};
        int[] r = t.sort(m);
        int[] expected = new int[] {1, 2, 3, 5, 7};
        assertThat(r, is(expected));
    }
    /**.
     * test {2, 1, 4, 3} to {1, 2, 3, 4}
     */
    @Test
    public void whenEvenOfElementsThen() {
        BubbleSort t = new BubbleSort();
        int[] m = new int[] {2, 1, 4, 3};
        int[] r = t.sort(m);
        int[] expected = new int[] {1, 2, 3, 4};
        assertThat(r, is(expected));
    }
}
