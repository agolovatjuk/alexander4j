package ru.job4j.banktransfer;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TransferTest {

    @Test
    public void whenAddUsearThen() {
        Transfer t = new Transfer();
        User[] users = new User[3];
        users[0] = new User("Name01", "001");
        users[1] = new User("Name02", "002");
        users[2] = new User("Name03", "003");
        t.addUser(users[0]);
        t.addUser(users[1]);
        t.addUser(users[2]);

        User[] expected = new User[3];
        t.tr.keySet().toArray(expected);
        assertThat(users, is(expected));
    }

    @Test
    public void whenDeleteUserThen() {
        Transfer t = new Transfer();
        User[] users = new User[3];
        users[0] = new User("Name01", "001");
        users[1] = new User("Name02", "002");
        users[2] = new User("Name03", "003");
        t.addUser(users[0]);
        t.addUser(users[1]);
        t.addUser(users[2]);
        int expected = t.tr.keySet().size();
        assertThat(3, is(expected));

        t.deleteUser(users[2]);
        t.deleteUser(users[1]);
        t.deleteUser(users[0]);
        expected = t.tr.keySet().size();
        assertThat(0, is(expected));
    }

    @Test
    public void whenAddAccountToUserThen() {
        Transfer t = new Transfer();
        User u = new User("Name01", "001");
        t.addUser(u);
        t.addAccountToUser(u.getPassport(), new Account(100, "acc001"));
        t.addAccountToUser(u.getPassport(), new Account(200, "acc001")); // doesn't add
        t.addAccountToUser(u.getPassport(), new Account(300, "acc002"));
        int szAccounts = t.getUserAccounts(u.getPassport()).size();
        assertThat(szAccounts, is(2));
    }

    @Test
    public void whenDeleteAccountFromUserThen() {
        Transfer t = new Transfer();
        User u = new User("Name01", "passport001");
        t.addUser(u);
        t.addAccountToUser("passport001", new Account(100, "acc001"));
        t.addAccountToUser("passport001", new Account(200, "acc002"));
        t.addAccountToUser("passport001", new Account(300, "acc003"));

        int szAccounts = t.getUserAccounts(u.getPassport()).size();
        assertThat(szAccounts, is(3));

        t.deleteAccountFromUser("passport001", new Account("acc001"));
        szAccounts = t.getUserAccounts("passport001").size();
        assertThat(szAccounts, is(2));

        t.deleteAccountFromUser("passport001", new Account("acc003"));
        szAccounts = t.getUserAccounts(u.getPassport()).size();
        assertThat(szAccounts, is(1));

        Account acc = t.getUserAccounts(u.getPassport()).get(0);
        assertThat(acc.getRequisites(), is("acc002"));
        assertThat(acc.getValue(), is(200.00));
    }

    @Test
    public void whenGetUserAccountsThen() {
        Transfer t = new Transfer();
        User u = new User("Name01", "passport001");
        t.addUser(u);
        t.addAccountToUser("passport001", new Account(100, "acc001"));
        t.addAccountToUser("passport001", new Account(200, "acc002")); // doesn't add
        t.addAccountToUser("passport001", new Account(300, "acc003"));

        List<Account> account = t.getUserAccounts(u.getPassport());
        assertThat(account.size(), is(3));
        assertThat(account.get(0).getRequisites(), is("acc001"));
        assertThat(account.get(1).getRequisites(), is("acc002"));
        assertThat(account.get(2).getRequisites(), is("acc003"));
    }

    @Test
    public void transferMoney() {
        Transfer t = new Transfer();
        User u1 = new User("Name01", "passport001");
        User u2 = new User("Name02", "passport002");
        t.addUser(u1);
        t.addUser(u2);
        t.addAccountToUser("passport001", new Account(100, "acc001"));
        t.addAccountToUser("passport001", new Account(200, "acc002"));
        t.addAccountToUser("passport001", new Account(300, "acc003"));
        t.addAccountToUser("passport002", new Account("acc003"));

        // добавили одному, сняли с другого
        t.transferMoney("passport001", "acc003", "passport002", "acc003", 20);

        Account acc1 = t.getUserAccounts("passport002").get(0);
        assertThat(acc1.getValue(), is(20.0));
        assertThat(acc1.getRequisites(), is("acc003"));

        List<Account> acc2 = t.getUserAccounts("passport001");
        Account acc = acc2.get(acc2.indexOf(new Account("acc003")));
        assertThat(acc.getValue(), is(280.0));
    }
}
