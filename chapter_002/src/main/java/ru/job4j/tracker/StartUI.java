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

        UserAction addItem = new BaseAction() {
            @Override
            public int key() {
                return 0;
            }

            @Override
            public void execute(Input input, Tracker tracker) {
                String name = input.ask("Get new item name:");
                String desc = input.ask("Get description:");
                Task task = new Task(name, desc, 123L);
                tracker.add(task);
                System.out.println("New item added");
            }

            @Override
            public String info() {
                return String.format("%s, %s", this.key(), "Add new item");
            }
        };

        UserAction showItems = new BaseAction() {
            @Override
            public int key() {
                return 1;
            }

            @Override
            public void execute(Input input, Tracker tracker) {
                Item[] result = tracker.findAll();
                for (Item r: result) {
                    System.out.printf("%s, %s, %s\n", r.getId(), r.getName(), r.getDescription());
                }
            }

            @Override
            public String info() {
                return String.format("%s, %s", this.key(), "Show all items");
            }
        };

        UserAction editItem = new BaseAction() {
            @Override
            public int key() {
                return 2;
            }

            @Override
            public void execute(Input input, Tracker tracker) {
                String id = input.ask("Enter item id:");
                Item item = tracker.findById(id);
                if (item != null) {
                    String name = input.ask("Get new name:");
                    String desc = input.ask("Get new description:");
                    Item newitem = new Item(name, desc, 123L);
                    newitem.setId(item.getId());
                    newitem.setComments(item.getComments());
                    tracker.update(newitem);
                } else {
                    System.out.printf("%s: not found\n", id);
                }
            }

            @Override
            public String info() {
                return String.format("%s, %s", this.key(), "Edit item");
            }
        };

        UserAction deleteItem = new BaseAction() {
            @Override
            public int key() {
                return 3;
            }

            @Override
            public void execute(Input input, Tracker tracker) {
                String id = input.ask("Enter item id:");
                Item item = tracker.findById(id);
                if (item != null) {
                    tracker.delete(item);
                    System.out.println("Item deleted");
                } else {
                    System.out.printf("%s: not found\n", id);
                }
            }

            @Override
            public String info() {
                return String.format("%s, %s", this.key(), "Delete item");
            }
        };


        menu.addAction(addItem);
        menu.addAction(showItems);
        menu.addAction(editItem);
        menu.addAction(deleteItem);
//        menu.addAction(findItemById);
//        menu.addAction(findItemByName);
//        menu.addAction(exitAction);
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
