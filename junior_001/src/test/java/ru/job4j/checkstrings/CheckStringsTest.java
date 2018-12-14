package ru.job4j.checkstrings;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class CheckStringsTest {

    @Test
    public void whenCheckThen() {
        assertThat(CheckStrings.checkForTwoLetter("привет", "привет"), is(true));
        assertThat(CheckStrings.checkForTwoLetter("привет", "тривеп"), is(true));
        assertThat(CheckStrings.checkForTwoLetter("мама", "ммаа"), is(true));
        assertThat(CheckStrings.checkForTwoLetter("амам", "мама"), is(false));
        assertThat(CheckStrings.checkForTwoLetter("пароход", "пароход"), is(true));
        assertThat(CheckStrings.checkForTwoLetter("пароход", "праоход"), is(true));
        assertThat(CheckStrings.checkForTwoLetter("пароход", "пархоод"), is(true));
        assertThat(CheckStrings.checkForTwoLetter("пароход", "праодох"), is(false));
    }
}