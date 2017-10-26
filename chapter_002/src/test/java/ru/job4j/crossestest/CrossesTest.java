package ru.job4j.crossestest;

import org.junit.Test;
import ru.job4j.crosses.Crosses;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CrossesTest {

    @Test
    public void whenCrossHorizWin() {
        boolean win;
        Crosses c = new Crosses(10);
        win = c.putA(1, 1, 'X');
        assertThat(win, is(false));
        win = c.putA(1, 2, 'X');
        assertThat(win, is(false));
        win = c.putA(1, 3, 'Y');
        assertThat(win, is(false));
        win = c.putA(1, 0, 'X');
        assertThat(win, is(true));
    }

    @Test
    public void whenCrossVertWin() {
        boolean win;
        Crosses c = new Crosses(10);
        win = c.putA(1, 1, 'X');
        assertThat(win, is(false));
        win = c.putA(2, 1, 'X');
        assertThat(win, is(false));
        win = c.putA(3, 1, 'X');
        assertThat(win, is(true));
    }

    @Test
    public void whenCrossLine45Win() {
        boolean win;
        Crosses c = new Crosses(10);
        win = c.putA(1, 1, 'X');
        assertThat(win, is(false));
        win = c.putA(2, 2, 'X');
        assertThat(win, is(false));
        win = c.putA(3, 3, 'X');
        assertThat(win, is(true));
    }

    @Test
    public void whenCrossLine135Win() {
        boolean win;
        Crosses c = new Crosses(10);
        win = c.putA(1, 3, 'X');
        assertThat(win, is(false));
        win = c.putA(2, 2, 'X');
        assertThat(win, is(false));
        win = c.putA(3, 1, 'X');
        assertThat(win, is(true));
    }
}
