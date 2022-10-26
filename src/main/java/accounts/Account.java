package accounts;

public abstract class Account implements MoneyTarget {
    protected long balance;
    protected String name;

    public Account(long balance, String name) {
        this.balance = balance;
        this.name = name;
    }

    public abstract boolean pay(long amount);

    public boolean add(long amount) {
        balance += amount;
        return true;
    }

    public long getBalance() {
        return balance;
    }

    public String getName() {
        return name;
    }

    public void transfer(Account accountTo, int amount) {
        if (this.pay(amount)) {
            if (!accountTo.add(amount)) {
                this.add(amount);
                System.out.println("Перевод не прошел. Ошибка.");
            } else {
                System.out.println("Перевод проведен!");
            }
        } else {
            System.out.println("Не удалось списать деньги");
        }

    }

}
