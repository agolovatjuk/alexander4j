package ru.job4j.tracker;

/**.
 *
 */
public class StubInput implements Input {
    /**.
     *
     */
    private String[] answers;
    /**.
     *
     */
    private int position = 0;

    /**.
     *
     * @param answers Strings[]
     */
    public StubInput(String[] answers) {
        this.answers = answers;
    }

    @Override
    public String ask(String question) {
        return answers[position++];
    }

    @Override
    public int ask(String question, int[] range) {
//        throw new UnsupportedOperationException("Not realized");
        return Integer.parseInt(answers[position++]);
//        return -1;
    }

    @Override
    public void print(String data) {
    }
}
