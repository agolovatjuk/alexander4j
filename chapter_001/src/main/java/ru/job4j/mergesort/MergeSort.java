package ru.job4j.mergesort;

/**.
 * class Merge sorted arrays
 * @author
 * @version $Id$
 * @since 0.1
 */
public class MergeSort {
    /**.
     * @param left sorted array
     * @param right sorted array
     * @param aux merged sorted array of a & b
     */
    public void mergesort(int[] left, int[] right, int[] aux) {
        int i = 0; int j = 0;

        for (int k = 0; k < aux.length; k++) {
            if (i >= left.length) {
                aux[k] = right[j++];
            } else if (j >= right.length) {
                aux[k] = left[i++];
            } else if (left[i] < right[j]) {
                aux[k] = left[i++];
            } else {
                aux[k] = right[j++];
            }
        }
    }

//    public static void main(String[] args) {
//        MergeSort m = new MergeSort();
//        int[] a = {1,2,3};
//        int[] b = {4,5,6,7};
//        int[] aux = new int[a.length + b.length];
//        m.mergesort(a, b, aux);
//        for (int x :
//                aux) {
//            System.out.print(x);
//        }
//    }
}
