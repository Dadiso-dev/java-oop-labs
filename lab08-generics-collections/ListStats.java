import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListStats {
    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>(List.of(4, 8, 15, 16, 23, 42, 7, 3, 12, 9));

        int sum = 0;
        int max = nums.get(0);
        for (int n : nums) {
            sum += n;
            if (n > max) max = n;
        }
        System.out.println("Sum: " + sum);
        System.out.println("Max: " + max);

        List<Integer> reversed = new ArrayList<>(nums);
        Collections.reverse(reversed);
        System.out.println("Reversed: " + reversed);
    }
}