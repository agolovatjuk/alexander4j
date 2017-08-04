package ru.job4j.mergesort;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**.
 * class for test mergesort
 * @author
 * @version $id$
 * @since 0.1
 */
public class MergeSortTest {
    /**.
     * test merge two sorted arrays
     */
    @Test
    public void whenTwoSortedArraysThen() {
        MergeSort m = new MergeSort();
        int[] a = {1, 3, 5, 7};
        int[] b = {2, 4, 6};
        int[] aux = new int[a.length + b.length];
        m.mergesort(a, b, aux);
        int[] expected = {1, 2, 3, 4, 5, 6, 7};
        assertThat(aux, is(expected));
    }
}
