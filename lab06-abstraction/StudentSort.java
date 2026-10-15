import java.util.Arrays;
import java.util.Comparator;

class Student implements Comparable<Student> {
    private final String name;
    private final int marks;

    Student(String name, int marks) { this.name = name; this.marks = marks; }

    int getMarks() { return marks; }

    @Override
    public int compareTo(Student other) {
        return this.name.compareTo(other.name);
    }

    @Override
    public String toString() { return name + "(" + marks + ")"; }
}

public class StudentSort {
    public static void main(String[] args) {
        Student[] list = {
            new Student("Tendai", 65), new Student("Anesu", 80), new Student("Chipo", 72)
        };

        Arrays.sort(list);
        System.out.println("By name:  " + Arrays.toString(list));

        Arrays.sort(list, Comparator.comparingInt(Student::getMarks));
        System.out.println("By marks: " + Arrays.toString(list));
    }
}