package accounts;

public class CheckingAccount extends Account {
    private final int MINBALANCE = 0;

    public CheckingAccount(long balance, String name) {
        super(balance, name);
    }

    @Override
    public boolean pay(long amount) {
        if (balance - amount < MINBALANCE) {
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
