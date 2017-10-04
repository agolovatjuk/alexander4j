package ru.job4j.tracker;

/** -
0. Add new Item
1. Show all items
2. Edit item
3. Delete item
4. Find item by Id
5. Find items by name
6. Exit Program
Select:
 */
public class StartUI {
    /**.
     *
     */
    private static final int ADD = 0;
    /**.
     *
     */
    private static final int SHOW = 1;
    /**.
     *
     */
    private static final int EDIT = 2;
    /**.
     *
     */
    private static final int DELETE = 3;
    /**.
     *
     */
    private static final int FINDBYID = 4;
    /**.
     *
     */
    private static final int FINDBYNAME = 5;
    /**.
     *
     */
    private static final int EXIT = 6;
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
     * @param tracker Tracker
     * @param input Input
     */
    public StartUI(Tracker tracker, Input input) {
        this.tracker = tracker;
        this.input = input;
    }
    /**.
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        Tracker tracker = new Tracker();
        Input input = new ConsoleInput();
        StartUI ui = new StartUI(tracker, input);
        ui.init();
    }
    /**.
     *
     */
    public void init() {
        int answer = 6;
        MenuTracker menu = new MenuTracker(this.input, this.tracker);
        menu.fillActions();

        do {
            menu.show();
            answer = Integer.parseInt(input.ask("Select:"));
            menu.select(answer);
        } while (answer != 6);
        System.out.println("Good bye!");
    }
}
