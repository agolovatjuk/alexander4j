package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**.
 * Test remove duplicates
 * @author
 * @version $Id$
 * @since 0.1
 */
public class ArrayDuplicateTest {
    /**.
     * remove duplicates
     */
    @Test
    public void whenRemoveDuplicatesThenArrayWithoutDuplicate() {
        String[] array = {"Привет", "Мир", "Привет", "Супер", "Мир"};
        String[] expected = {"Привет", "Мир", "Супер"};

        ArrayDuplicate arrdup = new ArrayDuplicate();
        array = arrdup.remove(array);
        assertThat(expected, is(array));
    }
}
