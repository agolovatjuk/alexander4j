package ru.job4j.strategy;

/**.
 *
 */
public class Square implements Shape {
    /**.
     *
     * @return
     */
    @Override
    public String pic() {
        StringBuilder sb = new StringBuilder();
        sb.append("***\n");
        sb.append("* *\n");
        sb.append("***\n");
        return sb.toString();
    }
}
