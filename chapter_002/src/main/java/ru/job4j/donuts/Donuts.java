package ru.job4j.donuts;

import java.util.Arrays;

/**.
 * Автомат по продаже пончиков на всю предложенную сумму продаёт пончики, выдаёт сдачу
 * если кончились пончики, либо их не хватает на всю сумму, либо не может выдать сдачу, сообщает об этом
 */
public class Donuts {
    /**.
     * пончиков осталось
     */
    int donutsleft = 0;
    /**.
     * цена за один пончик
     */
    private int donutprice = 0;

    private int[] coins;

    /**.
     * Конструктор класса
     * @param donutsleft int
     * @param donutprice int
     * @param coin1 int
     * @param coin2 int
     * @param coin5 int
     * @param coin10 int
     */
    Donuts(int donutsleft, int donutprice, int coin1, int coin2, int coin5, int coin10) {
        this.donutsleft = donutsleft;
        this.donutprice = donutprice;
        coins = new int[] {coin10, coin5, coin2, coin1};
    }

    /**.
     * Проверить сколько пончиков можно продать за money
     * @param money int
     * @return int
     */
    int checkdonuts(int money) {
        /**.
         */
        int donuts = money / donutprice;

        if (this.donutsleft - donuts >= 0) {
            return donuts;
        } else {
            return 0;
        }
    }

    /**.
     * Продать некое количество пончиков за заданную сумму
     * @param money int
     */
    void selldonuts(int money) {
        this.donutsleft = this.donutsleft - money / this.donutprice;
    }


    int getcharge(int money) {
        int charge = money % this.donutprice;
        int[] nominal = {10, 5, 2, 1};
        int[] tmpCoins = new int[nominal.length];
        System.arraycopy(this.coins, 0, tmpCoins, 0, 4);

        for (int i = 0; charge > 0 && i < nominal.length; i++) {
            if (tmpCoins[i] > 0 && charge >= nominal[i]) {
                int cntCoins = Math.min(tmpCoins[i], charge / nominal[i]);
                tmpCoins[i] -= cntCoins;
                charge -= cntCoins * nominal[i];
            }
        }
        if (charge == 0) {
            this.coins = tmpCoins;
            return money % this.donutprice;
        }
        return -1;
    }
    /**.
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        int charge, donuts;
//        int donutprice = 26;
        int donutprice = 33;
        int money = 150;
        Donuts d = new Donuts(100, donutprice, 50, 25, 10, 5);

        while (d.donutsleft > 0) {
            donuts = d.checkdonuts(money);
            if (donuts > 0) {
                charge = d.getcharge(money);
                if (charge != -1) {
                    d.selldonuts(money);
                    System.out.println(String.format("Money:%d, Donuts:%d, Charge:%d", money, donuts, charge));
                } else {
                    System.out.println("Sorry, no charge");
                    break;
                }
            } else {
                System.out.println("Sorry, no donuts");
                break;
            }
        }
        System.out.println(String.format("Осталось: %d", d.donutsleft));
        System.out.println(String.format("Осталось_1: %s", Arrays.toString(d.coins)));
    }
}
