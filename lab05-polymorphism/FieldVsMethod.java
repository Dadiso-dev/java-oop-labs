class Parent {
    String label = "Parent field";
    String who() { return "Parent method"; }
}

class Child extends Parent {
    String label = "Child field";
    @Override String who() { return "Child method"; }
}

public class FieldVsMethod {
    public static void main(String[] args) {
        Parent p = new Child();
        System.out.println(p.who());
        System.out.println(p.label);

        Child c = (Child) p;
        System.out.println(c.label);
    }
}