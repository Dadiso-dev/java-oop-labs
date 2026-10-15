import java.util.Arrays;

public class PrintDemo {
    static void print(int x)      { System.out.println("int: " + x); }
    static void print(double x)   { System.out.println("double: " + x); }
    static void print(String s)   { System.out.println("String: " + s); }
    static void print(int[] arr)  { System.out.println("int[]: " + Arrays.toString(arr)); }

    public static void main(String[] args) {
        print(5);
        print(2.5);
        print("Hello");
        print(new int[]{1, 2, 3});
    }
}