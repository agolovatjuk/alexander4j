package ru.job4j.checkstrings;

public class CheckStrings {

    public static boolean checkForTwoLetter(String a, String b) {
        boolean result = true;

        for (int i = 0, cnt = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i) && ++cnt > 2) {
                result = false;
                break;
            }
        }
        return result;
    }
}
