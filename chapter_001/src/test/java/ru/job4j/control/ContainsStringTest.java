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
        boolean expexted = true;
        assertThat(expexted, is(containsString.contains("Привет", "иве")));
     }
    /**.
     * test if string "Привет" not contains "abc"
     */
     @Test
     public void whenStringNotContainsThen() {
        ContainsString containsString = new ContainsString();
        boolean expexted = false;
        assertThat(expexted, is(containsString.contains("Привет", "abc")));
     }
}