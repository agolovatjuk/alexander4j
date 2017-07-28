package ru.job4j.control;

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**.
 * Board test
 * @author
 * @version $Id$
 * @since
 */
public class ContainsStringTest {
    /**.
     * test if string "Привет" contains "иве"
     */
     @Test
     public void whenStringContainsThen() {
        ContainsString containsString = new ContainsString();
        boolean result = containsString.contains("Привет", "иве");
        boolean expected = true;
        assertThat(result, is(expected));
     }
    /**.
     * test if string "Привет" not contains "abc"
     */
     @Test
     public void whenStringNotContainsThen() {
        ContainsString containsString = new ContainsString();
        boolean result = containsString.contains("Привет", "abc");
        boolean expected = false;
        assertThat(result, is(expected));
     }
    /**.
     * test if string "Привет" not contains "вето"
     */
     @Test
     public void whenStringLongNotContainsThen() {
        ContainsString containsString = new ContainsString();
        boolean result = containsString.contains("Привет", "вето");
        boolean expected = false;
        assertThat(result, is(expected));
     }
}
