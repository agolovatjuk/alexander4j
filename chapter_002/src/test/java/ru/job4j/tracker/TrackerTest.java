package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;

/**.
 *
 */
public class TrackerTest {
    /**.
     *
     */
    @Test
    public void whenTrackerAddAndGetItemsThen() {
        Tracker t = new Tracker();
        Item item1 = new Task("test1", "testDescription1", 123L);
        t.add(item1);
        Item item2 = new Task("test2", "testDescription2", 123L);
        t.add(item2);
        Item item3 = new Task("test3", "testDescription3", 123L);
        t.add(item3);

        assertThat(t.findById(item1.getId()).getName(), is("test1"));
        assertThat(t.findById(item2.getId()).getName(), is("test2"));
        assertThat(t.findById(item3.getId()).getName(), is("test3"));
    }
    /**.
     *
     */
    @Test
    public void whenTrackerDeleteItemsThen() {
        Tracker t = new Tracker();
        Item item1 = new Task("test1", "testDescription1", 123L);
        t.add(item1);
        Item item2 = new Task("test2", "testDescription2", 123L);
        t.add(item2);
        Item item3 = new Task("test3", "testDescription3", 123L);
        t.add(item3);

        t.delete(item1);
        t.delete(item2);
        t.delete(item3);

        assertThat(t.findById(item1.getId()), nullValue());
        assertThat(t.findById(item2.getId()), nullValue());
        assertThat(t.findById(item3.getId()), nullValue());
    }
    /**.
     *
     */
    @Test
    public void whenTrackerUpdateItemThen() {
        Tracker tracker = new Tracker();
        Item previous = new Task("test1", "testDescription", 123L);
        // Добавляем заявку в трекер. Теперь в объект проинициализирован id.
        tracker.add(previous);
        // Создаем новую заявку.
        Item next = new Task("test2", "testDescription2", 1234L);
        // Проставляем старый id из previous, который был сгенерирован выше.
        next.setId(previous.getId());
        // Обновляем заявку в трекере.
        tracker.update(next);
        // Проверяем, что заявка с таким id имеет новые имя test2.
        assertThat(tracker.findById(previous.getId()).getName(), is("test2"));
    }
    /**.
     *
     */
    @Test
    public void whenTrackerFindAllThen() {
        Tracker t = new Tracker();
        Item[] item = new Item[3];
        item[0] = new Task("test1", "testDescription1", 123L);
        t.add(item[0]);
        item[1] = new Task("test2", "testDescription2", 123L);
        t.add(item[1]);
        item[2] = new Task("test3", "testDescription3", 123L);
        t.add(item[2]);

        Item[] result = t.findAll();

        assertThat(result[0].getId(), is(item[0].getId()));
        assertThat(result[1].getId(), is(item[1].getId()));
        assertThat(result[2].getId(), is(item[2].getId()));
    }
    /**.
     *
     */
    @Test
    public void whenTrackerFindByNameThen() {
        Tracker t = new Tracker();
        Item item1 = new Task("test3", "testDescription1", 123L);
        t.add(item1);
        Item item2 = new Task("test2", "testDescription2", 123L);
        t.add(item2);
        Item item3 = new Task("test3", "testDescription3", 123L);
        t.add(item3);
        Item item4 = new Task("test4", "testDescription3", 123L);
        t.add(item4);

        Item[] result = t.findByName("test3");
//        Item[] resul2 = t.findByName("test333");

        assertThat(result[0].getName(), is(item1.getName()));
        assertThat(result[1].getName(), is(item3.getName()));
    }
    /**.
     *
     */
    @Test
    public void whenTrackerFindByIdThen() {
        Tracker t = new Tracker();
        Item item1 = new Task("test1", "testDescription1", 123L);
        t.add(item1);
        Item item2 = new Task("test2", "testDescription2", 123L);
        t.add(item2);
        Item item3 = new Task("test3", "testDescription3", 123L);
        t.add(item3);
        Item item4 = new Task("test4", "testDescription3", 123L);
//        t.add(item3);

        assertThat(item1, is(t.findById(item1.getId())));
        assertThat(item2, is(t.findById(item2.getId())));
        assertThat(item3, is(t.findById(item3.getId())));

        assertThat(t.findById(item4.getId()), nullValue());
    }
}
