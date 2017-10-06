package ru.job4j.tracker;

/**.
 *
 */
public interface Input {
    /**.
     *
     * @param question String
     * @return answer
     */
    String ask(String question);

    /**.
     *
     * @param question String
     * @param range int[]
     * @return int
     */
    int ask(String question, int[] range);

    /**.
     *
     * @param data String
     */
    void print(String data);
}
