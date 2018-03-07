package ru.job4j.departmentsort;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class DepartmentList {
    private Set<String> depSet = new TreeSet<>();

    public void addDepartment(Department department) {
        if (department != null) {
            depSet.add(department.code);
            int idx = department.code.lastIndexOf("\\");
            if (idx != -1) {
                String parent = department.code.substring(0, idx);
                depSet.add(parent);
            }
        }
    }

    public String getSort() {
        StringBuffer sb = new StringBuffer(255);
        for (String code: depSet) {
            sb.append(code);
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }

    public String getReverse() {
        StringBuffer sb = new StringBuffer(255);
        Set<String> reverseTreeSet = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return  (o1.indexOf(o2) == 0) ? o1.compareTo(o2) : o2.compareTo(o1);
            }
        });
        reverseTreeSet.addAll(this.depSet);
        for (String code: reverseTreeSet) {
            sb.append(code);
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }
}
