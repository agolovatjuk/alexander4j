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
        do {
            showmenu();
            answer = Integer.parseInt(input.ask("Select:"));
            switch (answer) {
                case ADD:
                    additem();
                    break;
                case SHOW:
                    showall();
                    break;
                case EDIT:
                    edititem();
                    break;
                case DELETE:
                    deleteitem();
                    break;
                case FINDBYID:
                    finditembyid();
                    break;
                case FINDBYNAME:
                    finditembyname();
                    break;
                case EXIT:
                    break;
                default:
                    System.out.println("Don't understand, press 6 to exit");
                    break;
            }
        } while (answer != 6);
        System.out.println("Good bye!");
    }

    /**.
     *
     */
    private void edititem() {
        String id = input.ask("Enter item id:");
        Item item = tracker.findById(id);
        if (item != null) {
            String name = input.ask("Get new name:");
            String desc = input.ask("Get new description:");
            Item newitem = new Item(name, desc, 123L);
            newitem.setId(item.getId());
            tracker.update(newitem);
        } else {
            System.out.printf("%s: not found\n", id);
        }
    }

    /**.
     *
     */
    private void deleteitem() {
        String id = input.ask("Enter item id:");
        Item item = tracker.findById(id);
        if (item != null) {
            tracker.delete(item);
            System.out.println("Item deleted");
        } else {
            System.out.printf("%s: not found\n", id);
        }
    }

    /**.
     *
     */
    private void finditembyid() {
        String id = input.ask("Enter item key:");
        Item r = tracker.findById(id);
        if (r != null) {
            System.out.printf("%s, %s, %s\n", r.getId(), r.getName(), r.getDescription());
        } else {
            System.out.printf("%s: not found\n", id);
        }
    }

    /**.
     *
     */
    private void finditembyname() {
        String key = input.ask("Enter item name:");
        Item[] result = tracker.findByName(key);
        if (result[0] != null) {
            for (Item r: result) {
                System.out.printf("%s, %s, %s\n", r.getId(), r.getName(), r.getDescription());
            }
        } else {
            System.out.println("Not found");
        }
    }

    /**.
     *
     */
    private void additem() {
        String name = input.ask("Get new item name:");
        String desc = input.ask("Get description:");
        Item item = new Item(name, desc, 123L);
        tracker.add(item);
        System.out.println("New item added");
    }

    /**.
     *
     */
    private void showall() {
        Item[] result = tracker.findAll();
        for (Item r: result) {
            System.out.printf("%s, %s, %s\n", r.getId(), r.getName(), r.getDescription());
        }
    }

    /**.
     *
     */
    private void showmenu() {
        System.out.println("0. Add new item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by id");
        System.out.println("5. Find item by name");
        System.out.println("6. Exit");
    }
}
