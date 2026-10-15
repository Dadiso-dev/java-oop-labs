abstract class Account {
    protected double balance;

    void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit must be positive");
        }
        balance += amount;
    }

    abstract double monthlyFee();

    void applyFee() { balance -= monthlyFee(); }

    double getBalance() { return balance; }
}

class SavingsAccount extends Account {
    @Override double monthlyFee() { return 2.50; }
}

class CurrentAccount extends Account {
    @Override double monthlyFee() { return 10.00; }
}

public class AccountDemo {
    public static void main(String[] args) {
        Account s = new SavingsAccount();
        Account c = new CurrentAccount();

        s.deposit(1000);
        c.deposit(1000);
        s.applyFee();
        c.applyFee();

        System.out.printf("Savings balance: %.2f%n", s.getBalance());
        System.out.printf("Current balance: %.2f%n", c.getBalance());
    }
}