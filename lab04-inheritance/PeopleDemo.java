public class PeopleDemo {
    public static void main(String[] args) {
        Person p = new Person("Tendai", 40);
        Student s = new Student("Chipo", 20, "Computer Science");
        Teacher t = new Teacher("Mr Moyo", 45, "Mathematics");

        p.display();
        s.display();
        System.out.println("Course: " + s.getCourse());
        t.display();
        System.out.println("Subject: " + t.getSubject());
    }
}