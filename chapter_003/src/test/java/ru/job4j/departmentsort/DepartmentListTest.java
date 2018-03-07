package ru.job4j.departmentsort;

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class DepartmentListTest {
    @Test
    public void whenAddDepartmentThen() {
        DepartmentList dp = new DepartmentList();
        Department[] d = {
                new Department("K1\\SK2"),
                new Department("K1\\SK1")
        };

        for (Department department: d) {
            dp.addDepartment(department);
        }

        final String line = System.getProperty("line.separator");
        assertThat(dp.getSort(), is(String.format("K1%1$sK1\\SK1%1$sK1\\SK2%1$s", line)));
        assertThat(dp.getReverse(), is(String.format("K1%1$sK1\\SK2%1$sK1\\SK1%1$s", line)));
    }

    @Test
    public void whenSortThenReverseThen() {
        DepartmentList dp = new DepartmentList();
        Department[] d = {
                new Department("K1\\SK2"),
                new Department("K1\\SK1"),
                new Department("K1\\SK1\\SSK1"),
                new Department("K1\\SK1\\SSK2"),
                new Department("K2"),
                new Department("K2\\SK1\\SSK1"),
                new Department("K2\\SK1\\SSK2"),
        };

        for (Department department: d) {
            dp.addDepartment(department);
        }

        final String line = System.getProperty("line.separator");

        assertThat(dp.getSort(), is(String.format("K1%1$sK1\\SK1%1$sK1\\SK1\\SSK1%1$sK1\\SK1\\SSK2%1$sK1\\SK2%1$s"
                + "K2%1$sK2\\SK1%1$sK2\\SK1\\SSK1%1$sK2\\SK1\\SSK2%1$s", line)));

        assertThat(dp.getReverse(), is(String.format("K2%1$sK2\\SK1%1$sK2\\SK1\\SSK2%1$sK2\\SK1\\SSK1%1$s"
                + "K1%1$sK1\\SK2%1$sK1\\SK1%1$sK1\\SK1\\SSK2%1$sK1\\SK1\\SSK1%1$s", line)));
    }
}
