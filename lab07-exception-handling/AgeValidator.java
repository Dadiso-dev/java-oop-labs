public class AgeValidator {

    static void validateAge(int age) throws InvalidAgeException {
        if (age < 0 || age > 120) {
            throw new InvalidAgeException("Age " + age + " is outside 0 to 120");
        }
    }

    public static void main(String[] args) {
        int[] ages = {25, -3, 150};
        for (int a : ages) {
            try {
                validateAge(a);
                System.out.println("Age " + a + " is valid");
            } catch (InvalidAgeException e) {
                System.out.println("Rejected: " + e.getMessage());
            }
        }
    }
}