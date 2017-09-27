package ru.job4j.tracker;

import java.util.Scanner;

/**.
 *
 */
public class ConsoleInput implements Input {
    /**.
     *
     * @param question String
     * @return answer from user
     */
    public String ask(String question) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(question);
        return scanner.nextLine();
    }

    /**.
     *
     * @param data String
     */
    @Override
    public void print(String data) {
        String.format(data);
    }
}
