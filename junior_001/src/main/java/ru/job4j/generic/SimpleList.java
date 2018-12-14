package ru.job4j.generic;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class SimpleList<T> {

    T[] data;
    int size = 0;

    T paramNewClassT;

    public SimpleList(int n) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        data = (T[]) new Object[n];

        // 1
        Type[] type = ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments();
        Class<T> t2 = (Class<T>) type[0];
        T val = t2.newInstance();

        // 1.1 or ... the same
        String tName = type[0].getTypeName();
        T val2 = (T) Class.forName(tName).newInstance();

        // 2
        Class<T> tClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        T value = tClass.newInstance();

        paramNewClassT = value;
    }

    public T getNewClassT() {
        return paramNewClassT;
    }

    public void push(T item) {
        data[size++] = item;
    }

    public T pop() {
        T tmp = data[--size];
        data[size] = null;
        return tmp;
    }

    public int size() {
        return size;
    }

//    public static void main(String[] args) throws IllegalAccessException, ClassNotFoundException, InstantiationException {
//        Stack array = new Stack(10);
//        array.push("one");
//        array.push("two");
//    }

}

class Stack extends SimpleList<String> {

    Stack(int n) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        super(n);
    }

//    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
//        Stack array = new Stack(10);
//        array.push("First");
//        array.push("Second");
//        System.out.println(array.pop());
//        System.out.println(array.pop());
//        Integer[] a = (Integer[]) array.data;
//        System.out.println(a);
//    }
}
