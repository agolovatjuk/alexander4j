package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**.
 * class for test rotate matrix 90 degrees right
 * @author
 * @version $Id$
 * @since 0.1
 */
public class RotateArrayTest {
    /**.
     * Test matrix 2x2
     */
    @Test
    public void whenArrayTwoByTwoThen() {
        int[][] array = {{1, 2}, {3, 4}};
        int[][] expected = {{3, 1}, {4, 2}};
        RotateArray rarray = new RotateArray();
        array = rarray.rotate(array);
        for (int i = 0; i < expected.length; i++) {
            for (int j = 0; j < expected.length; j++) {
                assertThat(array[i][j], is(expected[i][j]));
            }
        }
    }
    /**.
     * Test matrix 3x3
     */
    @Test
    public void whenArrayTreeByTreeThen() {
        int[][] array = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] expected = {{7, 4, 1}, {8, 5, 2}, {9, 6, 3}};
        RotateArray rarray = new RotateArray();
        array = rarray.rotate(array);
        for (int i = 0; i < expected.length; i++) {
            for (int j = 0; j < expected.length; j++) {
                assertThat(array[i][j], is(expected[i][j]));
            }
        }
    }
}
