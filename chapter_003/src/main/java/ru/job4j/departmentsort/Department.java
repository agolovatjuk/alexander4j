package ru.job4j.departmentsort;

public class Department implements Comparable<Department> {

    public String code;

    public Department(String code) {
        this.code = code;
    }

    @Override
    public int compareTo(Department o) {
        return this.code.compareTo(o.code);
    }
}
