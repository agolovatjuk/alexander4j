package ru.job4j.max;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**.
 * class for test max
 * @author
 * @version $Id$
 * @since 0.1
 */
public class MaxTest {
    /**.
     * test 1 and 2
     */
    @Test
    public void whenFirstLessSecond() {
        Max maxim = new Max();
        int result = maxim.max(1, 2);
        assertThat(result, is(2));
	}

    /**.
     * test 2 and 1
     */
    @Test
    public void whenSecondLessFirst() {
        Max maxim = new Max();
        int result = maxim.max(2, 1);
        assertThat(result, is(2));
	}

    /**.
     * test 3,  2 and 1
     */
    @Test
    public void whenThreeArgsThirdLessSecondLessFirst() {
        Max maxim = new Max();
        int result = maxim.max(3, 2, 1);
        assertThat(result, is(3));
	}

    /**.
     * test 3,  1 and 2
     */
    @Test
    public void whenThreeArgsSecondLessThirdLessFirst() {
        Max maxim = new Max();
        int result = maxim.max(3, 1, 2);
        assertThat(result, is(3));
	}

    /**.
     * test 1,  2 and 3
     */
    @Test
    public void whenThreeArgsFirstLessSecondLessThird() {
        Max maxim = new Max();
        int result = maxim.max(1, 2, 3);
        assertThat(result, is(3));
	}
}
