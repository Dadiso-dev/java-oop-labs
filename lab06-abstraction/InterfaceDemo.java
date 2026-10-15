interface Payable {
    double MAX_LIMIT = 10_000;

    void pay(double amount);

    default void receipt(double amount) {
        System.out.println("Receipt: paid " + amount);
    }

    static boolean withinLimit(double amount) {
        return amount <= MAX_LIMIT;
    }
}

interface Loggable {
    void log(String message);
}

class CardPayment implements Payable, Loggable {
    @Override
    public void pay(double amount) {
        if (!Payable.withinLimit(amount)) {
            log("Blocked: over limit");
            return;
        }
        log("Card charged " + amount);
        receipt(amount);
    }

    @Override
    public void log(String message) {
        System.out.println("[LOG] " + message);
    }
}

class CashPayment implements Payable {
    @Override
    public void pay(double amount) {
        System.out.println("Cash received: " + amount);
    }

    @Override
    public void receipt(double amount) {
        System.out.println("Handwritten receipt for " + amount);
    }
}

public class InterfaceDemo {
    public static void main(String[] args) {
        Payable[] methods = { new CardPayment(), new CashPayment() };

        for (Payable p : methods) {
            p.pay(250);
            p.receipt(250);
            System.out.println("---");
        }
        new CardPayment().pay(50_000);
    }
}