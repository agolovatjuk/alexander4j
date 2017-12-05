package ru.job4j.collectiontest;

import java.time.Clock;
import java.util.*;

public class CollectionTest {
    private String[] data;

    CollectionTest() {
    }

    public long add(Collection<String> collection, int amount) {
        Clock clock = Clock.systemUTC();
        Random r = new Random();
        this.data = new String[amount];
        for (int i = 0; i < this.data.length; i++) {
            this.data[i] = String.valueOf(r.nextInt());
        }
        long t = clock.millis();
        for (String s: this.data) {
            collection.add(s);
        }
//        this.data.addAll(Arrays.asList(testdata));
        return clock.millis() - t;
    }

    public long delete(Collection<String> collection, int amount) {
        String[] idx = new String[amount];
        System.arraycopy(this.data, 0, idx, 0, amount);
//        Random r = new Random();
//        for (int i = 0; i < amount; i++) {
//            idx[i] = r.nextInt(this.data.length);
//        }

        Clock clock = Clock.systemUTC();
        long t = clock.millis();
        for (int i = 0; i < amount; i++) {
//            collection.remove(this.data[idx[i]]);
            collection.remove(idx[i]);
        }
        return clock.millis() - t;
    }

    public static void main(String[] args) {
        int nAdd = 400000;
        int nDel = 4000;
        CollectionTest tc = new CollectionTest();

        LinkedList<String> lstr = new LinkedList<>();
        ArrayList<String>  astr = new ArrayList<>();
        TreeSet<String>    tstr = new TreeSet<>();

        System.out.println("\nTest LinkedList");
        System.out.printf("Add %d elapsed time, msec: %d", nAdd, tc.add(lstr, nAdd));
        System.out.printf("  Del %d elapsed time, msec: %d", nDel, tc.delete(lstr, nDel));
        System.out.println("\nTest TreeSet");
        System.out.printf("Add %d elapsed time, msec: %d", nAdd, tc.add(tstr, nAdd));
        System.out.printf("  Del %d elapsed time, msec: %d", nDel, tc.delete(tstr, nDel));
        System.out.println("\nTest ArrayList");
        System.out.printf("Add %d elapsed time, msec: %d", nAdd, tc.add(astr, nAdd));
        System.out.printf("  Del %d elapsed time, msec: %d", nDel, tc.delete(astr, nDel));
    }
}
