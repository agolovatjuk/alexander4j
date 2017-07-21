package ru.job4j.loop;


/**.
 * class for sum evens
 * @author
 * @version $Id$
 * @since 0.1
 */
public class Counter {

    /**.
     * add evens
     * @param start int
     * @param finish int
     * @return result
     */
    public int add(int start, int finish) {
        int result = 0;

        for (int i = start; i <= finish; i++) {
            if (i % 2 == 0) {
                result += i;
            }
        }
        return result;
    }
}

