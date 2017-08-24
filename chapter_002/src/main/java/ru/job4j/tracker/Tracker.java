package ru.job4j.tracker;

import java.util.Random;
/**.
 *
 */
public class Tracker {
    /**
     * .
     */
    private Item[] items = new Item[100];
    /**
     * .
     */
    private int pos = 0;
    /**
     * .
     */
    private static final Random RN = new Random();

    /**
     * .
     *
     * @param item Item
     * @return item
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[pos++] = item;
        return item;
    }

    /**
     * .
     *
     * @return id
     */
    private String generateId() {
        return String.valueOf(System.currentTimeMillis() + this.RN.nextInt());
    }

    /**
     * .
     *
     * @param item Item
     */
    public void update(Item item) {
        for (int i = 0; i < this.items.length; i++) {
            if (this.items[i] != null && this.items[i].getId().equals(item.getId())) {
                this.items[i] = item;
                break;
            }
        }
    }

    /**
     * .
     *
     * @param item Item
     */
    public void delete(Item item) {
        for (int i = 0; i < this.pos; i++) {
            if (this.items[i] != null && this.items[i].getId().equals(item.getId())) {
                System.arraycopy(this.items, i + 1, this.items, i, pos - i - 1);
                this.items[pos - 1] = null;
                pos--;
                break;
            }
        }
    }

    /**
     * .
     *
     * @return Item[]
     */
    public Item[] findAll() {
        Item[] result = new Item[this.pos];
        System.arraycopy(this.items, 0, result, 0, this.pos);
        return result;
    }

    /**
     * .
     *
     * @param key id
     * @return Item[]
     */
    public Item[] findByName(String key) {
        Item[] result = new Item[2];
        int n = 0;
        for (int i = 0; i < pos; i++) {
            if (this.items[i] != null && this.items[i].getName().equals(key)) {
                if (n == result.length) {
                    resize(result, result.length * 2);
                }
                result[n++] = this.items[i];
            }
        }
        return result;
    }

    /**
     * .
     *
     * @param result Item[]
     * @param n      int count
     */
    private void resize(Item[] result, int n) {
        Item[] tmp = new Item[n];
        System.arraycopy(tmp, 0, result, 0, result.length);
        result = tmp;
    }

    /**
     * .
     *
     * @param id String
     * @return Item[]
     */
    public Item findById(String id) {
        Item result = null;
        for (int i = 0; i < pos; i++) {
            if (items[i] != null && items[i].getId().equals(id)) {
                result = items[i];
                break;
            }
        }
        return result;
    }
}

/**.
 *
 */
class Item {
    /**.
     *
     */
    private String id;
    /**.
     *
     */
    private String name;
    /**.
     *
     */
    private String description;
    /**.
     *
     */
    private long create;

    /**.
     *
     * @param name String
     * @param description String
     * @param create String
     */
    Item(String name, String description, long create) {
        this.name = name;
        this.description = description;
        this.create = create;
    }

    /**.
     *
     * @param id String
     */
    public void setId(String id) {
        this.id = id;
    }

    /**.
     *
     * @return id
     */
    public String getId() {
        return this.id;
    }

    /**.
     *
     * @return name
     */
    public String getName() {
        return this.name;
    }

    /**
     *
     * @return description
     */
    public String getDescription() {
        return this.description;
    }

    /**.
     *
     * @return long date
     */
    public long getCreate() {
        return this.create;
    }
}

/**.
 *
 */
class Task extends Item {
    /**.
     *
     * @param name String
     * @param description String
     * @param create String
     */
    Task(String name, String description, long create) {
        super(name, description, create);
    }

    /**.
     *
     * @return String
     */
    public String calculatePrice() {
        return "100%";
    }
}