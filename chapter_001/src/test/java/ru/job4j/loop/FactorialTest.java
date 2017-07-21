package ru.job4j.loop;

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**.
 * class test factorial
 * @author
 * @version $Id$
 * @since 0.1
 */
public class FactorialTest {
    /**.
     * factorial of n
     */
    @Test
    public void whenSeqFromOneToTenThen() {
        Factorial factorial = new Factorial();
        int result = factorial.calc(10);
        assertThat(result, is(3628800));
        // int result = factorial.calc(5);
        // assertThat(result, is(120));
    }

    /**.
     * factorial of n
     */
    @Test
    public void whenSeqIsZeroThen() {
        Factorial factorial = new Factorial();
        int result = factorial.calc(0);
        assertThat(result, is(1));
    }

    /**.
     * factorial of n
     */
    @Test
    public void whenSeqIsOneThen() {
        Factorial factorial = new Factorial();
        int result = factorial.calc(1);
        assertThat(result, is(1));
    }
}
