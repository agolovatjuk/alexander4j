package ru.job4j.tracker;

/**.
 *
 */
public abstract class BaseAction implements UserAction {
    /**.
     *
     * @return int
     */
    public abstract int key();

    /**.
     *
     * @param input INput
     * @param tracker Tracker
     */
    public abstract void execute(Input input, Tracker tracker);

    /**.
     *
     * @return String
     */
    public String info() {
        return String.format("not realized");
    }
}
