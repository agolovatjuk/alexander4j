package ru.job4j.tracker;
/**.
 *
 */
public interface UserAction {
    /**.
     *
     * @return int
     */
    int key();
    /**.
     *
     * @param input INput
     * @param tracker Tracker
     */
    void execute(Input input, Tracker tracker);
    /**.
     *
     * @return String
     */
    String info();
}
