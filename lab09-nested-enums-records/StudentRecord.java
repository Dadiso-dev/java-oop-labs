record Student(String name, int age) {}

public class StudentRecord {
    public static void main(String[] args) {
        Student s1 = new Student("Chipo", 20);
        Student s2 = new Student("Chipo", 20);
        Student s3 = new Student("Tendai", 22);

        System.out.println(s1);
        System.out.println("s1 equals s2: " + s1.equals(s2));
        System.out.println("s1 equals s3: " + s1.equals(s3));
        System.out.println("s1 == s2: " + (s1 == s2));
        System.out.println("Name: " + s1.name());
    }
}