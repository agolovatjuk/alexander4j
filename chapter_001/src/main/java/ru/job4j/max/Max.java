package ru.job4j.max;

/**.
 * class Max
 * @author
 * @version $Id$
 * @since 0.1
 */
public class Max {
    /**.
     * Max method
     * @param first first arg
     * @param second second arg
     * @return max of first and second
     */
    public int max(int first, int second) {
        return first > second ? first : second;
    }

    /**.
     * Max method from three digits
     * @param first first arg
     * @param second second arg
     * @param third  third arg
     * @return max of first, second and third
     */
    public int max(int first, int second, int third) {
        return max(max(first, second), third);
    }
}
