package ru.job4j.collectiontest;

class User {
    private int id;
    private String name;
    private String city;

    User(int id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }

    public int getId() {
        return this.id;
    }

    @Override
    public String toString() {
        return String.format("Id:%d, Name:%s, City:%s", this.id, this.name, this.city);
    }

}
