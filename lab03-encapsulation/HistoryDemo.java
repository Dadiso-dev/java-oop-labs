public class HistoryDemo {
    public static void main(String[] args) {
        BankAccount acc = new BankAccount("ACC-002", "Chipo", 100.00);
        acc.deposit(50.00);
        acc.withdraw(30.00);
        acc.withdraw(1000.00);

        for (String line : acc.getHistory()) {
            System.out.println(line);
        }

        try {
            acc.getHistory().add("hack");
        } catch (UnsupportedOperationException e) {
            System.out.println("History is read-only");
        }
    }
}