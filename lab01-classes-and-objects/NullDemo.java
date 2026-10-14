public class NullDemo {
    public static void main(String[] args) {
        Person p = new Person();
        p.name = "Dadiso";
        p.address = null;
        System.out.println(p.address.city);
    }
}