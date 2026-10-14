public class AliasTest {
    public static void main(String[] args) {
        Rectangle r1 = new Rectangle();
        r1.width = 5;
        r1.height = 3;

        Rectangle r2 = r1;
        r2.width = 10;

        System.out.println("r1.width = " + r1.width);
        System.out.println("r2.width = " + r2.width);
    }
}