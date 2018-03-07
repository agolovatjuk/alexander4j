package ru.job4j.converter;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Converter {

    Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
        return new Iterator<Integer>() {

            private Iterator<Integer> itCurrent = it.next();

            @Override
            public boolean hasNext() {
                boolean result = true;

                while (!itCurrent.hasNext()) {
                    if (!it.hasNext()) {
                        result = false;
                        break;
                        }
                    itCurrent = it.next();
                    }
                return result;
            }

            @Override
            public Integer next() {
                if (!hasNext()) { // no next Integer
                    throw new NoSuchElementException();
                }
                return itCurrent.next();
            }
        };
    }
}
