package ru.job4j.tracker;

/**.
 *
 */
public class ValidateInput extends ConsoleInput {
    /**.
     *
     * @param question String
     * @param range int[]
     * @return int
     */
    public int ask(String question, int[] range) {
        boolean invalid = true;
        int answer = -1;
        do {
            try {
                answer = super.ask(question, range);
                invalid = false;
            } catch (MenuOutException moe) {
                System.out.println("Please select key from menu");
            } catch (NumberFormatException nfe) {
                System.out.println("Please enter data again");
            }
        } while (invalid);
        return  answer;
    }
}
