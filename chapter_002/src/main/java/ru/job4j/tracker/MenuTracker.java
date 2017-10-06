package ru.job4j.tracker;

/**.
 *
 */
class EditItem implements UserAction {
    /**.
     *
     * @return key
     */
    public int key() {
        return 2;
    }

    /**.
     *
     * @param input INput
     * @param tracker Tracker
     */
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

    /**.
     *
     * @return String
     */
    public String info() {
        return String.format("%s, %s", this.key(), "Edit item");
    }
}

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
     * @param input Input
     * @param tracker Tracker
     */
    MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**.
     *
     */
    public void fillActions() {
        actions[0] = new AddItem();
        actions[1] = new ShowItems();
        actions[2] = new EditItem();
        actions[3] = new DeleteItem();
        actions[4] = new FindItemById();
        actions[5] = new FindItemByName();
        actions[6] = new Exit();
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
    /**.
     *
     */
    private class AddItem implements UserAction {
        /**.
         *
         * @return int
         */
        public int key() {
            return 0;
        }
        /**.
         *
         * @param input INput
         * @param tracker Tracker
         */
        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Get new item name:");
            String desc = input.ask("Get description:");
            Task task = new Task(name, desc, 123L);
            tracker.add(task);
            System.out.println("New item added");
        }
        /**.
         *
         * @return String
         */
        public String info() {
            return String.format("%s, %s", this.key(), "Add new item");
        }
    }

    /**.
     *
     */
    private static class ShowItems implements UserAction {
        /**.
         *
         * @return int
         */
        public int key() {
            return 1;
        }
        /**.
         *
         * @param input INput
         * @param tracker Tracker
         */
        public void execute(Input input, Tracker tracker) {
            Item[] result = tracker.findAll();
            for (Item r: result) {
                System.out.printf("%s, %s, %s\n", r.getId(), r.getName(), r.getDescription());
            }
        }
        /**.
         *
         * @return String
         */
        public String info() {
            return String.format("%s, %s", this.key(), "Show all items");
        }
    }

    /**.
     *
     */
    private static class DeleteItem implements UserAction {
        /**.
         *
         * @return int
         */
        public int key() {
            return 3;
        }
        /**.
         *
         * @param input INput
         * @param tracker Tracker
         */
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
        /**.
         *
         * @return String
         */
        public String info() {
            return String.format("%s, %s", this.key(), "Delete item");
        }
    }

    /**.
     *
     */
    private class FindItemById implements UserAction {
        /**.
         *
         * @return int
         */
        public int key() {
            return 4;
        }
        /**.
         *
         * @param input INput
         * @param tracker Tracker
         */
        public void execute(Input input, Tracker tracker) {
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
         * @return String
         */
        public String info() {
            return String.format("%s, %s", this.key(), "Find item by ID");
        }
    }

    /**.
     *
     */
    private class FindItemByName implements UserAction {
        /**.
         *
         * @return int
         */
        public int key() {
            return 5;
        }
        /**.
         *
         * @param input INput
         * @param tracker Tracker
         */
        public void execute(Input input, Tracker tracker) {
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
         * @return String
         */
        public String info() {
            return String.format("%s, %s", this.key(), "Find item by name");
        }
    }

    /**.
     *
     */
    private class Exit implements UserAction {
        /**.
         *
         * @return int
         */
        public int key() {
            return 6;
        }
        /**.
         *
         * @param input INput
         * @param tracker Tracker
         */
        public void execute(Input input, Tracker tracker) {
        }
        /**.
         *
         * @return String
         */
        public String info() {
            return String.format("%s, %s", this.key(), "Exit");
        }
    }
}
