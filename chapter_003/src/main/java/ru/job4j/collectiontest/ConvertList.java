package ru.job4j.collectiontest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ConvertList {

    public List<Integer> tolist(int[][] array) {
//        {{1, 2, 3} {4, 5, 6} {7, 0 ,0}} => (1,2,3,4,5,6,7)
        List<Integer> lst = new ArrayList<>();

        for (int x[]: array) {
            for (int i: x) {
                lst.add(i);
            }
        }
        return lst;
    }

    public int[][] toArray(List<Integer> list, int rows) {
//        (1,2,3,4,5,6,7) => {{1, 2, 3} {4, 5, 6} {7, 0 ,0}}
        int cols = list.size()/rows;
        int rem  = list.size() % rows;
        cols = (rem > 0) ? cols + 1 : cols;

        int cnt = 0;
        int[][] a = new int[rows][cols];

        for (int x: list) {
            a[cnt / cols][cnt++ % cols] = x;
//            cnt++;
        }
        return a;
    }

    private void test(List<Integer> alist, int rows) {
        int[][] a = toArray(alist, rows);
        for (int x[]: a) {
            System.out.printf("%s ", Arrays.toString(x));
        }
        System.out.printf("\n%s\n\n", tolist(a));
    }

    public static void main(String[] args) {
        ConvertList cl = new ConvertList();

        List<Integer> alist = new ArrayList<>();
        for (int i = 1; i < 8; i++) {
            alist.add(i);
        }

        System.out.printf("Initial array: %s\n\n", alist);

        cl.test(alist, 2);
        cl.test(alist, 3);
        cl.test(alist, 4);
    }
}
