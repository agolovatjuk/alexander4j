package ru.job4j.map;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.ConcurrentModificationException;
import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertNull;

public class UserHashMapTest {

    UserHashMap<String, String> userHashMap;

    @Before
    public void setUp() throws Exception {
         userHashMap = new UserHashMap<>(4);
    }

    @Test
    public void testWhenInsertAndResizeDueToLoadFactorThen() {
        userHashMap.insert("test1", "Data1");
        userHashMap.insert("test2", "Data2");
        userHashMap.insert("test3", "Data3");
        assertThat(userHashMap.table.length, is(4));
        userHashMap.insert("test4", "Data4");
        boolean res = userHashMap.insert("test5", "Data5");
        assertThat(userHashMap.table.length, is(8));
        assertThat(res, is(true));
    }

    @Test
    public void whenRemoveInBigChainThen() {
        int count = 100;
        boolean res;
        for (int i = 0; i < count; i++) {
            userHashMap.insert("Key_" + i, "Data_" + i);
        }
        res = userHashMap.resize(10, 10f); // shrink table, increase each bin
        assertThat(res, is(true));
        assertThat(userHashMap.size, is(count));
        for (int i = 0; i < count; i++) {
            userHashMap.remove("Key_" + i);
        }
        assertThat(userHashMap.size, is(0));
    }

    @Test
    public void whenGetThen() {
        int count = 100;
        UserHashMap<String, Integer> map = new UserHashMap<>();
        for (int i = 0; i < count; i++) {
            boolean res = map.insert("Key" + Integer.toString(i), i);
            assertThat(res, is(true));
        }
        for (int i = 0; i < map.size; i++) {
            Integer res = map.get("Key" + i);
            assertThat(res, is(i));
        }
        Integer resInt = map.get("No_data");
        assertNull(resInt);
    }

    @Test
    public void whenDeleteThen() {
        int count = 100;
        UserHashMap<Integer, String> map = new UserHashMap<>();
        for (int i = 0; i < count; i++) {
            boolean res = map.insert(i, "Data_" + i);
            assertThat(res, is(true));
        }
        assertThat(map.size, is(count));
        assertThat(map.delete(111111), is(false));
        int sz = map.size;
        for (int i = 0; i < sz; i++) {
            boolean resDel = map.delete(i);
            assertThat(resDel, is(true));
        }
        assertThat(map.size, is(0));
    }

    @Test
    public void whetIteratorsThen() {
        int count = 100;
        UserHashMap<String, String> map = new UserHashMap<>(10);
        for (int i = 0; i < count; i++) {
            boolean resIns = map.insert("Key_" + i, "Data_" + i);
            assertThat(resIns, is(true));
        }
        Iterator<String> ikey = map.getKeyIterator();
        while (ikey.hasNext()) {
            String k = ikey.next();
            String value = k.substring(3);
            assertThat(map.get(k), is("Data" + value));
        }
        Iterator<UserHashMap.Node<String, String>> ititems = map.getItemIterator();
        while (ititems.hasNext()) {
            UserHashMap.Node<String, String> node = ititems.next();
            assertThat(map.get(node.key), is(node.value));
            assertThat(node.toString(), is(node.key + ", " + node.value));
        }
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenEditIteratorThen() {
        userHashMap.insert("A", "Data_A");
        userHashMap.insert("B", "Data_B");
        Iterator<String> ikey = userHashMap.getKeyIterator();
        ikey.next();
        userHashMap.insert("C", "Data_C");
        ikey.next(); // ConcurrentModificationException
    }

    @Test(expected = NoSuchElementException.class)
    public void whenNoSuchElementThen() {
        userHashMap.insert("X001", "Secret");
        Iterator<String> ikey = userHashMap.getKeyIterator();
        ikey.next();
        ikey.next(); // NoSuchElementException
    }

    @Test
    public void whenMaxValIntegerResizeThen() {
        boolean res;
        int oldsize;
        oldsize = userHashMap.size;
        res = userHashMap.resize(Integer.MAX_VALUE);
        assertThat(res, is(false));
        assertThat(oldsize, is(userHashMap.size));
        oldsize = userHashMap.size;
        res = userHashMap.resize(Integer.MAX_VALUE, 0.75f);
        assertThat(res, is(false));
        assertThat(oldsize, is(userHashMap.size));
    }
}