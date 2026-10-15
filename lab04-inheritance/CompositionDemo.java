class Engine {
    void start() { System.out.println("Engine started"); }
}

final class Car {
    private final Engine engine = new Engine();

    void drive() {
        engine.start();
        System.out.println("Car is moving");
    }

    @Override
    public String toString() { return "Car with an engine"; }
}

public class CompositionDemo {
    public static void main(String[] args) {
        Car c = new Car();
        c.drive();
        System.out.println(c);
    }
}