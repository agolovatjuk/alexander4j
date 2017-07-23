package ru.job4j.array;


/**.
 * @author
 * @version $Id$
 * @since 0.1
 */
public class BubbleSort {
    /**.
     * Selection sort array m in place (Bubble sort)
     * @param m int[]
     * @return m
     */
    public int[] sort(int[] m) {
        int tmp;
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m.length; j++) {
                if (m[i] < m[j]) {
                    tmp = m[i];
                    m[i] = m[j];
                    m[j] = tmp;
                }
            }
        }
        return m;
    }
}
