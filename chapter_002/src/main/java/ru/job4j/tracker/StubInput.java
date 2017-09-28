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
//        position = position % answers.length;
        return answers[position++];
    }

    @Override
    public void print(String data) {
    }
}
