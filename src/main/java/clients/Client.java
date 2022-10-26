package clients;

import accounts.Account;

import java.util.Arrays;

public class Client implements MoneyTarget {

    protected String name;
    protected Account[] accounts;

    public Client(String name, int quantityOfAccount) {
        this.name = name;
        this.accounts = new Account[quantityOfAccount];

    }

    public void print() {
        System.out.println(Arrays.toString(accounts));
    }

    public boolean newAccount(Account account) {
        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i] == null) {
                accounts[i] = account;
                System.out.println("Новый счет создан!");
                return true;
            }
        }
        System.out.println("Мест для нового счёта нет!");
        return false;
    }

    public boolean pay(int amount) {
        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i] != null) {
                if (accounts[i].getBalance() > amount) {
                    accounts[i].pay(amount);
                    return true;
                }
            }
        }
        System.out.println("На счетах недостаточно средств");
        return false;
    }

    @Override
    public boolean accept(int money) {
        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i] != null) {
                if (accounts[i].accept(money)) {
                    System.out.println("Удалось пополнить счет номер " + (i + 1) + " на сумму " + money);
                    return true;
                } else {
                    System.out.println("Не удалось пополнить счет номер " + (i + 1) + " на сумму " + money);
                }
            }
        }
        System.out.println("Не удалось пополнить ни один счет!");
        return false;
    }
}
