package ru.job4j.sorting;

public class User implements Comparable<User> {
    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format("%s: %d", this.name, this.age);
    }

    @Override
    public int compareTo(User o) {
        return Integer.compare(this.age, o.age);
    }
}
