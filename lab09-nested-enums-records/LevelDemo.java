enum Level { LOW, MEDIUM, HIGH }

public class LevelDemo {

    static void advice(Level level) {
        switch (level) {
            case LOW    -> System.out.println("LOW: all is well, keep going.");
            case MEDIUM -> System.out.println("MEDIUM: keep an eye on it.");
            case HIGH   -> System.out.println("HIGH: act immediately!");
        }
    }

    public static void main(String[] args) {
        for (Level l : Level.values()) {
            advice(l);
        }
    }
}