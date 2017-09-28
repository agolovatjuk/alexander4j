package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;

/**.
 *
 */
public class StartUITest {
    /**.
     *
     */
    @Test
    public void whenUserAddItemThenTrackerHasIt() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[] {"0", "New Name", "Description", "6"});
        new StartUI(tracker, input).init();
        assertThat(tracker.findAll()[0].getName().equals("New Name"), is(true));
    }
    /**.
     *
     */
    @Test
    public void whenUserEditThenTrackerHasUpdated() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Name", "desc", 123L));
        Input input = new StubInput(new String[] {"2", item.getId(), "New Name", "New Desc", "6"});
        new StartUI(tracker, input).init();
        assertThat(tracker.findAll()[0].getName().equals("New Name"), is(true));
    }
    /**.
     *
     */
    @Test
    public void whenUserDeleteItemThenTrackerDeleteIt() {
        Tracker tracker = new Tracker();
        Item item1 = tracker.add(new Item("Name", "desc", 123L));
        Item item2 = tracker.add(new Item("Name2", "desc2", 124L));
        Input input = new StubInput(new String[] {"3", item2.getId(), "6"});
        new StartUI(tracker, input).init();
        assertThat(tracker.findById(item2.getId()), nullValue());
    }
    /**.
     *
     */
    @Test
    public void whenUserFindByIdThenTrackerFindIt() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Name", "desc", 123L));
        Input input = new StubInput(new String[] {"4", item.getId(), "6"});
        new StartUI(tracker, input).init();
        assertThat(tracker.findById(item.getId()).getName().equals("Name"), is(true));
    }
    /**.
     *
     */
    @Test
    public void whenUserFindByNameThenTrackerFindIt() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Name", "desc", 123L));
        Input input = new StubInput(new String[] {"4", item.getId(), "6"});
        new StartUI(tracker, input).init();
        assertThat(tracker.findByName(item.getName())[0].getName().equals("Name"), is(true));
    }
}
