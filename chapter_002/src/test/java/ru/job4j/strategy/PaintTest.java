package ru.job4j.strategy;

import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**.
 *
 */
public class PaintTest {
    /**.
     *
     */
    @Test
    public void whenPaintTriangleThen() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        new Paint().draw(new Triangle());
        assertThat(out.toString(), is(String.format("  *  \n *** \n*****\n", System.getProperty("line.separator"))));
    }
    /**.
     *
     */
    @Test
    public void whenPaintSquareThen() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        new Paint().draw(new Square());
        assertThat(out.toString(), is(String.format("***\n* *\n***\n", System.getProperty("line.separator"))));
    }
}
