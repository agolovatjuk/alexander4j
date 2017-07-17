package ru.job4j.calculator;

/**.
 * class for computing
 *
 * @author
 * @version $Id$
 * @since 0.1
 */
class Calculator {
    /**.
     *
     */
    private double result;

    /**.
     * add
     * @param first firs arg
     * @param second sec arg
     */
    public void add(double first, double second) {
        this.result = first + second;
    }

    /**.
     * substruct
     * @param first firs arg
     * @param second sec arg
     */
    public void substruct(double first, double second) {
        this.result = first - second;
    }

    /**.
     * div
     * @param first firs arg
     * @param second sec arg
     */
    public void div(double first, double second) {
        this.result = first / second;
    }

    /**.
     * multiple
     * @param first firs arg
     * @param second sec arg
     */
    public void multiple(double first, double second) {
        this.result = first * second;
    }

    /**.
     * getResult
     * @return this.result return
     */
    public double getResult() {
        return this.result;
    }
}

