package ru.job4j.loop;

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**.
 *
 */
public class PaintTest {
    /**.
     *
     */
    @Test
    public void whenPiramidWithHeightTwoThenStringWithTwoRows() {
        Paint paint = new Paint();
        String result = paint.piramid(2);
        String linesep = System.getProperty("line.separator");
        String expected = String.format(" ^ %s^^^%s", linesep, linesep);
        assertThat(result, is(expected));
    }

   /**.
    *
    */
   @Test
   public void whenPiramidWithHeightThreeThenStringWithThreeRows() {
      //напишите здесь тест, проверяющий формирование пирамиды для высоты 3.
        Paint paint = new Paint();
        String result = paint.piramid(3);
        String linesep = System.getProperty("line.separator");
        String expected = String.format("  ^  %s ^^^ %s^^^^^%s", linesep, linesep, linesep);
        assertThat(result, is(expected));
   }
}