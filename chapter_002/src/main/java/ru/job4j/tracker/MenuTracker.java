package ru.job4j.tracker;


/**.
 *
 */
public class MenuTracker {
    /**.
     *
     */
    private Input input;
    /**.
     *
     */
    private Tracker tracker;
    /**.
     *
     */
    private UserAction[] actions = new UserAction[7];
    /**.
     *
     */
    private int position = 0;
    /**.
     *
     * @param input Input
     * @param tracker Tracker
     */
    MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**.
     *
     * @param action UserAction
     */
    public void addAction(UserAction action) {
        actions[position++] = action;
    }
    /**.
     *
     * @return UserAction[]
     */
    public UserAction[] getActions() {
        return this.actions;
    }

    /**.
     *
     * @param key int
     */
    public void select(int key) {
        this.actions[key].execute(this.input, this.tracker);
    }

    /**.
     *
     */
    public void show() {
        for (UserAction entry: actions) {
            if (entry != null) {
                System.out.println(entry.info());
            }
        }
    }
}
