package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.Random;
/**.
 *
 */
public class Tracker {
    /**
     * .
     */
//    private Item[] items = new Item[100];
    private ArrayList<Item> items = new ArrayList<>();
    /**
     * .
     */
//    private int pos = 0;
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
        this.items.add(item);
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
        for (Item curitem: this.items) {
            if (curitem.getId().equals(item.getId())) {
                this.items.set(this.items.indexOf(curitem), item);
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
        if (this.items.contains(item)) {
            this.items.remove(item);
        }
    }

    /**
     * .
     *
     * @return Item[]
     */
    public Item[] findAll() {
        return this.items.toArray(new Item[this.items.size()]);
    }

    /**
     * .
     *
     * @param key id
     * @return Item[]
     */
    public Item[] findByName(String key) {
        ArrayList<Item> result = new ArrayList<>();

        for (Item item: this.items) {
            if (item.getName().equals(key)) {
                result.add(item);
            }
        }
        return result.toArray(new Item[result.size()]);
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
        for (Item item: this.items) {
            if (item.getId().equals(id)) {
                result = item;
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