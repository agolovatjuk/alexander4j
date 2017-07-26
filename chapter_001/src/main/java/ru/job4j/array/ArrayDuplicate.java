package ru.job4j.array;
import java.util.Arrays;

/**.
 * Delete duplicates
 * @author
 * @version $Id$
 * @since 0.1
 */
public class ArrayDuplicate {
    /**.
     * remove duplicates in array
     * @param array String[]
     * @return array
     */
    public String[] remove(String[] array) {
        int cnt = 0;
        String tmp;
        for (int i = 0; i < array.length - cnt; i++) {
            for (int j = i + 1; j < array.length - cnt; j++) {
                if (array[i].equals(array[j])) {
                    for (int k = j; k < array.length - cnt - 1; k++) {
                        tmp = array[k + 1];
                        array[k + 1] = array[k];
                        array[k] = tmp;
                    }
                    cnt++;
                }
            }
        }
        return Arrays.copyOf(array, array.length - cnt);
    }
}
