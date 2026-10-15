import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class RemoveEvens {
    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        System.out.println("Original: " + nums);

        Predicate<Integer> isEven = n -> n % 2 == 0;
        nums.removeIf(isEven);

        System.out.println("After removeIf: " + nums);
    }
}