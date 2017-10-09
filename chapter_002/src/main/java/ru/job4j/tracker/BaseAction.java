package ru.job4j.tracker;

/**.
 *
 */
public abstract class BaseAction implements UserAction {
    /**.
     *
     */
    private String name;
    /**.
     *
     */
    private int k;

    /**
     *
     * @param name String
     * @param key int
     */
    public BaseAction(String name, int key) {
        this.name = name;
        this.k = key;
    }
    /**.
     *
     * @return int
     */
    public int key() {
        return this.k;
    }

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
        return String.format("%s, %s", this.k, this.name);
    }
}
