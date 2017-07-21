package ru.job4j.loop;


/**.
 * Board chess
 * @author
 * @version $Id$
 * @since
 */
public class Board {
    /**.
     * @param height int
     * @param width int
     * @return string
     */
    public String paint(int width, int height) {
        boolean flag = true;
        final String linesep = System.getProperty("line.separator");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (flag) {
                    sb.append('x');
                } else {
                    sb.append(' ');
                }
                flag = !flag;
            }
            sb.append(linesep);
        }
        return sb.toString();
    }
}

