package accounts;

public class CreditAccount extends Account {

    private final int MAXBALANCE = 0;

    public CreditAccount(long balance, String name) {
        super(balance, name);
        if (balance > 0) {
            this.balance = MAXBALANCE;
            System.out.println("Баланс 0");
        }

    }

    @Override
    public boolean pay(long amount) {
        balance -= amount;
        return true;
    }

    @Override
    public boolean add(long amount) {
        if (balance + amount > MAXBALANCE) {
            return false;
        } else {
            balance += amount;
            return true;
        }
    }


    @Override
    public boolean accept(int money) {
        if (money + balance > 0) {
            return false;
        } else {
            balance += money;
            return true;
        }
    }
}
