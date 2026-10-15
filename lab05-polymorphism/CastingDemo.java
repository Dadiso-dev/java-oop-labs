class Animal {
    String type = "Animal";
    void speak() { System.out.println("..."); }
    static void info() { System.out.println("Animal info"); }
}

class Dog extends Animal {
    String type = "Dog";
    @Override void speak() { System.out.println("Woof"); }
    void fetch() { System.out.println("Fetching..."); }
    static void info() { System.out.println("Dog info"); }
}

public class CastingDemo {
    public static void main(String[] args) {
        Animal a = new Dog();

        a.speak();
        System.out.println(a.type);
        a.info();

        if (a instanceof Dog d) {
            d.fetch();
        }

        Animal plain = new Animal();
        if (!(plain instanceof Dog)) {
            System.out.println("plain is not a Dog; downcast avoided");
        }
    }
}