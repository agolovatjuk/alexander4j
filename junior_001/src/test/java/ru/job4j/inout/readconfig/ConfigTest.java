package ru.job4j.inout.readconfig;

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

public class ConfigTest {

    @Test
    public void whenLoadThen() {
        Config conf = new Config("src/main/java/ru/job4j/app.properties");
        conf.load();
    }

    @Test
    public void whenToStringThen() {
        Config conf = new Config("src/main/java/ru/job4j/app.properties");
//        System.out.println(System.getProperty("user.dir"));
        System.out.println(conf);
    }

    @Test
    public void whenValueThen() {
        String result;
        Config conf = new Config("src/main/java/ru/job4j/app.properties");

        conf.load();
        result = conf.value("hibernate.connection.username");
        assertThat(result, is("postgres"));
        result = conf.value("hibernate.connection.password");
        assertThat(result, is("password"));
    }
}
