package ru.job4j.collectiontest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertThat;

public class UserConvertTest {

    @Test
    public void whenUserToMap() {
        List<User> userlist = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            User u = new User(i, "Name_" + i * 10, "City_" + i * 100);
            userlist.add(u);
        }

        UserConvert uc = new UserConvert();
        Map usermap = uc.process(userlist);

        assertThat(usermap.get(1).toString(), is("Id:1, Name:Name_10, City:City_100"));
        assertThat(usermap.get(7).toString(), is("Id:7, Name:Name_70, City:City_700"));
        assertThat(usermap.get(3).toString(), not("Id:7, Name:Name_70, City:City_700"));
    }
}
