public class Circle {
    
    private static int count = 0;
    
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
        count++;
    }

    public Circle() {
        this(1.0);

    }
public static int getCount() {
    return count;
}


    public void display() {
        System.out.println("Radius: " + radius);
    }

    public static void main(String[] args) {
        Circle c1 = new Circle(5.0);
        Circle c2 = new Circle();
        c1.display();
        c2.display();
        System.out.println("Circles created: " + Circle.getCount());
    }
}