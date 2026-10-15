import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class RemoveDuplicates {
    public static void main(String[] args) {
        List<String> names = List.of("Tino", "Ada", "Tino", "Moyo", "Ada", "Zodwa");
        Set<String> unique = new LinkedHashSet<>(names);

        System.out.println("Original: " + names);
        System.out.println("Unique: " + unique);
    }
}