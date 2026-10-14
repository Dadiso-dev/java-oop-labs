public class Person {
    String name;
    Address address;

    public static void main(String[] args) {
        Address a = new Address();
        a.city = "Harare";

        Person p = new Person();
        p.name = "Dadiso";
        p.address = a;

        System.out.println(p.name + " lives in " + p.address.city);
    }
}