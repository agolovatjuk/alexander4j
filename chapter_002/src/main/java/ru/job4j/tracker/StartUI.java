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
    private Input input;
    /**.
     *
     */
    private Tracker tracker;
    /**.
     *
     */
    private int[] range;

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
        Input input = new ValidateInput();
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

        int acts = menu.getActions().length;
        range = new int[acts];

        for (int i = 0; i < acts; i++) {
            range[i] = i;
        }

        do {
            menu.show();
            answer = Integer.valueOf(input.ask("Select:", range));
            menu.select(answer);
        } while (answer != 6);
        System.out.println("Good bye!");
    }
}
