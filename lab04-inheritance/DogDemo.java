class Animal {
    protected String name;
    Animal(String name) { this.name = name; }
}

/* BROKEN VERSION: this does not compile.
class BrokenDog extends Animal {
    BrokenDog() { }
}
*/

class Dog extends Animal {
    Dog(String name) { super(name); }
}

public class DogDemo {
    public static void main(String[] args) {
        Dog d = new Dog("Rex");
        System.out.println("Dog created: " + d.name);
    }
}