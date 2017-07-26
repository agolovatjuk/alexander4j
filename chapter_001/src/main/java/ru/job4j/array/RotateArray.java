package ru.job4j.array;

/**.
 * @author
 * @version $Id$
 * since 0.1
 */
public class RotateArray {
    /**.
     * rotate matrix 90 degrees right
     * @param array int[][]
     * @return array
     */
    public int[][] rotate(int[][] array) {
        int leftUp, leftDown, rightUp, rightDown;

        for (int i = 0; i < array.length / 2; i++) {
            for (int j = i; j < array.length - i - 1; j++) {
                leftUp    = array[i][j];
                rightUp   = array[j][array.length - i - 1];
                rightDown = array[array.length - i - 1][array.length - j - 1];
                leftDown  = array[array.length - j - 1][i];

                array[i][j] = leftDown;
                array[array.length - j - 1][i] = rightDown;
                array[array.length - i - 1][array.length - j - 1] = rightUp;
                array[j][array.length - i - 1] = leftUp;
            }
        }
        return array;
    }
}
