package ru.job4j.map;

import java.util.Calendar;
import java.util.GregorianCalendar;


public class User {
    String name;
    int children;
    Calendar birthday;

    public User(String name, int children, int[] bd) {
        this.name = name;
        this.children = children;
        this.birthday = new GregorianCalendar(bd[0], bd[1] - 1, bd[2]);
    }
}
