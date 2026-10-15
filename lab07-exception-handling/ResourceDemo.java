class Connection implements AutoCloseable {
    private final String name;

    Connection(String name) {
        this.name = name;
        System.out.println(name + " opened");
    }

    void query(boolean fail) {
        if (fail) throw new IllegalStateException(name + " query failed");
        System.out.println(name + " query ok");
    }

    @Override
    public void close() {
        System.out.println(name + " closed");
    }
}

public class ResourceDemo {
    public static void main(String[] args) {
        try (Connection c1 = new Connection("DB1");
             Connection c2 = new Connection("DB2")) {
            c1.query(false);
            c2.query(true);
        } catch (IllegalStateException e) {
            System.out.println("Caught: " + e.getMessage());
        }

        try {
            try {
                Integer.parseInt("12x");
            } catch (NumberFormatException e) {
                throw new RuntimeException("Configuration invalid", e);
            }
        } catch (RuntimeException e) {
            System.out.println(e.getMessage() + " <- " + e.getCause().getClass().getSimpleName());
        }
    }
}