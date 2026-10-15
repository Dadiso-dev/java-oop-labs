public class BankTest {
    public static void main(String[] args) {
        BankAccount acc = new BankAccount("ACC-001", 500);
        try {
            acc.withdraw(100);
            System.out.println("Balance: " + acc.getBalance());
            acc.withdraw(1000);
        } catch (InsufficientFundsException e) {
            System.out.println(e.getMessage());
            System.out.println("Short by: " + e.getShortfall());
        }
    }
}