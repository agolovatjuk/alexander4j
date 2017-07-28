package ru.job4j.control;

/**.
 * check Point
 * @author Alexander Golovatyuk
 * @version $Id$
 * @since 0.1
 */
public class ContainsString {
    /**.
     * @param origin - test string
     * @param sub  - pattern
     * @return result boolean
     */
    public boolean contains(String origin, String sub) {
        char[] chOrig = origin.toCharArray();
        char[] chSub  = sub.toCharArray();
        boolean result = false;

        for (int i = 0; i < origin.length() && !result; i++) {
            if (chOrig[i] == chSub[0]) {
                result = true;
                for (int j = 0; j < sub.length() && result; i++, j++) {
                    if (i == origin.length() || chOrig[i] != chSub[j]) {
                        result = false;
                    }
                }
            }
        }
        return result;
    }
}
