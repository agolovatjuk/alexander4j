package ru.job4j.departmentsort;

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class DepartmentListTest {
    @Test
    public void whenAddDepartmentThen(){
        DepartmentList dp = new DepartmentList();
        Department[] d = new Department[2];
        String result, expected;

        d[0] = new Department("K1\\SK2");
        d[1] = new Department("K1\\SK1");
        for (Department department: d) {
            dp.addDepartment(department);
        }

        final String line = System.getProperty("line.separator");
        result = dp.getSort();
        expected = String.format("K1%1$sK1\\SK1%1$sK1\\SK2%1$s", line);
        assertThat(result, is(expected));

        result = dp.getReverse();
        expected = String.format("K1%1$sK1\\SK2%1$sK1\\SK1%1$s", line);
        assertThat(result, is(expected));
    }

    @Test
    public void whenSortThenReverseThen(){
        DepartmentList dp = new DepartmentList();
        Department[] d = new Department[7];
        String result, expected;

        d[0] = new Department("K1\\SK2");
        d[1] = new Department("K1\\SK1");
        d[2] = new Department("K1\\SK1\\SSK1");
        d[3] = new Department("K1\\SK1\\SSK2");
        d[4] = new Department("K2");
        d[5] = new Department("K2\\SK1\\SSK1");
        d[6] = new Department("K2\\SK1\\SSK2");

        for (Department department: d) {
            dp.addDepartment(department);
        }

        final String line = System.getProperty("line.separator");
        result = dp.getSort();
        expected = String.format("K1%1$sK1\\SK1%1$sK1\\SK1\\SSK1%1$sK1\\SK1\\SSK2%1$sK1\\SK2%1$s" +
                "K2%1$sK2\\SK1%1$sK2\\SK1\\SSK1%1$sK2\\SK1\\SSK2%1$s", line);
        assertThat(result, is(expected));

        result = dp.getReverse();
        expected = String.format("K2%1$sK2\\SK1%1$sK2\\SK1\\SSK2%1$sK2\\SK1\\SSK1%1$s" +
                "K1%1$sK1\\SK2%1$sK1\\SK1%1$sK1\\SK1\\SSK2%1$sK1\\SK1\\SSK1%1$s", line);
        assertThat(result, is(expected));
    }
}
