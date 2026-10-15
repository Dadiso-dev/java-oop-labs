import java.util.Scanner;

public class DivideInput {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        try {
            System.out.print("Enter first integer: ");
            int a = Integer.parseInt(in.nextLine().trim());
            System.out.print("Enter second integer: ");
            int b = Integer.parseInt(in.nextLine().trim());
            System.out.println(a + " / " + b + " = " + (a / b));
        } catch (NumberFormatException e) {
            System.out.println("Please enter whole numbers only.");
        } catch (ArithmeticException e) {
            System.out.println("Cannot divide by zero.");
        } finally {
            in.close();
        }
    }
}