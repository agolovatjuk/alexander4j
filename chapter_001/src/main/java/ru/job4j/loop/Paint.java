package ru.job4j.loop;

/**.
 * Pyramid Painter
 * @author
 * @version
 * @since
 */
public class Paint {
    /**.
     * @param h int
     * @return string
     */
    public static String piramid(int h) {
//        int h = 4;
        StringBuilder sb = new StringBuilder();
        final String linesep = System.getProperty("line.separator");

        for (int i = 0; i < h; i++) {
            // left
            for (int j = 0; j < h - i - 1; j++) {
                sb.append(' ');
            }
            // center
            for (int j = 0; j < 2 * i + 1; j++) {
                sb.append('^');
            }
            // right
            for (int j = 0; j < h - i - 1; j++) {
                sb.append(' ');
            }
            // end
            sb.append(linesep);
        }
        return sb.toString();
    }
}
