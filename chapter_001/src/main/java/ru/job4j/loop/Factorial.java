package ru.job4j.loop;


/**.
 * Factorial
 * @author
 * @version
 * @since 0.1
 */
public class Factorial {
    /**.
     * calc
     * @param n int
     * @return factorial
     */
    public int calc(int n) {
        int result = 1;
        if (n == 0 || n == 1) {
            result = 1;
        }
        for (int i = 1; i <= n; i++) {
            result = result * i;
        }
        return result;
    }
}
