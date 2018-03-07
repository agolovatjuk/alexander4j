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
        boolean result = false;
        List<Account> srcAccounts = getUserAccounts(srcPassport);
        List<Account> dstAccounts = getUserAccounts(destPassport);

        if (srcAccounts != null & dstAccounts != null) {
            int srcIdx = srcAccounts.indexOf(new Account(srcRequisite));
            int dstIdx = dstAccounts.indexOf(new Account(dstRequisite));
            if (srcIdx != -1 & dstIdx != -1) { // bad Account
                if (srcAccounts.get(srcIdx).getValue() >= amount) { // not enough money
                    srcAccounts.get(srcIdx).setValue(srcAccounts.get(srcIdx).getValue() - amount);
                    dstAccounts.get(dstIdx).setValue(dstAccounts.get(dstIdx).getValue() + amount);
                    result = true;
                }
            }
        }
        return result;
    }
}
