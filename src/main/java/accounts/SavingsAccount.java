package accounts;

public class SavingsAccount extends Account {
    protected long minimumBalance;

    public SavingsAccount(long balance, String name, long minimumBalance) {
        super(balance, name);
        this.minimumBalance = minimumBalance;
    }

    @Override
    public boolean pay(long amount) {
        if (balance - amount < minimumBalance) {
            return false;
        } else {
            balance -= amount;
            return true;
        }
    }

    public boolean accept(int money) {
        balance += money;
        return true;
    }
}
