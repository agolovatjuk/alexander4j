package ru.job4j.array;


/**.
 * @author
 * @version $Id$
 * @since 0.1
 */
public class Turn {
    /**.
     * revert array m in place
     * @param m int[]
     * @return m
     */
    public int[] back(int[] m) {
        for (int i = 0; i < m.length / 2; i++) {
            int tmp = m[i];
            m[i] = m[m.length - i - 1];
            m[m.length - i - 1] = tmp;
        }
        return m;
    }
}
