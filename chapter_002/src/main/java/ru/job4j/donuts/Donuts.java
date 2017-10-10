package ru.job4j.donuts;

/**.
 * Автомат по продаже пончиков на всю предложенную сумму продаёт пончики, выдаёт сдачу
 * если кончились пончики, либо их не хватает на всю сумму, либо не может выдать сдачу, сообщает об этом
 */
public class Donuts {
    /**.
     * пончиков осталось
     */
    private int donutsleft = 0;
    /**.
     * цена за один пончик
     */
    private int donutprice = 0;
    /**.
     * монет достоинством 1 на сдачу
     */
    private int coin1 = 0;
    /**.
     * монет достоинством 2 на сдачу
     */

    private int coin2 = 0;
    /**.
     * монет достоинством 2 на сдачу
     */
    private int coin5 = 0;
    /**.
     * монет достоинством 10 на сдачу
     */
    private int coin10 = 0;

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
        this.coin1 = coin1;
        this.coin2 = coin2;
        this.coin5 = coin5;
        this.coin10 = coin10;
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

    /**.
     * Выдать сдачу
     * @param money int
     * @return int
     */
    int getcharge(int money) {
        /**.
         * считаем сдачу
         */
        int charge = money % this.donutprice;
        /**.
         * сколько в этой сдаче монет разного достоинства
         * с учётом их наличия в автомате
         */
        int c10 = 0, c5 = 0, c2 = 0, c1 = 0;

        if (charge >= 10 & coin10 >= charge / 10) {
            c10 = Math.min(charge / 10, coin10);
            charge = charge - 10 * c10;
        }
        if (charge >= 5 & coin5 >= charge / 5) {
            c5 = Math.min(charge / 5, coin5);
            charge = charge - 5 * c5;
        }
        if (charge >= 2 & coin2 > 0) {
            c2 = Math.min(charge / 2, coin2);
            charge = charge - 2 * c2;
        }
        if (charge >= 1 & coin1 >= charge) {
            c1 = charge;
            charge = 0;
        }

        if (charge != 0) {
            return -1;
        } else {
            coin1 = coin1 - c1;
            coin2 = coin2 - c2;
            coin5 = coin5 - c5;
            coin10 = coin10 - c10;
            return c10 * 10 + c5 * 5 + c2 * 2 + c1;
        }
    }

    /**.
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        int charge, donuts;
        int donutprice = 6;
        int money = 15;
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
        System.out.println(String.format("Продано: %d", d.donutsleft));
        System.out.println(String.format("Осталось_10: %d", d.coin10));
        System.out.println(String.format("Осталось_5: %d", d.coin5));
        System.out.println(String.format("Осталось_2: %d", d.coin2));
        System.out.println(String.format("Осталось_1: %d", d.coin1));
    }
}
