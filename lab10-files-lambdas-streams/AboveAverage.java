import java.util.List;
import java.util.stream.Collectors;

record Student(String name, int marks) {}

public class AboveAverage {
    public static void main(String[] args) {
        List<Student> students = List.of(
            new Student("Tariro", 72),
            new Student("Farai", 55),
            new Student("Rudo", 88),
            new Student("Kuda", 61),
            new Student("Ada", 79));

        double avg = students.stream().mapToInt(Student::marks).average().orElse(0);
        System.out.println("Class average: " + avg);

        List<String> above = students.stream()
            .filter(s -> s.marks() > avg)
            .map(Student::name)
            .sorted()
            .collect(Collectors.toList());
        System.out.println("Above average: " + above);
    }
}