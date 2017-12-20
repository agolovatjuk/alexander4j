package ru.job4j.collectiontest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class ConvertListTest {

    @Test
    public void whenToArray() {
        /**.
         *        (1,2,3,4,5,6,7) => {{1, 2, 3} {4, 5, 6} {7, 0 ,0}}
         */
        ConvertList cl = new ConvertList();
        int[][] data;
        int[][] expected;

        List<Integer> alist = new ArrayList<>();
        for (int i = 1; i < 8; i++) {
            alist.add(i);
        }

        data = cl.toArray(alist, 2);
        expected = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 0}};
        assertThat(data, is(expected));

        data = cl.toArray(alist, 3);
        expected = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 0, 0}};
        assertThat(data, is(expected));

        data = cl.toArray(alist, 4);
        expected = new int[][]{{1, 2}, {3, 4}, {5, 6}, {7, 0}};
        assertThat(data, is(expected));
    }

    @Test
    public void whenToList() {
//        {{1, 2, 3} {4, 5, 6} {7}} => (1,2,3,4,5,6,7)
        int[][] data;
        Integer[] tmp = {1, 2, 3, 4, 5, 6, 7};
        List<Integer> expected = new ArrayList<>(Arrays.asList(tmp));

        ConvertList cl = new ConvertList();

        data = new int[][]{{1, 2}, {3, 4}, {5, 6}, {7}};
        assertThat(cl.tolist(data), is(expected));

        data = new int[][]{{1, 2, 3}, {4, 5, 6}, {7}};
        assertThat(cl.tolist(data), is(expected));

        data = new int[][]{{1, 2, 3, 4}, {5, 6, 7}};
        assertThat(cl.tolist(data), is(expected));
    }

    @Test
    public void whenConvertToList() {
        List<int[]> list = new ArrayList<>();
        list.add(new int[]{1, 2});
        list.add(new int[]{3, 4, 5, 6});

        ConvertList convertList = new ConvertList();
        List<Integer> result = convertList.convert(list);
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5, 6);

        assertThat(result, equalTo(expected));
    }
}
