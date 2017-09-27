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
     * @param data String
     */
    void print(String data);
}
