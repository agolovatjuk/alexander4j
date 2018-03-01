package ru.job4j.banktransfer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Transfer {
    public Map<User, List<Account>> tr = new HashMap<>();

    public void addUser(User user) {
        tr.putIfAbsent(user, new ArrayList<>());
    }

    public void deleteUser(User user) {
        if (tr.containsKey(user)) {
            tr.remove(user);
        }
    }

    public void addAccountToUser(String passport, Account account) {
        // lambda JetBrains [added for me]
        List<Account> acc = tr.get(new User("", passport));
        if (acc != null && acc.indexOf(account) == -1) {
            acc.add(account);
        }
    }

    public void deleteAccountFromUser(String passport, Account account) {
        List<Account> acc = getUserAccounts(passport);
        if (acc != null) {
            acc.remove(account);
        }
    }

    public List<Account> getUserAccounts(String passport) {
        /**
         *    - получить список счетов для пользователя. см. equals() / hashCode() User
         */
        return tr.get(new User("", passport));
    }

    public boolean transferMoney(String srcPassport, String srcRequisite, String destPassport, String dstRequisite, double amount) {
        /**
         *- метод для перечисления денег с одного счёта на другой счёт:
         если счёт не найден или не хватает денег на счёте srcAccount (с которого переводят) должен вернуть false.
         */
        List<Account> srcAccounts  = getUserAccounts(srcPassport);
        List<Account> destAccounts = getUserAccounts(destPassport);

        for (Account srcAcc: srcAccounts) {
            if (srcAcc.getRequisites().equals(srcRequisite) && srcAcc.getValue() >= amount) {
                for (Account dstAcc: destAccounts) {
                    if (dstAcc.getRequisites().equals(dstRequisite)) {
                        dstAcc.setValue(dstAcc.getValue() + amount);
                        srcAcc.setValue(srcAcc.getValue() - amount);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Transfer{");
        sb.append("tr=").append(tr);
        sb.append('}');
        return sb.toString();
    }

//    public static void main(String[] args) {
//        User u1 = new User("John", "007");
//        User u2 = new User("Bill", "000");
//        User u3 = new User("Pew", "009");
//
//        Transfer t = new Transfer();
//        t.addUser(u1);
//        t.addUser(u2);
//        t.addUser(u3);
//
//        System.out.println(t.getUser(u1.getPassport()));
//        t.addAccountToUser(u1.getPassport(), new Account(100, "acc_001"));
//        t.addAccountToUser(u1.getPassport(), new Account(150, "acc_001")); // не добавит
//        t.addAccountToUser(u1.getPassport(), new Account(200, "acc_002"));
//        t.addAccountToUser(u1.getPassport(), new Account(300, "acc_003"));
//        t.addAccountToUser(u2.getPassport(), new Account(0, "acc_200"));
//        t.addAccountToUser(u2.getPassport(), new Account(0, "acc_201"));
//        t.transferMoney(u1.getPassport(), "acc_003", u2.getPassport(), "acc_201", 50);
//        System.out.println(t.getUserAccounts(u2.getPassport()));
//        System.out.println(t.getUserAccounts(u1.getPassport()));
////        u1.setPassport("008"); // если изменить поле key-объекта, участника hash, то потом будут value-проблемы
//        u1.setName("Morgan"); // name не участвует в hash, проблем с value не будет
////        t.addAccountToUser(u1.getPassport(), new Account(100,"acc_004")); // value не найден
////        t.tr.forEach((k, v) -> System.out.println(k.toString() + v.toString())); // хотя тут всё хорошо
//        t.deleteAccountFromUser("007", new Account("acc_003"));
//        t.deleteAccountFromUser("007", new Account("acc_003")); // нет ошибки
//        System.out.println(t.getUserAccounts(u1.getPassport()));
//        t.tr.forEach((k, v) -> System.out.println(k.toString() + v.toString()));
////        t.deleteUser(new User("", "007")); // hash считается по полю passport
////        t.tr.forEach((k, v) -> System.out.println(k.toString() + v.toString()));
//    }
}
