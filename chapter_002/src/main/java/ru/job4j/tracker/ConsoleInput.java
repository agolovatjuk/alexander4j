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
     * @param question String
     * @param range int[]
     * @return answer
     * @throws MenuOutException moe
     */
    public int ask(String question, int[] range) throws MenuOutException {
        /**.
         *
         */
        int key = Integer.valueOf(this.ask(question));
        /**.
         *
         */
        boolean exist = false;

        for (int i = 0; i < range.length; i++) {
            if (key == range[i]) {
                exist = true;
                break;
            }
        }
        if (exist) {
            return key;
        } else {
            throw new MenuOutException("Out of menu range");
        }
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
