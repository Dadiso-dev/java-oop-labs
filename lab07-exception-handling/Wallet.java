public class Wallet {
    private double balance;

    public Wallet(double balance) { this.balance = balance; }

    public void spend(double amount) throws InsufficientFundsException {
        if (amount > balance) {
            throw new InsufficientFundsException(
                "Cannot spend " + amount + "; balance is " + balance, amount - balance);
        }
        balance -= amount;
    }

    public double getBalance() { return balance; }

    public static void main(String[] args) {
        Wallet w = new Wallet(100);
        try {
            w.spend(60);
            System.out.println("Balance now: " + w.getBalance());
            w.spend(60);
        } catch (InsufficientFundsException e) {
            System.out.println(e.getMessage());
            System.out.println("Short by: " + e.getShortfall());
        }
    }
}