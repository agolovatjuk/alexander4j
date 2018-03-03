package ru.job4j.departmentsort;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class DepartmentList {
    private Set<String> depSet = new TreeSet<>();

    public void addDepartment(Department department) {
        if (department == null) {
            return;
        }
        depSet.add(department.code);
        int idx = department.code.lastIndexOf("\\");
        if (idx != -1) {
            String parent = department.code.substring(0, idx);
            depSet.add(parent);
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

//    public static void main(String[] args) {
//        DepartmentList dp = new DepartmentList();
//        Department[] d = new Department[7];
//        d[0] = new Department("K1\\SK2");
//        d[1] = new Department("K1\\SK1");
//        d[2] = new Department("K1\\SK1\\SSK1");
//        d[3] = new Department("K1\\SK1\\SSK2");
//        d[4] = new Department("K2");
//        d[5] = new Department("K2\\SK1\\SSK1");
//        d[6] = new Department("K2\\SK1\\SSK2");
//        for (Department department: d) {
//            dp.addDepartment(department);
//        }
//
//        String s = dp.getReverse();
//        System.out.println(dp.getSort());
//        System.out.println(dp.getReverse());
//
//    }
}
