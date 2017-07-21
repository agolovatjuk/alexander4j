package ru.job4j.loop;

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**.
 * @author
 * @version $Id$
 * @since
 */
public class CounterTest {
    /**.
     * Test sequence of evens 0, 10
     */
    @Test
    public void whenSeqFromZeroToTenThen() {
        Counter cnt = new Counter();
        int result = cnt.add(0, 10);
        assertThat(result, is(30));
    }
}

