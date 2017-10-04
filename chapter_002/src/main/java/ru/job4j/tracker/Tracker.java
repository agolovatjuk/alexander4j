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
        for (int i = 0; i < this.pos; i++) {
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
        Item[] result = new Item[1];
        int n = 0;
        for (int i = 0; i < pos; i++) {
            if (this.items[i] != null && this.items[i].getName().equals(key)) {
                if (n == result.length) {
                    result = resize(result, result.length * 2);
                }
                result[n++] = this.items[i];
            }
        }
        return result;
    }

    /**.
     *
     * @param source Item[]
     * @param n int
     * @return Item[]
     */
    private Item[] resize(Item[] source, int n) {
        Item[] dest = new Item[n];
        System.arraycopy(source, 0, dest, 0, source.length);
        return dest;
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
    private long created;
    /**.
     *
     */
    private String[] comments;

    /**.
     *
     * @param name String
     * @param description String
     * @param create String
     */
    Item(String name, String description, long create) {
        this.name = name;
        this.description = description;
        this.created = create;
    }

    /**.
     *
     * @param name String
     * @param description String
     * @param create String
     * @param comments String[]
     */
    Item(String name, String description, long create, String[] comments) {
        this.name = name;
        this.description = description;
        this.created = create;
        this.comments = new String[comments.length];
        System.arraycopy(comments, 0, this.comments, 0, comments.length);
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
     * @param entries String[]
     */
    public void setComments(String[] entries) {
        if (entries != null) {
            this.comments = new String[entries.length];
            System.arraycopy(entries, 0, this.comments, 0, entries.length);
        }
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
    public long getCreated() {
        return this.created;
    }

    /**.
     *
     * @return String[] comments
     */
    public String[] getComments() {
        return this.comments;
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