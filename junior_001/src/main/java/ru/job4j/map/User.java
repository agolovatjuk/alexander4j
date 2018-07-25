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

class UserWithHashCode extends User {

    UserWithHashCode(String name, int children, int[] bd) {
        super(name, children, bd);
    }

    @Override
    public int hashCode() {
        return this.name.hashCode();
    }
}

class UserWithEquals extends User {

    UserWithEquals(String name, int children, int[] bd) {
        super(name, children, bd);
    }

    @Override
    public boolean equals(Object obj) {
        UserWithEquals u = (UserWithEquals) obj;
        return this.name.equals(u.name);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}