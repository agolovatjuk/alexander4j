package ru.job4j.banktransfer;

import java.util.Objects;

public class Account {
    private double value = 0;
    private String requisites;

    public Account(String requisites) {
        this.requisites = requisites;
    }

    public Account(double value, String requisites) {
        this.value = value;
        this.requisites = requisites;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getRequisites() {
        return requisites;
    }

    public void setRequisites(String requisites) {
        this.requisites = requisites;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return Objects.equals(requisites, account.requisites);
    }

    @Override
    public int hashCode() {
        return Objects.hash(requisites);
    }

    @Override
    public String toString() {
        return "Account{" + "value=" + value + ", requisites='" + requisites + '\'' + '}';
    }
}
